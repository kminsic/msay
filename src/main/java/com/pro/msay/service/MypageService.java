package com.pro.msay.service;

import com.pro.msay.domain.Member;
import com.pro.msay.dto.requestdto.ProfileRequestDto;
import com.pro.msay.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service

@RequiredArgsConstructor
public class MypageService {

    private final MemberRepository memberRepository;
    private final S3Uploader s3Uploader;
    //이름 수정
    @Transactional
    public void nameUpdate(ProfileRequestDto profileRequestDto,
                           Member member) {

        Member members = memberRepository.findById(member.getId()).orElseThrow(
                () -> new IllegalStateException("닉네임 변경 오류"));
        members.update(profileRequestDto);
        memberRepository.save(members);
    }

    @Transactional
    public void updateImage(List<MultipartFile> image, Member member) throws UnsupportedEncodingException {
        Member members = memberRepository.findById(member.getId()).orElseThrow(
                () -> new IllegalStateException("프로필 사진 오류"));
        String imageUrl = members.getProfileImage();
        String profileImage = "";
        List<String> imgPaths;
        //이미지가 널값으로 들어오면 기존db에 있던 이미지 경로를 넣어준다


        //이미지 존재시 먼저 삭제후 다시 업로드.
        if (imageUrl != null) {
            String deleteUrl = imageUrl.substring(imageUrl.indexOf("/Msay/profile/image"));
            s3Uploader.deleteImage(deleteUrl);
        }
        imgPaths = s3Uploader.uploadList(image);
        for (int i = 0; i < imgPaths.size(); i++) {
            if (i == 0) {
                profileImage = imgPaths.get(i);
            }
        }

        members.imageUpdate(profileImage);
        memberRepository.save(members);
        }

    }


