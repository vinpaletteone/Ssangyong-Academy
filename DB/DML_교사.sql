-- 교사 강의스케줄 조회 -> 과정정보 및 과목목록 출력 VIEW
CREATE OR REPLACE VIEW vwSchedule
AS
SELECT
	l.ID AS teacherId,
	CASE 
		WHEN SYSDATE < c.STARTDATE THEN N'강의예정' 
		WHEN SYSDATE > c.STARTDATE AND SYSDATE < c.ENDDATE THEN N'강의중'
		WHEN SYSDATE > c.ENDDATE THEN N'강의종료'
	END AS lectureState,
	c.SEQ AS courseNumber,
	c.COURSE_NAME AS courseName,
	TO_CHAR(c.STARTDATE, 'yyyy-mm-dd') || ' ~ ' || TO_CHAR(c.ENDDATE, 'yyyy-mm-dd') AS coursePeriod,
	class.CLASS_NAME AS classRoom,
	s.SUBJECT_NAME AS subjectName,
	TO_CHAR(cs.STARTDATE, 'yyyy-mm-dd') || ' ~ ' || TO_CHAR(cs.ENDDATE, 'yyyy-mm-dd') AS subjectPeriod,
	b.BOOK_NAME AS bookName,
	c.REGIST_TOTAL AS registration
FROM TBLTEACHER_SUBJECT ts
	INNER JOIN TBLTEACHER t
		ON t.LOGINSEQ = ts.TEACHERSEQ
	RIGHT OUTER JOIN TBLCOURSE_SUBJECT cs
		ON ts.COURSE_SUBJECTSEQ = cs.SEQ
	INNER JOIN TBLCOURSE c
		ON cs.COURSE_SEQ = c.SEQ
	INNER JOIN TBLCLASS class
		ON c.CLASS_SEQ = class.SEQ
	INNER JOIN TBLSUBJECT s
		ON s.SEQ = cs.SUBJECT_SEQ
	INNER JOIN tblbook b
		ON s.BOOK_SEQ = b.SEQ
	INNER JOIN TBLLOGIN l
		ON l.SEQ = t.LOGINSEQ
ORDER BY c.SEQ;

-- 교사 강의스케줄 조회 -> 과정(선택) -> 학생 정보 출력 VIEW
CREATE OR REPLACE VIEW vwStudentInfo
AS
SELECT
	c.SEQ AS courseSeq,
	s.NAME AS studentName,
	s.TEL AS tel,
	TO_CHAR(c.STARTDATE, 'yyyy-mm-dd')AS courseStart,
	CASE
		WHEN sc.FAILCOURSE = 1 THEN '수강중'
		WHEN sc.FAILCOURSE = 2 THEN '중도탈락'
	END AS lectureState
FROM TBLSTUDENT_COURSE sc
	INNER JOIN TBLCOURSE c
	ON sc.COURSESEQ = c.SEQ
	INNER JOIN TBLSTUDENT s
	ON sc.STUDENTSEQ = s.LOGINSEQ;

-- 과정 정보 및 과목목록 출력 VIEW
CREATE OR REPLACE VIEW vwSubDistribution
AS
SELECT
	l.ID AS teacherId,
	c.COURSE_NAME AS courseName,
	TO_CHAR(c.STARTDATE, 'yyyy-mm-dd') || ' ~ ' || TO_CHAR(c.ENDDATE, 'yyyy-mm-dd') AS coursePeriod,
	room.CLASS_NAME AS classRoom,
	s.SEQ AS subjectNum,
	s.SUBJECT_NAME AS subjectName,
	TO_CHAR(cs.STARTDATE, 'yyyy-mm-dd') || ' ~ ' || TO_CHAR(cs.ENDDATE, 'yyyy-mm-dd') AS subjectPeriod,
	b.BOOK_NAME AS bookName,
	sp.ATTENDANCEPOINT AS attendancePoint,
	sp.WRITINGPOINT AS writingPoint,
	sp.PRACTICALPOINT AS practicalPoint
FROM TBLTEACHER t
	INNER JOIN TBLLOGIN l
		ON t.LOGINSEQ = l.SEQ
	INNER JOIN TBLTEACHER_SUBJECT TS
		ON ts.TEACHERSEQ = t.LOGINSEQ
	INNER JOIN TBLCOURSE_SUBJECT cs
		ON ts.SEQ = cs.SEQ
	INNER JOIN TBLSUBJECT s
		ON s.SEQ = cs.SUBJECT_SEQ
	INNER JOIN TBLBOOK b
		ON b.SEQ = s.BOOK_SEQ
	INNER JOIN TBLCOURSE c
		ON c.seq = cs.COURSE_SEQ
	INNER JOIN TBLCLASS room
		ON room.seq = c.CLASS_SEQ
	INNER JOIN tblScorePoint sp
		ON sp.SEQ = cs.SCOREPOINT_SEQ;
		
