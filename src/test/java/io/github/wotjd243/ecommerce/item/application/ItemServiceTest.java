package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.domain.search.*;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.application.dto.UserDto;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemServiceTest {
    UserService userService = new UserService(new DummyUserRepository());
    ItemService itemService = new ItemService(new DummyItemRepository(), userService);
    UserDto user = DummyUserRepository.getTestUser();

    @Test(expected = IllegalArgumentException.class)
    public void 키워드가_3글자_미만일_경우() {
        new QueryKeyword("DD");
    }

    @Test
    public void 물품_전체_검색() {
        List<ItemResponseDto> items = itemService.findAll();
        assertThat(items.size()).isNotNull();
    }

    @Test
    public void 키워드를_기준으로_검색한다() {
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        ItemResponseDto response = itemService.register(user, request);
        List<ItemResponseDto> items = itemService.findItems("DDD");

        assertThat(items).contains(response);
    }

    @Test
    public void 물품을_등록한다() {
        int preSize = itemService.findAll().size();
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        ItemResponseDto response = itemService.register(user, request);

        assertThat(itemService.findAll().size()).isEqualTo(preSize + 1);
        assertThat(request.getTitle()).isEqualTo(response.getTitle());
    }
}