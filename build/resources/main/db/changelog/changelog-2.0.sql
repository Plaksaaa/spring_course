--liquibase formatted sql

--changeset plaxa:1
Alter Table users
    ADD COLUMN created_at TIMESTAMP;

Alter Table users
    ADD COLUMN modified_at TIMESTAMP;

Alter Table users
    ADD COLUMN created_by Varchar(32);

Alter Table users
    ADD COLUMN modified_by Varchar(32);