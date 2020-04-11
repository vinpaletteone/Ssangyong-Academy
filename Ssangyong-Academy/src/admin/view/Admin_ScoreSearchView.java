package admin.view;

import java.util.ArrayList;

import admin.dto.Admin_vwAdminStudentScoreDTO;
import admin.dto.Admin_vwOpenProcessSubjectDTO;
import admin.dto.Admin_vwOpenSubjectDTO;
import commonDTO.StudentDTO;

/**
 * 
 * @author 유승현
 * Admin_ScoreSearch View
 */
public class Admin_ScoreSearchView {
	
	public void scoreSearchStart() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("1. 과목별 성적 조회 ");
		System.out.println("2. 학생별 성적 조회 ");
		System.out.println("0. 돌아가기         ");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("선택 : ");
	}

	public void error() {
		System.out.println("잘못된 선택입니다.");
	}

	public void studentListView(ArrayList<StudentDTO> list) {
		System.out.println();
		System.out.println("학생 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("[학생번호]\t[이름]\t[주민등록번호]\t[전화번호]\t[등록일]\n");
		
		for(StudentDTO dto : list) {
			System.out.printf("%s.\t\t%s\t%s\t\t%s\t%s\n", dto.getSeq(), dto.getName(), dto.getSsn(), dto.getTel(), dto.getRgstrDate());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("성적을 보기 원하는 학생 선택 : ");
		
	}

	public void studentScoreListView(ArrayList<Admin_vwAdminStudentScoreDTO> list) {
		System.out.println();
		System.out.println("학생 성적 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "[총합]", "[출석점수]", "[필기점수]", "[실기점수]", "[과제점수]", "[과목명]");
		
		for(Admin_vwAdminStudentScoreDTO dto : list) {
			if(dto.getAttendanceScore() == null) {
				System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n", "미등록", "미등록", "미등록", "미등록", "미등록" , dto.getSubjectName());
			}else { 
				System.out.printf("%s점\t%s점\t\t%s점\t\t%s점\t\t%s점\t\t%s\n", (Integer.parseInt(dto.getAttendanceScore()) + Integer.parseInt(dto.getWriteScore()) + Integer.parseInt(dto.getPracticalScore()) + Integer.parseInt(dto.getTaskScore()))
						, dto.getAttendanceScore(), dto.getWriteScore(), dto.getPracticalScore(), dto.getTaskScore(), dto.getSubjectName());
				
			}
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	public void noresult() {
		System.out.println("미등록 학생입니다.");
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
	 * 개설 과정 출력
	 * @param osList 
	 */
	public void openSubjectListView(ArrayList<Admin_vwOpenSubjectDTO> osList) {
		System.out.println();
		System.out.println("개설 과정 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[번호]\t[교사명]\t[강의실이름]\t\t[과정이름]");
		
		for(Admin_vwOpenSubjectDTO dto : osList) {
			System.out.printf("%s.\t%s\t\t%s\t%s\n", dto.getOpenProcess_seq() , dto.getTeacherName(), dto.getRoomName(), dto.getProcessName() );
		}
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("개설 과정 번호 선택 : ");
		
	}

	public void opSubjectListView(ArrayList<Admin_vwOpenProcessSubjectDTO> list) {
		System.out.println();
		System.out.println("과목 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.printf("%4s\t%s\t\t\t\t\t%s\n", "[번호]", "[과목이름]", "[기간]");
		
		for(Admin_vwOpenProcessSubjectDTO dto : list) {
			int result1 = checkTtitle(dto.getSubjectName(), 40);
			System.out.printf("%s.\t%-"+ result1 +"s\t%s\n", dto.getOpensubject_seq(), dto.getSubjectName()
					,dto.getStartDate() + "~" + dto.getEndDate() + "(" + dto.getPeriod() + "일)");
		}
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("과목 목록 번호 선택 : ");
	}

	public void subjectScoreListView(ArrayList<Admin_vwAdminStudentScoreDTO> list) {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[과목명]  " + list.get(0).getSubjectName());
		
		System.out.println("[학생번호]  [학생명]   [총합]\t[출석점수]   [필기점수]   [실기점수]   [과제점수]");
		
		for(Admin_vwAdminStudentScoreDTO dto : list) {
			if(dto.getAttendanceScore() == null) {
				System.out.printf("%s.\t     %s\t%s\t %3s\t\t%3s\t   %3s\t  %3s\n", dto.getSeq(), dto.getStudentName()
						, "미등록", "미등록", "미등록", "미등록", "미등록");
			}else {
				System.out.printf("%s.\t     %s\t%s점\t %3s점\t\t%3s점\t   %3s점\t  %3s점\n", dto.getSeq(), dto.getStudentName()
						, (Integer.parseInt(dto.getAttendanceScore()) + Integer.parseInt(dto.getWriteScore()) + Integer.parseInt(dto.getPracticalScore()) + Integer.parseInt(dto.getTaskScore()))
						, dto.getAttendanceScore(), dto.getWriteScore(), dto.getPracticalScore(), dto.getTaskScore());
			}
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
	}

	public void returnEnter() {
		System.out.println("돌아가려면 Enter를 누르십시오");
	}
	
}
