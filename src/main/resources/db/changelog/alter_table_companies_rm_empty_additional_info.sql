--liquibase formatted sql
--changeset Dmitriy Chereukho:12

UPDATE companies
SET additional_info = null
WHERE additional_info = '';