package day10;



public class Main {
	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
		   /*
	      Bank bank = new Bank();
	      Account a1 = new Account(bank, "Iron Man", 100, "123123");
	      Account a2 = new Account(bank, "Captin America", 30, "321321");

	      a1.printAccountInfo();
	      a2.printAccountInfo();
	   
	       
	      a1.transfer("321321", 20); 
	      a1.printAccountInfo();
	      a2.printAccountInfo();
	      
	      bank.printAccList();*/
	      
		   Bank bank = new Bank();
		   Account a1 = new Account(bank, "Iron Man", 100, "123123");
	     System.out.println(a1);
	      
	     Account a3 = new Account("Iron Man", -100);
	      
	      
	      
	      
	   }
	   
	  

	}