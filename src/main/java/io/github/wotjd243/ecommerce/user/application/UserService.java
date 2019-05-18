package io.github.wotjd243.ecommerce.user.application;

import io.github.wotjd243.ecommerce.user.application.dto.ShippingAddressDto;
import io.github.wotjd243.ecommerce.user.application.dto.UserDto;
import io.github.wotjd243.ecommerce.user.domain.ShippingAddress;
import io.github.wotjd243.ecommerce.user.domain.ShippingAddresses;
import io.github.wotjd243.ecommerce.user.domain.User;
import io.github.wotjd243.ecommerce.user.domain.UserRepository;
import io.github.wotjd243.ecommerce.user.domain.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(UserDto userDto) {

        if (isExists(userDto.getUserId())) {
            throw new IllegalArgumentException("이미 등록된 계정입니다.");
        }

        User user = new User(userDto.getUserId(), userDto.getAddress());
        return userRepository.save(user);
    }

    private boolean isExists(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    public void checkValid(String userId) {
        if (!isExists(userId)) {
            throw new ResourceNotFoundException("현재 접속한 계정은 유효하지 않습니다.");
        }
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No user found with id: " +userId));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public ShippingAddresses findShippingAddressesByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No shipping addresses found with id: " + userId))
                .getShippingAddresses();
    }

    public ShippingAddress addShippingAddress(String userId, ShippingAddressDto shippingAddressDto) {

        Optional<User> user = userRepository.findByUserId(userId);

        if(user.isPresent()) {
            throw new ResourceNotFoundException("현재 접속한 계정은 유효하지 않습니다.");
        }

        ShippingAddress shippingAddress = user.get().addShippingAddress(shippingAddressDto.getAddress(), shippingAddressDto.getZipCode());

        return shippingAddress;
    }
}
