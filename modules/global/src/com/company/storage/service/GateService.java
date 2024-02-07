package com.company.storage.service;

import java.util.UUID;

public interface GateService {
    String NAME = "storage_GateService";

    boolean isExistNumber(String number);

    public Boolean existGateByNumber(String number, UUID userId);
}