package me.iamhardyha.sns.controller;

import lombok.RequiredArgsConstructor;
import me.iamhardyha.sns.controller.request.PostCreateRequest;
import me.iamhardyha.sns.controller.response.Response;
import me.iamhardyha.sns.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Response<Void> create(@RequestBody PostCreateRequest request) {


        return Response.success(null);
    }
}
