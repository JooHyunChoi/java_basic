package day10;

import java.io.Serializable;
import java.util.Random;

public class Account extends Object implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// 계좌번호 잔고 입금 출금 계좌이체 통장정보출력

   private String mAccountNumber;
   
   private int mBalance;
   String mName;
   Bank bank;
   static int makeCount = 0;
   public int makedNo;
   {
	   ++makeCount;
	   makedNo = makeCount;
   }
   
   public void enterBankSys(Bank a) {
      a.mAccountList.add(this);
   }

   static String AccountNumGenerator() {
      Random rand = new Random();
      String generatedAccountNum = "";

      for (int i = 0; i < 6; i++) {
         String ran = Integer.toString(rand.nextInt(10));
         generatedAccountNum += ran;
      }

      return generatedAccountNum;
   }

   Account(Bank bank, String mName, int mBalance, String accountNum) {
      this.bank = bank;
      this.mName = mName;
      try {
    	  this.setmBalance(mBalance);
      } catch (MoneyException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
      }
      this.mAccountNumber = accountNum;
      this.enterBankSys(this.bank);
   }

   Account(String mName, int mBalance) {
      try {
		this.setmBalance(mBalance);
		} catch (MoneyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      this.setmName(mName);
      
      
      //mAccountNumber = AccountNumGenerator();
      //enterBankSys(this.bank);
   }

   public static void transfer(Account accFrom, Account accTo, int money) {
	   System.out.println("==============계좌이체=============");
	      System.out.println("보내는 돈 : " + money);
	      System.out.println("보내는 사람 : " + accFrom.getmName() + "잔고 : " + accFrom.getmBalance());
	      System.out.println("받는 사람 : " + accTo.getmName() + "잔고 : " + accTo.getmBalance());
      accTo.deposit(accFrom.withdraw(money));
      
      System.out.println("결과 : " + "보내는 사람 잔고 : " + accFrom.getmBalance() + "받는 사람 잔고 : " +accTo.getmBalance());
   }

   public void transfer(int money, Account acc) {
      if (mBalance > money) {
         mBalance -= money;
         acc.deposit(money);
      }

   }

   public void transfer(String accountNum, int money) {
      transfer(this, this.bank.searchAccount(accountNum), money);
   }

   public void printAccountInfo() {
      System.out.println("==============계좌정보 입니다.============");
      System.out.println("예금주 명 : " + mName);
      System.out.println("계좌번호: " + mAccountNumber);
      System.out.println("잔고 : " + mBalance);
   }

   public void deposit(int money) {
      if (money > 0) {
         mBalance += money;
      }

   }

   public int withdraw(int money) {
      if (mBalance > money) {
         mBalance -= money;
         return money;
      }
      System.out.println("잔고 부족입니다.");
      return 0;
   }

   public String getmAccountNumber() {
      return mAccountNumber;
   }

   public void setmAccountNumber(String mAccountNumber) {
      this.mAccountNumber = mAccountNumber;
   }

   public int getmBalance() {
      return mBalance;
   }

   public void setmBalance(int mBalance) throws MoneyException{
       if(mBalance <0) {
    	   throw new MoneyException();
       }
	   
	   this.mBalance = mBalance;
   }

   public String getmName() {
      return mName;
   }

   public void setmName(String mName) {
      this.mName = mName;
   }
   
   @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mBalance;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (mBalance != other.mBalance)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [mAccountNumber=" + mAccountNumber + ", mBalance=" + mBalance + ", getmAccountNumber()="
				+ getmAccountNumber() + ", getmBalance()=" + getmBalance() + ", getmName()=" + getmName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}