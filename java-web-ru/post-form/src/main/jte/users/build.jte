@template.layout.page(
content = @`
    <form action="/users" method="post">
        <label>firstName
             <input type="text" name="firstName">
        </label>
        <label>lastName
            <input type="text" name="lastName">
        </label>
        <label>email
            <input type="email" name="email">
        </label>
        <label>password
            <input type="text" name="password">
        </label>
        <button type="submit">Submit</button>
    </form>
`
)
