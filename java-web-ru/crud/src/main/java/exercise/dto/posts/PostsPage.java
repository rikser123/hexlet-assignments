package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private Integer page;

    public Integer getPreviousPage() {
        return page == null ? 1 : page - 1;
    }

    public Integer getNextPage() {
        return page == null ? 2 : page + 1;
    }
}
// END


