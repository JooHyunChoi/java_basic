package day10_1;

import day10.MoneyException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a2 = null;
		try {
			a2 = new Account ("000" ,-500);
		} catch (MoneyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a2);
	}

}

