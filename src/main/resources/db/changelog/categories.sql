--liquibase formatted sql
--changeset Dmitriy Chereukho:1
create table "categories"(
    id uuid not null constraint categories_pk primary key,
    name varchar(256) not null
);

INSERT INTO categories (id, name) VALUES (0, 'Банкротство')
INSERT INTO categories (id, name) VALUES (1, 'Договорная работа')
INSERT INTO categories (id, name) VALUES (2, 'Защита персональных данных')
INSERT INTO categories (id, name) VALUES (3, 'Комплаенс / управление рисками')
INSERT INTO categories (id, name) VALUES (4, 'Поиск и анализ юридической информации')
INSERT INTO categories (id, name) VALUES (5, 'Претензионно-исковая работа / Исполнительное производство')
INSERT INTO categories (id, name) VALUES (6, 'Прочие решения')
INSERT INTO categories (id, name) VALUES (7, 'Управление интеллектуальной собственностью')
INSERT INTO categories (id, name) VALUES (8, 'Управление юридической фирмой / юридическим департаментом')
INSERT INTO categories (id, name) VALUES (9, 'Юридические сервисы онлайн')
