package teacher;

import java.util.ArrayList;
import java.util.Scanner;

import commonDTO.TeacherDTO;
import teacher.teacherDTO.AttendanceDTO;
import teacher.teacherDTO.LoginDTO;
import teacher.teacherDTO.StudentDTO;
import teacher.teacherDTO.StudentSelDTO;
import teacher.teacherDTO.ScheduleDTO;

//정니찬, 2356800, 10
//신원환, 1162588, 1
public class TeacherController {
	private Scanner scan;
	private TeacherDAO dao;
	private TeacherDTO dto;
	private TeacherView view;
	private static String seq; //로그인한 교사의 번호
	public static LoginDTO lgDTO;
	
	
	public TeacherController() {
		scan = new Scanner(System.in);
		dao = new TeacherDAO();
		dto = new TeacherDTO();
		view = new TeacherView();
		seq = "";
	}
	
	/**
	 * 로그인
	 */
	public void login() {
		
		scan = new Scanner(System.in);
		System.out.println();
		System.out.println("[교사 로그인]");
		System.out.println();
		System.out.print("아이디 (이름) : ");
		String id = scan.nextLine();
		System.out.println();
		System.out.print("비밀번호 (주민번호 뒷자리) : ");
		String pw = scan.nextLine();
		
		
		lgDTO = dao.teacherLogin(id, pw);
		dto = dao.login(id, pw); //로그인 후 dto담기
		boolean loop = true;
		
		if(dto != null) {
			seq = dto.getSeq(); //교사번호 seq담기
			while(loop) {
				view.menu();
				String select = scan.nextLine();
				
				if(select.equals("1")) { //스케줄O
					schedule();
				} else if(select.equals("2")) {	//배점O
					points(seq);
				} else if(select.equals("3")) { //성적O
					score(seq);
				} else if(select.equals("4")) { //교사평가O
					eval(seq);
				} else if(select.equals("5")) { //과제O
					task(seq);
				} else if(select.equals("6")) { //출결O
					attendance(seq);
				} else {
					loop = !loop;
					continue;
				}
			}
		} else {
			System.out.println("로그인 실패!");
		}

	}
	
	private void attendance(String seq2) {
		//================(기간,특정 학생)출결 조회 메뉴 출력=============
		boolean loop = true;
		
		while(loop) {
			
			view.attstmenu();
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {periodattstall();}
			else if (sel.equals("2")) {periodattstsel();}
			else {loop = false;}
			System.out.println("엔터를 치면 메뉴로 돌아갑니다.");
			scan.nextLine();
			
		}
		
	}
	private void task(String seq) {
	      
	      
	      ArrayList<ProcTeacherTaskDTO> list = dao.teacherTask(seq); //과제목록
	      view.taskList(list); //과제목록 출력
	      
	      System.out.println("(1)과제 수정 및 업데이트 (2)과제 제출여부 출력");
	      System.out.print("번호 선택 : ");
	      String select = scan.nextLine(); //1 or 2
	      
	      if(select.equals("1")) {
	         System.out.print("과목번호 선택 : ");
	         select = scan.nextLine();
	         System.out.print("수정내용 : ");
	         String contents = scan.nextLine();
	         
	         dao.teacherTaskUpdate(seq, select, contents); //과목번호, 수정내용
	         
	         task(seq);
	         
	      } else if(select.equals("2")) {
	         System.out.print("과목번호 선택 : ");
	         select = scan.nextLine();
	         ArrayList<ProcTeacherTaskCheckDTO> list2 = dao.teacherTaskCheck(seq, select); //해당 과목과제 제출한 학생(교사번호, 과목번호)
	         view.taskCheck(list2); //학생들 제출여부 출력
	         
	         scan.nextLine();
	      }
	      
	      
	      

	      
	   }
	/**
	 * 교사평가
	 * @param seq 교사번호
	 */
	private void eval(String seq) {	
		ArrayList<ProcTeacherProcess2DTO> list = dao.teacherProcess(seq);//과정목록
		view.process(list); //과정목록 출력
		
		System.out.print("과정번호 선택 : ");
		String select = scan.nextLine();

		ArrayList<ProcTeacherEval2DTO> list2 = dao.teacherEval(seq, select);//평가내용 출력(교사번호, 선택과정)
		view.eval(list2);
	}

