package admin.dto;

/**
 * 
 * @author 유승현
 * Admin_vwOpenProcessSubject DTO
 */
public class Admin_vwOpenProcessSubjectDTO {
	
	private String opensubject_seq;
	private String openProcess_seq;
	private String subjectName;
	private String startDate;
	private String endDate;
	private String period;

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getOpensubject_seq() {
		return opensubject_seq;
	}
	public void setOpensubject_seq(String opensubject_seq) {
		this.opensubject_seq = opensubject_seq;
	}
	public String getOpenProcess_seq() {
		return openProcess_seq;
	}
	public void setOpenProcess_seq(String openProcess_seq) {
		this.openProcess_seq = openProcess_seq;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
	
	
}
