package student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import student.studentDTO.EvalDTO;
import student.studentDTO.InfoDTO;
import student.studentDTO.LoginDTO;
import student.studentDTO.Stu_AttendanceDTO;
import student.studentDTO.Stu_ScoreDTO;
import student.studentDTO.TaskListDTO;

/**
 * @author 권준혁
 * 학생 메뉴 조작 클래스
 */
//메인 > 학생 모드
public class StudentController {
	
	private Scanner scan;
	private StudentView view;
	private StudentDAO dao;
	private static String name;
	private static String ssn;
	public static LoginDTO lgDTO;
	public static InfoDTO ifDTO;
	public static EvalDTO evDTO;
	
	
	//정적 변수
	
	/**
	 * SutdentController 생성자
	 */
	public StudentController() {
		scan = new Scanner(System.in);
		view = new StudentView();
		dao = new StudentDAO();
	}
	
	
	/**
	 * 학생 메뉴 출력
	 * (로그인 검사, 학생 정보 출력 기능)
	 */
	public void studentMenu() {	// 학생 메뉴 메소드
		
		System.out.println();
		System.out.println("[학생 로그인]");
		System.out.println();
		System.out.print("아이디 (이름) : ");
		name = scan.nextLine();

		System.out.print("비밀번호 (주민번호 뒷자리) : ");
		ssn = scan.nextLine();
		System.out.println();	
		
		
		// ===============로그인 유효성 검사, StudentDAO 위임=======================
		
		
		lgDTO = dao.studentLogin(name, ssn);
		
		StudentView view = new StudentView();

		try {

			if (lgDTO.getName().equals(name) && lgDTO.getSsn().equals(ssn)) {
				System.out.println("로그인 성공");
			}
			
		
		} catch (Exception e) {
			System.out.println("로그인 실패! 다시 로그인 해주세요.");
			scan.nextLine();
			studentMenu();
		}
		
		// ===============학생 정보 출력, StudentDAO 위임=======================
		
		ifDTO = dao.studentInfo(lgDTO.getSeq());

		try {
			
			System.out.println();
			System.out.println("==========================================");
			System.out.printf("학생명 : %s\n", name);
			System.out.printf("학생 전화번호 : %s\n", ifDTO.getTel());
			System.out.printf("수강 과정명 : %s\n", ifDTO.getProcessName());
			System.out.printf("과정 기간 : %s ~ %s\n", ifDTO.getStartDate(), ifDTO.getEndDate());
			System.out.printf("강의실명 : %s\n", ifDTO.getClassName());
			System.out.printf("담당 교사명 : %s\n", ifDTO.getTeacher());
			System.out.println("==========================================");
			System.out.println();

		} catch (Exception e) {
			System.out.println("학생 정보 미등록");
		}
		
		// ===============학생 메뉴 출력=======================
		
		boolean loop = true;
		
		while (loop) {
			
			view.menu();
			String sel = scan.nextLine();
			System.out.println();

			if (sel.equals("1")) { scrView(); } //성적 조회
			else if (sel.equals("2")) { atnView(); } //출결 조회
			else if (sel.equals("3")) { evalView();} //교사 평가
			else if (sel.equals("4")) { taskView();} //과제 조회 및 제출
			else if (sel.equals("5")) { attendance();} //과제 조회 및 제출
			else { loop = false; }

		}
		
		
		// 프로그램 끝
		

	}

