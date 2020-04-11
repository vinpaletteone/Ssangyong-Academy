package commonDTO;

public class AttendanceDTO {
	//tblAttendance DTO
	//작성자 : 유승현
	
	private String seq;		//PK
	private String arriveTime;	//출근시간
	private String leaveTime;	//퇴근시간
	private String state;	//상태
	private String aplprocess_seq;	//FK
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAplprocess_seq() {
		return aplprocess_seq;
	}
	public void setAplprocess_seq(String aplprocess_seq) {
		this.aplprocess_seq = aplprocess_seq;
	}
	
	
}
