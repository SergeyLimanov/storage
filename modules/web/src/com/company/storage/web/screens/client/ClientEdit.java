package com.company.storage.web.screens.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.client.Client;

@UiController("storage_Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
@LoadDataBeforeShow
public class ClientEdit extends StandardEditor<Client> {
}