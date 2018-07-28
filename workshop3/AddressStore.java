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
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.io.*;

public class AddressStore extends Application {
	final int street = 32; 
	final int name = 32; 
	final int state = 2; 
	final int city = 20; 
	protected int index = 0; 
	final int zip = 5; 
	final int total =91;
	protected ADDRESS pane = new ADDRESS();
	public static void main(String[] args) {
        Application.launch(args); //launch a  application call the main method() 
    }
	@Override 
	public void start(Stage primaryStage) {
		//add function 
		pane.badd.setOnAction(b-> {
				
			try ( //using random file methods 
					RandomAccessFile file = 
						new RandomAccessFile("AddressBook.dat", "rw");
				) {
					file.seek(file.length());
				 	write(file);
				}
				catch (FileNotFoundException ex) {
					System.out.println("error");
					
				}
				catch (IOException ex) {
					System.out.println("error");
				}
				catch (IndexOutOfBoundsException ex) {
					System.out.println("error");
				}
				});
		//first function
		pane.bfirst.setOnAction(b -> {
			try ( 
					RandomAccessFile file = 
						new RandomAccessFile("AddressBook.dat", "rw");
				) {
					if (file.length() > 0) {
						file.seek(0);
						read(file);
						System.out.println("address updateed ");
						index = 1;
					}
					else {
						System.out.println("empty!");
					}
				}
				catch (IOException ex) {
					System.out.println("error");
				}
				
		});
		//next function 
		pane.bnext.setOnAction(b -> {
				
			try ( 
					RandomAccessFile file = 
						new RandomAccessFile("AddressBook.dat", "rw");
				) {
					if (index * total < file.length()) {
						file.seek(index * total);
						read(file);
						index++;
					}
					else {
						System.out.println("finished!");
					}
				}
				catch (IOException ex) {
					System.out.println("error");
				}
				
		});
		//previous functon 
		pane.bprevious.setOnAction(b-> {
				
				try ( // 
						RandomAccessFile file = 
							new RandomAccessFile("AddressBook.dat", "rw");
					) {
						if (index > 1) 
							index--;
						else
							index = 1;
						file.seek((index * total) - total);
						read(file);
						
					}
					catch (IOException ex) {
						
						System.out.println("error");
					}
		});
		//last function 
		pane.blast.setOnAction(b -> {
				
				try ( 
						RandomAccessFile file = 
							new RandomAccessFile("AddressBook.dat", "rw");
					) {
					index = ((int)file.length()) / total;
					file.seek((index * total) - total);
						read(file);
					
					}
					catch (IOException ex) {
						System.out.println("error");
					}
				
		});
		//update function 
		pane.bupdate.setOnAction(b-> {
			try ( 
					RandomAccessFile file = 
						new RandomAccessFile("AddressBook.dat", "rw");
				) {
				file.seek(index * total - total);
				 	write(file);
				}
				catch (FileNotFoundException ex) {
					System.out.println("file error");
				}
				catch (IOException ex) {
					System.out.println("error");
				}
			
		});

		//  a scene and stage
		Scene scene = new Scene(pane, 400, 150);
		primaryStage.setTitle("Address Book"); //  title
		primaryStage.setScene(scene); //  scene in the stage
		primaryStage.show(); // 
	}


	//read from a file 
	private void read(RandomAccessFile file) throws IOException {
		int str;
		byte[] Name = new byte[name];	
		str = file.read(Name);
		pane.tname.setText(new String(Name));

		byte[] Street = new byte[street];	
		str += file.read(Street);
		pane.tstreet.setText(new String(Street));

		byte[] City = new byte[city];	
		str += file.read(City);
		pane.tcity.setText(new String(City));

		byte[] State = new byte[state];	
		str += file.read(State);
		pane.tstate.setText(new String(State));

		byte[] Zip = new byte[zip];	
		str += file.read(Zip);
		pane.tzip.setText(new String(Zip));
	}
	
	//write a file  and save
		private void write(RandomAccessFile file) throws IOException {
			file.write(fixed(pane.tname.getText().getBytes(), name)); 
			file.write(fixed(pane.tstreet.getText().getBytes(), street));
			file.write(fixed(pane.tcity.getText().getBytes(), city));
			file.write(fixed(pane.tstate.getText().getBytes(), state));
			file.write(fixed(pane.tzip.getText().getBytes(), zip));
		}
//we can get a fixed length 
	private byte[] fixed(byte[] pre, int af) {
		byte[] before = new byte[af];
		for (int index = 0; index < pre.length; index++) {
			before[index] = pre[index];
		}
		return before;
	}
}
