@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@if (page.getName() == null)
    <div><a href="${NamedRoutes.buildSessionPath()}">Войти</a></div>
@else
<div>${String.valueOf(page.getName())}</div>
    <form method="post" action="${NamedRoutes.logoutPath()}">
        <button name="submit">Выйти</button>
    </form>
@endif
