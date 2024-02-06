package com.company.storage.service;

import com.company.storage.entity.planin.PlaninDto;

public interface PlaninService {
    String NAME = "storage_PlaninService";

    void createNewPlanin(PlaninDto planinDto);
}