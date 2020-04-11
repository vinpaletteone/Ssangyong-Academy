package admin;

import java.util.ArrayList;
import java.util.Scanner;

import admin.dao.Admin_TCManagementDAO;
import admin.dto.Admin_procTeacherInfoDTO;
import admin.dto.Admin_procTeacherPosSubjectDTO;
import admin.view.Admin_TCManagementView;
import commonDTO.SubjectDTO;
import commonDTO.TeacherDTO;

/**
 * 
 * @author 유승현
 * 관리자 - 교사계정 관리 - CRUD
 */
public class AdminMain_TCManagement {
	private Scanner scanner;
	private Admin_TCManagementView av;
	private Admin_TCManagementDAO dao;
	
	public AdminMain_TCManagement() {
			this.scanner = new Scanner(System.in);
			this.av = new Admin_TCManagementView();
			this.dao = new Admin_TCManagementDAO();
	}
	
	/**
	 * AdminMain_TCManagement 시작
	 */
	public void start() {
		ArrayList<TeacherDTO> teacherList = new ArrayList<TeacherDTO>();

		boolean loop = true;
			
		while(loop) {
			//-교사목록 출력
			teacherList = dao.teacherList();
			av.tcMgntStartView(teacherList);

			//-세부정보 번호 선택 or 추가, 수정, 삭제
			av.tcMgntSelct();
			String sel = scanner.nextLine();
			
			try {
				Integer.parseInt(sel);
				
				ArrayList<Admin_procTeacherInfoDTO> infoList = new ArrayList<Admin_procTeacherInfoDTO>();
				ArrayList<Admin_procTeacherPosSubjectDTO> subjectList = new ArrayList<Admin_procTeacherPosSubjectDTO>();
				
				infoList = dao.teacherInfo(sel);
				subjectList = dao.teacherSubject(sel);

				av.teacherInfoView(infoList, subjectList);
				
				av.continueView();
				scanner.nextLine();
			}catch (Exception e){
				if(sel.length() == 1){
					switch (sel.toLowerCase().charAt(0)){
						case 'a' :	//추가
							av.addTeacher();
							
							av.inputID();
							String ID = scanner.nextLine();
							
							av.inputPW();
							String PW = scanner.nextLine();
							
							av.inputTel();
							String Tel = scanner.nextLine();
							
							ArrayList<SubjectDTO> subjectList = new ArrayList<SubjectDTO>();
							//과목목록 출력
							subjectList = dao.subjectList();
							av.subjectListView(subjectList);
							
							av.subjectSelect();
							String subjectSelect = scanner.nextLine();
							
							int insertResult = dao.addTeacher(ID, PW, Tel) + dao.addSubject(sel, subjectSelect) ;
							
							if(insertResult > 0) {
								av.pass();
							}else {
								av.fail();
							}
							
							av.continueView();
							scanner.nextLine();
							
							break;
						case 'b' :	//수정
							av.updateTeacher();
							
							TeacherDTO dto = new TeacherDTO();
							
							String teacherSelect = scanner.nextLine();
							dto = dao.getTeacher(teacherSelect);
							
							av.updateID();
							String updateID = scanner.nextLine();
							av.updatePW();
							String updatePW = scanner.nextLine();
							av.updateTel();
							String updateTel = scanner.nextLine();
							
							if(updateID.equals("")) {
								updateID = dto.getName();
							}
							
							if(updatePW.equals("")) {
								updatePW = dto.getSsn();
							}
							
							if(updateTel.equals("")) {
								updateTel = dto.getTel();
							}
							
							int updateResult = dao.updateTeacher(teacherSelect, updateID, updatePW, updateTel);
							
							if(updateResult > 0) {
								av.pass();
							}else {
								av.fail();
							}
							
							av.continueView();
							scanner.nextLine();
							
							break;
						case 'c' :	//삭제
							av.deleteTeacher();
							
							String deleteSelect = scanner.nextLine();
							
							int deleteResult = dao.updateTeacher(deleteSelect, "■■■", "■■■", "null");
							
							if(deleteResult > 0) {
								av.pass();
							}else {
								av.fail();
							}
							
							av.continueView();
							scanner.nextLine();
							
							break;
						case 'z' :	//돌아가기
							loop = !loop;
							break;

						default:
							av.error();
							continue;
					}
				}else{
					av.error();
				}
			}
		}
	}
}
