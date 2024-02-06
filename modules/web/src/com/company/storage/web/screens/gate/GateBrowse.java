package com.company.storage.web.screens.gate;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.storage.entity.gate.Gate;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@UiController("storage_Gate.browse")
@UiDescriptor("gate-browse.xml")
@LookupComponent("gatesTable")
@LoadDataBeforeShow
public class GateBrowse extends StandardLookup<Gate> {
    @Inject
    private CollectionLoader<Gate> gatesDl;

    @Subscribe
    public void onInit(InitEvent event) {
        ScreenOptions options = event.getOptions();
        if (options instanceof MapScreenOptions) {
            Map<String, Object> params = ((MapScreenOptions) options).getParams();
            if (params.containsKey("selected")) {
                List<String> excludeGates = (List<String>) params.get("selected");
                gatesDl.setParameter("selected",excludeGates);
                gatesDl.load();
            }
        }
    }
}