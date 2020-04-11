package student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import main.DBUtil;
import oracle.jdbc.OracleTypes;
import student.studentDTO.EvalDTO;
import student.studentDTO.InfoDTO;
import student.studentDTO.LoginDTO;
import student.studentDTO.Stu_AttendanceDTO;
import student.studentDTO.Stu_ScoreDTO;
import student.studentDTO.TaskListDTO;

/**
 * 학생 작업 DAO 클래스
 * @author 권준혁
 *
 */
public class StudentDAO {

	//위임받는 모든 업무에서 공통으로 발생하는 작업
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	private Scanner scan;
	
	public StudentDAO() {
		
		scan = new Scanner(System.in);
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * 학생 로그인 검사 DAO
	 * @param name 로그인때 입력한 아이디(이름)
	 * @param ssn 로그인때 입력한 비밀번호(주민등록번호)
	 * @return LoginDTO에 데이터 전달
	 */
	public LoginDTO studentLogin(String name, String ssn) {	//학생 로그인 검사 DAO
		
		try {
			
			String sql ="select * from tblStudent where name= ? and ssn= ?";
			
			pstat = conn.prepareStatement(sql);	
			
			pstat.setString(1, name);
			pstat.setString(2, ssn);
			
			ResultSet rs = pstat.executeQuery();		
			
			if (rs.next()) {
			
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
	 * 학생 정보 DAO 메소드
	 * @param seq 학생 정보 조회할 로그인한 학생 번호
	 * @return InfoDTO에 데이터 전달
	 */
	public InfoDTO studentInfo(String seq) { //학생 정보 DAO
		
		try {
			
			String sql = "select * from vwStudentInfo where seq = ?";
			
			pstat = conn.prepareStatement(sql);	
			
			pstat.setString(1, seq);
			
			ResultSet rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				InfoDTO dto = new InfoDTO(); //1회용
				
				dto.setSeq(rs.getString("seq"));
				dto.setTel(rs.getString("tel"));
				dto.setProcessName(rs.getString("process"));
				dto.setStartDate(rs.getString("startdate"));
				dto.setEndDate(rs.getString("enddate"));
				dto.setClassName(rs.getString("class"));
				dto.setTeacher(rs.getString("teacher"));
				
				return dto;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	/**
	 * 성적 조회 DAO 메소드
	 * @param student_seq 성적 조회할 로그인한 학생 번호
	 * @return ArrayList<Stu_ScoreDTO>에 성적 관련 데이터 전달
	 */
	public ArrayList<Stu_ScoreDTO> scoreList(String student_seq) { //성적 조회 DAO
		
		
		try {
			
			String sql = "{ call procStudentScore(?,?) }";	//성적조회 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(2);
			
			ArrayList<Stu_ScoreDTO> scoreResult = new ArrayList<Stu_ScoreDTO>();
			
			
			while (rs.next()) {	//여러 DB 담기
				Stu_ScoreDTO dto = new Stu_ScoreDTO();
				dto.setOs_seq(rs.getString("openprocess_seq"));		//개설과목번호
				dto.setSub_name(rs.getString("subject_name"));		//과목명
				dto.setSub_start(rs.getString("subject_start"));	//과목 시작일
				dto.setSub_end(rs.getString("subject_end"));		//과목 종료일
				dto.setBook_name(rs.getString("book_name"));		//교재명
				dto.setTeacher_name(rs.getString("teacher_name"));	//교사명
				dto.setAtt_point(rs.getString("attendancepoints"));		//출결 배점
				dto.setWrite_point(rs.getString("writepoints"));	//필기 배점
				dto.setPrc_point(rs.getString("practicalpoints"));		//실기 배점
				dto.setTask_point(rs.getString("taskspoints"));		//과제 배점
				dto.setAtt_score(rs.getString("attendancescore"));		//출결 점수
				dto.setWrite_score(rs.getString("writescore"));	//필기 점수
				dto.setPrc_score(rs.getString("practicalscore"));		//실기 점수
				dto.setTask_socre(rs.getString("taskscore"));		//과제 점수
				dto.setTest_date(rs.getString("testdate"));		//시험 날짜
				dto.setTest_question(rs.getString("testquestion"));	//시험 문제
				
				scoreResult.add(dto);
			}
			
			return scoreResult;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * 출결 조회 DAO 메소드
	 * @param student_seq 출결 조회할 로그인한 학생 번호
	 * @return ArrayList<Stu_AttendanceDTO>에 출퇴근 시간, 출결 상태 데이터 전달
	 */
	public ArrayList<Stu_AttendanceDTO> atnlist(String student_seq) { //출결 조회 DAO (전체)
		
		
		try {
			
			String sql = "{ call procStudentAtn(?,?) }";	//전체 조회 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(2);
	
			ArrayList<Stu_AttendanceDTO> atnResult = new ArrayList<Stu_AttendanceDTO>();
			
			while (rs.next()) {
				
				Stu_AttendanceDTO dto = new Stu_AttendanceDTO();
				
				dto.setAtt_arrivetime(rs.getString("att_arrivetime"));
				dto.setAtt_leavetime(rs.getString("att_leavetime"));
				dto.setAtt_state(rs.getString("att_state"));	
				dto.setOp_seq(rs.getString("op_seq"));	
				dto.setSt_seq(rs.getString("st_seq"));
				dto.setT_name(rs.getString("t_name"));
				dto.setT_seq(rs.getString("t_seq"));
			
				atnResult.add(dto);
			}
			
			return atnResult;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 월별 조회 DAO 메소드
	 * @param student_seq 월별 조회할 로그인한 학생 번호
	 * @param month 조회할 날짜(월) 입력받은 값
	 * @return ArrayList<Stu_AttendanceDTO>에 월별 조회 데이터 전달
	 */
	public ArrayList<Stu_AttendanceDTO> atnlistMonth(String student_seq, String month) { //월별 조회 DAO
		
		
		try {
			
			String sql = "{ call procStudentAtnMonth(?,?,?) }";	//월별 조회 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);
			cstat.setString(2, month);
			cstat.registerOutParameter(3, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(3);
			
			ArrayList<Stu_AttendanceDTO> atnResult = new ArrayList<Stu_AttendanceDTO>();
			
			while (rs.next()) {	//여러 DB 담기
				Stu_AttendanceDTO dto = new Stu_AttendanceDTO();
				
				dto.setAtt_arrivetime(rs.getString("att_arrivetime"));
				dto.setAtt_leavetime(rs.getString("att_leavetime"));
				dto.setAtt_state(rs.getString("att_state"));	
				dto.setOp_seq(rs.getString("op_seq"));	
				dto.setSt_seq(rs.getString("st_seq"));
				dto.setT_name(rs.getString("t_name"));
				dto.setT_seq(rs.getString("t_seq"));
				
				atnResult.add(dto);
			}
					
			return atnResult;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	/**
	 * 일일 조회 DAO 메소드
	 * @param student_seq 일별 조회할 로그인한 학생 번호
	 * @param day 조회할 날짜(일) 입력받은 값
	 * @return ArrayList<Stu_AttendanceDTO>에 일일 조회 데이터 전달
	 */
	public ArrayList<Stu_AttendanceDTO> atnlistDay(String student_seq, String day) { //일일 조회 DAO
		
		try {
			
			String sql = "{ call procStudentAtnDay(?,?,?) }";	//일일 조회 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);
			cstat.setString(2, day);
			cstat.registerOutParameter(3, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(3);
			
			ArrayList<Stu_AttendanceDTO> atnResult = new ArrayList<Stu_AttendanceDTO>();
			
			while (rs.next()) {	//여러 DB 담기
				Stu_AttendanceDTO dto = new Stu_AttendanceDTO();
				
				dto.setAtt_arrivetime(rs.getString("att_arrivetime"));
				dto.setAtt_leavetime(rs.getString("att_leavetime"));
				dto.setAtt_state(rs.getString("att_state"));	
				dto.setOp_seq(rs.getString("op_seq"));	
				dto.setSt_seq(rs.getString("st_seq"));
				dto.setT_name(rs.getString("t_name"));
				dto.setT_seq(rs.getString("t_seq"));	
				
				atnResult.add(dto);
			}
					
			return atnResult;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * 교사 평가 DAO 메소드
	 * @return ArrayList<EvalDTO>에 교사 평가 데이터 전달
	 */
	public ArrayList<EvalDTO> EvalList() { //교사 평가 DAO
		
		try {
			
			String sql = "SELECT teachereval_seq, teacher_name, result_state, "
					+ "result_finaldate, student_name, teachereval_contents, teachereval_score "
					+ "from vwTeacherEvalList";

			rs = stat.executeQuery(sql);
	
			ArrayList<EvalDTO> EvalResult = new ArrayList<EvalDTO>();
			
			while (rs.next()) {
				EvalDTO dto = new EvalDTO();
				dto.setEval_seq(rs.getString("teachereval_seq"));	
				dto.setTeacher_name(rs.getString("teacher_name"));	
				dto.setRe_state(rs.getString("result_state"));	
				dto.setRe_finaldate(rs.getString("result_finaldate"));	
				dto.setStudent_name(rs.getString("student_name"));	
				dto.setEval_contents(rs.getString("teachereval_contents"));	
				dto.setEval_score(rs.getString("teachereval_score"));	
				
				EvalResult.add(dto);
			}
			
			return EvalResult;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	/**
	 * 교사 평가 작성 가능 판별 여부 DAO 메소드
	 * @param stduent_seq 교사 평가 작성할 로그인한 학생 번호 
	 * @return evalCheck에 교사 평가 작성 가능 판별 여부 데이터 전달
	 */
	public String evalCheck(String stduent_seq) { //평가 작성 가능 판별 여부 DAO
		
		try {
			
			String sql = "{ call procEvalCheck(?,?) }";	//평가 작성 유효성 검사 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, stduent_seq);
			cstat.registerOutParameter(2, OracleTypes.NUMBER);
			
			cstat.executeQuery();
			
			//결과값 매개변수 받아오기 (1 - 작성 가능, 2 - 판별 실패, 3 - 작성 불가)
			String num = cstat.getString(2);
		
			return num;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	/**
	 * 교사 평가 작성 DAO 메소드
	 * @param student_seq 교사 평가 작성할 로그인한 학생 번호
	 * @param content 교사 평가 작성 내용 입력받은 값
	 * @param score 교사 평가 점수 입력받은 값
	 */
	public void evalAdd(String student_seq, String content, String score) { //평가 작성 DAO
		
		try {
					
			String sql = "{ call procEvalAdd (?, ?, ?) }";
			cstat = conn.prepareCall(sql);
						
			cstat.setString(1, student_seq);
			cstat.setString(2, content);
			cstat.setString(3, score);
			
			cstat.executeUpdate();
			
			conn.commit();
			System.out.println("작성 완료");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * 교사 평가 수정 가능 여부 판별 DAO 메소드
	 * @param stduent_seq 교사 평가 수정할 로그인한 학생 번호
	 * @return evalUpdateCheck에 교사 평가 수정 가능 여부 판별 여부 데이터 전달
	 */
	public String evalUpdateCheck(String stduent_seq) { //수정 가능 여부 판별 DAO
		
		try {
			
			String sql = "{ call procEvalUdCheck(?,?) }";	//평가 수정 유효성 검사 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, stduent_seq);
			cstat.registerOutParameter(2, OracleTypes.NUMBER);
			
			cstat.executeQuery();
			
			//결과값 매개변수 받아오기 (1 - 수정 가능, 2 - 판별 실패, 3 - 수정 불가)
			String num = cstat.getString(2);
		
			return num;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 교사 평가 수정 DAO 메소드
	 * @param student_seq 교사 평가 수정할 로그인한 학생 번호
	 * @param content 교사 평가 작성 내용 입력받은 값
	 * @param score 교사 평가 점수 입력받은 값
	 */
	public void evalUpdate(String student_seq, String content, String score) { //수정 DAO
		
		try {
			
			String sql = "{ call procEvalUpdate (?, ?, ?) }";
			cstat = conn.prepareCall(sql);
						
			cstat.setString(1, student_seq);
			cstat.setString(2, content);
			cstat.setString(3, score);
			
			cstat.executeUpdate();
			
			System.out.println("수정 완료");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * 평가 삭제 유효성 검사 DAO 메소드
	 * @param student_seq 교사 평가 삭제할 로그인한 학생 번호
	 * @return evalDeleteCheck에 평가 삭제 유효성 검사 데이터 전달
	 */
	public String evalDeleteCheck(String student_seq) { //평가 삭제 유효성 검사 DAO
		
		try {
			
			String sql = "{ call procEvalUdCheck(?,?) }";	//평가 삭제 유효성 검사 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);
			cstat.registerOutParameter(2, OracleTypes.NUMBER);
			
			cstat.executeQuery();
			
			//결과값 매개변수 받아오기 (1 - 삭제 가능, 2 - 판별 실패, 3 - 삭제 불가)
			String num = cstat.getString(2);
		
			return num;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}


	/**
	 * 평가 삭제 작업 DAO 메소드
	 * @param student_seq 교사 평가 삭제할 로그인한 학생 번호
	 */
	public void evalDelete(String student_seq) { //평가 삭제 작업 DAO
		
		try {
			
			String sql = "{ call procEvalDelete (?) }";
			cstat = conn.prepareCall(sql);
						
			cstat.setString(1, student_seq);
			
			cstat.executeUpdate();
			
			System.out.println("삭제 완료");
			
			scan.nextLine();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	/**
	 * 과제 조회 프로시저 호출 메소드
	 * @param student_seq 과제 조회할 로그인한 학생 번호
	 * @return ArrayList<TaskListDTO>에 과제 조회 프로시저 호출 데이터 전달
	 */
	public ArrayList<TaskListDTO> TaskList(String student_seq) { //과제 조회 DAO
		
		
		try {
			
			String sql = "{ call procTaskList(?,?) }";	//과제 조회 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(2);
			
			ArrayList<TaskListDTO> taskList = new ArrayList<TaskListDTO>();
			
			while (rs.next()) {
				TaskListDTO dto = new TaskListDTO();
				dto.setTask_seq(rs.getString("seq"));	
				dto.setOs_startdate(rs.getString("startdate"));	
				dto.setOs_enddate(rs.getString("enddate"));
				dto.setSub_name(rs.getString("name"));
				dto.setTask_contents(rs.getString("contents"));
				dto.setSubmit_state(rs.getString("SubmitState"));
			
				taskList.add(dto);
			}
			
			return taskList;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	
	}

	/**
	 * 과제 제출 유효성 검사 프로시저 호출 메소드
	 * @param student_seq 과제 제출 할 로그인한 학생 번호
	 * @param tseq 과제 번호 입력받은 값
	 * @return 유효성 검사 결과값 데이터 전달
	 */
	public String TaskSubmitCheck(String student_seq, String tseq) { //과제 제출 유효성 검사 DAO
		
		try {
			
			String sql = "{ call procTaskSubmitCheck(?,?,?) }";	//과제 제출 유효성 검사 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);	//학생 번호
			cstat.setString(2, tseq);			//과제 번호
			cstat.registerOutParameter(3, OracleTypes.NUMBER);	//유효성 검사 결과 1,2,3
			
			cstat.executeQuery();
			
			//결과값 매개변수 받아오기 (1 - 제출 가능, 2 - 판별 실패, 3 - 제출 불가)
			String num = cstat.getString(3);
		
			return num;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}


	/**
	 * 과제 제출 메소드
	 * @param student_seq 과제 제출할 로그인한 학생 번호
	 * @param tseq 과제 번호 입력받은 값
	 */ 
	public void TaskSubmit(String student_seq, String tseq) { //과제 제출 DAO
		
		try {
			
			String sql = "{ call procTaskSubmit (?, ?) }";
			cstat = conn.prepareCall(sql);
						
			cstat.setString(1, tseq);
			cstat.setString(2, student_seq);
			
			cstat.executeUpdate();
			
			conn.commit();
			System.out.println("제출 완료");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * 과제 제출 유효성 검사 프로시저 호출 메소드
	 * @param student_seq 과제 제출 취소할 로그인한 학생 번호
	 * @param tseq 과제 번호 입력받은 값
	 * @return 유효성 검사 결과값 데이터 전달
	 */
	public String TaskSubmitDeleteCheck(String student_seq, String tseq) { //과제 제출 취소(삭제) 유효성 검사 DAO
		
		try {
			
			String sql = "{ call procTaskSubmitCheck2(?,?,?) }";	//과제 제출 취소 유효성 검사 프로시저 호출
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);	//학생 번호
			cstat.setString(2, tseq);			//과제 번호
			cstat.registerOutParameter(3, OracleTypes.NUMBER);	//유효성 검사 결과 1,2,3
			
			cstat.executeQuery();
			
			//결과값 매개변수 받아오기 (1 - 삭제 가능, 2 - 판별 실패, 3 - 삭제 불가)
			String num = cstat.getString(3);
		
			
			return num;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}

	/**
	 * 과제 제출 취소 메소드
	 * @param student_seq 과제 제출 취소할 로그인한 학생 번호
	 * @param tseq 과제 번호 입력받은 값
	 */
	public void TaskSubmitCancel(String student_seq, String tseq) { //과제 제출 취소 DAO
		
		try {
			
			String sql = "{ call procTaskSubmitDelete (?, ?) }";
			cstat = conn.prepareCall(sql);
						
			cstat.setString(1, tseq);
			cstat.setString(2, student_seq);
			
			cstat.executeUpdate();
			
			conn.commit();
			System.out.println("삭제 완료");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * 
	 * @param student_seq 출석체크할 로그인한 학생 번호
	 * @return 출석 체크 확인 여부 유효성 검사 결과 값 리턴
	 */
	public String attendanceWork(String student_seq) {
		
		try {
			
			String sql = "{ call procAttendanceCheck(?,?) }";	//출석체크
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, student_seq);	//학생 번호
			cstat.registerOutParameter(2, OracleTypes.NUMBER);	//유효성 검사 결과 1,2,3
			
			cstat.executeUpdate();
			
			String num = cstat.getString(2); //결과값 매개변수 받아오기
			
			conn.commit();
			
			return num;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	
	}
		
}
