package admin.dto;

public class Admin_vwAdminStudentScoreDTO {
	private String seq;
	private String openSubject_seq;
	private String studentName;
	private String subjectName;
	private String attendanceScore;
	private String practicalScore;
	private String taskScore;
	private String writeScore;
	
	public String getOpenSubject_seq() {
		return openSubject_seq;
	}
	public void setOpenSubject_seq(String openSubject_seq) {
		this.openSubject_seq = openSubject_seq;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getAttendanceScore() {
		return attendanceScore;
	}
	public void setAttendanceScore(String attendanceScore) {
		this.attendanceScore = attendanceScore;
	}
	public String getPracticalScore() {
		return practicalScore;
	}
	public void setPracticalScore(String practicalScore) {
		this.practicalScore = practicalScore;
	}
	public String getTaskScore() {
		return taskScore;
	}
	public void setTaskScore(String taskScore) {
		this.taskScore = taskScore;
	}
	public String getWriteScore() {
		return writeScore;
	}
	public void setWriteScore(String writeScore) {
		this.writeScore = writeScore;
	}
}
