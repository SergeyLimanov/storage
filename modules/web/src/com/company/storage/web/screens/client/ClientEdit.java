package com.company.storage.web.screens.client;

import com.company.storage.service.ClientService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.client.Client;

import javax.inject.Inject;

@UiController("storage_Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
@LoadDataBeforeShow
public class ClientEdit extends StandardEditor<Client> {
    @Inject
    private ClientService clientService;
    @Inject
    private Notifications notifications;
    @Inject
    private TextField<Integer> clientCodeField;

    @Subscribe("clientCodeField")
    public void onClientCodeFieldValueChange(HasValue.ValueChangeEvent<Integer> event) {
        if (!clientService.isExistCode(event.getValue())) {
            notifications.create().withCaption("Поставщик под данным номером уже зарегистрирован, укажите другой").show();
            clientCodeField.clear();
        }
    }


}