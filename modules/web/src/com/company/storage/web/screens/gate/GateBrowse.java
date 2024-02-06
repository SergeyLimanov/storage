package com.company.storage.web.screens.gate;

import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.gate.Gate;

@UiController("storage_Gate.browse")
@UiDescriptor("gate-browse.xml")
@LookupComponent("gatesTable")
@LoadDataBeforeShow
public class GateBrowse extends StandardLookup<Gate> {
}