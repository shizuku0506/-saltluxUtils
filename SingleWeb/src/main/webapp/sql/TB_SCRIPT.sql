/*
 * TABLE SCRIPT
 * 
 * 생성 : TB_ 테이블네임 
 * 
 */

-- CREATE TABLE
CREATE TABLE TB_USER
( 
	SEQ NUMBER NOT NULL,
	USER_ID VARCHAR2(10) NOT NULL PRIMARY KEY,
	USER_NM VARCHAR2(50) NOT NULL,
	USER_PASSWORD VARCHAR2(50) NOT NULL,
	USER_PHONE VARCHAR2(100),
	USER_EMAIL VARCHAR2(100),
	ROLL_CD VARCHAR2(20) DEFAULT 'ROLL_001',
	CREATE_DT DATE DEFAULT SYSDATE,
	UPDATE_DT DATE DEFAULT SYSDATE,
	DELETE_YN VARCHAR2(1) DEFAULT 'N'
);

-- INSERT
INSERT INTO TB_USER VALUES(SQ_USER_01.NEXTVAL , 'single' , '싱글' , 'single' , '010-5132-0000' , 'souler2585@gmail.com', 'ROLL_01' , SYSDATE , SYSDATE , 'Y');
