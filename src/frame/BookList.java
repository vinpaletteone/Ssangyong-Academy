package frame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import common.BookClass;
import common.UserClass;
import data.Path;
import data.ReadFile;

public class BookList {
	
	static Scanner scan = new Scanner(System.in);
	
	//전체 도서 목록
	public void totalBookList() {
		
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  [도서 목록 조회]                                                                                                                                                                                   ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.printf( "┃  %-6s%-80s%-30s  %-17s  %-7s  %-7s  %-7s  %s  ┃\n", "도서번호", "제목", "저자", "출판사", "도서상태", "등록날짜", "리뷰개수", "책가격");
		System.out.println("┠─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┨");

		
		
		for(BookClass book : ReadFile.books) {
			
			int titleLength = checkLength(book.getBookTitle(), 80);
			int authorLength = checkLength(book.getAuthor(), 32);
			int publisherLength = checkLength(book.getPublisher(), 20);
			int stateLength = checkLength(book.getBookState(), 10);
			
			System.out.printf("┃  "
						+ "%s" + "     " 							//도서번호
						+ "%-" + titleLength + "s  "				//제목
						+ "%-" + authorLength + "s  "				//저자
						+ "%-" + publisherLength + "s  "			//출판사
						+ "%-"+ stateLength +"s   "					//도서상태
						+ "%tF    "									//등록날짜
						+ "%-10d  "									//리뷰개수
						+ "%-8d┃\n"									//가격
						, book.getBookNo()
						, book.getBookTitle()
						, book.getAuthor()
						, book.getPublisher()
	                  	, book.getBookState()
	                  	, book.getInsertDate()
	                  	, book.getReviewCount()
	                  	, book.getPrice());
			
		}
		
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		
		//도서목록으로 돌아감
		AfterAdminLogin afteradminlogin = new AfterAdminLogin();
		afteradminlogin.bookDataScreen();
		
		
		
	}//totalBookList
	

	//대여 도서 목록
	public void rentalBookList() {
		
	}//rentalBookList

	private String returnUserName(String userNum) {
		
		for(UserClass user : ReadFile.users) {
			if(user.getUserNo().equals(userNum)) {
				return user.getName();
			}
		}
		
		
		return "1";
	}


	private String returnUserNum(ArrayList<String> userNo, BookClass book) {
		
		for (int i = 0; i < userNo.size(); i++) {
			String[] items = userNo.get(i).split("■");
			if(items[0].equals(book.getBookNo())) {
				
				return items[1];

			}
		}
		
		return "1";
		
	}


	private ArrayList<String> checkRental() {
		String path = Path.RENTAL_FILE_PATH;
		
		ArrayList<String> userNo = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line ="";
			String totalLine="";
			
			while((line =reader.readLine())!=null) {
				totalLine += line+"\n";
			}
			
			String[] lines = totalLine.split("\n");
			
			for (int i = 0; i < lines.length; i++) {
				String[] items=lines[i].split("■");
				if(items[5].equals("대여중")) {
					String str = items[2]+"■"+items[1];
					userNo.add(str);
				
				}
			}
			
			reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return userNo;
		
	}
	
	
	public void searchBook(String state) {
		
		// 도서번호 | 제목 | 저자 | 출판사 | 회원이름 | 상태
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  [도서 목록 조회]                                                                                                                                                            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.printf("┃  %-6s%-80s%-30s  %-17s  %-9s%-7s┃\n", "도서번호", "제목", "저자", "출판사", "회원이름", "도서상태");
		System.out.println("┠──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┨");

		ArrayList<String> userNo =checkRental();

		for(BookClass book : ReadFile.books) {
			
			
			if(book.getBookState().equals(state)) {
				String userNum =returnUserNum(userNo, book);
				
				if(!userNum.equals("1")){
				
					String userName = returnUserName(userNum);
					if(!userName.equals("1")) {
						
						int titleLength = checkLength(book.getBookTitle(), 80);
						int authorLength = checkLength(book.getAuthor(), 32);
						int publisherLength = checkLength(book.getPublisher(), 20);
					
						System.out.printf("┃  "
								+ "%s" + "     " 							//도서번호
								+ "%-" + titleLength + "s  "				//제목
								+ "%-" + authorLength + "s  "				//저자
								+ "%-" + publisherLength + "s  "			//출판사
								+ "%-10s"									//회원이름
								+ "%-8s┃\n"									//상태
								, book.getBookNo()
								, book.getBookTitle()
								, book.getAuthor()
								, book.getPublisher()
								, userName
								, book.getBookState());
					}else {
						System.out.println("데이터 가져오기 실패");
					} // 이름 가쟈오기
					
				} // 책번호 가져오기
  
			}  //if 도서상태
			
		} //for
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		
		AfterAdminLogin afteradminlogin = new AfterAdminLogin();
		afteradminlogin.bookDataScreen();
		
	} //searchBook
	
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

}
