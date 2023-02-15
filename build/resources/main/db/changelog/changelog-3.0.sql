--liquibase formatted sql

--changeset plaxa:1
ALTER TABLE users
ADD COLUMN image VARCHAR(64);

--changeset plaxa:2
ALTER TABLE users_aud
ADD COLUMN image VARCHAR(64)
