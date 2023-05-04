package com.epam.service.impl;

import com.epam.domain.Post;
import com.epam.exceptions.ResourceNotFoundException;
import com.epam.repos.PostRepository;
import com.epam.service.api.PostsService;
import com.epam.service.api.UserInteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {
    private final PostRepository postRepository;
    private final UserInteractionService userInteractionService;

    @Override
    public Post create(Post post) {
        post.setPostedAt(LocalDateTime.now());
        Post created = postRepository.save(post);

        long amountOfPosts = postRepository.countByAuthorId(created.getAuthorId());
        userInteractionService.updatePosts(created.getAuthorId(), amountOfPosts);

        return created;
    }

    @Override
    public Post update(Post post) {
        Post postFromDb = this.findById(post.getId());
        postFromDb.setText(post.getText());
        return postRepository.save(postFromDb);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post is not found, id=" + id));
    }

    @Override
    public Long deleteById(Long id) {
        Post post = this.findById(id);
        postRepository.deleteById(post.getId());
        return id;
    }
}
