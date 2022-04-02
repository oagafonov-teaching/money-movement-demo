package com.example.demo;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MoneyMovementRepositoryTest {

  @Autowired
  private MoneyMovementRepository moneyMovementRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserCategoryRepository userCategoryRepository;

  @Test
  void save() {

    var user = new User("test", "test test");
    user = userRepository.save(user);

    var category = new UserCategory(null, "test category", user, true);
    category = userCategoryRepository.save(category);

    var movement = new MoneyMovement(null, category, LocalDateTime.now(), 100.0);
    moneyMovementRepository.save(movement);

  }
}