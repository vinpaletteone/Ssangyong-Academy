package frame;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.BookClass;
import common.OverdueClass;
import common.RentalClass;
import common.ReserveClass;
import common.ReturnClass;
import data.Count;
import data.Path;
import data.ReadFile;
import data.WriterFile;

public class MyPage {
	
	static Scanner scan;
	AfterUserLogin afteruserLogin;
	WriterFile writerFile;
	ReadFile readFile;
	
	
	public MyPage() {
		this.afteruserLogin = new AfterUserLogin();
		this.writerFile = new WriterFile();
		this.readFile = new ReadFile();
	}
	
	static {
		scan = new Scanner(System.in);
	}
	
	
	public void saveUserPastRentalList() {
		// 1. 대여했던 도서 목록

		String userNo = ReadFile.userNo; //회원번호
		String rentalNo = "";//대여번호
		String rentalDate = ""; //대여날짜
		String bookNo = null, bookTitle, author, publisher; //번호, 제목, 저자, 출판사
		String returnDate; //반납날짜
		
		
		List<String> rentalNoArray = new ArrayList<String>(); //대여번호
		List<String> bookNoArray = new ArrayList<String>(); //도서번호
		List<String> bookTitleArray = new ArrayList<String>(); //제목
		List<String> authorArray = new ArrayList<String>(); //저자
		List<String> publisherArray = new ArrayList<String>(); //출판사
		List<String> rentalDateArray = new ArrayList<String>(); //대여날짜
		List<String> returnDateArray = new ArrayList<String>(); //반납날짜
		
		
		
		// 1. 대여목록 -> 로그인 한 회원 (회원번호) -> 반납여부가 반납인 것 대여번호 뽑기
		// 2. 그 대여번호의 대여날짜 가져오기
		// 3. 그 대여번호의 반납날짜 가져오기
		// 4. 그 대여번호의 도서번호 가져오기 
		// 5. 도서번호의 정보(도서번호, 저자, 출판사) 가져오기
		
		//1, 2, 4
		for (RentalClass r : ReadFile.rentals) {
			if (r.getUserNo().equals(userNo)) { //특정 회원의 대여목록
				if (r.getReturnState().equals("반납")) { //여러 개 있음
					rentalNo = r.getRentalNo(); //대여번호
					rentalDate = String.format("%tF", r.getRentalDate());//대여날짜
					bookNo = r.getBookNo(); //도서번호
					
					rentalNoArray.add(rentalNo);
					rentalDateArray.add(rentalDate);
					bookNoArray.add(bookNo);
					
				}
			}
		}
		
		//대여번호 도서번호 반납날짜
		//B00002   00004    2019-10-10
		//B00005   00009    2019-10-11
		//B00007   00010    2019-10-15
		
		//3
		for (ReturnClass rt : ReadFile.returns) {
			
			for (String rn : rentalNoArray) {
				if (rt.getRentalNo().equals(rn)) {
					returnDate = String.format("%tF", rt.getReturnDate()); //반납날짜
					returnDateArray.add(returnDate);
				}
			}
		}
		
		//5
		for (BookClass b : ReadFile.books) {
			
			for (String bn : bookNoArray) {
				
				if (b.getBookNo().equals(bn)) {
					bookTitle = b.getBookTitle(); //제목
					author = b.getAuthor(); //저자
					publisher = b.getPublisher(); //출판사
					
					bookTitleArray.add(bookTitle);
					authorArray.add(author);
					publisherArray.add(publisher);
				}
			}
		}
		
		//통합
		AfterUserLogin.rentaledBooks.clear();
		for(int i=0; i<rentalNoArray.size(); i++) {
			AfterUserLogin.rentaledBooks.add(String.format("%s■%s■%s■%s■%s■%s"
															, bookNoArray.get(i)
															, bookTitleArray.get(i)
															, authorArray.get(i)
															, publisherArray.get(i)
															, rentalDateArray.get(i)
															, returnDateArray.get(i)
			));
		}
		

	}
	
