package com.company.storage.service;

public interface PlaninScheduledService {
    String NAME = "storage_ScheduledServiceService";

    default String getMethodName() {
        return "updatePlaningsBySchedule";
    }

    default String getMethodParamsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<params/>";
    }

    void createScheduledTaskByPlanin();

    void updatePlaningsBySchedule();
}