package commonDTO;

public class TaskSubmitDTO {
	//tblTaskSubmit DTO
	//작성자 : 유승현
	
	private String seq;	//PK
	private String task_seq;	//과제번호 FK
	private String student_seq;	//학생번호 FK
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTask_seq() {
		return task_seq;
	}
	public void setTask_seq(String task_seq) {
		this.task_seq = task_seq;
	}
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
}
