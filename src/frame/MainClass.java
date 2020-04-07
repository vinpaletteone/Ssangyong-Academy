package frame;

import data.ReadFile;

public class MainClass {
	
	public static void main(String[] args) {
		
		ReadFile readFile = new ReadFile();
		readFile.init();
		
		Login login = new Login();
//		Login2 login = new Login2();
		login.mainScreen();
		
	}//main

}

