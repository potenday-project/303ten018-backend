package com.beside.pickup.jwt.controller;

import com.beside.pickup.security.jwt.JwtTokenProvider;
import com.beside.pickup.security.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtTokenController {

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestParam("refresh_token") String refreshToken) {

        if (!(refreshToken != null && jwtTokenProvider.validateToken(refreshToken))) {
            return ResponseEntity.badRequest().body("Invalid Refresh Token");
        }

        return nul;
    }

}
