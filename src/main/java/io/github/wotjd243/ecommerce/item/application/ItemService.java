package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.ItemRepository;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;

import java.util.List;
import java.util.stream.Collectors;

public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponseDto> findAll() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public List<ItemResponseDto> findItems(String keyword) {
        List<Item> items = itemRepository.findByQueryKeyword(new QueryKeyword(keyword));
        return items.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public ItemResponseDto register(ItemRequestDto dto) {
        return itemRepository.save(new Item(dto.getTitle(), dto.getPrice(), dto.getUrl())).toDto();
    }
}
