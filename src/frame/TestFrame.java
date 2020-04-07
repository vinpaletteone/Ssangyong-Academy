package frame;

import java.io.FileReader;
import java.util.Scanner;

import data.Path;
import data.ReadFile;

public class TestFrame {

	public static void main(String[] args) {

		// 얇은 선
		System.out.println("┌─────────────────────────────┐");
		System.out.println("│                             │");
		System.out.println("┝━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┥");
		System.out.println("├─────────────────────────────┤");
		System.out.println("└─────────────────────────────┘");

		// 굵은 선
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                             ┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┠─────────────────────────────┨");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

//		System.out.println(padRight("padTe안녕st", 20) + "*");
//		System.out.println(padLeft("padTest", 20) + "*");

		// test.java
		// ProductSales ps = new ProductSales();
		// System.out.println(ps.totalSum());
		// SalesManagement sm = new SalesManagement();
		// sm.productSale(false);
		// sm.daySale();
		// sm.monthSale();
		// sm.productSale();
		// sm.daySaleWrite();
		// 영어 숫자 특수문자 콘솔에 길이 맞춰 출력하기
		String eng1 = "베스트셀러 책제목의 비밀 BEST!!!! 7";
		String eng2 = "나미야 잡화점의 기적";
		String eng3 = "PHOTOSHOP CS3 핵심 활용 비법 400";
		System.out.println(eng1);
		System.out.println(eng2);
		System.out.println(eng3);
		System.out.println();
		int a = 50; // %30d -> %ad
		a = checkTtitle(eng1, a);
		System.out.printf("%-" + a + "s%-10s\n", eng1, "aaa");
		a = 50;
		a = checkTtitle(eng2, a);
		System.out.printf("%-5s     %-" + a + "s%-10s\n", "bbb", eng2, "bbb");
		a = 50;
		a = checkTtitle(eng3, a);
		System.out.printf("%-" + a + "s%-10s\n", eng3, "ccc");

		ReadFile r = new ReadFile();
		r.init();

		String lastNo = ReadFile.books.get(ReadFile.books.size() - 1).getBookNo();
		System.out.println(lastNo);


	}

//	public static String padRight(String s, int n) {
//		return String.format("%1$-" + n + "s", s);
//	}
//
//	public static String padLeft(String s, int n) {
//		return String.format("%1$" + n + "s", s);
//	}



	// 한글이 들어있으면 문자열 길이를 줄이기

	private static int checkTtitle(String str, int length) {
		int result = length;
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			if (c1 >= '가' && c1 <= '힣') {
				result--;
			}
		}
		return result;
	}

}
