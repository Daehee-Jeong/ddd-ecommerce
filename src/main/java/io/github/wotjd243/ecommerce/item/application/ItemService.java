package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.ItemDetail;
import io.github.wotjd243.ecommerce.item.domain.ItemRepository;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.application.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    public ItemService(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public List<ItemResponseDto> searchAll() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public List<ItemResponseDto> searchItems(String keyword) {
        List<Item> items = itemRepository.findByQueryKeyword(new QueryKeyword(keyword));
        return items.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public ItemResponseDto register(UserDto userDto, ItemRequestDto itemDto) {
        userService.checkValid(userDto.getUserId());

        ItemDetail detail = new ItemDetail(itemDto.getTitle(), itemDto.getPrice(), itemDto.getUrl());
        return itemRepository.save(new Item(userDto.getUserId(), detail)).toDto();
    }

    public List<String> findItemsOwned(UserDto userDto) {
        userService.checkValid(userDto.getUserId());

        List<Item> items = itemRepository.findByUserId(userDto.getUserId());
        return items.stream().map(v -> v.getTitle()).collect(Collectors.toList());
    }
}
