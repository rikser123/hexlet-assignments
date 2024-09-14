@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@if (page.getError() != null && !page.getError().isEmpty())
    <div>${page.getError()}</div>
@endif
<form action="${NamedRoutes.loginPath()}" method="post">
    <input name="name" value="${page.getName()}"/>
    <input name="password" />
    <button type="submit">Submit</button>
</form>