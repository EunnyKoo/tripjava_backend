package com.trip.tripjava.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private String id;
    private String password;
    private String email;
    private String nickname;
    private String token;
}
