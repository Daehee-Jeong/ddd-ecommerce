package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.domain.search.*;

import java.util.List;

public interface ItemRepository {
    List<Item> findAll();

    List<Item> findAll(Page page, Sort sort);

    List<Item> findByQueryKeyword(QueryKeyword queryKeyword, Page page, Sort sort);
}
