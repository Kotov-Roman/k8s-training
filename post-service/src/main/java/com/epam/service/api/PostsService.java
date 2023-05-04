package com.epam.service.api;

import com.epam.domain.Post;

public interface PostsService {
    Post create(Post post);

    Post update(Post post);

    Post findById(Long id);

    Long deleteById(Long id);
}
