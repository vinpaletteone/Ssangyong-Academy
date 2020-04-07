package frame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import common.BookClass;
import common.RentalClass;
import common.ReserveClass;
import data.Count;
import data.Path;
import data.ReadFile;
import data.WriterFile;

public class Rental {

	static Scanner scan;
	AfterUserLogin afteruserLogin;
	WriterFile writerFile;
	ReadFile readFile;

	public Rental() {
		this.afteruserLogin = new AfterUserLogin();
		this.writerFile = new WriterFile();
		this.readFile = new ReadFile();
	}

	static {
		scan = new Scanner(System.in);
	}
	
	//대여중인 책 권 수 세기
	private int getRentalCount() {
		int count = 0;
		
		for (RentalClass rental : ReadFile.rentals) {
			if (rental.getUserNo().equals(ReadFile.userNo) 
					&& rental.getReturnState().equals("대여중")) {
				count++;
			}
		}
		
		return count;
	} //getRentalCount
	
	//도서번호를 통해 도서 상태 가져오기
	private String getBookState (String bookNo) {
		
		String bookState = "";
		for (BookClass book : ReadFile.books) {
			if (book.getBookNo().equals(bookNo)) {
				bookState = book.getBookState();
			}
		}
		return bookState;
	}//getBookState
	
	
	//현재 대여하고 있는 책 번호들 가져오기 
	private List<String> getCurrentRentalBookNos() {
		
		List<String> currentRentalBookNos = new ArrayList<String>();
		
		for (RentalClass rental : ReadFile.rentals) {
			if (rental.getUserNo().equals(ReadFile.userNo)
					&& rental.getReturnState().equals("대여중")) {
				currentRentalBookNos.add(rental.getBookNo());
			}
		}
		
		return currentRentalBookNos;
		
	}//getCurrentRentalBookNos
	
	
	public void rentalBook(List<String> searchedArray) {
		
		//5권을 초과해서 빌릴 수 없음
		if (getRentalCount() >= 5) {
			System.out.println("<<대여 가능한 대여 권 수를 초과하였습니다.>>");
			afteruserLogin.rentalBookScreen();
		}
		
		//정렬한 배열에 있는 도서 번호 가져오기
		String bookNumber = "";
		boolean loop = true;
		
		while (loop) {
			
			System.out.print("대여할 도서 번호 : ");
			bookNumber = scan.nextLine();
			
			for (String book : searchedArray) {
				if (book.contains(bookNumber)) {
					loop = false;
				}
			}

			if (loop) {
				System.out.println("다시 입력하세요.");
			}
			
		}
		
		//도서의 다섯가지 상태를 통해 대여 여부 결정
		String bookState = getBookState(bookNumber);
		
		if (bookState.equals("대여가능")) {
			rental(bookNumber);
		} else if (bookState.equals("대여중")) {
			
			//대여중일 때 처리
			bookStateIsRental(bookNumber);
			
		} else if (bookState.equals("예약중")) {
			//반납여부 확인
			//반납이면 내가 예약한 것인지 확인
			rentalReservedBook(bookNumber);
			
		} else if (bookState.equals("연장함")) {

			//대여중과 같은 처리
			bookStateIsRental(bookNumber);
			
		} else if (bookState.equals("연체함")) {
			//대여불가
			System.out.println("<<이미 대여중인 책입니다.>>");
			afteruserLogin.rentalBookScreen(); // 빠져나가기
			
		}
		
	}//rentalBook
	
	//예약한 회원의 예약 목록에서의 인덱스
	private int rr() {
		int index = 0;
		for (int i = 0; i<ReadFile.reserves.size(); i++) {
			if (ReadFile.reserves.get(i).getUserNo().equals(ReadFile.userNo)) {
				index = i;
			}
		}
		return index;
	}
	
	//예약중인 책 대여
	private void rentalReservedBook(String bookNumber) {
		
		//예약중인 책을 대여목록에서 확인
		for (RentalClass rental : ReadFile.rentals) {
			if (rental.getBookNo().equals(bookNumber)) {
				
				//예약중인 책이 반납됐을 때
				if (rental.getReturnState().equals("반납")) {
				
					//본인이면 대여 가능
					// 입력한 도서번호를 예약 목록에서 찾아서
					// 예약 목록의 회원번호가 로그인 한 회원번호와 같으면 대여
					for (ReserveClass reserve : ReadFile.reserves) {
						if (reserve.getBookNo().equals(bookNumber)) {
							if (reserve.getUserNo().equals(ReadFile.userNo)) {

								// 대여 가능 (예약한 사람)
								// 예약 목록에서 없애기
								ReadFile.reserves.remove(rr());
								writerFile.writeReserveFile();
								
								// 대여 처리
								rental(bookNumber);

							} else {
								// 대여 불가 (예약한 사람 아님)
								System.out.println("<<다른 사람이 예약중인 도서입니다.>>");
								afteruserLogin.afterLoginScreen();
							}
						}
					}
					
				//예약중인 책이 아직 대여중일 때
				} else { 
					System.out.println(rental.getBookNo());
					System.out.println(rental.getReturnState());
					System.out.println("<<!!대여중인 책입니다.>>");
					afteruserLogin.afterLoginScreen();
					
				}
				
			} 
		}
		
	} //rentalReservedBook
	
