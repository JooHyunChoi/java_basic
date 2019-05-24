package test.scott;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JDBCUtil;

public class test07_select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "select * from book";
		
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
			// exe
			//row = ps.executeUpdate();
			rs = ps.executeQuery();
			// result handling
			while(rs.next()) {
				System.out.print(rs.getString("bookno") + "  ");
				System.out.print(rs.getString("title") + "  ");
				System.out.print(rs.getString("author") + "  ");
				System.out.print(rs.getString("price") + "  ");
				System.out.print(rs.getDate("pubdate") + "  ");
				System.out.println();
			}
			
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
