DROP TABLE ADDRESS CASCADE CONSTRAINTS;
DROP TABLE EMPLOYMENT CASCADE CONSTRAINTS;
DROP TABLE PROPERTY CASCADE CONSTRAINTS;
DROP TABLE COLLATERAL CASCADE CONSTRAINTS;
DROP TABLE APPLICATION CASCADE CONSTRAINT;
DROP TABLE LOAN CASCADE CONSTRAINTS;
DROP TABLE EMI CASCADE CONSTRAINTS;
DROP TABLE CUSTOMER CASCADE CONSTRAINTS;
DROP TABLE ADMIN CASCADE CONSTRAINTS;
DROP TABLE DOCUMENT CASCADE CONSTRAINTS;


 CREATE TABLE CUSTOMER
  (
  CUST_ID NUMBER PRIMARY KEY,
  TITLE VARCHAR2(5),
  FIRST_NAME VARCHAR2(20) NOT NULL,
  MIDDLE_NAME VARCHAR2(20) ,
  LAST_NAME VARCHAR2(20) NOT NULL,
  PHONE_NUMBER VARCHAR2(10) NOT NULL,
  EMAIL_ID VARCHAR2(20) NOT NULL,
  PASSWORD VARCHAR2(20) NOT NULL,
  DATE_OF_BIRTH DATE,
  GENDER VARCHAR2(10) DEFAULT 'MALE',
  AADHAR_NUMBER VARCHAR2(12) UNIQUE ,
  PAN_NUMBER VARCHAR2(12) UNIQUE
  );

INSERT INTO CUSTOMER VALUES(1 , 'MR' , 'AKASH' , 'SINGH' , 'RAJPUT' ,'8839091067' , 'AKSHRAJ007@GMAIL.COM' , 'AKASH' , TO_DATE('01/01/1990' , 'DD/MM/YYYY') , 'MALE' , '1234567890' , 'ABCDE12345'); 

INSERT INTO CUSTOMER VALUES(2, 'MRS' , 'JESSICA' , NULL , 'WATKINS' ,'8839091043' , 'JESSICA@GMAIL.COM' , 'JESSICA' , TO_DATE('02/02/1980' , 'DD/MM/YYYY') , 'FEMALE' , '1234567876' , 'ABCDE12567'); 
INSERT INTO CUSTOMER VALUES(3, 'MR' , 'JAMES' , NULL , 'WATKINS' ,'8839091678' , 'JAMES@GMAIL.COM' , 'JAMES' , TO_DATE('03/03/1985' , 'DD/MM/YYYY') , 'MALE' , '1234567123' , 'ABCDE12123'); 

CREATE TABLE ADDRESS
(
  ADDRESS_ID NUMBER PRIMARY KEY,
  ADDRESS VARCHAR2(40),
  PIN_CODE NUMBER NOT NULL,
  CITY VARCHAR2(20),
  STATE VARCHAR2(20),
CUST_ID UNIQUE REFERENCES CUSTOMER(CUST_ID) ON DELETE CASCADE 
);

INSERT INTO ADDRESS  VALUES(1,'RAJIV NAGAR MYSORE',570019,'MYSORE','KARNATAKA',1);
INSERT INTO ADDRESS  VALUES(2,'TILAKNAGAR',570021,'MYSORE','KARNATAKA',2);
INSERT INTO ADDRESS VALUES(3,'SHIVAJINAGAR',560068,'BANGALORE','KARNATAKA',3);

CREATE TABLE EMPLOYMENT (
EID NUMBER PRIMARY KEY,
TYPE_OF_EMPLOYEMENT VARCHAR2(20) NOT NULL,
RETIREMENT_AGE VARCHAR2(2),
WORK_EXPERIENCE NUMBER CHECK(WORK_EXPERIENCE < 80),
ORGANIZATION_TYPE VARCHAR2(20) NOT NULL,
EMPLOYER_NAME VARCHAR2(50),
INCOME_PAT NUMBER NOT NULL,
INCOME_FROM_OTHER_SOURCES NUMBER,
NET_MONTHLY_INCOME NUMBER NOT NULL,
CUST_ID UNIQUE REFERENCES CUSTOMER(CUST_ID) ON DELETE CASCADE 
);

INSERT INTO EMPLOYMENT VALUES (1 , 'SALARIED' ,'60' , 10 , 'IT' , 'LTI' , 1000 , 100 , 1100,1);
INSERT INTO EMPLOYMENT VALUES (2,'SELF-EMPLOYED','60',12,'TRADING','TRADING CO.',1500,100,1600,2);
INSERT INTO EMPLOYMENT VALUES (3,'SALARIED','50',15,'IT','TCS',1200,100,1300,3);



CREATE TABLE PROPERTY (
P_ID   NUMBER PRIMARY KEY,
PROPERTY_LOCATION VARCHAR2(20) ,
PROPERTY_NAME  VARCHAR2(20),
COST  NUMBER,
CUST_ID UNIQUE REFERENCES CUSTOMER(CUST_ID) ON DELETE CASCADE  
);
INSERT INTO PROPERTY VALUES ( 1, 'Andheri , Mumbai', 'Sterling Heights', 700000,1);
INSERT INTO PROPERTY VALUES ( 2, 'Andheri , Mumbai', 'Emerald Heights', 800000,2);
INSERT INTO PROPERTY VALUES ( 3, 'Andheri , Mumbai', 'Aakriti Miro', 900000,3);


