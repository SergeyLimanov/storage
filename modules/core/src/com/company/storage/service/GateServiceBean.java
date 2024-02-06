package com.company.storage.service;

import com.company.storage.entity.gate.Gate;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

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
}