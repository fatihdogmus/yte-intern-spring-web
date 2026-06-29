package yte.intern.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.util.List;

public class RestClientTest {

    RestClient restClient = RestClient
            .builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();

    @Test
    public void getPosts() {
        ResponseEntity<List<Post>> response = restClient.get()
                .uri("/posts")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {
                });

        System.out.println(response.getBody());
    }

    @Test
    public void getOnePost() {
        ResponseEntity<Post> post = restClient.get()
                .uri("/posts/1")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});

        System.out.println(post.getBody());
    }

    @Test
    public void addPost() {
        ResponseEntity<Post> post = restClient
                .post()
                .uri("/posts")
                .body(new Post(15L,null, "Hebele","Hübele"))
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});

        System.out.println(post.getBody());
    }

    @Test
    public void getUserPosts() {
        ResponseEntity<List<Post>> posts = restClient
                .get()
                .uri("/posts?userId={userId}",2)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});

        System.out.println(posts.getBody());

    }

    @Test
    public void deletePost() {
        ResponseEntity<Void> response = restClient.delete()
                .uri("/posts/1")
                .retrieve()
                .toBodilessEntity();

        System.out.println(response.getStatusCode());
    }
}
