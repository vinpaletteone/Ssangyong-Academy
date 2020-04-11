package admin;

import java.util.ArrayList;
import java.util.Scanner;

import admin.dao.Admin_OSManagementDAO;
import admin.dao.Admin_ScoreSearchDAO;
import admin.dto.Admin_vwAdminStudentScoreDTO;
import admin.dto.Admin_vwOpenProcessSubjectDTO;
import admin.dto.Admin_vwOpenSubjectDTO;
import admin.view.Admin_ScoreSearchView;
import commonDTO.StudentDTO;

/**
 * 
 * @author 유승현
 * 관리자 - 점수조회
 */
public class AdminMain_ScoreSearch {
	private Admin_ScoreSearchView av;
	private Admin_ScoreSearchDAO dao;
	private Admin_OSManagementDAO osdao;
	private Scanner scanner;
	
	
	public AdminMain_ScoreSearch(){
		av = new Admin_ScoreSearchView();
		dao = new Admin_ScoreSearchDAO();
		osdao = new Admin_OSManagementDAO();
		scanner = new Scanner(System.in);
	}

	/**
	 * AdminMain_ScoreSearch 시작
	 */
	public void start() {
		
		boolean loop = true;
		
		while(loop) {
			
			av.scoreSearchStart();
			String sel = scanner.nextLine();
			
			if(sel.equals("1")) { // 1. 과목별 성적 조회
				ArrayList<Admin_vwOpenSubjectDTO> osList = new ArrayList<Admin_vwOpenSubjectDTO>();
				ArrayList<Admin_vwOpenProcessSubjectDTO> opSubjectList = new ArrayList<Admin_vwOpenProcessSubjectDTO>();
				
				//개설과정 출력
				osList = osdao.openSubjectList();
				
				av.openSubjectListView(osList);
				
				String seq = scanner.nextLine();
				av.returnEnter();
				
				if(seq.equals("")) {
					continue;
				}
				
				//개설과정의 개설과목 출력
				opSubjectList = osdao.opSubjectList(seq);
				av.opSubjectListView(opSubjectList);
				
				String ossel = scanner.nextLine();
				
				if(ossel.equals("")) {
					continue;
				}
				
				//선택한 개설과목의 학생 성적목록 가져오기
				ArrayList<Admin_vwAdminStudentScoreDTO> subjectScoreList = new ArrayList<Admin_vwAdminStudentScoreDTO>();

				subjectScoreList = dao.selectSubjectScoreList(ossel);
				
				if(subjectScoreList.size() == 0) {
					av.noresult();
				}else {
					av.subjectScoreListView(subjectScoreList);
				}
				av.returnEnter();
				scanner.nextLine();
				
			}else if(sel.equals("2")) { //2. 학생별 성적 조회
				ArrayList<StudentDTO> studentList = new ArrayList<StudentDTO>();
				
				studentList = dao.studentList();
				
				av.studentListView(studentList);
				
				String studentSel = scanner.nextLine();
				
				if(studentSel.equals("")) {
					continue;
				}
				
				//선택한 학생의 성적 가져오기
				ArrayList<Admin_vwAdminStudentScoreDTO> studentScoreList = new ArrayList<Admin_vwAdminStudentScoreDTO>();
				
				studentScoreList = dao.selectStudentScore(studentSel);
				
				//가져온 성적 출력하기
				if(studentScoreList.size() == 0) {
					av.noresult();
				}else {
					av.studentScoreListView(studentScoreList);
				}
				av.returnEnter();
				scanner.nextLine();
				
			}else if(sel.equals("0")) { //0. 돌아가기
				loop = !loop;
			}else {	// 잘못된 선택
				av.error();
			}
		}
	}
}
