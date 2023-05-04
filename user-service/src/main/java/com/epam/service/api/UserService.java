package com.epam.service.api;

import com.epam.domain.User;

public interface UserService {
    User create(User user);
    User update(User user);
    User findById(Long id);
    Long deleteById(Long id);
}
