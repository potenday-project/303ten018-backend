package com.beside.pickup.member.controller;

import com.beside.pickup.member.domain.dto.MemberAddDto;
import com.beside.pickup.member.domain.dto.MemberLoginDto;
import com.beside.pickup.member.service.MemberService;
import com.beside.pickup.security.jwt.TokenInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class MemberController {

    private final MemberService memberService;


    @Operation(summary = "회원 가입", description = "회원 가입", tags = { "회원" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("")
    public ResponseEntity addUser(@RequestBody MemberAddDto memberAddDto) {
        memberService.addMember(memberAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "로그인", description = "로그인", tags = { "회원" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/login")
    public ResponseEntity<TokenInfo> login(@RequestBody MemberLoginDto memberLoginDto) {
        TokenInfo tokenInfo = memberService.login(memberLoginDto);
        return new ResponseEntity(tokenInfo, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "테스트 성공";
    }

}
