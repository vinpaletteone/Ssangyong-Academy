package data;

import java.io.FileReader;
import java.util.Scanner;

public class Count {
	
	//각 클래스의 객체 개수 셀 변수
	
	public static int userCount;
	public static int bookCount;
	public static int authorCount;
	public static int blackUserCount;
	public static int extensionCount;
	public static int overdueCount;
	public static int publisherCount;
	public static int rentalCount;
	public static int returnCount;
	public static int reserveCount;
	public static int reviewCount;
	
	static {
		userCount = getLastUserNo();
		bookCount = getLastBookNo();
		authorCount = ReadFile.authors.size();
		publisherCount = ReadFile.publishers.size();
		blackUserCount = getLastBlackUserNo();
		extensionCount = getLastExtensionNo();
		overdueCount = getLastOverdueNo();
		rentalCount = getLastRentalNo();
		returnCount = getLastReturnNo();
		reserveCount = getLastReserveNo();
		
		reviewCount = 10; //초기 리뷰 데이터 10개 - 라인 수로 셀 수 없어 size() 못 씀
	}
	
	
	

	// 마지막 도서 번호
	// 00000
	private static int getLastBookNo() {
		
		String lastNo = ReadFile.books.get(ReadFile.books.size()-1).getBookNo();
		int lastBookNo = Integer.parseInt(lastNo);

		return lastBookNo;
	}//getLastBookNo
	

	// 마지막 회원 번호
	// U00000
	private static int getLastUserNo() {
		
		String lastNo = ReadFile.users.get(ReadFile.users.size()-1).getUserNo();
		int lastUserNo = Integer.parseInt(lastNo.substring(1));

		return lastUserNo;
	}//getLastUserNo
	
	
	// 마지막 블랙리스트 번호
	// BL00000
	private static int getLastBlackUserNo() {

		String lastNo = ReadFile.blackUsers.get(ReadFile.blackUsers.size() - 1).getBlackUserNo();
		int lastAuthorNo = Integer.parseInt(lastNo.substring(2));

		return lastAuthorNo;
	}
	
	
	// 마지막 연장 번호
	// E00000
	private static int getLastExtensionNo() {
		
		String lastNo = ReadFile.extensions.get(ReadFile.extensions.size() - 1).getExtensionNo();
		int lastExtensionNo = Integer.parseInt(lastNo.substring(1));

		return lastExtensionNo;
		
	}//getLastExtensionNo

	
	// 마지막 연체 번호
	// O00000
	private static int getLastOverdueNo() {
		
		String lastNo = ReadFile.overdues.get(ReadFile.overdues.size() - 1).getOverdueNo();
		int lastOverdueNo = Integer.parseInt(lastNo.substring(1));

		return lastOverdueNo;
		
	}//getLastOverdueNo
	
	
	// 마지막 반납 번호
	// RT00000
	private static int getLastReturnNo() {

		String lastNo = ReadFile.returns.get(ReadFile.returns.size() - 1).getReturnNo();
		int lastReturnNo = Integer.parseInt(lastNo.substring(2));

		return lastReturnNo;

	}//getLastReturnNo
	

	// 마지막 대여 번호
	// B00000
	private static int getLastRentalNo() {

		String lastNo = ReadFile.rentals.get(ReadFile.rentals.size() - 1).getRentalNo();
		int lastRentalNo = Integer.parseInt(lastNo.substring(1));

		return lastRentalNo;
		
	}//getLastRentalNo

	
	// 마지막 예약 번호
	// R00000
	private static int getLastReserveNo() {
		
		String lastNo = ReadFile.reserves.get(ReadFile.reserves.size() - 1).getReserveNo();
		int lastRentalNo = Integer.parseInt(lastNo.substring(1));

		return lastRentalNo;

	}//getLastReserveNo
	
	
	
	//리뷰 개수
//	private static int getLastReviewNo() {
//
//		int count = 0;
//		try {
//
//			Scanner scanFile = new Scanner(new FileReader(Path.REVIEW_FILE_PATH));
//
//			String temp = "";
//			while (scanFile.hasNext()) {
//				temp += scanFile.nextLine();
//			}
//
//			int index = 0;
//
//			while (true) {
//				index = temp.indexOf("===", index);
//				if (index == -1) {
//					break;
//				}
//				count++;
//				index += "===".length();
//			}
//
//			scanFile.close();
//
//		} catch (Exception e) {
//			System.out.println("Count.review() : " + e.toString());
//		}
//		return count;
//
//	}// getLastReviewNo

}
