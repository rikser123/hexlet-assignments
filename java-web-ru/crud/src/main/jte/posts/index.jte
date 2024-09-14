@import exercise.dto.posts.PostsPage
@param PostsPage page

<div>
    <div>
        <a href="/posts?page=${page.getPreviousPage()}">Back</a>
        <a href="/posts?page=${page.getNextPage()}">Forward</a>
    </div>

@for (var post : page.getPosts())
    <a href="/posts/${post.getId()}">${post.getName()}</a>
@endfor
</div>