package commonDTO;

public class OpenProcessDTO {	//개설과정 DTO
	
	//작성자: 권준혁
	
	private String seq;					//PK 
	private String startdate;			//시작일
	private String enddate;				//종료일
	private String classroom_seq;		//강의실 번호(FK)
	private String process_seq;		//과정번호(FK)
	private String teacher_seq;		//교사번호(FK)
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getClassroom_seq() {
		return classroom_seq;
	}
	public void setClassroom_seq(String classroom_seq) {
		this.classroom_seq = classroom_seq;
	}
	public String getProcess_seq() {
		return process_seq;
	}
	public void setProcess_seq(String process_seq) {
		this.process_seq = process_seq;
	}
	public String getTeacher_seq() {
		return teacher_seq;
	}
	public void setTeacher_seq(String teacher_seq) {
		this.teacher_seq = teacher_seq;
	}
	
}
