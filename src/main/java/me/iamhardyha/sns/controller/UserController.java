package me.iamhardyha.sns.controller;

import lombok.RequiredArgsConstructor;
import me.iamhardyha.sns.controller.request.UserJoinRequest;
import me.iamhardyha.sns.controller.request.UserLoginRequest;
import me.iamhardyha.sns.controller.response.Response;
import me.iamhardyha.sns.controller.response.UserJoinResponse;
import me.iamhardyha.sns.controller.response.UserLoginResponse;
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
        User user = userService.join(request.getName(), request.getPassword());;
        return Response.success(UserJoinResponse.fromUser(user));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request.getName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }
}
