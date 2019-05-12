package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.domain.exception.HasNotPermissionException;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;

public class Item {
    private Long id = 1L;
    private String sellerId;
    private Stock stock;
    private ItemDetail detail;
    private ItemState itemState;

    public Item(String sellerId, Stock stock, ItemDetail detail) {
        this.sellerId = sellerId;
        this.stock = stock;
        this.detail = detail;
        this.itemState = ItemState.BEFORE_SELLING;
    }

    public Item(Long id, String sellerId, Stock stock, ItemDetail detail) {
        this.id = id;
        this.sellerId = sellerId;
        this.stock = stock;
        this.detail = detail;
        this.itemState = ItemState.BEFORE_SELLING;
    }

    public Item(Long id, String sellerId, Stock stock, ItemDetail detail, ItemState itemState) {
        this.id = id;
        this.sellerId = sellerId;
        this.stock = stock;
        this.detail = detail;
        this.itemState = itemState;
    }

    public boolean isKeywordMatched(QueryKeyword keywords) {
        return this.detail.contains(keywords);
    }

    public boolean isSelling() {
        return this.itemState.isSelling();
    }

    public Item startSelling(String sellerId) {
        if (!checkOwner(sellerId)) {
            throw new HasNotPermissionException("해당 물품에 대한 권한이 없습니다.");
        }

        if (isSelling()) {
            throw new IllegalStateException("It's already selling");
        }

        this.itemState = ItemState.SELLING;
        return this;
    }

    public Item sold(int numberOfSoldItem) {
        if (!isSelling()) {
            throw new IllegalStateException("This item is not selling now");
        }

        this.stock = this.stock.decrease(numberOfSoldItem);

        if (this.stock.isOutOfStock()) {
            this.itemState = ItemState.SOLD_OUT;
        }

        return this;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return detail.getTitle();
    }

    public String getSellerId() {
        return sellerId;
    }

    public double getPrice() {
        return detail.getPrice();
    }

    public String getFalleryUrl() {
        return this.detail.getGalleryUrl();
    }

    public int getStock() {
        return stock.getValue();
    }

    public ItemState getItemState() {
        return itemState;
    }

    private boolean checkOwner(String sellerId) {
        return this.sellerId.equals(sellerId);
    }
}
