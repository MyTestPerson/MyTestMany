package com.testmany.shop.repository;

import com.testmany.shop.enam.RoleEnum;
import com.testmany.shop.entity.AuthoritiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA интерфейс
// Данный интерфейс предназначен для работы с таблицей Authorities
public interface AuthoritiesEntityJpa extends JpaRepository<AuthoritiesEntity, Long> {








    // Получаем роль по enum роли
    AuthoritiesEntity findAuthoritiesEntityByRoleEnum (RoleEnum roleEnum);
//    List<AuthoritiesEntity> findAuthoritiesEntitiesByRoleEnumIn(List<RoleEnum> roleEnum);












}
