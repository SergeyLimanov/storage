create table STORAGE_PLANIN (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REG_NUMBER varchar(10),
    GATE varchar(5),
    REG_DATE timestamp,
    DATE_INSTALLATION_GATE timestamp,
    DATE_LEAVE_ALLOWED timestamp,
    LEAVE_DATE timestamp,
    ORDER_NUMBER varchar(50),
    PLANNING_DATE timestamp,
    TS_NUMBER varchar(20),
    LOAD_CAPACITY integer,
    FIO varchar(100),
    PHONE_NUMBER varchar(20),
    PLANIN_STATUS integer,
    PLANIN_STATE integer,
    --
    primary key (ID)
);