--liquibase formatted sql
--changeset Dmitriy Chereukho:8

-- Удаляем внешний ключ
ALTER TABLE companies
DROP CONSTRAINT fk_companies_images;

-- Удаляем столбец image_id
ALTER TABLE companies
DROP COLUMN image_id;

-- Добавляем новый столбец image_file_name типа String (VARCHAR)
ALTER TABLE companies
    ADD COLUMN image_file_name VARCHAR(512);