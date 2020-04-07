package common;

public class ReviewClass {
	private String reviewNo; //리뷰번호
	private String userNo; //회원번호
	private String bookNo; //도서번호
	private int reviewScore; //별점
	private String rentalNo; //반납번호
	private String nickName; //닉네임
 	private String content; //리뷰내용
	
	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
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

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		
		if (reviewScore >= 1 && reviewScore <= 5) {
			this.reviewScore = reviewScore;			
		} else {
			System.out.println("평점은 1~5사이의 숫자로 입력하세요.");
		}
		
	}

	public String getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", rentalNo=" + rentalNo + ", content=" + content + ", userNo=" + userNo
				+ ", bookNo=" + bookNo + "]";
	}
}