	/**
	 * 성적 조회 메소드
	 */
	private void scrView() { //=========================== 성적 조회 메소드 =======================================
		
		
		System.out.println("[성적 조회]");
		System.out.println();
		
		
		ArrayList<Stu_ScoreDTO> scoreResult = dao.scoreList(lgDTO.getSeq());
		
		view.Scorelist(scoreResult);
		
		System.out.println();
		System.out.println("뒤로 가려면 엔터를 누르세요.");
		
		scan.nextLine();
		return;

	}

	
	/**
	 * 전체 출결 조회 메소드
	 */
	private void atnView() { //=========================== 출결 조회 메소드 =======================================
		
		
		boolean loop = true;
		
		while (loop) {
		
			System.out.println("[전체 출결 조회]");
			System.out.println();
			
			ArrayList<Stu_AttendanceDTO> atnResult = dao.atnlist(lgDTO.getSeq());
			
			view.atnlist(atnResult);
			
			System.out.println("==========================================");
			System.out.println("0.메뉴로 돌아가기");
			System.out.println("1.월별 조회");
			System.out.println("2.일일 조회");
			System.out.println("==========================================");
			
			System.out.print("입력(번호) : ");
			String seq = scan.nextLine();
			
			
			if (seq.equals("0")) {
				
				return; //빈 리턴문 (메소드 강제 종료)
				
			} else if (seq.equals("1")) {
				
				System.out.print("입력(월) : ");
				String month = scan.nextLine();
				
				atnViewMonth(month);
				
				
			} else if (seq.equals("2")) {
				
				System.out.println("EX)2019-10-04");
				System.out.print("입력(일) : ");
				String day = scan.nextLine();
				
				atnViewDay(day);
				
			}
		
		}
		
		
	}
	
	
	/**
	 * 월별 출결 조회 메소드
	 * @param month 조회할 날짜(월) 입력 받은 값
	 */
	private void atnViewMonth(String month) { //월별 출결 조회
		
		
		System.out.println("[월별 출결 조회]");
		System.out.println();
		
		ArrayList<Stu_AttendanceDTO> atnResult = dao.atnlistMonth(lgDTO.getSeq(), month);
		
		view.atnlist(atnResult);
		
		System.out.println("==========================================");
		System.out.println("0.돌아가기");
		System.out.println("==========================================");
		
		System.out.print("입력(번호) : ");
		String seq = scan.nextLine();
		
		if (seq.equals("0")) {
			
			return; //빈 리턴문 (메소드 강제 종료)
			
		}
		
	}


	/**
	 * 일일 출결 조회 메소드
	 * @param day 조회할 날짜(일) 입력 받은 값
	 */
	private void atnViewDay(String day) { //일일 출결 조회
		
		
		System.out.println("[일일 출결 조회]");
		System.out.println();
		
		ArrayList<Stu_AttendanceDTO> atnResult = dao.atnlistDay(lgDTO.getSeq(), day);
		
		view.atnlist(atnResult);
		
		System.out.println("==========================================");
		System.out.println("0.돌아가기");
		System.out.println("==========================================");
		
		System.out.print("입력(번호) : ");
		String seq = scan.nextLine();
		
		if (seq.equals("0")) {
			
			return; //빈 리턴문 (메소드 강제 종료)
			
		};
		
	}

	/**
	 * 교사 평가 메소드
	 */
	private void evalView() { //=========================== 교사 평가 메소드 =======================================
		
		System.out.println("[교사 평가]");
		System.out.println();
		
		boolean loop = true;
		
		while(loop) {
		
		ArrayList<EvalDTO> teacherEval = dao.EvalList();
		
		view.EvalList(teacherEval);
		
			System.out.println("==========================================");
			System.out.println("0.메뉴로 돌아가기");
			System.out.println("1.평가 작성");
			System.out.println("2.평가 수정");
			System.out.println("3.평가 삭제");
			System.out.println("==========================================");
			
			System.out.print("입력(번호) : ");
			String seq = scan.nextLine();
		
			if (seq.equals("0")) {
				
				return; //빈 리턴문 (메소드 강제 종료)
				
			} else if (seq.equals("1")) {	//평가 작성 (학생이 수료했어야하고, 이미 작성했으면 불가)
				
				String num = dao.evalCheck(lgDTO.getSeq());
				
				WriteEval(num); //평가 작성 메소드
				
			} else if (seq.equals("2")) {	//평가 수정 (본인 글만 수정)
				
				String num = dao.evalUpdateCheck(lgDTO.getSeq());
				
				UpdateEval(num);
				
			} else if (seq.equals("3")) {	//평가 삭제 (본인 글만 삭제)
	
				String num = dao.evalDeleteCheck(lgDTO.getSeq());
				
				DeleteEval(num);
				
			}
		
		} // while
		
	}
	
