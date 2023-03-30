package com.beside.pickup.member.domain.dto;

import com.beside.pickup.member.domain.Member;
import com.beside.pickup.member.domain.Sex;
import lombok.Data;

@Data
public class MemberAddDto {
    private String loginId;
    private String name;
    private String password;
    private String sex;
    private String nickname;
    private String contact;
    private Long age;

    public Member toMember() {
        return Member.builder()
                .loginId(this.loginId)
                .password(this.password)
                .name(this.name)
                .sex(this.sex)
                .nickname(this.nickname)
                .contact(this.contact)
                .age(this.age)
                .build();
    }
}
