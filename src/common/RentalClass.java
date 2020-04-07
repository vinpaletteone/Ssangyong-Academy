package common;
import java.util.Calendar;

public class RentalClass {
	private String rentalNo; //대여번호
	private String userNo; //회원번호
	private String bookNo; //도서번호
	private Calendar rentalDate; //대여날짜
	private Calendar returnDueDate; //반납기한
	private String returnState; //반납여부
	
	public String getRentalNo() {
		return rentalNo;
	}
	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
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
	public Calendar getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Calendar rentalDate) {
		this.rentalDate = rentalDate;
	}
	
	public Calendar getReturnDueDate() {
		return returnDueDate;
	}
	public void setReturnDueDate(Calendar returnDueDate) {
		this.returnDueDate = returnDueDate;
	}
	
	public String getReturnState() {
		return returnState;
	}
	
	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}
	@Override
	public String toString() {
		return "Rental [rentalNo=" + rentalNo + ", userNo=" + userNo + ", bookNo=" + bookNo + ", rentalDate="
				+ String.format("%tF", this.rentalDate) + ", returnDueDate=" + String.format("%tF", this.returnDueDate) + ", returnState=" + returnState + "]";
	}
	
	
}
