package frame;

import java.util.Scanner;

import common.UserClass;
import data.ReadFile;
import data.WriterFile;

public class Update {

	Scanner scan = new Scanner(System.in);
	WriterFile writerFile = new WriterFile();
	AfterUserLogin afterUserLogin = new AfterUserLogin();

	// 본인 비밀번호 수정
	public void updateUserPW() {

		System.out.print("새 비밀번호: ");
		String password = scan.nextLine();

		for (UserClass user : ReadFile.users) {
			if (user.getUserNo().equals(ReadFile.userNo)) {
				user.setPassword(password);
			}
		}

		writerFile.writeUserFile();
		System.out.println("<<수정되었습니다.>>");

		afterUserLogin.updateUserInfoScreen();

	}

	//본인 전화번호 수정
	public void updateUserTel() {
		System.out.print("새 전화번호: ");
		String phone = scan.nextLine();

		for (UserClass user : ReadFile.users) {
			if (user.getUserNo().equals(ReadFile.userNo)) {
				user.setPhone(phone);
			}
		}

		writerFile.writeUserFile();
		System.out.println("<<수정되었습니다.>>");

		afterUserLogin.updateUserInfoScreen();

	}

	
	// 본인 생일 수정
	public void updateUserBirth() {
		System.out.print("새 생년월일: ");
		String birth = scan.nextLine();

		for (UserClass user : ReadFile.users) {
			if (user.getUserNo().equals(ReadFile.userNo)) {
				user.setBirth(birth);
			}
		}

		writerFile.writeUserFile();
		System.out.println("<<수정되었습니다.>>");

		afterUserLogin.updateUserInfoScreen();
	}

}
