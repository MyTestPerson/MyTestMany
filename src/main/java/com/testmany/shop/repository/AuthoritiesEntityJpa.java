package com.testmany.shop.repository;

import com.testmany.shop.enam.RoleEnum;
import com.testmany.shop.entity.AuthoritiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesEntityJpa extends JpaRepository<AuthoritiesEntity, Long> {








    AuthoritiesEntity findAuthoritiesEntityByRoleEnum (RoleEnum roleEnum);
//    List<AuthoritiesEntity> findAuthoritiesEntitiesByRoleEnumIn(List<RoleEnum> roleEnum);












}