	/**
	 * 강의스케줄 조회(교사)
	 */
	private void schedule() {//강의 스케줄 조회 메소드
	      
	      view.schedulelist(dao.schedulelist(lgDTO.getSeq()));
	      System.out.println("〔과목 번호 입력 시 등록된 교육생 정보 확인 가능합니다. 메뉴로 돌아가기 : 0〕");
	      System.out.print("개설 과목 번호 : ");
	      String os_seq = scan.nextLine();
	      
	      
	      //특정 번호 선택 > DB > select
	      ArrayList<StudentDTO> dto = dao.get(os_seq);
	      
	      view.studentlist(dto); //특정 번호의 교육생 등록 정보 출력
	      
	      scan.nextLine();
	      
	   }
	
	/**
	 * 배점 입출력(교사)
	 */
	public void points(String seq) {
		
		//배점 출력(과목별)
		ArrayList<ProcTPointsDTO> list = dao.teacherPoints(seq); //과목목록 불러오기
		view.resultPoints(list); //과목목록 뷰에 넘기기
		String select = scan.nextLine(); //과목번호
		
		if (select.equals("0")) {
			
			return;
			
		}
		
		//배점 출력(과목상세)
		ArrayList<ProcTPointsDetailDTO> list2 = dao.teacherPointsDetail(select); //과목 상세정보 불러오기
		view.resiltPointsDetail(list2); //상세정보 뷰에 넘기기
		
		//배점 출력(수정 + 수정 후)
		System.out.print("수정할 사항을 선택하세요.(번호) : ");
		String editnum = scan.nextLine();//수정 사항 선택
		String edit = ""; //수정 내용을 담아줄 변수
		if(editnum.equals("1")) {
			System.out.print("출석 배점 수정(최소 20) : ");
			edit = scan.nextLine();
			dao.teacherTPointsEdit(editnum, select, edit, list2); //정보 수정(선택번호, 과목번호, 수정내용, 기존내용)
			
		} else if(editnum.equals("2")) {
			System.out.print("필기 배점 수정 : ");	
			edit = scan.nextLine();
			dao.teacherTPointsEdit(editnum, select, edit, list2);
			
		} else if(editnum.equals("3")) {
			System.out.print("실기 배점 수정 : ");
			edit = scan.nextLine();
			dao.teacherTPointsEdit(editnum, select, edit, list2);
			
		} else if(editnum.equals("4")) {
			System.out.print("과제 배점 수정 : ");
			edit = scan.nextLine();
			dao.teacherTPointsEdit(editnum, select, edit, list2);
			
		} else if(editnum.equals("5")) {
			System.out.print("시험날짜 수정(YYYY-MM-DD) : ");
			edit = scan.nextLine();
			dao.teacherTPointsEdit(editnum, select, edit, list2);
			
		} if(editnum.equals("6")) {
			System.out.print("문제 수정 : ");
			edit = scan.nextLine();
			dao.teacherTPointsEdit(editnum, select, edit, list2);
			
		}		
		
		list = dao.teacherPoints(seq); //배점 수정(교사번호)
		view.resultPoints(list); //배점 수정 결과
		
		scan.nextLine();
		
	}
	
