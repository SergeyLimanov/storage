create table STORAGE_LOG_PLANIN_ENTITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REG_NUMBER varchar(255),
    LOG_STATUS integer,
    LOG_STATE integer,
    TS_NUMBER varchar(255),
    --
    primary key (ID)
);