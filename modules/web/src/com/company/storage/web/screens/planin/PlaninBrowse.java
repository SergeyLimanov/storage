package com.company.storage.web.screens.planin;

import com.company.storage.entity.gate.Gate;
import com.company.storage.entity.planin.Planin;
import com.company.storage.entity.planin.PlaninState;
import com.company.storage.entity.planin.PlaninStatus;
import com.company.storage.service.PlaninService;
import com.company.storage.web.screens.gate.GateBrowse;
import com.company.storage.web.screens.registration.RegistrationWindow;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.components.Timer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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
    private DataManager dataManager;
    @Inject
    private GroupTable<Planin> planinsTable;
    @Inject
    private GroupTable<Planin> planinsTable2;
    @Inject
    private Notifications notifications;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private PlaninService planinService;

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

    @Subscribe(id = "planinsDl2", target = Target.DATA_LOADER)
    public void onSettlementsDlPostLoad(CollectionLoader.PostLoadEvent<Planin> event) {
        planinsTable2.addGeneratedColumn("Время на воротах", entity -> {
            Label<String> label = uiComponents.create(Label.NAME);
            label.setValue(String.valueOf(entity.getDateInstallationGate() != null ? Duration.between(entity.getDateInstallationGate(), LocalDateTime.now()).toHours() : ""));
            return label;
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

    public void registered() {
        RegistrationWindow build = screenBuilders.screen(this).withScreenClass(RegistrationWindow.class).withLaunchMode(OpenMode.DIALOG).build();
        build.addAfterCloseListener(e -> loadPlanning());
        build.show();
    }

    public void assigneeGate() {
        Planin selected = planinsTable.getSingleSelected();
        if (selected == null) {
            notifications.create().withCaption("Ни один элемент не выбран.").show();
            return;
        }
        if (selected.getPlaninStatus() == null || !PlaninStatus.REGISTERED.equals(selected.getPlaninStatus())) {
            notifications.create().withCaption("Ворота не могут быть назначены").show();
            return;
        }
        if (PlaninStatus.REGISTERED.equals(selected.getPlaninStatus())) {
            List<String> gateNumbers = planinService.getPlaninNumbers();
            MapScreenOptions map = new MapScreenOptions(ParamsMap.of("selected", gateNumbers));
            GateBrowse build = (GateBrowse) screenBuilders.lookup(Gate.class, this)
                    .withSelectHandler(handler -> {
                        Gate gate = handler.stream().findFirst().get();
                        updateSelected(selected, gate);
                        loadPlanning();
                        loadAtGate();
                    })
                    .withOptions(map)
                    .build();
            build.show();
        }
    }

    private void updateSelected(Planin selected, Gate gate) {
        selected.setGate(gate.getGateNumber());
        selected.setPlaninStatus(PlaninStatus.AT_GATE);
        selected.setPlaninState(PlaninState.GATE_ASSIGNED);
        selected.setDateInstallationGate(LocalDateTime.now());
        dataManager.commit(selected);
    }

    public void downloadCompeted() {
        Planin selected = planinsTable2.getSingleSelected();
        if (selected == null) {
            notifications.create().withCaption("Ни один элемент не выбран.").show();
            return;
        }
        selected.setPlaninStatus(PlaninStatus.EXIT_ALLOWED);
        selected.setPlaninState(PlaninState.EXIT_ALLOWED);
        selected.setGate("PARKINGEXIT".substring(0, 5));
        dataManager.commit(selected);
        loadAtGate();
    }
}