create table STORAGE_GATE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GATE_NUMBER varchar(5),
    TIME_FROM time,
    TIME_TO time,
    --
    primary key (ID)
);