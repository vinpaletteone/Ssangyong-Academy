package admin;

import java.util.ArrayList;
import java.util.Scanner;

import admin.dao.Admin_OSManagementDAO;
import admin.dto.Admin_vwOpenProcessSubjectDTO;
import admin.dto.Admin_vwOpenSubjectDTO;
import admin.dto.Admin_vwProcessSubjectDTO;
import admin.view.Admin_OSManagementView;

/**
 * 
 * @author 유승현
 * 관리자 - 개설 과목 관리
 */
public class AdminMain_OsManagement {
	private Scanner scanner;
	private Admin_OSManagementView av;
	private Admin_OSManagementDAO dao;

	public AdminMain_OsManagement() {
		scanner = new Scanner(System.in);
		av = new Admin_OSManagementView();
		dao = new Admin_OSManagementDAO();
	}
	
	/**
	 * AdminMain_OsManagement 시작
	 */
	public void start() {
		
		ArrayList<Admin_vwOpenSubjectDTO> osList = new ArrayList<Admin_vwOpenSubjectDTO>();
		ArrayList<Admin_vwOpenProcessSubjectDTO> opSubjectList = new ArrayList<Admin_vwOpenProcessSubjectDTO>();
		
		boolean loop = true;
		while(loop) {
			boolean switchloop = true;
			
			//개설과정 출력
			osList = dao.openSubjectList();
			
			av.osManagementView(osList);
			
			String seq = scanner.nextLine();
			
			if(seq.equals("")) {
				loop = !loop;
				break;
			}else {
				
			}
			
			//개설과정의 개설과목 출력
			opSubjectList = dao.opSubjectList(seq);
			
			av.opSubjectListView(opSubjectList);
			
			String sel = scanner.nextLine();
			
			if(sel.length() == 1) {
				switch (sel.toLowerCase().charAt(0)) {
					case 'a' : //추가
						ArrayList<Admin_vwProcessSubjectDTO> subjectList = new ArrayList<Admin_vwProcessSubjectDTO>();
						subjectList = dao.psList(seq);
						
						while(switchloop) {
							//과정과목 출력
							av.psListView(subjectList);
							
							String addsel = scanner.nextLine();
							
							if(addsel.equals("")) {
								switchloop = false;
								continue;
							}
							
							int result = dao.addOpenSubject(seq, addsel);
							
							if(result > 0) {
								av.pass();
							}else{
								av.fail();
							}
						}
						break;
					case 'b' : //삭제
						
						while(switchloop) {
							av.deleteView();
							String delsel = scanner.nextLine();
							
							if(delsel.equals("")) {
								switchloop = false;
								continue;
							}
							
							int result = dao.delOpenSubject(delsel);
							
							if(result > 0) {
								av.pass();
							}else {
								av.fail();
							}
						}
						
						break;
					default :
						switchloop = !switchloop;
						break;
				}
			}
		}
	}
}
