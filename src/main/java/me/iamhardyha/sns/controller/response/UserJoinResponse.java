package me.iamhardyha.sns.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.iamhardyha.sns.model.User;
import me.iamhardyha.sns.model.UserRole;

@Getter
@AllArgsConstructor
public class UserJoinResponse {

    private Integer id;
    private String userName;
    private UserRole userRole;

    public static UserJoinResponse fromUser(User user) {
        return new UserJoinResponse(
                user.getId(),
                user.getUsername(),
                user.getUserRole()
        );
    }

}
