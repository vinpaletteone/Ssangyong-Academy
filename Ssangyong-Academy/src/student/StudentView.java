package student;

import java.util.ArrayList;

import student.studentDTO.EvalDTO;
import student.studentDTO.Stu_AttendanceDTO;
import student.studentDTO.Stu_ScoreDTO;
import student.studentDTO.TaskListDTO;

public class StudentView {

	public void menu() {

		System.out.println("[학생 모드]");
		System.out.println("1. 성적 조회");
		System.out.println("2. 출결 조회");
		System.out.println("3. 교사 평가");
		System.out.println("4. 과제 조회 및 제출");
		System.out.println("5. 출석 체크");
		System.out.println("6. 로그아웃");
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

	public void Scorelist(ArrayList<Stu_ScoreDTO> scoreResult) {

		System.out.println(
				"[번호]\t[과목명]\t\t\t\t\t[시작일]\t[종료일]\t[교재명]\t\t\t\t\t\t\t[교사명]" + "\t[출결 배점]\t[필기 배점]\t[실기 배점]\t[과제 배점]"
						+ "\t[출결 점수]\t[필기 점수]\t[실기 점수]\t[과제 점수]" + "\t[시험 날짜]\t[시험 문제]");

		for (Stu_ScoreDTO dto : scoreResult) {
			
			int result1 = checkTtitle(dto.getSub_name(), 40);
			int result2 = checkTtitle(dto.getBook_name(), 55);
			
			System.out.printf(
					"%3s\t%-"+result1+"s\t%10s\t%10s\t%-"+result2+"s\t\t%4s\t\t%4s\t\t%4s\t\t%4s\t\t%4s\t\t%4s\t\t%4s\t\t%4s\t\t%4s\t\t%10s\t%-30s\n",
					dto.getOs_seq() // 개설과목번호
					, dto.getSub_name() // 과목명
					, dto.getSub_start() // 시작일
					, dto.getSub_end() // 종료일
					, dto.getBook_name() // 교재명
					, dto.getTeacher_name() // 교사명
					, dto.getAtt_point() // 출결 배점
					, dto.getWrite_point() // 필기 배점
					, dto.getPrc_point() // 실기 배점
					, dto.getTask_point() // 과제 배점
					, dto.getAtt_score() == null ? "미등록" : dto.getAtt_score() // 출결 점수
					, dto.getWrite_score() == null ? "미등록" : dto.getWrite_score() // 필기 점수
					, dto.getPrc_score() == null ? "미등록" : dto.getPrc_score() // 실기 점수
					, dto.getTask_socre() == null ? "미등록" : dto.getTask_socre() // 과제 점수
					, dto.getTest_date() // 시험 날짜
					, dto.getTest_question()); // 시험 문제

		} // for

	}

	public void atnlist(ArrayList<Stu_AttendanceDTO> atnResult) {

		System.out.println("[출근 시각]\t\t[퇴근 시각]\t\t[출결 상태]");

		for (Stu_AttendanceDTO dto : atnResult) {
			System.out.printf("%20s\t%20s\t%4s\n", dto.getAtt_arrivetime(), dto.getAtt_leavetime() == null ? "없음" : dto.getAtt_leavetime() , dto.getAtt_state());
		}

	}

	public void EvalList(ArrayList<EvalDTO> teacherEval) {

		System.out.println("[평가번호]\t[교사명]\t[수료상태]\t[수료일]\t[학생명]\t\t[평가 내용]\t\t[평가 점수]");

		for (EvalDTO dto : teacherEval) {
			int result1 = checkTtitle(dto.getEval_contents() == null ? "내용 없음" : dto.getEval_contents(), 35);
			System.out.printf("%2s\t\t%4s\t\t%4s\t\t%10s\t%4s\t%"+result1+"s\t\t%2s\n"
					, dto.getEval_seq() // 교사평가번호
					, dto.getTeacher_name() // 교사명
					, dto.getRe_state() // 수료상태
					, dto.getRe_finaldate() // 수료일
					, dto.getStudent_name() // 학생명
					, dto.getEval_contents() == null ? "내용 없음" : dto.getEval_contents() // 평가 내용
					, dto.getEval_score()); // 평가 점수
			

		} // for

	}

	public void TaskList(ArrayList<TaskListDTO> task) {

		System.out.println("[과제번호]\t[과제 내용]\t\t\t\t[제출 상태]\t\t[과목명]\t\t\t[과목 시작일]\t\t[과목 종료일]");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
				+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		for (TaskListDTO dto : task) {
			int result1 = checkTtitle(dto.getSub_name(), 30);
			int result2 = checkTtitle(dto.getTask_contents(), 35);
			int result3 = checkTtitle(dto.getSubmit_state(), 10);
			System.out.printf("%s.\t\t%-"+ result2 +"s\t%-"+result3+"s\t\t%-"+result1+"s\t%-10s\t\t%-10s\n"
					, dto.getTask_seq() // 과제 번호
					, dto.getTask_contents() // 과제 내용
					, dto.getSubmit_state() // 제출 상태
					, dto.getSub_name() // 과목명
					, dto.getOs_startdate() // 개설 과목 시작일
					, dto.getOs_enddate()); // 개설 과목 종료일

		} // for
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
				+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	}

}
