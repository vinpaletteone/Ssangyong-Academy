package common;

public class PublisherClass {

	private String bookNo; //도서번호
	private String publisher; //출판사
	
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Publisher [bookNo=" + bookNo + ", publisher=" + publisher + "]";
	}
}
