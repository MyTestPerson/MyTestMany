package com.testmany.shop.controller;

import com.testmany.shop.enam.PrivilegeEnum;
import com.testmany.shop.enam.RoleEnum;
import com.testmany.shop.entity.AuthoritiesEntity;
import com.testmany.shop.entity.PrivilegesEntity;
import com.testmany.shop.entity.UserEntity;
import com.testmany.shop.service.ServiceJpa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {


    private final
    ServiceJpa serviceJpa;

    public RegistrationController(ServiceJpa serviceJpa) {
        this.serviceJpa = serviceJpa;
    }


    @GetMapping(value = "/registration")
    public String registrationGet () {
            return "/registration";

    }



    @PostMapping(value = "/registration")
    public ModelAndView registrationPost (@ModelAttribute("user") UserEntity userEntity) {

            // Наполняем пользователя
            userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));




//            List<RoleEnum> roleList = new ArrayList<>();
//            roleList.add(RoleEnum.ROLE_USER);
//            roleList.add(RoleEnum.ROLE_SELLER);
//
//            // Привязываем пользователя к роли
//            List<AuthoritiesEntity> authoritiesEntityList = serviceJpa.findAuthoritiesEntityByRoleEnum(roleList);
//            authoritiesEntityList.listIterator().forEachRemaining(authoritiesEntity -> authoritiesEntity.addPerson(userEntity));
//
//            // Сохраняем роль/роли с привязанным к ней пользователя.
//            // Тут механизм следующий. Сохраняем один элемент, в данном случаи
//            // мы берём из индекса 0, а все остальные роли привязываются паровозом.
//            serviceJpa.saveAuthoritiesEntity(authoritiesEntityList.get(0));






        PrivilegesEntity privilegesEntity = serviceJpa.findPrivilegesEntityByPrivilegeEnum(PrivilegeEnum.PRIVILEGE_EDIT);
        AuthoritiesEntity authoritiesEntity = serviceJpa.findAuthoritiesEntityByRoleEnum(RoleEnum.ROLE_USER);

        privilegesEntity.addAuthority(authoritiesEntity);
        authoritiesEntity.addUser(userEntity);

        serviceJpa.savePrivilegesEntity(privilegesEntity);


//            AuthoritiesEntity authoritiesEntity = serviceJpa.findAuthoritiesEntityByRoleEnum(RoleEnum.ROLE_USER);
//            authoritiesEntity.addUser(userEntity);
//            serviceJpa.saveAuthoritiesEntity(authoritiesEntity);





//            // Привязываем пользователя к роли
//            AuthoritiesEntity authoritiesEntity = serviceJpa.findAuthoritiesEntityByRoleEnum(RoleEnum.ROLE_USER);
//            authoritiesEntity.addPerson(userEntity);
//
//            AuthoritiesEntity authoritiesEntity1 = serviceJpa.findAuthoritiesEntityByRoleEnum(RoleEnum.ROLE_SELLER);
//            authoritiesEntity1.addPerson(userEntity);
//
//            // Сохраняем роль с привязанное к ней пользователя.
//            serviceJpa.saveAuthoritiesEntity(authoritiesEntity);





            return new ModelAndView("redirect:/login");

    }


}
