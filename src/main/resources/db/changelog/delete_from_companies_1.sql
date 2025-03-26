--liquibase formatted sql
--changeset Dmitriy Chereukho:18

DELETE FROM companies WHERE name = 'Электронное правосудие' AND description = 'Система электронного документооборота для арбитражных судов и участников судебного процесса.';