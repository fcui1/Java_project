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
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	 public static void main(String[] args) {
		 try {
		  Scanner input = new Scanner(System.in);
		  int NumberofColor = 0;
		  String colour;
		  int num;
		  int[][] COLOURS = new int[6][7];   
		   display(COLOURS);
		  do {
			  NumberofColor++;      //make yellow is 2 and red is 3
		   if (NumberofColor % 2 == 0) {
			   colour = "Yellow";
			   num = 2;
		   } else {
			   colour = "Red";
			   num = 3; 
		   }
		   System.out.print("Drop a " + colour + " disk at column (0–6):");
		   int coloum = input.nextInt();
		   for (int i = COLOURS.length - 1; i >= 0; i--) {  
		   if (COLOURS[i][coloum] == 0) {  //if the value is empty it will have the value of color 
		    	COLOURS[i][coloum] = num; //if it has a value it will reduce one index ( 5,0), (4,0), (5,1)
		         break;
		    }		    
		    if (i == 0)
		    System.out.println(" Please , Try again.");
		   }
		    display(COLOURS);  //display the value 
		 
		  } while (color_check(COLOURS) == false && NumberofColor != 6 * 7);
		   
		  if(color_check(COLOURS)) {
		   System.out.println("The " + colour + " player won");
		    
		  }
		 }catch (InputMismatchException e) {
             System.out.println("Please enter a number.");
        } catch (Exception e) { 
        	 System.out.println("Please enter number from 0-6.");
	   }		 
	}

 public static boolean color_check(int[][] COLOURS) {
		  return   Horzion(COLOURS) ||More_Check (COLOURS) ||Vertically(COLOURS);
 }	 
  public static boolean Horzion(int[][] COLOURS) {               
	        //upper                                              // |Y|Y|Y|Y|Y| | |
                                                                 // | | | | | | | |
                                                                 // | | | | | | | |
        int num = 1;                                             // |R|R|R|R|R|R|
		  // Going through the array horizontally
		  for (int i = 0; i < COLOURS.length; i++) {
		  
		    int Hor = COLOURS[i][0];
		   for (int j = 1; j < COLOURS[i].length; j++) {
		    if (Hor == COLOURS[i][j] && Hor != 0) {
		    	num++;
		    	
		    } else {
		    	Hor = COLOURS[i][j];
		    	num = 1;
		    }
		    if (num == 4) {
		     return true;
		    }
		   }
		  }
		 
		  return false;
		 }
		 
		//check the vertically value whether it is right                   
                                                     // |Y| | | | | | |
                                                     // |Y| | | | | | |
                                                     // |Y| | | | | | |
                                                     // |Y| | | | | |

		 public static boolean Vertically(int[][] COLOURS) {
			  int num = 1;
		  // Going through the array vertically
		  for (int i = 0; i < COLOURS[0].length; i++) {  
		   int vertical = COLOURS[0][i];
		   for (int j = 1; j < COLOURS.length; j++) {
		    if (vertical == COLOURS[j][i] && vertical != 0) {
		    	num++;
		    	
		    } else {
		    	vertical = COLOURS[j][i];
		    	num = 1;
		    }
		 
		    if (num == 4) {
		     return true;
		    }
		   }
		   
		  }
		 
		  return false;
		 
		 }
		 
public static boolean More_Check(int[][] COLOURS) {
		  // From upper right to lower left                        // |Y|R| | | | | |
			                  //(0,0) (1,1) ,(2,2)                //  |R|Y|R| | | | |
			                                                      //  | |R|Y|R| | | |
			//lower   left                                        //  | | |R|Y|R| | |
		
		  for (int i = 0; i < COLOURS.length; i++) {
		   int num = 1;
		    int begin = COLOURS[i][0];
		   for (int j = i+1, k = 1; j < COLOURS.length && k < COLOURS[0].length; j++, k++) {
		    if (begin == COLOURS[j][k] && begin != 0) {
		    	num++;   	
		    } else {
		    	begin = COLOURS[j][k];
		    	num = 1;
		    }
		    if (num == 4) {
		     return true;
		    }
		   }
		   
		  }
		  
		   // upper     right                                   // | | |R|R|Y| | |
                                                                // | | | |R|R|Y| |
		                                                        // | | | | |R|R|Y|
		                                                        // | | | | | |R|R|
	
		  for (int i = 0; i < COLOURS[0].length; i++) {
		   int num = 1;
		    int begin = COLOURS[0][i];
		   for (int j = i+1, k = 1; j < COLOURS[0].length && k < COLOURS.length; j++, k++) {
		    if (begin == COLOURS[k][j] && begin != 0) {
		    	num++;
		    } else {
		    	begin = COLOURS[k][j];
		    	num = 1;
		    }
		    if (num == 4) {
		     return true;
		    }
		   }
		  }
		 
		  // From upper left to lower right                    // | | |Y|Y|R| | |
                                                               // | |Y|Y|R| | | |
                                                               // |Y|Y|R| | | | |
                                                               // |Y|R| | | | | |
		  // left upper
		  for (int i = 0; i < COLOURS[0].length; i++) {
		 
		   int num = 1;
		     int begin = COLOURS[0][i];    
		   for (int j = 1, k = i-1; j < COLOURS.length && k >= 0; j++, k--) {
		    if (begin == COLOURS[j][k] && begin != 0) {
		    	num++;
		    	
		    } else {
		    	begin = COLOURS[j][k];
		    	num = 1;
		    }
		    if (num == 4) {
		     return true;
		    }
		   }
		  }
		  //               right lower                   // | | | | |R|Y| |
                                                         // | | | |R|Y|Y| |
                                                         // | | |R|Y|Y|Y| |
                                                         // | |R|Y|Y|Y| | |
		   
		  for (int i = 0; i < COLOURS.length; i++) {
		     //(0,6), 
		    int num = 1;
		    int begin = COLOURS[i][COLOURS[i].length-1]; //  (0,6),(1,5),(2,4),(3,3),(4,2),(5,1) 
		    
		   for (int j = i+1, k = COLOURS[0].length-2; j < COLOURS.length && k >= 0; j++, k--) {
		      if (begin == COLOURS[j][k] && begin != 0) {    
		      	num++;
		    
		     } else {
		    	begin = COLOURS[j][k];
		    	num = 1;
		     }
		        if (num == 4) {
		        return true;
		       }
		    }
		  }   
		    return false;	 
 }
		 
public static void display(int[][] COLOURS) {
		       char color;
		  for (int i = 0; i < COLOURS.length; i++) {
		   System.out.print("|");
		   for (int j = 0; j < COLOURS[i].length; j++) {
		    if (COLOURS[i][j] == 2) {   
		    	color = 'Y';   
		    } else if (COLOURS[i][j] == 3) {
		    	color = 'R';  //print the colour is yellow or red 
		    } else {
		    	color = ' '; 
		    }	 
		      System.out.print(color + "|");
		   }
		     System.out.println();//print another line 
		  }
		 
		  for (int i = 0; i <= COLOURS.length * 2; i++) {
		   System.out.print("-");
		  }
		  System.out.println();
		 
		 }
}