-- 교사 배점 입출력 -> 과목번호(선택) -> 선택과목 배점 정보출력 VIEW
CREATE OR REPLACE VIEW vwscoreInfo
AS
SELECT
	s.SEQ AS subjectNum,
	s.SUBJECT_NAME AS subjectName,
	sp.ATTENDANCEPOINT AS attendancePoint,
	TO_CHAR(sp.WRITINGDAY, 'yyyy-mm-dd') AS writingDay,
	sp.WRITINGPOINT AS writingPoint,
	TO_CHAR(sp.PRACTICALDAY, 'yyyy-mm-dd') AS practicalDay,
	sp.PRACTICALPOINT AS practicalPoint
FROM TBLCOURSE_SUBJECT cs
	INNER JOIN TBLSUBJECT s
		ON cs.SUBJECT_SEQ = s.SEQ
	INNER JOIN tblScorePoint sp
		ON cs.SCOREPOINT_SEQ = sp.SEQ;
	
-- 교사 배점 입출력 -> 과목번호(선택) -> 선택과목 출결 배점 수정 및 입력 PROCEDURE
create or replace procedure attScore_proc
(
	pseq tblScorePoint.seq%TYPE,
	pscore tblScorePoint.AttendancePoint%TYPE,
	presult OUT number
)
is
    vnum number;
    vnum2 number;
    vnum3 number;
BEGIN
	UPDATE tblScorePoint SET AttendancePoint = pscore WHERE seq = pseq;
    select AttendancePoint into vnum from tblScorePoint where seq = pseq;
    select WritingPoint into vnum2 from tblScorePoint where seq = pseq;
    select PracticalPoint into vnum3 from tblScorePoint where seq = pseq;
   
   IF vnum2 IS NULL THEN
   	vnum2 := 0;
   ELSIF vnum3 IS NULL THEN
   	vnum3 := 0;
   END IF;
   
    IF vnum+vnum2+vnum3 <= 100 AND vnum >= 20 THEN
    	presult := 1;
        commit;
      ELSIF vnum < 20 THEN
      	presult := 2;
        ROLLBACK;
      ELSE 
      	PRESULT := 3;
      	ROLLBACK;
      END IF;
end;

-- 교사 배점 입출력 -> 과목번호(선택) -> 선택과목 필기시험날짜 수정 및 입력 PROCEDURE
CREATE OR REPLACE PROCEDURE writingDay_proc
(
	pseq tblScorePoint.seq%TYPE,
	pday tblScorePoint.writingday%TYPE
)
IS
BEGIN
	UPDATE TBLSCOREPOINT SET writingday = pday WHERE seq = pseq;
END;

-- 교사 배점 입출력 -> 과목번호(선택) -> 선택과목 필기시험배점 수정 및 입력 PROCEDURE
create or replace procedure writingScore_proc
(
	pseq tblScorePoint.seq%TYPE,
	pscore tblScorePoint.WritingPoint%TYPE,
	presult OUT number
)
IS
	
	vnum number;
    vnum2 number;
    vnum3 number;

BEGIN
	UPDATE tblScorePoint SET WritingPoint = pscore WHERE seq = pseq;
    select AttendancePoint into vnum from tblScorePoint where seq = pseq;
    select WritingPoint into vnum2 from tblScorePoint where seq = pseq;
    select PracticalPoint into vnum3 from tblScorePoint where seq = pseq;
   
   IF vnum IS NULL THEN
   	vnum := 0;
   ELSIF vnum3 IS NULL THEN
   	vnum3 := 0;
   END IF;
   
    IF vnum+vnum2+vnum3 <= 100 THEN
    	presult := 1;
        commit;
      ELSE 
      	PRESULT := 2;
      	ROLLBACK;
      END IF;
end;

-- 교사 배점 입출력 -> 과목번호(선택) -> 선택과목 실기시험날짜 수정 및 입력 PROCEDURE
CREATE OR REPLACE PROCEDURE practicalDay_proc
(
	pseq tblScorePoint.seq%TYPE,
	pday tblScorePoint.PRACTICALDAY%TYPE
)
IS
BEGIN
	UPDATE TBLSCOREPOINT SET PRACTICALDAY = pday WHERE seq = pseq;
END;

-- 교사 배점 입출력 -> 과목번호(선택) -> 선택과목 실기시험배점 수정 및 입력 PROCEDURE
create or replace procedure practicalScore_proc
(
	pseq tblScorePoint.seq%TYPE,
	pscore tblScorePoint.PRACTICALPOINT%TYPE,
	presult OUT number
)
IS
	vnum number;
    vnum2 number;
    vnum3 number;

