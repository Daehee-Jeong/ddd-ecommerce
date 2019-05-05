package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import lombok.Getter;

@Getter
public class Item {
    private Long id;
    private String userId;
    private ItemDetail detail;
    private SellingState sellingState;

    public Item(String userId, ItemDetail itemDetail) {
        this.userId = userId;
        this.detail = itemDetail;
        this.sellingState = SellingState.ACTIVE;
    }

    public boolean isActive() {
        return sellingState.isActive();
    }

    public boolean contains(QueryKeyword keywords) {
        return this.detail.contains(keywords);
    }

    public ItemResponseDto toDto() {
        return new ItemResponseDto(detail.getTitle(), detail.getPrice(), detail.getGalleryUrl(), sellingState.value);
    }

    public String getTitle() {
        return detail.getTitle();
    }

    enum SellingState {
        ACTIVE("Active"),
        CANCELED("Canceled"),
        ENDED("Ended"),
        ENDED_WITH_SALES("EndedWithSales"),
        ENDED_WITHOUT_SALES("EndedWithoutSales");

        private final String value;

        SellingState(String value) {
            this.value = value;
        }

        private boolean isActive() {
            return (this == ACTIVE);
        }
    }
}
