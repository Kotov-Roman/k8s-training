package com.epam.controller;

import com.epam.domain.User;
import com.epam.service.api.UserService;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User created = userService.create(user);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable @NotNull Long id,
                                       @RequestBody User user) {
        user.setId(id);
        User created = userService.update(user);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @NotNull Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
