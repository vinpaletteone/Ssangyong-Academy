package common;
import java.util.Calendar;

public class BookClass {
	private String bookNo; //도서번호
	private String bookTitle; //제목
	private String author; //저자
	private String publisher; //출판사
	private int price; //가격
	private Calendar insertDate; //등록날짜
	private String bookState; // 도서상태
	private int reviewCount; //리뷰 개수
	

	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Calendar getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Calendar insertDate) {
		this.insertDate = insertDate;
	}
	public String getBookState() {
		return bookState;
	}
	public void setBookState(String bookState) {
		this.bookState = bookState;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", insertDate=" + String.format("%tF", this.insertDate) + ", bookState=" + bookState + ", reivewCount="
				+ reviewCount + "]";
	}
	
	
}
