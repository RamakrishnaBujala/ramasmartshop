DROP SCHEMA SMARTSHOP IF EXISTS;
CREATE SCHEMA SMARTSHOP;

CREATE TABLE SMARTSHOP.CATEGORY ( 
	CATEGORY_ID          integer GENERATED ALWAYS AS IDENTITY  NOT NULL,
	CATEGORY_NAME        varchar(100)   NOT NULL,
	CATEGORY_DESCRIPTION varchar(250)   ,
	CONSTRAINT PK_CATEGORY PRIMARY KEY ( CATEGORY_ID )
 );

COMMENT ON TABLE SMARTSHOP.CATEGORY IS 'Prodcut category
';

CREATE TABLE SMARTSHOP."ORDER" ( 
	ORDER_ID             integer   NOT NULL,
	ORDER_BOOKING_DATE   date   NOT NULL,
	ORDER_CANCEL_DATE    date   ,
	ORDER_TXN_ID         varchar(20)   NOT NULL,
	ORDER_STATUS         char(1)   ,
	USER_ID              integer   NOT NULL,
	SHIPPING_ADDRESS     varchar(100)   ,
	SHIPPING_CITY        varchar(100)   ,
	SHIPPING_PIN         varchar(10)   ,
	CONSTRAINT IDX_ORDER UNIQUE ( ORDER_ID ) ,
	CONSTRAINT PK_ORDER PRIMARY KEY ( ORDER_ID )
 );

ALTER TABLE SMARTSHOP."ORDER" ADD CONSTRAINT FK_ORDER_USER FOREIGN KEY ( ORDER_ID ) REFERENCES SMARTSHOP."USER"( USER_ID ) ON DELETE NO ACTION ON UPDATE NO ACTION;




CREATE TABLE SMARTSHOP.ORDER_DETAILS ( 
	ORDER_DETAILS_ID     integer   NOT NULL,
	ORDER_DETAILS_QTY    integer   ,
	ORDER_DETAILS_PRICE  double   ,
	ORDER_ID             integer   ,
	PRODUCT_ID           integer   ,
	CONSTRAINT PK_ORDER_DETAILS PRIMARY KEY ( ORDER_DETAILS_ID )
 );

CREATE INDEX idx_ORDER_DETAILS ON SMARTSHOP.ORDER_DETAILS ( ORDER_DETAILS_ID );

ALTER TABLE SMARTSHOP.ORDER_DETAILS ADD CONSTRAINT FK_ORDER_DETAILS_PRODUCT FOREIGN KEY ( PRODUCT_ID ) REFERENCES SMARTSHOP.PRODUCT( PRODUCT_ID ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE SMARTSHOP.ORDER_DETAILS ADD CONSTRAINT FK_ORDER_DETAILS_ORDER FOREIGN KEY ( ORDER_ID ) REFERENCES SMARTSHOP."ORDER"( ORDER_ID ) ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE TABLE SMARTSHOP.PRODUCT ( 
	PRODUCT_NAME         varchar(100)   NOT NULL,
	PRODUCT_PRICE        decimal   NOT NULL,
	PRODCUT_DESC         varchar(100)   ,
	CATEGORY_ID          integer   ,
	PRODUCT_ID           integer   NOT NULL,
	CONSTRAINT PK_PRODUCT PRIMARY KEY ( PRODUCT_ID )
 );

ALTER TABLE SMARTSHOP.PRODUCT ADD CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY ( CATEGORY_ID ) REFERENCES SMARTSHOP.CATEGORY( CATEGORY_ID ) ON DELETE NO ACTION ON UPDATE NO ACTION;


CREATE TABLE SMARTSHOP.PRODUCT_IMAGES ( 
	PRODUCT_IMAGES_ID    integer   NOT NULL,
	PRODUCT_ID           integer   ,
	PRODUCT_IMAGE        blob(65535)   ,
	CONSTRAINT PK_PRODUCT_IMAGES PRIMARY KEY ( PRODUCT_IMAGES_ID )
 );

ALTER TABLE SMARTSHOP.PRODUCT_IMAGES ADD CONSTRAINT FK_PRODUCT_IMAGES_PRODUCT FOREIGN KEY ( PRODUCT_ID ) REFERENCES SMARTSHOP.PRODUCT( PRODUCT_ID ) ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE TABLE SMARTSHOP."USER" ( 
	USER_ID              integer GENERATED ALWAYS AS IDENTITY  NOT NULL,
	USER_EMAIL           varchar(50)   NOT NULL,
	USER_PASSWORD        varchar(30)   NOT NULL,
	USER_FIRST_NAME      varchar(50)   NOT NULL,
	USER_LAST_NAME       varchar(50)   ,
	USER_USER_NAME       varchar(50)   NOT NULL,
	USER_ADDRESS   		 varchar(100)   NOT NULL,	
	USER_CITY            varchar(100)   NOT NULL,
	USER_STATE           varchar(100)   NOT NULL,
	USER_PINCODE         varchar(250)   NOT NULL,
	USER_TYPE            varchar(1)  DEFAULT 'U' NOT NULL,
	CONSTRAINT PK_USER PRIMARY KEY ( USER_ID )
 );

COMMENT ON TABLE SMARTSHOP."USER" IS 'This table hold the user credentials(login details)';


COMMENT ON TABLE SMARTSHOP.USER_ADDRESS IS 'This table holds the user address information';

create sequence SMARTSHOP.CATEGORY_CATEGORY_ID;

create sequence SMARTSHOP.PRODUCT_PRODCUT_ID;

create sequence SMARTSHOP.USER_ADDRESS_USER_ADDRESS_ID;

create sequence SMARTSHOP.USER_USER_ID;

create sequence SMARTSHOP.hibernate_sequence