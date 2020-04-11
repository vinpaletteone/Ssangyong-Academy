--관리자 -> 교사계정관리
--유진
--교사수정시 정보 출력
select * from vwteacher_all order by loginseq asc;
create view vwteacher_all
as
select 
loginseq, name, jumin, tel, age, address, email,
case
    when state = 1 then '강의 예정'
    when state = 2 then '강의 중'
    when state = 3 then '강의 종료'
  end as state
from tblteacher;


--교사조회(seq,name,jumin,tel만 출력)
	select * from tblTeacher order by loginseq asc;

--교사조회시 출력 
	select * from vwsub  where loginseq =;
create view vwsub as
select t.loginseq as loginseq, s.subject_name as subject_name, s.seq as seq from tblteacher t
 left outer join tblteacher_subject ts
  on t.loginseq = ts.teacherseq
    left outer join tblsubject s
      on s.seq = ts.subject;

--교사 조회에서 특정교사 선택시 정보출력 
	select * from vwselteacher where loginseq = ;
create view vwsub as
select t.loginseq as loginseq, s.subject_name as subject_name, s.seq as seq from tblteacher t
 left outer join tblteacher_subject ts
  on t.loginseq = ts.teacherseq
    left outer join tblsubject s
      on s.seq = ts.subject;


--교사 등록 메소드
	--"{call proc_teacherInsert(?, ?, ?, ?, ?, ?, ?, ?)}";
create procedure proc_teacherInsert
(
  pname tblteacher.name%type,
  pjumin tblteacher.jumin%type,
  ptel tblteacher.tel%type,
  page tblteacher.age%type,
  paddress tblteacher.address%type,
  pemail tblteacher.email%type,
  pstate tblteacher.state%type,
  pnum out number

)
is
vnum number;
begin
    pnum:=1;
    select login_seq.nextval into vnum from dual;
  --1차업무
  insert into tbllogin values(vnum, pname, substr(pjumin,8,6), '2');
  
  --2차 업무
  insert into tblteacher values(vnum, pname, pjumin, ptel, page, paddress, pemail, pstate);
  pnum:=0;
  commit;
  
exception
  when others then
  pnum:=1;

   rollback;
    
end;


--교사 삭제 메소드
	delete from tblTeacher where loginseq = ;
	delete from tbllogin where seq = ;

--교사 수정 메소드
	--"{call proc_teacherEdit(?,?,?,?)}";
create procedure proc_teacherEdit
(
  psel1 number, --교사번호
  psel2 number, --수정할 번호
  pinput varchar2, --입력받은 것
  pnum out number
)
is
begin

  if psel2 = 1 then update tblteacher set name = pinput where loginseq = psel1;
  elsif psel2 = 2 then update tblteacher set state = pinput where loginseq = psel1;
  elsif psel2 = 3 then update tblteacher set jumin = pinput where loginseq = psel1;
  elsif psel2 = 4 then update tblteacher set tel = pinput where loginseq = psel1;
  elsif psel2 = 5 then update tblteacher set age = pinput where loginseq = psel1;
  elsif psel2 = 6 then update tblteacher set address = pinput where loginseq = psel1;
  elsif psel2 = 7 then update tblteacher set email = pinput where loginseq = psel1;
  pnum:=0;
   commit;
  
end if;
exception
  when others then
  pnum:=1;
  rollback;
end proc_teacherEdit;


--교사가능 과목 추가선택시 과목리스트 출력
	select * from vwTeacher_addSub;
create view vwselteacher
as
select 
  t.loginseq as loginseq,s.subject_name as subject_name, t.name,
  to_char(cs.startdate,'yyyy-mm-dd')||'~'||to_char(cs.enddate,'yyyy-mm-dd') as speriod,
  c.course_name as course_name,
  to_char(c.startdate,'yyyy-mm-dd')||'~'||to_char(c.enddate,'yyyy-mm-dd') as cperiod ,
  b.book_name as book_name,cl.class_name as class_name,
  case
    when t.state = 1 then '강의 예정'
    when t.state = 2 then '강의 중'
    when t.state = 3 then '강의 종료'
  end as state
