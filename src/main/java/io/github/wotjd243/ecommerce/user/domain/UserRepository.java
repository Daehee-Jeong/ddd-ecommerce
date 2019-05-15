package io.github.wotjd243.ecommerce.user.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<User> findByUserId(String userId);

    User save(User user);

    List<User> findAll();
}
