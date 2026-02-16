package me.iamhardyha.sns.controller;

import lombok.RequiredArgsConstructor;
import me.iamhardyha.sns.controller.request.UserJoinRequest;
import me.iamhardyha.sns.controller.response.Response;
import me.iamhardyha.sns.controller.response.UserJoinResponse;
import me.iamhardyha.sns.model.User;
import me.iamhardyha.sns.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        User user = userService.join(request.getUserName(), request.getPassword());;
        return Response.success(UserJoinResponse.fromUser(user));
    }

    // TODO: implement
    @PostMapping("/login")
    public void login() {
        userService.login("userName", "password");
    }
}
