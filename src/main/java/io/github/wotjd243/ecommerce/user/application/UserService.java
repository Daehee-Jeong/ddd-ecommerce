package io.github.wotjd243.ecommerce.user.application;

import io.github.wotjd243.ecommerce.user.application.dto.UserRequestDto;
import io.github.wotjd243.ecommerce.user.application.dto.UserResponseDto;
import io.github.wotjd243.ecommerce.user.domain.User;
import io.github.wotjd243.ecommerce.user.domain.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto register(UserRequestDto dto) {
        if(isExists(dto.getUserId())) {
            throw new IllegalArgumentException("이미 등록된 계정입니다.");
        }

        User user  = new User(dto.getUserId(), dto.getAddress());
        return userRepository.save(user).toDto();
    }

    private boolean isExists(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }
}
