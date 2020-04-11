package admin;

import java.util.ArrayList;
import java.util.Scanner;

import admin.dao.AdminMain_SManagementDAO;
import admin.dto.AdminMain_SManagementDTO;
import admin.dto.Admin_VwSelStudentDTO;
import admin.view.AdminView2;

/***
 * 
 * @author 송재원
 * 학생 관리 
 *
 */
public class AdminMain_SManagement {

	private Scanner scan;
	private AdminView2 av2;
	private AdminMain_SManagementDAO dao;
	private ArrayList<AdminMain_SManagementDTO> list;

	public AdminMain_SManagement() {
		scan = new Scanner(System.in);
		av2 = new AdminView2();
		dao = new AdminMain_SManagementDAO();
		list = new ArrayList<AdminMain_SManagementDTO>();
	}

	public void start() {

		boolean loop = true;

		while (loop) {

			System.out.println("1. 학생 목록 보기");
			System.out.println("2. 학생 정보 관리");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 뒤로가기");

			System.out.print("번호 선택 : ");
			String sel = scan.nextLine();

			switch (sel) {
			case "1": // 학생 목록 보기

				dao = new AdminMain_SManagementDAO();

				list = dao.VwMain_studentinfo();

				av2.ViewList(list);
				scan.nextLine();
				break;
			case "2": // 학생 정보 관리 (등록, 수정, 삭제)

				av2.AdminStudentTodo();

				String todoSel = scan.nextLine();

				switch (todoSel) {
				case "1": // 등록 > 교육생 이름, 주민번호 뒷자리, 전화번호
					av2.AddStudent();

					av2.StudentName();
					String StudentName = scan.nextLine();

					av2.StudentSsn();
					String StudentSsn = scan.nextLine();

					av2.StudentTel();
					String StudentTel = scan.nextLine();

					int resultAdd = dao.AddStudent(StudentName, StudentSsn, StudentTel);

					if (resultAdd > 0) {
						System.out.println("추가 완료");
					} else {
						System.out.println("추가 x");
					}

					break;
				// 수정
				case "2": // 수정
					av2.updateStudent();

					av2.UpdateSeq();
					String updateSeq = scan.nextLine();

					av2.updateName();
					String name = scan.nextLine();

					av2.updateSsn();
					String ssn = scan.nextLine();

					av2.updateTel();
					String tel = scan.nextLine();

					int resultUpdate = dao.UpdateStudent(name, ssn, tel, updateSeq);

					if (resultUpdate > 0) {
						System.out.println("수정 완료");
					} else {
						System.out.println("수정 X");
					}

					break;

				case "3":// 삭제
					av2.DeleteStudent();

					av2.DeleteSeq();
					String DeleteSeq = scan.nextLine();

					int resultDelete = dao.DeleteStudent(DeleteSeq);

					if (resultDelete > 0) {
						System.out.println("삭제 완료");
					} else {
						System.out.println("삭제 X");

					}

					break;

				default:

					break;
				}

				break;
			case "3": // 학생 정보 검색

				Admin_VwSelStudentDTO dto = new Admin_VwSelStudentDTO();
				av2.SearchStudent();

				av2.StudentNumber();
				String studentNum = scan.nextLine();

				dto = dao.SearchStudent(studentNum);

				av2.SearchStudent(dto);

				break;

			default:
				loop = !loop;
				break;
			}
		}

	}

}
