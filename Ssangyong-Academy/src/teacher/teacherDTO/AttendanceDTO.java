package teacher.teacherDTO;

public class AttendanceDTO {

	//작성자 : 안유니
	
	private String Op_seq;
	private String St_seq;
	private String St_name;
	private String Att_arrivetime;
	private String Att_leavetime;
	private String Att_state;

	
	public String getOp_seq() {
		return Op_seq;
	}
	public void setOp_seq(String op_seq) {
		this.Op_seq = op_seq;
	}
	public String getSt_seq() {
		return St_seq;
	}
	public void setSt_seq(String st_seq) {
		St_seq = st_seq;
	}
	public String getSt_name() {
		return St_name;
	}
	public void setSt_name(String st_name) {
		St_name = st_name;
	}
	public String getAtt_arrivetime() {
		return Att_arrivetime;
	}
	public void setAtt_arrivetime(String att_arrivetime) {
		Att_arrivetime = att_arrivetime;
	}
	public String getAtt_leavetime() {
		return Att_leavetime;
	}
	public void setAtt_leavetime(String att_leavetime) {
		Att_leavetime = att_leavetime;
	}
	public String getAtt_state() {
		return Att_state;
	}
	public void setAtt_state(String att_state) {
		Att_state = att_state;
	}
	public String getT_seq() {
		return T_seq;
	}
	public void setT_seq(String t_seq) {
		T_seq = t_seq;
	}
	private String T_seq;
	
	
	
	
	
}
