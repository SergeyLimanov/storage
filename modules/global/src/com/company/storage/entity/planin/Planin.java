package com.company.storage.entity.planin;

import com.company.storage.entity.client.Client;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@PublishEntityChangedEvents
@Table(name = "STORAGE_PLANIN")
@Entity(name = "storage_Planin")
public class Planin extends StandardEntity {
    private static final long serialVersionUID = 941728051937650376L;

    @Column(name = "REG_NUMBER", length = 10)
    private String regNumber;

    @JoinTable(name = "STORAGE_PLANIN_CLIENT_LINK",
            joinColumns = @JoinColumn(name = "PLANIN_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLIENT_ID"))
    @ManyToMany
    private List<Client> clients;

    @Column(name = "GATE", length = 5)
    private String gate;

    @Column(name = "REG_DATE")
    private LocalDateTime regDate;

    @Column(name = "DATE_INSTALLATION_GATE")
    private LocalDateTime dateInstallationGate;

    @Column(name = "DATE_LEAVE_ALLOWED")
    private LocalDateTime dateLeaveAllowed;

    @Column(name = "LEAVE_DATE")
    private LocalDateTime leaveDate;

    @Column(name = "ORDER_NUMBER", length = 50)
    private String orderNumber;

    @Column(name = "PLANNING_DATE")
    private LocalDateTime planningDate;

    @Column(name = "TS_NUMBER", length = 20)
    private String tsNumber;

    @Column(name = "LOAD_CAPACITY")
    private Integer loadCapacity;

    @Column(name = "FIO", length = 100)
    private String fio;

    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @Column(name = "PLANIN_STATUS")
    private Integer planinStatus;

    @Column(name = "PLANIN_STATE")
    private Integer planinState;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public LocalDateTime getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDateTime leaveDate) {
        this.leaveDate = leaveDate;
    }

    public LocalDateTime getDateLeaveAllowed() {
        return dateLeaveAllowed;
    }

    public void setDateLeaveAllowed(LocalDateTime dateLeaveAllowed) {
        this.dateLeaveAllowed = dateLeaveAllowed;
    }

    public LocalDateTime getDateInstallationGate() {
        return dateInstallationGate;
    }

    public void setDateInstallationGate(LocalDateTime dateInstallationGate) {
        this.dateInstallationGate = dateInstallationGate;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public PlaninState getPlaninState() {
        return planinState == null ? null : PlaninState.fromId(planinState);
    }

    public void setPlaninState(PlaninState planinState) {
        this.planinState = planinState == null ? null : planinState.getId();
    }

    public PlaninStatus getPlaninStatus() {
        return planinStatus == null ? null : PlaninStatus.fromId(planinStatus);
    }

    public void setPlaninStatus(PlaninStatus planinStatus) {
        this.planinStatus = planinStatus == null ? null : planinStatus.getId();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity == null ? null : LoadCapacity.fromId(loadCapacity);
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity == null ? null : loadCapacity.getId();
    }

    public String getTsNumber() {
        return tsNumber;
    }

    public void setTsNumber(String tsNumber) {
        this.tsNumber = tsNumber;
    }

    public LocalDateTime getPlanningDate() {
        return planningDate;
    }

    public void setPlanningDate(LocalDateTime planningDate) {
        this.planningDate = planningDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}