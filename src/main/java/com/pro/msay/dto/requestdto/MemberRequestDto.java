package com.pro.msay.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {
    private Long    id;
    private String memberId;
    private String password;
    private String passwordConfirm;
    private String name;
    private String email;
    private String profileImage;
}
