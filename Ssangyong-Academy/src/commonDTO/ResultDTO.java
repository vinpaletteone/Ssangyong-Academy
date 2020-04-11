package commonDTO;

public class ResultDTO {
	//tblResult DTO
	//작성자 : 유승현
	
	private String seq;	//PK
	private String state;	//수료 여부
	private String finalDate;	//수료 여부 날짜
	private String aplprocess_seq;	//FK
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}
	public String getAplprocess_seq() {
		return aplprocess_seq;
	}
	public void setAplprocess_seq(String aplprocess_seq) {
		this.aplprocess_seq = aplprocess_seq;
	}
	
}

