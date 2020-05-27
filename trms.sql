CREATE USER trms
IDENTIFIED BY veepatel
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to trms;
GRANT resource to trms;
GRANT create session TO trms;
GRANT create table TO trms;
GRANT create view TO trms;

conn trms/veepatel


/*CREATE TABLES*/
CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID         NUMBER PRIMARY KEY,
    EMPLOYEE_FIRSTNAME  VARCHAR2(30) NOT NULL,
    EMPLOYEE_LASTNAME   VARCHAR2(30) NOT NULL,
    EMPLOYEE_EMAIL      VARCHAR2(70) UNIQUE,
    EMPLOYEE_USERNAME VARCHAR2(25) UNIQUE,
    EMPLOYEE_PASSWORD   VARCHAR2(40),
    EMPLOYEE_TITLE      NUMBER NOT NULL,
    EMPLOYEE_DEPARTMENT NUMBER NOT NULL
);

CREATE TABLE REIMBURSEMENT(
    REIMBURSEMENT_ID              NUMBER PRIMARY KEY,
    REIMBURSEMENT_EMPLOYEE_ID     NUMBER NOT NULL,
    REIMBURSEMENT_COST            NUMBER(10,2) NOT NULL,
    REIMBURSEMENT_STATUS          VARCHAR2(50) NOT NULL,
    REIMBURSEMENT_EVENT           NUMBER NOT NULL,
    REIMBURSEMENT_DAYS_MISSED     NUMBER,
    REIMBURSEMENT_JUSTIFICATION   VARCHAR2(200),
    REIMBURSEMENT_NOTES           VARCHAR2(200),
	REIMBURSEMENT_STATUS_BY		  VARCHAR2(50)	
);

CREATE TABLE EVENT(
    EVENT_ID NUMBER PRIMARY KEY,
    EVENT_TYPE NUMBER NOT NULL,
    EVENT_DATE DATE NOT NULL,
    EVENT_LOCATION VARCHAR2(50) NOT NULL,
    EVENT_DESCRIPTION 	VARCHAR2(200),
    EVENT_GRADING_FORMAT NUMBER NOT NULL,
    EVENT_GRADE VARCHAR2(10),
    EVENT_FILE BLOB
);

CREATE TABLE DEPARTMENT(
    DEPARTMENT_ID   NUMBER PRIMARY KEY,
    DEPARTMENT_NAME VARCHAR2(40) UNIQUE NOT NULL
);

CREATE TABLE EMPLOYEE_TITLE(
    EMPLOYEE_TITLE_ID   NUMBER PRIMARY KEY,
    EMPLOYEE_TITLE_NAME VARCHAR2(60) UNIQUE NOT NULL
);

CREATE TABLE EVENT_TYPE(
    EVENT_TYPE_ID         NUMBER PRIMARY KEY,
    EVENT_TYPE_NAME       VARCHAR2(60) UNIQUE NOT NULL,
    EVENT_TYPE_PERCENT    NUMBER NOT NULL
);

CREATE TABLE GRADING_FORMAT(
    GRADING_FORMAT_ID           NUMBER PRIMARY KEY,
    GRADING_FORMAT_NAME         VARCHAR2(40) NOT NULL,
    GRADING_FORMAT_PASS_GRADE   VARCHAR2(8) NOT NULL
);

CREATE TABLE MESSAGE(
	MESSAGE_ID NUMBER PRIMARY KEY,
    REIMBURSEMENT_ID NUMBER,
	FROM_ID NUMBER NOT NULL,
	TO_ID NUMBER NOT NULL,
	SUBJECT VARCHAR2(100),
	MESSAGE VARCHAR2(500)
);


/*ADD FOREIGN KEYS*/

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_EMPLOYEE_TITLE
    FOREIGN KEY (EMPLOYEE_TITLE) REFERENCES
    EMPLOYEE_TITLE (EMPLOYEE_TITLE_ID);
    
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT
    FOREIGN KEY (EMPLOYEE_DEPARTMENT) REFERENCES
    DEPARTMENT(DEPARTMENT_ID);

ALTER TABLE REIMBURSEMENT ADD CONSTRAINT FK_REIMBURSEMENT_EMPLOYEE
    FOREIGN KEY (REIMBURSEMENT_EMPLOYEE_ID) REFERENCES
    EMPLOYEE (EMPLOYEE_ID);
    
ALTER TABLE REIMBURSEMENT ADD CONSTRAINT FK_REIMBURSEMENT_EVENT
    FOREIGN KEY (REIMBURSEMENT_EVENT) REFERENCES
    EVENT (EVENT_ID);
    
ALTER TABLE EVENT ADD CONSTRAINT FK_EVENT_GRADING_FORMAT
    FOREIGN KEY (EVENT_GRADING_FORMAT) REFERENCES
    GRADING_FORMAT (GRADING_FORMAT_ID);

ALTER TABLE ATTACHMENT ADD CONSTRAINT FK_ATTACHMENT_REIMBURSEMENT
    FOREIGN KEY (ATTACHMENT_REIMBURSEMENT_ID) REFERENCES
    REIMBURSEMENT (REIMBURSEMENT_ID);

