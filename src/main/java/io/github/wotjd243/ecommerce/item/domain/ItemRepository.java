package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.domain.search.Page;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.item.domain.search.Sort;

import java.util.List;

public interface ItemRepository {
    Item findById(Long itemId);

    List<Item> findByUserId(String userId);

    List<Item> findAll();

    List<Item> findAll(Page page, Sort sort);

    List<Item> findByQueryKeyword(QueryKeyword queryKeyword, Page page, Sort sort);

    Item save(Item item);
}
