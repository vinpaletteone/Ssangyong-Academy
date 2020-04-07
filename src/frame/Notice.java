package frame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.BookClass;
import common.OverdueClass;
import common.RentalClass;
import common.ReserveClass;
import data.ReadFile;

public class Notice {
	
	//연체 알람 (회원에게)
	public void overDueNotice() {
		
		//현재 로그인 한 회원
		String userNo = ReadFile.userNo;
		
		//연체?
		//회원이 대여하고 있는 도서 중
		//로그인 한 날짜 - 반납기한 -> 양수이면 연체된 책
		//해당 대여번호의 연체일 수, 연체료 합계
		//
		
		String bookNo = ""; //도서번호
		
		//회원이 빌린 책의 도서번호 담을 Array
		List<String> bookNos = new ArrayList<String>(); 
		
		//대여목록
		for (RentalClass rental : ReadFile.rentals) {
			
			if (rental.getUserNo().equals(userNo)) {
				
				bookNo = rental.getBookNo();
				bookNos.add(bookNo);
			}
		}
		
		//회원이 빌린 책 중 연체한 도서의 도서번호를 담을 Array
		List<String> overNos = new ArrayList<String>();
		
		//빌린 책 중에 연체한 도서 찾기
		//도서목록
		for (BookClass b : ReadFile.books) {
			for (String rentalBook : bookNos) {
				if (rentalBook.equals(b.getBookNo())) {
					if (b.getBookState().equals("연체함")) {
						bookNo = b.getBookNo();
						overNos.add(bookNo);
					}
				}
			}
		}
		
		String rentalNo = "";
		
		//회원이 연체한 도서의 대여번호
		List<String> overRNo = new ArrayList<String>();
		
		//대여목록
		for (RentalClass r : ReadFile.rentals) {
			for (String overNo : overNos) {
				if (r.getBookNo().equals(overNo)) {
					rentalNo = r.getRentalNo();
					overRNo.add(rentalNo);
				}
			}
		}
		
		//연체일 수들 저장할 배열
		List<Integer> overdueCounts = new ArrayList<Integer>();
		
		//연체료 저장할 공간
		int overduePrice = 0;
		
		
		//연체목록
		for (OverdueClass o : ReadFile.overdues) {
			for (String rn : overRNo) {
				if (o.getRentalNo().equals(rn)) {
					overdueCounts.add(o.getOverdueDate());
					overduePrice += o.getOverduePrice();
				}
				
			}
		}
		
		//가장 늦은 연체일
		int max = 0;
		
		for (Integer overdueCount : overdueCounts) {
			if (overdueCount > max) {
				max = overdueCount;
			}
		}
		
		//hLFVKe
		//gqE5DW5X52dCbL
		
		//알림 출력
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [※알림※]                    ┃");
		System.out.println("┠───────────────────────────────────────────────┨");
		
		if (max > 0) {
			System.out.printf("  도서가 %d일 연체되었습니다.\n", max);
			System.out.printf("  연체료는 %d원입니다.\n", overduePrice);
		} else {
			System.out.println("  알림이 없습니다.");
		}
		
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
	}//overDueNotice
	
	//예약한 도서가 반납되었을 때의 알림
	public void reserveNotice() {
		
		
		//예약된 도서
		Map<String, String> reserveMap = new HashMap<String, String>();
		
		List<String> reservedBookNos = new ArrayList<String>();
		
		for (ReserveClass rs : ReadFile.reserves) {
			reservedBookNos.add(rs.getBookNo());
			reserveMap.put(rs.getUserNo(), rs.getBookNo());
		}
		
		for (RentalClass r : ReadFile.rentals) {
			
			for (String bn : reservedBookNos) {
				//예약목록에 있고 대여목록에 있는 도서번호
				if (r.getBookNo().equals(bn) && r.getReturnState().equals("반납")) {
					
				}
			}
			if (r.getBookNo().equals(reserveMap.get(ReadFile.userNo))) {
				
			}
		}
		
	}

}
