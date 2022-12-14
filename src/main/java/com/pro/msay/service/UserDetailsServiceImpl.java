package com.pro.msay.service;

import com.pro.msay.domain.Member;
import com.pro.msay.domain.UserDetailsImpl;
import com.pro.msay.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
    @RequiredArgsConstructor
    public class UserDetailsServiceImpl implements UserDetailsService {
        private final MemberRepository memberRepository;
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Member> member = memberRepository.findByMemberId(username);
            return member
                    .map(UserDetailsImpl::new)
                    .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        }
        @Transactional(readOnly = true)
        public Member findByIdMember(Long id) {
            return memberRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 사용자입니다."));
        }
    }