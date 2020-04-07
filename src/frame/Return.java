package frame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

import common.BookClass;
import common.RentalClass;
import common.ReturnClass;
import data.Count;
import data.Path;
import data.ReadFile;
import data.WriterFile;

public class Return {
	
	static Scanner scan;
	AfterUserLogin afteruserLogin;
	WriterFile writerFile;
	ReadFile readFile;
	MyPage myPage;
	
	
	public Return() {
		this.afteruserLogin = new AfterUserLogin();
		this.writerFile = new WriterFile();
		this.readFile = new ReadFile();
		this.myPage = new MyPage();
	}
	
	static {
		scan = new Scanner(System.in);
	}
	
	//반납하기
	// 구현할 것 - 대여중인 도서 아닐 때 반납 못하게 하기
	// 반납했을 때 예약한 사람에게 알림

	public void returnBook() {

		myPage.saveUserNowRentalList();
		myPage.printRentalingBooks();

		String bookNumber = "";

		// 대여중인 도서가 없으면
		if (AfterUserLogin.rentalingBooks.size() == 0) {
			afteruserLogin.returnBookScreen();
		} else {
			System.out.print("반납할 도서 번호: ");
			bookNumber = scan.nextLine();

		}

//			for (Book book : ReadFile.books) {
//				if (book.getBookNo().equals(bookNumber) ) {
//					System.out.println("올바른 도서번호를 입력해주세요.");
//					returnBook();
//				}
//			}

		Calendar returnDueDate = null;

		// 1. 해당 도서의 반납여부 변경 대여중->반납
		// 2. 해당 도서를 반납목록에 추가
		// 3. 반납날짜 - 반납기한이 양수이면 연체된 것 -> 연체료 부과
		// 4. 도서 상태 변경 -> 대여가능
		// 4.

		// 2019-10-19 구현할 것
		// 해당 도서가 예약중이면 예약중 > 대여가능
		// 우선순위가 예약한 사람이 되어야 함
		
		// 예약 테이블에 있는 도서번호 뽑아와서
		// 대여 테이블에서 반납인지 확인
		// 반납이면 예약한 회원에게 알림
		// 도서상태는 여전히 예약중
		// 회원이 대여하면 그때 변경
		
		// 예약중일 때 대여 못하게 되어있는 것 바꾸기
		// 1. 예약중, 대여중 -> 대여 못함
		// 2. 예약중, 반납 -> 회원 정보 확인하고 대여
		
		// 구현 X
		// 예약중인데 반납되었을 경우
		// 대여를 일주일 안에 하지 않으면 대여 가능으로 변경
		

		String rentalNo = "";

		// 1.
		// 대여 목록 탐색
		for (RentalClass rentalBook : ReadFile.rentals) {

			// 입력한 도서번호와 대여목록의 도서번호가 같은 대여 정보에서 반납여부 변경하기
			if (rentalBook.getBookNo().equals(bookNumber)) {
				rentalBook.setReturnState("반납");

				// 반납 목록에 넣을 대여번호 가져오기
				rentalNo = rentalBook.getRentalNo();
				returnDueDate = rentalBook.getReturnDueDate();
			}
		}
		

		// 확인용
//			for (int i=0; i<ReadFile.rentals.size(); i++) {
//				System.out.println(String.format("%s■%s■%s■%tF■%tF■%s"
//						, ReadFile.rentals.get(i).getRentalNo()
//						, ReadFile.rentals.get(i).getUserNo()
//						, ReadFile.rentals.get(i).getBookNo()
//						, ReadFile.rentals.get(i).getRentalDate()
//						, ReadFile.rentals.get(i).getReturnDueDate()	
//						, ReadFile.rentals.get(i).getReturnState()));
//			}

		// 변경된 대여목록 다시 쓰기
		writerFile.writeRentalFile();

		// 2.
		// 반납번호 | 반납날짜 | 대여번호
		Count.returnCount++;
		ReturnClass returnBook = new ReturnClass();

		returnBook.setReturnNo(String.format("RT%05d", Count.returnCount)); // 반납번호
		returnBook.setReturnDate(ReadFile.loginDate); // 반납날짜 (오늘, 로그인 한 날짜) //안들어감
		returnBook.setRentalNo(rentalNo); // 대여번호 (위에서 가져온 것)

//			System.out.println(returnBook);
		ReadFile.returns.add(returnBook);

		// 3. 반납날짜 - 반납기한 틱값 계산

		// 도서 가격 가져오기
		int bookPrice = 0;
		for (BookClass b : ReadFile.books) {
			if (b.getBookNo().equals(bookNumber)) {
				bookPrice = b.getPrice();
			}
		}

		int overduePrice = 0; // 연체료
		Calendar canDateRental = Calendar.getInstance();

		String loginstrArray[] = String.format("%tF", ReadFile.loginDate).split("-");
		int lyear = Integer.parseInt(loginstrArray[0]);
		int lmonth = Integer.parseInt(loginstrArray[1]);
		int ldate = Integer.parseInt(loginstrArray[2]);

		canDateRental.set(lyear, lmonth, ldate);

		// 연체일수
		int overDateCount = (int) ((ReadFile.loginDate.getTimeInMillis() - returnDueDate.getTimeInMillis()) / 1000 / 60 / 60
				/ 24);
		if (overDateCount > 0 && overDateCount <= 29) { // 연체됨

			Count.overdueCount++; // 연체번호 +1

			// 연체료 부과
			if (overDateCount >= 1 && overDateCount <= 6) {
				// 연체일수 1~6일 : 도서 가격의 2.5%
				overduePrice = (int) (bookPrice * 0.025);

			} else if (overDateCount >= 7 && overDateCount <= 13) {
				// 연체일수 7~13일 : 도서 가격의 5%
				overduePrice = (int) (bookPrice * 0.05);

			} else if (overDateCount >= 14 && overDateCount <= 29) {
				// 연체일수 14~29일 : 도서 가격의 8%
				overduePrice = (int) (bookPrice * 0.08);

			}

			// 대여 가능 날짜 : 반납일(로그인 한 날짜, 오늘)로부터 연체일수 더한 것의 다음날
//				canDateRental.add(Calendar.DATE, overDateCount + 1);
//				
//				System.out.printf("%d일 연체되었습니다. %tF부터 도서 대여가 가능합니다.\n", overDateCount, canDateRental);

		} else if (overDateCount >= 30) {
			// 블랙리스트 구현
			// 로그인 한 회원을 블랙리스트 목록에 추가
			Count.blackUserCount++; // 블랙리스트 번호 +1
			try {

				BufferedWriter writerBlackUser = new BufferedWriter(new FileWriter(Path.BLACKLIST_FILE_PATH));
				writerBlackUser.write(String.format("BL%05d■%s", Count.blackUserCount, ReadFile.userNo));
				writerBlackUser.newLine();
				writerBlackUser.close();

			} catch (Exception e) {
				System.out.println("AfterUserLogin.returnBook() : " + e.toString());
			}

			System.out.printf("%d일 연체되었습니다. 책을 대여할 수 없습니다.", overDateCount);

		} else {
			
			//도서 상태 변경
			//대여가능
			
			for (BookClass book : ReadFile.books) {
				if (book.getBookNo().equals(bookNumber)) {
					book.setBookState("대여가능");
				}
			}
			//도서 파일 다시 쓰기
			writerFile.writeBookFile();
			System.out.println("<<반납이 완료되었습니다.>>");
		}
		

		// 파일 쓰기(append)
		try {

			// 반납목록에 반납도서 추가하기
			BufferedWriter writerRentalBook = new BufferedWriter(new FileWriter(Path.RETURN_FILE_PATH, true));
			writerRentalBook.write(String.format("RT%05d■%tF■%s", Count.returnCount, ReadFile.loginDate, rentalNo));
			writerRentalBook.newLine();
			writerRentalBook.close();

			// 연체목록에 연체도서 추가하기
//				BufferedWriter writerOverdueBook = new BufferedWriter(new FileWriter(Path.OVERDUE_FILE_PATH, true));
//				writerOverdueBook.write(String.format("O%05d■%s■%d■%d", Count.overdueCount, rentalNo, overDateCount, overduePrice));
//				writerOverdueBook.newLine();
//				writerOverdueBook.close();

		} catch (Exception e) {
			System.out.println("AfterUserLogin.returnBook() : " + e.toString());
		}

		// 파일 다시 읽기
		readFile.init();

		afteruserLogin.returnBookScreen();
	}// returnBook

}
