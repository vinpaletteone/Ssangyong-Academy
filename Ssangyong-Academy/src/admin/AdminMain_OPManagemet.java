package admin;

import java.util.ArrayList;
import java.util.Scanner;

import admin.dao.AdminMain_OPManagemetDAO;
import admin.dto.Admin_VwOpenProcessDTO;
import admin.dto.Admin_procOpenSubjectDTO;
import admin.dto.Admin_procStudentInfoDTO;
import admin.view.AdminView2;

/**
 * 
 * @author 송재원
 * 학생 개설과정 관리
 *
 */
public class AdminMain_OPManagemet {

	private Scanner scan;
	private AdminView2 av2;

	public AdminMain_OPManagemet() {
		scan = new Scanner(System.in);
		av2 = new AdminView2();
	}

	public void start() {

		boolean loop = true;
		
		while(loop) {
			
			AdminMain_OPManagemetDAO dao = new AdminMain_OPManagemetDAO();
			
			ArrayList<Admin_VwOpenProcessDTO> list = new ArrayList<Admin_VwOpenProcessDTO>();
			
			list = dao.VwopenprocessList();
			
			av2.openProcessView(list);
			
			String sel = scan.nextLine();
			
			try {
				Integer.parseInt(sel);
				
				ArrayList<Admin_procStudentInfoDTO> list2 = new ArrayList<Admin_procStudentInfoDTO>();
				
				list2 = dao.procStudentInfo(sel);
				
				av2.Admin_procStudentInfoDTO(list2);
				
				ArrayList<Admin_procOpenSubjectDTO> list3 = new ArrayList<Admin_procOpenSubjectDTO>();
				
				list3 = dao.procOpenSubject(sel);
				
				av2.Admin_procOpenSubjectDTO(list3);
				
				scan.nextLine();
				
			} catch (Exception e) {
				
				// 개설 과정 정보에 대한 등록 및 관리(입력 (1), 수정(2), 삭제(3), 돌아가기(4))
				
				switch (sel) {
				
				case "a": // 추가
					av2.AddProcess();
					
					av2.input();
					String name = scan.nextLine();
					
					av2.period();
					String period = scan.nextLine();
					
					int resultAdd = dao.AddProcess(name, period);
					
					if (resultAdd > 0) {
						System.out.println("추가 완료");
					} else {
						System.out.println("추가 X");
					}
					
					break;
					
				case "b": // 수정
					System.out.print("과정 번호 : ");
					String sel3 = scan.nextLine();
					
					System.out.print("과정 이름 입력 : ");
					String nameSel = scan.nextLine();
					System.out.print("과정 기간 입력 : ");
					String periodSel = scan.nextLine();
					
					int resultUpdate = dao.updateOpenProcess(sel3, nameSel, periodSel);
					
					if (resultUpdate > 0) {
						System.out.println("수정 완료");// 참
					} else {
						System.out.println("수정  X");// 거짓
					}
					
					break;
					
				case "c": // 삭제
					
					av2.seqDelete();
					String seqDelete = scan.nextLine();
					
					int resultDelete = dao.DeleteProcess(seqDelete);
					
					if (resultDelete > 0) {
						System.out.println("삭제 완료");
					} else {
						System.out.println("삭제 X");
					}
					
					break;
					
				default: // 돌아가기
					loop = !loop;
					break;
				}
			}
			
		}
		


//		av2.openProcessSelect();


//		String sel2 = scan.nextLine();


	}

}
