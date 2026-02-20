package me.iamhardyha.sns.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.iamhardyha.sns.model.User;
import me.iamhardyha.sns.model.UserRole;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String userName;
    private UserRole userRole;

    public static UserResponse fromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getUserRole()
        );
    }
}
