--liquibase formatted sql

--changeset mial:1.0.0_001 splitStatements:false logicalFilePath:classpath:/liquibase/changelog-1.0.0.sql
CREATE TABLE exchange_rate
(
    id       UUID PRIMARY KEY NOT NULL,
    currency TEXT,
    rate     REAL,
    date     DATE
);

--changeset mial:1.0.0_002 splitStatements:false logicalFilePath:classpath:/liquibase/changelog-1.0.0.sql
CREATE TABLE user_account
(
    id       UUID PRIMARY KEY NOT NULL,
    username TEXT             NOT NULL,
    password TEXT             NOT NULL
);

INSERT INTO user_account(id, username, password)
VALUES ('b379be78-53aa-46c8-8efd-638c3e2d5b11', 'test', '$2a$12$mm/baarFOx69kilCYAoQ/eynm/0TXta7fDmim27SHLhWevBHgX8z2');

--changeset mial:1.0.0_003 splitStatements:false logicalFilePath:classpath:/liquibase/changelog-1.0.0.sql
CREATE TABLE conversion_history
(
    id                 UUID PRIMARY KEY NOT NULL,
    from_currency      TEXT,
    from_currency_rate REAL,
    to_currency        TEXT,
    to_currency_rate   REAL,
    amount             REAL,
    date               DATE
);