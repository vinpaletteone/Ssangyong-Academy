package common;

public class ExtensionClass {
	private String extensionNo; //연장번호
	private String rentalNo; //대여번호
	private int extensionCount; //연장횟수
	
	public String getExtensionNo() {
		return extensionNo;
	}
	public void setExtensionNo(String extensionNo) {
		this.extensionNo = extensionNo;
	}
	public String getRentalNo() {
		return rentalNo;
	}
	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
	}
	public int getExtensionCount() {
		return extensionCount;
	}
	public void setExtensionCount(int extensionCount) {
		this.extensionCount = extensionCount;
	}
	
	@Override
	public String toString() {
		return "Extension [extensionNo=" + extensionNo + ", rentalNo=" + rentalNo + ", extensionCount=" + extensionCount
				+ "]";
	}
}
