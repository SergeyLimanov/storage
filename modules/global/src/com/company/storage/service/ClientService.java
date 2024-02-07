package com.company.storage.service;

import java.util.UUID;

public interface ClientService {
    String NAME = "storage_ClientService";

    Boolean existClientCode(Integer clientCode, UUID gateId);
}