package com.gruntik.foodmatcher.repository;

import com.gruntik.foodmatcher.entity.UserTest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserTestRepository extends CrudRepository<UserTest, Long> {
    Optional<UserTest> findById(Long id);
}