from tblteacher t
 left outer join tblteacher_subject ts
   on t.loginseq=ts.teacherseq
     left outer join tblcourse_subject cs
       on  cs.seq=ts.course_subjectseq
        left outer join tblcourse c
          on c.seq=cs.course_seq
           left outer join tblclass cl
             on cl.seq=c.class_seq
              left outer join tblsubject s
                on s.seq=cs.subject_seq
                 left outer join tblbook b
                   on b.seq=s.book_seq;


--교사 강의가능 과목 추가 메소드
	--"{call proc_teacherAddSub(?, ?, ?)}";
create procedure proc_teacherAddSub
(
  pteacherseq tblteacher_subject.teacherseq%type,
  psubseq tblteacher_subject.subject%type,
  pnum out number
)
is
  vnum number;
begin
    pnum:=123;
    select teacher_subject_seq.nextval into vnum from dual;
    pnum:=1111;
    insert into tblteacher_subject values(vnum, pteacherseq, null, psubseq);
    pnum:=0;

    commit;

exception
  when others then
  pnum:=1;
  rollback;
end;



--관리자 -> 취업통계-> 취업등록
--취업등록시 리스트 출력
	select * from vwjob_stat;
create or replace view vwjob_stat
as
select s.loginseq,s.name, 
case
    when e.seq is null then '미취업'
    else '취업'
end as state, e.companyname, e.yearpay, e.companyscale,to_char(e.employmentday,'yyyy-mm-dd') as employmentday,
c.course_name, c.seq as cseq
from tblstudent s left outer join TBLEMPLOYMENT e
on s.loginseq=e.studentSeq left outer join tblstudent_course sc
on s.loginseq = sc.studentSeq left outer join tblcourse c
on c.seq = sc.courseSeq
order by s.name;

--취업한 학생 등록 메소드
	insert into tblemployment values (employment_seq.nextval,?,?,?,?,?);	
    
--지성
--관리자 -> 개설 과정 관리
--특정과정 학생조회
	select * from vwStudent where courseSeq = ;
create or replace view vwstudent as
select s.loginseq as loginseq ,s.name as name, substr(s.jumin,8,6) as jumin, s.tel as tel, sc.regDate as regDate,
case
    when sc.failCourse = 1 then '수강중'
    when sc.failCourse = 2 then '중도탈락'
    when sc.failCourse = 3 then '수료'
    when sc.failCourse = 4 then '수강신청'
end as state, courseSeq as courseSeq
from tblStudent s inner join tblStudent_Course sc
on s.loginSeq =sc.studentSeq
where courseSeq=1;


--과정 전체 조회
	select * from vwCourse; 
create view vwCourse 
as
select distinct (aa.course_name) as name,aa.startdate as startDate , aa.enddate as endDate, aa.regist_total as registStudent, aa.class_name as classRoom,
    case 
        when tj.seq is null then '과목미등록'
        else '과목등록' 
    end as registSubject, aa.seq as "courseSeq"
from tblcourse_subject tj right outer join (select r.class_name, c.seq,c.course_name, c.startdate, c.enddate,c.regist_total from tblcourse c inner join tblclass r
    on c.class_seq=r.seq) aa
    on tj.course_seq = aa.seq order by aa.seq asc;


--과정에 속해있는 과목의 리스트 및 모든학생 점수 등록여부
	select * from vwSubject where courseSeq = ;
create or replace view vwSubject
as
select s.seq as seq, s.subject_name as subject_name,b.book_name as book_name, b.author as author , t.name as teacher, cs.course_seq as courseSeq, cs.seq as csSeq
from tblcourse_subject cs left outer join tblsubject s
    on s.seq=cs.subject_seq left outer join tblbook b
    on b.seq=s.book_seq left outer join tblteacher_subject ts
    on ts.course_subjectseq= cs.seq left outer join tblteacher t
    on t.loginseq = ts.teacherseq
order by s.seq;


	select * from vwScorereg where cseq=;
create or replace view vwScorereg
as
select 
case
    when writingscore is not null and practicalscore is not null and attendancescore is not null then 'x'
end as regScore,
csseq as cseq
from vwstuScore;

--과정 추가
	INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, ?, ?, ?, 0, ?);


--과정 삭제
	 delete from TBLCOURSE_Subject where seq = ;


--과정 수정
	update TBLCOURSE set course_name=? where seq =;
