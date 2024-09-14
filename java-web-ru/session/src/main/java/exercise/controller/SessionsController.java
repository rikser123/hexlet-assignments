package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("build.jte", model("page", page));
    }

    public static void createSession(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> UsersRepository.existsByName(value), "Wrong username or password").get();
            var currentUser = UsersRepository.findByName(name).get();
            ctx.formParamAsClass("password", String.class)
                    .check(value -> encrypt(value).equals(currentUser.getPassword()), "Wrong username or password").get();
            ctx.sessionAttribute("user", currentUser.getName());
            ctx.redirect(NamedRoutes.rootPath());

        } catch(Exception e) {
            var name = ctx.formParam("name");
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void main(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("user"));
        ctx.render("index.jte", model("page", page));
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("user", null);
        ctx.redirect(NamedRoutes.loginPath());
    }
    // END
}
