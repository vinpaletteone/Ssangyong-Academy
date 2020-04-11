-- DMD003_Info.SQL
-- 교재, 과목, 과정, 강의실 기본 정보 더미 데이터
------------------------------------------------------------------------------------------------------------
-- 교재 더미데이터(15개)
------------------------------------------------------------------------------------------------------------
SELECT * FROM tblbook;
DROP SEQUENCE book_seq;
CREATE SEQUENCE book_seq;

INSERT INTO tblBook VALUES (book_seq.nextVal, '이것이 자바다','신용권','한빛미디어'); -- 1
INSERT INTO tblBook VALUES (book_seq.nextVal, '누구나 쉽게SQL','홍형경','길벗'); -- 2
INSERT INTO tblBook VALUES (book_seq.nextVal, 'Do it! 자바스크립트 + 제이쿼리 입문','정인용','이지스퍼블리싱'); -- 3
INSERT INTO tblBook VALUES (book_seq.nextVal, '생활코딩! HTML + CSS + 자바스크립트','이고잉','위키북스'); -- 4
INSERT INTO tblBook VALUES (book_seq.nextVal, '코드로 배우는 스프링 웹 프로젝트','구멍가게','남가람북스'); -- 5
INSERT INTO tblBook VALUES (book_seq.nextVal, '스프링 5 레시피','다니엘','한빛미디어'); -- 6
INSERT INTO tblBook VALUES (book_seq.nextVal, '모덴 웹을 위한 HTML5_CSS3 바이블','윤인성','한빛미디어'); -- 7
INSERT INTO tblBook VALUES (book_seq.nextVal, '혼자 공부하는 파이썬','윤인성','한빛미디어'); -- 8
INSERT INTO tblBook VALUES (book_seq.nextVal, 'Do it! 점프 투 파이썬','박응용','이지스퍼블리싱'); -- 9
INSERT INTO tblBook VALUES (book_seq.nextVal, '모두의 파이썬','이승찬','길벗'); -- 10
INSERT INTO tblBook VALUES (book_seq.nextVal, 'Java의 정석','Java정석','도우출판'); -- 11
INSERT INTO tblBook VALUES (book_seq.nextVal, '혼자 공부하는 자바','신용권','한빛미디어'); -- 12
INSERT INTO tblBook VALUES (book_seq.nextVal, '코어 자바스크립트','정재남','위키북스'); -- 13
INSERT INTO tblBook VALUES (book_seq.nextVal, 'SQL 코딩의 기술','더글러스','길벗'); -- 14
INSERT INTO tblBook VALUES (book_seq.nextVal, 'SQL 레벨업','미크','한빛미디어'); -- 15

------------------------------------------------------------------------------------------------------------
-- 과목 더미데이터(30개)
------------------------------------------------------------------------------------------------------------
SELECT * FROM tblSubject;
CREATE SEQUENCE subject_seq;
DROP SEQUENCE subject_seq;
DELETE FROM TBLSUBJECT;

INSERT INTO tblSubject VALUES (subject_seq.nextVal,'객체지향 프로그래밍', 11); -- 1
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'데이터 베이스 구현', 2); -- 2
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'JAVA 애플리케이션 구현', 1); -- 3
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'JAVA 애플리케이션 통합 테스트', 1); -- 4
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'애플리케이션 배포', 4); -- 5
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Front-end 웹 애플리케이션 구현', 4); -- 6
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Full-stack Framwork 구현', 9); -- 7
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'반응형 웹 개발 기법', 7); -- 8
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'융합기반 웹표준 프로젝트', 10); -- 9
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'NCS 소양교과', 15); -- 10
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'관계형 데이터베이스', 15); -- 11
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'화면 설계', 3); -- 12
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'웹 어플리케이션', 5); -- 13
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'웹 퍼블리싱', 3); -- 14
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'구현 애플리케이션 테스트', 13); -- 15
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'자바 프레임워크', 13); -- 16
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'인공지능', 14); -- 17
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Oracle DBMS', 14); -- 18
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Fundamental Java SE', 12); -- 19
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Front-end 개발', 6); -- 20
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Back-end 개발', 6); -- 21
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Framwork', 12); -- 22
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Testing & Development', 8); -- 23
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Python', 8); -- 24
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'JAVA 프로그래밍', 11); -- 25
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'데이터베이스', 2); -- 26
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'애플리케이션 테스트 수행', 9); -- 27
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'웹 프로그래밍', 7); -- 28
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'요구사항 확인', 10); -- 29
INSERT INTO tblSubject VALUES (subject_seq.nextVal,'Spring 개발', 5); -- 30

