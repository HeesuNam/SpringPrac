package com.example.springprac2.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoUserInfoDto {
    private String id;
    private String nickname;
    private String email;
}