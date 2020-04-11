package admin;

import java.util.Scanner;

import admin.dao.AdminLoginDAO;
import admin.view.AdminView;

/**
 * 
 * @author 유승현, 송재원
 * 관리자 모드 선택시 시작
 * 관리자 컨트롤러
 */
public class AdminController {
	private Scanner scanner;
	private AdminView av;
	private AdminLoginDAO dao;
	
	public AdminController() {
		this.scanner = new Scanner(System.in);
		this.av = new AdminView();
		this.dao = new AdminLoginDAO();
	}
	
	/**
	 * 관리자 로그인 계정확인
	 */
	public void adminLogin() {
		String ID;
		String PW;

		//아이디 입력창 출력
		av.IDView();
		ID = scanner.nextLine();
		
		//비밀번호 입력창 출력
		av.PWView();
		PW = scanner.nextLine();
		
		if(dao.loginCheck(ID,PW)) {
			adminMain();
		}else {
			System.out.println();
			av.fail();
			System.out.println();
		}
	}
	
	/**
	 * 로그인 성공시 관리자페이지 시작
	 */
	public void adminMain() {
		boolean loop = true;
		
		while(loop) {
			av.adminMain();
			String sel = scanner.nextLine();
			
			switch(sel) {	
				case "1" :	//AdminMain_TCManagement
					AdminMain_TCManagement adminMain_tcManagement = new AdminMain_TCManagement();
					adminMain_tcManagement.start();
					break;
				case "2" :	//AdminMain_OPManagemet
					AdminMain_OPManagemet adminMain_opManagement = new AdminMain_OPManagemet();
					adminMain_opManagement.start();
					break;
				case "3" :	//AdminMain_OSManagement
					AdminMain_OsManagement adminMain_osManagement = new AdminMain_OsManagement();
					adminMain_osManagement.start();
					break;
				case "4" :	//AdminMain_SManagement
					AdminMain_SManagement adminMain_sManagement = new AdminMain_SManagement();
					adminMain_sManagement.start();
					break;
				case "5" :	//AdminMain_ScoreSearch
					AdminMain_ScoreSearch adminMain_scoreSearch = new AdminMain_ScoreSearch();
					adminMain_scoreSearch.start();
					break;
				case "6" :	//AdminMain_AttendanceSearch
					AdminMain_AttendanceSearch adminMain_attendanceSearch = new AdminMain_AttendanceSearch();
					adminMain_attendanceSearch.start();
					break;
				case "7" :	//AdminMain_TeacherEvalSearch  
					AdminMain_TeacherEvalSearch adminMain_teacherEvalSearch = new AdminMain_TeacherEvalSearch();
					adminMain_teacherEvalSearch.start();
					break;
				case "8" :	//AdminMain_TaskSearch
					AdminMain_TaskSearch adminMain_taskSearch = new AdminMain_TaskSearch();
					adminMain_taskSearch.start();
					break;
				case "0" :
					loop = !loop;
					break;
				default :
					continue;
					
			}//switch
		}//while
	}//adminMain
	
}
