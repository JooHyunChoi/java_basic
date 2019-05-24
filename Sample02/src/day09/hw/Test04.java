package day09.hw;

import java.io.File;


public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		File f = new File("c://library/bookdata.txt");
		
		BookMgr bm = new BookMgr();
		FileToBookMgr fb = new FileToBookMgr(bm);
		fb.insertToMgr(f);
		bm.printBookList();
		bm.printTotalPrice();
		
		
		System.out.println("end");
	}

}
