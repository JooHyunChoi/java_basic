package test.scott;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.JDBCUtil;

public class test02 {

	public static void main(String[] args) {
		
		String sql = "select deptno , round(avg(sal),2) , count(*)\r\n" + 
				"from emp\r\n" + 
				"group by deptno";
		Connection conn = null;		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) { //4. 결과값 처리
				System.out.print(rs.getString(1)+"      ");
				System.out.print(rs.getString(2)+"  ");
				System.out.print(rs.getString(3)+"  ");
				System.out.println();	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		
		System.out.println("** end **");
	}

}
