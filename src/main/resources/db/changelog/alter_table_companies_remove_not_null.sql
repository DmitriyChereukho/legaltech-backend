--liquibase formatted sql
--changeset Dmitriy Chereukho:16
ALTER TABLE companies ALTER COLUMN description DROP NOT NULL;
ALTER TABLE companies ALTER COLUMN year_of_launch DROP NOT NULL;
ALTER TABLE companies ALTER COLUMN link_to_project DROP NOT NULL;
ALTER TABLE companies ALTER COLUMN contacts DROP NOT NULL;
ALTER TABLE companies ALTER COLUMN founder DROP NOT NULL;