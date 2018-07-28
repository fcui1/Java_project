/**********************************************
Workshop #
Course:<subject type> - Semester
Last Name:<Fengzhi>
First Name:<Cui>
ID:<student 142045160>
Section:<section name>
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:<submission date>
**********************************************/

package workshop4;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class RankingNew {
    
	    public static void main(String[] args) throws FileNotFoundException  {
	    	 Boolean end = false;
	    	 Boolean validGender = false;
	    	 int YEAR = 0;
	    	 char GENDER = 0;
	    	   Scanner scan = new Scanner(System.in);
	    	 Boolean validEnd = false;
	    	 Boolean correctYear = false;
	    	 char running;
	    	   while(end == false) { 
	  //Year   		   
	         try {
	    		do {
	    	         System.out.print("Enter the year: ");
	    	         if (scan.hasNextInt()) {
	    	          	YEAR= scan.nextInt();
	    	          	 if (YEAR >= 2001 && YEAR <= 2010) {     
	                            correctYear = true;
	                             break;
	    	          	 } 
	    	         } else {
	    	          		scan.next();          
		             }
		                System.out.println("Please enter a number between 2001-2010.");
		                 YEAR = 0; 
	    	   } while(correctYear == false);  
	    	} catch (InputMismatchException e) {
		             System.out.println("Please enter a number between 2001-2010.");
		    } catch (Exception e) {
		            e.printStackTrace();
		    }  
		//gender
	    		    try {
		               
		                do {
		                    System.out.print("Enter the gender: ");
		                    GENDER = scan.next().charAt(0);
		                    GENDER = Character.toUpperCase(GENDER); // set input to uppercase
		                    if (Character.compare(GENDER, 'F') == 0 || Character.compare(GENDER, 'M') == 0) {
		                    
		                        scan.nextLine();
		                        validGender = true;
		                        break;
		                    }
		                         System.out.println("Please enter M or F.");
		                } while (validGender == false);
		            } catch (Exception e) {
		                e.printStackTrace();
		            } 
  
	 //Name
	    	         System.out.print("Enter the name: ");
	    	         String NAME = scan.next();
	 //create file 
	    	         File FILE = new File("babynamesranking" + YEAR + ".txt");
	                 if (!FILE.exists()) {
	                     System.out.println("No record for " + YEAR);
	                     System.exit(1);
	                 }
 //create array list               
	     ArrayList<String> array = new ArrayList<>(); //create a arrary list to store  the information 
	    		     boolean Name_exist = true;
	    	             Scanner  output = new Scanner(FILE);   //read information from file    
	    	         while (output.hasNext()) { 
	    	        	  for (int i = 0; i < 5; i++) {
	    	                array.add(i, output.next());//read the information and add it to array
	    	                     //Inserts the specified element at the specified position in this list. 
	    	                     //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	    	                 } 
	    	                	 if (array.get(GetGender(GENDER)).equals(NAME)) {
	    	                         System.out.println(
	    	                             NAME + " is ranked #" + array.get(0) + " in year " + YEAR);   
	    	                             Name_exist = false;
	    	                     }
	    	                     
	    	                     array.clear();        	            	     	                    
	    	         }
	    	          if(Name_exist) {
	    	             System.out.println("The name " + NAME + " is not ranked in year " + YEAR);
	    	           }  //no exist name 
	// inquiry	          
	    	          try {
	  	                do {
	  	                    System.out.print("Enter another inquiry? ");
	  	                  running = scan.next().charAt(0);
	  	                  running = Character.toUpperCase(running); // set input to uppercase
	  	                    if (Character.compare(running, 'Y') == 0 ) {
	  	                        validEnd = true;
	  	                        break;
	  	                    }
	  	                    if (Character.compare(running, 'N') == 0 ) {
	  	                        validEnd = true;
	  	                        end = true;
	  	                        break;
	  	                    }

	  	                    System.out.println("Please enter either Y or N.");
	  	                } while (validEnd == false);
	  	            } catch (Exception e) {
	  	                e.printStackTrace();
	  	            }
	    	          
	    	          
	    	          
	    	   }
	    	   System.out.println("Goodbye!");
	    }
	    
	    public static int GetGender(char gender) {
	         if (Character.compare(gender, 'M') == 0)
	             return 1;
	         else
	             return 3; 
	     }
  } 
	    

	    
