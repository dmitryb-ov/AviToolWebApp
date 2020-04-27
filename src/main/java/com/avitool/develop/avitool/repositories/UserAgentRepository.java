package com.avitool.develop.avitool.repositories;

import com.avitool.develop.avitool.models.UserAgent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAgentRepository extends JpaRepository<UserAgent, Long> {
    Optional<UserAgent> findUserAgentById(Long id);
}
