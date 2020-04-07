package common;

import data.ReadFile;

public class UserClass {
	private String userNo; //회원번호
	private String id; //아이디
	private String password; //비번
	private String name; //이름
	private String birth; //생년월일
	private String phone; //전번
	private static int count = 0; //회원번호 카운트

	
	
	public UserClass(String id, String password, String name, String birth, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		
		count++;
		for(UserClass user : ReadFile.users) {
			int userNo = Integer.parseInt(user.getUserNo().substring(1,6));
			this.userNo = String.format("U%05d", userNo+count);
		}
		
	}
	
	public UserClass() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", id=" + id + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", birth=" + birth + "]";
	}
}
