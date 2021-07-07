package yte.intern.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import yte.intern.springweb.controllers.dto.resttemplate.Comment;
import yte.intern.springweb.controllers.dto.resttemplate.Post;

import java.net.URI;
import java.util.Arrays;

public class RestTemplateTest {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    public void tumPostlariGetir() {
        URI postsUri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(postsUri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);

        System.out.println(Arrays.asList(response.getBody()));
    }

    @Test
    public void tekPostGetir() {
        URI postsUri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(postsUri).build();

        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);

        System.out.println(response.getBody());
    }

    @Test
    public void postEkle() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        var request = RequestEntity.post(uri)
                .body(new Post(3L, null, "test title", "test body"));

        var response = restTemplate.exchange(request, Post.class);

        System.out.println(response.getBody());
    }

    @Test
    public void userIdIlePostGetir() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId","2")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).build();

        var response = restTemplate.exchange(request, Post[].class);

        System.out.println(Arrays.asList(response.getBody()));
    }

    @Test
    public void commentGuncelle() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("comments", "5")
                .build()
                .toUri();

        var request = RequestEntity.put(uri)
                .body(new Comment(12L, 5L, "hebele", "hebele@hubele.com", "test body"));

        var response = restTemplate.exchange(request, Comment.class);

        System.out.println(response.getBody());
    }

    @Test
    public void postuSil() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts", "1")
                .build()
                .toUri();

        var request = RequestEntity.delete(uri).build();

        var reponse = restTemplate.exchange(request, Void.class);

        System.out.println(reponse.getBody());
    }
}
