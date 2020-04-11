package commonDTO;

public class PosSubject {
	//PosSubject DTO
	//작성자 : 유승현
	
	private String seq; //PK
	private String teacher_seq;	//교사번호 (FK)
	private String subject_seq; //과목번호 (FK)
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTeacher_seq() {
		return teacher_seq;
	}
	public void setTeacher_seq(String teacher_seq) {
		this.teacher_seq = teacher_seq;
	}
	public String getSubject_seq() {
		return subject_seq;
	}
	public void setSubject_seq(String subject_seq) {
		this.subject_seq = subject_seq;
	}
	
	
}
