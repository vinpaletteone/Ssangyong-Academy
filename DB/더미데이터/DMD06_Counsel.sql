-- DMD06_Counsel.SQL
-- 상담 요청 및 상담일지 더미 데이터
---------------------------------------------------------------------------------------------------------------------
-- 상담일지 더미 데이터
---------------------------------------------------------------------------------------------------------------------
SELECT * FROM TBLCOUNSEL;
CREATE SEQUENCE counsel_seq;
DROP SEQUENCE counsel_seq;
DELETE FROM TBLCOUNSEL;
INSERT INTO TBLCOUNSEL values(counsel_seq.nextVal, sysdate, 'for문부터 차근차근 예제를 복습하고 과제를 다시 한번 풀어보고 데이터베이스 과정 프로젝트가 시작하기 전까지 Java 예제와 과제 복습을 하면 도움이 될 수 있다고함', '김민성', 'Java  for문부터 이해가 되지않아 따라가기 어려움',1,4);
INSERT INTO TBLCOUNSEL VALUES(counsel_seq.nextVal, SYSDATE, '안녕', '김승현', '안녕2', 5, 4);
INSERT INTO TBLCOUNSEL VALUES(counsel_seq.nextVal, sysdate, null, 1, 4);
INSERT INTO TBLCOUNSEL VALUES(counsel_seq.nextVal, sysdate, null, 2, 5);
INSERT INTO TBLCOUNSEL VALUES(counsel_seq.nextVal, sysdate, null, 3, 6);

---------------------------------------------------------------------------------------------------------------------
-- 상담요청 더미 데이터
---------------------------------------------------------------------------------------------------------------------
SELECT * FROM TBLCOUNSELREQUEST;
CREATE SEQUENCE counselrequest_seq;
DROP SEQUENCE counselrequest_seq;
DELETE FROM TBLCOUNSELREQUEST;
INSERT INTO TBLCOUNSELREQUEST VALUES (counselrequest_seq.nextVal, SYSDATE, 'Java  for문부터 이해가 되지않아 따라가기 어려움', 4, '요청', 14);
INSERT INTO TBLCOUNSELREQUEST VALUES (counselrequest_seq.nextVal, SYSDATE, '취업 걱정', NULL, 14);
INSERT INTO TBLCOUNSELREQUEST VALUES (counselrequest_seq.nextVal, SYSDATE, '성적 걱정', NULL, 15);
INSERT INTO TBLCOUNSELREQUEST VALUES (counselrequest_seq.nextVal, SYSDATE, '집안 사정 걱정', NULL, 16);
INSERT INTO TBLCOUNSELREQUEST VALUES (counselrequest_seq.nextVal, SYSDATE, '집안 사정 걱정', NULL, 17);
INSERT INTO TBLCOUNSELREQUEST VALUES (counselrequest_seq.nextVal, SYSDATE, '집안 사정 걱정', NULL, 18);
---------------------------------------------------------------------------------------------------------------------