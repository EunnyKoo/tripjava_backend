package com.trip.tripjava.controller;

import com.trip.tripjava.dto.UserDTO;
import com.trip.tripjava.entity.UserEntity;
import com.trip.tripjava.security.TokenProvider;
import com.trip.tripjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TokenProvider tokenProvider;

    // 회원가입
    @PostMapping("")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            UserEntity user = UserEntity.builder()
                    .id(userDTO.getId())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .email(userDTO.getEmail())
                    .nickname(userDTO.getNickname())
                    .build();

            UserEntity responseUser = userService.signup(user);

            return ResponseEntity.ok().body("회원가입 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        try {
            UserEntity user = userService.login(userDTO.getId(), userDTO.getPassword());

            if(user == null) {
                throw new RuntimeException("login failed");
            }

            String token = tokenProvider.create(user);

            UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .id(user.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