	/*
	 * 성적 입출력(교사)
	 */
	public void score(String seq) {
		
		//과목 목록 출력(성적)
		ArrayList<ProcTScoreCheckDTO> list = dao.teacherScore(seq); //과목목록 불러오기
		view.score(list); //과목목록 출력
		
		System.out.print("과목번호 입력 : ");
		String select = scan.next();
		
		
		ArrayList<ProcTScoreDetailDTO> list2 = dao.teacherScoreDetail(seq, select); //학생성적 목록 불러오기
		
		if(list2.get(0).getStudentState().equals("수강중")) { //현재 수강중인 과목은 시험날짜 수정
			System.out.print("시험 날짜 입력(YYYY-MM-DD) : ");
			scan.nextLine();
			String testDate = scan.nextLine();
			
			ArrayList<ProcTPointsDetailDTO> list3 = dao.teacherPointsDetail(select);//해당 과목의 정보 받아오기(시험배점, 날짜, 문제)		
			dao.teacherTPointsEdit("5", select, testDate, list3); //시험날짜 수정 메소드 실행(실행할 IF문, 과목번호, 변경날짜, 과목정보)
		} else {
			view.scoreDetail(list2); //수강이 끝난 과목은 성적목록 출력
			
			System.out.print("학생번호 입력 : ");
			String studentSeq = scan.nextLine();
			studentSeq = scan.nextLine();
			System.out.print("\n입력할 성적(출결) : ");
			String attendance = scan.nextLine();
			System.out.print("\n입력할 성적(필기) : ");
			String write = scan.nextLine();
			System.out.print("\n입력할 성적(실기) : ");
			String practical = scan.nextLine();
			System.out.print("\n입력할 성적(과제) : ");
			String task = scan.nextLine();
			
			String update = dao.teacherPointsUpdate(select, studentSeq, attendance, write, practical, task, seq); //학생 성적 수정(과목번호, 학생번호, 출결, 필기, 실기, 과제, 교사번호)
			System.out.println(update); //업데이트 여부 출력
			
			
		}
	}
	
private void periodattstall() {
		
		System.out.println("전체 학생 기간별 조회");
		
		view.attlist(dao.attlist(lgDTO.getSeq()));
		
		System.out.println("0을 입력하면 뒤로 돌아갑니다.");
		System.out.print("개설 과정(번호) : ");
		String op_seq = scan.nextLine();
		System.out.println();
		
		
		if (op_seq.equals("0")) {
			
			return;
			
		}
		
		
		System.out.println("[기간 입력]");
		System.out.println("EX)2019-10-01 09:00:00 (날짜,시각 입력)");
		System.out.print("시작(날짜,시각 입력) : ");
		String att_arrivetime = scan.nextLine();
		
		System.out.print("종료(날짜,시각 입력) : ");
		String att_leavetime = scan.nextLine(); 
		System.out.println();
		
		ArrayList<AttendanceDTO> periodAttResult = dao.periodAttList(lgDTO.getSeq(), op_seq, att_arrivetime, att_leavetime);
		view.periodAttList(periodAttResult);
		
	}
	
private void periodattstsel() {

	System.out.println("특정 학생 기간별 조회");
	
	view.attlist(dao.attlist(lgDTO.getSeq()));
	
	System.out.println("0을 입력하면 뒤로 돌아갑니다.");
	System.out.print("개설 과정(번호) : ");
	String op_seq = scan.nextLine();
	System.out.println();
	
	
	if (op_seq.equals("0")) {
		
		return;
		
	}
	
	view.attstlist(dao.attstlist(lgDTO.getSeq(),op_seq));
	
	System.out.print("학생(번호) : ");
	String st_seq = scan.nextLine();
	
	System.out.println("[기간 입력]");
	System.out.println("EX)2019-10-01 09:00:00 (날짜,시각 입력)");
	System.out.print("시작(날짜,시각 입력) : ");
	String att_arrivetime = scan.nextLine();
	
	System.out.print("종료(날짜,시각 입력) : ");
	String att_leavetime = scan.nextLine(); 
	System.out.println();
	
	ArrayList<AttendanceDTO> periodAttSelResult = dao.periodAttSelList(lgDTO.getSeq(), op_seq, st_seq, att_arrivetime, att_leavetime);
	view.periodAttSelList(periodAttSelResult);
			
}
	

}
