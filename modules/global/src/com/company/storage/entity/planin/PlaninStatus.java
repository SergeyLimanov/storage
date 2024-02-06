package com.company.storage.entity.planin;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PlaninStatus implements EnumClass<Integer> {

    PLANNING(10),
    REGISTERED(20),
    AT_GATE(30),
    EXIT_ALLOWED(50),
    LEFT(90);

    private Integer id;

    PlaninStatus(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static PlaninStatus fromId(Integer id) {
        for (PlaninStatus at : PlaninStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}