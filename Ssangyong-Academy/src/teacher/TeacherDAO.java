package teacher;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import commonDTO.TeacherDTO;
import main.DBUtil;
import oracle.jdbc.OracleTypes;
import teacher.teacherDTO.AttendanceDTO;
import teacher.teacherDTO.LoginDTO;
import teacher.teacherDTO.ScheduleDTO;
import teacher.teacherDTO.StudentDTO;
import teacher.teacherDTO.StudentSelDTO;

public class TeacherDAO {
//	public static void main(String[] args) {
//		teacherPointsDetail("12");
//	}
	//위임받는 모든 업무에서 공통으로 발생하는 작업
			private Connection conn;
			private Statement stat;
			private PreparedStatement pstat;
			private CallableStatement cstat;
			private ResultSet rs;
			private Scanner scan;
			
			public TeacherDAO() {
				
				scan = new Scanner(System.in);
				
				try {

					conn = DBUtil.open();
					stat = conn.createStatement();

				} catch (Exception e) {
					System.out.println("TeacherDAO.StudentDAO()" + e.toString());
				}
			}
	/**
	 * 교사 > 로그인
	 * @param id 교사명
	 * @param pw 주민번호
	 */
	public TeacherDTO login(String id, String pw) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
			
		try {
			conn = DBUtil.open();
			String sql = "SELECT seq FROM tblTeacher WHERE name = ? AND ssn = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, id);
			stat.setString(2, pw);
			
			rs = stat.executeQuery();
								
			if(rs.next()) {
				TeacherDTO dto = new TeacherDTO();
				dto.setSeq(rs.getString("seq"));
				
				
				return dto;
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 교사 > 강의 스케쥴 출력
	 * 교실명, 과정명, 과정기간, 과목번호, 과목명, 과목기간, 교재명, 배점
	 * @param seq 교사번호
	 */
	public void schedule(TeacherDTO seq) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			String sql = "SELECT seq FROM tblTeacher WHERE name = ? AND ssn = ?";
			stat = conn.prepareStatement(sql);
			
//			stat.setString(1, id);
//			stat.setString(2, pw);
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("seq"));
				TeacherDTO dto = new TeacherDTO();
				dto.setSeq(rs.getString("seq"));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 교사 > ProcTscheduleDTO에 값을 담아주는 메소드
	 * 	- 교실명, 과정명, 과정기간, 과목번호, 과목명, 과목기간, 교재명, 배점
	 * @param seq 교사번호
	 * @return 
	 */
	public ArrayList<ProcTPointsDTO> teacherPoints(String seq) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		//PreparedStatement stat = null;
		
		try {
			conn = DBUtil.open();
			
			String sql = "{call procTPoints(?, ?)}"; //프로시저 실행
			stat = conn.prepareCall(sql);
			stat.setString(1, seq);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2); //ResultSet에 프로시저 결과 담기
			
			ArrayList<ProcTPointsDTO> list = new ArrayList<ProcTPointsDTO>();
			
			while(rs.next()) { //프로시저 결과 DTO에 담기
				ProcTPointsDTO proc = new ProcTPointsDTO();
				proc.setClassName(rs.getString("classname"));
				proc.setProcessName(rs.getString("processname"));
				proc.setProcessStart(rs.getString("processstart"));
				proc.setProcessEnd(rs.getString("processend"));
				proc.setSubjectSeq(rs.getString("subjectseq"));
				proc.setSubjectName(rs.getString("subjectname"));
				proc.setSubjectStart(rs.getString("subjectstart"));
				proc.setSubjectEnd(rs.getString("subjectend"));
				proc.setBookName(rs.getString("bookname"));
				proc.setAttendancePoints(rs.getString("attendancepoints"));
				proc.setWritePoints(rs.getString("writepoints"));
				proc.setPracticalPoints(rs.getString("practicalpoints"));
				proc.setTaskPoints(rs.getString("taskspoints"));
				
				list.add(proc);
			}
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 교사 > 배점상세화면
	 * @param seq 교사번호
	 * @return
	 */
	public ArrayList<ProcTPointsDetailDTO> teacherPointsDetail(String seq) {
		Connection conn = null;
		CallableStatement stat = null;
//		ResultSet rs = null;
		try {
			conn = DBUtil.open();
			
			String sql = "{call procTPointsDetail(?,?,?,?,?,?,?)}";
			stat = conn.prepareCall(sql);
			stat.setString(1, seq);
			
			stat.registerOutParameter(2, OracleTypes.NUMBER);
			stat.registerOutParameter(3, OracleTypes.NUMBER);
			stat.registerOutParameter(4, OracleTypes.NUMBER);
			stat.registerOutParameter(5, OracleTypes.NUMBER);
			stat.registerOutParameter(6, OracleTypes.DATE);
			stat.registerOutParameter(7, OracleTypes.VARCHAR);
			
			stat.executeQuery();
			
			ProcTPointsDetailDTO proc = new ProcTPointsDetailDTO();
			proc.setAttendance(stat.getString(2));
			proc.setWrite(stat.getString(3));
			proc.setPractical(stat.getString(4));
			proc.setTask(stat.getString(5));
			proc.setTest(stat.getString(6));
			proc.setQuestion(stat.getString(7));		
			
			ArrayList<ProcTPointsDetailDTO> list = new ArrayList<ProcTPointsDetailDTO>();
			list.add(proc);
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 교사 > 과목 배점수정
	 * @param editnum 선택번호
	 * @param select 과목번호
	 * @param edit 수정내용
	 * @param list 기존내용
	 */
	public void teacherTPointsEdit(String editnum, String select, String edit, ArrayList<ProcTPointsDetailDTO> list) {
		Connection conn = null;
		CallableStatement stat = null;
		try {
			conn = DBUtil.open();
			
			//(1.과목번호, 2.출결점수, 3.필기점수, 4.실기점수, 5.과제점수, 6.시험날짜(date), 7.문제)
			String sql = "{call procTScoremgntEdit(?,?,?,?,?,?,?)}";
			stat = conn.prepareCall(sql);
			
			if(editnum.equals("1")) { //출결점수 수정
				stat.setString(1, select); //과목번호
				stat.setString(2, edit); //출결(수정)
				stat.setString(3, list.get(0).getWrite()); //필기
				stat.setString(4, list.get(0).getPractical()); //실기
				stat.setString(5, list.get(0).getTask()); //과제
				stat.setString(6, list.get(0).getTest()); //시험날짜
				stat.setString(7, list.get(0).getQuestion()); //문제
				
			} else if(editnum.equals("2")) { //필기점수 수정
				stat.setString(1, select); //과목번호
				stat.setString(2, list.get(0).getAttendance()); //출결
				stat.setString(3, edit); //필기(수정)
				stat.setString(4, list.get(0).getPractical()); //실기
				stat.setString(5, list.get(0).getTask()); //과제
				stat.setString(6, list.get(0).getTest()); //시험날짜
				stat.setString(7, list.get(0).getQuestion()); //문제
				
			} else if(editnum.equals("3")) { //실기점수 수정
				stat.setString(1, select); //과목번호
				stat.setString(2, list.get(0).getAttendance()); //출결
				stat.setString(3, list.get(0).getWrite()); //필기
				stat.setString(4, edit); //실기(수정)
				stat.setString(5, list.get(0).getTask()); //과제
				stat.setString(6, list.get(0).getTest()); //시험날짜
				stat.setString(7, list.get(0).getQuestion()); //문제
				
			} else if(editnum.equals("4")) { //과제점수 수정
				stat.setString(1, select); //과목번호
				stat.setString(2, list.get(0).getAttendance()); //출결
				stat.setString(3, list.get(0).getWrite()); //필기
				stat.setString(4, list.get(0).getPractical()); //실기
				stat.setString(5, edit); //과제(수정)
				stat.setString(6, list.get(0).getTest()); //시험날짜
				stat.setString(7, list.get(0).getQuestion()); //문제
				
			} else if(editnum.equals("5")) { //시험날짜 수정
				stat.setString(1, select); //과목번호
				stat.setString(2, list.get(0).getAttendance()); //수정내용(출결)
				stat.setString(3, list.get(0).getWrite()); //필기
				stat.setString(4, list.get(0).getPractical()); //실기
				stat.setString(5, list.get(0).getTask()); //과제
				stat.setString(6, edit); //시험날짜(수정)
				stat.setString(7, list.get(0).getQuestion()); //문제
				
			} else if(editnum.equals("6")) { //문제 수정				
				stat.setString(1, select); //과목번호
				stat.setString(2, list.get(0).getAttendance()); //수정내용(출결)
				stat.setString(3, list.get(0).getWrite()); //필기
				stat.setString(4, list.get(0).getPractical()); //실기
				stat.setString(5, list.get(0).getTask()); //과제
				stat.setString(6, list.get(0).getTest()); //시험날짜
				stat.setString(7, edit); //문제(수정)
				
			}
			stat.executeUpdate();
			
			stat.close();
			conn.close();
		
			System.out.println("수정완료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	/**
	 * 교사 > 진행중인 과정 종료된 과목 목록
	 * @param seq 교사번호
	 * @return
	 */
	public ArrayList<ProcTScoreCheckDTO> teacherScore(String seq) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{call procTScoreCheck(?, ?)}"; //교사번호, 커서
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, seq);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			ArrayList<ProcTScoreCheckDTO> list = new ArrayList<ProcTScoreCheckDTO>();
			while(rs.next()) {
				ProcTScoreCheckDTO proc = new ProcTScoreCheckDTO();
				proc.setClassName(rs.getString("cr_name"));
				proc.setProcessEnd(rs.getString("op_enddate"));
				proc.setProcessName(rs.getString("p_name"));
				proc.setProcessStart(rs.getString("op_startdate"));
				proc.setRegScore(rs.getString("regscore"));
				proc.setSubjectEnd(rs.getString("os_enddate"));
				proc.setSubjectName(rs.getString("s_name"));
				proc.setSubjectSeq(rs.getString("os_seq"));
				proc.setSubjectStart(rs.getString("os_startdate"));
				
				list.add(proc);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	
	/**
	 * 교사 > 교사평가 과정목록
	 * @param seq
	 * @param select
	 * @return
	 */
	public ArrayList<ProcTeacherEval2DTO> teacherEval(String seq, String select) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.open();
			
			String sql = "{call procTeacherEval2(?,?,?)}"; //교사번호, 개설과정번호, 커서
			stat = conn.prepareCall(sql);
			
			stat.setString(1, seq);
			stat.setString(2, select);
			stat.registerOutParameter(3, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(3);
			
			ArrayList<ProcTeacherEval2DTO> list = new ArrayList<ProcTeacherEval2DTO>();
			while(rs.next()) {
				ProcTeacherEval2DTO proc = new ProcTeacherEval2DTO();
				proc.setScore(rs.getString("score"));
				proc.setContents(rs.getString("contents"));
				proc.setS_name(rs.getString("s_name"));
				
				list.add(proc);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

	/**
	 * 교사 > 과정목록
	 * @param seq
	 * @return
	 */
	public ArrayList<ProcTeacherProcess2DTO> teacherProcess(String seq) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.open();
			
			String sql = "{call procTeacherProcess2(?,?)}"; //교사번호, 커서
			stat = conn.prepareCall(sql);
			
			stat.setString(1, seq);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
		
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			ArrayList<ProcTeacherProcess2DTO> list = new ArrayList<ProcTeacherProcess2DTO>();
			
			while(rs.next()) {
				ProcTeacherProcess2DTO proc = new ProcTeacherProcess2DTO();
				proc.setOpenProcessSeq(rs.getString("op_seq"));
				proc.setProcessName(rs.getString("p_name"));
				
				list.add(proc);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}
	/**
	 * 교사 > 과제목록
	 * @param seq 교사번호
	 * @return
	 */
	public ArrayList<ProcTeacherTaskDTO> teacherTask(String seq) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{call procTeacherTask(?, ?)}";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, seq);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			ArrayList<ProcTeacherTaskDTO> list = new ArrayList<ProcTeacherTaskDTO>();
			while(rs.next()) {
				ProcTeacherTaskDTO proc = new ProcTeacherTaskDTO();
				proc.setProcessName(rs.getString("process_name"));
				proc.setSubjectName(rs.getString("subject_name"));
				proc.setTaskContents(rs.getString("task_contents"));
				proc.setOpenSubjectSeq(rs.getString("opensubject_seq"));
				
				list.add(proc);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 교사 > 학생들 과제 제출여부
	 * @param seq 교사번호
	 * @param select 과목번호
	 * @return
	 */
	public ArrayList<ProcTeacherTaskCheckDTO> teacherTaskCheck(String seq, String select) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		try {
			
			conn = DBUtil.open();
			
			String sql = "{call procTeacherTaskCheck(?,?,?)}";			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, seq);
			stat.setString(2, select);
			stat.registerOutParameter(3, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(3);
			
			ArrayList<ProcTeacherTaskCheckDTO> list = new ArrayList<ProcTeacherTaskCheckDTO>();
			while(rs.next()) {
				ProcTeacherTaskCheckDTO proc = new ProcTeacherTaskCheckDTO();
				proc.setStudentSeq(rs.getString("student_seq"));
				proc.setStudentName(rs.getString("student_name"));
				proc.setTaskState(rs.getString("state"));
				
				list.add(proc);
			}

			rs.close();
			stat.close();
			conn.close();		
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 교사 > 학생 점수 목록 
	 * @param seq 교사번호
	 * @param select 과목번호
	 * @return
	 */
	public ArrayList<ProcTScoreDetailDTO> teacherScoreDetail(String seq, String select) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{call procTScoreDetail(?, ?, ?)}"; //교사번호, 과목번호, 커서
			stat = conn.prepareCall(sql);
			
			stat.setString(1, seq);
			stat.setString(2, select);
			stat.registerOutParameter(3, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(3);
			
			ArrayList<ProcTScoreDetailDTO> list = new ArrayList<ProcTScoreDetailDTO>();
			while(rs.next()) {
				ProcTScoreDetailDTO proc = new ProcTScoreDetailDTO();
				proc.setStudentSeq(rs.getString("s_seq"));
				proc.setStudentName(rs.getString("s_name"));
				proc.setStudentTel(rs.getString("s_tel"));
				proc.setStudentState(rs.getString("r_state"));
				proc.setAttendancescore(rs.getString("sc_attendancescore"));
				proc.setWritescore(rs.getString("sc_writescore"));
				proc.setPracticalscore(rs.getString("sc_practicalscore"));
				proc.setTaskscore(rs.getString("sc_taskscore"));
				
				list.add(proc);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 교사 > 학생 점수 수정
	 * @param select 과목번호
	 * @param studentSeq 학생번호
	 * @param attendance 출결점수
	 * @param write 필기점수
	 * @param practical 실기점수
	 * @param task 과제점수
	 * @param seq 교사번호
	 * @return
	 */
	public String teacherPointsUpdate(String select, String studentSeq, String attendance, String write,
			String practical, String task, String seq) {
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{call procTScoreUpdate(?, ?, ?, ?, ?, ?, ?)}"; //교사번호, 과목번호, 커서
			stat = conn.prepareCall(sql);
			
			stat.setString(1, select); //과목번호
			stat.setString(2, studentSeq); //학생번호
			stat.setString(3, attendance); //출결
			stat.setString(4, write); //필기
			stat.setString(5, practical); //실기
			stat.setString(6, task); //과제
			stat.setString(7, seq); //교사번호
			
			stat.executeUpdate();
						
			stat.close();
			conn.close();
			
			return "성적 입력 성공";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "성적 입력 실패";

	}

	public ArrayList<AttendanceDTO> periodAttList(String t_seq, String op_seq, String att_arrivetime, String att_leavetime) {

		try {
			
			String sql = "{ call procattendanceed(?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, t_seq);
			cstat.setString(2, op_seq);
			cstat.setString(3, "2");
			cstat.setString(4, "1");
			cstat.setString(5, att_arrivetime);
			cstat.setString(6, att_leavetime);
			cstat.setString(7, "0");
			cstat.setString(8, "0");
			cstat.setString(9, "0");
			cstat.setString(10,"0");
			cstat.setString(11, "0");
			cstat.registerOutParameter(12, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(12);
			
			ArrayList<AttendanceDTO> attResult = new ArrayList<AttendanceDTO>();

			while(rs.next()) {
				
				AttendanceDTO dto = new AttendanceDTO();
				
				dto.setOp_seq(rs.getString("op_seq"));	 					//개설 과정 번호
				dto.setSt_seq(rs.getString("st_seq"));						//교육생 번호
				dto.setSt_name(rs.getString("st_name"));					//교육생 이름
				dto.setAtt_arrivetime(rs.getString("att_arrivetime"));		//입실 시각
				dto.setAtt_leavetime(rs.getString("att_leavetime"));		//퇴실 시각
				dto.setAtt_state(rs.getString("att_state"));				//출결 상태
				
				attResult.add(dto);
			
			}
			
			return attResult;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<ScheduleDTO> attlist(String seq) {//개설 과정 번호 입력 전 출력 DAO


		try {
			
			String sql = "{ call procteacherschedule(?, ?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);

			cstat.executeQuery();
			rs = (ResultSet)cstat.getObject(2);
			
			ArrayList<ScheduleDTO> attResult = new ArrayList<ScheduleDTO>();
			
			while (rs.next()) { //여러 DB 담기
				
				ScheduleDTO dto = new ScheduleDTO();
				dto.setOp_seq(rs.getString("op_seq")); 				//개설 과정 번호
				dto.setP_name(rs.getString("p_name"));				//과정명
				dto.setOp_startdate(rs.getString("op_startdate")); 	//과정 시작
				dto.setOp_enddate(rs.getString("op_enddate")); 		//과정 종료 
				dto.setCr_name(rs.getString("cr_name")); 			//강의실
				
				attResult.add(dto);
			}
			
			return attResult;

		} catch (Exception e) {
			System.out.println("TeacherDAO.schedulelist()" + e.toString());
		}
		
		return null;
	}
	
	public ArrayList<AttendanceDTO> periodAttSelList(String t_seq, String op_seq, String st_seq, String att_arrivetime,
			String att_leavetime) {

		try {
			
			String sql = "{ call procattendanceed(?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, t_seq);
			cstat.setString(2, op_seq);
			cstat.setString(3, "2");
			cstat.setString(4, "2");
			cstat.setString(5, att_arrivetime);
			cstat.setString(6, att_leavetime);
			cstat.setString(7, "0");
			cstat.setString(8, "0");
			cstat.setString(9, "0");
			cstat.setString(10,st_seq);
			cstat.setString(11, "0");
			cstat.registerOutParameter(12, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(12);
			
			ArrayList<AttendanceDTO> attResult = new ArrayList<AttendanceDTO>();

			while(rs.next()) {
				
				AttendanceDTO dto = new AttendanceDTO();
				
				dto.setOp_seq(rs.getString("op_seq"));	 					//개설 과정 번호
				dto.setSt_seq(rs.getString("st_seq"));						//교육생 번호
				dto.setSt_name(rs.getString("st_name"));					//교육생 이름
				dto.setAtt_arrivetime(rs.getString("att_arrivetime"));		//입실 시각
				dto.setAtt_leavetime(rs.getString("att_leavetime"));		//퇴실 시각
				dto.setAtt_state(rs.getString("att_state"));				//출결 상태
				
				attResult.add(dto);
			
			}
			
			return attResult;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;	
	
	}

	public ArrayList<StudentSelDTO> attstlist(String t_seq, String op_seq) {//특정 학생 번호 입력 전 출력 DAO

		try {
			
			String sql = "SELECT DISTINCT  st_seq, st_name FROM VWATTENDANCEOUTPUT ORDER BY st_seq";
			
			rs = stat.executeQuery(sql);
			
			ArrayList<StudentSelDTO> list = new ArrayList<StudentSelDTO>();
			
			while (rs.next()) {

				StudentSelDTO dto = new StudentSelDTO();
				
				dto.setSt_seq(rs.getString("st_seq"));						//교육생 번호
				dto.setSt_name(rs.getString("st_name"));					//교육생 이름
				
				list.add(dto);

			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public ArrayList<ScheduleDTO> schedulelist(String seq) { //강의스케줄 조회 DAO

	      try {
	         
	         String sql = "{ call procteacherschedule(?, ?) }";
	         
	         cstat = conn.prepareCall(sql);

	         
	         cstat.setString(1, seq);
	         cstat.registerOutParameter(2, OracleTypes.CURSOR);

	         cstat.executeQuery();
	         rs = (ResultSet)cstat.getObject(2);
	         
	         ArrayList<ScheduleDTO> scheduleResult = new ArrayList<ScheduleDTO>();
	         
	         while (rs.next()) { //여러 DB 담기
	            
	            ScheduleDTO dto = new ScheduleDTO();
	            dto.setOs_seq(rs.getString("os_seq"));             //개설 과목 번호
	            dto.setP_name(rs.getString("p_name"));            //과정명
	            dto.setOs_startdate(rs.getString("os_startdate"));    //과정 시작
	            dto.setOs_enddate(rs.getString("os_enddate"));       //과정 종료 
	            dto.setCr_name(rs.getString("cr_name"));          //강의실
	            dto.setS_name(rs.getString("s_name"));             //과목명
	            dto.setOp_startdate(rs.getString("op_startdate"));    //과목 시작
	            dto.setOp_enddate(rs.getString("op_enddate"));      //과목 종료
	            dto.setB_name(rs.getString("b_name"));             //교재명
	            dto.setStucount(rs.getString("stucount"));          //교육생 등록 인원 
	            
	            scheduleResult.add(dto);
	         }
	         
	         return scheduleResult;

	      } catch (Exception e) {
	         System.out.println("TeacherDAO.schedulelist()" + e.toString());
	      }
	      
	      return null;
	}
	
	
	public ArrayList<StudentDTO> get(String os_seq) {//등록된 교육생 정보 DAO 

	      try {
	         
	         String sql = "{ call procstudentinformation(?,?) }";
	         
	         cstat = conn.prepareCall(sql);
	         
	         cstat.setString(1, os_seq);
	         cstat.registerOutParameter(2, OracleTypes.CURSOR);
	         
	         cstat.executeQuery();
	         
	         rs = (ResultSet)cstat.getObject(2);
	         
	         ArrayList<StudentDTO> studentResult = new ArrayList<StudentDTO>();
	         
	         while(rs.next()) {
	            
	            StudentDTO dto = new StudentDTO();
	            
	            dto.setOs_seq(rs.getString("os_seq"));             //개설 과목 번호
	            dto.setSt_name(rs.getString("st_name"));          //교육생 이름
	            dto.setSt_rgstrdate(rs.getString("st_rgstrdate"));    //교육생 등록일
	            dto.setSt_tel(rs.getString("st_tel"));              //교육생 전화번호
	            dto.setRe_state(rs.getString("re_state"));           //교육생 강의진행 상태
	            
	            studentResult.add(dto);

	         }
	         
	         return studentResult;
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return null;
	   }
	
	
	public LoginDTO teacherLogin(String name, String ssn) {//교사 로그인 DAO
	      
	      try {

	         String sql = "SELECT*FROM tblTeacher WHERE name = ? AND ssn = ?";
	         
	         pstat = conn.prepareStatement(sql);
	         
	         pstat.setString(1, name);
	         pstat.setString(2, ssn);
	         
	         ResultSet rs = pstat.executeQuery();
	         
	         if(rs.next()) {
	            
	            LoginDTO dto = new LoginDTO(); //1회용
	            
	            dto.setName(rs.getString("name"));
	            dto.setSsn(rs.getString("ssn"));
	            dto.setSeq(rs.getString("seq"));
	            
	            return dto;
	            
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return null;
	}
	
	 /**
	    * 과제 수정
	    * @param seq 교사번호
	    * @param select 과목번호
	    * @param contents 과제내용
	    * @return
	    */
	   public String teacherTaskUpdate(String seq, String select, String contents) {   
	      try {
	         
	         String sql = "{call procTeacherTaskUpdate(?, ?, ?) }";
	         
	         cstat = conn.prepareCall(sql);
	         
	         cstat.setString(1, seq);
	         cstat.setString(2, select);
	         cstat.setString(3, contents);
	   
	         cstat.executeQuery();
	   
	         
	         return "과제 업데이트 성공";

	      } catch (Exception e) {
	         System.out.println("teacherTaskUpdate()" + e.toString());
	      }
	         return "과제 업데이트 실패";
	      }

}
