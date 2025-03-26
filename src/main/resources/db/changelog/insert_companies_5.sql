--liquibase formatted sql
--changeset Dmitriy Chereukho:15

INSERT INTO companies (name, description, category_id, year_of_launch, link_to_project, contacts, founder, additional_info, image_file_name)
VALUES
    (
        'Б-152 Privacy check',
        'Конструктор политик конфиденциальности',
        (SELECT id FROM categories WHERE name = 'Защита персональных данных'),
        2022,
        'https://policy.privacy check.ru',
        'welcome@privacy-check.ru',
        'ООО «Б152», ИНН 5050091524, ОГРН 1115050004761',
        '1. По домену выявляет все формы сбора на сайте и cookie
2. Готовит политику конфиденциальности
3. Автоматическое обновление политики
4. Один бесплатный и два платных годовых тарифа',
     null
    );