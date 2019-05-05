package io.github.wotjd243.ecommerce.user.application;

import io.github.wotjd243.ecommerce.user.application.dto.ShippingAddressDto;
import io.github.wotjd243.ecommerce.user.domain.ShippingAddress;
import io.github.wotjd243.ecommerce.user.infra.ShippingAddressRepository;

public class UserService {

    private ShippingAddressRepository shippingAddressRepository;

    public UserService(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
    }

    public void addShippingAddress(ShippingAddressDto shippingAddressDto) {
        ShippingAddress shippingAddress = new ShippingAddress(shippingAddressDto.getAddress(), shippingAddressDto.getZipcode());
        shippingAddressRepository.save(shippingAddress);
    }

    private boolean isShippingAddressExist(String userId, ShippingAddress shippingAddress) {
        return shippingAddressRepository.findAllByUserId(userId).contains(shippingAddress);
    }
}
