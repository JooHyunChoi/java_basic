package test.scott;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.BookVO;

public class test08_select_map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "select * from book";
		
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		List<BookVO> books = new ArrayList<BookVO>();
		Map<Integer, BookVO> map = new HashMap<Integer, BookVO>();
		
		
		
		
		
		try {
			conn = JDBCUtil.getConnection();
			st = conn.createStatement();
			ps = conn.prepareStatement(sql);
			//? setting
			// exe
			//row = ps.executeUpdate();
			rs = ps.executeQuery();
			// result handling
			while(rs.next()) {
				//System.out.print(rs.getString("bookno") + "  ");
				//System.out.print(rs.getString("title") + "  ");
				//System.out.print(rs.getString("author") + "  ");
				//System.out.print(rs.getString("price") + "  ");
				//System.out.print(rs.getDate("pubdate") + "  ");
				//System.out.println();
				BookVO book = new BookVO();
				book.setPrice(rs.getInt("price"));
				book.setBookno(rs.getInt("bookno"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setAuthor(rs.getString("pubdate"));
				//System.out.println(book);
				books.add(book);
				map.put(book.getBookno(), book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, st, rs);
		}
		
		for(BookVO b:books) {
			System.out.println(b);
		}
		System.out.println("--------------------------------------------");
		
		books.forEach(i->System.out.println(i));
		
		System.out.println("----------------------map----------------------");
		map.forEach((k,v)->System.out.println(v));
		
	}

}
