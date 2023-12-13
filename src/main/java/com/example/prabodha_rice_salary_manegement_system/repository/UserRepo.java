package com.example.prabodha_rice_salary_manegement_system.repository;

import com.example.prabodha_rice_salary_manegement_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
