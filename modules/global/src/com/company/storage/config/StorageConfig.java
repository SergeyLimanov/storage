package com.company.storage.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultInt;

@Source(type = SourceType.DATABASE)
public interface StorageConfig extends Config {
    /**
     * Время убытия ТС в минутах
     */
    @DefaultInt(30)
    @Property("minutesLeftTime")
    int getMinutesLeftTime();
}