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
import java.util.*;

import java.io.*;
public class FINALGAME {

	static String[] words = {"write","yellow","purple", "blue","programming"};  //create a lot of string words
	
	static String random;
	 public static void main(String[] args) {
		 
		 Scanner input = new Scanner(System.in); //input a chara
		 String choice = "y";
		 int CHOICE;
		 try {
			 System.out.print("Hangman Game\n\n" );
			 System.out.print("Press 1 to run game with some random words\n\n" );
			 System.out.print("Press 2 to run game by reading the word from the text file\n\n" );
			 System.out.print("Choice:" );
			 CHOICE= input.nextInt();
			 if(CHOICE<1||CHOICE>2) {
				 System.out.print("Wrong number" );
			 }
			 System.out.print("\n");
		    switch(CHOICE)	{ 
		        case 1: 
		     while(choice.charAt(0) == 'y') {
			 //get a randam char word 
			 //char[] word = OneWord();
			 random = words[(int)(Math.random()*words.length)];
			 //put the words in a hidden area one by one 
			 char[] hidden_words = new char[random.length()];
			
			 for (int i = 0; i < hidden_words.length; i++) {
				 hidden_words[i] =random.charAt(i);
				}
			 
			 char[] STAR = new char[hidden_words.length];
			 fill(STAR);
			 //guess a word 
			 int lose_time = 0;
			do {
				char guess_word = Guess(STAR);
			      if (!isCorrect(hidden_words, STAR, guess_word)) {
			    	  lose_time++;
			      }
			}while(!Finish_game(STAR));
			
			System.out.print("The word is  " );
			System.out.print(hidden_words);
			System.out.println(" You has missed " + lose_time + " times");
			System.out.println("Do you want to guess another word? Enter y or n>");
			choice = input.next();
		 }
		       
		          if(choice.equals("n")) {
		        	  System.out.print("Game over  " );
		          }else {
		        	  System.out.print("Wrong   Try again" );
		          }
		          break;
		case 2:    
			
			
			while(choice.charAt(0) == 'y') {                
				File file = openFile();
				ArrayList<String> words = new ArrayList<>();
				Scanner Fileinput = new Scanner(file);
				while (Fileinput.hasNext()) {
					words.add(Fileinput.next()); 
				}
				 random = words.get((int)(Math.random()*words.size())); 
				 //put the words in a hidden area one by one 
				 char[] hidden_words = random.toCharArray();  
				 char[] STAR = new char[hidden_words.length];
				 fill(STAR);

				 //guess a word 
				 int lose_time = 0;
				do {
					char guess_word = Guess(STAR);
				      if (!isCorrect(hidden_words, STAR, guess_word)) {
				    	  lose_time++;
				      }
				}while(!Finish_game(STAR));
				
					
					System.out.print("The word is  " );
					System.out.print(hidden_words);
					System.out.println(" You has missed " + lose_time + " times");
					System.out.println("Do you want to guess another word? Enter y or n>");
					choice = input.next();          
			}	
					
	     }
		          
	 }catch(Exception e){

			System.out.print("\n\t" + "Wrong Input, Please  Again!");	
		}
						
}
	 
	 public static void fill(char[] list) {
			for (int i = 0; i < list.length; i++) {
				list[i] = '*';
			}
		}
	 
	 public static char Guess(char[] hidden_words){
			Scanner input = new Scanner(System.in);
			System.out.print("Enter a letter in word you guess ");
			System.out.print(hidden_words);
			System.out.print(" > ");
			String word_guess = input.next();
			return word_guess.charAt(0);
		}
	 
	 public static boolean isCorrect(char[] word, char[] hidden, char guess_word) {
		 boolean iscorrect = false;
		 
		 for (int i = 0; i < word.length; i++) {
				 if(word[i] == guess_word) {
					 if(hidden[i]==guess_word) {
						 System.out.println("\t" + guess_word + " is already in the word");
					 }else {
						 hidden[i]=guess_word; 
					 }
					  iscorrect=  true;
				 }
			 }
		 
		  if(!iscorrect) 
			 System.out.println("\t" + guess_word + " is not in the word,Guess another");
		 return iscorrect;
	 }
	 
	
	 public static File openFile() throws FileNotFoundException {
			File file = new File("/Users/fanwenqi/eclipse-workspace/test/workshp2/src/workshp2/hangman.txt");

			if (!file.exists()) {
				System.out.print("File " + file.getName() + " does not exist");
				System.exit(1);
			}
			return file;
		}
	 
		 
	 public static boolean Finish_game(char[] words) {
	 for(int i =0; i<words.length;i++) {
		 if(words[i]== '*') {
			 return false;
		 }
	 }
	  return true;
	 }
}

