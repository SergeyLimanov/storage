package com.company.storage.service;

import com.company.storage.entity.client.Client;
import com.company.storage.entity.gate.Gate;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(ClientService.NAME)
public class ClientServiceBean implements ClientService {

    @Inject
    private DataManager dataManager;

    @Override
    public Boolean existClientCode(Integer clientCode, UUID gateId) {
        if (gateId != null) {
            return dataManager.load(Client.class)
                    .query("select e from storage_Client e where e.clientCode = :clientCode and e.id <> :id")
                    .parameter("clientCode", clientCode)
                    .parameter("id", gateId)
                    .optional().isPresent();
        } else {
            return dataManager.load(Gate.class)
                    .query("select e from storage_Client e where e.clientCode = :clientCode")
                    .parameter("clientCode", clientCode)
                    .optional().isPresent();
        }
    }
}