create procedure proc_courseEdit
(
  pnum number, --과정번호
  psel number, --수정할 번호
  pinput varchar2, --입력할내용
  pout out number
)
is
begin

  if psel = 1 then update tblcourse set startdate = pinput where seq = pnum;
  elsif psel = 2 then update tblcourse set enddate = pinput where seq = pnum;
  elsif psel = 3 then update tblcourse set regist_total = pinput where seq = pnum;
  elsif psel = 4 then update tblcourse set class_seq = pinput where seq = pnum;
  elsif psel = 5 then update tblcourse set course_name = pinput where seq = pnum;
  pout:=1;
   commit;
  
end if;
exception
  when others then
  pout:=0;
  rollback;
end proc_courseEdit;


--과정 듣는 학생 수료 처리
	update TBLStudent_Course set failCourse=? where StudentSeq =  ;


--과정에 속한 과목 추가하기
	--"{call proc_csInsert(?, ?, ?, ?, ?)}";
create or replace procedure proc_csInsert
(
  psubjectSeq tblCourse_Subject.SUBJECT_SEQ%type,
  pcourseSeq tblCourse_Subject.COURSE_SEQ%type,
  pstartDate tblCourse_Subject.startdate%type,
  pendDate tblCourse_Subject.enddate%type,
  presult out number

)
is
vscorepointSeq number;
begin
    presult:=1;
    select scorepoint_seq.nextVal into vscorepointSeq from dual;
  --1차업무
  insert into tblscorepoint values(vscorepointSeq, null,null,null,null,null);
  
  --2차 업무
  insert into tblCourse_Subject values(COURSE_SUBJECT_SEQ.nextval, psubjectSeq, pcourseSeq, vscorepointSeq, pstartDate, pendDate);
  presult:=0;
  commit;
  
exception
    when others then
    presult:=1;
    rollback;
    
end;


--과목전체조회
	select * from vwSubject;
create or replace view vwSubject
as
select s.seq as seq, s.subject_name as subject_name,b.book_name as book_name, b.author as author , t.name as teacher, cs.course_seq as courseSeq, cs.seq as csSeq
from tblcourse_subject cs left outer join tblsubject s
    on s.seq=cs.subject_seq left outer join tblbook b
    on b.seq=s.book_seq left outer join tblteacher_subject ts
    on ts.course_subjectseq= cs.seq left outer join tblteacher t
    on t.loginseq = ts.teacherseq
order by s.seq;


-- 과정에 속한 과목 삭제
	delete from TBLCOURSE_Subject where seq = ;


--과정 -> 과목 -> 학생성적조회 (과정에 속한 과목 안 학생의 성적 조회)
	 select * from vwStuScore where cseq= ? and sseq= ;
create or replace view vwStuScore
as

select stu.name as student_name,substr(stu.jumin,8,7) as jumin,c.course_name, to_char(c.startdate, 'yyyy-mm-dd') as cstartdate, 
to_char(c.enddate,'yyyy-mm--dd') as cenddate,s.subject_name as subject_name, to_char(cs.startdate,'yyyy-mm-dd') as csstartdate,
to_char(cs.enddate,'yyyy-mm-dd') as csenddate,ts.attendancescore,ts.writingscore,ts.practicalscore, c.seq as cseq,teas.subject as sseq, cs.seq as csseq,
case
    when ts.writingscore is not null and ts.practicalscore is not null and ts.attendancescore is not null then '등록'
    else '미등록'
end as regscore, stu.loginseq
from tblcourse_Subject cs left outer join tbltotalScore ts
on cs.seq = ts.course_subjectseq inner join tblCourse c
on c.seq = cs.course_seq inner join tblTeacher_subject teas
on teas.course_subjectseq = cs.seq inner join tblsubject s
on s.seq=teas.subject right outer join tblStudent_Course sc
on sc.seq = ts.student_courseseq right outer join tblStudent stu
on stu.loginseq = sc.studentseq
order by student_name;


--모든 학생 조회 (성적)
	-select * from vwstudent2;
create or replace view vwstudent2
as
select loginseq,name,jumin,tel,age,courseCount,
case
    when employmentstate = 1 then '취업'
    when employmentstate = 2 then '수강중'
    when employmentstate = 3 then '미취업'
    when employmentstate = 4 then '수강대기'
end as employmentstate
from tblStudent;



--특정 학생의 모든 성적 조회
	 select * from vwStuScore where loginseq=;
create or replace view vwStuScore
as

