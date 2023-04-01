package com.beside.pickup.jwt.controller;

import com.beside.pickup.jwt.domain.RefreshToken;
import com.beside.pickup.jwt.service.JwtTokenService;
import com.beside.pickup.security.jwt.JwtTokenProvider;
import com.beside.pickup.security.jwt.TokenInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class JwtTokenController {

    private final JwtTokenService jwtTokenService;

    @Operation(summary = "토큰 재발급", description = "refreshToken을 인자값으로 주면 유효한지 검사 후 token을 재발급", tags = { "토큰" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/refresh-token")
    public ResponseEntity<TokenInfo> refreshToken(@RequestBody RefreshToken refreshToken) {
        TokenInfo tokenInfo = jwtTokenService.reissueTokenWithRefreshToken(refreshToken.getRefreshToken());

        return new ResponseEntity(tokenInfo, HttpStatus.OK);
    }

}
