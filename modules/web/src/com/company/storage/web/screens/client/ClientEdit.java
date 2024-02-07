package com.company.storage.web.screens.client;

import com.company.storage.entity.client.Client;
import com.company.storage.service.ClientService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.screen.*;

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

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Client client = getEditedEntity();
        if (client.getClientCode() != null && clientService.existClientCode(client.getClientCode(), client.getId())) {
            notifications.create()
                    .withCaption("Введенный Вами код уже используется. Введите другой.")
                    .withHideDelayMs(2000)
                    .show();
            event.preventCommit();
        }
    }
}