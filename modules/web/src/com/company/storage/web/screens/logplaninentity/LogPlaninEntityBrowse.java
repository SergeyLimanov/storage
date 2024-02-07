package com.company.storage.web.screens.logplaninentity;

import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.planin.LogPlaninEntity;

@UiController("storage_LogPlaninEntity.browse")
@UiDescriptor("log-planin-entity-browse.xml")
@LookupComponent("logPlaninEntitiesTable")
@LoadDataBeforeShow
public class LogPlaninEntityBrowse extends StandardLookup<LogPlaninEntity> {
}