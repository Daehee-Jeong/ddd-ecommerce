package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.application.dto.PagingDto;
import io.github.wotjd243.ecommerce.item.domain.*;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.user.application.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    public ItemService(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public List<ItemResponseDto> searchAll() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(this::itemToReponseDto)
                .collect(Collectors.toList());
    }

    public List<ItemResponseDto> searchAll(PagingDto paging) {
        List<Item> items = itemRepository.findAll(paging.getPage(), paging.getSort());
        return items.stream()
                .map(this::itemToReponseDto)
                .collect(Collectors.toList());
    }

    public List<ItemResponseDto> searchItems(String keyword, PagingDto paging) {
        List<Item> items = itemRepository.findByQueryKeyword(new QueryKeyword(keyword), paging.getPage(), paging.getSort());
        return items.stream()
                .map(this::itemToReponseDto)
                .collect(Collectors.toList());
    }

    public ItemResponseDto register(Seller seller, ItemRequestDto itemDto, int stock) {
        userService.checkValid(seller.getUserId());

        ItemDetail detail = new ItemDetail(itemDto.getTitle(), itemDto.getPrice(), itemDto.getUrl());
        Item item = itemRepository
                .save(new Item(seller.getUserId(), new Stock(stock), detail));
        return itemToReponseDto(item);
    }

    public List<ItemResponseDto> findItemsOwned(Seller seller) {
        userService.checkValid(seller.getUserId());

        List<Item> items = itemRepository.findByUserId(seller.getUserId());
        return items.stream()
                .map(this::itemToReponseDto)
                .collect(Collectors.toList());
    }

    public ItemResponseDto findItem(long itemId) {
        Item item = itemRepository.findById(itemId);
        return itemToReponseDto(item);
    }

    public ItemResponseDto startSelling(Seller seller, Long itemId) {
        userService.checkValid(seller.getUserId());

        Item item = itemRepository.findById(itemId);
        item.startSelling();

        return itemToReponseDto(item);
    }

    public ItemResponseDto sold(Long itemId, int numberOfSoldItems) {
        Item item = itemRepository.findById(itemId);
        item.sold(numberOfSoldItems);

        return itemToReponseDto(item);
    }

    private ItemResponseDto itemToReponseDto(Item item) {
        return new ItemResponseDto(item.getTitle(), item.getPrice(), item.getFalleryUrl(), item.getStock(), item.getItemState().name());
    }
}
