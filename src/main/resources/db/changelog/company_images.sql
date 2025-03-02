--liquibase formatted sql
--changeset Dmitriy Chereukho:6

CREATE TABLE "company_images"
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    path VARCHAR(512) NOT NULL
);