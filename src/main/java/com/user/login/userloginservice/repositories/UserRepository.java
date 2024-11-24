package com.user.login.userloginservice.repositories;

import com.user.login.userloginservice.entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String login);
}
