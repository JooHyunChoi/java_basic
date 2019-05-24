package vo;

public class BookVO {
	int bookno;
	String author;
	String title;
	int price;
	String pubdate;
	
	
	public BookVO() {
		super();
	}
	
	public BookVO(int bookno, String author, String title, int price, String pubdate) {
		super();
		this.bookno = bookno;
		this.author = author;
		this.title = title;
		this.price = price;
		this.pubdate = pubdate;
	}

	public BookVO(String author, String title, int price) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
	}

	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	@Override
	public String toString() {
		return "Book [bookno=" + bookno + ", author=" + author + ", title=" + title + ", price=" + price + ", pubdate="
				+ pubdate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + bookno;
		result = prime * result + price;
		result = prime * result + ((pubdate == null) ? 0 : pubdate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVO other = (BookVO) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookno != other.bookno)
			return false;
		if (price != other.price)
			return false;
		if (pubdate == null) {
			if (other.pubdate != null)
				return false;
		} else if (!pubdate.equals(other.pubdate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
