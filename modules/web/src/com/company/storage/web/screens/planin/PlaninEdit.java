package com.company.storage.web.screens.planin;

import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.planin.Planin;

@UiController("storage_Planin.edit")
@UiDescriptor("planin-edit.xml")
@EditedEntityContainer("planinDc")
@LoadDataBeforeShow
public class PlaninEdit extends StandardEditor<Planin> {
}