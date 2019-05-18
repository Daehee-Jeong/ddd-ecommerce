package io.github.wotjd243.ecommerce.user.ui;

import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.application.dto.ShippingAddressDto;
import io.github.wotjd243.ecommerce.user.application.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users")
    public List<UserDto> findAll() {
        return userService.findAll().stream()
                .map(user -> UserDto.of(user))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "users/{userId}")
    public UserDto findByUserId(@PathVariable String userId) {
        return UserDto.of(userService.findByUserId(userId));
    }

    @PostMapping(value = "users")
    public UserDto register(UserDto userDto) {
        return UserDto.of(userService.register(userDto));
    }

    @GetMapping(value = "users/{userId}/shippingAddresses")
    public List<ShippingAddressDto> findShippingAddresses(@PathVariable String userId) {
        return userService.findShippingAddressesByUserId(userId)
                .getShippingAddresses().stream().
                map(shippingAddress -> ShippingAddressDto.of(shippingAddress))
                .collect(Collectors.toList());
    }
    @PostMapping(value = "users/{userId}")
    public ShippingAddressDto addShippingAddress(@PathVariable String userId, @RequestBody ShippingAddressDto shippingAddressDto) {
        return ShippingAddressDto.of(userService.addShippingAddress(userId, shippingAddressDto));

    }
}
