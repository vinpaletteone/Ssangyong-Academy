package data;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import common.*;


public class ReadFile {
	
	public static List<UserClass> users;
	public static List<BookClass> books;
	public static List<RentalClass> rentals;
	public static List<ReturnClass> returns;
	public static List<AuthorClass> authors; 
	public static List<PublisherClass> publishers;
	public static List<BlackUserClass> blackUsers;
	public static List<ExtensionClass> extensions;
	public static List<OverdueClass> overdues;
	public static List<ReserveClass> reserves;
//	public static List<Review> reviews;
	
	
	public static String bookNo;
	
	public static String userNo; //회원번호
	public static Calendar loginDate;

	
	static {
		users = new ArrayList<UserClass>(); //회원 목록
		books = new ArrayList<BookClass>(); //책 목록
		rentals = new ArrayList<RentalClass>(); //대여 목록
		returns = new ArrayList<ReturnClass>(); //반납 목록
		authors = new ArrayList<AuthorClass>(); //저자 목록
		publishers = new ArrayList<PublisherClass>(); //출판사 목록
		blackUsers = new ArrayList<BlackUserClass>(); //블랙리스트 회원 목록
		extensions = new ArrayList<ExtensionClass>(); //연장 목록
		overdues = new ArrayList<OverdueClass>(); //연체 목록
		reserves = new ArrayList<ReserveClass>(); //예약 목록
//		reviews = new ArrayList<Review>(); //리뷰 목록
		
		ReadFile.loginDate = Calendar.getInstance();
		ReadFile.loginDate.set(2019, 9, 16); //2019-10-16
	}
	
	
	
	private void getUserFile() {
		
		users.clear();
		
		// 회원 파일
		String path = Path.USER_FILE_PATH;
		String userNo // 회원번호
				, id // 회원아이디
				, password // 회원패스워드
				, name // 회원이름
				, birth // 회원생년월일
				, phone; // 회원전화번호

		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {
				
				UserClass user = new UserClass();
				String[] line = scanFile.nextLine().split("■");
				userNo = line[0];
				id = line[1];
				password = line[2];
				name = line[3];
				birth = line[4];
				phone = line[5];

				user.setUserNo(userNo);
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setBirth(birth);
				user.setPhone(phone);

				ReadFile.users.add(user);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("User.getUser() : " + e.toString());
		}

//		for (User user : users) {
//			System.out.println(user);
//		}
		
	}//getUserFile
	
