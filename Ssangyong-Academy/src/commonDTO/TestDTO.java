package commonDTO;


public class TestDTO {
	
	//작성자 : 황영현
	
	private String seq;				//시험 번호(PK)
	private String regdate;			//시험 날짜
	private String question;		//시험 문제
	private String openSubject_seq; //개설과목번호(FK)
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOpenSubject_seq() {
		return openSubject_seq;
	}
	public void setOpenSubject_seq(String openSubject_seq) {
		this.openSubject_seq = openSubject_seq;
	}
	
	
}