	/**
	 * 평가 작성 메소드
	 * @param num 유효성 검사 결과값 매개변수
	 */
	private void WriteEval(String num) { //평가 작성 메소드
		
		if (num.equals("1")) {
			
			System.out.println("평가가 가능합니다. 평가 작성으로 이동합니다.");
			System.out.println(lgDTO.getName() + " 학생은 " + ifDTO.getProcessName() + " 과정을 수료 하였습니다.");
			System.out.println(ifDTO.getTeacher() + "" + "교사에 대한 평가를 작성합니다.");
			System.out.println("0을 입력하면 뒤로 돌아갑니다.");
			System.out.println("============================");
			System.out.print("평가 내용 : ");
			String content = scan.nextLine();
			
			if (content.equals("0")) { //0 입력하면 뒤로 돌아가기
				return;
			}
			
			System.out.print("평가 점수(1~5) : ");
			String score = scan.nextLine();
			
			if (score.equals("0")) { //0 입력하면 뒤로 돌아가기
				return;
			}
			
			dao.evalAdd(lgDTO.getSeq(),content,score);
						
			return; //교사 평가 조회로 돌아가기
			
			
		} else if (num.equals("3")) {
			
			System.out.println("평가가 불가능합니다. 수료한 상태가 아니거나 이미 평가하셨습니다.");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //교사 평가 조회로 돌아가기
			
		} else {
			
			System.out.println("유효성 검사 판별 실패!");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //교사 평가 조회로 돌아가기
			
		}
	}

	
	/**
	 * 평가 수정 메소드
	 * @param num 유효성 검사 결과값 매개변수
	 */
	private void UpdateEval(String num) { //평가 수정 메소드
		
		if (num.equals("1")) {
			
			System.out.println("수정이 가능합니다. 평가 수정으로 이동합니다.");
			System.out.println(lgDTO.getName() + " 학생은 " + ifDTO.getProcessName() + " 과정을 수료 하였습니다.");
			System.out.println(ifDTO.getTeacher() + "" + "교사에 대한 평가를 수정합니다.");
			System.out.println("0을 입력하면 뒤로 돌아갑니다.");
			System.out.println("============================");
			System.out.print("평가 내용 : ");
			String content = scan.nextLine();
			
			if (content.equals("0")) { //0 입력하면 뒤로 돌아가기
				return;
			}
			
			System.out.print("평가 점수(1~5) : ");
			String score = scan.nextLine();
			
			if (score.equals("0")) { //0 입력하면 뒤로 돌아가기
				return;
			}
			
			dao.evalUpdate(lgDTO.getSeq(),content,score);
						
			return; //교사 평가 조회로 돌아가기
			
			
		} else if (num.equals("3")) {
			
			System.out.println("수정이 불가능합니다. 수정할 평가가 없습니다.");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //교사 평가 조회로 돌아가기
			
		} else {
			
			System.out.println("유효성 검사 판별 실패!");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //교사 평가 조회로 돌아가기
			
		}
		
	}


	/**
	 * 평가 삭제 메소드
	 * @param num 유효성 검사 결과값 매개변수
	 */
	private void DeleteEval(String num) { //평가 삭제 메소드
		
		if (num.equals("1")) {
			
			System.out.printf("%s 교사에 대한 평가를 삭제하시겠습니까?\n",ifDTO.getTeacher());
			System.out.println("============================");
			System.out.print("입력(Y/N) : ");
			String result = scan.nextLine();
			
			if (result.toUpperCase().equals("N")) { //0 입력하면 뒤로 돌아가기
				
				return;
				
			} else if (result.toUpperCase().equals("Y")) {
				
				dao.evalDelete(lgDTO.getSeq());
				
			}
					
			return; //교사 평가 조회로 돌아가기
			
			
		} else if (num.equals("3")) {
			
			System.out.println("삭제가 불가능합니다. 삭제할 평가가 없습니다.");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //교사 평가 조회로 돌아가기
			
		} else {
			
			System.out.println("유효성 검사 판별 실패!");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //교사 평가 조회로 돌아가기
			
		}
		
	}

