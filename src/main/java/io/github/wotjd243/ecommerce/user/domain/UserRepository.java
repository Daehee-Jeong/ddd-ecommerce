package io.github.wotjd243.ecommerce.user.domain;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserId(String userId);

    User save(User user);
}
