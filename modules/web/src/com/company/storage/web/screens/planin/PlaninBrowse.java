package com.company.storage.web.screens.planin;

import com.company.storage.entity.planin.Planin;
import com.company.storage.entity.planin.PlaninState;
import com.company.storage.entity.planin.PlaninStatus;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.components.Timer;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@UiController("storage_Planin.browse")
@UiDescriptor("planin-browse.xml")
@LookupComponent("planinsTable")
@LoadDataBeforeShow
public class PlaninBrowse extends StandardLookup<Planin> {
    @Inject
    private CollectionLoader<Planin> planinsDl;
    @Inject
    private CollectionLoader<Planin> planinsDl2;
    @Inject
    private Timer timer;
    @Inject
    private TabSheet tabSheet;
    @Inject
    private CollectionContainer<Planin> planinsDc2;
    @Inject
    private CollectionContainer<Planin> planinsDc;
    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onInit(InitEvent event) {
        loadPlanning();
        loadAtGate();

        tabSheet.addSelectedTabChangeListener(e -> {
            if (e.getSelectedTab().getName().equals("planning")) {
                loadPlanning();
            } else {
                loadAtGate();
            }
        });
    }

    private void loadAtGate() {
        Map<String, Object> byDepParams = new HashMap<>();
        byDepParams.put("planinStatus3", PlaninStatus.AT_GATE);
        byDepParams.put("planinStatus4", PlaninState.GATE_ASSIGNED);
        planinsDl2.setParameters(byDepParams);
        planinsDl2.load();
    }

    private void loadPlanning() {
        Map<String, Object> byDepParams = new HashMap<>();
        byDepParams.put("planinStatus", PlaninStatus.PLANNING);
        byDepParams.put("planinStatus2", PlaninStatus.REGISTERED);
        planinsDl.setParameters(byDepParams);
        planinsDl.load();
    }


    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        initTimer();
    }

    @Subscribe
    public void onBeforeClose(BeforeCloseEvent event) {
        timer.stop();
    }

    private void initTimer() {
        timer.setId("update");
        timer.setRepeating(true);
        timer.setDelay(30_000);
        timer.addTimerActionListener(e -> refreshDls());
        timer.start();
    }

    public void refreshDls() {
        planinsDl.load();
        planinsDl2.load();
    }

}