
--1. 관리자,선생님,학생
drop table tblLogin;

create table tblLogin
(
    seq number primary key,     			--PK
    id varchar2(100) NOT NULL UNIQUE,            --아이디
    password varchar2(100) not null,      --비밀번호
    authority number check(authority in (1, 2, 3)) not null     --권한
);

create sequence login_seq;

SELECT * FROM tblLogin;

drop table Administrator;
create table tbladministrator
(
    loginSeq number primary key,         --PK=FK
    name varchar2(100) not null,          --이름
    jumin varchar2(100) not null unique,  --주민번호
    tel varchar2(100) not null,           --전화번호
    age number,                          --나이
    address varchar2(100),                --주소
    email varchar2(100),                  --이메일
    
    
    constraint login_admin_fk foreign key(loginSeq) references tblLogin(seq)
    	ON DELETE CASCADE
);

drop table tblTeacher;
create table tblTeacher
(
    loginSeq number primary key,    --PK=FK
    name varchar2(100) not null,              --이름
    jumin varchar2(100) not null unique,             --주민번호
    tel varchar2(100) not null,               --전화번호
    age number,                     --나이
    address varchar2(100),           --주소
    email varchar2(100),             --이메일
    state number check(state in (1, 2, 3)),             --강의진행여부   1강의예정 2강의중 3강의종료
    
    constraint login_teacher_fk foreign key(loginSeq) references tblLogin(seq)
    ON DELETE CASCADE
);

drop table tblStudent;
create table tblStudent
(
    loginSeq number primary key,    --PK=FK
    name varchar2(100) not null,              --이름
    jumin varchar2(100) not null unique,             --주민번호
    tel varchar2(100) not null,               --전화번호
    age number,                     --나이
    address varchar2(100),           --주소
    email varchar2(100),             --이메일
    courseCount number,             --수강신청횟수
    employmentState number check(employmentState in (1, 2, 3)) ,   --취업여부 1 취업 2 수강 중 미취업 3 수료 후 미취업
    
    constraint login_student_fk foreign key(loginSeq) references tblLogin(seq)
    ON DELETE CASCADE

);

-------------------------------------------------------------------------//1

--2. 과목

--교재
drop table tblBook;
create table tblBook
(
  seq number primary key,        --교재번호(PK)
  book_name varchar2(100),       --교재명
  author varchar2(100),          --저자
  pub varchar2(100)              --출판사
  
);
create sequence book_seq;



--과목
drop table tblSubject;
create table tblSubject
(
  seq number primary key,                      --과목번호(PK)
  subject_name varchar2(100),                  --과목명
  book_seq number,                              --교재번호(FK)
  constraint subject_book_fk foreign key(book_seq) references tblbook(seq)
  ON DELETE CASCADE
);
create sequence subject_seq;

-------------------------------------------------------------------------//2

--3. 과정

--강의실
drop table tblClass;
create table tblClass
(
  seq number primary key,               --강의실번호(PK)
  class_name varchar2(100),             --강의실명
  maxPeople number check(maxPeople in (26,30)) not null                           --최대인원수
);
create sequence class_seq;

--과정
drop table tblcourse;
create table tblcourse
(
  seq number primary key,                    --과정번호(PK)
  course_name varchar2(100) not null,                 --과정명
  startdate date not null,                                --시작일
  enddate date not null,                                  --종료일
  regist_total number,                       --등록인원수    
  class_seq number,                         --강의실번호(FK)
  constraint course_class_fk foreign key(class_seq) references tblClass(seq)
  ON DELETE CASCADE
);
SELECT * FROM TBLCOURSE;
create sequence course_seq;

-------------------------------------------------------------------------//3

--4. 과정-과목

--과정-과목
SELECT * FROM tblCourse_Subject;
drop table tblCourse_Subject;
create table tblCourse_Subject
(
  seq number primary key,                         --번호(PK)
  subject_seq number,                             --과목번호(FK)
  course_seq number,                              --과정번호(FK)
  scorePoint_seq NUMBER NOT NULL,						-- 배점(FK)
  startdate date not null,                              --과목 시작일
  enddate date not null,                              	--과목 종료일
  constraint coursesubject_subject_fk foreign key(subject_seq) references tblsubject(seq)
  ON DELETE CASCADE,
  constraint coursesubject_curse_fk foreign key(course_seq) references tblcourse(seq)
  ON DELETE CASCADE,
  CONSTRAINT coursesubject_scorePoint_fk FOREIGN KEY(scorePoint_seq) REFERENCES tblScorePoint(seq)
  ON DELETE CASCADE
);

SELECT * FROM TBLSUBJECT;
SELECT * FROM TBLCOURSE;
create sequence course_subject_seq;

-------------------------------------------------------------------------//2,3

--5. 교사-과목

--교사-과목
drop table tblTeacher_subject;
create table tblTeacher_subject 
(   seq number primary key,         --PK
    teacherSeq number,              --교사번호 (FK)
    course_subjectSeq number,        --과정-과목번호 (FK)
    subject NUMBER,			-- 과목 번호(FK)
    
    constraint teacher_subject_fk foreign key(teacherSeq) references tblTeacher(loginSeq)
    ON DELETE CASCADE,
    constraint subject_course_fk foreign key(course_subjectSeq) references TBLCOURSE_SUBJECT(seq)
    ON DELETE CASCADE,
    CONSTRAINT subject_fk FOREIGN KEY (subject) REFERENCES TBLSUBJECT(seq)
    ON DELETE CASCADE
);
SELECT * FROM tblTeacher;
create sequence teacher_subject_seq;
-------------------------------------------------------------------------//4,1