BEGIN
	UPDATE tblScorePoint SET PRACTICALPOINT = pscore WHERE seq = pseq;
    select AttendancePoint into vnum from tblScorePoint where seq = pseq;
    select WritingPoint into vnum2 from tblScorePoint where seq = pseq;
    select PracticalPoint into vnum3 from tblScorePoint where seq = pseq;
   
   IF vnum IS NULL THEN
   	vnum := 0;
   ELSIF vnum2 IS NULL THEN
   	vnum2 := 0;
   END IF;
   
    IF vnum+vnum2+vnum3 <= 100 THEN
    	presult := 1;
        commit;
      ELSE 
      	PRESULT := 2;
      	ROLLBACK;
      END IF;
end;

-- 교사 성적 입출력 -> 과목번호(선택) -> 교육생 정보 및 점수 출력
CREATE OR REPLACE VIEW vwSubjectStudentInfo
AS
SELECT
	cs.SEQ AS subjectNum,
	sc.SEQ AS studentNum,
	s.NAME AS studentName,
	s.TEL AS studentTel,
	CASE
	WHEN sc.FAILCOURSE = 1 THEN '수료중'
	WHEN sc.FAILCOURSE = 2 THEN '중도탈락'|| ' : ' || TO_CHAR(sc.FAILDAY, 'yyyy-mm-dd')
	WHEN sc.FAILCOURSE = 3 THEN '수료'
	END AS failState,
	ts.AttendanceScore AS attendanceScore,
	ts.WRITINGSCORE AS writingScore,
	ts.PRACTICALSCORE AS practicalScore
FROM TBLSUBJECT sub
	INNER JOIN TBLCOURSE_SUBJECT cs
		ON sub.SEQ = cs.SUBJECT_SEQ
	INNER JOIN TBLTOTALSCORE ts
		ON ts.COURSE_SUBJECTSEQ = cs.SEQ
	INNER JOIN TBLSTUDENT_COURSE sc
		ON sc.SEQ = ts.STUDENT_COURSESEQ
	INNER JOIN TBLSTUDENT s
		ON s.LOGINSEQ = sc.STUDENTSEQ;

-- 교사 성적 입출력 -> 출결 점수 입력 프로시저
CREATE or replace PROCEDURE teacherInputAtt_proc
(
	pseq tblTotalScore.COURSE_SUBJECTSEQ%TYPE,
	pscNum tblTotalScore.STUDENT_COURSESEQ%TYPE,
	pattScore tblTotalScore.AttendanceScore%TYPE,
	pnum OUT NUMBER
)
IS
	vnum NUMBER;
BEGIN
	UPDATE TBLTOTALSCORE SET AttendanceScore = pattScore WHERE STUDENT_COURSESEQ = pscNum AND COURSE_SUBJECTSEQ = pseq;
	SELECT attendancepoint INTO vnum FROM TBLSCOREPOINT WHERE seq = pseq;

	IF pattScore <= vnum THEN
		pnum := 0;
		COMMIT;
	ELSE
		pnum := vnum;
		ROLLBACK;
	END IF;
END;

-- 교사 성적 입출력 -> 필기 점수 입력 프로시저
CREATE or replace PROCEDURE teacherInputwriting_proc
(
	pseq tblTotalScore.COURSE_SUBJECTSEQ%TYPE,
	pscNum tblTotalScore.STUDENT_COURSESEQ%TYPE,
	pwritingScore tblTotalScore.WRITINGSCORE%TYPE,
	pnum OUT NUMBER
)
IS
	vnum NUMBER;
BEGIN
	UPDATE TBLTOTALSCORE SET WRITINGSCORE = pwritingScore WHERE STUDENT_COURSESEQ = pscNum AND COURSE_SUBJECTSEQ = pseq;
	SELECT WRITINGPOINT INTO vnum FROM TBLSCOREPOINT WHERE seq = pseq;

	IF pwritingScore <= vnum THEN
		pnum := 0;
		COMMIT;
	ELSE
		pnum := vnum;
		ROLLBACK;
	END IF;
END;

-- 교사 성적 입출력 -> 실기 점수 입력 프로시저
CREATE or replace PROCEDURE teacherInputpractical_proc
(
	pseq tblTotalScore.COURSE_SUBJECTSEQ%TYPE,
	pscNum tblTotalScore.STUDENT_COURSESEQ%TYPE,
	ppracticalScore tblTotalScore.WRITINGSCORE%TYPE,
	pnum OUT NUMBER
)
IS
	vnum NUMBER;
