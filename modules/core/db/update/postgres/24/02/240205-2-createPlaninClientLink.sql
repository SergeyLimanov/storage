alter table STORAGE_PLANIN_CLIENT_LINK add constraint FK_PLACLI_ON_PLANIN foreign key (PLANIN_ID) references STORAGE_PLANIN(ID);
alter table STORAGE_PLANIN_CLIENT_LINK add constraint FK_PLACLI_ON_CLIENT foreign key (CLIENT_ID) references STORAGE_CLIENT(ID);