	/**
	 * 과제 메소드
	 */
	private void taskView() {	//=========================== 과제 메소드 =======================================
		
		System.out.println("[과제 조회]");
		System.out.println();
		
		boolean loop = true;
		
		while(loop) {
		
		ArrayList<TaskListDTO> task = dao.TaskList(lgDTO.getSeq());
		
		view.TaskList(task);
		
			System.out.println("0.메뉴로 돌아가기");
			System.out.println("1.과제 제출");
			System.out.println("2.과제 제출 취소");
			System.out.println("==========================================");
			
			System.out.print("입력(번호) : ");
			String seq = scan.nextLine();
		
			if (seq.equals("0")) {
				
				return; //빈 리턴문 (메소드 강제 종료)
				
			} else if (seq.equals("1")) {	//과제 제출 (학생이 이미 제출한 과제, 혹은 과제 번호 범위를 벗어나면 유효성 검사)
				
				System.out.println();
				System.out.println("제출할 과제 번호를 입력하세요.");
				System.out.print("과제 번호 : ");
				String tseq = scan.nextLine();
				
				String num = dao.TaskSubmitCheck(lgDTO.getSeq(), tseq); //유효성 검사 DAO
				
				SubmitTask(num, tseq); //과제 제출 메소드
				
			} else if (seq.equals("2")) {	//과제 삭제 (원하는 과제)
				
				System.out.println();
				System.out.println("제출을 취소할 과제 번호를 입력하세요.");
				System.out.print("과제 번호 : ");
				String tseq = scan.nextLine();
				
				String num = dao.TaskSubmitDeleteCheck(lgDTO.getSeq(), tseq); //유효성 검사 DAO
				
				SubmitTaskCancel(num, tseq); //과제 제출 취소 메소드
				
			} 
		
		} // while
		
	}

	/**
	 * 과제 제출 메소드
	 * @param num 유효성 검사 결과값 매개변수
	 * @param tseq 제출할 과제 번호 입력 받은 값
	 */
	private void SubmitTask(String num, String tseq) { //과제 제출 메소드
		
		if (num.equals("1")) {
			
			System.out.println("과제 제출이 가능합니다. 과제를 제출하시겠습니까? (Y/N)");
			System.out.println("============================");
			System.out.print("입력 : ");
			String result = scan.nextLine();
			
			if (result.equals("0")) { //0 입력하면 뒤로 돌아가기
				return;
			}
			
			dao.TaskSubmit(lgDTO.getSeq(),tseq); //INSERT 하는 DAO
			
			return; //과제 조회로 돌아가기
			
			
		} else if (num.equals("3")) {
			
			System.out.println("과제 제출이 불가능합니다. 이미 제출하였거나 없는 과제 번호입니다.");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //과제 조회로 돌아가기
			
		} else {
			
			System.out.println("유효성 검사 판별 실패!");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //과제 조회로 돌아가기
			
		}
		
	}
	
	/**
	 * 과제 제출 취소 메소드
	 * @param num 유효성 검사 결과값 매개변수
	 * @param tseq 제출할 과제 번호 입력 받은 값
	 */
	private void SubmitTaskCancel(String num, String tseq) { //과제 제출 취소 메소드
		
		if (num.equals("1")) { //
			
			System.out.println("과제 제출 취소가 가능합니다. 과제 제출을 취소하시겠습니까? (Y/N)");
			System.out.println("============================");
			System.out.print("입력 : ");
			String result = scan.nextLine();

			if (result.toUpperCase().equals("N")) { //N 입력하면 뒤로 돌아가기
				
				return;
				
			} else if (result.toUpperCase().equals("Y")) { //Y 입력하면 과제 제출 삭제
				
				dao.TaskSubmitCancel(lgDTO.getSeq(),tseq); //DELETE 하는 DAO
				
			}
					
			return; //과제 조회로 돌아가기
			
			
		} else if (num.equals("3")) {
			
			System.out.println("과제 제출 취소가 불가능합니다. 과제를 제출하지 않았거나 없는 과제 번호입니다.");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //과제 조회로 돌아가기
			
		} else {
			
			System.out.println("유효성 검사 판별 실패!");
			System.out.println("(엔터를 눌러 계속 진행)");
			scan.nextLine();
			return; //과제 조회로 돌아가기
			
		}
	
	}
	
	
	/**
	 * 출석 체크 메소드
	 */
	private void attendance() {	// 출석 체크 메소드
			
		String num = dao.attendanceWork(lgDTO.getSeq());
		Calendar time = Calendar.getInstance();
		
		if (num.equals("0")) {
			
			System.out.printf("%s님, %tF %tT에 입실하셨습니다.\n", lgDTO.getName(), time, time);
			
		} else if (num.equals("1")) {
			
			System.out.printf("%s님, %tF %tT에 퇴실하셨습니다.\n", lgDTO.getName(), time, time);
			
		} else if (num.equals("2")) {
			
			System.out.printf("%s님, %tF %tT에 퇴실하셨습니다.\n", lgDTO.getName(), time, time);
			
		} else {
			
			System.out.println("예외처리 오류");
			
		}
		

		System.out.println();
		System.out.println("뒤로 가려면 엔터를 누르세요.");
		
		scan.nextLine();
		return;
		
		
	}

}
