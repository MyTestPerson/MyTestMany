package com.testmany.shop.service;

import com.testmany.shop.enam.PrivilegeEnum;
import com.testmany.shop.enam.RoleEnum;
import com.testmany.shop.entity.AuthoritiesEntity;
import com.testmany.shop.entity.PrivilegesEntity;
import com.testmany.shop.entity.UserEntity;

public interface ServiceJpa {


    UserEntity findUserEntityByEmail (String email);

    void saveAuthoritiesEntity(AuthoritiesEntity authoritiesEntity);


    void savePrivilegesEntity(PrivilegesEntity privilegesEntity);



    AuthoritiesEntity findAuthoritiesEntityByRoleEnum (RoleEnum roleEnum);
//    List<AuthoritiesEntity> findAuthoritiesEntityByRoleEnum (List<RoleEnum> roleEnum);


    PrivilegesEntity findPrivilegesEntityByPrivilegeEnum (PrivilegeEnum privilegeEnum);




}
