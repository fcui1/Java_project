/**********************************************
Workshop 2
Course:<subject type> - Semester
Last Name:<fengzhi>
First Name:<cui>
ID:<student 142045160>
Section:<section name>
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:<submission date>
**********************************************/

package workshp2;
import java.util.Scanner;
public class BANK {
	
    static final int money_loan = 1;  //loan how much money to other banks 
    static final int BANK_ID = 0; //bank number you loan to 
    static double[][][] ArrayBANKS;   //create a bank array//number of banks, bank of ID and balance  
    public static void main(String[] args) {
       try {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of banks: ");
        
        int NUMBER = input.nextInt(); // n = the how many number of banks how many banks five array here 
        System.out.print("Enter minimum limit: ");
        int limit = input.nextInt(); 
        ArrayBANKS = new double[NUMBER][][];//create  banks of array if it has five banks it will have five three-dimensioanl arrarys
        
        for (int i = 0; i < ArrayBANKS.length; i++) {
        	System.out.println("Bank   > Balance > Number of banks Loaned > first Bank ID > Amount > sencound Bank ID > Amount > ...");
            System.out.print("Enter bank Num "+i+" > ");
            double balance = input.nextDouble();  //input the balance
            int numBanks = input.nextInt();  //input the how many loans from this banks 
                 ArrayBANKS[i] = new double[++numBanks][2]; //create a array for the loans of banks, if it has two loaned it will create two bank of lond 
                ArrayBANKS[i][0][0] = balance; // put the banks balance in to three array
                for (int numbank = 1; numbank < ArrayBANKS[i].length; numbank++) { 	//make a loop to put the id and money_loan 
            	   ArrayBANKS[i][numbank][BANK_ID] = input.nextDouble();  //input the id into the array
            	   ArrayBANKS[i][numbank][money_loan] = input.nextDouble();   ///input the money_loan into the array
            	  
            }
            
 }
       //display all the data 
        System.out.printf("%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n",
                "bank # |", "balance |", "Loaned# |", "Bank ID |", "Amounts |", "Bank ID |", "Amounts |");
        for (int i = 0; i < ArrayBANKS.length; i++) {
            System.out.printf("%-7d|%8.2f|%8d|", i, ArrayBANKS[i][0][0], ArrayBANKS[i].length -1);

            for (int j = 1; j < ArrayBANKS[i].length; j++) {
                System.out.printf("%8.0f|%8.2f|", ArrayBANKS[i][j][BANK_ID], ArrayBANKS[i][j][money_loan]);
            }
           System.out.println("");
        }
        
        
        boolean[] Notsafe = SafeBank(ArrayBANKS, limit);//make an array for the bank unsafe
        for (int i = 0; i < Notsafe.length; i++) {
            System.out.println("Bank " + i + " unsafe: " +Notsafe[i] );//pass the function of safebank to this loop to see that which is unsafe when  
        }                                                           //the totoal amount is less than the limit it will unsafe
       }catch(Exception E) {
    	   System.out.print("Put right input  ");
       }
    }

    public static boolean[] SafeBank(double[][][] banks, int limits) {
        boolean[] NotsafeBanks = new boolean[banks.length]; //put the unsate in the array 
        boolean Safe = false;
        double Balance;
        while (!Safe) { 
        	Safe = true;   
            for (int i = 0; i < banks.length; i++) {
            	Balance = banks[i][0][0]; //put the original loand amount id is to 0 
                for (int NumLoanedBanks = 1; NumLoanedBanks < banks[i].length; NumLoanedBanks++) {//how many of loaned of banks 
                    int id = (int)banks[i][NumLoanedBanks][BANK_ID]; //if the bank is unsafe we will get the id of which bank is unsafe to find that which bank has loaned money to these bank
                                                                   //when we caculate we will not include the amount of this id 
                    if (!NotsafeBanks[id])//if it is not unsafety it will be caculate the amount 
                    	Balance += banks[i][NumLoanedBanks][money_loan]; 
                }  //caculate the bank balance to see whether it is safety 
                
                if (Balance < limits && !NotsafeBanks[i]) {   //if the balance is less than the limit it will be unsafe
                	NotsafeBanks[i] = true;
                	Safe = false;  //if it is not saft  less than limit we will change the boolen of issafe to update 
                }
            }
        }
        return NotsafeBanks;
    }

}
