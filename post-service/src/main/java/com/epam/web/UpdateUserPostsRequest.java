package com.epam.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserPostsRequest {
    private Long userId;
    private Long amountOfPosts;
}
