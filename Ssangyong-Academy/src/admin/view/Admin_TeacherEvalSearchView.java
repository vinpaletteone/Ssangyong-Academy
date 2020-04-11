package admin.view;

import java.util.ArrayList;

import admin.dto.Admin_vwEndOpenProcessDTO;
import admin.dto.Admin_vwTeacherEvalDTO;


/**
 * 
 * @author 유승현
 * TeacherEvalSearch View
 */
public class Admin_TeacherEvalSearchView {
	
	
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
	

	public void endOpenProcessView(ArrayList<Admin_vwEndOpenProcessDTO> list) {
		System.out.println();
		System.out.println("교사평가 결과 조회");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.printf("%s\t%s\t\t\t\t\t\t\t\t\t%s\n", "[번호]", "[과정명]", "[교사명]");
		
		for(Admin_vwEndOpenProcessDTO dto : list) {
			int result1 = checkTtitle(dto.getProcessName(), 60);
			System.out.printf("%s.\t%-"+ result1 +"s\t%20s\n", dto.getSeq(), dto.getProcessName(), dto.getTeacherName());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("세부 정보를 보고싶은 과정 선택 (Enter - 종료) : ");
	}

	//%-"+ result1 +"s
	
	
	public void teacherEvalView(ArrayList<Admin_vwTeacherEvalDTO> list) {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		System.out.printf("%s\t\t\t\t\t\t\t%s\n", "[과정명]", "[교사명]");
		int result1 = checkTtitle(list.get(0).getProcessName(), 60);
		System.out.printf("%-"+ result1 +"s\t%s\n", list.get(0).getProcessName(), list.get(0).getTeacherName());
		System.out.println();
		
		System.out.printf("%3s\t%s\t\t\t\t%s\n", "[학생명]", "[평가내용]", "[평가점수]");

		for(Admin_vwTeacherEvalDTO dto : list){
			int result2 = checkTtitle(dto.getContents() == null ? "내용 없음" : dto.getContents(), 35);
			System.out.printf("%3s\t\t%-"+ result2 +"s\t%5s\n", dto.getStudentName(), dto.getContents() == null ? "내용 없음" : dto.getContents(), dto.getScore());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("계속하시려면 Enter를 누르십시오.");

	}
}
