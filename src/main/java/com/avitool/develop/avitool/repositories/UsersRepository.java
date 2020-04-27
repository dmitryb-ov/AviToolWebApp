package com.avitool.develop.avitool.repositories;

import com.avitool.develop.avitool.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);

    Optional<User> findUserById(Long id);
}
