package com.company.storage.service;

import com.company.storage.entity.client.Client;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(ClientService.NAME)
public class ClientServiceBean implements ClientService {

    @Inject
    private DataManager dataManager;

    @Override
    public boolean isExistCode(Integer code) {
        List<Client> clientCode = dataManager.load(Client.class)
                .query("e.clientCode = :clientCode")
                .parameter("clientCode", code)
                .list();
        return clientCode.isEmpty();
    }
}