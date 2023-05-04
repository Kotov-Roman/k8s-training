package com.epam.service.impl;

import com.epam.domain.User;
import com.epam.exceptions.ResourceNotFoundException;
import com.epam.repos.UserRepository;
import com.epam.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User userFromDb = this.findById(user.getId());
        if (user.getAmountOfPosts() != null) {
            userFromDb.setAmountOfPosts(user.getAmountOfPosts());
        }
        if (user.getUsername() != null) {
            userFromDb.setUsername(user.getUsername());
        }
        userFromDb.setAmountOfPosts(user.getAmountOfPosts());
        return userRepository.save(userFromDb);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found, id=" + id));
    }

    @Override
    public Long deleteById(Long id) {
        User user = this.findById(id);
        userRepository.deleteById(user.getId());
        return id;
    }
}
