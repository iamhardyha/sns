package me.iamhardyha.sns.controller;

import lombok.RequiredArgsConstructor;
import me.iamhardyha.sns.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // TODO: implement
    @PostMapping("/join")
    public void join() {
        userService.join("userName", "password");
    }

    @PostMapping("/login")
    public void login() {
        userService.login("userName", "password");
    }
}
