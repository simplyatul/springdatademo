DROP TABLE IF EXISTS officers;
CREATE TABLE officers (
    id      INT  NOT NULL AUTO_INCREMENT,
    rank    VARCHAR(20)    NOT NULL,
    NAME    VARCHAR(20)    NOT NULL,
    PRIMARY KEY (id)
);
