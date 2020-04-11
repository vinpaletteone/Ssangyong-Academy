package admin.dto;
/***
 * 
 * @author 송재원
 * 
 */
public class Admin_VwOpenProcessDTO {
	
	private String seq;
	private String ProcessName; //과정 이름
	private String StartDate;	//시작일
	private String EndDate;	//종료일
	private String ClassName; // 강의실 이름
	private String StudentCount; //학생수
	private String SelectSubjectCount; // 과목 등록수
	
	public String getProcessName() {
		return ProcessName;
	}
	public void setProcessName(String processName) {
		ProcessName = processName;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getStudentCount() {
		return StudentCount;
	}
	public void setStudentCount(String studentCount) {
		StudentCount = studentCount;
	}
	public String getSelectSubjectCount() {
		return SelectSubjectCount;
	}
	public void setSelectSubjectCount(String selectSubjectCount) {
		SelectSubjectCount = selectSubjectCount;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	

}
