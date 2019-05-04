package io.github.wotjd243.ecommerce.item.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ItemResponseDto {
    private String title;
    private double price;
    private String galleryUrl;
    private String state;
}
