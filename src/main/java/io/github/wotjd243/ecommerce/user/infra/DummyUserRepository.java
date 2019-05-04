package io.github.wotjd243.ecommerce.user.infra;

import io.github.wotjd243.ecommerce.user.domain.User;
import io.github.wotjd243.ecommerce.user.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DummyUserRepository implements UserRepository {
    private static List<User> users = new ArrayList<>();

    @Override
    public Optional<User> findByUserId(String userId) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }
}