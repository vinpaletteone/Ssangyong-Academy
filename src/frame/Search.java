package frame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.BookClass;
import data.ReadFile;

public class Search {
	
	List<String> arraySearchedTitle = new ArrayList<String>();

	Sort sort;
	public Search() {
		sort = new Sort();
	}
	
	static Scanner scan;
	static {
		scan = new Scanner(System.in);
	}
	
	
	//검색 기준 정하기
	public void searchScreen(String sel) {
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   [도서검색]                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");


		if (sel.equals("1")) {
			// 제목 검색
			searchTitle();
		} else if (sel.equals("2")) {
			// 저자 검색
			searchAuthor();
		} else if (sel.equals("3")) {
			// 출판사 검색
			searchPublisher();
		}
	}

	// 제목 검색
	private void searchTitle() {

		String title = "";
		List<String> arraySearchedTitle = new ArrayList<String>();

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("  찾고 싶은 도서 제목의 일부분을 입력하세요.");
		System.out.print("  입력 : ");
		title = scan.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");


	      
	    //검색
		for (BookClass book : ReadFile.books) {
			if (book.getBookTitle().indexOf(title) > -1) { //검색
				arraySearchedTitle.add(String.format("%s■%s■%s■%s■%s■%tF■%d■%d"
						, book.getBookNo()
						, book.getBookTitle()
						, book.getAuthor()
						, book.getPublisher()
						, book.getBookState()
						, book.getInsertDate()
						, book.getReviewCount()
						, book.getPrice()));
			}
		}
		
		
	    // 입력받은 제목을 가지고 정렬함
	    this.sort.sortScreen(arraySearchedTitle); //매개변수로 배열 넣기

	}// searchTitle


	// 저자 검색
	public void searchAuthor() {
		
		
		String author = "";
		List<String> arraySearchedAuthor = new ArrayList<String>();

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("  찾고 싶은 도서 저자의 일부분을 입력하세요.");
		System.out.print("  입력 : ");
		author = scan.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		

	      
	    //검색
		for (BookClass book : ReadFile.books) {
			if (book.getAuthor().indexOf(author) > -1) { //검색
				arraySearchedAuthor.add(String.format("%s■%s■%s■%s■%s■%tF■%d■%d"
						, book.getBookNo()
						, book.getBookTitle()
						, book.getAuthor()
						, book.getPublisher()
						, book.getBookState()
						, book.getInsertDate()
						, book.getReviewCount()
						, book.getPrice()));
			}
		}

		
	    // 입력받은 제목을 가지고 정렬함
	    this.sort.sortScreen(arraySearchedAuthor); //매개변수로 배열 넣기
		
		
	}// searchAuthor


	// 출판사 검색 화면
	public void searchPublisher() {

		String publisher = "";
		List<String> arraySearchedPublisher = new ArrayList<String>();

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("  찾고 싶은 도서 출판사의 일부분을 입력하세요.");
		System.out.print("  입력 : ");
		publisher = scan.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

	      
	      
	    //검색
		for (BookClass book : ReadFile.books) {
			if (book.getPublisher().indexOf(publisher) > -1) { //검색
				arraySearchedPublisher.add(String.format("%s■%s■%s■%s■%s■%tF■%d■%d"
						, book.getBookNo()
						, book.getBookTitle()
						, book.getAuthor()
						, book.getPublisher()
						, book.getBookState()
						, book.getInsertDate()
						, book.getReviewCount()
						, book.getPrice()));
			}
		}

		
	    // 입력받은 제목을 가지고 정렬함
	    this.sort.sortScreen(arraySearchedPublisher); //매개변수로 배열 넣기
		

	}// searchPublisherScreen
	
	

}
