package com.company.storage.service;

import com.company.storage.entity.planin.*;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.UUID;

@Service(PlaninService.NAME)
public class PlaninServiceBean implements PlaninService {

    @Inject
    private DataManager dataManager;

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

}