package admin.view;

import java.util.ArrayList;

import admin.dto.Admin_vwOpenProcessSubjectDTO;
import admin.dto.Admin_vwOpenSubjectDTO;
import admin.dto.Admin_vwProcessSubjectDTO;

/**
 * 
 * @author 유승현
 * Admin_OSManagement View
 */
public class Admin_OSManagementView {
	
	
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
	

	public void osManagementView(ArrayList<Admin_vwOpenSubjectDTO> list) {
		
		System.out.println("개설과정 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("%s\t%-50s\t\t%s\t%s\n", "[번호]", "[과정이름]", "[강의실]", "[개설된 과목수]");
		
		for(Admin_vwOpenSubjectDTO dto : list) {
			
			int result1 = checkTtitle(dto.getProcessName(), 60);
			
			System.out.printf("%s.\t%-"+ result1 +"s\t%5s\t%-3s\n", dto.getOpenProcess_seq(), dto.getProcessName()
					, dto.getRoomName(), dto.getCntSubject() );
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("세부 정보를 보기원하는 과정번호 선택 (Enter - 종료) : ");
		
	}

	public void opSubjectListView(ArrayList<Admin_vwOpenProcessSubjectDTO> list) {
		
		System.out.println("개설 과목 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.printf("%4s\t%s\t\t\t\t\t%s\n", "[번호]", "[과목이름]", "[기간]");
		
		for(Admin_vwOpenProcessSubjectDTO dto : list) {
			
			int result1 = checkTtitle(dto.getSubjectName(), 40);
			System.out.printf("%-4s\t%-"+ result1 +"s\t%s\n", dto.getOpensubject_seq(), dto.getSubjectName(), dto.getPeriod() + "일");
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.println("A. 과목 추가");
		System.out.println("B. 과목 삭제");
		System.out.println("Z. 돌아 가기");
		System.out.print("선택 : ");
	}

	public void continueView() {
		System.out.println("계속하려면 Enter를 누르십시오.");
	}

	public void psListView(ArrayList<Admin_vwProcessSubjectDTO> list) {
			
		System.out.println("추가 가능 과목 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.println("[과목번호]\t[과목명]");
		
		for(Admin_vwProcessSubjectDTO dto : list) {
			System.out.printf("%s.\t%s\n", dto.getProcessSubject_seq(), dto.getSubjectName());
		}
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("추가 하고싶은 과목번호 선택 (Enter - 종료) : ");
		
	}

	public void pass() {
		System.out.println("성공했습니다.");
	}
	
	public void fail() {
		System.out.println("실패했습니다.");
	}

	public void deleteView() {
		
		System.out.print("삭제할 과목번호를 선택하세요 (Enter - 종료) : ");
		
	}

}
