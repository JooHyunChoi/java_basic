package app;

public class Dept {
	String dname;
	String loc;
	int deptno;
	
	public Dept(String dname, String loc, int deptno) {
		super();
		this.dname = dname;
		this.loc = loc;
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "Dept [dname=" + dname + ", loc=" + loc + ", deptno=" + deptno + "]";
	}

	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

}
