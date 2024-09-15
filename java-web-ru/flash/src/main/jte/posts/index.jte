@import exercise.dto.posts.PostsPage;
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    @for (var post : page.getPosts())
        <div>
            <div>${post.getName()}</div>
            <div>${post.getBody()}</div>
        </div>
        @endfor
`,
)