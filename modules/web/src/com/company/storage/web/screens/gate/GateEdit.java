package com.company.storage.web.screens.gate;

import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.gate.Gate;

@UiController("storage_Gate.edit")
@UiDescriptor("gate-edit.xml")
@EditedEntityContainer("gateDc")
@LoadDataBeforeShow
public class GateEdit extends StandardEditor<Gate> {
}