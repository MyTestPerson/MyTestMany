package com.testmany.shop.repository;

import com.testmany.shop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// JPA интерфейс
// Данный интерфейс предназначен для работы с таблицей users
@Transactional(readOnly = true)
public interface UserEntityJpa extends JpaRepository<UserEntity, Long> {

    // Получаем сущность UserEntity по email
    UserEntity findUserEntityByEmail (String email);





}