select stu.name as student_name,substr(stu.jumin,8,7) as jumin,c.course_name, to_char(c.startdate, 'yyyy-mm-dd') as cstartdate, 
to_char(c.enddate,'yyyy-mm--dd') as cenddate,s.subject_name as subject_name, to_char(cs.startdate,'yyyy-mm-dd') as csstartdate,
to_char(cs.enddate,'yyyy-mm-dd') as csenddate,ts.attendancescore,ts.writingscore,ts.practicalscore, c.seq as cseq,teas.subject as sseq, cs.seq as csseq,
case
    when ts.writingscore is not null and ts.practicalscore is not null and ts.attendancescore is not null then '등록'
    else '미등록'
end as regscore, stu.loginseq
from tblcourse_Subject cs left outer join tbltotalScore ts
on cs.seq = ts.course_subjectseq inner join tblCourse c
on c.seq = cs.course_seq inner join tblTeacher_subject teas
on teas.course_subjectseq = cs.seq inner join tblsubject s
on s.seq=teas.subject right outer join tblStudent_Course sc
on sc.seq = ts.student_courseseq right outer join tblStudent stu
on stu.loginseq = sc.studentseq
order by student_name;



--관리자->취업통계
--모든 학생 취업 조회
	select * from vwjob_stat;
create or replace view vwjob_stat
as
select s.loginseq,s.name, 
case
    when e.seq is null then '미취업'
    else '취업'
end as state, e.companyname, e.yearpay, e.companyscale,to_char(e.employmentday,'yyyy-mm-dd') as employmentday,
c.course_name, c.seq as cseq
from tblstudent s left outer join TBLEMPLOYMENT e
on s.loginseq=e.studentSeq left outer join tblstudent_course sc
on s.loginseq = sc.studentSeq left outer join tblcourse c
on c.seq = sc.courseSeq
order by s.name;


--특정 과정 학생들 취업 조회
	select * from vwjob_stat where cseq =;
create or replace view vwjob_stat
as
select s.loginseq,s.name, 
case
    when e.seq is null then '미취업'
    else '취업'
end as state, e.companyname, e.yearpay, e.companyscale,to_char(e.employmentday,'yyyy-mm-dd') as employmentday,
c.course_name, c.seq as cseq
from tblstudent s left outer join TBLEMPLOYMENT e
on s.loginseq=e.studentSeq left outer join tblstudent_course sc
on s.loginseq = sc.studentSeq left outer join tblcourse c
on c.seq = sc.courseSeq
order by s.name;

--지성
--관리자 -> 개설 과정 관리
--특정과정 학생조회
	select * from vwStudent where courseSeq = ;
-create or replace view vwstudent as
select s.loginseq as loginseq ,s.name as name, substr(s.jumin,8,6) as jumin, s.tel as tel, sc.regDate as regDate,
case
    when sc.failCourse = 1 then '수강중'
    when sc.failCourse = 2 then '중도탈락'
    when sc.failCourse = 3 then '수료'
    when sc.failCourse = 4 then '수강신청'
end as state, courseSeq as courseSeq
from tblStudent s inner join tblStudent_Course sc
on s.loginSeq =sc.studentSeq
where courseSeq=1;


--과정 전체 조회
	select * from vwCourse ;
create view vwCourse 
as
select distinct (aa.course_name) as name,aa.startdate as startDate , aa.enddate as endDate, aa.regist_total as registStudent, aa.class_name as classRoom,
    case 
        when tj.seq is null then '과목미등록'
        else '과목등록' 
    end as registSubject, aa.seq as "courseSeq"
from tblcourse_subject tj right outer join (select r.class_name, c.seq,c.course_name, c.startdate, c.enddate,c.regist_total from tblcourse c inner join tblclass r
    on c.class_seq=r.seq) aa
    on tj.course_seq = aa.seq order by aa.seq asc;


--과정에 속해있는 과목의 리스트 및 모든학생 점수 등록여부
	select * from vwSubject where courseSeq = ;
create or replace view vwSubject
as
select s.seq as seq, s.subject_name as subject_name,b.book_name as book_name, b.author as author , t.name as teacher, cs.course_seq as courseSeq, cs.seq as csSeq
from tblcourse_subject cs left outer join tblsubject s
    on s.seq=cs.subject_seq left outer join tblbook b
    on b.seq=s.book_seq left outer join tblteacher_subject ts
    on ts.course_subjectseq= cs.seq left outer join tblteacher t
    on t.loginseq = ts.teacherseq
