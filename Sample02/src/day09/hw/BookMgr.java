package day09.hw;

//import java.util.ArrayList;

public class BookMgr {
	//ArrayList<Book> mBookList = new ArrayList<>();
	
	private Book[] bookList;
	private int count =0;
	
	public BookMgr()
	{
		bookList = new Book[4];
	}
	
	public void addBook(Book book) {
		if(count == bookList.length) {
			Book[] temp = new Book[bookList.length*2];
			System.arraycopy(bookList, 0, temp, 0, bookList.length);
			bookList = temp;
		}
		for(int i = 0 ; i<count ; i++) {
			if(bookList[i].equals(book)) {
				return;
			}
		}
		bookList[count] = book;
		count++;
	
	}
	
	
	
	
	public boolean exist(Book book) {
		for(Book b: bookList) {
			//System.out.println(book.getTitle());
			//if(book.getTitle() == b.getTitle() && book.getPrice() == b.getPrice()) {
			if(book.equals(b)) {
				return true;
			}
		}
		return false;
	}

	public void printTotalPrice() {
		int sum =0;
		for(int a=0 ; a<count ; a++) {
			sum += bookList[a].getPrice();
			}
		System.out.print("책 총 가격 : ");
		System.out.println(sum);
	}
	
	public void printBookList() {
		System.out.println("=================책 목록===============");
		for(int a=0 ; a<count ; a++) {
			//System.out.println(bookList[a].getTitle());
			System.out.println(bookList[a]); // <- 중요
			}
	}
	/*
	public void addBook(Book book) {
		mBookList.add(book);
		
	}
	
	public void printBookList() {
		System.out.println("=================책 목록===============");
		for(Book b : mBookList) {
			System.out.println(b.getTitle());
			}
	}
	
	public int printTotalPrice() {
		int sum=0;
		for(Book b : mBookList) {
			sum += b.getPrice();
	    	}
		return sum;
	}*/
}
