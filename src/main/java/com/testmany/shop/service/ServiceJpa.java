package com.testmany.shop.service;

import com.testmany.shop.enam.PrivilegeEnum;
import com.testmany.shop.enam.RoleEnum;
import com.testmany.shop.entity.AuthoritiesEntity;
import com.testmany.shop.entity.PrivilegesEntity;
import com.testmany.shop.entity.UserEntity;

// Сервис. Интерфейс для работы с БД
public interface ServiceJpa {


    // Получаем сущность UserEntity по email
    UserEntity findUserEntityByEmail (String email);

    // Сохраняем сущность AuthoritiesEntity
    void saveAuthoritiesEntity(AuthoritiesEntity authoritiesEntity);


    // Сохраняем сущность PrivilegesEntity
    void savePrivilegesEntity(PrivilegesEntity privilegesEntity);



    // Получаем роль по enum роли
    AuthoritiesEntity findAuthoritiesEntityByRoleEnum (RoleEnum roleEnum);
//    List<AuthoritiesEntity> findAuthoritiesEntityByRoleEnum (List<RoleEnum> roleEnum);


    // Получаем привилегию по enum привилегии
    PrivilegesEntity findPrivilegesEntityByPrivilegeEnum (PrivilegeEnum privilegeEnum);




}
