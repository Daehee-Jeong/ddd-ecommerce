package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.domain.search.*;
import io.github.wotjd243.ecommerce.item.domain.Item;

import java.util.Collections;
import java.util.List;

public class SearchService {
    private final ItemService itemService;

    public SearchService(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<Item> searchItems(String keyword, int pageNumber, int pageSize,
                                SortParameter sortParameter, SortOrder sortOrder) {
        QueryKeyword queryKeyword = new QueryKeyword(keyword);
        Page page = new Page(pageNumber, pageSize);
        Sort sort = new Sort(sortParameter, sortOrder);

        List<Item> items = itemService.findItems(queryKeyword, page, sort);
        return Collections.unmodifiableList(items);
    }

    public List<Item> searchItems(int pageNumber, int pageSize, SortParameter sortParameter, SortOrder sortOrder) {
        Page page = new Page(pageNumber, pageSize);
        Sort sort = new Sort(sortParameter, sortOrder);

        List<Item> items = itemService.findAll(page, sort);
        return Collections.unmodifiableList(items);
    }
}
