package com.trip.tripjava.service;

import com.trip.tripjava.entity.UserEntity;
import com.trip.tripjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // 회원가입
    public UserEntity signup(UserEntity userEntity) {
        if (userEntity == null) { // 입력받은 값이 null 일 경우
            throw new RuntimeException("entity null");
        }

        return userRepository.save(userEntity);
    }
}
