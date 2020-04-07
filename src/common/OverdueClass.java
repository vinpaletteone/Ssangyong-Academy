package common;

public class OverdueClass {
	private String overdueNo; //연체번호
	private String rentalNo; //대여번호
	private int overdueDate; //연체일수
	private int overduePrice; //연체료
	
	public String getOverdueNo() {
		return overdueNo;
	}
	public void setOverdueNo(String overdueNo) {
		this.overdueNo = overdueNo;
	}
	public String getRentalNo() {
		return rentalNo;
	}
	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
	}
	public int getOverdueDate() {
		return overdueDate;
	}
	public void setOverdueDate(int overdueDate) {
		this.overdueDate = overdueDate;
	}
	public int getOverduePrice() {
		return overduePrice;
	}
	public void setOverduePrice(int overduePrice) {
		this.overduePrice = overduePrice;
	}
	
	@Override
	public String toString() {
		return "Overdue [overdueNo=" + overdueNo + ", rentalNo=" + rentalNo + ", overdueDate=" + overdueDate
				+ ", overduePrice=" + overduePrice + "]";
	}
}
