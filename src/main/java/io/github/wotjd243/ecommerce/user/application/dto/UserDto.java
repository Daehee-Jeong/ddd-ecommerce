package io.github.wotjd243.ecommerce.user.application.dto;

import io.github.wotjd243.ecommerce.user.domain.User;

public class UserDto {
    private String userId;
    private String address;

    public UserDto(String userId, String address) {
        this.userId = userId;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public static UserDto of(User user) {
        return new UserDto(user.getUserId(), user.getAddress());
    }
}
