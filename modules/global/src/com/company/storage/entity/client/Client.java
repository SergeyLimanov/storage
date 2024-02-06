package com.company.storage.entity.client;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "STORAGE_CLIENT")
@Entity(name = "storage_Client")
@NamePattern("%s|clientCode")
public class Client extends StandardEntity {
    private static final long serialVersionUID = -4084315723629422931L;

    @Column(name = "CLIENT_CODE")
    private Integer clientCode;

    @Column(name = "DESCRIPTION_NAME", length = 200)
    private String descriptionName;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name = "CONTACT_PERSON", length = 100)
    private String contactPerson;

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public Integer getClientCode() {
        return clientCode;
    }

    public void setClientCode(Integer clientCode) {
        this.clientCode = clientCode;
    }
}