--liquibase formatted sql
--changeset Dmitriy Chereukho:13

CREATE TABLE "requests"
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    description     TEXT         NOT NULL,
    category_id     integer      NOT NULL,
    year_of_launch  INT          NOT NULL,
    link_to_project VARCHAR(512) NOT NULL,
    contacts        VARCHAR(512) NOT NULL,
    founder         VARCHAR(255) NOT NULL,
    additional_info TEXT,
    image_file_name VARCHAR(512),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status          VARCHAR(32) NOT NULL DEFAULT 'CREATED',
    CONSTRAINT fk_requests_category FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE
);