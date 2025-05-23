package org.amazon.ecommerce.auth.controller;

import org.amazon.ecommerce.auth.entity.User;
import org.amazon.ecommerce.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/auth/login")
    public Mono<ResponseEntity<String>> login(@RequestBody User user) {
        return userService.authenticate(user)
            .map(jwt -> ResponseEntity.ok(jwt))
            .switchIfEmpty(Mono.just(ResponseEntity.status(401).build()));
    }
}