package com.pro.msay.repository;


import com.pro.msay.domain.Member;
import com.pro.msay.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByMember(Member member);
    RefreshToken findByKeyValue(String keyValue);
    void deleteAllByMember(Member member);
}
