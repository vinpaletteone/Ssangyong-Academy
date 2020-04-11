package commonDTO;

public class ScoremgntDTO {
	
	//작성자 : 황영현
	
	private String opensubject_seq; //개설과목번호(PK,FK)
	private String attendancepoints;//출결 배점
	private String writepoints;		//필기 배점
	private String practicalpoints; //실기 배점
	private String taskspoints;		//과제 배점
	
	public String getOpensubject_seq() {
		return opensubject_seq;
	}
	public void setOpensubject_seq(String opensubject_seq) {
		this.opensubject_seq = opensubject_seq;
	}
	public String getAttendancepoints() {
		return attendancepoints;
	}
	public void setAttendancepoints(String attendancepoints) {
		this.attendancepoints = attendancepoints;
	}
	public String getWritepoints() {
		return writepoints;
	}
	public void setWritepoints(String writepoints) {
		this.writepoints = writepoints;
	}
	public String getPracticalpoints() {
		return practicalpoints;
	}
	public void setPracticalpoints(String practicalpoints) {
		this.practicalpoints = practicalpoints;
	}
	public String getTaskspoints() {
		return taskspoints;
	}
	public void setTaskspoints(String taskspoints) {
		this.taskspoints = taskspoints;
	}
	
	
}
