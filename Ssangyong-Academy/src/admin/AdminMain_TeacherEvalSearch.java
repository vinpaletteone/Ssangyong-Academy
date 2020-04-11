package admin;

import java.util.ArrayList;
import java.util.Scanner;

import admin.dao.Admin_TeacherEvalSearchDAO;
import admin.dto.Admin_vwEndOpenProcessDTO;
import admin.dto.Admin_vwTeacherEvalDTO;
import admin.view.Admin_TeacherEvalSearchView;


/**
 * 
 * @author 유승현
 * 관리자 - 교사평가조회
 */
public class AdminMain_TeacherEvalSearch {
	private Scanner scanner;
	private Admin_TeacherEvalSearchView av;
	private Admin_TeacherEvalSearchDAO dao;
	
	public AdminMain_TeacherEvalSearch() {
		this.scanner = new Scanner(System.in);
		this.av = new Admin_TeacherEvalSearchView();
		this.dao = new Admin_TeacherEvalSearchDAO();
	}

	/**
	 * AdminMain_TeacherEvalSearch 시작
	 */
	public void start() {
		boolean loop = true;

		while(loop) {

			ArrayList<Admin_vwEndOpenProcessDTO> endOpenProcessList = new ArrayList<Admin_vwEndOpenProcessDTO>();

			endOpenProcessList = dao.openProcessList();

			av.endOpenProcessView(endOpenProcessList);

			String selOpenProcess = scanner.nextLine();
			
			if(selOpenProcess.equals("")) {
				loop = !loop;
				continue;
			}

			ArrayList<Admin_vwTeacherEvalDTO> teacherEvalList = new ArrayList<Admin_vwTeacherEvalDTO>();

			teacherEvalList = dao.teacherEvalList(selOpenProcess);

			av.teacherEvalView(teacherEvalList);
			scanner.nextLine();
		}
	} 
}
