package com.company.storage.entity.gate;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@Table(name = "STORAGE_GATE")
@Entity(name = "storage_Gate")
public class Gate extends StandardEntity {
    private static final long serialVersionUID = -7636316918278340467L;

    @Column(name = "GATE_NUMBER", length = 5)
    private String gateNumber;

    @Column(name = "TIME_FROM")
    private LocalTime timeFrom;

    @Column(name = "TIME_TO")
    private LocalTime timeTo;

    public LocalTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalTime timeTo) {
        this.timeTo = timeTo;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }
}