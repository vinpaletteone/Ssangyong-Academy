package student.studentDTO;

public class LoginDTO {

	private String seq;		//학생 번호
	private String name;	//학생 이름
	private String ssn;		//비밀번호 (학생 주민등록번호)
	
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
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
