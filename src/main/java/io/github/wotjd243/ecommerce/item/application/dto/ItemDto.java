package io.github.wotjd243.ecommerce.item.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {
    private String title;
    private double price;
    private String url;
}
