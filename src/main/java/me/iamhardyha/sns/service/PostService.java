package me.iamhardyha.sns.service;

import lombok.RequiredArgsConstructor;
import me.iamhardyha.sns.exception.ErrorCode;
import me.iamhardyha.sns.exception.SnsApplicationException;
import me.iamhardyha.sns.model.entity.PostEntity;
import me.iamhardyha.sns.model.entity.UserEntity;
import me.iamhardyha.sns.repository.PostEntityRepository;
import me.iamhardyha.sns.repository.UserEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;

    @Transactional
    public void create(String title, String Body, String userName) {
        // user find
        UserEntity userEntity = userEntityRepository.findByUserName(userName)
                .orElseThrow(() -> new SnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));
        // post save
        postEntityRepository.save(new PostEntity());
        //return
    }
}
