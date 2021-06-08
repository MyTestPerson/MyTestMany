package com.testmany.shop.security;

import com.testmany.shop.entity.AuthoritiesEntity;
import com.testmany.shop.entity.UserEntity;
import com.testmany.shop.service.ServiceJpa;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserDetail implements UserDetailsService {


//    private String authority;

    private final
    ServiceJpa serviceJpa;

    public UserDetail(ServiceJpa serviceJpa) {
        this.serviceJpa = serviceJpa;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {



        // Получаем UserEntity из БД для проверки
        UserEntity userEntity = serviceJpa.findUserEntityByEmail(email);


        if (userEntity == null){
            throw new UsernameNotFoundException("UsernameNotFoundException == " + email);
        }

        Collection<AuthoritiesEntity> userRoles = userEntity.getAuthoritiesEntities();

        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                true,
                true,
                true,
                true,
                getAuthoritiesEntities(userRoles));
    }


    private Collection<GrantedAuthority> getAuthoritiesEntities(Collection<AuthoritiesEntity> userRoles) {

        Collection<GrantedAuthority> roles = new ArrayList<>();
        userRoles.forEach(role -> roles.add(new SimpleGrantedAuthority(role.getAuthority())));

        return roles;
    }


//    private Collection<? extends GrantedAuthority> getAuthorities(Collection<AuthoritiesEntity> roles) {
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        for (AuthoritiesEntity authoritiesEntity: roles) {
//            authorities.add(new SimpleGrantedAuthority(authoritiesEntity.getRoleEnum().toString()));
//        }
//
//        return authorities;
//    }







//    private Collection<? extends GrantedAuthority> getAuthorities(Collection<AuthoritiesEntity> authoritiesEntities){
//
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        for (AuthoritiesEntity authoritiesEntity: authoritiesEntities) {
//            authorities.add(new SimpleGrantedAuthority(authoritiesEntity.getAuthority()));
//            authoritiesEntity.getUserEntities().stream()
//                    .map(userEntity -> new SimpleGrantedAuthority(userEntity.getName()))
//                    .forEach(authorities::add);
//        }
//
//
//        return authorities;
//    }



//    private Collection<? extends GrantedAuthority> getAuthorities(){
//
//        List<SimpleGrantedAuthority> authList = new ArrayList<>();
//        authList.add(new SimpleGrantedAuthority(authority));
//
//        return authList;
//
//    }

}
