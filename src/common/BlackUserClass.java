package common;

import data.ReadFile;

public class BlackUserClass {

		private String blackUserNo; //블랙리스트번호
		private String userNo; //회원번호
		private String userName; //이름
		private String userBirth; //생년월일
		private static int count = 0; //블랙리스트번호 카운트
		
		public BlackUserClass(String userNo) {

			this.userNo = userNo;
			
			count++;
			for(BlackUserClass blackUser : ReadFile.blackUsers) {
				int blackUserkNo = Integer.parseInt(blackUser.getBlackUserNo().substring(2,7));
				this.blackUserNo = String.format("BL%05d", blackUserkNo+count);
				
			}
		}
		
		public BlackUserClass() {
			// TODO Auto-generated constructor stub
		}

		public String getBlackUserNo() {
			return blackUserNo;
		}
		public void setBlackUserNo(String blackUserNo) {
			this.blackUserNo = blackUserNo;
		}
		public String getUserNo() {
			return userNo;
		}
		public void setUserNo(String userNo) {
			this.userNo = userNo;
		}
		
		@Override
		public String toString() {
			return "BlackUser [blackUserNo=" + blackUserNo + ", userNo=" + userNo + "]";
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserBirth() {
			return userBirth;
		}

		public void setUserBirth(String userBirth) {
			this.userBirth = userBirth;
		}
	}

