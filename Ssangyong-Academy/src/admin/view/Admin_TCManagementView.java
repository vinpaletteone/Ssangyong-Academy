package admin.view;

import java.util.ArrayList;

import admin.dto.Admin_procTeacherInfoDTO;
import admin.dto.Admin_procTeacherPosSubjectDTO;
import commonDTO.SubjectDTO;
import commonDTO.TeacherDTO;

/**
 * 
 * @author 유승현
 * Admin_TCManagement View
 */
public class Admin_TCManagementView {
	
	
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


	// 작성자 유승현
	// 교사 목록 출력
	public void tcMgntStartView(ArrayList<TeacherDTO> list) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");			
		System.out.println("[교사번호]\t[교사명]\t[주민번호]\t[전화번호]");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");		
		
		for(TeacherDTO dto : list){
			//삭제되어 이름이 ■■■ 인 계정 넘어가기
			if(dto.getName().equals("■■■")) { continue; }
			
			System.out.printf("%s.\t\t%s\t\t%s\t\t%s\n", dto.getSeq(), dto.getName(), dto.getSsn(), dto.getTel());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	// 작성자 유승현
	// 선택
	public void tcMgntSelct() {

		System.out.println("A. 교사 정보 추가");
		System.out.println("B. 교사 정보 수정");
		System.out.println("C. 교사 정보 삭제");
		System.out.println("Z. 돌아가기");
		System.out.print("세부정보를 보고싶은 교사 번호 선택 OR 추가, 수정, 삭제 선택 : ");

	}

	public void error() {
		System.out.println("잘못된 선택입니다.");
	}

	// 교사 세부정보 출력
	public void teacherInfoView(ArrayList<Admin_procTeacherInfoDTO> infoList, ArrayList<Admin_procTeacherPosSubjectDTO> subjectList) {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[교사명] : " + infoList.get(0).getName());
		System.out.println();
		
		System.out.printf("%-30s\t\t\t%s\t\t%s\t%s\n", "[과정명]", "[과정기간]", "[강의실명]", "[강의 진행 여부]");
		for(Admin_procTeacherInfoDTO dto : infoList) {
			System.out.printf("%-30s\t%s\t%s\t%s\n", dto.getProcessName()
					, dto.getStartDate() + " ~ " + dto.getEndDate() + "(" + dto.getPeriod() + "일)"
					, dto.getRoomName(), dto.getProcessState());
		}
		System.out.println();

		
		System.out.println("[과목명]");
		
		for(Admin_procTeacherPosSubjectDTO dto : subjectList) {
			System.out.println(dto.getName());
		}

		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		}

		//교사 추가
		public void addTeacher() {
			System.out.println();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");		
			System.out.println("교사 계정 추가하기");
		}
		
		public void inputID() {
			System.out.print("ID(교사명) 입력 : ");
		}
		
		public void inputPW() {
			System.out.print("PW(주민등록뒷번호) 입력 : ");
		}
		
		public void inputTel() {
			System.out.print("전화번호 입력 : ");
		}

		public void pass() {
			System.out.println("성공했습니다.");
		}

		public void fail() {
			System.out.println("실패했습니다.");
		}

		//과목목록 출력
		public void subjectListView(ArrayList<SubjectDTO> subjectList) {
			
			System.out.printf("%2s\t%s\t\t\t\t\t\t%3s\n", "[번호]", "[과목명]", "[일수]");
			
			for(SubjectDTO dto : subjectList) {
				int result1 = checkTtitle(dto.getName(), 55);
				System.out.printf("%s.\t%-"+result1+"s\t[%s일]\n", dto.getSeq(), "["+ dto.getName() +"]", dto.getPeriod());
			}
			
		}

		public void subjectSelect() {
			System.out.print("강의가능 과목 선택(다중선택) : ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println();
		}

		
		//교사 수정하기
		public void updateTeacher() {
			System.out.println();
			System.out.print("수정하고 싶은 교사 번호 선택 : ");
		}
		
		public void updateID() {
			System.out.println("변경 안할시 빈칸 입력");
			System.out.print("변경할 ID 입력 : ");
		}
		
		public void updatePW() {
			System.out.print("변경할 PW 입력 : ");
		}
		
		public void updateTel() {
			System.out.print("변경할 Tel 입력 : ");
		}

		//교사 삭제하기
		public void deleteTeacher() {
			System.out.print("삭제하고 싶은 교사 번호 선택 : ");
		}

		public void continueView() {
			System.out.println("계속하시려면 Enter를 누르십시오.");
		}
		
	
}
