package common;

public class ReserveClass {
	private String reserveNo; //예약번호
	private String userNo; //회원번호
	private String bookNo; //도서번호
	
	public String getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	
	@Override
	public String toString() {
		return "Reserve [reserveNo=" + reserveNo + ", userNo=" + userNo + ", bookNo=" + bookNo + "]";
	}
}
