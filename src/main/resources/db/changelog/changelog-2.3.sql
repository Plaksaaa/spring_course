--liquibase formatted sql

--changeset plaxa:1
ALTER TABLE users_aud
ALTER COLUMN username DROP NOT NULL;