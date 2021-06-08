package com.testmany.shop.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Сущность пользователя
 */
@Entity(name = "UserEntity")
@Table(name = "users", schema = "testmany")
public class UserEntity implements Serializable {

    private Long id;
    private String email;
    private String password;

    private Collection<AuthoritiesEntity> authoritiesEntities = new ArrayList<>();


    public UserEntity() {
    }

    // Это ID пользователя
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // Это email пользователя
    @NaturalId
    @Column(name = "email", nullable = false, unique = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Это пароль пользователя
    @Column(name = "password", nullable = false, length = 65)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }








    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Collection<AuthoritiesEntity> getAuthoritiesEntities() {
        return authoritiesEntities;
    }

    public void setAuthoritiesEntities(Collection<AuthoritiesEntity> authoritiesEntities) {
        this.authoritiesEntities = authoritiesEntities;
    }






//    public void addNotActivatedUsersEntity(NotActivatedUsersEntity notActivatedUsersEntity) {
//        notActivatedUsersEntity.setUserEntity( this );
//        this.notActivatedUsersEntity = notActivatedUsersEntity;
//    }
//
//


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;

        UserEntity that = (UserEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        if (!getPassword().equals(that.getPassword())) return false;
        return getAuthoritiesEntities().equals(that.getAuthoritiesEntities());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getAuthoritiesEntities().hashCode();
        return result;
    }
}
