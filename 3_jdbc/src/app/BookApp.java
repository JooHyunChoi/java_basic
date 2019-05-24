package app;

import java.util.List;

import dao.BookDAO;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		
		
		
		BookVO user = new BookVO("Kim","Title1" , 22225500);
		
		try {
			service.addBook(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("등록되는 값 다시 보셈");
		}
		
		if(service!= null) {
			List<BookVO> list = service.bookList();
			list.forEach(i->System.out.println(i));
		}
		
	}

}
