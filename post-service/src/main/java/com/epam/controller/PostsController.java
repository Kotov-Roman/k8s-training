package com.epam.controller;

import com.epam.domain.Post;
import com.epam.service.api.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<Post> create(@Valid @RequestBody Post post) {
        Post created = postsService.create(post);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable @NotNull Long id,
                                       @Valid @RequestBody Post post) {
        post.setId(id);
        Post created = postsService.update(post);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(postsService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @NotNull Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
