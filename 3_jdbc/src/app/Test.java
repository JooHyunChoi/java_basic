package app;

public class Test {

	public static void main(String[] args) {
		DeptManager dm = new DeptManager();
		
		for(Dept d : dm.getDept()) {
			System.out.println(d);
		}
	}

}
