package me.iamhardyha.sns.model.entity;

import jakarta.persistence.*;
import lombok.*;
import me.iamhardyha.sns.model.UserRole;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE users SET deleted_at = NOW() WHERE id=?")
@SQLRestriction("deleted_at is NULL")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "registered_at")
    private Timestamp registeredAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void prePersist() {
        this.registeredAt = Timestamp.from(Instant.now());
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static UserEntity of(String userName, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(password);
        return userEntity;
    }
}
