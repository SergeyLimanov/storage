package com.company.storage.service;

import com.company.storage.entity.gate.Gate;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service(GateService.NAME)
public class GateServiceBean implements GateService {

    @Inject
    private DataManager dataManager;

    @Override
    public boolean isExistNumber(String number) {
        List<Gate> clientCode = dataManager.load(Gate.class)
                .query("e.gateNumber = :gateNumber")
                .parameter("gateNumber", number)
                .list();
        return clientCode.isEmpty();
    }

    @Override
    public Boolean existGateByNumber(String number, UUID gateId) {
        if(gateId != null) {
            return dataManager.load(Gate.class)
                    .query("select e from storage_Gate e where e.gateNumber = :number and e.id <> :id")
                    .parameter("number", number)
                    .parameter("id", gateId)
                    .optional().isPresent();
        }else {
            return dataManager.load(Gate.class)
                    .query("select e from storage_Gate e where e.gateNumber = :number")
                    .parameter("number", number)
                    .optional().isPresent();
        }
    }
}