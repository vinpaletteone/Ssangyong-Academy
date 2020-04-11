package admin.dto;

/**
 * 
 * @author 유승현
 * 프로시저 procTeacherPosSubject DTO
 */
public class Admin_procTeacherPosSubjectDTO {
	private String seq; 	//기본키
	private String name;	//과목 이름
	
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
	
}