	private void getBookFile() {
		
		books.clear();
		
		//도서 파일
		String path = Path.BOOK_FILE_PATH;
		String bookNo //도서 번호
				, bookTitle //제목
				, author //저자
				, publisher; //출판사
				
		int price; //가격
		
		String[] insertDate; //등록 날짜
		int year, month, date;
		
		String bookState; //도서 상태
		int reviewCount; //리뷰 개수

		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {
				
				String[] line = scanFile.nextLine().split("■");
				bookNo = line[0];
				bookTitle = line[1];
				author = line[2];
				publisher = line[3];
				price = Integer.parseInt(line[4]);
				
				//등록 날짜 : Calendar
				insertDate = line[5].split("-");
				Calendar cdate = Calendar.getInstance();
				
				year = Integer.parseInt(insertDate[0]);
				month = Integer.parseInt(insertDate[1])-1;
				date = Integer.parseInt(insertDate[2]);
				
				cdate.set(year, month, date);
				
				
				bookState = line[6];
				reviewCount = Integer.parseInt(line[7]);
				

				BookClass book = new BookClass();
				
				book.setBookNo(bookNo);
				book.setBookTitle(bookTitle);
				book.setAuthor(author);
				book.setPublisher(publisher);
				book.setPrice(price);
				book.setInsertDate(cdate);
				book.setBookState(bookState);
				book.setReviewCount(reviewCount);
				
				ReadFile.books.add(book);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("User.getUser() : " + e.toString());
		}
		
		
		//확인용
//		for (Book book : books) {
//			System.out.println(book);
//		}

		
	}//getBookFile
	
	
	private void getRentalFile() {
		
		rentals.clear();
		
		//대여 파일
		String path = Path.RENTAL_FILE_PATH;
		
		String rentalNo //대여번호
		, userNo //회원번호
		, bookNo; //도서번호
		
		String[] rdatestr; 
		int ryear, rmonth, rdate; 
		Calendar rentalDate; //대여날짜
		
		String[] rddatestr; //
		int rdyear, rdmonth, rddate;
		Calendar returnDueDate; //반납기한
		
		String returnState; //반납여부

		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {
				
				String[] line = scanFile.nextLine().split("■");
				rentalNo = line[0];
				userNo = line[1];
				bookNo = line[2];
				
				
				//대여 날짜 : Calendar
				rdatestr = line[3].split("-");
				
				ryear = Integer.parseInt(rdatestr[0]);
				rmonth = Integer.parseInt(rdatestr[1])-1;
				rdate = Integer.parseInt(rdatestr[2]);
				
				rentalDate = Calendar.getInstance();
				rentalDate.set(ryear, rmonth, rdate);
				
				
				
				//반납 기한 : Calendar
				rddatestr = line[4].split("-");
				
				rdyear = Integer.parseInt(rddatestr[0]);
				rdmonth = Integer.parseInt(rddatestr[1])-1;
				rddate = Integer.parseInt(rddatestr[2]);
				
				returnDueDate = Calendar.getInstance();
				returnDueDate.set(rdyear, rdmonth, rddate);
				
				returnState = line[5];
				
				
				//대여 클래스
				RentalClass rental = new RentalClass();
				
				rental.setRentalNo(rentalNo);
				rental.setUserNo(userNo);
				rental.setBookNo(bookNo);
				rental.setRentalDate(rentalDate);
				rental.setReturnDueDate(returnDueDate);
				rental.setReturnState(returnState);
				
				ReadFile.rentals.add(rental);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("User.getUser() : " + e.toString());
		}
		
		
		//확인용
//		for (Rental rental : rentals) {
//			System.out.println(rental);
//		}

		
	}//getRentalFile
	
	
	private void getReturnFile() {
		
		returns.clear();
		
		//반납 파일
		String path = Path.RETURN_FILE_PATH;
		String returnNo;
		
		String[] rdatestr;
		int ryear, rmonth, rdate;
		Calendar returnDate;
		String rentalNo;

		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {
				
				String[] line = scanFile.nextLine().split("■");
				
				//반납번호
				returnNo = line[0]; 
				
				//반납된날짜
				rdatestr = line[1].split("-");
				ryear = Integer.parseInt(rdatestr[0]);
				rmonth = Integer.parseInt(rdatestr[1])-1;
				rdate = Integer.parseInt(rdatestr[2]);
				
				returnDate = Calendar.getInstance();
				returnDate.set(ryear, rmonth, rdate);
				
				//대여번호
				rentalNo = line[2];
				
				ReturnClass returnbook = new ReturnClass();
				
				returnbook.setReturnNo(returnNo);
				returnbook.setRentalNo(rentalNo);
				returnbook.setReturnDate(returnDate);

				
				ReadFile.returns.add(returnbook);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("User.getUser() : " + e.toString());
		}
		
		//확인용
//		for(Return r : returns) {
//			System.out.println(r);
//		}

		
	}//getReturnFile
	
	private void getAuthorFile() {
		
		authors.clear();
		
		//저자 파일
		String path = Path.AUTHOR_FILE_PATH;
		
		String bookNo; //도서번호
		String author; //저자
		
		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {
				
				String[] line = scanFile.nextLine().split("■");
				
				//반납번호
				bookNo = line[0]; //도서번호
				author = line[1]; //저자
				
				AuthorClass author1 = new AuthorClass();
				
				author1.setBookNo(bookNo); 
				author1.setAuthor(author);

				
				ReadFile.authors.add(author1);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("ReadFile.getAuthorFile() : " + e.toString());
		}
		
		//확인용
//		for (Author a : authors) {
//			System.out.println(a);
//		}
		
	}//getAuthorFile
	
	private void getPublisherFile() {
		
		publishers.clear();
		
		//출판사 파일
		String path = Path.PUBLISHER_FILE_PATH;

		String bookNo; //도서번호
		String publisher; //출판사
		
		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {
				
				String[] line = scanFile.nextLine().split("■");
				
				bookNo = line[0]; //도서번호
				publisher = line[1]; //출판사
				
				PublisherClass publisher1 = new PublisherClass();
				
				publisher1.setBookNo(bookNo); //도서번호
				publisher1.setPublisher(publisher); //출판사

				
				ReadFile.publishers.add(publisher1);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("ReadFile.getPublisherFile() : " + e.toString());
		}
		
		
//		//확인용
//		for(Publisher p : publishers) {
//			System.out.println(p);
//		}
		
	}//getPublisherFile
	
	private void getBlackUserFile() {

		blackUsers.clear();

		// 블랙리스트 파일
		String path = Path.BLACKLIST_FILE_PATH;
		String blackUserNo // 블랙리스트번호
				, userNo // 회원번호
				, userName // 이름
				, userBirth; // 생년월일

		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {

				BlackUserClass blackUser = new BlackUserClass();
				String[] line = scanFile.nextLine().split("■");
				blackUserNo = line[0];
				userNo = line[1];
				userName = line[2];
				userBirth = line[3];

				blackUser.setBlackUserNo(blackUserNo);
				blackUser.setUserNo(userNo);
				blackUser.setUserName(userName);
				blackUser.setUserBirth(userBirth);

				ReadFile.blackUsers.add(blackUser);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("BlackUser.getBlackUser : " + e.toString());
		}
	} // getBlackUserFile

