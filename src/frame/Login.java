package frame;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.BlackUserClass;
import common.OverdueClass;
import common.RentalClass;
import common.UserClass;
import data.Path;
import data.ReadFile;
import data.WriterFile;

public class Login {
	
	static Scanner scan;
	UserClass user;
	
	static {
		scan = new Scanner(System.in);
	}
	
	public Login() {
		this.user = new UserClass();
	}
	
	
	public void mainScreen() {
		
		System.out.println();
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                 [역삼 도서관]                 ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 로그인                                    ┃");
		System.out.println("┃  2. 회원가입                                  ┃");
		System.out.println("┃  3. 아이디 찾기                               ┃");
		System.out.println("┃  4. 비밀번호 찾기                             ┃");
		System.out.println("┃  5. 종료                                      ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		System.out.print("선택(숫자): ");
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {
			loginScreen();
		} else if (sel.equals("2")) {
			signUpScreen();
		} else if (sel.equals("3")) {
			findIDScreen();
		} else if (sel.equals("4")) {
			findPasswordScreen();
		} else if (sel.equals("5")) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		} else {
			System.out.println("1-5의 숫자를 입력해주세요.");
			mainScreen();
		}
	}
	
	

	// 로그인 화면
	public void loginScreen() {

		String id, password;

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                    [로그인]                   ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		System.out.print("아이디 : ");
		id = scan.nextLine();

		System.out.print("비밀번호 : ");
		password = scan.nextLine();
		
		if (loginCheck(id, password)) {
			findIDScreen();
		}
		
		loginScreen();

	}// login

	//관리자 계정과 회원 계정을 구분
	// 아이디를 쓸 수 있게 돌려줌
	// 로그인 아이디, 패스워드 유효성 검사
	
	private boolean loginCheck(String id, String password) {
		
		int flag = 3;
		boolean flagId = false;
		String userName="";
		String userNum="";
		String userBirth = "";
		boolean flagBlack=true;
	
		for (UserClass user : ReadFile.users) {
		
			//아이디랑 비밀번호가 둘다 같을 경우
			//System.out.printf("[%s][%s][%s][%s]\n", user.getId(), id, user.getPassword());

			if(id.equals("admin") && password.equals("111111111111") ) {
				flag=1;
				break;
			} else if(id.equals(user.getId()) && password.equals(user.getPassword())) {
				flag=2;
				//System.out.println("회원");
				userName = user.getName();
				userNum = user.getUserNo();
				userBirth = user.getBirth();
				ReadFile.userNo = user.getUserNo();
				break;
			} else if(id.equals(user.getId()) && !password.equals(user.getPassword())) {
				flagId=true;
				flag=3;
			} else {
				flag=3;
			}

		}//for
			

		if (flag == 1) {
			//관리자일때
			AfterAdminLogin adminLogin = new AfterAdminLogin();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("  [관리자]로 로그인이 완료되었습니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

			adminLogin.afterLoginScreen();
			
			return false;
		}else if (flag == 2) {
			//System.out.println("회원 로그인 완료");
			
			//연체
			for(OverdueClass overdue : ReadFile.overdues) {
				
				//System.out.println(overdue.getOverdueDate());
				if(overdue.getOverdueDate() > 30) { //30일 초과
					String overdueNo = overdue.getRentalNo(); //대여번호 알아냄
					//System.out.println(overdueNo);
					
					//대여
					for(RentalClass rental : ReadFile.rentals) {
						if(rental.getRentalNo().equals(overdueNo)) { //대여번호가 똑같으면
							
							//System.out.println(rental.getRentalNo()); //B00047
							
							if(userNum.equals(rental.getUserNo())) {
								//System.out.println(rental.getUserNo()); //U00102
								
								//회원번호를 알아내고 블랙리스트에 추가
								ReadFile.blackUsers.add(new BlackUserClass(rental.getUserNo()));
								
								//System.out.println(ReadFile.blackUsers);
								
								int count = 0;
								
								//블랙리스트
								for (BlackUserClass blackUser : ReadFile.blackUsers) {
									//System.out.println(ReadFile.blackUsers.get(ReadFile.blackUsers.size() - 1).getBlackUserNo().substring(2, 7));
									int blackUserNo = Integer.parseInt(ReadFile.blackUsers.get(ReadFile.blackUsers.size() - 1).getBlackUserNo().substring(2, 7));
									//System.out.println(blackUserNo);  //10
									blackUserWriter(String.format("BL%05d■%s■%s■%s\n", blackUserNo + count, rental.getUserNo(), userName, userBirth));
									break;
								}
								
								int index = findUserNo(rental.getUserNo()); //회원번호를 알아냄
								ReadFile.users.remove(index); //회원에서 삭제
								
								WriterFile writerFile = new WriterFile();
								writerFile.writeUserFile();
								
								System.out.println("연체일 30일 초과, 회원탈퇴");
								flagBlack = false;
								
							}
						}
					}
					
					
				} 
				
			} //for (overdueclass :      )
		
			if(flagBlack){
				
				//사용자일때
				System.out.println();
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.printf( "  [%s]님 환영합니다.\n", userName);
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				AfterUserLogin afterLogin = new AfterUserLogin();
				afterLogin.afterLoginScreen();
				
				//여기에 넣으면 값이 안 바뀜
				ReadFile.userNo = user.getUserNo();
				//flag = 2;
				//return false;
			
			}
			
			return false;
			
		}else if (flag == 3) {
			if(flagId) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}else
			System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
			return true;
		} else {
			System.out.println("시스템 오류");
			return true;
		}
	
		
		
	}