BEGIN
	UPDATE TBLTOTALSCORE SET PRACTICALSCORE = ppracticalScore WHERE STUDENT_COURSESEQ = pscNum AND COURSE_SUBJECTSEQ = pseq;
	SELECT PRACTICALPOINT INTO vnum FROM TBLSCOREPOINT WHERE seq = pseq;

	IF ppracticalScore <= vnum THEN
		pnum := 0;
		COMMIT;
	ELSE
		pnum := vnum;
		ROLLBACK;
	END IF;
END;

-- 출결 조회 뷰
CREATE OR REPLACE VIEW vwAttendance
as	
SELECT
	c.COURSE_NAME AS courseName,
	ts.COURSESEQ AS courseNum,
	s.NAME AS studentName,
	to_char(att.DAYS, 'yyyy-mm-dd') AS days,
	to_char(att.INSIGAN, 'hh24:mi:ss') AS inTime,
	to_char(att.OUTSIGAN, 'hh24:mi:ss') AS outTime,
	CASE
		WHEN att.STATE = 1 THEN N'정상'
		WHEN att.STATE = 2 THEN N'지각'
		WHEN att.STATE = 3 THEN N'조퇴'
		WHEN att.STATE = 4 THEN N'외출'
		WHEN att.STATE = 5 THEN N'병가'
		WHEN att.STATE = 6 THEN N'결석'
		WHEN att.STATE = 7 THEN N'기타'
	END AS attState
FROM TBLSTUDENT s
	INNER JOIN TBLSTUDENT_COURSE ts
		ON s.LOGINSEQ = ts.STUDENTSEQ
	INNER JOIN TBLATTENDANCE att
		ON att.STUDENT_COURSESEQ = ts.SEQ
	INNER JOIN TBLCOURSE c
		ON ts.COURSESEQ = c.SEQ;

-- 교사 상담일지 작성 및 조회 -> 상담요청 조회 뷰
CREATE OR REPLACE VIEW vwcounselRequest
AS
SELECT 
	cr.SEQ AS counselNum,
	s.NAME AS studentName,
	cr.REQUSETMEMO AS requestMemo,
	TO_CHAR(cr.REQUESTDAY, 'yyyy-mm-dd') AS requestDay,
	l.ID AS teacherId,
	cr.REQUESTSTATE AS state
FROM TBLCOUNSELREQUEST cr
	INNER JOIN TBLTEACHER t
		ON t.LOGINSEQ = cr.TEACHERSEQ
	INNER JOIN TBLLOGIN l
		ON t.LOGINSEQ = l.SEQ
	INNER JOIN TBLSTUDENT s
		ON cr.STUDENTSEQ = s.LOGINSEQ;

-- 교사 상담요청목록 선택 프로시저
CREATE OR REPLACE PROCEDURE counselSelect_proc
(
	pCounselNum IN varchar2,
	pCounselMemo IN varchar2,
	pteacherId IN varchar2
)
IS
	vCounselTime DATE;
	vStudentName varchar2(100);
	vCounselRequestMemo varchar2(4000);
	vCounselRequest NUMBER;
	vTeacherSeq NUMBER;

BEGIN
	SELECT requestDay INTO vCounselTime FROM vwcounselRequest2 WHERE counselNum = pCounselNum;
	SELECT studentName INTO vStudentName FROM vwcounselRequest2 WHERE counselNum = pCounselNum;
	SELECT requestMemo INTO vCounselRequestMemo FROM vwcounselRequest2 WHERE counselNum = pCounselNum;
	SELECT counselNum INTO vCounselRequest FROM vwcounselRequest2 WHERE counselNum = pCounselNum;
	SELECT seq INTO vTeacherSeq FROM TBLLOGIN WHERE id = pteacherId;
	
	INSERT INTO TBLCOUNSEL VALUES (counsel_seq.nextVal, vCounselTime, pCounselMemo, vStudentName, vCounselRequestMemo, vCounselRequest, vTeacherSeq);
    UPDATE TBLCOUNSELREQUEST SET requestState = '완료' WHERE seq = vCounselRequest;
END;

-- 교사 상담일지 조회 뷰
CREATE OR REPLACE VIEW vwcounselInfo
AS
SELECT 
	l.ID AS teacherId,
	c.SEQ AS counselNum,
	c.studentName AS studentName,
	c.COUNSELREQUESTMEMO AS requestMemo,
	to_char(c.COUNSELTIME, 'yyyy-mm-dd') AS counselTime,
	c.COUNSELMEMO AS counselMemo
FROM TBLCOUNSEL c
	INNER JOIN TBLTEACHER t
		ON 	c.TEACHERSEQ = t.LOGINSEQ
	INNER JOIN TBLLOGIN l
		ON l.SEQ = t.LOGINSEQ;
SELECT * FROM TBLCOUNSEL;