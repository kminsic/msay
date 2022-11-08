package com.pro.msay.domain;

import javax.persistence.*;

@Table
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(nullable = false)
    private String chatMessage;

    @Column(nullable = false)
    private String createAt;

    @Column(nullable = false)
    private String roomName;

    @Column(nullable = false)
    private String memberCount;




}
