package me.iamhardyha.sns.fixture;

import me.iamhardyha.sns.model.entity.PostEntity;
import me.iamhardyha.sns.model.entity.UserEntity;

public class PostEntityFixture {

    public static PostEntity get(Integer userId, String userName, Integer postId) {
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setUserName(userName);

        PostEntity result = new PostEntity();
        result.setUser(user);
        result.setId(postId);

        return result;
    }
}