ALTER TABLE ATTACHMENT ADD CONSTRAINT FK_ATTACHMENT_REIMBURSEMENT_STATUS
    FOREIGN KEY (ATTACHMENT_APPROVAL_TYPE) REFERENCES
    REIMBURSEMENT_STATUS (REIMBURSEMENT_STATUS_ID);

/*CREATE SEQUENCES*/

CREATE SEQUENCE EMPLOYEE_ID_SEQ MINVALUE 1 MAXVALUE 999999999999
    INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE;

CREATE SEQUENCE REIMBURSEMENT_ID_SEQ MINVALUE 1 MAXVALUE 999999999999999
    INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE;

CREATE SEQUENCE MESSAGE_ID_SEQ MINVALUE 1 MAXVALUE 999999999999999
    INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE;

CREATE SEQUENCE EVENT_ID_SEQ MINVALUE 1 MAXVALUE 999999999999999
    INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE;
	
/* INSERT REQUIRED RECORDS */

INSERT INTO DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME)
    VALUES (1, 'Sales');

INSERT INTO DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME)
    VALUES (2, 'Human Resources');

INSERT INTO DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME)
    VALUES (3, 'Production');


INSERT INTO EVENT_TYPE VALUES (1, 'university course', 80);
INSERT INTO EVENT_TYPE VALUES (2, 'seminar', 60);
INSERT INTO EVENT_TYPE VALUES (3, 'certification preparation', 75);
INSERT INTO EVENT_TYPE VALUES (4, 'certification', 100);
INSERT INTO EVENT_TYPE VALUES (5, 'technical training', 90);
INSERT INTO EVENT_TYPE VALUES (6, 'other', 30);

INSERT INTO GRADING_FORMAT VALUES (1, 'Percentage (0-100)', '80');
INSERT INTO GRADING_FORMAT VALUES (2, 'Grade (A-F)', 'B');
INSERT INTO GRADING_FORMAT VALUES (3, 'Pass/Fail', 'PASS');
INSERT INTO GRADING_FORMAT VALUES (4, 'Other', 'Other');

INSERT INTO EMPLOYEE_TITLE VALUES (1, 'Department Head');
INSERT INTO EMPLOYEE_TITLE VALUES (2, 'Direct Supervisor');
INSERT INTO EMPLOYEE_TITLE VALUES (3, 'Benifits Coordinator');
INSERT INTO EMPLOYEE_TITLE VALUES (4, 'Associate');

COMMIT;

/*CREATE TRIGGERS*/

CREATE OR REPLACE TRIGGER EMPLOYEE_INSERT
    BEFORE INSERT ON EMPLOYEE
    FOR EACH ROW
    BEGIN
        SELECT EMPLOYEE_ID_SEQ.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
    END;
/

CREATE OR REPLACE TRIGGER REIMBURSEMENT_INSERT
    BEFORE INSERT ON REIMBURSEMENT
    FOR EACH ROW
    BEGIN
        SELECT REIMBURSEMENT_ID_SEQ.NEXTVAL INTO :NEW.REIMBURSEMENT_ID FROM DUAL;
    END;
/

CREATE OR REPLACE TRIGGER EVENT_INSERT
    BEFORE INSERT ON EVENT
    FOR EACH ROW
    BEGIN
        SELECT EVENT_ID_SEQ.NEXTVAL INTO :NEW.EVENT_ID FROM DUAL;
    END;
/

CREATE OR REPLACE TRIGGER MESSAGE_INSERT
    BEFORE INSERT ON MESSAGE
    FOR EACH ROW
    BEGIN
        SELECT MESSAGE_ID_SEQ.NEXTVAL INTO :NEW.MESSAGE_ID FROM DUAL;
    END;
/

INSERT INTO EMPLOYEE (EMPLOYEE_FIRSTNAME,EMPLOYEE_LASTNAME, EMPLOYEE_EMAIL,EMPLOYEE_USERNAME,EMPLOYEE_PASSWORD,EMPLOYEE_TITLE,EMPLOYEE_DEPARTMENT)
VALUES ('VEE','PATEL','IT.VEENAYPATEL@GMAIL.COM','VEEPATEL','Vee@1221',4,3);

INSERT INTO EMPLOYEE (EMPLOYEE_FIRSTNAME,EMPLOYEE_LASTNAME, EMPLOYEE_EMAIL,EMPLOYEE_USERNAME,EMPLOYEE_PASSWORD,EMPLOYEE_TITLE,EMPLOYEE_DEPARTMENT)
VALUES ('MATT','KNIGHTEN','MATT.KNIGHTENJ@REVATURE.COM','KNIGHTENJ','Matt@1234',2,3);

INSERT INTO EMPLOYEE (EMPLOYEE_FIRSTNAME,EMPLOYEE_LASTNAME, EMPLOYEE_EMAIL,EMPLOYEE_USERNAME,EMPLOYEE_PASSWORD,EMPLOYEE_TITLE,EMPLOYEE_DEPARTMENT)
VALUES ('STEVE','SMITH','STEVE.SMITH@REVATURE.COM','STEVES','Smith@123',1,3);

