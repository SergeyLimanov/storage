package com.company.storage.web.screens.gate;

import com.company.storage.service.GateService;
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
    private TextField<String> gateNumberField;
    @Inject
    private Notifications notifications;

    @Subscribe("gateNumberField")
    public void onGateNumberFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        if (!gateService.isExistNumber(event.getValue())) {
            notifications.create().withCaption("Поставщик под данным номером уже зарегистрирован, укажите другой").show();
            gateNumberField.clear();
        }
    }
}