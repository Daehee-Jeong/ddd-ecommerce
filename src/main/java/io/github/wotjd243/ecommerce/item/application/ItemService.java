package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.ItemRepository;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;

import java.util.Collections;
import java.util.List;

public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        return Collections.unmodifiableList(items);
    }

    public List<Item> findItems(String keyword) {
        List<Item> items = itemRepository.findByQueryKeyword(new QueryKeyword(keyword));
        return Collections.unmodifiableList(items);
    }

    public ItemResponseDto register(ItemRequestDto dto) {
        return itemRepository.save(new Item(dto.getTitle(), dto.getPrice(), dto.getUrl())).toDto();
    }
}
