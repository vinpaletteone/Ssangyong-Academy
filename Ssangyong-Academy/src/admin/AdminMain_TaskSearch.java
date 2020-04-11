package admin;

import java.util.ArrayList;
import java.util.Scanner;

import admin.dao.AdminMain_TaskSearchDAO;
import admin.dto.AdminMain_TaskSearchDTO;
import admin.dto.ProcTeacherTaskCheckDTO;
import admin.dto.ProcTeacherTaskDTO;
import admin.view.AdminView2;
import commonDTO.TeacherDTO;

/***
 * 
 * @author 송재원
 *  과제 조회 관리
 *
 */
public class AdminMain_TaskSearch {

	private Scanner scan;
	private AdminView2 av2;

	public AdminMain_TaskSearch() {
		scan = new Scanner(System.in);
		av2 = new AdminView2();

	}

	public void start() {
		boolean loop = true;
		while(loop) {
			AdminMain_TaskSearchDAO dao = new AdminMain_TaskSearchDAO();
			
			ArrayList<AdminMain_TaskSearchDTO> list = new ArrayList<AdminMain_TaskSearchDTO>();
			// 과제
			list = dao.vwAdmin_scoreList();
			av2.vwAdmin_scoreList();
			
			// 특정 교사 선택 > 과정 선택 > 과목 선택 >> 어떻게 해???
			ArrayList<TeacherDTO> Teacherlist = new ArrayList<TeacherDTO>();
			Teacherlist = dao.teacherList();
			av2.Teacherlist(Teacherlist);
			
			av2.TaskTeacherSearch();
			String seq = scan.nextLine();
			
			if(seq.equals("")) {
				loop = !loop;
				continue;
			}
			
			ArrayList<ProcTeacherTaskDTO> subjectlist = dao.teacherTask(seq); // 과제목록
			
			av2.taskList(subjectlist); // 과제목록 출력
			
			System.out.print("과목번호 선택 : ");
			String select = scan.nextLine();
			
			ArrayList<ProcTeacherTaskCheckDTO> list2 = dao.teacherTaskCheck(seq, select); // 해당 과목과제 제출한 학생(교사번호, 과목번호)
			av2.taskCheck(list2); // 학생들 제출여부 출력
			scan.nextLine();
		}
			
	}
}
