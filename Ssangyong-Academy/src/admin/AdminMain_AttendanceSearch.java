package admin;

/**
 * @author 송재원
 * 학생 근태조회
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

import admin.dao.AdminMain_AttendanceSearchDAO;
import admin.dto.AdminMain_AttendanceSearchDTO;
import admin.view.AdminView2;

public class AdminMain_AttendanceSearch {

	private Scanner scan;
	private AdminView2 av2;

	public AdminMain_AttendanceSearch() {
		scan = new Scanner(System.in);
		av2 = new AdminView2();
	}

	public void start() {
		
		boolean loop = true;
		while(loop) {
			AdminMain_AttendanceSearchDAO dao = new AdminMain_AttendanceSearchDAO();
			
			ArrayList<AdminMain_AttendanceSearchDTO> list = new ArrayList<AdminMain_AttendanceSearchDTO>();
			// 전체 학생 근태 목록 보기
			list = dao.VwAttendancrSearchList();
			
			av2.VwAttendancrSearchList(list);
			
			scan.nextLine();
			
			
			// 학생 근태 조회
			dao = new AdminMain_AttendanceSearchDAO();
			list = new ArrayList<AdminMain_AttendanceSearchDTO>();
			
			av2.SearchStudentSelet();
			String name = scan.nextLine();
			
			if(name.equals("")) {
				loop = !loop;
				continue;
			}
			
			list = dao.SearchStudentAtt(name);
			
			av2.SearchStudentAtt(list);
			scan.nextLine();
			
		}

	}

}
