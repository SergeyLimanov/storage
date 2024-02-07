package com.company.storage.service;

import com.company.storage.entity.planin.LogPlaninEntity;
import com.company.storage.entity.planin.Planin;
import com.company.storage.entity.planin.PlaninDto;

import java.util.List;

public interface PlaninService {
    String NAME = "storage_PlaninService";

    void createNewPlanin(PlaninDto planinDto);

    List<Planin> getPlanningsByFilter();

    LogPlaninEntity createLogPlaninEntity(Planin planin);

    List<String> getPlaninNumbers();
}