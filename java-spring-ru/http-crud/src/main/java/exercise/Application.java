package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1") int page) {
        var start = limit * (page - 1);
        var end = start + limit;
        var pageItems = posts.subList(start, end);
        return pageItems;
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable String id) {
        var currentPost = posts.stream().filter(post -> post.getId().equals(id)).findFirst();

        return currentPost;
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post newPost) {
        var maybePost = posts.stream().filter(post -> post.getId().equals(id)).findFirst();

        if (maybePost.isPresent()) {
           var currentPost = maybePost.get();
           currentPost.setBody(newPost.getBody());
           currentPost.setTitle(newPost.getTitle());
        }

        return newPost;
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable String id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
    // END
}
