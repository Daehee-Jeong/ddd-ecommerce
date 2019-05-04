package io.github.wotjd243.ecommerce.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDto {
    private String userId;
    private String address;
}
