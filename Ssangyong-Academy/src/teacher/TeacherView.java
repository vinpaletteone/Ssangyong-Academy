package teacher;

import java.util.ArrayList;
import teacher.teacherDTO.StudentDTO;
import teacher.teacherDTO.StudentSelDTO;
import teacher.teacherDTO.AttendanceDTO;
import teacher.teacherDTO.LoginDTO;
import teacher.teacherDTO.ScheduleDTO;

public class TeacherView {

	/**
	 * 교사 > 계정 로그인 후 선택화면 뷰
	 */
	public void menu() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[교사계정]");
		System.out.println("1. 강의스케줄 조회");
		System.out.println("2. 배점 입출력");
		System.out.println("3. 성적 입출력");
		System.out.println("4. 교사 평가");
		System.out.println("5. 과제 관리");
		System.out.println("6. 출결 조회");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("선택(번호) : ");
		
		
	}
	
	public int checkTtitle(String str, int length) {

		int result = length;

		for (int i = 0; i < str.length(); i++) {

			char c1 = str.charAt(i);
			if (c1 >= '가' && c1 <= '힣') {
				result--;
			}

		}

		return result;
	}
	
	/**
	 * 교사 > 배점 입출력 뷰
	 */
	public void resultPoints(ArrayList<ProcTPointsDTO> list) {
		

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[배점 입출력]");
		System.out.println("[교실명]\t\t[과정명]\t\t\t\t\t\t[과정시작날짜]\t[과정종료날짜]\t[과목번호]\t[과목명]\t\t\t\t[과목시작날짜]\t[과목종료날짜]\t\t[교재명]\t\t\t\t\t[출결]\t[필기]\t[실기]\t[과제]");
		for(ProcTPointsDTO result : list) {

			int result1 = checkTtitle(result.getBookName(), 50);
			
			System.out.println(String.format("%-6s\t\t%-40s\t%-10s\t%-10s\t%-2s\t\t%-20s\t\t%-10s\t%-10s\t%-"+result1+"s\t%-3s\t%-3s\t%-3s\t%-3s\n"
																									, result.getClassName()
																									, result.getProcessName()
																									, result.getProcessStart().substring(0, 10)
																									, result.getProcessEnd().substring(0, 10)
																									, result.getSubjectSeq()
																									, result.getSubjectName()
																									, result.getSubjectStart().substring(0, 10)
																									, result.getSubjectEnd().substring(0, 10)
																									, result.getBookName()
																									, result.getAttendancePoints()
																									, result.getWritePoints()
																									, result.getPracticalPoints()
																									, result.getTaskPoints()));
		}		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("뒤로 가려면 0을 입력하세요.");
		System.out.print("과목번호 선택 : ");
		
	}
	/**
	 * 교사 > 배점 입출력(상세)
	 * @param list2
	 */
	public void resiltPointsDetail(ArrayList<ProcTPointsDetailDTO> list2) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[배점 입출력(상세)]");
		System.out.println("[1.출석]\t[2.필기]\t[3.실기]\t[4.과제]\t[5.시험날짜]\t[6.문제]");
		
		System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\n", list2.get(0).getAttendance()
													, list2.get(0).getWrite()
													, list2.get(0).getPractical()
													, list2.get(0).getTask()
													, list2.get(0).getTest().substring(0, 10)
													, list2.get(0).getQuestion());
		
	}
	/**
	 * 교사 > 교사 과정 목록
	 * @param list
	 */
	public void process(ArrayList<ProcTeacherProcess2DTO> list) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[과정 목록]");
		System.out.println("[과목번호]\t[과목명]");
		for(ProcTeacherProcess2DTO dto : list) {
			System.out.printf("%s.\t\t%s\n", dto.getOpenProcessSeq(), dto.getProcessName());
		}
	}
	
	/**
	 * 교사 > 교사평가 내용
	 * @param list
	 */
	public void eval(ArrayList<ProcTeacherEval2DTO> list) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[과정 목록]");
		System.out.println("[성]\t[점수]\t[평가내용]");
		for(ProcTeacherEval2DTO dto : list) {
			System.out.printf("%s\t%s\t%s\n", dto.getS_name()
											, dto.getScore()
											, dto.getContents() == null ? "내용없음" : dto.getContents());
		};
		
	}
	/**
	 * 교사 > 과제 목록
	 * @param list
	 */
   public void taskList(ArrayList<ProcTeacherTaskDTO> list) {
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
      System.out.println("[과제 목록]");
      System.out.println();
      System.out.println("[과목번호]\t[과정명]\t\t\t\t\t\t\t[과목명]\t\t\t\t[과제내용]");
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
      for(ProcTeacherTaskDTO dto : list) {
         
         int result1 = checkTtitle(dto.getProcessName(), 40);
         int result2 = checkTtitle(dto.getSubjectName(), 30);
         int result3 = checkTtitle(dto.getTaskContents(), 20);
         
         System.out.printf("%s\t\t%-"+result1+"s\t\t%-"+result2+"s\t\t%-"+result3+"s\n"
                                 , dto.getOpenSubjectSeq()
                                 , dto.getProcessName()
                                 , dto.getSubjectName()
                                 , dto.getTaskContents());
      }
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            
   }
	/**
	 * 교사 > 성적 과목 목록
	 * @param list
	 */
	public void score(ArrayList<ProcTScoreCheckDTO> list) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[성적 과목 목록]");
		
		
		System.out.println("[과정명]\t\t\t\t\t\t\t[과정시작일]\t[과정종료일]\t[강의실명]\t[과목번호]\t[과목명]\t\t\t\t\t[과목시작일]\t[과목종료일]\t[성적등록여부]");
		for(ProcTScoreCheckDTO dto : list) {
			int result = checkTtitle(dto.getProcessStart(), 40);
			int reuslt2 = checkTtitle(dto.getSubjectName(), 35);
			System.out.printf("%-"+ result +"s\t%-10s\t%-10s\t%-8s\t%-3s\t\t%-"+ reuslt2 +"s\t\t%s\t%s\t%s\n", dto.getProcessName()
																 	, dto.getProcessStart().substring(0,10)
																 	, dto.getProcessEnd().substring(0,10)
																 	, dto.getClassName()
																 	, dto.getSubjectSeq()
																 	, dto.getSubjectName()
																 	, dto.getSubjectStart().substring(0,10)
																 	, dto.getSubjectEnd().substring(0,10)
																 	, dto.getRegScore());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	/**
	 * 교사 > 점수 상세
	 * @param list
	 */
	public void scoreDetail(ArrayList<ProcTScoreDetailDTO> list) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[성적 학생 목록]");
		System.out.println("[학생번호]\t[학생명]\t[연락처]\t\t[상태]\t\t[출결]\t[필기]\t[실기]\t[과제]");
		for(ProcTScoreDetailDTO dto : list) {
			int result = checkTtitle(dto.getStudentState(), 8);
			System.out.printf("%s.\t\t%s\t\t%s\t\t%-"+ result +"s\t%s\t%s\t%s\t%4s\n", dto.getStudentSeq()
															, dto.getStudentName()
															, dto.getStudentTel()
															, dto.getStudentState()
															, dto.getAttendancescore()
															, dto.getWritescore()
															, dto.getPracticalscore()
															, dto.getTaskscore());
			
		}
		
	}
	/**
	 * 교사 > 과제 제출여부
	 * @param list
	 */
	public void taskCheck(ArrayList<ProcTeacherTaskCheckDTO> list) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[학생 과제 제출여부 확인]");
		System.out.println("[학생번호][학생명][제출여부]");
		for(ProcTeacherTaskCheckDTO dto : list) {
			System.out.printf("%s.\t%s\t%s\n", dto.getStudentSeq()
											, dto.getStudentName()
											, dto.getTaskState());
			
		}
	}
	
	public void attstmenu() {

		System.out.println("학생 조회");
		System.out.println("0. 돌아가기");
		System.out.println("1. 전체 학생 조회");
		System.out.println("2. 특정 학생 조회");
		System.out.print("선택(번호) : ");
	
	}
	
	public void periodAttList(ArrayList<AttendanceDTO> periodAttResult) {

		System.out.println("[번호]\t[이름]\t    [입실 시각]\t\t    [퇴실 시각]\t     [근태 상태]");

		for (AttendanceDTO dto : periodAttResult) {
			System.out.printf("%s.\t%s\t%s\t%s\t%s\n"
															,dto.getSt_seq()
															,dto.getSt_name()
															,dto.getAtt_arrivetime()
															,dto.getAtt_leavetime()
															,dto.getAtt_state());
		}		
	}
	
	public void attlist(ArrayList<ScheduleDTO> attlistresult) {//개설 과정 번호 입력 전 View


		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  개설 과정 번호\t:" + attlistresult.get(0).getOp_seq()+"    ┃───────────────────────────────────────────────");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println(" 과정명\t\t:\t" +attlistresult.get(0).getP_name());
		System.out.println(" 과정 기간\t:\t" +attlistresult.get(0).getOp_startdate() +" ~ "+ attlistresult.get(0).getOp_enddate());
		System.out.println(" 강의실\t\t:\t" +attlistresult.get(0).getCr_name());
		System.out.println("──────────────────────────────────────────────────────────────────────────────");

		
	}

	public void attstlist(ArrayList<StudentSelDTO> attstlistresult) {


		System.out.println("[교육생 정보]");
		System.out.println("[번호]\t[이름]");

		for (StudentSelDTO dto : attstlistresult) {
			System.out.printf("%s.\t%s\n"
															,dto.getSt_seq()
															,dto.getSt_name());
		}
		
	}
	
	public void periodAttSelList(ArrayList<AttendanceDTO> periodAttResult) {

		System.out.println("[번호]\t[이름]\t    [입실 시각]\t\t    [퇴실 시각]\t     [근태 상태]");

		for (AttendanceDTO dto : periodAttResult) {
			System.out.printf("%s.\t%s\t%s\t%s\t%s\n"
															,dto.getSt_seq()
															,dto.getSt_name()
															,dto.getAtt_arrivetime()
															,dto.getAtt_leavetime()
															,dto.getAtt_state());
		}		
	}
	
	
	
	public void schedulelist(ArrayList<ScheduleDTO> list) {//강의 스케줄 View
	      
	      System.out.println();
	      System.out.println("[강의 스케줄 조회]");
	      
	      for(ScheduleDTO dto : list) {
	         System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
	         System.out.println("┃  개설 과목 번호\t:" + dto.getOs_seq()+"   ┃────────────────────────────────────────────────");
	         System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	         System.out.println(" 과정명\t\t:\t" +dto.getP_name());
	         System.out.println(" 과정 기간\t:\t" +dto.getOp_startdate() +" ~ "+ dto.getOp_enddate());
	         System.out.println(" 강의실\t\t:\t" +dto.getCr_name());
	         System.out.println(" 과목명\t\t:\t" +dto.getS_name());
	         System.out.println(" 과목 기간\t:\t" +dto.getOs_startdate() +" ~ "+dto.getOs_enddate());
	         System.out.println(" 교재명\t\t:\t" +dto.getB_name());
	         System.out.println(" 등록 인원\t:\t" +dto.getStucount()+"명");
	         System.out.println("──────────────────────────────────────────────────────────────────────────────");
	      }
	      
	   }
	
	
	public void studentlist(ArrayList<StudentDTO> list) {//등록된 교육생 정보 View

	      System.out.println();
	      System.out.println("[교육생 등록 정보]");
	      System.out.println();
	   
	      
	      System.out.println("[번호]\t[이름]\t [전화번호]\t      [등록일]\t     [강의진행상태]");
	       
	      for(StudentDTO dto : list) {
	      
	      System.out.printf("  %s\t%s\t%s\t%s\t%s\n"
	                                       ,dto.getOs_seq()   
	                                       ,dto.getSt_name()
	                                       ,dto.getSt_tel()
	                                       ,dto.getSt_rgstrdate()
	                                       ,dto.getRe_state());
	      }
	   
	   }
	
}
