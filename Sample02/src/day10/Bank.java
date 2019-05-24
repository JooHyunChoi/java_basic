package day10;

import java.util.ArrayList;

public class Bank {

   ArrayList<Account> mAccountList = new ArrayList<>();
   
   public Bank() {
       Account defaultAcc = new Account(this,"Name" , 0, "000000");
       mAccountList.add(defaultAcc);
   }

   public void printAccList() {
       for(Account a : mAccountList) {
    	   System.out.println(a.makedNo+"번째 계좌번호 : "+a.getmAccountNumber());
    	   }
       

      /*
       * for (int i=0 ; i<mAccountList.size() ; i++) { System.out.println("~~");
       * System.out.println(mAccountList.get(i).getmAccountNumber()); }
       */

      //System.out.println((mAccountList.get(0)).getmName());
   }

   public void enterBankSys(Account acc) {
      mAccountList.add(acc);
   }

   public Account searchAccount(String accountNum) {
      Account findAccount = null;
      for (Account a : mAccountList) {
         if (a.getmAccountNumber() == accountNum) {
            findAccount = a;
            break;
         }
      }
      if (findAccount == null) {
    	  System.out.println("찾는 계좌번호가 없습니다.");
         return mAccountList.get(0);
      } else {
         return findAccount;
      }

   }

}