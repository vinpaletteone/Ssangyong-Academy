package commonDTO;

public class ScoreDTO {

	//작성자 : 황영현
	
	private String seq;				//성적 번호(PK)
	private String attendancescore; //출결 점수
	private String writescore;		//필기 점수
	private String practicalscore;	//실기 점수
	private String taskscore;		//과제 점수
	private String opensubject_seq; //개설과목 번호(FK)
	private String aplprocess_seq;  //수강신청 번호(FK)
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getAttendancescore() {
		return attendancescore;
	}
	public void setAttendancescore(String attendancescore) {
		this.attendancescore = attendancescore;
	}
	public String getWritescore() {
		return writescore;
	}
	public void setWritescore(String writescore) {
		this.writescore = writescore;
	}
	public String getPracticalscore() {
		return practicalscore;
	}
	public void setPracticalscore(String practicalscore) {
		this.practicalscore = practicalscore;
	}
	public String getTaskscore() {
		return taskscore;
	}
	public void setTaskscore(String taskscore) {
		this.taskscore = taskscore;
	}
	public String getOpensubject_seq() {
		return opensubject_seq;
	}
	public void setOpensubject_seq(String opensubject_seq) {
		this.opensubject_seq = opensubject_seq;
	}
	public String getAplprocess_seq() {
		return aplprocess_seq;
	}
	public void setAplprocess_seq(String aplprocess_seq) {
		this.aplprocess_seq = aplprocess_seq;
	}
	
	
}
