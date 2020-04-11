package admin.dto;

public class AdminMain_TaskSearchDTO {

	/*
	 * t.seq as teacher_seq, --교사번호 t.name as teacher_name, --교사이름 p.name as
	 * process_name, --과정이름 sub.name as subject_name, --과목명 s.name as student_name,
	 * ta.contents as task_contents, --과제내용 sc.taskscore as task_score
	 */
	private String teacher_seq;
	private String teacher_name;
	private String process_name;
	private String subject_name;
	private String student_name;
	private String task_contents;
	private String task_score;

	public String getTeacher_seq() {
		return teacher_seq;
	}

	public void setTeacher_seq(String teacher_seq) {
		this.teacher_seq = teacher_seq;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getProcess_name() {
		return process_name;
	}

	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getTask_contents() {
		return task_contents;
	}

	public void setTask_contents(String task_contents) {
		this.task_contents = task_contents;
	}

	public String getTask_score() {
		return task_score;
	}

	public void setTask_score(String task_score) {
		this.task_score = task_score;
	}

}
