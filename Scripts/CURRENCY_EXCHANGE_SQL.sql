CREATE TABLE currency (
    id character varying(3) NOT NULL,
    inclusion_date time with time zone
);

CREATE TABLE currencyconverurl (
    tocurrency character varying(4) NOT NULL,
    fromcurrency character varying(4) NOT NULL,
    urlvalue character varying(800)
);


CREATE SEQUENCE exchange_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE exchange (
    fromcurrency character varying(4),
    tocurrency character varying(4),
    rate double precision,
    dateexchange timestamp with time zone,
    id numeric(9,0) DEFAULT nextval('exchange_seq'::regclass) NOT NULL,
    active boolean
);

CREATE TABLE parameters (
    paramkey character varying(20) NOT NULL,
    paramvalue character varying(200)
);

INSERT INTO currency VALUES ('USD', '17:11:02.639-05');
INSERT INTO currency VALUES ('EUR', '17:11:02.639-05');
INSERT INTO currencyconverurl VALUES ('EUR', 'USD', 'http://api.fixer.io/latest');
INSERT INTO exchange VALUES ('USD', 'EUR', 0.84245999999999999, '2018-05-08 16:17:14.298-05',(select nextval('exchange_seq')), true);
INSERT INTO parameters VALUES ('TIMECURRENCYREFESH', '10');
