package test.scott;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JDBCUtil;

public class test06_update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "update book set price =? , title = ? where bookno =?";
		
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
			String bookno = JOptionPane.showInputDialog("바꾸고 싶은 bookno를 입력하세요");
			String title = JOptionPane.showInputDialog("제목을 입력하세요");
			String price = JOptionPane.showInputDialog("가격을 입력하세요");
			ps.setInt(1, Integer.parseInt(price));
			ps.setString(2, title);
			ps.setInt(3, Integer.parseInt(bookno));
			// exe
			row = ps.executeUpdate();
			// result handling
			System.out.println(row);
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
