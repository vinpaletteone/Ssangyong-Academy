package commonDTO;

public class AplProcessDTO {	//수강신청 DTO

	//작성자: 권준혁
	
	private String seq;					//PK 
	private String openprocess_seq;		//개설과정번호(FK)
	private String student_seq;			//학생번호(FK)
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getOpenprocess_seq() {
		return openprocess_seq;
	}
	public void setOpenprocess_seq(String openprocess_seq) {
		this.openprocess_seq = openprocess_seq;
	}
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
	
}
