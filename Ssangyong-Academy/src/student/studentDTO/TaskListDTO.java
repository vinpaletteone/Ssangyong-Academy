package student.studentDTO;

public class TaskListDTO {
	
	private String task_seq;		//과제 번호
	private String os_startdate;	//개설 과목 시작일
	private String os_enddate;		//개설 과목 종료일
	private String sub_name;		//과목명
	private String task_contents;	//과제 내용
	private String submit_state;	//제출 상태
	
	public String getTask_seq() {
		return task_seq;
	}
	public void setTask_seq(String task_seq) {
		this.task_seq = task_seq;
	}
	public String getOs_startdate() {
		return os_startdate;
	}
	public void setOs_startdate(String os_startdate) {
		this.os_startdate = os_startdate;
	}
	public String getOs_enddate() {
		return os_enddate;
	}
	public void setOs_enddate(String os_enddate) {
		this.os_enddate = os_enddate;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getTask_contents() {
		return task_contents;
	}
	public void setTask_contents(String task_contents) {
		this.task_contents = task_contents;
	}
	public String getSubmit_state() {
		return submit_state;
	}
	public void setSubmit_state(String submit_state) {
		this.submit_state = submit_state;
	}

}
