package data;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriterFile {
	
	//대여 목록 파일 다시 쓰기
	public void writeRentalFile() {
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.RENTAL_FILE_PATH));
			for (int i=0; i<ReadFile.rentals.size(); i++) {
				writer.write(String.format("%s■%s■%s■%tF■%tF■%s"
						, ReadFile.rentals.get(i).getRentalNo()
						, ReadFile.rentals.get(i).getUserNo()
						, ReadFile.rentals.get(i).getBookNo()
						, ReadFile.rentals.get(i).getRentalDate()
						, ReadFile.rentals.get(i).getReturnDueDate()	
						, ReadFile.rentals.get(i).getReturnState()));
				writer.newLine();
			}
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.rentalBookFile() : " + e.toString());
		}
	}
	
	//도서 목록 파일 다시 쓰기
	public void writeBookFile() {
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.BOOK_FILE_PATH));
			for (int i=0; i<ReadFile.books.size(); i++) {
				writer.write(String.format("%s■%s■%s■%s■%d■%tF■%s■%d"
						, ReadFile.books.get(i).getBookNo()
						, ReadFile.books.get(i).getBookTitle()
						, ReadFile.books.get(i).getAuthor()
						, ReadFile.books.get(i).getPublisher()
						, ReadFile.books.get(i).getPrice()
						, ReadFile.books.get(i).getInsertDate()
						, ReadFile.books.get(i).getBookState()
						, ReadFile.books.get(i).getReviewCount()));
				writer.newLine();
			}
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.writerBookFile() : " + e.toString());
		}
	}
	
	//회원 정보 파일 다시 쓰기
	public void writeUserFile() {
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.USER_FILE_PATH));
			
			for (int i=0; i<ReadFile.users.size(); i++) {
				writer.write(String.format("%s■%s■%s■%s■%s■%s"
						, ReadFile.users.get(i).getUserNo()
						, ReadFile.users.get(i).getId()
						, ReadFile.users.get(i).getPassword()
						, ReadFile.users.get(i).getName()
						, ReadFile.users.get(i).getBirth()
						, ReadFile.users.get(i).getPhone()
				));
				writer.newLine();
				
			}
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.writerUserFile() : " + e.toString());
		}
	}
	
	//반납 목록 파일 다시 쓰기
	public void writeReturnFile() {
	
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.RETURN_FILE_PATH));
			
			for (int i=0; i<ReadFile.returns.size(); i++) {
				writer.write(String.format("%s■%tF■%s"
						, ReadFile.returns.get(i).getReturnNo()
						, ReadFile.returns.get(i).getReturnDate()
						, ReadFile.returns.get(i).getRentalNo()
						));
				writer.newLine();
			}
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.writerReturnFile() : " + e.toString());
		}
	}//writerReturnFile
	
	//저자 목록 파일 다시 쓰기
	public void writeAuthorFile() {
		
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.AUTHOR_FILE_PATH));
			
			for (int i=0; i<ReadFile.authors.size(); i++) {
				writer.write(String.format("%s■%s"
						, ReadFile.authors.get(i).getBookNo()
						, ReadFile.authors.get(i).getAuthor()
						));
				writer.newLine();
			}
			
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.writerAuthorFile() : " + e.toString());
		}
	}//writerAuthorFile
	
	//출판사 목록 파일 다시 쓰기
	public void writePublisherFile() {
		
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.PUBLISHER_FILE_PATH));
			
			for (int i=0; i<ReadFile.publishers.size(); i++) {
				writer.write(String.format("%s■%s"
						, ReadFile.publishers.get(i).getBookNo()
						, ReadFile.publishers.get(i).getPublisher()));
				writer.newLine();
			}
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.writerPublisherFile() : " + e.toString());
		}
	}//writerPUblisherFile
	
	//연체 목록 파일 다시 쓰기 
	public void writeOverdueFile() {
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.OVERDUE_FILE_PATH));
			
			for (int i=0; i<ReadFile.overdues.size(); i++)	{
				writer.write(String.format("%s■%s■%d■%d"
						, ReadFile.overdues.get(i).getOverdueNo()
						, ReadFile.overdues.get(i).getRentalNo()
						, ReadFile.overdues.get(i).getOverdueDate()
						, ReadFile.overdues.get(i).getOverduePrice()));
				writer.newLine();
			}
			
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.writerOverdueFile() : " + e.toString());
		}
	}
	
	//연장 목록 파일 다시 쓰기
	public void writeExtensionFile() {
		
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.EXTENSION_FILE_PATH));
			
			for (int i=0; i<ReadFile.extensions.size(); i++) {
				writer.write(String.format("%s■%s■%d"
						, ReadFile.extensions.get(i).getExtensionNo()
						, ReadFile.extensions.get(i).getRentalNo()
						, ReadFile.extensions.get(i).getExtensionCount()));
				writer.newLine();
			}
			
			writer.close();
			

		} catch (Exception e) {
			System.out.println("WriterFile.writerExtensionFile() : " + e.toString());
		}
	}//writerExtensionFile
	
	//블랙리스트 목록 파일 다시 쓰기
	public void writeBlackUserFile() {
		
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.BLACKLIST_FILE_PATH));
			for (int i=0; i<ReadFile.blackUsers.size(); i++) {
				writer.write(String.format("%s■%s"
						, ReadFile.blackUsers.get(i).getBlackUserNo()
						, ReadFile.blackUsers.get(i).getUserNo()));
				writer.newLine();
			}
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.writerBlackUserFile() : " + e.toString());
		}
		
	}//writerBlackUserFile
	
	//예약 목록 파일 다시 쓰기
	public void writeReserveFile() {
		
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.RESERVE_FILE_PATH));
			
			for (int i=0; i<ReadFile.reserves.size(); i++) {
				writer.write(String.format("%s■%s■%s"
						, ReadFile.reserves.get(i).getReserveNo()
						, ReadFile.reserves.get(i).getUserNo()
						, ReadFile.reserves.get(i).getBookNo()));
				writer.newLine();
			}
			writer.close();

		} catch (Exception e) {
			System.out.println("WriterFile.writerReserveFile() : " + e.toString());
		}
	}//writerReserveFile
	
	//리뷰 목록 파일 다시 쓰기
//	public void writeReviewFile() {
//		
//		try {
//
//			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.REVIEW_FILE_PATH));
//			
//			for (int i=0; i<ReadFile.reserves.size(); i++) {
//				writer.write(String.format(""
//						, ReadFile.reviews.get(i)));
//			}
//
//		} catch (Exception e) {
//			System.out.println("WriterFile.writeReviewFile() : " + e.toString());
//		}
//	}//writerReviewFile

}
