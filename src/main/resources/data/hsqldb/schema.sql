DROP TABLE DRUG IF EXISTS;

CREATE TABLE DRUG (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1,INCREMENT BY 1) NOT NULL,
    drugName VARCHAR(100) NOT NULL,
    company VARCHAR(100) NOT NULL,
);