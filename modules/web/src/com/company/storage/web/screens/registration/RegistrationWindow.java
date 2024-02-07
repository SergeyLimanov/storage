package com.company.storage.web.screens.registration;

import com.company.storage.entity.planin.LoadCapacity;
import com.company.storage.entity.planin.Planin;
import com.company.storage.entity.planin.PlaninDto;
import com.company.storage.entity.planin.PlaninStatus;
import com.company.storage.service.PlaninService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.MaskedField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@UiController("storage_RegistrationWindow")
@UiDescriptor("registration-window.xml")
public class RegistrationWindow extends Screen {

    @Inject
    private MaskedField<String> tsNumberField;
    @Inject
    private TextField<String> fullNameField;
    @Inject
    private MaskedField<String> phoneNumberField;
    @Inject
    private LookupField<LoadCapacity> loadCapacityLookupField;
    @Inject
    private PlaninService planinService;

    public void confirmRegistration() {
        PlaninDto planinDto= new PlaninDto();
        planinDto.setFio(fullNameField.getValue()!= null ? fullNameField.getValue() : "");
        planinDto.setPhoneNumber(phoneNumberField.getValue() != null ? phoneNumberField.getValue() : "");
        planinDto.setLoadCapacityId(loadCapacityLookupField.getValue() != null && loadCapacityLookupField.getValue().getId() != null? loadCapacityLookupField.getValue().getId() : null);
        planinDto.setTsNumber(tsNumberField.getValue() != null ? tsNumberField.getValue() : "");
        planinService.createNewPlanin(planinDto);
        closeWithDefaultAction();
    }
}