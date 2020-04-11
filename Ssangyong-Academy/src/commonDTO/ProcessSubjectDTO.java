package commonDTO;

public class ProcessSubjectDTO {	//과정과목 DTO

	//작성자: 권준혁
	
	private String seq;					//PK 
	private String subject_seq;			//과목번호(FK)
	private String process_seq;			//과정번호(FK)
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSubject_seq() {
		return subject_seq;
	}
	public void setSubject_seq(String subject_seq) {
		this.subject_seq = subject_seq;
	}
	public String getProcess_seq() {
		return process_seq;
	}
	public void setProcess_seq(String process_seq) {
		this.process_seq = process_seq;
	}

	
	
}
