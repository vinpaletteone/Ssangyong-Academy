package admin.dto;

public class AdminMain_SManagementDTO {

	// 교육생 정보 : 교육생 이름, 주민번호 뒷자리, 전화번호, 등록일
	private String seq;
	private String name;
	private String ssn;
	private String tel;
	private String rgstrdate;
	
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
	public String getRgstrdate() {
		return rgstrdate;
	}
	public void setRgstrdate(String rgstrdate) {
		this.rgstrdate = rgstrdate;
	}
	
	
}