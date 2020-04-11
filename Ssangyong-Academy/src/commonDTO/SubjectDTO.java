package commonDTO;

public class SubjectDTO {
	//tblSubject
	//작성자 : 이원필
	
	private String seq;		//번호(PK)
	private String name;	//과목명
	private String period;	//과목기간
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
}
