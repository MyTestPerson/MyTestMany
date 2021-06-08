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

    @Override
    public UserEntity findUserEntityByEmail(String email) {
        return userEntityJpa.findUserEntityByEmail(email);
    }



    @Override
    @Transactional
    public void saveAuthoritiesEntity(AuthoritiesEntity authoritiesEntity) {
        authoritiesEntityRepository.save(authoritiesEntity);
    }

    @Override
    @Transactional
    public void savePrivilegesEntity(PrivilegesEntity privilegesEntity) {
        privilegesEntityJpa.save(privilegesEntity);
    }


    @Override
    public AuthoritiesEntity findAuthoritiesEntityByRoleEnum (RoleEnum roleEnum) {
        return authoritiesEntityRepository.findAuthoritiesEntityByRoleEnum(roleEnum);
    }

    // Получаем привилегию по enum привилегии
    @Override
    public PrivilegesEntity findPrivilegesEntityByPrivilegeEnum(PrivilegeEnum privilegeEnum) {
        return privilegesEntityJpa.findPrivilegesEntityByPrivilegeEnum(privilegeEnum);
    }










}
