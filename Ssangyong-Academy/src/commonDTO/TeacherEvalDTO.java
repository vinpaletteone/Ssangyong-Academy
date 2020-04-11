package commonDTO;

public class TeacherEvalDTO {
	//tblTeacherEval DTO
	//작성자 : 유승현
	private String seq;		//PK
	private String score;		//점수
	private String contents;	//평가내용
	private String aplprocess_seq;	//FK\

	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getAplprocess_seq() {
		return aplprocess_seq;
	}
	public void setAplprocess_seq(String aplprocess_seq) {
		this.aplprocess_seq = aplprocess_seq;
	}
	
	
}