------------------------------------------------------------------------------------------------------------
-- 과정 더미데이터 (12개)
------------------------------------------------------------------------------------------------------------
SELECT * FROM TBLCOURSE;
DELETE  FROM TBLCOURSE WHERE seq = 65;
UPDATE TBLCOURSE SET COURSE_NAME = '웹기반 빅데이터 분석 응용SW개발자' WHERE seq = 1;
CREATE SEQUENCE course_seq;
DELETE FROM TBLCOURSE;
DROP SEQUENCE course_seq;
UPDATE TBLCOURSE SET STARTDATE = '2019-06-15' WHERE seq = 1;
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, '자바 기반 융합형 SW 개발자 양성과정', '2019-06-15', '2019-12-29', 30, 1);	-- 1
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, '웹개발'||'&'||'머신러닝을 통한 응용SW 엔지니어링', '2019-05-26', '2019-12-26', 25, 2); -- 2
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, 'Python'||'&'||'Java 응용SW실무개발자 양성과정', '2019-07-21', '2020-01-15', 25, 3); -- 3
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, 'JAVA기반의 스마트 웹 앱콘텐츠 양성과정', '2019-06-27', '2020-01-15', 25, 4); -- 4
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, '웹기반 빅데이터 분석 응용SW개발자', '2019-06-26', '2020-01-16', 21, 5); -- 5
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, 'Java를 활용한 웹 응용SW개발자 양성과정', '2019-07-13', '2019-02-02', 20, 6); -- 6
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, '빅데이터를 활용한 지능형 웹 콘텐츠 개발자', '2019-01-06', '2019-06-14', 22, 1); -- 7
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, 'Python'||'&'||'Java를 활용한 AI 텍스트 마이닝 개발자 양성과정', '2019-01-16', '2019-05-25', 23, 2); -- 8
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, 'Java'||'&'||'JavaScript Library을 활용한 반응형 개발자', '2019-01-20', '2019-07-20', 24, 3); -- 9
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, '모의 해킹 기반 정보보호 엔지니어 양성 과정', '2019-01-26', '2019-06-26', 26, 4); -- 10
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, '정보보호 기반 정보시스템 진단 및 관리 엔지니어 양성과정', '2019-01-15', '2019-06-25', 20, 5); -- 11
INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, 'UI/UX엔지니어링 및 응용SW엔지니어링 양성과정', '2019-02-01', '2019-07-12', 22, 6); -- 12

------------------------------------------------------------------------------------------------------------
-- 강의실 더미 데이터(6개)
------------------------------------------------------------------------------------------------------------
SELECT * FROM tblclass;
CREATE SEQUENCE class_seq;
DROP SEQUENCE class_seq;
DELETE FROM tblclass;

INSERT INTO TBLCLASS VALUES (class_seq.nextVal, '제 1강의실', 30); -- 1
INSERT INTO TBLCLASS VALUES (class_seq.nextVal, '제 2강의실', 30); -- 2
INSERT INTO TBLCLASS VALUES (class_seq.nextVal, '제 3강의실', 30); -- 3
INSERT INTO TBLCLASS VALUES (class_seq.nextVal, '제 4강의실', 26); -- 4
INSERT INTO TBLCLASS VALUES (class_seq.nextVal, '제 5강의실', 26); -- 5
INSERT INTO TBLCLASS VALUES (class_seq.nextVal, '제 6강의실', 26); -- 6