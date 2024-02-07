package com.company.storage.service;

import com.company.storage.entity.planin.Planin;
import com.company.storage.entity.planin.PlaninStatus;
import com.haulmont.cuba.core.entity.ScheduledTask;
import com.haulmont.cuba.core.entity.ScheduledTaskDefinedBy;
import com.haulmont.cuba.core.entity.SchedulingType;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service(PlaninScheduledService.NAME)
public class PlaninScheduledServiceBean implements PlaninScheduledService {

    @Inject
    private DataManager dataManager;
    @Inject
    private PlaninService planinService;

    @Override
    public void createScheduledTaskByPlanin() {
        ScheduledTask scheduledTask = dataManager.create(ScheduledTask.class);
        scheduledTask.setActive(Boolean.TRUE);
        scheduledTask.setDefinedBy(ScheduledTaskDefinedBy.BEAN);
        scheduledTask.setBeanName(PlaninScheduledService.NAME);
        scheduledTask.setMethodName(getMethodName());
        scheduledTask.setMethodParamsXml(getMethodParamsXml());
        scheduledTask.setCron("0 0 10-18 * * *");
        scheduledTask.setSchedulingType(SchedulingType.CRON);
        dataManager.commit(scheduledTask);
    }

    @Transactional
    @Override
    public void updatePlaningsBySchedule() {
        String EXIT_GATE = "Exit";
        List<Planin> planningsByFilter = planinService.getPlanningsByFilter();
        CommitContext commitContext = new CommitContext();
        for (Planin curPlanin : planningsByFilter) {
            curPlanin.setPlaninStatus(PlaninStatus.LEFT);
            curPlanin.setPlaninState(null);
            curPlanin.setLeaveDate(LocalDateTime.now());
            curPlanin.setGate(EXIT_GATE);
            commitContext.addInstanceToCommit(curPlanin);
        }
        dataManager.commit(commitContext);
    }
}