package test.scott;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("JDBC TEST");
		String sql = "select * from dept";
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "TIGER";
		
		Connection conn = null;		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName(driver); // 드라이버 로딩
			// Class.forname <- 런타임에 메모리 올라감
			conn = DriverManager.getConnection(url, user, password); // 2.connectio to DB
			//System.out.println(conn);
			st = conn.createStatement(); //sql 관리 객체 statement 생성
			rs = st.executeQuery(sql); // 4. sql구문 실행
			while(rs.next()) { //4. 결과값 처리
				/*System.out.print(rs.getString(1)+"  ");
				System.out.print(rs.getString(2)+"  ");
				System.out.print(rs.getString(3)+"  ");
				System.out.println();*/
				System.out.print(rs.getString("deptno")+"  ");
				System.out.print(rs.getString("loc")+"  ");
				System.out.print(rs.getString("dname")+"  ");
				System.out.println();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("jdbc driver 확인 요망.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("** end **");
		
	}

}
