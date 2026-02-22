package me.iamhardyha.sns.repository;

import me.iamhardyha.sns.model.Post;
import me.iamhardyha.sns.model.entity.LikeEntity;
import me.iamhardyha.sns.model.entity.PostEntity;
import me.iamhardyha.sns.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer> {

    Optional<LikeEntity> findByUserAndPost(UserEntity user, PostEntity post);

    @Query(value = """
       SELECT COUNT(*)
         FROM LikeEntity entity
         WHERE entity.post = :post
    """)
    Integer countByPostLike(PostEntity entity);

}