	//회원번호를 알아내는 index
	private int findUserNo(String userNo) {

		for (int i = 0; i < ReadFile.users.size(); i++) {
			   if (ReadFile.users.get(i).getUserNo().equals(userNo)) {
				   return i;
			   }
		}
		return -1;
	}


	//회원가입 화면
	private void signUpScreen() {

		String id="", password="", name="", birth="", tel="";
		boolean check = true;
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [회원가입]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		
		
		//아이디
		while (check) {
		
			System.out.print("  아이디(4~16자) : ");
			id = scan.nextLine();
			
			//아이디 유효성 검사
			if (userIDCheck(id)) {
				continue;
			}
			
			break;
		}

		//비밀번호
		while (check) {
			System.out.print("  비밀번호(10~16자) : ");
			password = scan.nextLine();
		
			//아이디 유효성 검사
			if (userPWCheck(password)) {
				continue;
			}
			
			break;
		}
		
		while (check) {
			System.out.print("  이름: ");
			name = scan.nextLine();

			//이름 유효성검사
			if(userNameCheck(name)) {
				continue;
			}
			
			break;
		}


		while (check) {
			System.out.print("  생년월일(ex)991231): ");
			birth = scan.nextLine();
			
			// 생년월일 유효성 검사
			if(userBirthCheck(birth)) {
				continue;
			} 
			
			break;
		}
		
		while(check) {
			System.out.print("  전화번호(ex)010-1234-5678): ");
			tel = scan.nextLine();
			
			//전화번호 유효성 검사
			if(userTelCheck(tel)) {
				continue;
			}
			
			break;
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		//블랙리스트 회원 재가입 불가
		for(BlackUserClass black : ReadFile.blackUsers) {
			
			if(black.getUserName().equals(name) && black.getUserBirth().equals(birth)) {
				System.out.println("블랙리스트 회원가입 불가");
				break;
			}else {
				
				// 다시보기
				ReadFile.users.add(new UserClass(id, password, name, birth, tel));
				System.out.println("  " + name + "님, 회원가입을 축하드립니다.");
				System.out.println();
				
				// System.out.println(ReadFile.users.get(ReadFile.users.size()-1));
				
				int count = 0;
				
				for (UserClass user : ReadFile.users) {
					int userNo = Integer.parseInt(ReadFile.users.get(ReadFile.users.size() - 1).getUserNo().substring(1, 6));
					// System.out.printf("U%05d", userNo+count); //회원번호 출력
					userWriter(String.format("U%05d■%s■%s■%s■%s■%s\n", userNo + count, id, password, name, birth, tel));
					break;
				}
				
				mainScreen();
				
			}
		}
		
		
		

	}// signUp

	// 유효성 검사
	//아이디 유효성 검사
	private boolean userIDCheck(String id) {
		// 중복되는 아이디가 있는지 검색
		// 기존 회원들의 아이디와 중복되는 아이디를 입력했을 경우 메세지를 띄우고 다시 입력받는다.
		for (UserClass user : ReadFile.users) {
			if (user.getId().equals(id)) {
				System.out.println("  !알림 : 중복된 아이디 입니다.");
				return true;
			}
		}

		// 길이는 4-16자로 제한한다
		if (id.length() < 4 || id.length() > 16) {
			System.out.println("  !알림 : 아이디는 4 ~ 16자로 입력해주세요.");
			// 다시 입력받기
			return true;
		}

		// 첫글자는 영어 소문자이여야한다
		// if((int)'a' != (char)id.charAt(0)) {
		if (!((id.charAt(0) >= 'a') && (id.charAt(0) <= 'z'))) {
			System.out.println("  !알림 : 앞자리는 영어 소문자로 입력하세요.");
			// 다시 입력받기
			return true;
		}

		// 영어 소문자, 숫자, _만 아이디에 사용할 수 있다.

		for (int i = 0; i < id.length(); i++) {
			int ch = id.charAt(i); // "a" -> 'a'
			if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z') && !(id.equals("_"))) {
				System.out.println("  !알림 : 영어 소문자, 숫자, _만 아이디에 사용할 수 있습니다.");
				// 다시 입력받기
				return true;
			}
		}

		return false;

	}// userIDCheck

