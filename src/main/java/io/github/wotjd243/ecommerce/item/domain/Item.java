package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;

import java.net.MalformedURLException;
import java.net.URL;

public class Item {
    private Long id;
    private String title;
    private Dollar price;
    private URL galleryUrl;
    private SellingState sellingState;

    public Item(String title, Double price, String galleryUrl) {
        this.title = title;
        this.price = new Dollar(price);
        this.sellingState = SellingState.ACTIVE;
        setGalleryUrl(galleryUrl);
    }

    public boolean isActive() {
        return sellingState.isActive();
    }

    public boolean isSamePrice(double price) {
        return this.price.equals(price);
    }

    public boolean match(QueryKeyword keywords) {
        return keywords.match(this.title);
    }

    public double price() {
        return this.price.castToDouble();
    }

    private void setGalleryUrl(String galleryUrl) {
        try {
            this.galleryUrl = new URL(galleryUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
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
