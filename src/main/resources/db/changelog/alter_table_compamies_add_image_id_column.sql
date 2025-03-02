--liquibase formatted sql
--changeset Dmitriy Chereukho:7

ALTER TABLE companies
    ADD COLUMN image_id INT;

UPDATE companies
SET image_id = NULL;

ALTER TABLE companies
    ADD CONSTRAINT fk_companies_images FOREIGN KEY (image_id) REFERENCES company_images (id);