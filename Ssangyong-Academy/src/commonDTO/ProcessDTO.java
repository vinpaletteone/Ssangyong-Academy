package commonDTO;

public class ProcessDTO {
	//tblProcess
	//작성자 : 이원필
	private String seq;		//번호(PK)
	private String name;	//과정명
	private String period;	//과정기간
	
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
