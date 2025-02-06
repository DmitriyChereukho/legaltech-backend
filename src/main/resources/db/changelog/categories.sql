--liquibase formatted sql
--changeset Dmitriy Chereukho:1
create table "categories"
(
    id   serial       not null
        constraint categories_pk primary key,
    name varchar(256) not null
);

INSERT INTO categories (name)
VALUES ('Банкротство');
INSERT INTO categories (name)
VALUES ('Договорная работа');
INSERT INTO categories (name)
VALUES ('Защита персональных данных');
INSERT INTO categories (name)
VALUES ('Комплаенс / управление рисками');
INSERT INTO categories (name)
VALUES ('Поиск и анализ юридической информации');
INSERT INTO categories (name)
VALUES ('Претензионно-исковая работа / Исполнительное производство');
INSERT INTO categories (name)
VALUES ('Прочие решения');
INSERT INTO categories (name)
VALUES ('Управление интеллектуальной собственностью');
INSERT INTO categories (name)
VALUES ('Управление юридической фирмой / юридическим департаментом');
INSERT INTO categories (name)
VALUES ('Юридические сервисы онлайн');