	//비밀번호 유효성 검사
	private boolean userPWCheck(String password) {

		// 10 ~ 16자리로 입력
		if (password.length() < 10 || password.length() > 16) {
			System.out.println("10 ~ 16자리로 입력해주세요.");
			return true;
		}

		// 영어 대문자, 소문자
		for (int i = 0; i < password.length(); i++) {
			int ch = password.charAt(i);
			if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z')) {
				System.out.println("  !알림 : 영어 대문자, 소문자, 숫자만 비밀번호에 사용할 수 있습니다.");
				// 다시 입력받기
				return true;
			}
		}

		return false;

	}// userPWCheck

	// 이름 유효성 검사
	private boolean userNameCheck(String name) {

		String regex = "^[가-힣]{2,5}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);

		if (!m.find()) {
			System.out.println("  !알림 : 한글로 입력해주세요.");
			return true;
		}

		return false;
	}// userNameCheck

	// 생년월일 유효성 검사
	private boolean userBirthCheck(String birth) {

		// 2월 31일은 못하도록 윤년, 평년 계산
		// isLeafYear(); , 평년인지 윤년
		// 일계산

		// 951123
		int year = Integer.parseInt(birth.substring(0, 2));
		int month = Integer.parseInt(birth.substring(2, 4)); // "01" -> 1, "12" -> 12
		// int month2 = Integer.parseInt(birth.substring(3,4));
		int day = Integer.parseInt(birth.substring(4, 6));

		// 일은 1 ~ 31
		if (day < 0 || day > 31) {
			System.out.println("  !알림 : 일을 잘못 입력하셨습니다.");
			System.out.println(day);
			return true;
		}

		// 달은 01 ~ 12
		if (month < 0 || month > 12) {
			System.out.println("  !알림 : 월을 잘못 입력하셨습니다.");
			return true;
		}

		// 2월 31일은 못하도록 윤년, 평년 계산
		// 해당 년과 월의 마지막 일을 알아내는 메소드
		// System.out.println(getLastDay(year, month));
		// 해당 년도가 평년인지 윤년인지 알아내는 메소드 반환값 boolean
		// System.out.println(isLeafYear(year));

		if ((isLeafYear(1900 + year) && day > 29) || (!isLeafYear(1900 + year) && day > 28)) {
			System.out.println("  !알림 : 일을 잘못 입력하셨습니다.");
			return true;
		}

		return false;

	}// userBirthCheck

	// 전화번호 유효성 검사
	private boolean userTelCheck(String tel) {

		// 하이픈일때만 입력을 받는다
		// 전화번호의 앞자리가 3자리 또는 4자리일때 상관없이 입력받는다.
		String regex = "^\\d{3}-\\d{3,4}-\\d{4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(tel);

		if (!m.find()) {
			System.out.println("  !알림 : 형식에 맞게 입력해주세요.\n         ex) 010-1234-5678");
			return true;
		}

		return false;

	}// userTelCheck

	// 아이디 찾기 화면
	private void findIDScreen() {

		String name, birth;

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                  [아이디찾기]                 ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.print("  이름 : ");
		name = scan.nextLine();
		System.out.print("  생년월일 : ");
		birth = scan.nextLine();
		System.out.println();
		
		if (!findID(name, birth)) {
			System.out.println("  등록되지 않은 회원입니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		}

	}// findIDScreen

	// 아이디 찾기
	private boolean findID(String name, String birth) {

		for (UserClass user : ReadFile.users) {
			if (user.getName().equals(name) && user.getBirth().equals(birth)) {
				System.out.println("  " + name + "님의 아이디는 '" + user.getId() + "' 입니다.");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
								return true;
			}
		}

		return false;

	}// findID

	// 비밀번호 찾기 화면
	public void findPasswordScreen() {
		String id, tel;

		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                 [비밀번호찾기]                ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		
		System.out.print("아이디 : ");
		id = scan.nextLine();
		System.out.print("전화번호 : ");
		tel = scan.nextLine();
		System.out.println();

		if (!findPassword(id, tel)) {
			System.out.println("등록되지 않은 회원입니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		}

	}// findPasswordScreen

	// 비밀번호 찾기
	public boolean findPassword(String id, String tel) {

		for (UserClass user : ReadFile.users) {
			if (user.getId().equals(id) && user.getPhone().equals(tel)) {
				System.out.println("  " + user.getName() + "님의 비밀번호는 '" + user.getPassword() + "' 입니다.");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				return true;
			}
		}

		return false;

	}// findPassword

	// 해당 년과 월의 마지막 일
	public static int getLastDay(int year, int month) {

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;

		case 4:
		case 6:
		case 9:
		case 11:
			return 30;

		case 2: // 윤년

			// 메소드 이름 : is~()
			// 어떤 상태가 맞는지 틀린지 확인하는 메소드에 잘 붙임
			// 대부분이 boolean값을 리턴함
			return isLeafYear(year) ? 29 : 28;

		}
		return 0;

	} // getLastDay

	// 해당 년도가 평년인지 윤년인지 알아내는 메소드
	public static boolean isLeafYear(int year) {

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	private void blackUserWriter(String blackUser) {
		try {
			
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(Path.BLACKLIST_FILE_PATH, true));
			writer.write(blackUser);
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Login.blackUser() : " + e.toString());
		}
		
	}
	
	public void userWriter(String user) {

		try {

			BufferedWriter writer = new BufferedWriter(
					new FileWriter(Path.USER_FILE_PATH, true));
			writer.write(user);
			writer.close();

		} catch (Exception e) {
			System.out.println("Login.userWriter() : " + e.toString());
		}

	}
	
	void logoutScreen() {
		mainScreen();
	}// logoutScreen

}
