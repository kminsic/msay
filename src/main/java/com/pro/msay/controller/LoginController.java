package com.pro.msay.controller;

import com.pro.msay.dto.ResponseDto;
import com.pro.msay.dto.requestdto.MemberRequestDto;
import com.pro.msay.service.FormMemberService;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final FormMemberService formMemberService;

    //회원가입
    @PostMapping( "/api/member/signup")
    public ResponseDto<?> signup(@RequestBody @Valid MemberRequestDto requestDto) {
        return formMemberService.createMember(requestDto);
    }

    // 로그인
    @PostMapping ("/api/member/login")
    public ResponseDto<?> login(@RequestBody  MemberRequestDto requestDto, HttpServletResponse response)
            throws IOException {
        return formMemberService.login( requestDto , response);
    }
}
