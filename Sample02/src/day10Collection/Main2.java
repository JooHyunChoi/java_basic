package day10Collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Main2 {
	public static void main(String args[]) {
		//List<Book> list = new ArrayList<Book>();
		List<Book> list = new Vector<Book>();
		list.add(new Book("java" , 900));
		list.add(new Book("C++" , 700));
		list.add(new Book("Python" , 1300));
		list.add(new Book("Swift" , 500));
		list.add(new Book("java" , 900));
		
		
		//System.out.println(list);
		//Collections.sort(list);
		
		//System.out.println(list);
		
		
		//for(int i=0;i<list.size();i++) {
		//	System.out.println(list.get(i));
		//}
		
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			if(book.getPrice() > 1000) {
				it.remove();
			}
		}
		System.out.println(list);
	}
}
class Book implements Serializable,Comparable<Book>{
	/**
	 * Serializable 직렬화 가능 직렬화 불가능 이렇게 있음
	 * 이걸 하지 않으면 저장도 안되고 스트림을 통과하지도 못함
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mTitle;
	private int mPrice;
	
	Book(String title , int price){
		mTitle = title;
		mPrice = price;
	}
	Book()
	{
		
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean flag =false;
		if(obj != null && obj instanceof Book) {
			Book temp = (Book)obj;
			if(mTitle.equals(temp.mTitle) && mPrice == temp.mPrice) {
				flag = true;
			}
		}
		
		return flag;
	}
	@Override
	public String toString() {
		return "Book [mTitle=" + mTitle + ", mPrice=" + mPrice + "]";
	}
	public void printBookInfo() {
		System.out.println("Title : "+mTitle);
		System.out.println("Price : "+mPrice);
	}
	
	public int getPrice() {
		return mPrice;
	}
	public void setPrice(int price) {
		if(price>0) {
			mPrice = price;
		}
		
	}
	public String getTitle() {
		return mTitle;
	}
	public void setTitle(String title) {
		if(title != null && title.length()>0) {
			mTitle = title;
		}
		
	}
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		
		return mPrice-o.mPrice;
		//return mTitle.compareTo(o.mTitle);
	}
	
	
}















