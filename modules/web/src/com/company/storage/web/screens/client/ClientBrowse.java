package com.company.storage.web.screens.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.client.Client;

@UiController("storage_Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
@LoadDataBeforeShow
public class ClientBrowse extends StandardLookup<Client> {
}