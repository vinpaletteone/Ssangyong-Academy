package admin.dto;

/**
 * @author 유승현
 * 뷰 vwEndOpenProcess DTO
 */
public class Admin_vwEndOpenProcessDTO {
	
	private String seq;
	private String processName;
	private String teacherName;

	public String getSeq(){
		return seq;
	}
	public void setSeq(String seq){
		this.seq = seq;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	
}
