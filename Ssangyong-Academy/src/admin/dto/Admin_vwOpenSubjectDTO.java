package admin.dto;

/**
 * 
 * @author 유승현
 * 뷰 vwOpenSubject DTO
 */
public class Admin_vwOpenSubjectDTO {
	private String teacherName;
	private String openProcess_seq;
	private String processName;
	private String roomName;
	private String cntSubject;
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getOpenProcess_seq() {
		return openProcess_seq;
	}
	public void setOpenProcess_seq(String openProcess_seq) {
		this.openProcess_seq = openProcess_seq;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getCntSubject() {
		return cntSubject;
	}
	public void setCntSubject(String cntSubject) {
		this.cntSubject = cntSubject;
	}
	
	
	
}
