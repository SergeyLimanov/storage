-- begin STORAGE_GATE
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
)^
-- end STORAGE_GATE
-- begin STORAGE_CLIENT
create table STORAGE_CLIENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLIENT_CODE integer,
    DESCRIPTION_NAME varchar(200),
    ADDRESS varchar(200),
    CONTACT_PERSON varchar(100),
    --
    primary key (ID)
)^
-- end STORAGE_CLIENT
-- begin STORAGE_PLANIN
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
)^
-- end STORAGE_PLANIN
-- begin STORAGE_PLANIN_CLIENT_LINK
create table STORAGE_PLANIN_CLIENT_LINK (
    PLANIN_ID uuid,
    CLIENT_ID uuid,
    primary key (PLANIN_ID, CLIENT_ID)
)^
-- end STORAGE_PLANIN_CLIENT_LINK
