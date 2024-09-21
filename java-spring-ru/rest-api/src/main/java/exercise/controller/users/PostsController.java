package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN

@RestController
@RequestMapping("/api/users")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("{id}/posts")
    public List<Post> getPosts(@PathVariable() String id) {
        var posts = this.posts.stream().filter(post -> String.valueOf(post.getUserId()).equals(id)).toList();
        return posts;
    }

    @PostMapping("{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@PathVariable() String id, @RequestBody Post post) {
        post.setUserId(Integer.parseInt(id));
        posts.add(post);

        return post;
    }
}
// END
