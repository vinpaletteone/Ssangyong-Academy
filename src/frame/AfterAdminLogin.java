package frame;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import common.BlackUserClass;
import common.BookClass;
import common.OverdueClass;
import common.RentalClass;
import common.UserClass;
import data.Count;
import data.Path;
import data.ReadFile;
import data.WriterFile;

public class AfterAdminLogin {

	static Scanner scan = new Scanner(System.in);

	public void afterLoginScreen() {

		Login login = new Login();

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [메인화면]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 도서관리                                  ┃");
		System.out.println("┃  2. 회원관리                                  ┃");
		System.out.println("┃  3. 조회                                      ┃");
		System.out.println("┃  4. 로그아웃                                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자) : ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			managementBookScreen();
		} else if (sel.equals("2")) {
			managementUserScreen();
		} else if (sel.equals("3")) {
			dataListScreen();
		} else if (sel.equals("4")) {
			login.logoutScreen();

		} else {
			System.out.println("1-4의 숫자를 입력해주세요.");
			afterLoginScreen();
		}

	}// loginAfterScreen

	private void managementBookScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [도서관리]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 도서목록                                  ┃");
		System.out.println("┃  2. 도서검색                                  ┃");
		System.out.println("┃  3. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			bookListScreen();
			// 1.도서 목록
		} else if (sel.equals("2")) {
			bookSearchScreen();
			// 2.도서검색
		} else if (sel.equals("3")) {
			afterLoginScreen();
		} else {
			System.out.println("1-3의 숫자를 입력해주세요.");
			managementBookScreen();
		}

	}// 도서관리 (managementBookScreen)

	private void bookListScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [도서목록]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		BookList bl = new BookList();
		bl.totalBookList(); // 전체 도서조회

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 도서등록                                  ┃");
		System.out.println("┃  2. 도서수정                                  ┃");
		System.out.println("┃  3. 도서삭제                                  ┃");
		System.out.println("┃  4. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			// 도서 등록
			insertBookScreen();
		} else if (sel.equals("2")) {
			// 도서 수정
			changeBookScreen();
		} else if (sel.equals("3")) {
			// 도서 삭제
			deleteBookScreen();
		} else if (sel.equals("4")) {
			// 이전 화면
			managementBookScreen();
		} else {
			System.out.println("1-4의 숫자를 입력해주세요.");
			bookListScreen();
		}
	}

	//도서 등록
	private void insertBookScreen() {
		
		String bookTitle = ""		//제목
				, author = ""		//저자
				, publisher = "";	//출판사
		int price = 0;				//가격
		
		Calendar cdate = Calendar.getInstance(); //등록날짜 - 로그인 한 날짜
		cdate.set(2019, 9, 16);
		
		
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [도서등록]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");

		
		System.out.print("  책 제목     : ");
		bookTitle = scan.nextLine();
		
		System.out.print("  저자 입력   : ");
		author = scan.nextLine();
		
		System.out.print("  출판사 입력 : ");
		publisher = scan.nextLine();

		System.out.print("  가격 입력   : ");
		price = Integer.parseInt(scan.nextLine());

		
		Count.bookCount++; //도서번호

		
		//책 추가
		BookClass book = new BookClass();

		book.setBookNo(String.format("%05d", Count.bookCount) );
		book.setBookTitle(bookTitle);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setInsertDate(cdate);
		book.setBookState("대여가능"); //상태 기본값 - 대여가능
		book.setReviewCount(0); //리뷰 개수 기본값 - 0

		ReadFile.books.add(book); //책 추가
		
		WriterFile wf = new WriterFile();
		wf.writeBookFile();

		System.out.println();
		System.out.println("  <<도서등록이 완료되었습니다.>>");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		

		managementBookScreen();

	}// 도서 등록

	private void changeBookScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [도서수정]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		String bookNo = "";
		boolean flag = true;
		while (flag) {
			
			System.out.print("도서번호 입력 : ");
			bookNo = scan.nextLine();
			
			//int index = -1;

			for (int i = 0; i < ReadFile.books.size(); i++) {
				if (ReadFile.books.get(i).getBookNo().equalsIgnoreCase(bookNo)) {
					//System.out.println(ReadFile.books.get(i));
					//index = i;
					flag = false;
				}
			}
			if (flag) {
				System.out.println("<도서가 존재하지 않습니다.>");
				changeBookScreen();
			}
			
		}
		

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 제목수정                                  ┃");
		System.out.println("┃  2. 저자수정                                  ┃");
		System.out.println("┃  3. 출판사수정                                ┃");
		System.out.println("┃  4. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			changeBookTitle(bookNo);
		} else if (sel.equals("2")) {
			changeBookAuthor(bookNo);
		} else if (sel.equals("3")) {
			changeBookPublisher(bookNo);
		} else if (sel.equals("4")) {
			bookListScreen();
		} else {
			System.out.println("1-4의 숫자를 입력해주세요.");
			changeBookScreen();
		}

	}// 도서 수정

	private void changeBookTitle(String bookNo) {

		System.out.print("수정할 제목 입력 :");
		String title = scan.nextLine();

		for (BookClass book : ReadFile.books) {
			if (book.getBookNo().equals(bookNo)) {
				book.setBookTitle(title);
				WriterFile writerFile = new WriterFile();
				writerFile.writeBookFile();
			}
		}

		bookListScreen();

	}

	private void changeBookAuthor(String bookNo) {

		System.out.print("수정할 저자 입력 :");
		String author = scan.nextLine();

		for (BookClass book : ReadFile.books) {
			if (book.getBookNo().equals(bookNo)) {
				book.setAuthor(author);
				WriterFile writerFile = new WriterFile();
				writerFile.writeBookFile();
			}
		}

		bookListScreen();

	}

	private void changeBookPublisher(String bookNo) {

		System.out.print("수정할 출판사 입력 :");
		String publisher = scan.nextLine();

		for (BookClass book : ReadFile.books) {
			if (book.getBookNo().equals(bookNo)) {
				book.setPublisher(publisher);
				WriterFile writerFile = new WriterFile();
				writerFile.writeBookFile();
			}
		}

		bookListScreen();

	} // changeBookPublisher

	// 구현할 것
	// 대여중인 도서일 때 삭제 못함
	private void deleteBookScreen() {
		
		//도서 목록 띄우기 
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 도서번호 입력: ");
		String line = scan.nextLine();

		for (BookClass book : ReadFile.books) {
			if (book.getBookNo().equals(line)) {
				File file = new File(Path.BOOK_FILE_PATH);

			}
		}
		bookListScreen();

	} // 도서삭제

	private void bookSearchScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [도서검색]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 제목검색                                  ┃");
		System.out.println("┃  2. 저자검색                                  ┃");
		System.out.println("┃  3. 출판사검색                                ┃");
		System.out.println("┃  4. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			bookListScreen();
			// 1.도서 목록
		} else if (sel.equals("2")) {
			bookSearchScreen();
			// 2.도서검색
		} else if (sel.equals("3")) {
			afterLoginScreen();
		} else {
			System.out.println("1-3의 숫자를 입력해주세요.");
			bookSearchScreen();
		}

	}// 도서 검색

	private void managementUserScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                  [회원관리]                   ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 회원관리                                  ┃");
		System.out.println("┃  2. 회원검색                                  ┃");
		System.out.println("┃  3. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			userListScreen();
		} else if (sel.equals("2")) {
			searchUserScreen();
		} else if (sel.equals("3")) {
			afterLoginScreen();
		} else {
			System.out.println("1-3의 숫자를 입력해주세요.");
			managementUserScreen();
		}

	}// 회원관리

	//회원관리 - 회원관리 화면
	private void userListScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 회원등록                                  ┃");
		System.out.println("┃  2. 회원수정                                  ┃");
		System.out.println("┃  3. 회원삭제                                  ┃");
		System.out.println("┃  4. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			// 회원 등록
			insertUser();
		} else if (sel.equals("2")) {
			changeUserScreen();
		} else if (sel.equals("3")) {
			deleteUserScreen();
		} else if (sel.equals("4")) {
			managementUserScreen();
		} else {
			System.out.println("1-4의 숫자를 입력해주세요.");
			userListScreen();
		}
	}

	// 회원 등록
	private void insertUser() {
		try {
			FileReader reader = new FileReader(Path.USER_FILE_PATH);

			String temp = "";
			int code = -1;

			while ((code = reader.read()) != -1) {
				temp += (char) code;
			}

			reader.close();

			System.out.println(temp);
			String[] lines = temp.split("\r\n");

			for (int i = 0; i < lines.length; i++) {
				String[] items = lines[i].split("■");
				UserClass user = new UserClass();

				ReadFile.users.set(i, user);

				ReadFile.users.get(i).setUserNo(items[0]);
				ReadFile.users.get(i).setId(items[1]);
				ReadFile.users.get(i).setPassword(items[2]);
				ReadFile.users.get(i).setName(items[3]);
				ReadFile.users.get(i).setBirth(items[4]);
				ReadFile.users.get(i).setPhone(items[5]);

				// System.out.println(lines[i]);

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		userListScreen();
	}

	//회원 수정
	private void changeUserScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [회원수정]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		
		String userNum = "";
		boolean flag = true;
		while (flag) {
			
			System.out.print("수정할 회원 번호 : ");
			userNum = scan.nextLine();
			

			for (int i = 0; i < ReadFile.users.size(); i++) {				
				if (ReadFile.users.get(i).getUserNo().equalsIgnoreCase(userNum)) {
					System.out.println(ReadFile.users.get(i));
					flag = false;
				}
			}
			if (flag) {
				System.out.println("회원이 존재하지 않습니다.");
				userListScreen();
			}
		}

		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 비밀번호수정                              ┃");
		System.out.println("┃  2. 생년월일수정                              ┃");
		System.out.println("┃  3. 전화번호수정                              ┃");
		System.out.println("┃  4. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			changeUserPW(userNum);
		} else if (sel.equals("2")) {
			changeUserBirth(userNum);
		} else if (sel.equals("3")) {
			changeUserTel(userNum);
		} else if (sel.equals("4")) {
			userListScreen();
		} else {
			System.out.println("1-4의 번호를 입력해주세요.");
			changeUserScreen();
		}
	}

	private void changeUserTel(String userNum) {
		System.out.print("전화번호: ");
		String changUserTel = scan.nextLine();

		WriterFile writerFile = new WriterFile();

		for (UserClass user : ReadFile.users) {
			if (user.getUserNo().equals(userNum)) {
				user.setPhone(changUserTel);
			}

		}
		writerFile.writeUserFile();
		System.out.println("변경되었습니다.");
		userListScreen();
	}

	//
	private void changeUserPW(String userNum) {
		System.out.print("비밀번호: ");
		String changUserPW = scan.nextLine();
		
		WriterFile writerFile2 = new WriterFile();
		
		for (UserClass user : ReadFile.users) {
			if (user.getUserNo().equals(userNum)) {
				user.setPassword(changUserPW);
			}
		}
		
		writerFile2.writeUserFile();
		System.out.println("변경되었습니다.");
		userListScreen();

	}

	//
	private void changeUserBirth(String userNum) {
		
		System.out.print("생년월일: ");
		String changUserBirth = scan.nextLine();
		
		WriterFile writerFile3 = new WriterFile();

		for (UserClass user : ReadFile.users) {
			if (user.getUserNo().equals(userNum)) {
				user.setBirth(changUserBirth);
			}

		}
		writerFile3.writeUserFile();
		System.out.println("변경되었습니다.");
		
		userListScreen();
	}

	// 대여한 책 있으면 삭제 못함
	private void deleteUserScreen() {
		System.out.println("삭제할 번호를 선택해주세요.");
		System.out.print("회원번호 : ");
		
		String sel = scan.nextLine();
		userListScreen();

	}

	private void searchUserScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [회원검색]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 회원번호검색                              ┃");
		System.out.println("┃  2. 이름검색                                  ┃");
		System.out.println("┃  3. 아이디검색                                ┃");
		System.out.println("┃  4. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			printUserInfo(searchUserNum());
		} else if (sel.equals("2")) {
			printUserInfo(searchUserName());
		} else if (sel.equals("3")) {
			printUserInfo(searchUserID());
		} else if (sel.equals("4")) {
			managementUserScreen();
		} else {
			System.out.println("1-4의 숫자를 입력해주세요.");
			searchUserScreen();
		}
	}

	//회원번호 검색
	//유일함
	private String searchUserNum() {
		
		String userNo = "";

		System.out.print("번호: ");
		userNo = scan.nextLine();
		
		return userNo;

	}//searchUserNum

	//이름 검색
	//동명이인 있을 수 있음
	private List<String> searchUserName() {
		String userName = "";
		
		//찾은 회원의 회원번호들
		List<String> userNos = new ArrayList<String>();

		System.out.print("이름: ");
		userName = scan.nextLine();

		// 검색
		for (UserClass user : ReadFile.users) {
			if (user.getName().indexOf(userName) > -1) { // 검색
				userNos.add(user.getUserNo());
			}
		}
		return userNos;

	}//searchUserName

	//회원 아이디 검색
	//유일함
	private String searchUserID() {
		String userID = "";

		System.out.print("이름: ");
		userID = scan.nextLine();

		//찾은 회원의 회원번호
		String userNo = "";
		// 검색
		for (UserClass user : ReadFile.users) {
			if (user.getId().indexOf(userID) > -1) { // 검색
				userNo = user.getUserNo();

			}
		}
		return userNo;

	}//searchUserID
	
	//회원 한 명의 정보 출력
	private void printUserInfo(String userNo) {
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  [검색 결과]                                                                            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  회원번호  아이디            비밀번호          이름        생년월일    전화번호         ┃");
		System.out.println("┠─────────────────────────────────────────────────────────────────────────────────────────┨");
		
		
		for (UserClass user : ReadFile.users) {
			
			if (user.getUserNo().equals(userNo)) {
				System.out.print(String.format("┃  %-8s  %-16s  %-16s  %-7s  %-8s    %-13s    ┃\n"
						, user.getUserNo()
						, user.getId()
						, user.getPassword()
						, user.getName()
						, user.getBirth()
						, user.getPhone()
				));
				
			}
		}
		
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		searchUserScreen();
		
	}//printUserInfo
	
	//회원 여러 명의 정보 출력
	private void printUserInfo(List<String> userNos) {
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  [검색 결과]                                                                            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  회원번호  아이디            비밀번호          이름        생년월일    전화번호         ┃");
		System.out.println("┠─────────────────────────────────────────────────────────────────────────────────────────┨");
		
		
		for (UserClass user : ReadFile.users) {
			for (String userNo : userNos) {
				if (user.getUserNo().equals(userNo)) {
					System.out.print(String.format("┃  %-8s  %-16s  %-16s  %-7s  %-8s    %-13s    ┃\n"
							, user.getUserNo()
							, user.getId()
							, user.getPassword()
							, user.getName()
							, user.getBirth()
							, user.getPhone()
					));
				}
			}
		}
		
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		searchUserScreen();
		
	}//printUserInfo
	
	

	//조회
	private void dataListScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                     [조회]                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 도서조회                                  ┃");
		System.out.println("┃  2. 회원조회                                  ┃");
		System.out.println("┃  3. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			bookDataScreen();
		} else if (sel.equals("2")) {
			userDataScreen();
		} else if (sel.equals("3")) {
			afterLoginScreen();
		} else {
			System.out.println("1-3의 숫자를 입력해주세요.");
			dataListScreen();
		}

	}

	public void bookDataScreen() {

		BookList bl = new BookList();

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [도서조회]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 전체도서조회                              ┃");
		System.out.println("┃  2. 대여도서조회                              ┃");
		System.out.println("┃  3. 예약도서조회                              ┃");
		System.out.println("┃  4. 연체도서조회                              ┃");
		System.out.println("┃  5. 연장도서조회                              ┃");
//		System.out.println("┃  6. 손상도서조회                              ┃");
		System.out.println("┃  6. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			bl.totalBookList();
		} else if (sel.equals("2")) {
			bl.searchBook("대여중");
		} else if (sel.equals("3")) {
			bl.searchBook("예약중");
		} else if (sel.equals("4")) {
			bl.searchBook("연체함");
		} else if (sel.equals("5")) {
			bl.searchBook("연장함");
//		} else if (sel.equals("6")) {
//			bl.searchBook("손상됨");
		} else if (sel.equals("6")) {
			//나가기
			dataListScreen();
		} else {
			System.out.println("1-6의 숫자를 입력해주세요.");
			bookDataScreen();
		}
	}

	private void userDataScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [회원조회]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 블랙리스트조회                            ┃");
		System.out.println("┃  2. 연체회원조회                              ┃");
		System.out.println("┃  3. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			blackUserList();
		} else if (sel.equals("2")) {
			overdueUserList();
		} else if (sel.equals("3")) {
			dataListScreen();
		} else {
			System.out.println("1-3의 숫자를 입력해주세요.");
			dataListScreen();
		}
	}

	private void blackUserList() {
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  [검색 결과]                                       ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  블랙리스트번호  회원번호  이름        생년월일    ┃");
		System.out.println("┠────────────────────────────────────────────────────┨");

		
		for(BlackUserClass black : ReadFile.blackUsers) {
			System.out.printf("┃  %-14s  %-8s  %-7s  %-8s    ┃\n"
					, black.getBlackUserNo()
					, black.getUserNo()
					, black.getUserName()
					, black.getUserBirth());
		}
		
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		userDataScreen();
	}

	private void overdueUserList() {

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  [검색 결과]                                                                                              ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  회원번호  이름        생년월일    전화번호         아이디            비밀번호          연체일수  연체료  ┃");
		System.out.println("┠───────────────────────────────────────────────────────────────────────────────────────────────────────────┨");
		
		// 연체를 돌고, 대여를 돌고, 회원돌고
		for (OverdueClass overdue : ReadFile.overdues) {
			for (RentalClass rental : ReadFile.rentals) {
				for (UserClass user : ReadFile.users) {

					// 연체의 대여번호와 대여의 대여번호가 같고
					if (overdue.getRentalNo().equals(rental.getRentalNo())) {
						// 대여의 회원번호와 회원의 회원번호가 같을
						if (rental.getUserNo().equals(user.getUserNo())) {
							
							System.out.printf("┃  %-8s  %-7s  %-8s    %-13s    %-16s  %-16s  %,8d  %,6d  ┃\n"
									, user.getUserNo() //회원번호
									, user.getName() //이름
									, user.getBirth() //생년월일
									, user.getPhone() //전화번호
									, user.getId() //아이디
									, user.getPassword() //비밀번호
									, overdue.getOverdueDate() //연체일수
									, overdue.getOverduePrice() //연체료
							);
						}//if
					}//if

				}//for - user

			}//for - rental
		}//for overdue
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		userDataScreen();

	}//overdueUserList
	

}
