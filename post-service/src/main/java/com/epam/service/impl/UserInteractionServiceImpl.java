package com.epam.service.impl;

import com.epam.service.api.UserInteractionService;
import com.epam.web.UpdateUserPostsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

@Service
@Slf4j
public class UserInteractionServiceImpl implements UserInteractionService {

    @Value("${user.service.location}")
    private String updatePostsUrl;

    @Override
    public void updatePosts(Long userId, Long amount) {
        RestTemplate restTemplate = new RestTemplate();
        UpdateUserPostsRequest request = UpdateUserPostsRequest.builder()
                .userId(userId)
                .amountOfPosts(amount)
                .build();

        log.info("sending request to update posts: " + request);
        HttpEntity<UpdateUserPostsRequest> requestHttpEntity = new HttpEntity<>(request);
        try {
            restTemplate.exchange(updatePostsUrl + "/" + userId, HttpMethod.PUT, requestHttpEntity, Object.class);
        } catch (HttpStatusCodeException | UnknownHttpStatusCodeException exception) {
            log.error("Failed to update posts: ", exception);
        }
    }
}
