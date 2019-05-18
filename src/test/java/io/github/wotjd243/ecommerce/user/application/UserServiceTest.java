package io.github.wotjd243.ecommerce.user.application;

import io.github.wotjd243.ecommerce.user.application.dto.UserDto;
import io.github.wotjd243.ecommerce.user.domain.User;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;
import org.junit.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {
    UserService userService = new UserService(new DummyUserRepository());

    @Test
    public void 유저를_등록한다() {
        UserDto request = new UserDto("TEST","TEST");
        User response = userService.register(request);

        List<User> users = userService.findAll();
        assertThat(users).contains(response);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 같은_아이디가_있을_경우() {
        UserDto request = new UserDto("TEST_USER","TEST");
        userService.register(request);
    }
}