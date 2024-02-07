package com.company.storage.web.screens.gate;

import com.company.storage.service.GateService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.gate.Gate;

import javax.inject.Inject;

@UiController("storage_Gate.edit")
@UiDescriptor("gate-edit.xml")
@EditedEntityContainer("gateDc")
@LoadDataBeforeShow
public class GateEdit extends StandardEditor<Gate> {
    @Inject
    private GateService gateService;
    @Inject
    private Notifications notifications;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Gate gate =  getEditedEntity();
        if (gate.getGateNumber() != null && gateService.existGateByNumber(gate.getGateNumber(), gate.getId())) {
            notifications.create()
                    .withCaption("Введенный Вами номер уже используется. Введите другой.")
                    .withHideDelayMs(2000)
                    .show();
           event.preventCommit();
        }
    }
}