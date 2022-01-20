-- fix Table Create SQL
CREATE TABLE fix
(
    `idx`       INT            NOT NULL    AUTO_INCREMENT,
    `name`      VARCHAR(20)    NOT NULL    ,
    `state`     INT        NOT NULL    DEFAULT 0,
    CONSTRAINT PK_fix PRIMARY KEY (idx)
);

ALTER TABLE fix;

CREATE UNIQUE INDEX name_UNIQUE
    ON fix(name);

-- custom Table Create SQL
CREATE TABLE custom
(
    `idx`       INT            NOT NULL    AUTO_INCREMENT,
    `name`      VARCHAR(20)    NOT NULL    ,
    CONSTRAINT PK_custom PRIMARY KEY (idx)
);

ALTER TABLE custom;

CREATE UNIQUE INDEX name_UNIQUE
    ON custom(name);