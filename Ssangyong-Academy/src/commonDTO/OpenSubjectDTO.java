package commonDTO;

public class OpenSubjectDTO {	//개설과목 DTO
	
	//작성자: 권준혁
	
	private String seq;					//PK 
	private String startdate;			//시작일
	private String enddate;				//종료일
	private String openprocess_seq;		//개설과정번호(FK)
	private String processSubject;		//개설과목번호(FK)
	
	
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
	public String getOpenprocess_seq() {
		return openprocess_seq;
	}
	public void setOpenprocess_seq(String openprocess_seq) {
		this.openprocess_seq = openprocess_seq;
	}
	public String getProcessSubject() {
		return processSubject;
	}
	public void setProcessSubject(String processSubject) {
		this.processSubject = processSubject;
	}
	
}
