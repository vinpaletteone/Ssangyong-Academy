package admin.dto;

public class AdminMain_AttendanceSearchDTO {

	private String St_seq;
	private String St_name;
	private String Att_arrivetime;
	private String Att_leavetime;
	private String Att_state;

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

}
