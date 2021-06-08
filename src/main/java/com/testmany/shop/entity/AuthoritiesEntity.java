package com.testmany.shop.entity;

import com.testmany.shop.enam.RoleEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity(name = "AuthoritiesEntity")
@Table(name = "authorities", schema = "testmany")
public class AuthoritiesEntity implements Serializable{

    private Long id;
    private String authority;
    private Collection<UserEntity> userEntityList = new ArrayList<>();
    private Collection<PrivilegesEntity> privilegesEntities = new ArrayList<>();
    private RoleEnum roleEnum;

    public AuthoritiesEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





    // Это роль
    @Column(name = "authority", nullable = false, unique = true, length = 45, insertable = false, updatable = false)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }














    @ManyToMany(mappedBy = "authoritiesEntities", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    public Collection<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(Collection<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Collection<PrivilegesEntity> getPrivilegesEntities() {
        return privilegesEntities;
    }

    public void setPrivilegesEntities(Collection<PrivilegesEntity> privilegesEntities) {
        this.privilegesEntities = privilegesEntities;
    }











    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }



    public void addUser(UserEntity userEntity) {
        userEntityList.add( userEntity );
        userEntity.getAuthoritiesEntities().add( this );
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthoritiesEntity)) return false;

        AuthoritiesEntity that = (AuthoritiesEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (!getAuthority().equals(that.getAuthority())) return false;
        if (!getUserEntityList().equals(that.getUserEntityList())) return false;
        if (!getPrivilegesEntities().equals(that.getPrivilegesEntities())) return false;
        return getRoleEnum() == that.getRoleEnum();
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getAuthority().hashCode();
        result = 31 * result + getUserEntityList().hashCode();
        result = 31 * result + getPrivilegesEntities().hashCode();
        result = 31 * result + getRoleEnum().hashCode();
        return result;
    }
}
