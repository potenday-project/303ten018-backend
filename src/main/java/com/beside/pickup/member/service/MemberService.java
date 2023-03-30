package com.beside.pickup.member.service;

import com.beside.pickup.member.domain.Member;
import com.beside.pickup.member.domain.dto.MemberAddDto;
import com.beside.pickup.member.domain.dto.MemberLoginDto;
import com.beside.pickup.member.repository.MemberRepository;
import com.beside.pickup.security.jwt.JwtTokenProvider;
import com.beside.pickup.security.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
 
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public Member addMember(MemberAddDto memberAddDto) {
        Member member = Member.builder()
                .loginId(memberAddDto.getLoginId())
                .password(memberAddDto.getPassword())
                .name(memberAddDto.getName())
                .sex(memberAddDto.getSex())
                .nickname(memberAddDto.getNickname())
                .contact(memberAddDto.getContact())
                .age(memberAddDto.getAge())
                .build();
        Member saveMember = memberRepository.save(member);
        return saveMember;
    }

    @Transactional
    public TokenInfo login(MemberLoginDto memberLoginDto) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberLoginDto.getLoginId(), memberLoginDto.getPassword());
 
        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
 
        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
 
        return tokenInfo;
    }
}