	//내가 대여한 것인지 확인
	private boolean checkMyRental(String bookNumber) {
		
		boolean check = false;
		List<String> arr = getCurrentRentalBookNos();
		
		//내가 대여한 책인지 체크
		for (String bookNo : arr) {
			if (bookNo.equals(bookNumber)) {
				check = true;
			}
		}
		
		return check;
	}//checkMyRental
	
	//책이 대여중일 때 처리하는 메소드
	private void bookStateIsRental(String bookNumber) {
		
		//내가 대여한 것 확인
		if (checkMyRental(bookNumber)) {
			//내가 대여함
			System.out.println("회원님이 대여한 책입니다.");
			afteruserLogin.rentalBookScreen();
		} else {
			//내가 대여하지 않음
			System.out.println("<<이미 대여중인 책입니다.>>");
			//예약 처리
			reserveScreen(bookNumber);
		}
		
	}//rentalOrExtended
	
	//예약 화면
	private void reserveScreen(String bookNumber) {
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                  [예약하기]                   ┃");
		System.out.println("┃  1. 예약                                      ┃");
		System.out.println("┃  2. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("선택(숫자) : ");
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {
			reserve(bookNumber);
		} else if (sel.equals("2")) {
			//나가기
			afteruserLogin.rentalBookScreen();
		} else {
			System.out.println("1-2의 숫자를 입력해주세요.");
			reserveScreen(bookNumber);
		}
	}//reserveScreen
	
	private void reserve(String bookNumber) {

		// 예약 처리
		for (BookClass book : ReadFile.books) {
			if (book.getBookNo().equals(bookNumber)) {
				
				book.setBookState("예약중");
				System.out.println("<<예약이 완료되었습니다.>>");
				// 도서 목록 파일 다시 쓰기
				writerFile.writeBookFile();
			}
		}
		
		
		try {

			// 예약목록에 추가
			BufferedWriter writerReserveBook = new BufferedWriter(
					new FileWriter(Path.RESERVE_FILE_PATH, true));
			
			// 예약 번호 + 1
			Count.reserveCount++;
			
			writerReserveBook.write(
					String.format("R%05d■%s■%s", Count.reserveCount, ReadFile.userNo, bookNumber));
			writerReserveBook.newLine();
			writerReserveBook.close();
			

		} catch (Exception e) {
			System.out.println("Rental.reserve() : " + e.toString());
		}
		
		// 예약 후 대여하기 화면으로 나가기
		
		afteruserLogin.afterLoginScreen();

	}//reserve
	
	//대여 처리(파일)
	private void rental(String bookNumber) {
		
		//대여 목록에 추가
		RentalClass rental = new RentalClass();
		
		//대여번호 회원번호 도서번호 대여날짜 반납기한
		String rentalNumber;
		String userNumber;
		
		Calendar rentalDate;
		Calendar returnDueDate;
		
		
		//대여번호
		Count.rentalCount++;
		rentalNumber = String.format("B%05d",Count.rentalCount);
		
		//회원번호
		userNumber = ReadFile.userNo;
		
		//대여날짜
		rentalDate = ReadFile.loginDate;
		
		//반납기한
		String[] rdate = String.format("%tF", rentalDate).split("-");
		int year = Integer.parseInt(rdate[0]);
		int month = Integer.parseInt(rdate[1])-1;
		int date = Integer.parseInt(rdate[2]);
		returnDueDate = Calendar.getInstance();
		returnDueDate.set(year, month, date);
		
		returnDueDate.add(Calendar.DATE, 14);
		
		//리스트에 추가
		rental.setRentalNo(rentalNumber);
		rental.setUserNo(userNumber);
		rental.setBookNo(bookNumber);
		rental.setRentalDate(rentalDate);
		rental.setReturnDueDate(returnDueDate);
		rental.setReturnState("대여중");
		
		ReadFile.rentals.add(rental);
		
		
		
		
		
		
		//도서상태 변경 : 대여가능 -> 대여중
		for (BookClass book : ReadFile.books) {
			if (book.getBookNo().equals(bookNumber)) {
				book.setBookState("대여중");
			}
		}
		
		System.out.printf("<<%s번 책이 대여되었습니다.>>\n", bookNumber);
		
		
		
		//파일 다시 쓰기
		writerFile.writeBookFile(); //도서 목록
		writerFile.writeRentalFile(); //대여 목록
		
		afteruserLogin.afterLoginScreen();
		
	}//rental
	
}
