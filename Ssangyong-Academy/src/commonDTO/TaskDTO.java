package commonDTO;

public class TaskDTO {
	//tblTask DTO
	//작성자 : 유승현
	private String seq;		//PK
	private String contents;	//과제내용
	private String opensubject_seq;		//FK
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getOpensubject_seq() {
		return opensubject_seq;
	}
	public void setOpensubject_seq(String opensubject_seq) {
		this.opensubject_seq = opensubject_seq;
	}
	
}