CREATE TABLE COLLATERAL(
COL_ID NUMBER PRIMARY KEY,
COLLATERAL_TYPE VARCHAR2(20),
NETWORTH NUMBER,
CUST_ID NUMBER REFERENCES CUSTOMER(CUST_ID) ON DELETE CASCADE 
);
INSERT INTO COLLATERAL VALUES ( 1, 'APARTMENT', 2000000, 1);
INSERT INTO COLLATERAL VALUES ( 2, 'GOLD', 3000000, 2);
INSERT INTO COLLATERAL VALUES ( 3, 'PLOT', 4000000, 3);
CREATE TABLE ADMIN(
USERNAME VARCHAR2(20) PRIMARY KEY,
PASSWORD VARCHAR2(20)
);
INSERT INTO ADMIN VALUES( 'ADMIN' , 'Admin123');
CREATE TABLE APPLICATION (
APPLICATION_NO NUMBER PRIMARY KEY,
COMMENTS VARCHAR2(30),
STATUS VARCHAR2(15) CHECK(STATUS IN ('FORM SUBMITTED','APPROVED','REJECTED')),
TENURE NUMBER NOT NULL,
EXPECTED_AMOUNT NUMBER NOT NULL,
  CUST_ID NUMBER UNIQUE REFERENCES CUSTOMER(CUST_ID) ON DELETE CASCADE  
);
INSERT INTO APPLICATION VALUES(1 , NULL , 'FORM SUBMITTED' ,10 ,200000 , 1);
INSERT INTO APPLICATION VALUES(2 , NULL , 'FORM SUBMITTED' ,12 ,10000, 2);
INSERT INTO APPLICATION VALUES(3 , NULL ,  'FORM SUBMITTED',8,300000 , 3);
  CREATE TABLE LOAN 
      (
  LOAN_ACC_NO NUMBER PRIMARY KEY,
  APPROVED_AMOUNT DECIMAL(20,2) ,
  START_DATE DATE,
  END_DATE DATE,
  BALANCE DECIMAL(20,2),
  AMOUNT_PAID DECIMAL(20,2),
  EMI_AMOUNT DECIMAL(12,2),
  AMOUNT_WITH_INTEREST DECIMAL(20,2),
APPLICATION_NO NUMBER UNIQUE REFERENCES APPLICATION(APPLICATION_NO) ON DELETE CASCADE  
    );


INSERT INTO LOAN VALUES (1, 10000,TO_DATE('01/01/2021' , 'DD/MM/YYYY') ,TO_DATE('01/01/2030' , 'DD/MM/YYYY') ,3000,0,300,11000,1);
INSERT INTO LOAN VALUES (2, 100000,TO_DATE('01/01/2020' , 'DD/MM/YYYY') ,TO_DATE('01/01/2030' , 'DD/MM/YYYY') ,10000,300,3000,120000,2);
INSERT INTO LOAN VALUES (3, 300000,TO_DATE('03/05/2021' , 'DD/MM/YYYY') ,TO_DATE('03/05/2035' , 'DD/MM/YYYY') ,10000,400,3090,320000,3);
             
CREATE TABLE EMI (
EMI_ID NUMBER PRIMARY KEY,
EMI_DUE_DATE DATE NOT NULL,
STATUS VARCHAR2(10) NOT NULL CHECK(STATUS IN ('PAID','PENDING')),
CUST_ID NUMBER REFERENCES CUSTOMER(CUST_ID) ON DELETE CASCADE ,
LOAN_ACC_NO NUMBER REFERENCES LOAN(LOAN_ACC_NO) ON DELETE CASCADE 
);



CREATE TABLE DOCUMENT (
DOC_ID NUMBER PRIMARY KEY,
PHOTOGRAPH VARCHAR2(120),
SIGNATURE VARCHAR2(120),
AADHAR_CARD VARCHAR2(120),
PAN_CARD VARCHAR2(120),
VOTER_ID VARCHAR2(120),
BANK_STATEMENT VARCHAR2(120),
SALARY_SLIP VARCHAR2(120),
LOA VARCHAR2(120),
ITRC VARCHAR2(120),
NOC VARCHAR2(120),
AGREEMENT_TO_SALE VARCHAR2(120),
CUST_ID NUMBER UNIQUE REFERENCES CUSTOMER(CUST_ID) ON DELETE CASCADE 
);
INSERT INTO DOCUMENT VALUES(1,'ABC','A:\\B\\C','ABC','A:\\B\\C','ABC','ABC','ABC','ABC','ABC','ABC','ABC',1);
INSERT INTO DOCUMENT VALUES(2,'ABC','ABC','ABC','A:\\B\\C','A:\\B\\C','ABC','ABC','ABC','ABC','ABC','ABC',2);
INSERT INTO DOCUMENT VALUES(3,'ABC','ABC','ABC','ABC','ABC','A:\\B\\C','ABC','ABC','ABC','ABC','ABC',3);

COMMIT;




