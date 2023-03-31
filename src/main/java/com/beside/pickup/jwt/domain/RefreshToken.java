package com.beside.pickup.jwt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshToken {

    @Id
    @GeneratedValue
    private Long id;
    private String refreshToken;
    private String expireTime;
    private String loginId;

    @Builder
    public RefreshToken(String refreshToken, String expireTime, String loginId) {
        this.refreshToken = refreshToken;
        this.expireTime = expireTime;
        this.loginId = loginId;
    }
}
