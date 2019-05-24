package day09.hw;

import java.io.Serializable;

public class Book extends Object implements Serializable{
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
	
	
}

