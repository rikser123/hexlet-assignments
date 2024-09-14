@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    @if (page.getErrors() != null)
        <ul>
        @for (var validator : page.getErrors().values())
            @for (var error : validator)
                <li>${error.getMessage()}</li>
                @endfor
        @endfor
        </ul>
    @endif

   <form action="/articles" method="post">
       <label>Title
           <input type="text" name="title" value="${page.getTitle()}"/>
       </label>
       <label>Content
            <textarea name="content" value="${page.getContent()}"></textarea>
       </label>
       <button type="submit">Submit</button>
   </form>
`
)
