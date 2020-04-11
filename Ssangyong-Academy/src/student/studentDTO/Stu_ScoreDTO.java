package student.studentDTO;

public class Stu_ScoreDTO {
	
	private String os_seq;			//개설 과목 번호
	private String sub_name;		//과목명
	private String sub_start;		//과목 시작일
	private String sub_end;			//과목 종료일
	private String book_name;		//교재명
	private String teacher_name;	//교사명
	private String att_point;		//과목별 배점(출결)
	private String write_point;		//과목별 배점(필기)
	private String prc_point;		//과목별 배점(실기)
	private String task_point;		//과목별 배점(과제)
	private String att_score;		//과목별 성적(출결)
	private String write_score;		//과목별 성적(필기)
	private String prc_score;		//과목별 성적(실기)
	private String task_socre;		//과목별 성적(과제)
	private String test_date;		//과목별 시험날짜
	private String test_question;	//과목별 시험문제
	
	
	public String getOs_seq() {
		return os_seq;
	}
	public void setOs_seq(String os_seq) {
		this.os_seq = os_seq;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getSub_start() {
		return sub_start;
	}
	public void setSub_start(String sub_start) {
		this.sub_start = sub_start;
	}
	public String getSub_end() {
		return sub_end;
	}
	public void setSub_end(String sub_end) {
		this.sub_end = sub_end;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getAtt_point() {
		return att_point;
	}
	public void setAtt_point(String att_point) {
		this.att_point = att_point;
	}
	public String getWrite_point() {
		return write_point;
	}
	public void setWrite_point(String write_point) {
		this.write_point = write_point;
	}
	public String getPrc_point() {
		return prc_point;
	}
	public void setPrc_point(String prc_point) {
		this.prc_point = prc_point;
	}
	public String getTask_point() {
		return task_point;
	}
	public void setTask_point(String task_point) {
		this.task_point = task_point;
	}
	public String getAtt_score() {
		return att_score;
	}
	public void setAtt_score(String att_score) {
		this.att_score = att_score;
	}
	public String getWrite_score() {
		return write_score;
	}
	public void setWrite_score(String write_score) {
		this.write_score = write_score;
	}
	public String getPrc_score() {
		return prc_score;
	}
	public void setPrc_score(String prc_score) {
		this.prc_score = prc_score;
	}
	public String getTask_socre() {
		return task_socre;
	}
	public void setTask_socre(String task_socre) {
		this.task_socre = task_socre;
	}
	public String getTest_date() {
		return test_date;
	}
	public void setTest_date(String test_date) {
		this.test_date = test_date;
	}
	public String getTest_question() {
		return test_question;
	}
	public void setTest_question(String test_question) {
		this.test_question = test_question;
	}
	
}
