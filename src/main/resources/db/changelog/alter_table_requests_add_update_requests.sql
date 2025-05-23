--liquibase formatted sql
--changeset Dmitriy Chereukho:21

ALTER TABLE requests
    ADD COLUMN company_id INTEGER REFERENCES companies(id) ON DELETE CASCADE;

UPDATE requests
    SET company_id = null;