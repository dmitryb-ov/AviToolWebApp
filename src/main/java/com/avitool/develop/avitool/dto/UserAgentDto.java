package com.avitool.develop.avitool.dto;

import com.avitool.develop.avitool.models.UserAgent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserAgentDto {
    private Long id;
    private String userAgentString;

    public static UserAgentDto from(UserAgent userAgent) {
        return UserAgentDto.builder()
                .id(userAgent.getId())
                .userAgentString(userAgent.getUserAgentString())
                .build();
    }
}
