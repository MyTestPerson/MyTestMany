package com.testmany.shop.repository;

import com.testmany.shop.enam.PrivilegeEnum;
import com.testmany.shop.entity.PrivilegesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegesEntityJpa extends JpaRepository<PrivilegesEntity, Long> {

    PrivilegesEntity findPrivilegesEntityByPrivilegeEnum (PrivilegeEnum privilegeEnum);


}
