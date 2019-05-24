package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO {
	
	
	//select * from book;
	public List<BookVO> bookList(){
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";
		
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookVO book = new BookVO();
				book.setTitle(rs.getString("title"));
				book.setBookno(rs.getInt("bookno"));
				book.setPrice(rs.getInt("price"));
				book.setAuthor(rs.getString("author"));
				book.setAuthor(rs.getString("pubdate"));
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return list;
	}
	
	public int addBook(BookVO vo) {
		
		String sql = "insert into book(bookno,title,price)\r\n" + 
				"values((select nvl(max(bookno),0)+1 from book) ,?,?)";
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setInt(2,vo.getPrice());
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		
		return 1;
	}
	
	
}
