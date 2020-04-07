package common;

public class AuthorClass {
	
	private String bookNo; //도서번호
	private String author; //저자
	
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Author [bookNo=" + bookNo + ", author=" + author + "]";
	}

}

