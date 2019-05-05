package io.github.wotjd243.ecommerce.user.application;

import io.github.wotjd243.ecommerce.user.application.dto.ShippingAddressDto;
import io.github.wotjd243.ecommerce.user.domain.ShippingAddress;
import io.github.wotjd243.ecommerce.user.infra.ShippingAddressRepository;

public class UserService {

    private ShippingAddressService shippingAddressService;

    public UserService(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    public ShippingAddress addShippingAddress(ShippingAddressDto shippingAddressDto) {
        return shippingAddressService.addShippingAddress(shippingAddressDto);
    }
}
