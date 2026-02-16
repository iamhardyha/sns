package me.iamhardyha.sns.controller.response;

import lombok.AllArgsConstructor;
import me.iamhardyha.sns.model.User;
import me.iamhardyha.sns.model.UserRole;

@AllArgsConstructor
public class UserJoinResponse {

    private Integer id;
    private String userName;
    private UserRole userRole;

    public static UserJoinResponse fromUser(User user) {
        return new UserJoinResponse(
                user.getId(),
                user.getUserName(),
                user.getUserRole()
        );
    }

}
