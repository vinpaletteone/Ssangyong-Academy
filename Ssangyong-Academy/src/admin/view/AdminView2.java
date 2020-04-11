package admin.view;
/**
 * @author 송재원
 * 관리자 기능 출력 View
 */
import java.util.ArrayList;
import java.util.Scanner;

import admin.dto.AdminMain_AttendanceSearchDTO;
import admin.dto.AdminMain_SManagementDTO;
import admin.dto.Admin_VwOpenProcessDTO;
import admin.dto.Admin_VwSelStudentDTO;
import admin.dto.Admin_procOpenSubjectDTO;
import admin.dto.Admin_procStudentInfoDTO;
import admin.dto.ProcTeacherTaskCheckDTO;
import admin.dto.ProcTeacherTaskDTO;
import commonDTO.TeacherDTO;

public class AdminView2 {

	// 개성과정 보요주기
	public void openProcessView(ArrayList<Admin_VwOpenProcessDTO> list) {
		System.out.println();
		System.out.println("개설 과정 관리");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		// System.out.println("[번호]\t[과정이름]\t\t[시작날짜]\t[종료날짜]\t[강의실]");
		for (Admin_VwOpenProcessDTO dto : list) {

			System.out.println("[번호]\t[과정이름]");
			System.out.printf("%s\t%s", dto.getSeq(), dto.getProcessName());
			System.out.println();
			System.out.println();
			System.out.println("[시작 날짜]\t\t\t[종료 날짜]");
			System.out.printf("%s\t%s", dto.getStartDate(), dto.getEndDate());
			System.out.println();
			System.out.println();
			System.out.printf("[강의실]");
			System.out.println();
			System.out.printf("%s", dto.getClassName());
			System.out.println();
			System.out.println();

		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("a. 입력");
		System.out.println("b. 수정");
		System.out.println("c. 삭제");
		System.out.println("z. 돌아가기");
		System.out.print("세부 정보를 보기위한 과정 선택(번호) : ");

	}

	public void Admin_procStudentInfoDTO(ArrayList<Admin_procStudentInfoDTO> list2) {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[이름] [주민번호]  [전화번호]    [등록일]    [상태]");

		for (Admin_procStudentInfoDTO dto : list2) {
			System.out.printf("%s %s\t   %s\t%s   %s\n", dto.getStudentName(), dto.getSsn(), dto.getTel(), dto.getRgstrdate().substring(0,10),
					dto.getState());

		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	public void Admin_procOpenSubjectDTO(ArrayList<Admin_procOpenSubjectDTO> list3) {
		System.out.println();
		System.out.println("개설 과정 과목");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		System.out.println("[과목 이름]\t\t\t[과목 기간]");
		for (Admin_procOpenSubjectDTO dto : list3) {
			System.out.printf("%s\t\t\t%s일\n", dto.getName(), dto.getPeriod());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("계속하려면 Enter를 누르십시오.");
	}

	// 개설 과정 정보에 대한 등록 및 관리(입력 (1), 수정(2), 삭제(3), 돌아가기(4))
	public void openProcessSelect() {
		
		System.out.print("선택 : " );
	}

	public void AddProcess() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("과정추가");

	}

	public void input() {
		System.out.print("과정 이름 입력 : ");
	}

	public void period() {
		System.out.print("과정 기간 입력:");
	}

	public void seqDelete() {

		System.out.print("삭제할 번호 입력 : ");

	}

	public void DeleteProcess() {

	}

	public void ViewList(ArrayList<AdminMain_SManagementDTO> list) {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("학생 목록");
		for (AdminMain_SManagementDTO dto : list) {
			System.out.printf("%s, %s, %s, %s\n", dto.getSeq(), dto.getName(), dto.getSsn(), dto.getTel(),
					dto.getRgstrdate());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("계속하려면 Enter를 누르십시오.");
	}

	// 학생 정보에 대한 등록 및 관리(입력 (1), 수정(2), 삭제(3), 돌아가기(4))

	public void AdminStudentTodo() {
		System.out.println("1. 학생 등록 ");
		System.out.println("2. 학생 수정 ");
		System.out.println("3. 학생 삭제 ");
		System.out.print("번호 입력 (Enter - 뒤로가기) : ");

	}

	public void AddStudent() {

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("학생 추가");

	}

	public void StudentName() {
		System.out.print("이름 입력 : ");

	}

	public void StudentSsn() {
		System.out.print("주민번호 입력:");

	}

	public void StudentTel() {
		System.out.print("전화번호 입력:");

	}

	public void updateStudent() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("학생 수정");

	}

	public void UpdateSeq() {
		System.out.print("수정할 학생 번호 :");

	}

	public void updateName() {
		System.out.print("이름 입력 : ");

	}

	public void updateSsn() {
		System.out.print("주민번호 입력 : ");

	}

	public void updateTel() {
		System.out.print("전화번호 입력:");

	}

	public void DeleteStudent() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("학생 삭제");
	}

	public void DeleteSeq() {
		System.out.print("삭제할 학생 번호 : ");
	}

	public void SearchStudent() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("학생 검색하기");

	}

	public void StudentNumber() {
		System.out.print("학생 번호 입력 : ");

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
	
	
	public void SearchStudent(Admin_VwSelStudentDTO dto) {
		int result1 = checkTtitle(dto.getProcessName(), 50);
		System.out.println();
		System.out.println("선택 학생 정보");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[이름]\t[과정명]\t\t\t\t\t\t\t[강의실명]\t[상태]\t[수료날짜]");
		System.out.printf("%s\t%-"+ result1 +"s\t\t%s\t%s\t%s\n", dto.getStudentName(), dto.getProcessName(),
				dto.getClassName(), dto.getState(), dto.getFinaldate() == null ? "" : dto.getFinaldate().substring(0, 10));
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		// 특정 교육생 선택시 출력할 내용 : 과정명, 과정기간, 강의실, 수료여부, 날짜
	}

	public void VwAttendancrSearchList(ArrayList<AdminMain_AttendanceSearchDTO> list) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━ 학생 근태 상황 ━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[번호] [이름]  [출근시간]\t\t[퇴근시간]\t[상황]");
		for (AdminMain_AttendanceSearchDTO dto : list) {
			System.out.printf("%s. %s %s %s %s \n", dto.getSt_seq(), dto.getSt_name()
					, dto.getAtt_arrivetime() != null ? dto.getAtt_arrivetime() : "없음\t\t"
					, dto.getAtt_leavetime() != null ? dto.getAtt_leavetime() : "없음\t\t"
						, dto.getAtt_state());
		}
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("계속하려면 Enter를 누르십시오.");

	}

	public void SearchStudentSelet() {
		System.out.print("학생 이름 입력 (Enter - 종료) : ");

	}

	public void SearchStudentAtt(ArrayList<AdminMain_AttendanceSearchDTO> list) {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("선택 학생 근태상황");
		for (AdminMain_AttendanceSearchDTO dto : list) {
			System.out.printf("%s, %s, %s, %s, %s \n", dto.getSt_seq(), dto.getSt_name()
					, dto.getAtt_arrivetime() != null ? dto.getAtt_arrivetime() : "없음\t\t"
					, dto.getAtt_leavetime() != null ? dto.getAtt_leavetime() : "없음\t\t"
					, dto.getAtt_state());

		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("계속하려면 Enter를 누르십시오.");
		System.out.println();
	}

	public void vwAdmin_scoreList() {
		System.out.println("목록 불러오기 성공!");
	}

	public void TaskTeacherSearch() {
		System.out.print("교사 번호 (Enter - 종료) : ");

	}

	public void Teacherlist(ArrayList<TeacherDTO> Teacherlist) {

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[교사번호]\t[교사명]\t[주민번호]\t[전화번호]");

		for (TeacherDTO dto : Teacherlist) {
			// 삭제되어 이름이 ■■■ 인 계정 넘어가기
			if (dto.getName().equals("■■■")) {
				continue;
			}
			System.out.printf("%s.\t\t%s\t\t%s\t\t%s\n", dto.getSeq(), dto.getName(), dto.getSsn(), dto.getTel());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	
	

	public void taskList(ArrayList<ProcTeacherTaskDTO> list) {
		System.out.println();
		System.out.println("과제 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[과정명]\t\t\t\t[과목번호]\t[과목명]\t\t\t\t[과제내용]");
		for (ProcTeacherTaskDTO dto : list) {
			int result1 = checkTtitle(dto.getSubjectName(), 30);
			System.out.printf("%s\t%s\t\t%-"+ result1 +"s\t\t%s\n", dto.getProcessName(), dto.getOpenSubjectSeq(),
					dto.getSubjectName(), dto.getTaskContents());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	

	public void taskCheck(ArrayList<ProcTeacherTaskCheckDTO> list) {
		System.out.println();
		System.out.println("학생 과제 제출여부 확인");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[학생번호]\t[학생명]\t[제출여부]");
		for (ProcTeacherTaskCheckDTO dto : list) {
			System.out.printf("%-10s\t%-10s\t%-10s\n", dto.getStudentSeq(), dto.getStudentName(), dto.getTaskState());

		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("계속하려면 Enter를 누르십시오.");
	}

}
