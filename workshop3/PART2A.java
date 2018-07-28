/**********************************************
Workshop 3
Course:<subject type> - Semester
Last Name:<fengzhi>
First Name:<cui>
ID:<student 142045160>
Section:<section name>
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:<submission date>
**********************************************/

package workshop3;
import java.util.*;
public class PART2A {
	  private static List<String> topNames2017 =  Arrays.asList(
	            "Amelia",
	            "Olivia",
	            "emily",
	            "Isla",
	            "Ava",
	            "oliver",
	            "Jack",
	            "Charlie",
	            "harry",
	            "Jacob",
	            "cuifengzhi" 
	    ); 
      public static void main(String args[]) {
    	  topNames2017.sort((String s,String x) ->(s.substring(0,1).toUpperCase()+x.substring(1))
    			  . compareTo(x.substring(0, 1).toUpperCase() + x.substring(1)));
    	  
    	  for (String str : topNames2017) {
    		  System.out.println(str.toUpperCase().charAt(0)+str.substring(1));
    	  }
      }
      
}
