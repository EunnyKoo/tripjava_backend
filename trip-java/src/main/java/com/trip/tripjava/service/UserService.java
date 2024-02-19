package com.trip.tripjava.service;

import com.trip.tripjava.entity.UserEntity;
import com.trip.tripjava.repository.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    // 회원가입
    public UserEntity signup(UserEntity userEntity) {
        if (userEntity == null) { // 입력받은 값이 null 일 경우
            throw new RuntimeException("entity null");
        }

        return userRepository.save(userEntity);
    }

    // 로그인
    public UserEntity login(String id, String password) {
        UserEntity user = userRepository.findById(id).get();

        if(user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    // 아이디 중복체크
    public boolean checkId(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()) return true;
        return false;
    }

    // 닉네임 중복체크
    public boolean checkNickname(String nickname) {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByNickname(nickname));
        if(user.isPresent()) return true;
        return false;
    }

    // 사용자 정보 조회 (마이페이지)
    public UserEntity getUserInfo(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()) return user.get();
        return null;
    }

    // 회원정보 수정
    public UserEntity editUserInfo(UserEntity userEntity) {
        if (userEntity == null) { // 입력받은 값이 null 일 경우
            throw new RuntimeException("entity is wrong");
        }
        return userRepository.save(userEntity);
    }
}
