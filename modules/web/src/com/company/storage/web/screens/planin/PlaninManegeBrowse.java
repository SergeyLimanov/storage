package com.company.storage.web.screens.planin;

import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.planin.Planin;

@UiController("storage_PlaninManage.browse")
@UiDescriptor("planin-manage-browse.xml")
@LookupComponent("planinsTable")
@LoadDataBeforeShow
public class PlaninManegeBrowse extends StandardLookup<Planin> {
}