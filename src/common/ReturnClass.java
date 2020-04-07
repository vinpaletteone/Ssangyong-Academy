package common;
import java.util.Calendar;

public class ReturnClass {

	private String returnNo; //반납번호
	private Calendar returnDate; //반납된날짜
	private String rentalNo; //대여번호
	
	public String getReturnNo() {
		return returnNo;
	}
	public void setReturnNo(String returnNo) {
		this.returnNo = returnNo;
	}
	public Calendar getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Calendar returnDate) {
		this.returnDate = returnDate;
	}
	public String getRentalNo() {
		return rentalNo;
	}
	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
	}
	
	@Override
	public String toString() {
		return "Return [returnNo=" + returnNo + ", returnDate=" + String.format("%tF", this.returnDate) + ", rentalNo=" + rentalNo + "]";
	}	

}
