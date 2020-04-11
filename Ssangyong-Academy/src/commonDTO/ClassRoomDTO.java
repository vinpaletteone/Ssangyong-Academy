package commonDTO;

public class ClassRoomDTO {
	// tblClassRoom
	// 작성자 : 이원필
	private String seq;		//번호(PK)
	private String name;	//강의실명
	private String capacity;//정원
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
}
