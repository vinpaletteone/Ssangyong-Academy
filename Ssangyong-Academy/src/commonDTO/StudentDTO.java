package commonDTO;

public class StudentDTO {
	//tblStudent
	//작성자 : 이원필
	private String seq;
	private String name;
	private String ssn;
	private String tel;
	private String rgstrDate;
	
	public String getRgstrDate() {
		return rgstrDate;
	}
	public void setRgstrDate(String rgstrDate) {
		this.rgstrDate = rgstrDate;
	}
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
