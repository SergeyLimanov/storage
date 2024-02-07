package com.company.storage.service;

import com.company.storage.config.StorageConfig;
import com.company.storage.entity.planin.*;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service(PlaninService.NAME)
public class PlaninServiceBean implements PlaninService {

    @Inject
    private DataManager dataManager;
    @Inject
    private StorageConfig scheduledConfig;
    @Inject
    private Metadata metadata;

    @Override
    @Transactional
    public void createNewPlanin(PlaninDto planinDto) {
        Planin planin = dataManager.create(Planin.class);
        planin.setRegNumber(UUID.randomUUID().toString().substring(0, 10));
        planin.setTsNumber(planinDto.getTsNumber());
        planin.setLoadCapacity(LoadCapacity.fromId(planinDto.getLoadCapacityId()));
        planin.setPlaninStatus(PlaninStatus.REGISTERED);
        planin.setPlaninState(PlaninState.WAIT_GATE);
        planin.setRegDate(LocalDateTime.now());
        dataManager.commit(planin);
    }

    @Override
    public List<Planin> getPlanningsByFilter() {
        LocalDateTime timeToLeave = LocalDateTime.now().minusMinutes(scheduledConfig.getMinutesLeftTime());
        return dataManager.load(Planin.class).query("where e.planinStatus = :status and e.dateLeaveAllowed > :timeToLeave")
                .view("planin-view")
                .parameter("status", PlaninStatus.EXIT_ALLOWED)
                .parameter("timeToLeave", timeToLeave)
                .list();
    }

    @Override
    public LogPlaninEntity createLogPlaninEntity(Planin planin) {
        LogPlaninEntity logPlaninEntity = metadata.create(LogPlaninEntity.class);
        logPlaninEntity.setLogState(planin.getPlaninState());
        logPlaninEntity.setLogStatus(planin.getPlaninStatus());
        logPlaninEntity.setRegNumber(planin.getRegNumber());
        logPlaninEntity.setTsNumber(planin.getTsNumber());
        return logPlaninEntity;
    }

    @Override
    public List<String> getPlaninNumbers() {
        return dataManager.load(Planin.class)
                .view("planin-view")
                .list()
                .stream()
                .map(Planin::getGate).
                filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}