order by s.seq;


	select * from vwScorereg where cseq=;
create or replace view vwScorereg
as
select 
case
    when writingscore is not null and practicalscore is not null and attendancescore is not null then 'x'
end as regScore,
csseq as cseq
from vwstuScore;

--과정 추가
	INSERT INTO TBLCOURSE VALUES (course_seq.nextVal, ?, ?, ?, 0, ?);


--과정 삭제
	 delete from TBLCOURSE_Subject where seq = "+num;


--과정 수정
	--"update TBLCOURSE set course_name=? where seq =" + num;
create procedure proc_courseEdit
(
  pnum number, --과정번호
  psel number, --수정할 번호
  pinput varchar2, --입력할내용
  pout out number
)
is
begin

  if psel = 1 then update tblcourse set startdate = pinput where seq = pnum;
  elsif psel = 2 then update tblcourse set enddate = pinput where seq = pnum;
  elsif psel = 3 then update tblcourse set regist_total = pinput where seq = pnum;
  elsif psel = 4 then update tblcourse set class_seq = pinput where seq = pnum;
  elsif psel = 5 then update tblcourse set course_name = pinput where seq = pnum;
  pout:=1;
   commit;
  
end if;
exception
  when others then
  pout:=0;
  rollback;
end proc_courseEdit;


--과정 듣는 학생 수료 처리
	update TBLStudent_Course set failCourse=? where StudentSeq = ?" ;


--과정에 속한 과목 추가하기
	"{call proc_csInsert(?, ?, ?, ?, ?)}";
create or replace procedure proc_csInsert
(
  psubjectSeq tblCourse_Subject.SUBJECT_SEQ%type,
  pcourseSeq tblCourse_Subject.COURSE_SEQ%type,
  pstartDate tblCourse_Subject.startdate%type,
  pendDate tblCourse_Subject.enddate%type,
  presult out number

)
is
vscorepointSeq number;
begin
    presult:=1;
    select scorepoint_seq.nextVal into vscorepointSeq from dual;
  --1차업무
  insert into tblscorepoint values(vscorepointSeq, null,null,null,null,null);
  
  --2차 업무
  insert into tblCourse_Subject values(COURSE_SUBJECT_SEQ.nextval, psubjectSeq, pcourseSeq, vscorepointSeq, pstartDate, pendDate);
  presult:=0;
  commit;
  
exception
    when others then
    presult:=1;
    rollback;
    
end;


--과목전체조회
	select * from vwSubject;
create or replace view vwSubject
as
select s.seq as seq, s.subject_name as subject_name,b.book_name as book_name, b.author as author , t.name as teacher, cs.course_seq as courseSeq, cs.seq as csSeq
from tblcourse_subject cs left outer join tblsubject s
    on s.seq=cs.subject_seq left outer join tblbook b
    on b.seq=s.book_seq left outer join tblteacher_subject ts
    on ts.course_subjectseq= cs.seq left outer join tblteacher t
    on t.loginseq = ts.teacherseq
order by s.seq;


-- 과정에 속한 과목 삭제
	-"delete from TBLCOURSE_Subject where seq = ? ";


--과정 -> 과목 -> 학생성적조회 (과정에 속한 과목 안 학생의 성적 조회)
	 -"select * from vwStuScore where cseq= ? and sseq= ? ";
create or replace view vwStuScore
as

select stu.name as student_name,substr(stu.jumin,8,7) as jumin,c.course_name, to_char(c.startdate, 'yyyy-mm-dd') as cstartdate, 
to_char(c.enddate,'yyyy-mm--dd') as cenddate,s.subject_name as subject_name, to_char(cs.startdate,'yyyy-mm-dd') as csstartdate,
to_char(cs.enddate,'yyyy-mm-dd') as csenddate,ts.attendancescore,ts.writingscore,ts.practicalscore, c.seq as cseq,teas.subject as sseq, cs.seq as csseq,
case
    when ts.writingscore is not null and ts.practicalscore is not null and ts.attendancescore is not null then '등록'
    else '미등록'
