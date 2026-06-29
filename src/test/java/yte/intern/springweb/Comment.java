package yte.intern.springweb;

public record Comment(Long postId,
                      Long id,
                      String name,
                      String email,
                      String body) {
}
