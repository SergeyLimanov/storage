package com.company.storage.listeners;

import com.company.storage.entity.planin.LogPlaninEntity;
import com.company.storage.entity.planin.Planin;
import com.company.storage.service.PlaninService;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

@Component("storage_PlaninChangedListener")
public class PlaninChangedListener {

    @Inject
    private TransactionalDataManager transactionalDataManager;
    @Inject
    private PlaninService planinService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<Planin, UUID> event) {

        if (event.getType() == EntityChangedEvent.Type.UPDATED &&
                ((event.getChanges().isChanged("planinStatus") || event.getChanges().isChanged("planinState")))) {
            try (Transaction transaction = transactionalDataManager.transactions().create()) {
                Optional<Planin> opt = transactionalDataManager.load(event.getEntityId()).view("planin-view").optional();
                if (!opt.isPresent()) {
                    return;
                }
                Planin planin = opt.get();
                LogPlaninEntity logPlaninEntity = planinService.createLogPlaninEntity(planin);
                transactionalDataManager.save(logPlaninEntity);
                transaction.commit();
            }
        }
    }
}