	private void getExtensionFile() {
		
		extensions.clear();

		// 연장 파일
		String path = Path.EXTENSION_FILE_PATH;
		String extensionNo // 연장번호
				, rentalNo; // 대여번호
		int extensionCount; // 연장횟수

		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {

				ExtensionClass extension = new ExtensionClass();
				String[] line = scanFile.nextLine().split("■");
				extensionNo = line[0];
				rentalNo = line[1];
				extensionCount = Integer.parseInt(line[2]);

				extension.setExtensionNo(extensionNo);
				extension.setRentalNo(rentalNo);
				extension.setExtensionCount(extensionCount);

				ReadFile.extensions.add(extension);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("Extension.getExtension : " + e.toString());
		}

		
		//확인용
//		for(Extension e : extensions) {
//			System.out.println(e);
//		}

	}// getExtensionFile

	private void getOverdueFile() {
		
		overdues.clear();

		// 연체 파일
		String path = Path.OVERDUE_FILE_PATH;
		String overdueNo // 연체번호
				, rentalNo; // 대여번호
		int overdueDate, // 연체일수
				overduePrice; // 연체료

		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {

				OverdueClass overdue = new OverdueClass();
				String[] line = scanFile.nextLine().split("■");
				overdueNo = line[0];
				rentalNo = line[1];
				overdueDate = Integer.parseInt(line[2]);
				overduePrice = Integer.parseInt(line[3]);

				overdue.setOverdueNo(overdueNo);
				overdue.setRentalNo(rentalNo);
				overdue.setOverdueDate(overdueDate);
				overdue.setOverduePrice(overduePrice);

				ReadFile.overdues.add(overdue);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("Overdue.getOverdue : " + e.toString());
		}

		
		//확인용
//		for (Overdue o : this.overdues) {
//			System.out.println(o);
//		}

	}// getOverdueFile

	private void getReserveFile() {
		
		reserves.clear();

		// 예약 파일
		String path = Path.RESERVE_FILE_PATH;
		String reserveNo // 예약번호
				, userNo // 회원번호
				, bookNo; // 도서번호

		try {

			Scanner scanFile = new Scanner(new FileReader(path));

			while (scanFile.hasNext()) {

				ReserveClass reserve = new ReserveClass();
				String[] line = scanFile.nextLine().split("■");
				reserveNo = line[0];
				userNo = line[1];
				bookNo = line[2];

				reserve.setReserveNo(reserveNo);
				reserve.setUserNo(userNo);
				reserve.setBookNo(bookNo);

				ReadFile.reserves.add(reserve);

			}

			scanFile.close();

		} catch (Exception e) {
			System.out.println("Reserve.getReserve : " + e.toString());
		}

		
		//확인용
//		for (Reserve r : reserves) {
//			System.out.println(r);
//		}

	}// getReserveFile

//	private void getReviewFile() {
//
//		// 리뷰 파일
//		// String path = Path.REVIEW_FILE_PATH;
//		String reviewNo // 리뷰번호
//				, userNo // 회원번호
//				, bookNo; // 도서번호
//		int reviewScore; // 별점
//		String rentalNo // 반납번호
//				, nickName // 닉네임
//				, content; // 리뷰내용
//
//		try {
//
//			Scanner scanFile = new Scanner(new FileReader(path));
//
//			while (scanFile.hasNext()) {
//
//				Review review = new Review();
//				String[] line = scanFile.nextLine().split("■");
//				reviewNo = line[0];
//				userNo = line[1];
//				bookNo = line[2];
//				reviewScore = Integer.parseInt(line[3]);
//				rentalNo = line[4];
//				nickName = line[5];
//				content = line[6];
//
//				review.setReviewNo(reviewNo);
//				review.setUserNo(userNo);
//				review.setBookNo(bookNo);
//				review.setReviewScore(reviewScore);
//				review.setRentalNo(rentalNo);
//				review.setNickName(nickName);
//				review.setContent(content);
//
//				this.reviews.add(review);
//
//			}
//
//			scanFile.close();
//
//		} catch (Exception e) {
//			System.out.println("Review.getReview : " + e.toString());
//		}
//
//		for (Review review : reviews) {
//			System.out.println(review);
//		}
//
//	}// getReserveFile
	
	public void init() {
		getUserFile();
		getBookFile();
		getAuthorFile();
		getPublisherFile();
		getRentalFile();
		getReturnFile();
		getReserveFile();
		getExtensionFile();
		getOverdueFile(); 
		getBlackUserFile();
		//getReviewFile();
	}
	

}
