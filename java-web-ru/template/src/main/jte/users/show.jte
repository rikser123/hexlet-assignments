@import exercise.dto.users.UserPage
@param UserPage page

<main>
    <div>Name: ${page.getUser().getFirstName()}</div>
    <div>LastName: ${page.getUser().getLastName()}</div>
    <div>Email: ${page.getUser().getEmail()}</div>
</main>
