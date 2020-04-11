package teacher.teacherDTO;

public class LoginDTO {

	//작성자 : 안유니 = TeacherDTO와 동일 
	
	private String seq; //번호(PK)
	private String name;//교사명
	private String ssn; //주민번호
	private String tel; //전화번호
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
