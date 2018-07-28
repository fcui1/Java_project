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
public class PART2B {
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

			  topNames2017.sort((String x, String y) -> (x.substring(0, 1).toUpperCase() + x.substring(1))  //compare two string
			    .compareTo(y.substring(0, 1).toUpperCase() + y.substring(1)));

			  for (int i = 0; i < topNames2017.size(); i++) {
			   topNames2017.set(i, topNames2017.get(i).substring(0, 1).toUpperCase() + topNames2017.get(i).substring(1));  //set(index,value) 
			  }

			  topNames2017.forEach(System.out::println);

			 }
			
}

