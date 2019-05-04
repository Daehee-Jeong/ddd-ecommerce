package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.ItemRepository;
import io.github.wotjd243.ecommerce.item.domain.search.Page;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.item.domain.search.Sort;

import java.util.List;

public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findItems(QueryKeyword queryKeyword, Page page, Sort sort) {
        return itemRepository.findByQueryKeyword(queryKeyword, page, sort);
    }

    public List<Item> findAll(Page page, Sort sort) {
        return itemRepository.findAll(page, sort);
    }
}
