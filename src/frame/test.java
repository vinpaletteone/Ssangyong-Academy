//package frame;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import data.ReadFile;
//import data.WriterFile;
//
//public class test {
//	
//	Scanner scan;
//	ReadFile readFile;
//	WriterFile writerFile;
//
//	
//	static List<String> rentaledBooks;
//	static List<String> rentalingBooks;
//	static List<String> reservedBooks;
//	
//	public AfterUserLogin() {
//		
//		this.scan = new Scanner(System.in);
//		this.writerFile = new WriterFile();
//		this.readFile = new ReadFile();
//		
//	}
//	
//	static {
//		rentaledBooks = new ArrayList<String>();
//		rentalingBooks = new ArrayList<String>();
//		reservedBooks = new ArrayList<String>();
//	}
//	
//
//	public void afterLoginScreen() {
//		
//		Login login = new Login();
//		Notice notice = new Notice();
//		
////		System.out.println();
////		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
////		System.out.println("┃               [메인메뉴]              ┃");
////		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
////		
//		//로그인 했을 때 알림 띄우기
//		notice.overDueNotice();
//		
//
//		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//		System.out.println("┃  1. 도서 대여                         ┃");
//		System.out.println("┃  2. 도서 반납                         ┃");
//		System.out.println("┃  3. 내 서재                           ┃");
//		System.out.println("┃  4. 로그아웃                          ┃");
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//		System.out.print("선택(숫자) : ");
//		
//
//		String sel = scan.nextLine();
//
//		if (sel.equals("1")) {
//			rentalBookScreen();
//		} else if (sel.equals("2")) {
//			returnBookScreen();
//		} else if (sel.equals("3")) {
//			myPageScreen();
//		} else if (sel.equals("4")) {
//			login.logoutScreen();
//		}
//
//	}// loginAfterScreen
//
//	// 도서 대여 화면
//	public void rentalBookScreen() {
//		
//		Search search = new Search();
//		Rental rental = new Rental();
//
//		
//		System.out.println();
//		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//		System.out.println("┃               [도서대여]               ┃");
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//
//		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//		System.out.println("┃  1. 제목 검색                          ┃");
//		System.out.println("┃  2. 저자 검색                          ┃");
//		System.out.println("┃  3. 출판사 검색                        ┃");
//		System.out.println("┃  4. 나가기                             ┃");
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//		System.out.print("선택(숫자) : ");
//
//		
//		String sel = scan.nextLine();
//	
//		if (sel.equals("1") || sel.equals("2") || sel.equals("3")) {
//			search.searchScreen(sel);
//			
//		} else if (sel.equals("4")) {
//			afterLoginScreen();
//		} else {
//			System.out.println("1-4의 숫자를 입력해주세요.");
//			rentalBookScreen();
//		}
//
//	} // rentalBookScreen
//	
//	
//	// 도서 반납 화면
//	public void returnBookScreen() {
//		
//
//		Return rt = new Return();
//		Extension extension = new Extension();
//		
//		// 회원이 대여한 목록 가져와서 보여주기(메소드)
//		// userNowRentalList();
//		
//		System.out.println();
//		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"); 
//		System.out.println("┃              [도서반납]               ┃");
//		System.out.println("┃                                       ┃");
//		System.out.println("┃  1. 반납하기                          ┃");
//		System.out.println("┃  2. 연장하기                          ┃");
//		System.out.println("┃  2. 나가기                            ┃");
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//		System.out.print("선택(숫자) : ");
//		String sel = scan.nextLine();
//		
//		if (sel.equals("1")) {
//			// 반납하기
//			rt.returnBook();
//		} else if (sel.equals("2")) {
//			// 연장하기
//			extension.extensionRentalDate();
//		} else if (sel.equals("3")) {
//			afterLoginScreen(); // 나가기
//		} else {
//			System.out.println("1-3의 숫자를 입력해주세요.");
//			returnBookScreen();
//		}
//
//	} // returnBookScreen
//
//	
//	
//	
//
//	// 내 서재(마이페이지) 화면
//	public void myPageScreen() {
//		
//		MyPage myPage = new MyPage();
//		
//		System.out.println();
//		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"); 
//		System.out.println("┃               [내  서재]              ┃");
//		System.out.println("┃                                       ┃");
//		System.out.println("┃  1. 대여했던 도서 보기                ┃");
//		System.out.println("┃  2. 대여중인 도서 보기                ┃");
//		System.out.println("┃  3. 예약한 도서 보기                  ┃");
//		System.out.println("┃  4. 나의 리뷰 보기                    ┃");
//		System.out.println("┃  5. 나가기                            ┃");
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//
//				
//		System.out.print("선택(숫자) : ");
//		String sel = scan.nextLine();
//		
//		if (sel.equals("1")) {
//			//1. 대여했던 도서 보기
//			myPage.saveUserPastRentalList();
//			myPage.printRentaledBooks();
//			
//			myPageScreen();
//		}
//		if (sel.equals("2")) {
//
//			// 2. 대여중인 도서 보기
//			myPage.saveUserNowRentalList();
//			myPage.printRentalingBooks();
//			myPageScreen();
//		}
//		if (sel.equals("3")) {
//			// 3. 예약한 도서 보기
//			myPage.saveUserReserveList();
//			myPage.printReservedBooks();
//			myPageScreen();
//		}
//		if (sel.equals("4")) {
//			// 4. 나의 리뷰 보기
//			myPage.userReviewList();
//		}
//		if (sel.equals("5")) {
//			// 5. 로그인 후 첫 화면으로
//			afterLoginScreen();
//		}
//
//	} // myPageScreen
//
//}
