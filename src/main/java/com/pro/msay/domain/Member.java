package com.pro.msay.domain;

import com.pro.msay.dto.requestdto.ProfileRequestDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String memberId;

    @Column(nullable = false,unique = true)
    private String password;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column
    private String profileImage;


    public boolean validatePassword(PasswordEncoder passwordEncoder, String password) {
        return passwordEncoder.matches(password, this.password);
    }


    public void update(ProfileRequestDto profileRequestDto) {
        this.name = profileRequestDto.getName();
    }
    public void imageUpdate(String image) {
        this.profileImage = image;
      }


}
