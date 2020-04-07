package frame;

import java.util.Calendar;
import java.util.Scanner;

import common.BookClass;
import common.RentalClass;
import common.ExtensionClass;
import data.ReadFile;
import data.WriterFile;

public class Extension {

	static Scanner scan;
	AfterUserLogin afteruserLogin;
	WriterFile writerFile;
	ReadFile readFile;
	MyPage myPage;

	public Extension() {
		this.afteruserLogin = new AfterUserLogin();
		this.writerFile = new WriterFile();
		this.readFile = new ReadFile();
		this.myPage = new MyPage();
	}

	static {
		scan = new Scanner(System.in);
	}

	// 연장하기
	public void extensionRentalDate() {

		myPage.saveUserNowRentalList();
		myPage.printRentalingBooks();

		String bookNumber = "";
		// 대여중인 책이 없을 때
		if (AfterUserLogin.rentalingBooks.size() == 0) {
			afteruserLogin.returnBookScreen();
		} else {
			System.out.print("연장할 도서 번호 : ");
			bookNumber = scan.nextLine();

		}

		// 현재 대여중인 것에서 연장하는 것.
		// 대여목록에 존재
		// 현재 도서 상태는 대여중 또는 연체함 또는 예약중

		// 제약사항
		// 1. 예약중일 때는 연장 못 함
		// 2. 연체되었으면 연장 못 함
		// 3. 연장은 한 번까지만.

		// 연장
		// 1. 도서목록에서 해당 도서의 상태를 연장함으로 변경
		// 2. 대여목록에서 해당 도서의 반납기한이 7일 증가
		// 3. 연장목록에서 연장 횟수가 1회 증가

		for (BookClass book : ReadFile.books) {

			// 입력한 도서번호의 도서 상태 변경하기
			if (book.getBookNo().equals(bookNumber)) {

				if (book.getBookState().equals("예약중")) {
					System.out.println("<<도서를 예약한 사람이 있습니다. 대여 기간을 연장할 수 없습니다.>>");
					afteruserLogin.returnBookScreen(); // 빠져나가기
				} else if (book.getBookState().equals("연체함")) {
					System.out.println("<<대여 기간이 연체되었습니다. 대여 기간을 연장할 수 없습니다.>>");
					afteruserLogin.returnBookScreen(); // 빠져나가기
				} else {

					// 연장횟수 검사
					checkExtensionCount(bookNumber);

					// 도서 상태 변경
					book.setBookState("연장함");
					// 반납기한 7일 연장
					extensionReturnDueDate(bookNumber);
					System.out.println("<<연장이 완료되었습니다.>>");
				}
			}
		}

		// 도서번호 00004
		// 대여번호 B00003
		// 연장번호 E00001

		// 확인용
//			for (Rental r : ReadFile.rentals) {
//				System.out.println(r);
//			}
//			
//			for (Book b : ReadFile.books) {
//				System.out.println(b);
//			}
//			
//			for (Extension e : ReadFile.extensions) {
//				System.out.println(e);
//			}

		// 변경된 연장목록 다시 쓰기
		writerFile.writeExtensionFile();

		// 변경된 도서목록 다시 쓰기
		writerFile.writeBookFile();

		// 변경된 대여목록 다시 쓰기
		writerFile.writeRentalFile();

		readFile.init();
		afteruserLogin.returnBookScreen();

	}// extensionRentalDate

	// 연장횟수 검사
	private void checkExtensionCount(String bookNumber) {
		String rentalNo = "";
		// 입력받은 도서번호로 대여번호 뽑아오기
		for (RentalClass r : ReadFile.rentals) {
			if (r.getBookNo().equals(bookNumber)) {
				rentalNo = r.getRentalNo();
			}
		}

		for (ExtensionClass e : ReadFile.extensions) {
			if (e.getRentalNo().equals(rentalNo)) {
				if (e.getExtensionCount() == 1) {
					// 연장불가
					System.out.println("<<대여 기간을 이미 1회 연장했습니다. 대여 기간을 연장할 수 없습니다.>>");
					afteruserLogin.returnBookScreen(); // 빠져나가기
				} else {
					// 연장 : 연장횟수 + 1
					e.setExtensionCount(e.getExtensionCount() + 1);
				}
			}
		}
	}// checkExtensionCount

	// 반납기한 7일 연장
	private void extensionReturnDueDate(String bookNumber) {

		for (RentalClass rental : ReadFile.rentals) {
			if (rental.getBookNo().equals(bookNumber)) {

				Calendar c = rental.getReturnDueDate();
				c.add(Calendar.DATE, 7);

				rental.setReturnDueDate(c);
			}
		}
	}// extensionReturnDueDate

}
