package com.alex.rest.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tenants")
public class Tenant extends EntityObject<Long> {

    @Column(name = "firstName", nullable = false)
    private String firstName;

    public Tenant() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
