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
import java.util.Arrays;
	import java.util.List;

public class Part2  {
	
	 public static void main(String args[]) {
		 
		System.out.println("The Lambda function is: ");
	      //List ->stream ->for each()
	            List<String> ListNames = Arraynames(); //put the name in a string list 
            //substring(0,1) function put the first char to upper case 
            //substring(1) cutting the first letter and save the end of letter
	            
	         //stream() covert  the strings in stream 
ListNames.stream().map(name-> name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase() ) //lambda 
	                    //using map() function to put them in a string apply the
	                //a function to each object to produce another stream to edit their        
	                    .sorted() //sort their 
	                    .forEach(System.out::println); //print the output //method reference 
	        
	    } 

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

	    public static List<String> Arraynames() {
	        return topNames2017;
	    }

	}

