package com.example.pass.service.user;

import com.example.pass.repository.user.UserEntity;
import com.example.pass.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(final String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        log.info("### userName = {}", userEntity.getUserName());
//        User user = UserModelMapper.INSTANCE.toUser(userEntity);
//        log.info("### user.getUserName = {}", user.getUserName());
//        return user;
        return UserModelMapper.INSTANCE.toUser(userEntity);

    }
}
