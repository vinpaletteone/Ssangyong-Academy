package frame;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import data.Path;
import data.ReadFile;

public class Sort {

	static Scanner scan = new Scanner(System.in);
	List<String> sortedArray = new ArrayList<String>();

	public void sortScreen(List<String> searchedArray) {

		AfterUserLogin afterUser = new AfterUserLogin();

		// 정렬
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [정렬하기]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  1. 제목순                                    ┃");
		System.out.println("┃  2. 최신순                                    ┃");
		System.out.println("┃  3. 리뷰순                                    ┃");
		System.out.println("┃  4. 나가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("선택(숫자) : ");
		String sel = scan.nextLine();

		Rental rental = new Rental();

		if (sel.equals("1")) {
			// 제목순으로 정렬
			printSortedArray(titleSort(searchedArray));
			rental.rentalBook(searchedArray);
		} else if (sel.equals("2")) {
			// 최신순으로 정렬
			printSortedArray(dateSort(searchedArray));
			rental.rentalBook(searchedArray);
		} else if (sel.equals("3")) {
			// 리뷰순으로 정렬
			printSortedArray(reviewSort(searchedArray));
			rental.rentalBook(searchedArray);
		} else if (sel.equals("4")) {
			// 도서 대여 화면으로 나가기
			afterUser.afterLoginScreen();
		}

	}// sortScrenn

	// 제목 순으로 정렬
	private List<String> titleSort(List<String> array) {

		// 정렬
		Collections.sort(array, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] o1St = o1.split("■");
				String[] o2St = o2.split("■");
				return o1St[6].compareTo(o2St[6]);
			}
		});

		this.sortedArray.clear();
		for (String line : array) {
			this.sortedArray.add(line);
		}

		return this.sortedArray;
	}

	// 등록날짜 순으로 정렬
	// 거꾸로 정렬
	private List<String> dateSort(List<String> array) {

		// 거꾸로 정렬
		Collections.reverse(array);

		this.sortedArray.clear();
		for (String line : array) {
			this.sortedArray.add(line);
		}

		return this.sortedArray;

	}// dateSort

	// 리뷰 개수로 정렬
	private List<String> reviewSort(List<String> array) {

		// 정렬
		Collections.sort(array, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] o1St = o1.split("■");
				String[] o2St = o2.split("■");
				return o1St[6].compareTo(o2St[6]);
			}
		});

		this.sortedArray.clear();
		for (String line : array) {
			this.sortedArray.add(line);
		}

		return this.sortedArray;

	}

private void printSortedArray(List<String> array) {
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃  [검색 결과]                                                                                                                                                                               ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//		System.out.printf(" ┃  도서번호  제목  저자 출판사 상태 등록날짜 리뷰개수  ┃");
		System.out.printf( "┃  %-6s%-80s%-30s  %-17s  %-10s  %-8s  %-4s  ┃\n", "도서번호", "제목", "저자", "출판사", "상태", "등록날짜", "리뷰개수");
		System.out.println("┠────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┨");

		for (String lines : array) {
			//도서번호 제목 저자 출판사 상태 등록날짜 리뷰개수
			String[] line = lines.split("■");
			
			int titleLength = checkLength(line[1], 80);
			int authorLength = checkLength(line[2], 32);
			int publisherLength = checkLength(line[3], 20);
			
			int stateLength = checkLength(line[4], 12);
			
			
			String printStr = String.format("┃   "
					+ "%s" + "    " 							//도서번호
					+ "%-" + titleLength + "s  "				//제목
					+ "%-" + authorLength + "s  "				//저자
					+ "%-" + publisherLength + "s  "			//출판사
//					+ "%-10s  "									//상태
					+ "%-" + stateLength + "s  "					//상태
					+ "%-12s  "									//등록날짜
					+ "%-8s  ┃\n"									//
					, line[0] //도서번호
					, line[1] //제목
					, line[2] //저자
					, line[3] //출판사
					, line[4] //상태
					, line[5] //등록날짜
					, line[6] //리뷰개수
					
			);
			System.out.print(printStr);
			
		}
		
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		readReview(); //리뷰 보기
		
	}// printSortedArray

	private int checkLength(String str, int length) {
		int result = length;
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			if (c1 >= '가' && c1 <= '힣') {
				result--;
			}
		}
		return result;
	}

	private void readReview() {

		System.out.print("리뷰를 보시겠습니까?(y/n): ");
		String yn = scan.nextLine();
		if (yn.equals("y")) {
			System.out.print("리뷰 보기 (도서번호): ");
			String sel = scan.nextLine();
			
			try {

				FileReader reader = new FileReader(Path.REVIEW_FILE_PATH);

				String temp = "";
				int code = -1;

				while ((code = reader.read()) != -1) {
					temp += (char) code;
				}

				reader.close();

				String[] list = temp.trim().split("===");

				for (String memo : list) {

					String[] lines = memo.trim().split("\r\n");
					String[] subitems = lines[0].split("■");

					if (sel.equals(subitems[2])) {
						System.out.println("----------------------------------------------------");
						System.out.println(memo);
					} else {
						// System.out.println("리뷰가 존재하지 않습니다.");

					}

				}

			} catch (Exception e) {
				System.out.println("Sort.readReview() : " + e.toString());
			}

		} else if (yn.equals("n")) {

		} else {
			System.out.println("잘못입력하셨습니다.");
		}

	}// readReview

}