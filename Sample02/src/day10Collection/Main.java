package day10Collection;

public class Main {
	public static void main(String args[]) {
		
		String year = "";
		
		/*Employee<String> emp = new Employee<String>("홍길동", "20190508");
		for (int i=0 ; i<4 ; i++) {
			year += emp.number.charAt(i);
		}
		System.out.println(year);
		System.out.println(emp.number.substring(0,4));
		
		Employee<Integer> emp2 = new Employee<Integer>("홍길동", 20190507);
		System.out.println(emp2);
		Employee emp3 = new Employee("마이콜", "20190505");
		System.out.println(emp3.number instanceof String ? (Employee)emp3 : null);
		Employee emp4 = new Employee("마이콜", 20190504);
		// 타입에 데헤 정의 하지 않으면 Object타입으로 만들어줭~~
		//저 숫자는 object타입으로 관리됨
		System.out.println(emp4);*/
		
		Employee<String, String> emp1 = new Employee<String ,String>("홍길동" , "2019-001");
		Employee emp2 = new Employee("또치" , 20190831);
		System.out.println(emp1);
		System.out.println(emp2);
		
		
		
	}

}
