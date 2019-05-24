package test.scott;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JDBCUtil;

public class test04_insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "insert into book(bookno,title,price)\r\n" + 
				"values((select nvl(max(bookno),0)+1 from book) ,?,?)";
		
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			st = conn.createStatement();
			ps = conn.prepareStatement(sql);
			//? setting
			String title = JOptionPane.showInputDialog("제목을 입력하세요");
			String price = JOptionPane.showInputDialog("가격을 입력하세요");
			ps.setString(1, title);
			ps.setInt(2, Integer.parseInt(price));
			// exe
			row = ps.executeUpdate();
			// result handling
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, st, rs);
		}
	}

}
