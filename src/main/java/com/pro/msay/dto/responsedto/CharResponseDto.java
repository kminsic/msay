package com.pro.msay.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharResponseDto {
        private Long id;
        private String chatMessage;
        private String createAt;
        private int memberCount;
}
