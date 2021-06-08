package com.testmany.shop.service;

import com.testmany.shop.enam.PrivilegeEnum;
import com.testmany.shop.enam.RoleEnum;
import com.testmany.shop.entity.AuthoritiesEntity;
import com.testmany.shop.entity.PrivilegesEntity;
import com.testmany.shop.entity.UserEntity;
import com.testmany.shop.repository.AuthoritiesEntityJpa;
import com.testmany.shop.repository.PrivilegesEntityJpa;
import com.testmany.shop.repository.UserEntityJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ServiceJpaImpl implements ServiceJpa {

    @Autowired
    PrivilegesEntityJpa privilegesEntityJpa;

    private final
    AuthoritiesEntityJpa authoritiesEntityRepository;

    private final
    UserEntityJpa userEntityJpa;

    public ServiceJpaImpl(AuthoritiesEntityJpa authoritiesEntityRepository, UserEntityJpa userEntityJpa) {
        this.authoritiesEntityRepository = authoritiesEntityRepository;
        this.userEntityJpa = userEntityJpa;
    }

    // Получаем сущность UserEntity по email
    @Override
    public UserEntity findUserEntityByEmail(String email) {
        return userEntityJpa.findUserEntityByEmail(email);
    }



    // Сохраняем сущность AuthoritiesEntity
    @Override
    @Transactional
    public void saveAuthoritiesEntity(AuthoritiesEntity authoritiesEntity) {
        authoritiesEntityRepository.save(authoritiesEntity);
    }

    // Сохраняем сущность PrivilegesEntity
    @Override
    @Transactional
    public void savePrivilegesEntity(PrivilegesEntity privilegesEntity) {
        privilegesEntityJpa.save(privilegesEntity);
    }


    // Получаем роль по enum роли
    @Override
    public AuthoritiesEntity findAuthoritiesEntityByRoleEnum (RoleEnum roleEnum) {
        return authoritiesEntityRepository.findAuthoritiesEntityByRoleEnum(roleEnum);
    }
//    @Override
//    public List<AuthoritiesEntity> findAuthoritiesEntityByRoleEnum (List<RoleEnum> roleEnum) {
//        return authoritiesEntityRepository.findAuthoritiesEntitiesByRoleEnumIn(roleEnum);
//    }

    // Получаем привилегию по enum привилегии
    @Override
    public PrivilegesEntity findPrivilegesEntityByPrivilegeEnum(PrivilegeEnum privilegeEnum) {
        return privilegesEntityJpa.findPrivilegesEntityByPrivilegeEnum(privilegeEnum);
    }










}