INSERT INTO EMPLOYEE (EMPLOYEE_FIRSTNAME,EMPLOYEE_LASTNAME, EMPLOYEE_EMAIL,EMPLOYEE_USERNAME,EMPLOYEE_PASSWORD,EMPLOYEE_TITLE,EMPLOYEE_DEPARTMENT)
VALUES ('JACOB','DAVIS','JACOB.DAVIS@REVATURE.COM','DJACOB','DAVIS@234',3,2);

INSERT INTO EVENT (EVENT_TYPE,EVENT_DATE,EVENT_LOCATION,EVENT_DESCRIPTION,EVENT_GRADING_FORMAT)
VALUES (2,'27-FEB-2020','BALTIMORE','SEMINAR ON ADVANCED JAVA',4);

INSERT INTO REIMBURSEMENT (REIMBURSEMENT_EMPLOYEE_ID,REIMBURSEMENT_COST,REIMBURSEMENT_STATUS,REIMBURSEMENT_EVENT,REIMBURSEMENT_DAYS_MISSED)
VALUES (1,150,'APPROVED',1,1,'REQUIRED FOR NEW PROJECT','BENIFITS COORDINATOR');

INSERT INTO EVENT (EVENT_TYPE,EVENT_DATE,EVENT_LOCATION,EVENT_DESCRIPTION,EVENT_GRADING_FORMAT)
VALUES (2,'31-MAY-2020','BALTIMORE','SEMINAR ON ANGULAR',4);

INSERT INTO REIMBURSEMENT (REIMBURSEMENT_EMPLOYEE_ID,REIMBURSEMENT_COST,REIMBURSEMENT_STATUS,REIMBURSEMENT_EVENT,REIMBURSEMENT_DAYS_MISSED)
VALUES (1,200,'PENDING',2,1,'REQUIRED AS PER CLIENT');

/*STORED PROCEDURES*/
CREATE OR REPLACE PROCEDURE GET_USER
(UNAME IN VARCHAR2,UPASS IN VARCHAR2,U1 OUT SYS_REFCURSOR)
AS

BEGIN
OPEN U1 FOR
SELECT E.EMPLOYEE_ID,E.EMPLOYEE_FIRSTNAME,E.EMPLOYEE_LASTNAME,E.EMPLOYEE_EMAIL,ET.EMPLOYEE_TITLE_NAME,DE.DEPARTMENT_NAME FROM EMPLOYEE E
JOIN EMPLOYEE_TITLE ET
ON E.EMPLOYEE_TITLE = ET.EMPLOYEE_TITLE_ID
JOIN DEPARTMENT DE
ON E.EMPLOYEE_DEPARTMENT=DE.DEPARTMENT_ID
WHERE E.EMPLOYEE_USERNAME=UNAME AND E.EMPLOYEE_PASSWORD=UPASS;

END;
/

SELECT EMPLOYEE.EMPLOYEE_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME,EMPLOYEE.EMPLOYEE_LASTNAME,EMPLOYEE.EMPLOYEE_EMAIL,EMPLOYEE.EMPLOYEE_USERNAME,EMPLOYEE.EMPLOYEE_PASSWORD,EMPLOYEE_TITLE.EMPLOYEE_TITLE_NAME,DEPARTMENT.DEPARTMENT_NAME FROM EMPLOYEE 
JOIN EMPLOYEE_TITLE 
ON EMPLOYEE.EMPLOYEE_TITLE = EMPLOYEE_TITLE.EMPLOYEE_TITLE_ID
JOIN DEPARTMENT 
ON EMPLOYEE.EMPLOYEE_DEPARTMENT=DEPARTMENT.DEPARTMENT_ID;
execute get_user('VEEPATEL','Vee@1221');

SELECT EMPLOYEE_FIRSTNAME||' '||EMPLOYEE_LASTNAME AS EMPLOYEE_NAME,EMPLOYEE_EMAIL FROM EMPLOYEE;

SELECT EMPLOYEE.EMPLOYEE.FIRSTNAME,REIMBURSEMENT.REIMBURSEMENT_COST,
EVENT.EVENT_TYPE,EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE,
REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED,REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,
REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY FROM REIMBURSEMENT
JOIN EMPLOYEE
ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID
JOIN EVENT
ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID;

SELECT EMPLOYEE.EMPLOYEE_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME,EMPLOYEE.EMPLOYEE_LASTNAME,
EMPLOYEE_TITLE.EMPLOYEE_TITLE_NAME,DEPARTMENT.DEPARTMENT_NAME FROM EMPLOYEE 
JOIN EMPLOYEE_TITLE 
ON EMPLOYEE.EMPLOYEE_TITLE = EMPLOYEE_TITLE.EMPLOYEE_TITLE_ID
JOIN DEPARTMENT 
ON EMPLOYEE.EMPLOYEE_DEPARTMENT=DEPARTMENT.DEPARTMENT_ID
WHERE EMPLOYEE.EMPLOYEE_USERNAME=UNAME AND EMPLOYEE.EMPLOYEE_PASSWORD=UPASS;
