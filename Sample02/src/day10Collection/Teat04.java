package day10Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;

public class Teat04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Book> set = new TreeSet<Book>();
		
		set.add(new Book("java" , 900));
		set.add(new Book("C++" , 700));
		set.add(new Book("Python" , 1300));
		set.add(new Book("Swift" , 500));
		set.add(new Book("java" , 900));
		set.add(new Book("java" , 900));
		
		//System.out.println(set);
		/*
		Set<String> set = new TreeSet<String>();
		
		set.add("Hello9");
		set.add("Hello3");
		set.add("Hello5");
		set.add("Hello9");
		set.add("Hello9");
		set.add("Hello7");
		set.add("Hello1");
		set.add("Hi");
		System.out.println(set);*/
		
		//for(Book b : set) {
		//	System.out.println(b);
		//}

		Iterator<Book> it = set.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			if(book.getPrice() > 1000) {
				it.remove();
			}
		}
		System.out.println(set);
	}

}
