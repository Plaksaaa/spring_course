--liquibase formatted sql

--changeset plaxa:1
ALTER TABLE users
ADD COLUMN password VARCHAR(264) DEFAULT '{noop}123';

--changeset plaxa:2
ALTER TABLE users_aud
ADD COLUMN password VARCHAR(264)