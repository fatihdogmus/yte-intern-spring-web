package yte.intern.springweb.controllers.dto.resttemplate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Long userId;
    private Long id;
    private String title;
    private String body;
}
