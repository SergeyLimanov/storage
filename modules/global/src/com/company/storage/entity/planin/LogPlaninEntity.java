package com.company.storage.entity.planin;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "STORAGE_LOG_PLANIN_ENTITY")
@Entity(name = "storage_LogPlaninEntity")
public class LogPlaninEntity extends StandardEntity {
    private static final long serialVersionUID = -4618554816563769916L;

    @Column(name = "REG_NUMBER")
    private String regNumber;

    @Column(name = "LOG_STATUS")
    private Integer logStatus;

    @Column(name = "LOG_STATE")
    private Integer logState;

    @Column(name = "TS_NUMBER")
    private String tsNumber;

    public PlaninState getLogState() {
        return logState == null ? null : PlaninState.fromId(logState);
    }

    public void setLogState(PlaninState logState) {
        this.logState = logState == null ? null : logState.getId();
    }

    public PlaninStatus getLogStatus() {
        return logStatus == null ? null : PlaninStatus.fromId(logStatus);
    }

    public void setLogStatus(PlaninStatus logStatus) {
        this.logStatus = logStatus == null ? null : logStatus.getId();
    }

    public String getTsNumber() {
        return tsNumber;
    }

    public void setTsNumber(String tsNumber) {
        this.tsNumber = tsNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}