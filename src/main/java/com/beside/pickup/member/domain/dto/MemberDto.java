package com.beside.pickup.member.domain.dto;

import com.beside.pickup.member.domain.Member;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class MemberDto {
    private String loginId;
    private String name;
    private String sex;
    private String nickname;
    private String contact;
    private Long age;
    private List<String> roles = new ArrayList<>();

    public static MemberDto MemberToMemberDto(Member member) {
        return MemberDto.builder()
                .loginId(member.getLoginId())
                .name(member.getName())
                .sex(member.getSex())
                .nickname(member.getNickname())
                .contact(member.getContact())
                .age(member.getAge())
                .roles(member.getRoles())
                .build();
    }
}
