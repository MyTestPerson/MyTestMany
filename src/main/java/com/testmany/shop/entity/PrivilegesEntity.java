package com.testmany.shop.entity;

import com.testmany.shop.enam.PrivilegeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "PrivilegesEntity")
@Table(name = "privileges", schema = "testmany")
public class PrivilegesEntity implements Serializable {

    private Long id;
    private String privilege;
    private Collection<AuthoritiesEntity> authoritiesEntityList = new ArrayList<>();
    private PrivilegeEnum privilegeEnum;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public PrivilegesEntity() {
    }

    @Column(name = "privilege", nullable = false, unique = true, length = 45, insertable = false, updatable = false)
    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }








    @ManyToMany(mappedBy = "privilegesEntities", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    public Collection<AuthoritiesEntity> getAuthoritiesEntityList() {
        return authoritiesEntityList;
    }

    public void setAuthoritiesEntityList(Collection<AuthoritiesEntity> authoritiesEntityList) {
        this.authoritiesEntityList = authoritiesEntityList;
    }







    @Enumerated(EnumType.STRING)
    @Column(name = "privilege")
    public PrivilegeEnum getPrivilegeEnum() {
        return privilegeEnum;
    }

    public void setPrivilegeEnum(PrivilegeEnum privilegeEnum) {
        this.privilegeEnum = privilegeEnum;
    }




    // Добавления пользователя к роли
    public void addAuthority(AuthoritiesEntity authoritiesEntity) {
        authoritiesEntityList.add( authoritiesEntity );
        authoritiesEntity.getPrivilegesEntities().add( this );
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrivilegesEntity)) return false;

        PrivilegesEntity that = (PrivilegesEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (!getPrivilege().equals(that.getPrivilege())) return false;
        if (!getAuthoritiesEntityList().equals(that.getAuthoritiesEntityList())) return false;
        return getPrivilegeEnum() == that.getPrivilegeEnum();
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getPrivilege().hashCode();
        result = 31 * result + getAuthoritiesEntityList().hashCode();
        result = 31 * result + getPrivilegeEnum().hashCode();
        return result;
    }
}
