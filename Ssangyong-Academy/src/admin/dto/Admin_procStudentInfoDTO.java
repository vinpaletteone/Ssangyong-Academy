package admin.dto;

/***
 * 
 * @author 송재원
 *
 */
public class Admin_procStudentInfoDTO {

	private String seq;
	private String StudentName;
	private String ssn;
	private String tel;
	private String rgstrdate;
	private String state;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}