package com.beside.pickup.jwt.domain;

import com.beside.pickup.member.domain.Member;
import jakarta.persistence.*;
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
    @OneToOne(mappedBy = "refreshToken")
    private Member member;

    @Builder
    public RefreshToken(String refreshToken, String expireTime) {
        this.refreshToken = refreshToken;
        this.expireTime = expireTime;
    }

    public void setMember(Member member) {
        this.member = member;
        if (member.getRefreshToken() != this) {
            member.setRefreshToken(this);
        }
    }
}