end as regscore, stu.loginseq
from tblcourse_Subject cs left outer join tbltotalScore ts
on cs.seq = ts.course_subjectseq inner join tblCourse c
on c.seq = cs.course_seq inner join tblTeacher_subject teas
on teas.course_subjectseq = cs.seq inner join tblsubject s
on s.seq=teas.subject right outer join tblStudent_Course sc
on sc.seq = ts.student_courseseq right outer join tblStudent stu
on stu.loginseq = sc.studentseq
order by student_name;


--모든 학생 조회 (성적)
	-"select * from vwstudent2";
create or replace view vwstudent2
as
select loginseq,name,jumin,tel,age,courseCount,
case
    when employmentstate = 1 then '취업'
    when employmentstate = 2 then '수강중'
    when employmentstate = 3 then '미취업'
    when employmentstate = 4 then '수강대기'
end as employmentstate
from tblStudent;



--특정 학생의 모든 성적 조회
	 -"select * from vwStuScore where loginseq=?";
create or replace view vwStuScore
as

select stu.name as student_name,substr(stu.jumin,8,7) as jumin,c.course_name, to_char(c.startdate, 'yyyy-mm-dd') as cstartdate, 
to_char(c.enddate,'yyyy-mm--dd') as cenddate,s.subject_name as subject_name, to_char(cs.startdate,'yyyy-mm-dd') as csstartdate,
to_char(cs.enddate,'yyyy-mm-dd') as csenddate,ts.attendancescore,ts.writingscore,ts.practicalscore, c.seq as cseq,teas.subject as sseq, cs.seq as csseq,
case
    when ts.writingscore is not null and ts.practicalscore is not null and ts.attendancescore is not null then '등록'
    else '미등록'
end as regscore, stu.loginseq
from tblcourse_Subject cs left outer join tbltotalScore ts
on cs.seq = ts.course_subjectseq inner join tblCourse c
on c.seq = cs.course_seq inner join tblTeacher_subject teas
on teas.course_subjectseq = cs.seq inner join tblsubject s
on s.seq=teas.subject right outer join tblStudent_Course sc
on sc.seq = ts.student_courseseq right outer join tblStudent stu
on stu.loginseq = sc.studentseq
order by student_name;



--관리자->취업통계
--모든 학생 취업 조회
	-"select * from vwjob_stat";
create or replace view vwjob_stat
as
select s.loginseq,s.name, 
case
    when e.seq is null then '미취업'
    else '취업'
end as state, e.companyname, e.yearpay, e.companyscale,to_char(e.employmentday,'yyyy-mm-dd') as employmentday,
c.course_name, c.seq as cseq
from tblstudent s left outer join TBLEMPLOYMENT e
on s.loginseq=e.studentSeq left outer join tblstudent_course sc
on s.loginseq = sc.studentSeq left outer join tblcourse c
on c.seq = sc.courseSeq
order by s.name;


--특정 과정 학생들 취업 조회
	"select * from vwjob_stat where cseq = ?";
create or replace view vwjob_stat
as
select s.loginseq,s.name, 
case
    when e.seq is null then '미취업'
    else '취업'
end as state, e.companyname, e.yearpay, e.companyscale,to_char(e.employmentday,'yyyy-mm-dd') as employmentday,
c.course_name, c.seq as cseq
from tblstudent s left outer join TBLEMPLOYMENT e
on s.loginseq=e.studentSeq left outer join tblstudent_course sc
on s.loginseq = sc.studentSeq left outer join tblcourse c
on c.seq = sc.courseSeq
order by s.name;

--수빈
create or replace view v_subjectselect as
select * from 
(select
    ROWNUM as rownum2,
    c.course_name as coursename,
    to_char(c.startdate,'yyyy-mm-dd') || ' ~ ' || to_char(c.enddate,'yyyy-mm-dd') as coursedate,
    cla.class_name as classname,
    s.subject_name as subjectname,
    to_char(cs.startdate,'yyyy-mm-dd') || ' ~ ' || to_char(cs.enddate,'yyyy-mm-dd') as subjectdate,
    b.book_name as bookname,
    tea.name as teachername
        from tblcourse c                                                                                -- 과정          
            left outer join tblClass cla on cla.seq = c.class_seq                                            -- 강의실
                left outer join tblCourse_Subject cs on cs.subject_seq = c.seq                               -- 과정 과목 
                    left outer join tblSubject s on s.seq = cs.subject_seq                                   -- 과목
                        left outer join tblBook b on b.seq = s.book_seq                                      -- 교재
                            left outer join tblTeacher_subject tsub on tsub.subject = cs.subject_seq
                                left outer join tblteacher tea on tea.loginseq = tsub.teacherseq);

