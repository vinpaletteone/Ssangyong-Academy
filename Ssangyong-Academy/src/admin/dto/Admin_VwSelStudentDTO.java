package admin.dto;
/**
 * 
 * @author 송재원
 *
 */
public class Admin_VwSelStudentDTO {

	private String StudentNum;
	private String StudentName;
	private String ProcessName;
	private String period;
	private String ClassName;
	private String state;
	private String finaldate;

	public String getStudentNum() {
		return StudentNum;
	}

	public void setStudentNum(String studentNum) {
		StudentNum = studentNum;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getProcessName() {
		return ProcessName;
	}

	public void setProcessName(String processName) {
		ProcessName = processName;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFinaldate() {
		return finaldate;
	}

	public void setFinaldate(String finaldate) {
		this.finaldate = finaldate;
	}

}
