package com.pro.msay.controller;

import com.pro.msay.domain.UserDetailsImpl;
import com.pro.msay.dto.requestdto.ProfileRequestDto;
import com.pro.msay.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MypageController {

    private final MypageService mypageService;

    //이름 수정
    @PostMapping( "/api/member/name/")
    public ResponseEntity<String> updateName(@RequestBody ProfileRequestDto profileRequestDto,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        mypageService.nameUpdate(profileRequestDto, userDetails.getMember());
        return ResponseEntity.ok("닉네임 변경 성공");
    }
    //프로필 이미지 수정
    @PostMapping( "/api/member/profile/")
    public ResponseEntity<String> updateImage(@RequestPart(value = "image" ,required = false) @Valid List<MultipartFile> image,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) throws UnsupportedEncodingException {
        mypageService.updateImage(image, userDetails.getMember());
        return ResponseEntity.ok("프로필 이미지 변경 성공");
    }
}
