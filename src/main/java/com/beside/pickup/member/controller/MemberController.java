package com.beside.pickup.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MemberController {

    @GetMapping("")
    public String addUser() {
        return "회원가입 성공";
    }
}