create or replace view v_student as
select 
    loginseq as loginseq,
    name as name,
    substr(jumin, 8, 7) as jumin,
    tel as tel,
    coursecount as coursecount
        from tblstudent;

create or replace view v_studentone as
select 
    t.name as name, --이름
    t.coursecount as coursecount, --수강신청 횟수
    c.course_name as course_name, --과정명
    to_char(startdate,'yyyy-mm-dd') || ' ~ ' || to_char(enddate,'yyyy-mm-dd') as course_date, --과정기간
    cla.class_name as class_name, --강의실명
    case -- sysdate - startdate
        when sc.failcourse = 1 then '수료중'
        when sc.failcourse = 2 then '중도탈락'
        when sc.failcourse = 3 then '수료'
        when sc.failcourse = 4 then '수강신청'
        --when sc.failcourse not in (1,2,3) and startdate- sysdate > 0 then '수강신청' 
    end as failcourse --중도탈락여부
    -- 중도탈락 날짜, 테이블에 없어서 뺐음
        from tblstudent t                                                                             -- 교육생
            left outer join tblStudent_course sc on sc.studentseq = t.loginseq                             -- 교육생 과정
                left outer join tblcourse c on c.seq = sc.courseSeq                                        -- 과정
                    left outer join tblClass cla on cla.seq = c.class_seq;                                  -- 강의실    

create or replace procedure proc_studentInsert
(
  pname tblstudent.name%type,
  pjumin tblstudent.jumin%type,
  ptel tblstudent.tel%type,
  page tblstudent.age%type,
  paddress tblstudent.address%type,
  pemail tblstudent.email%type,
  pnum out number
)
is
vnum number;
begin
    pnum:=1;
    select login_seq.nextval into vnum from dual;
  --1차업무
  insert into tbllogin values(vnum, pname, substr(pjumin,8,6), '3');
  
  --2차 업무
  insert into tblstudent values(vnum, pname, pjumin, ptel, page, paddress, pemail, 0, 4);
  pnum:=0;
  commit;
  
exception
  when others then
  pnum:=1;

   rollback;
    
end;

create procedure proc_studentUpdate
(
  psel1 number, --교사번호
  psel2 number, --수정할 번호
  pinput varchar2, --입력받은 것
  pnum out number
)
is
begin

  if psel2 = 1 then update tblstudent set name = pinput where loginseq = psel1; --이름
  elsif psel2 = 2 then update tblstudent set jumin = pinput where loginseq = psel1; --주민번호
  elsif psel2 = 3 then update tblstudent set tel = pinput where loginseq = psel1; --전화번호
  elsif psel2 = 4 then update tblstudent set age = pinput where loginseq = psel1; --나이
  elsif psel2 = 5 then update tblstudent set address = pinput where loginseq = psel1; --주소
  elsif psel2 = 6 then update tblstudent set email = pinput where loginseq = psel1; --이메일
  pnum:=0;
   commit;
  
end if;
exception
  when others then
  pnum:=1;
  rollback;
end proc_studentUpdate;

create or replace view v_student_failcourse as
select 
    tc.seq as seq,
    s.loginseq as loginseq,
    s.name as name, 
    case 
        when tc.failcourse = 1 then '수료중'
        when tc.failcourse = 2 then '중도탈락'
        when tc.failcourse = 3 then '수료'
        when tc.failcourse = 4 then '수강신청'
    end  as failcourse 
    from tblstudent s
    inner join tblStudent_course tc on tc.studentSeq = s.loginseq;
 
create or replace view v_studnetCourse as
select 
    s.name as name, 
    c.course_name as coursename,
    recourse as recourse, --재수강여부
    case 
        when sc.failcourse = 1 then '수료중'
        when sc.failcourse = 2 then '중도탈락'
        when sc.failcourse = 3 then '수료'
        when sc.failcourse = 4 then '수강신청'
    end  as failcourse
from tblstudent s 
    inner join tblstudent_course sc on s.loginseq = sc.studentseq
        inner join tblcourse c on c.seq = sc.courseseq;

