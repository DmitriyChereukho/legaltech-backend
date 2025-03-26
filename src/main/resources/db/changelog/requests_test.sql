--liquibase formatted sql
--changeset Dmitriy Chereukho:14

INSERT INTO requests (name, description, category_id, year_of_launch, link_to_project, contacts, founder, additional_info, image_file_name, status)
VALUES
    ('LegalTech AI', 'Платформа для автоматической генерации контрактов с помощью искусственного интеллекта.', 2, 2023, 'https://example.com/legaltech-ai', 'contact@legaltech-ai.com', 'ООО "AI Легал"', 'Дополнительная информация о проекте', 'test.png', 'CREATED'),
    ('DataProtector', 'Решение для защиты персональных данных в юридических организациях.', 3, 2022, 'https://example.com/dataprotect', 'contact@dataprotect.com', 'ООО "Безопасность данных"', NULL, 'test.png', 'CREATED'),
    ('ContractBot', 'Автоматизация процесса создания и согласования договоров.', 2, 2021, 'https://example.com/contractbot', 'contact@contractbot.com', 'ООО "Контракт Бот"', 'Используется для малого бизнеса', 'test.png', 'CREATED'),
    ('ComplianceHub', 'Система управления рисками и соблюдения комплаенса.', 4, 2020, 'https://example.com/compliancehub', 'contact@compliancehub.com', 'ООО "РискГрупп"', 'Решение для крупных компаний', 'test.png', 'CREATED'),
    ('LegalAnalyzer', 'Поиск и анализ юридической информации с использованием машинного обучения.', 5, 2021, 'https://example.com/legalanalyzer', 'contact@legalanalyzer.com', 'ООО "ЮрисАналитика"', 'Использует ИИ для обработки документов', 'test.png', 'CREATED'),
    ('ClaimPro', 'Платформа для автоматизации претензионно-исковой работы.', 6, 2022, 'https://example.com/claimpro', 'contact@claimpro.com', 'ООО "ЮрИск"', 'Работает с государственными и частными учреждениями', 'test.png', 'CREATED'),
    ('IntelliIP', 'Решение для управления интеллектуальной собственностью.', 8, 2020, 'https://example.com/intelliip', 'contact@intelliip.com', 'ООО "Интеллектуальная собственность"', NULL, 'test.png', 'CREATED'),
    ('LawFirmManager', 'CRM-система для управления юридической фирмой.', 9, 2023, 'https://example.com/lawfirmmanager', 'contact@lawfirmmanager.com', 'ООО "ФирмаЮрист"', 'Решение для юридических компаний с более чем 50 сотрудниками', 'test.png', 'CREATED'),
    ('LegalOnline', 'Юридические услуги онлайн для частных лиц и бизнеса.', 10, 2021, 'https://example.com/legalonline', 'contact@legalonline.com', 'ООО "Юридические услуги онлайн"', 'Доступно 24/7', 'test.png', 'CREATED'),
    ('BankruptcyAI', 'Система для автоматизации процесса банкротства и ликвидации компаний.', 1, 2022, 'https://example.com/bankruptcyai', 'contact@bankruptcyai.com', 'ООО "Банкрот-Авто"', 'Использует AI для ускорения процедуры', 'test.png', 'CREATED');