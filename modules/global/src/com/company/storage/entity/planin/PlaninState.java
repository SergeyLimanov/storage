package com.company.storage.entity.planin;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PlaninState implements EnumClass<Integer> {

    WAIT_GATE(5),
    AT_GATE(20),
    EXIT_ALLOWED(50);

    private Integer id;

    PlaninState(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static PlaninState fromId(Integer id) {
        for (PlaninState at : PlaninState.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}