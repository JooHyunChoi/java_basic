package test.scott;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JDBCUtil;

public class test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sname = JOptionPane.showInputDialog("검색할 사원의 이름을 입력하세요");
		//String sql = "select * from EMP where lower(ename) like '%'||?||'%'";
		String sql = "select * from EMP where lower(ename) like ?";
		//?가 들어가는 애들은 preparedStatement로 써야함 보안적으로 좋음
		
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
			ps.setString(1, "%"+sname.toLowerCase()+"%");
			// exe
			rs = ps.executeQuery();
			// result handling
			while(rs.next()) {
				System.out.print(rs.getString("ename") + "  ");
				System.out.print(rs.getString("deptno") + "  ");
				System.out.print(rs.getString("job") + "  ");
				System.out.print(rs.getDate("hiredate") + "  ");
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
