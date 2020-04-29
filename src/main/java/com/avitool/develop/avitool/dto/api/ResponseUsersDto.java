package com.avitool.develop.avitool.dto.api;

import com.avitool.develop.avitool.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseUsersDto {
    private List<UserDto> data;
}
