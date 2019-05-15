package io.github.wotjd243.ecommerce.user.ui;

import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.application.dto.UserRequestDto;
import io.github.wotjd243.ecommerce.user.application.dto.UserResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users")
    public List<UserResponseDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "users/{userId}")
    public UserResponseDto findByUserId(@PathVariable String userId) {
        return userService.findByUserId(userId);
    }

    @PutMapping(value = "users")
    public UserResponseDto register(UserRequestDto userRequestDto) {
        return userService.register(userRequestDto);
    }
}