create or replace procedure proc_studentCourseInsert
(
  pcourseseq in tblstudent_course.courseseq%type, --과정번호
  pstudentseq in tblstudent_course.studentseq%type, --학생번호
  pnum out number -- 반환 
)
is
vnum number; -- student_course_seq, 교육생 과정 seq
vloginseq number; -- loginseq, 교육생번호
vcoursecount number; -- coursecount, 수강신청횟수
vrecourse number; -- recourse, 재수강여부
vregist_total number; -- 과정총인원수
vrecoursecount number; --재수강 카운트
--cursor vcursor is select courseSeq from v_studentcourseSeq where loginseq = pstudentseq;
vcourseSeq number;
vflag number;
vtemp number;
begin
    pnum:=0;
    select student_course_seq.nextval into vnum from dual; -- student_course_seq
    --dbms_output.put_line('vnum : ' || vnum);
    
    select coursecount into vcoursecount from tblstudent where loginseq = pstudentseq; --수강신청횟수
   -- dbms_output.put_line(vcoursecount);
   

    select count(*) into vrecourse from tblstudent_course where studentseq = pstudentseq; --재수강횟수
    --dbms_output.put_line(vrecourse);
    
    if vcoursecount = 0 then
        vrecourse := 0;
    else 
        
        for vrow in (select * from v_studentcourseSeq where loginseq = pstudentseq) loop 
               
            if pcourseseq =vrow.courseseq then 
            vflag :=1;
            else vflag :=0;
            end if;
            exit when vflag=1;
            
        end loop;
        
        if vflag =1 then vrecourse := 1;
        else vrecourse := 0;
        end if;
        
    end if;
    
   
    
  --1차업무
    insert into tblstudent_course values(vnum, 4, null, vrecourse, pcourseseq, pstudentseq, sysdate); 
                                      -- seq, failcourse, failday, recourse, courseseq, studentseq, regdate
                                      
--    select max(vnum) into vtemp from  tblstudent_course;
--    dbms_output.put_line('vtemp : ' || vtemp);
    
   --2차업무
    --과정에 등록인원 가져오기
    select regist_total into vregist_total from tblcourse where seq = pcourseseq ;
    update tblcourse set regist_total = vregist_total + 1 where seq = pcourseseq;
     
--    dbms_output.put_line(vregist_total);
  
  --3차 업무
  select courseCount into vcoursecount from tblstudent where loginseq = pstudentseq; --수강신청횟수
    if vcoursecount >= 1 then
        update tblstudent set coursecount = vcoursecount+1 where loginseq = pstudentseq;    
    else 
        update tblstudent set coursecount = 1 where loginseq = pstudentseq;   
    end if;
    
  --4차 업무
  
  for vrow in (select * from tblcourse_subject where course_seq = pcourseseq) loop 
            
            select max(vnum) into vtemp from  tblstudent_course;
            dbms_output.put_line('vtemp : ' || vtemp);
                
            dbms_output.put_line('vrow.seq : ' || vrow.seq);
            dbms_output.put_line('vnum : ' || vnum);
            
            --vrow.seq 과정 과목 seq, 
            --vnum 교육생 과정 번호
            insert into tbltotalscore values(totalscore_seq.nextVal, null, null, null, vnum, vrow.seq); 
            dbms_output.put_line('테스트');                
            
    end loop;
  

   
 
  pnum:=1; --성공
  commit;
  
exception
  when others then
    pnum:=0; --실패
    dbms_output.put_line(SQLERRM);
   rollback;
    
end;

create or replace procedure proc_studentInsert
(
  pname tblstudent.name%type,
  pjumin tblstudent.jumin%type,
  ptel tblstudent.tel%type,
  page tblstudent.age%type,
  paddress tblstudent.address%type,
  pemail tblstudent.email%type,
  pnum out number
)
is
vnum number;
begin
    pnum:=1;
    select login_seq.nextval into vnum from dual;
  --1차업무
  insert into tbllogin values(vnum, pname, substr(pjumin,8,6), '3');

  --2차 업무
  insert into tblstudent values(vnum, pname, pjumin, ptel, page, paddress, pemail, 0, 4);
  pnum:=0;
  commit;

exception
  when others then
  pnum:=1;

   rollback;

end;

create or replace view v_studentcourseSeq as
select c.seq as courseseq, s.loginseq as loginseq from tblstudent s
    left outer join tblstudent_course sc on sc.studentseq = s.loginseq
        left outer join tblcourse c on c.seq = sc.courseseq;
