package com.beside.pickup.jwt.service;

import com.beside.pickup.jwt.domain.RefreshToken;
import com.beside.pickup.jwt.repository.RefreshTokenRepository;
import com.beside.pickup.member.repository.MemberRepository;
import com.beside.pickup.security.jwt.JwtTokenProvider;
import com.beside.pickup.security.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public TokenInfo reissueTokenWithRefreshToken(String refreshToken) {
        if (refreshToken == null || !jwtTokenProvider.validateToken(refreshToken)) {
            return null;
        }

        RefreshToken refresh = refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("no such refresh token"));


        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(refresh.getMember().getLoginId(), refresh.getMember().getPassword());

        // 클레임에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(refresh.getMember().getRoles().toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        // UserDetails 객체를 만들어서 Authentication 리턴
        UserDetails principal = new User(refresh.getMember().getLoginId(), "", authorities);

        return jwtTokenProvider.generateToken(new UsernamePasswordAuthenticationToken(principal, "", authorities));
    }

}
