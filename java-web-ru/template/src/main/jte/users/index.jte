@import exercise.dto.users.UsersPage
@param UsersPage page

<main>
    @if(page.getUsers().isEmpty())
       <p>Нет пользователей</p>
    @else
        <table>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
            </tr>
       @for(var user :page.getUsers())
           <tr>
               <td>${user.getFirstName()}</td>
               <td>${user.getLastName()}</td>
               <td>${user.getEmail()}</td>
           </tr>
        @endfor
        </table>
    @endif
</main>
