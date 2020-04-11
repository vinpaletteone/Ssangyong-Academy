---------------------교육생 프로시저------------------------------
-------------------입실시간 입력하기 프로시저-----------------------------              		
create or replace procedure procAttendin
(
	pid IN varchar2,	--회원 가입한 아이디
	presult OUT NUMBER	
)
is		
	vseq NUMBER;
	vinsigan DATE;
begin
	-- A001.1 자신의 학생과정 seq를 받는다 -> vseq에 저장	
   SELECT  sc.SEQ, att.INSIGAN INTO vseq ,vinsigan
   FROM TBLSTUDENT s
      INNER JOIN TBLLOGIN c
         ON c.SEQ = s.LOGINSEQ
            INNER JOIN TBLSTUDENT_COURSE sc
               ON sc.STUDENTSEQ = s.LOGINSEQ
               	INNER JOIN TBLATTENDANCE att
               		ON sc.SEQ = att.STUDENT_COURSESEQ
              WHERE c.ID = pid AND to_char(att.DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd')
             AND sc.FAILCOURSE=1; 
	-- A001.2 
	IF vinsigan IS NULL
    THEN
  	presult :=1;  
	if
	to_number(to_char(sysdate, 'hh24mi')) BETWEEN 911 AND 1400  then		
	UPDATE 
		TBLATTENDANCE
			SET INSIGAN = sysdate, STATE =2 WHERE STUDENT_COURSESEQ = vseq AND 
						to_char(DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');
	ELSIF
	to_number(to_char(sysdate, 'hh24mi')) >= 1400 THEN
	UPDATE 
		TBLATTENDANCE
			SET INSIGAN = sysdate, STATE =6 WHERE STUDENT_COURSESEQ = vseq AND 
						to_char(DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');	
	ELSE
	UPDATE 
		TBLATTENDANCE
			SET INSIGAN = sysdate WHERE STUDENT_COURSESEQ = vseq AND 
						to_char(DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');				
	END IF;
	ELSIF vseq IS NULL THEN
	presult :=0;
	ELSE
	presult :=0;	
	END IF;
	exception
	when no_data_found then null;
	end;  
    
-----------------------퇴근찍기------------------------
create or replace procedure procAttendclose
(
	pid  varchar2	--회원 가입한 pw
	
)
is		
	vseq NUMBER;
	vinsigan DATE;
begin
	
	SELECT  sc.SEQ, att.INSIGAN INTO vseq ,vinsigan
   FROM TBLSTUDENT s
      INNER JOIN TBLLOGIN c
         ON c.SEQ = s.LOGINSEQ
            INNER JOIN TBLSTUDENT_COURSE sc
               ON sc.STUDENTSEQ = s.LOGINSEQ
               	INNER JOIN TBLATTENDANCE att
               		ON sc.SEQ = att.STUDENT_COURSESEQ
              WHERE c.ID = pid AND 
             to_char(att.DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');
           
	
	-- A001.2 910  1310
 IF (to_number(to_char(SYSDATE, 'hh24mi')) - to_number(to_char(vinsigan, 'hh24mi')))
		<400	
	THEN	
	UPDATE 
		TBLATTENDANCE
			SET OUTSIGAN = sysdate ,STATE = 6 WHERE STUDENT_COURSESEQ = vseq AND 
			to_char(DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');
 ELSIF to_number(to_char(vinsigan, 'hh24mi')) <911 AND 
 	   to_number(to_char(SYSDATE, 'hh24mi')) >=1750
    THEN    
    UPDATE
		TBLATTENDANCE
			SET OUTSIGAN = sysdate ,STATE = 1 WHERE STUDENT_COURSESEQ = vseq AND 
			to_char(DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');
 ELSIF to_number(to_char(vinsigan, 'hh24mi')) <911 AND 
 	   to_number(to_char(SYSDATE, 'hh24mi')) BETWEEN 1301 AND 1749 
 	THEN
 	
 	UPDATE
		TBLATTENDANCE
			SET OUTSIGAN = sysdate ,STATE = 3 WHERE STUDENT_COURSESEQ = vseq AND 
			to_char(DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd'); 	
 ELSE 
 	IF  to_number(to_char(vinsigan, 'hh24mi')) >=911 AND 
 	    to_number(to_char(SYSDATE, 'hh24mi')) >=1750
 	THEN 
 	UPDATE
		TBLATTENDANCE
			SET OUTSIGAN = sysdate, STATE=2 WHERE STUDENT_COURSESEQ = vseq AND 
			to_char(DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');
 	
 	ELSE
 	UPDATE
		TBLATTENDANCE
			SET OUTSIGAN = sysdate WHERE STUDENT_COURSESEQ = vseq AND 
			to_char(DAYS, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');
		END IF;
		END IF;	
end;

---------상담요청 프로시저--------------
create or replace procedure procCouncel
(
   pid varchar2,      --회원 가입한 pw
   prequestDay DATE,   --상담요청날짜
   prequestMemo varchar2   --상담내용
     
)
is
      --아이디 중복 검사 결과
   vloginSeq NUMBER;
   vteacherSeq NUMBER;
   
begin
   -- A001.1 비밀번호로 이름과 로그인번호 가져오기
   
   select s.loginSeq INTO vloginSeq 
   from TBLSTUDENT s   
   INNER JOIN TBLLOGIN l
      ON l.SEQ =s.LOGINSEQ
         where l.ID = pid;     
   SELECT
   (
SELECT
   ts.TEACHERSEQ
FROM TBLSTUDENT s
   INNER JOIN TBLSTUDENT_COURSE sc
      ON sc.STUDENTSEQ = s.LOGINSEQ
   INNER JOIN TBLCOURSE c
      ON sc.COURSESEQ = c.SEQ
   INNER JOIN TBLCOURSE_SUBJECT cs
      ON cs.COURSE_SEQ = c.SEQ
   INNER JOIN TBLTEACHER_SUBJECT ts
      ON ts.COURSE_SUBJECTSEQ = cs.SEQ
   INNER JOIN TBLLOGIN l
      ON l.SEQ = s.LOGINSEQ
WHERE l.ID = pid
GROUP BY ts.TEACHERSEQ) INTO vteacherSeq FROM dual;   
      -- A001.2 상담 정보 입력받기
      insert into TBLCOUNSELREQUEST 
      values (counselrequest_seq.nextval,prequestDay, prequestMemo, vteacherSeq, vloginSeq);
      
END;

 --PROCEDURE
-- 교육생 정보 조회 프로시저
create or replace procedure proc_studentInfo(
  pid in varchar2, -- 자바에서 넘겨주면
  pname out varchar2,-- 4개를 돌려줌
  pcoursename out varchar2,
  pcoursedate out varchar2,
  pclassname out varchar2
)
is
begin
  select 
    stu.name as name, 
    cor.course_name as coursename, 
    to_char(cor.startdate,'yyyy-mm-dd') || ' ~ ' || to_char(cor.enddate,'yyyy-mm-dd') as coursedate, 
    cla.class_name as classname
    into pname, pcoursename, pcoursedate, pclassname
        from tblStudent stu                                                                 -- 교육생
            inner join tblStudent_course scor on stu.loginseq = scor.studentseq             -- 과정 과목
                inner join tblcourse cor on scor.courseseq = cor.seq                        -- 과정
                    inner join tblClass cla on cor.class_seq = cla.seq  
                        inner join tbllogin log on log.seq = stu.loginseq
                          where log.id = pid;
end proc_studentInfo;

-- 교육생 성적 조회 프로시저
create or replace procedure proc_studentGrade(
    pid in varchar2,                 -- 로그인번호
    pcursor out SYS_REFCURSOR
)is
begin
   open pcursor for 
     select * from V_STUDENTSUBJECT where id = pid;
end;

-----교육생 뷰---------------------------------------------  
-----상담일지view----------
CREATE OR REPLACE VIEW viewcouncel
AS
select  
c.STUDENTNAME ,
TO_CHAR(cr.REQUESTDAY,'yyyy-mm-dd') AS reqday ,
TO_CHAR(c.COUNSELTIME,'yyyy-mm-dd') AS compday,
t.name AS tname,
c.COUNSELREQUESTMEMO ,
c.COUNSELMEMO,
l.ID,
C.SEQ
from tblstudent s
    inner join TBLCOUNSELREQUEST cr
        on s.LOGINSEQ = cr.STUDENTSEQ
        	INNER JOIN TBLCOUNSEL c
        		ON c.COUNSELREQUEST = cr.SEQ
            		INNER JOIN TBLTEACHER t
            			ON t.LOGINSEQ = c.TEACHERSEQ
            				INNER JOIN TBLLOGIN l
            					ON l.SEQ = s.LOGINSEQ;

------------자신의 전체 출결 뷰----------------------------------------
CREATE OR REPLACE VIEW VIEWAttendance
AS
SELECT
s.NAME ,
c.COURSE_NAME ,
TO_CHAR(att.DAYS ,'yyyy-mm-dd') AS attdate,
TO_CHAR(att.INSIGAN ,'hh24:mi:ss') AS ibsil,
TO_CHAR(att.OUTSIGAN ,'hh24:mi:ss') AS tasil,
l.ID,
CASE  
	 WHEN att.STATE =1 THEN N'정상'
	 WHEN att.STATE =2 THEN N'지각'
	 WHEN att.STATE =3 THEN N'조퇴'	
	 WHEN att.STATE =4 THEN N'외출'
	 WHEN att.STATE =5 THEN N'병가'
	 WHEN att.STATE =6 THEN N'결석'
	 WHEN att.STATE =7 THEN N'기타'
	 END AS attstat
from  tblStudent s
    inner join tblStudent_course stc 
        on s.LOGINSEQ = stc.STUDENTSEQ
            inner join tblAttendance att
                on att.STUDENT_COURSESEQ = stc.SEQ
                	INNER JOIN TBLCOURSE C
                		ON c.SEQ = stc.COURSESEQ
                			INNER JOIN TBLLOGIN l
                				ON l.SEQ = s.LOGINSEQ                 
                    	ORDER BY att.DAYS;
                        
                                