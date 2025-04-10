--liquibase formatted sql
--changeset Dmitriy Chereukho:20

UPDATE companies
SET image_file_name = null
WHERE name = 'Гарант Коннект';

UPDATE companies
SET image_file_name = null
WHERE name = 'Гарант ДокМэйл';

UPDATE companies
SET image_file_name = null
WHERE name = 'Электронные собрания Bnakro.TECH';