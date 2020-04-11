package student.studentDTO;

public class Stu_AttendanceDTO { //권준혁 제작 학생 출결용 DTO

	private String op_seq;
	private String st_seq;
	private String att_arrivetime;
	private String att_leavetime;
	private String att_state;
	private String t_name;
	private String t_seq;
	
	
	public String getOp_seq() {
		return op_seq;
	}
	public void setOp_seq(String op_seq) {
		this.op_seq = op_seq;
	}
	public String getSt_seq() {
		return st_seq;
	}
	public void setSt_seq(String st_seq) {
		this.st_seq = st_seq;
	}
	public String getAtt_arrivetime() {
		return att_arrivetime;
	}
	public void setAtt_arrivetime(String att_arrivetime) {
		this.att_arrivetime = att_arrivetime;
	}
	public String getAtt_leavetime() {
		return att_leavetime;
	}
	public void setAtt_leavetime(String att_leavetime) {
		this.att_leavetime = att_leavetime;
	}
	public String getAtt_state() {
		return att_state;
	}
	public void setAtt_state(String att_state) {
		this.att_state = att_state;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_seq() {
		return t_seq;
	}
	public void setT_seq(String t_seq) {
		this.t_seq = t_seq;
	}

}
