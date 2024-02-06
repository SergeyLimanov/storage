package com.company.storage.entity.planin;

import javax.validation.constraints.Max;
import java.io.Serializable;

public class PlaninDto implements Serializable {
    private static final long serialVersionUID = 6863730613355320960L;


    private String tsNumber;
    private String fio;
    private String phoneNumber;
    private Integer loadCapacityId;

    public String getTsNumber() {
        return tsNumber;
    }

    public void setTsNumber(String tsNumber) {
        this.tsNumber = tsNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getLoadCapacityId() {
        return loadCapacityId;
    }

    public void setLoadCapacityId(Integer loadCapacityId) {
        this.loadCapacityId = loadCapacityId;
    }

}
