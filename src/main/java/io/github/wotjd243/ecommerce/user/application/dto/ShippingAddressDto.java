package io.github.wotjd243.ecommerce.user.application.dto;

import io.github.wotjd243.ecommerce.user.domain.ShippingAddress;

public class ShippingAddressDto {
    private String address;
    private String zipCode;

    public ShippingAddressDto(String address, String zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }

    public static ShippingAddressDto of(ShippingAddress shippingAddress) {
        return new ShippingAddressDto(shippingAddress.getAddress(), shippingAddress.getZipCode());
    }

    public String getAddress() {
        return this.address;
    }

    public String getZipCode() {
        return this.zipCode;
    }
}
