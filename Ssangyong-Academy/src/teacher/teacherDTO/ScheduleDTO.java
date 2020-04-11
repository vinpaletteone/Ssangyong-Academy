package teacher.teacherDTO;

public class ScheduleDTO {

	//작성자 : 안유니
	
	private String op_seq;			//개설 과정 번호
	private String os_seq;			//개설 과목 번호
	private String p_name;			//과정명
	private String op_startdate;	//과정 시작
	private String op_enddate;		//과정 종료
	private String cr_name;			//강의실
	private String s_name; 			//과목명
	private String os_startdate;	//과목 시작
	private String os_enddate; 		//과목 종료
	private String b_name;			//교재명
	private String t_seq;			//교사 번호
	private String p_state; 		//강의진행 상태
	private String stucount;		//교육생 등록 인원
	
	public String getOs_seq() {
		return os_seq;
	}
	public void setOs_seq(String os_seq) {
		this.os_seq = os_seq;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getOp_startdate() {
		return op_startdate;
	}
	public void setOp_startdate(String op_startdate) {
		this.op_startdate = op_startdate;
	}
	public String getOp_enddate() {
		return op_enddate;
	}
	public void setOp_enddate(String op_enddate) {
		this.op_enddate = op_enddate;
	}
	public String getCr_name() {
		return cr_name;
	}
	public void setCr_name(String cr_name) {
		this.cr_name = cr_name;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
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
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getT_seq() {
		return t_seq;
	}
	public void setT_seq(String t_seq) {
		this.t_seq = t_seq;
	}
	public String getP_state() {
		return p_state;
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
	}
	public String getStucount() {
		return stucount;
	}
	public void setStucount(String stucount) {
		this.stucount = stucount;
	}
	public String getOp_seq() {
		return op_seq;
	}
	public void setOp_seq(String op_seq) {
		this.op_seq = op_seq;
	}
	
	
	
}
