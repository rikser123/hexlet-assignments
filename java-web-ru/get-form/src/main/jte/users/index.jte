@import exercise.dto.users.UsersPage
@param UsersPage page


<div>
    <form method="get" action="/users">
        <input type="search" name="term" value="${page.getTerm()}"/>
        <button type="submit">Отправить</button>
    </form>
    @if (!page.getUsers().isEmpty())
    <div>
        @for (var user: page.getUsers())
        <div>
            ${user.getFirstName()}
            ${user.getLastName()}
            ${user.getEmail()}
        </div>
        @endfor
    </div>
    @endif
</div>