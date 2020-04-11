package main;
import java.util.Scanner;

import admin.AdminController;
import student.StudentMain;
import teacher.TeacherController;

/**
 * 
 * @author DB5조
 *
 */
public class MainController {
		
		private Scanner scanner;
		private MainView mv;
		
		MainController(){
			scanner = new Scanner(System.in);
			mv = new MainView();
		}
		
		public void mainStart() {
			boolean loop = true;
			
			while(loop) {
				mv.mainList();
				String sel = scanner.nextLine();
				switch(sel) {
				case "1" : //관리자 모드
					AdminController ac = new AdminController();
					ac.adminLogin();
					break;
				case "2" : //교사 모드
					TeacherController tc = new TeacherController();
					tc.login();
					break;
				case "3" : //학생 모드
					StudentMain sm = new StudentMain();
					sm.Start();
					break;
				case "0" : //종료
					loop = !loop;
					System.out.println();
					System.out.println("프로그램 종료");
					scanner.close();
					break;
				default : 
					continue;
				}
			}
		}
}
