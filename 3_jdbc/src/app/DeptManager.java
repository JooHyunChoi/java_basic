package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;


public class DeptManager {
	List<Dept> deptlist = new ArrayList<Dept>();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int row = 0;
	String sql = "select * from dept";

	public List<Dept> getDept(){
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dept dept = new Dept(rs.getString("dname"),rs.getString("loc"),rs.getInt("deptno"));
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		
		return deptlist;
	}
	
}
