package yte.intern.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import yte.intern.springweb.resttemplate.Comment;
import yte.intern.springweb.resttemplate.Post;

import java.net.URI;
import java.util.Arrays;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

public class RestTemplateTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    RestTemplate restTemplate = new RestTemplate();

    @Test
    void getPosts() {
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);
        System.out.println(Arrays.stream(response.getBody()).toList());
    }

    @Test
    void getSinglePost() {
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("posts", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);

        System.out.println(response.getBody());
    }

    @Test
    void addPost() {
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Post> request = RequestEntity
                .post(uri)
                .body(new Post(7L, null, "hebele", "hübele"));

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);

        System.out.println(response.getBody());
    }

    @Test
    void getPostById() {
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);
        System.out.println(Arrays.stream(response.getBody()).toList());
    }

    @Test
    void updateComment() {
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("comments", "5")
                .build()
                .toUri();

        RequestEntity<Comment> request = RequestEntity
                .put(uri)
                .body(new Comment(9L, 5L, "hebele", "hübele@hibele.com", "hello"));

        ResponseEntity<Comment> response = restTemplate.exchange(request, Comment.class);

        System.out.println(response.getBody());
    }

    @Test
    void deletePost() {
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("posts", "2")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.delete(uri).build();

        ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);

        System.out.println(response.getStatusCode());
    }
}
