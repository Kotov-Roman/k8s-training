package com.epam.repos;

import com.epam.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Long countByAuthorId(Long authorId);
}