--6. 교육생-과정
ALTER TABLE TBLSTUDENT_COURSE DROP COLUMN regdate;
SELECT * FROM TBLSTUDENT_COURSE;
drop table tblStudent_course;
create table tblStudent_course
(   
	seq number primary key,     --PK
    failcourse NUMBER check(failcourse in (1, 2, 3, 4)),    --중도탈락(1 수료중, 2 중도탈락, 3 수료 4 수강대기)
    failday DATE,				-- 중도탈락 날짜
    recourse number,      		--재수강여부
    courseSeq number,           --과정번호(FK)
    studentSeq number,           --교육생번호(FK)
    regdate DATE DEFAULT SYSDATE,	-- 등록일
    
    constraint student_course_fk foreign key(studentSeq) references tblStudent(loginSeq)
    ON DELETE CASCADE,
    constraint course_student_fk foreign key(courseSeq) references tblCourse(seq)
    ON DELETE CASCADE
);
create sequence student_course_seq;

-------------------------------------------------------------------------//1,3

--7. 총점수

-- 배점
SELECT * FROM TBLSCOREPOINT;
CREATE TABLE tblScorePoint
(
	Seq NUMBER PRIMARY KEY,		-- 배점 seq(PK)
	AttendancePoint NUMBER,		-- 출결 배점
	WritingDay DATE,			-- 필기시험 날짜
	WritingPoint NUMBER,		-- 필기배점
	PracticalDay DATE,			-- 실기시험 날짜
	PracticalPoint NUMBER		-- 실기시험
);

--총 점수
drop table tblTotalScore;
SELECT * FROM tblTotalScore;
create table tblTotalScore(
     seq number primary key, 	-- seq(PK)
     PracticalScore NUMBER,		-- 실기 점수
     WritingScore NUMBER,		-- 필기 점수
     AttendanceScore NUMBER,	-- 출석 점수
     Student_CourseSeq number,	-- 교육생 - 과정
     course_subjectSeq number,	-- 과정 - 과목
     constraint tblcourse_total_fk foreign key(course_subjectSeq) references TBLCOURSE_SUBJECT(seq)
     ON DELETE CASCADE,                -- 과정 과목 
     constraint student_course_total_fk foreign key(Student_CourseSeq) references tblStudent_course(seq)
     ON DELETE CASCADE			-- 교육생 과정
);

SELECT * FROM tblTotalScore;

-------------------------------------------------------------------------//7,4,6

--8. 출결

-- 출결
drop table tblAttendance;
create table tblAttendance(
    seq number primary key,             -- seq(PK)
    days date default to_date(to_char(sysdate,'yyyy-mm-dd')),                         -- 날짜
    insigan DATE,                       -- 출석 시간
    outsigan date,                      -- 퇴근 시간
    state number check(state in (1, 2, 3, 4, 5, 6, 7)), -- 출결 상태 1. 정상 2. 지각 3. 조퇴 4. 외출 5. 병가 6. 결석 7. 기타
    Student_CourseSeq number,
    constraint attendance_student_fk foreign key(Student_CourseSeq) references tblStudent_course(seq)
    ON DELETE CASCADE		-- 교육생 과정 
);

SELECT * FROM TBLATTENDANCE;

-------------------------------------------------------------------------//6,7

--9. 상담
SELECT * FROM TBLCOUNSELREQUEST;
drop table tblCounselRequest;
DELETE FROM TBLCOUNSELREQUEST;
CREATE TABLE tblCounselRequest -- 상담요청 테이블
(
   seq NUMBER PRIMARY KEY,      -- 상담요청 번호(PK)
   requestDay date,             -- 상담요청날짜
   requsetMemo varchar2(4000),   -- 상담 요청내용
   teacherSeq NUMBER,
   requestState varchar2(4000),
   studentSeq NUMBER REFERENCES tblStudent(loginSeq) NOT NULL
   							-- 교육생 seq(FK)
);
DELETE FROM TBLCOUNSELREQUEST WHERE seq = 4;
SELECT * FROM TBLCOUNSELREQUEST;
SELECT * FROM tblCounsel;
drop table tblCounsel;
DELETE FROM TBLCOUNSEL;
CREATE TABLE tblCounsel -- 상담일지 테이블
(
   seq NUMBER PRIMARY KEY,   -- 상담일지 번호(PK)
   counselTime date,      -- 상담일시
   counselMemo varchar2(4000),   -- 상담내용
   studentName varchar2(1000),
   counselRequestMemo varchar2(4000),
   counselRequest NUMBER REFERENCES TBLCOUNSELREQUEST(seq) NOT NULL,
   teacherSeq NUMBER REFERENCES tblTeacher(loginseq) NOT NULL 
 											-- 상담교사seq(FK)
);

CREATE SEQUENCE counsel_seq;

-------------------------------------------------------------------------//1,9

--10. 취업

drop table tblEmployment;
CREATE TABLE tblEmployment -- 취업 테이블
(
   seq NUMBER PRIMARY KEY, 		-- 회사 번호(PK)
   companyName varchar2(100),  -- 회사 이름
   yearPay NUMBER,        		-- 연봉
   companyScale varchar2(100),	-- 회사 규모
   employmentDay DATE, 			-- 입사일
   StudentSeq NUMBER REFERENCES tblstudent(loginSeq) NOT NULL	-- 교육생 seq(FK)
);

SELECT * FROM tblEmployment;
CREATE SEQUENCE employment_seq;

-------------------------------------------------------------------------//1