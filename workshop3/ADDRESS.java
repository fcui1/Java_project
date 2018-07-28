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

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class ADDRESS extends BorderPane {
	protected Button bfirst = new Button("First");  //button 
	protected Button bnext = new Button("Next");
	protected Button bprevious = new Button("Previous");
	protected Button blast = new Button("Last");
	protected Button bupdate = new Button("Update");
	private FlowPane paneinfo = new FlowPane(5, 5);
	private HBox buttons = new HBox(5);
	 
	protected TextField tcity = new TextField(); 
	protected TextField tzip = new TextField();     //textfile 
	protected Button badd = new Button("Add");
	protected TextField tname = new TextField(); 
	protected TextField tstreet = new TextField();
	protected TextField tstate = new TextField();

	public ADDRESS() {
		AddressBook();
	}

	private void AddressBook() {
		//make a colunm length 
		tname.setPrefColumnCount(23);
		tstreet.setPrefColumnCount(23);
		tcity.setPrefColumnCount(8);
		tstate.setPrefColumnCount(2);
		tzip.setPrefColumnCount(4);
		
		paneinfo.setPadding(new Insets(10, 10, 0, 10));
		paneinfo.getChildren().addAll(new Label("Name"), tname, 
			new Label("Street"), tstreet, new Label("City   "), tcity,
			new Label("State"), tstate, new Label("Zip"), tzip);
	//make nodes
		setCenter(paneinfo);
		setBottom(buttons);
		//hbox information we can do it 
		buttons.getChildren().addAll(badd, bfirst, 
			bnext, bprevious, blast, bupdate);
		buttons.setAlignment(Pos.CENTER);

		
	}
}