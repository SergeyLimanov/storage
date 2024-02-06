package com.company.storage.web.screens.planin;

import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.planin.Planin;

@UiController("storage_Planin.browse")
@UiDescriptor("planin-browse.xml")
@LookupComponent("planinsTable")
@LoadDataBeforeShow
public class PlaninBrowse extends StandardLookup<Planin> {
}