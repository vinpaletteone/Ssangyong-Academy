package commonDTO;

public class BookDTO {   // 교재 DTO
	
	//작성자: 권준혁
	
	private String seq;					//PK 
	private String name;				//교재명
	private String publisher;			//출판사명
	private String opensubject_seq;		//개설과목번호(FK)
	
	
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getOpensubject_seq() {
		return opensubject_seq;
	}
	public void setOpensubject_seq(String opensubject_seq) {
		this.opensubject_seq = opensubject_seq;
	}
    
	
	
	
}
