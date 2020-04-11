package student.studentDTO;

public class EvalDTO {

	private String eval_seq;		//평가 번호
	private String teacher_name;	//교사명
	private String re_state;		//수료 여부
	private String re_finaldate;	//수료/중도탈락 날짜
	private String student_seq;		//학생번호
	private String student_name;	//학생명
	private String eval_contents;	//평가 내용
	private String eval_score;		//평가 점수
	
	
	public String getEval_seq() {
		return eval_seq;
	}
	
	public void setEval_seq(String eval_seq) {
		this.eval_seq = eval_seq;
	}
	
	public String getTeacher_name() {
		return teacher_name;
	}
	
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	
	public String getRe_state() {
		return re_state;
	}
	
	public void setRe_state(String re_state) {
		this.re_state = re_state;
	}
	
	public String getRe_finaldate() {
		return re_finaldate;
	}
	
	public void setRe_finaldate(String re_finaldate) {
		this.re_finaldate = re_finaldate;
	}
	
	public String getStudent_seq() {
		return student_seq;
	}
	
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	public String getEval_contents() {
		return eval_contents;
	}
	
	public void setEval_contents(String eval_contents) {
		this.eval_contents = eval_contents;
	}
	
	public String getEval_score() {
		return eval_score;
	}
	
	public void setEval_score(String eval_score) {
		this.eval_score = eval_score;
	}

	
	
	
}
