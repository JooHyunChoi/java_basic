package day09.hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileToBookMgr {
	
	private BookMgr bookmgr; 
	
	public FileToBookMgr(BookMgr bm) {
		// TODO Auto-generated constructor stub
		this.bookmgr = bm;
	}
	public void insertToMgr(File f) {
		Scanner sc = null;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String data = sc.nextLine();
				String[] bookdata = data.split(",");
				
				String title = bookdata[0];
				int price = Integer.parseInt(bookdata[1]);		
				Book book = new Book(title , price);
						
				bookmgr.addBook(book);
					
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("bookdata가 없어요");
		} catch(Exception e){
			System.out.println("parsing error");
			
		}finally {
			if(sc!= null) {
				sc.close();
			}
		}
	}
	
}
