package admin.view;


/**
 * 
 * @author 유승현
 * AdminController 관리자 모드 View
 */
public class AdminView {
	
	
	

	public void IDView() {
		System.out.print("ID 입력 : ");
	}

	public void PWView() {
		System.out.print("PW 입력 : ");
	}
	
	public void adminMain() {
		System.out.println("━━━━━━━ 관리자 페이지 ━━━━━━━");
		System.out.println("1. 교사 계정 관리            ");
		System.out.println("2. 개설 과정 관리            ");
		System.out.println("3. 개설 과목 관리            ");
		System.out.println("4. 교육생 관리               ");
		System.out.println("5. 시험 성적 조회            ");
		System.out.println("6. 교육생 출결 조회          ");
		System.out.println("7. 교사 평가 조회            ");
		System.out.println("8. 과제 조회                 ");
		System.out.println("0. 돌아가기                  ");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("선택(번호) : ");
	}

	public void fail() {
		System.out.println("찾을수 없는 계정입니다.");
	}

}