	//대여했던 도서 출력
	public void printRentaledBooks() {
		// 대여했던 도서 없을 때
		if (AfterUserLogin.rentaledBooks.size() == 0) {
			System.out.println("<<대여했던 도서가 없습니다.>>");
		} else {
			// 도서번호 | 제목 | 저자 | 출판사 | 대여날짜 | 반납날짜
			System.out.println(
					"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(
					"┃  [대여했던 도서 목록]                                                                                                                                                          ┃");
			System.out.println(
					"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println(
					"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//				System.out.println("┃  도서번호  제목             저자  출판사  대여날짜  반납날짜 ");
			System.out.printf("┃  %-6s%-80s%-30s  %-17s  %-9s%-9s┃\n", "도서번호", "제목", "저자", "출판사", "대여날짜", "반납날짜");
			System.out.println(
					"┠────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┨");

			for (int i = 0; i < AfterUserLogin.rentaledBooks.size(); i++) {
				// 도서번호 제목 저자 출판사 대여가능일자
				String[] line = AfterUserLogin.rentaledBooks.get(i).split("■");

				int titleLength = checkLength(line[1], 80);
				int authorLength = checkLength(line[2], 32);
				int publisherLength = checkLength(line[3], 20);

				String printStr = String.format("┃  " + "%s" + "     " // 도서번호
						+ "%-" + titleLength + "s  " // 제목
						+ "%-" + authorLength + "s  " // 저자
						+ "%-" + publisherLength + "s  " // 출판사
						+ "%-13s" // 대여날짜
						+ "%-13s┃\n" // 반납날짜
						, line[0] // 도서번호
						, line[1] // 제목
						, line[2] // 저자
						, line[3] // 출판사
						, line[4] // 대여날짜
						, line[5] // 반납날짜

				);

				System.out.print(printStr);
			}
			System.out.println(
					"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		}
		
		
		//리뷰 작성
		writeReviewScreen();
		
	}//printRentalingBooks
	
	private void writeReviewScreen() {

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"); 
		System.out.println("┃                [리뷰작성]                 ┃");
		System.out.println("┃  1. 리뷰 작성                             ┃");
		System.out.println("┃  2. 나가기                                ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("선택(숫자) : ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			reviewWriter();
		} else if (sel.equals("2")) {
			afteruserLogin.myPageScreen();
		} else {
			System.out.println("1-2의 숫자를 입력해주세요.");
			writeReviewScreen();
		}

	}

	// 리뷰 작성
	private void reviewWriter() {

		System.out.println();
		System.out.print("리뷰를 작성할 도서번호 입력 : ");
		String bookNum = scan.nextLine();

		// 구현할 것
		// 이상한 번호 입력했을 때 처리

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"); 
		System.out.println("┃                [리뷰작성]                 ┃");
		System.out.println("┃       마치려면 '완료'를 입력하세요.       ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		System.out.print("아이디 : ");
		String name = scan.nextLine();

		String score = "";
		while (true) {
			System.out.print("점수(1-5): ");
			score = scan.nextLine();

			if (score.equals("1") || score.equals("2") || score.equals("3") || score.equals("4") || score.equals("5")) {
				break;
			} else {
				System.out.println("1-5의 숫자를 입력해주세요.");
			}

		}

		// "완료"를 입력하면 종료
		System.out.print("내용 : ");

		// 리뷰 내용을 한 줄씩 담을 배열
		ArrayList<String> content = new ArrayList<String>();

		while (true) {
			String input = scan.nextLine();

			if (input.equals("완료")) {
				break;
			}

			content.add(input);
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.REVIEW_FILE_PATH, true));

			// 현재 시각
			// String regdate = String.format("%tF %tT", new Date(), new Date());

			// RV00001/U00010/00001/날짜/5/duwjd719
			// 리뷰번호■회원번호■도서번호■리뷰작성날짜■점수■닉네임
			Count.reviewCount++;

			writer.write(String.format("RV%05d■%s■%s■%tF■%s■%s", Count.reviewCount, ReadFile.userNo, bookNum,
					ReadFile.loginDate, score, name));
			writer.newLine();
			writer.write("-");
			writer.newLine();
			for (String line : content) {
				writer.write(line + "\r\n");
			}

			writer.newLine();
			writer.write("==="); // 리뷰들을 구분해줄 구분자
			writer.newLine();

			writer.close();
			System.out.println("리뷰가 작성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// reviewWriter

	}// reviewWriter

	public void saveUserNowRentalList() {
		
		//파일 읽기
		readFile.init();
		
		// 2. 대여중인 도서 보기
		
		String userNo = ReadFile.userNo; //회원 번호
		String rentalNo = ""; //대여번호
		String rentalDate = ""; //대여날짜
		String returnDueDate = ""; //반납기한
		String bookNo = null, bookTitle, author, publisher; //번호, 제목, 저자, 출판사
		String overdueCount = null; //연체일수
		String overduePrice = null; //연체료
		
		List<String> rentalNoArray = new ArrayList<String>(); //대여번호
		List<String> bookNoArray = new ArrayList<String>(); //도서번호
		List<String> bookTitleArray = new ArrayList<String>(); //제목
		List<String> authorArray = new ArrayList<String>(); //저자
		List<String> publisherArray = new ArrayList<String>(); //출판사
		List<String> rentalDateArray = new ArrayList<String>(); //대여날짜
		List<String> returnDueDateArray = new ArrayList<String>(); //반납기한
		
		List<String> overdueCountArray = new ArrayList<String>(); //연체일수
		List<String> overduePriceArray = new ArrayList<String>(); //연체료
		
		
		
		// 1. 대여목록 -> 로그인 한 회원 (회원번호) -> 반납여부가 대여중인 것 대여번호 뽑기
		// 2. 그 대여번호의 대여날짜, 반납기한 가져오기
		// 3. 그 대여번호의 도서번호 가져오기 
		//	- 도서번호를 통해 도서목록에서 도서상태가 연체함인 것은 대여번호의 연체일수, 연체료 가져오기
		// 4. 도서번호의 정보(도서번호, 저자, 출판사) 가져오기
		
		
		//1, 2, 4
		for (RentalClass r : ReadFile.rentals) {
			if (r.getUserNo().equals(userNo)) { //특정 회원의 대여목록
				if (r.getReturnState().equals("대여중")) { //여러 개 있음
					
					//1.
					
					//연체 여부 계산 (틱값 계산)
					//오늘 - 반납기한 
					int tick = (int)((ReadFile.loginDate.getTimeInMillis() - r.getReturnDueDate().getTimeInMillis()) /1000 /60 /60 /24);
					if (tick > 0) { //연체
						rentalNo = r.getRentalNo(); //대여중인데 연체한 회원의 대여번호
					}
					
					//2.
					rentalDate = String.format("%tF", r.getRentalDate()); //대여날짜
					returnDueDate = String.format("%tF", r.getReturnDueDate()); //반납기한
					
					//4.
					bookNo = r.getBookNo(); //도서번호
					
					//배열에 추가
					rentalNoArray.add(rentalNo);
					rentalDateArray.add(rentalDate);
					returnDueDateArray.add(returnDueDate);
					bookNoArray.add(bookNo);
					
				}
			}
		}
		
		//확인용
//		System.out.println(rentalNoArray.size());
//		System.out.println(rentalDateArray.size());
//		System.out.println(returnDueDateArray.size());
//		System.out.println(bookNoArray.size());
		
		//3
		
		for (BookClass b : ReadFile.books) {
			for (String bn : bookNoArray) {
				if (b.getBookNo().equals(bn)) {
					
					if (b.getBookState().equals("연체함")) {
						
						//대여번호의 연체일수
						for (OverdueClass o : ReadFile.overdues) {
							if (o.getRentalNo().equals(rentalNo)) {
								overdueCount = o.getOverdueDate() + "";
								overduePrice = o.getOverduePrice() + "";
							}
						}
					} else {
						overdueCount = 0 + "";
						overduePrice = 0 + "";
					}
					overdueCountArray.add(overdueCount);
					overduePriceArray.add(overduePrice);
				}
					
			} 
		}
		
		
		
		//확인용
//		System.out.println(overdueCountArray.size());
//		System.out.println(overduePriceArray.size());
		
		//5
		for (BookClass b : ReadFile.books) {
			
			for (String bn : bookNoArray) {
				
				if (b.getBookNo().equals(bn)) {
					bookTitle = b.getBookTitle(); //제목
					author = b.getAuthor(); //저자
					publisher = b.getPublisher(); //출판사
					
					bookTitleArray.add(bookTitle);
					authorArray.add(author);
					publisherArray.add(publisher);
				}
			}
		}
		
		
		//통합
		AfterUserLogin.rentalingBooks.clear();
		for(int i=0; i<rentalNoArray.size(); i++) {
			AfterUserLogin.rentalingBooks.add(String.format("%s■%s■%s■%s■%s■%s■%s■%s"
																, bookNoArray.get(i)
																, bookTitleArray.get(i)
																, authorArray.get(i)
																, publisherArray.get(i)
																, rentalDateArray.get(i)
																, returnDueDateArray.get(i)
																, overdueCountArray.get(i)
																, overduePriceArray.get(i)));
		}
	}

	// 대여중인 도서 출력
	public void printRentalingBooks() {
		// 대여중인 도서 없을 때
		if (AfterUserLogin.rentalingBooks.size() == 0) {
			System.out.println("<<대여중인 도서가 없습니다.>>");
		} else {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃  [대여중인 도서 목록]                                                                                                                                                                            ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃  %-6s%-80s%-30s  %-17s  %-9s%-9s%-6s%-5s┃\n", "도서번호", "제목", "저자", "출판사", "대여날짜", "반납기한", "연체일수", "연체료");
			System.out.println("┠──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┨");

			for (int i = 0; i < AfterUserLogin.rentalingBooks.size(); i++) {

				// 도서번호 제목 저자 출판사 대여가능일자
				String[] line = AfterUserLogin.rentalingBooks.get(i).split("■");

				int titleLength = checkLength(line[1], 80);
				int authorLength = checkLength(line[2], 32);
				int publisherLength = checkLength(line[3], 20);

				String printStr = String.format("┃  "
							+ "%s" + "     " 							//도서번호
							+ "%-" + titleLength + "s  "				//제목
							+ "%-" + authorLength + "s  "				//저자
							+ "%-" + publisherLength + "s  "			//출판사
							+ "%-13s"									//대여날짜
							+ "%-13s"									//반납기한
							+ "%-10s"									//연체일수
							+ "%-8s┃\n"									//연체료
							, line[0] //도서번호
							, line[1] //제목
							, line[2] //저자
							, line[3] //출판사
							, line[4] //대여날짜
							, line[5] //반납기한
							, line[6] //연체일수
							, line[7] //연체료
							
				);

				System.out.print(printStr);
			}
			System.out.println(
					"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		}

	}// printRentalingBooks
	
	private static int checkLength(String str, int length) {
		int result = length;
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			if (c1 >= '가' && c1 <= '힣') {
				result--;
			}
		}
		return result;
	}
	
	

	public void saveUserReserveList() {
		
		readFile.init();
		
		// 3. 예약한 도서 보기
		
		String userNo = ReadFile.userNo; //회원번호
		String bookNo, bookTitle, author, publisher;
		String returnDueDate;
		
		//예약중
		//예약 테이블에서 예약 도서의 번호, 제목, 저자, 출판사 가져오기
		//반납기한은 대여에서 갖고오기
		
		//도서번호 | 제목 | 저자 | 출판사 | 대여가능일자(반납기한)
		
		List<String> bookNoArray = new ArrayList<String>(); //도서번호
		List<String> bookTitleArray = new ArrayList<String>(); //제목
		List<String> authorArray = new ArrayList<String>(); //저자
		List<String> publisherArray = new ArrayList<String>(); //출판사
		
		List<String> returnDueDateArray = new ArrayList<String>(); //반납기한(대여가능일자)
		
		
		
		//회원번호로 예약목록에서 도서번호들 가져오기
		for (ReserveClass rs : ReadFile.reserves) {
			if (rs.getUserNo().equals(userNo)) {
				
				bookNo = rs.getBookNo(); //도서번호들
				
				bookNoArray.add(bookNo);
			}
		}
		
		//각 도서번호의 제목, 저자, 출판사 가져오기
		for (BookClass b : ReadFile.books) {
			for (String bn : bookNoArray) {
				if (b.getBookNo().equals(bn)) {
					
					bookTitle = b.getBookTitle(); //제목
					author = b.getAuthor(); //저자
					publisher = b.getPublisher(); //출판사
					
					bookTitleArray.add(bookTitle);
					authorArray.add(author);
					publisherArray.add(publisher);
				}
			}
		}
		
		//각 도서번호로 대여목록에서 반납기한 가져오기
		for (RentalClass r : ReadFile.rentals) {
			for (String bn : bookNoArray) {
				if (r.getBookNo().equals(bn)) {
					
					returnDueDate = String.format("%tF", r.getReturnDueDate()); //반납기한
					
					returnDueDateArray.add(returnDueDate);
				}
			}
		}
		
		
		//통합
		AfterUserLogin.reservedBooks.clear();
		for(int i=0; i<bookNoArray.size(); i++) {
			AfterUserLogin.reservedBooks.add(String.format("%s■%s■%s■%s■%s"
					, bookNoArray.get(i)
					, bookTitleArray.get(i)
					, authorArray.get(i)
					, publisherArray.get(i)
					, returnDueDateArray.get(i)));
		}
		
	}
 
	public void printReservedBooks() {
		
		//예약중인 도서 없을 때
		if (AfterUserLogin.reservedBooks.size() == 0) {
			System.out.println("<<예약중인 도서가 없습니다.>>");
		} else {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃  [예약중인 도서 목록]                                                                                                                                               ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃  %-6s%-80s%-30s  %-17s  %-9s┃\n", "도서번호", "제목", "저자", "출판사", "대여가능일자");
			System.out.println("┠─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┨");

			
			for (int i=0; i<AfterUserLogin.reservedBooks.size(); i++) {
				
				//도서번호 제목 저자 출판사 대여가능일자
				String[] line = AfterUserLogin.reservedBooks.get(i).split("■");
				
				int titleLength = checkLength(line[1], 80);
				int authorLength = checkLength(line[2], 32);
				int publisherLength = checkLength(line[3], 20);
				
				
				String printStr = String.format("┃  "
						+ "%s" + "     " 							//도서번호
						+ "%-" + titleLength + "s  "				//제목
						+ "%-" + authorLength + "s  "				//저자
						+ "%-" + publisherLength + "s  "			//출판사
						+ "%-13s  ┃\n"								//대여가능일자
						, line[0] //도서번호
						, line[1] //제목
						, line[2] //저자
						, line[3] //출판사
						, line[4] //대여가능일자
				);
				
				System.out.print(printStr);
			}
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

			}
			
	}//printReservedBooks

	public void userReviewList() {

		// 4. 나의 리뷰 보기
		readFile.init();
		System.out.println(" [나의 리뷰 목록]  ");

		try {

			FileReader reader = new FileReader(Path.REVIEW_FILE_PATH);
			FileReader reader1 = new FileReader(Path.BOOK_FILE_PATH);

			String temp = "";
			int code = -1;

			while ((code = reader.read()) != -1) {
				temp += (char) code;
			}

			reader.close();
			reader1.close();

			String[] list = temp.trim().split("===");

			// System.out.println(list.length);
			List<String> bookNumList = new ArrayList<String>();
			for (String memo : list) {

				String[] content = memo.trim().split("\r\n" + "-");
				String[] lines = memo.trim().split("\r\n");
				// 리뷰목록
				String[] subitems = lines[0].split("■");

				if (subitems[4].equals("1")) {
					subitems[4] = subitems[4].replaceAll("1", "★☆☆☆☆");
				} else if (subitems[4].equals("2")) {
					subitems[4] = subitems[4].replaceAll("2", "★★☆☆☆");
				} else if (subitems[4].equals("3")) {
					subitems[4] = subitems[4].replaceAll("3", "★★★☆☆");
				} else if (subitems[4].equals("4")) {
					subitems[4] = subitems[4].replaceAll("4", "★★★★☆");
				} else if (subitems[4].equals("5")) {
					subitems[4] = subitems[4].replaceAll("5", "★★★★★");
				}

				bookNumList.add(subitems[2]);

				String temp2 = "";

				for (int i = 0; i < ReadFile.books.size(); i++) {
					for (String s : bookNumList) {
						if (ReadFile.books.get(i).getBookNo().equals(s)) {

							temp2 = ReadFile.books.get(i).getBookTitle();

						}
					}

				}

				if (ReadFile.userNo.equals(subitems[1])) {

					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------------");
					System.out.printf(" 아이디: %s \t 책이름:%s \t 평점 :%s\n   ", subitems[5], temp2, subitems[4]);
					System.out.println();
					System.out.printf("            %s  \n", content[1]);
				}

			}

		} catch (Exception e) {
			System.out.println("Ex82_File.list() : " + e.toString());

		}
	}//userReviewList

}
