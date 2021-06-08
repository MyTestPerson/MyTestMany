package com.testmany.shop.repository;

import com.testmany.shop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserEntityJpa extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByEmail (String email);





}
