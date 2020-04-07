package frame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.RentalClass;
import data.ReadFile;
import data.WriterFile;

public class AfterUserLogin {
	
	Scanner scan;
	ReadFile readFile;
	WriterFile writerFile;

	
	static List<String> rentaledBooks;
	static List<String> rentalingBooks;
	static List<String> reservedBooks;
	
	List<String> sarray = new ArrayList<String>();
	
	
	public AfterUserLogin() {
		
		this.scan = new Scanner(System.in);
		this.writerFile = new WriterFile();
		this.readFile = new ReadFile();
		
	}
	
	static {
		rentaledBooks = new ArrayList<String>();
		rentalingBooks = new ArrayList<String>();
		reservedBooks = new ArrayList<String>();
	}
	

	public void afterLoginScreen() {
		
		Login login = new Login();
//		Login2 login = new Login2();
		Notice notice = new Notice();
		
//		System.out.println();
//		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//		System.out.println("┃                   [메인메뉴]                  ┃");
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//		
		//로그인 했을 때 알림 띄우기
		notice.overDueNotice();
		

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 도서 대여                                 ┃");
		System.out.println("┃  2. 도서 반납                                 ┃");
		System.out.println("┃  3. 내 서재                                   ┃");
		System.out.println("┃  4. 로그아웃                                  ┃");
		System.out.println("┃  5. 내 정보 수정                              ┃");
		System.out.println("┃  6. 회원탈퇴                                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("선택(숫자) : ");
		

		String sel = scan.nextLine();

		if (sel.equals("1")) {
			rentalBookScreen();
		} else if (sel.equals("2")) {
			returnBookScreen();
		} else if (sel.equals("3")) {
			myPageScreen();
		} else if (sel.equals("4")) {
			login.logoutScreen();
		} else if (sel.equals("5")) {
			updateUserInfoScreen();
		} else if (sel.equals("6")) {
			deleteUser();
		} else {
			System.out.println("1-6의 숫자를 입력해주세요.");
			afterLoginScreen();
		}

	}// loginAfterScreen

	




	// 도서 대여 화면
	public void rentalBookScreen() {
		
		Search search = new Search();
		Rental rental = new Rental();

		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [도서대여]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 제목 검색                                 ┃");
		System.out.println("┃  2. 저자 검색                                 ┃");
		System.out.println("┃  3. 출판사 검색                               ┃");
		System.out.println("┃  4. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("선택(숫자) : ");

		
		String sel = scan.nextLine();
	
		if (sel.equals("1") || sel.equals("2") || sel.equals("3")) {
			search.searchScreen(sel);
		} else if (sel.equals("4")) {
			afterLoginScreen();
		} else {
			System.out.println("1-4의 숫자를 입력해주세요.");
			rentalBookScreen();
		}

	} // rentalBookScreen
	
	
	// 도서 반납 화면
	public void returnBookScreen() {
		

		Return rt = new Return();
		Extension extension = new Extension();
		
		// 회원이 대여한 목록 가져와서 보여주기(메소드)
		// userNowRentalList();
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"); 
		System.out.println("┃                  [도서반납]                   ┃");
		System.out.println("┃                                               ┃");
		System.out.println("┃  1. 반납하기                                  ┃");
		System.out.println("┃  2. 연장하기                                  ┃");
		System.out.println("┃  3. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("선택(숫자) : ");
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {
			// 반납하기
			rt.returnBook();
		} else if (sel.equals("2")) {
			// 연장하기
			extension.extensionRentalDate();
		} else if (sel.equals("3")) {
			afterLoginScreen(); // 나가기
		} else {
			System.out.println("1-3의 숫자를 입력해주세요.");
			returnBookScreen();
		}

	} // returnBookScreen

	
	
	

	// 내 서재(마이페이지) 화면
	public void myPageScreen() {
		
		MyPage myPage = new MyPage();
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"); 
		System.out.println("┃                   [내  서재]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"); 
		System.out.println("┃  1. 대여했던 도서 보기                        ┃");
		System.out.println("┃  2. 대여중인 도서 보기                        ┃");
		System.out.println("┃  3. 예약한 도서 보기                          ┃");
		System.out.println("┃  4. 나의 리뷰 보기                            ┃");
		System.out.println("┃  5. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

				
		System.out.print("선택(숫자) : ");
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {
			//1. 대여했던 도서 보기
			myPage.saveUserPastRentalList();
			myPage.printRentaledBooks();
			
			myPageScreen();
		}
		if (sel.equals("2")) {

			// 2. 대여중인 도서 보기
			myPage.saveUserNowRentalList();
			myPage.printRentalingBooks();
			myPageScreen();
		}
		if (sel.equals("3")) {
			// 3. 예약한 도서 보기
			myPage.saveUserReserveList();
			myPage.printReservedBooks();
			myPageScreen();
		}
		if (sel.equals("4")) {
			// 4. 나의 리뷰 보기
			myPage.userReviewList();
		}
		if (sel.equals("5")) {
			// 5. 로그인 후 첫 화면으로
			afterLoginScreen();
		}

	} // myPageScreen
	
	
	// 회원 정보 수정 화면
	public void updateUserInfoScreen() {
		
		Update update = new Update();
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"); 
	    System.out.println("┃                 [회원수정]                    ┃");
	    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
	    System.out.println("┃  1. 비밀번호수정                              ┃");
	    System.out.println("┃  2. 생년월일수정                              ┃");
	    System.out.println("┃  3. 전화번호수정                              ┃");
	    System.out.println("┃  4. 나가기                                    ┃");
	    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	    
	    
	    System.out.print("선택(숫자): ");
	    String sel = scan.nextLine();

	    if (sel.equals("1")) {
	       update.updateUserPW();
	    } else if (sel.equals("2")) {
	       update.updateUserBirth();
	    } else if (sel.equals("3")) {
	       update.updateUserTel();
	    }else if(sel.equals("4")) {
	    	afterLoginScreen();
	    } else {
	       System.out.println("1-4의 번호를 입력해주세요.");
	       updateUserInfoScreen();
	    }

	} // updateUserInfoScreen
	

	
	// 회원 탈퇴(삭제) 
	//대여한 책이 있으면 회원 탈퇴 못 하게
	private void deleteUser() {
		
		Login login = new Login();
		List<String> array = new ArrayList<String>();
		
		//로그인 한 회원의 리스트 내에서의 인덱스(방번호) 알아오기 
		int index = 0;
		for (int i=0; i<ReadFile.users.size(); i++) {
			if (ReadFile.users.get(i).getUserNo().equals(ReadFile.userNo)) {
				index = i;
			}
		}
		
		boolean flag = true;
		//로그인 한 회원이 빌린 책이 있을 때 (반납하지 않음)
		for (RentalClass rental : ReadFile.rentals) {
			if (rental.getUserNo().indexOf(ReadFile.userNo) > -1 
					&& rental.getReturnState().equals("대여중")) {
				flag = false; //탈퇴 불가
				
			} 
		}
		
		if (flag) {
			//회원 탈퇴(삭제)
			ReadFile.users.remove(index);
			writerFile.writeUserFile();
			
			System.out.println("<<탈퇴가 완료되었습니다.>>");
			login.mainScreen();
		} else {
			//회원 탈퇴(삭제) 불가
			System.out.println("<<대여중인 책이 있습니다. 탈퇴가 불가합니다.>>");
			afterLoginScreen();

		}
		
		System.out.println();
		System.out.println();

	} // deleteUserScreen

}
