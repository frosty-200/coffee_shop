package application;
	
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class softwareEngineering extends Application {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/coffee_shop";
	private static final String DB_USER = "newuser";
	private static final String DB_PASSWORD = "Password";
	
	private final static String ADMIN_QUERY = "SELECT * FROM customer";
	private final static String customer_visits = "SELECT * FROM item";
	private final static String insert = "INSERT INTO customer (first_name, last_name, street_address, post_code, town, house_number, visits) VALUES(?,?,?,?,?,?,?)";
	private final static String employee = "SELECT * FROM employee";
	private final static String removeCustomers = "DELETE FROM customer WHERE customer_ID = ?";
	private final static String removeUser = "DELETE FROM employee WHERE employee_ID = ?";
	private final static String addEmployee = "INSERT INTO employee (first_name, last_name, street_address, post_code, house_number) VALUES (?,?,?,?,?)";
	private final static String changePassword = "INSERT INTO login (username, password) VALUES (?,?)";
	private final static String getPassword = "SELECT * FROM login WHERE BINARY username = ?  AND BINARY password = ?";
	private final static String getAdminPassword = "SELECT * FROM adminLogin WHERE BINARY username = ? AND BINARY password = ?";
	private final static String changeVisit = "UPDATE customer SET visits = ? WHERE customer_ID = ?";
	
	private static TableView<searchHandler> table = new TableView<>();
	private static TableView<customerHandler1> adminCustomer = new TableView<>();
	private static TableView<customerHandler3> privateCustomer = new TableView<>();
	private static TableView<employeeHandler> employees = new TableView<>();
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//start page asking for password
		start2(primaryStage);
        
        }	
	
	
	public static void start2(Stage primaryStage) throws Exception {
		//start page asking for password
				
		
		
		        Label user = new Label("USERNAME");
		        user.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		        user.setTextFill(Color.WHITE);
		        user.setTranslateX(180);
		        user.setTranslateY(310);
		        
		        Label password = new Label("PASSWORD");
		        password.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		        password.setTextFill(Color.WHITE);
		        password.setTranslateX(180);
		        password.setTranslateY(390);
		        
		        TextField tf = new TextField();
		        tf.setPromptText("type username...");
		        tf.setPrefSize(300, 50);
		        tf.setTranslateX(320);
		        tf.setTranslateY(300);
		        
		        PasswordField pw = new PasswordField();
		        pw.setPromptText("type password...");
		        pw.setPrefSize(300, 50);
		        pw.setTranslateX(320);
		        pw.setTranslateY(380);
		        
		        Button button = new Button("SUBMIT");
		        button.setPrefSize(130, 60);
		        button.setAlignment(Pos.CENTER);
		        button.setTranslateX(400);
		        button.setTranslateY(450);
		        button.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		        button.setOnAction(e -> {

		        	try {
		        		long startTime = System.currentTimeMillis();
						verify(tf, pw, primaryStage);
						long endTime = System.currentTimeMillis();
						long elapsedTime = endTime - startTime;
						System.out.println("elapsed time to log in is " + elapsedTime+ " in milliseconds");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        	});
		        
//		        GridPane roots = new GridPane(); 
//		        roots.addRow(0, user, tf);
//		        roots.addRow(1, password, pw);
//		        roots.addRow(5, button);
		        
		        Group root = new Group(user, tf,password, pw,button);
		        Scene scene = new Scene(root,1000,1000, Color.rgb(78, 105, 88));
		        primaryStage.setScene(scene);
		        primaryStage.show();
		        primaryStage.setTitle("LOGIN PAGE");
		        
		        }	
	
	
	
	public static void addUser(Stage Primarystage) {
		
		Label fname = new Label("FIRST NAME");
		fname.setTranslateX(200);
		fname.setTranslateY(70);
		fname.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		fname.setTextFill(Color.WHITE);
		
		TextField fname2 = new TextField();
		fname2.setTranslateX(400);
		fname2.setTranslateY(70);
		fname2.setPrefSize(200, 30);
		
		Label lname = new Label("LAST NAME");
		lname.setTranslateX(200);
		lname.setTranslateY(120);
		lname.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		lname.setTextFill(Color.WHITE);
		
		TextField lname2 = new TextField(); 
		lname2.setTranslateX(400);
		lname2.setTranslateY(120);
		lname2.setPrefSize(200, 30);
		
		Label street = new Label("STREET ADDRESS");
		street.setTranslateX(200);
		street.setTranslateY(170);
		street.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		street.setTextFill(Color.WHITE);
		
		TextField street2 = new TextField();
		street2.setTranslateX(400);
		street2.setTranslateY(170);
		street2.setPrefSize(200, 30);
		
		Label postcode = new Label("POSTCODE");
		postcode.setTranslateX(200);
		postcode.setTranslateY(220);
		postcode.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		postcode.setTextFill(Color.WHITE);
		
		TextField postcode2 = new TextField();
		postcode2.setTranslateX(400);
		postcode2.setTranslateY(220);
		postcode2.setPrefSize(200, 30);
		
		Label town = new Label("TOWN");
		town.setTranslateX(200);
		town.setTranslateY(270);
		town.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		town.setTextFill(Color.WHITE);
		
		TextField town2 = new TextField();
		town2.setTranslateX(400);
		town2.setTranslateY(270);
		town2.setPrefSize(200, 30);
		
		Label house_number = new Label("HOUSE NUMBER");
		house_number.setTranslateX(200);
		house_number.setTranslateY(320);
		house_number.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		house_number.setTextFill(Color.WHITE);
		
		TextField house_number2 = new TextField();
		house_number2.setTranslateX(400);
		house_number2.setTranslateY(320);
		house_number2.setPrefSize(200, 30);
		
		Label visits = new Label("VISITS");
		visits.setTranslateX(200);
		visits.setTranslateY(370);
		visits.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		visits.setTextFill(Color.WHITE);
		
		TextField visits2 = new TextField();
		visits2.setTranslateX(400);
		visits2.setTranslateY(370);
		visits2.setPrefSize(200, 30);
		
		Button add = new Button("ADD");
		add.setTranslateX(350);
		add.setTranslateY(500);
		add.setPrefSize(100, 50);
		add.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		
		Button back = new Button("BACK");
		back.setTranslateX(550);
		back.setTranslateY(500);
		back.setPrefSize(100, 50);
		back.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		
		back.setOnAction(event -> {
			try {
				buttons(Primarystage);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	
		
		add.setOnAction(event -> {
			String firstname = fname2.getText().toUpperCase();
			String lastname = lname2.getText().toUpperCase();
			String customerstreet = street2.getText().toUpperCase();
			String customerpostcode = postcode2.getText().toUpperCase();
			String customertown = town2.getText().toUpperCase();
			String hnumber = house_number2.getText().toUpperCase();
			Integer visitNum = Integer.parseInt(visits2.getText().toUpperCase());
			
			
			
			
			
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedstatement = conn.prepareStatement(insert)){
			preparedstatement.setString(1, firstname);
			preparedstatement.setString(2, lastname);
			preparedstatement.setString(3, customerstreet);
			preparedstatement.setString(4, customerpostcode);
			preparedstatement.setString(5, customertown);
			preparedstatement.setString(6, hnumber);
			preparedstatement.setInt(7, visitNum);
			int rowsAffected = preparedstatement.executeUpdate();
			if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                fname2.clear();
        		lname2.clear();
        		street2.clear();
        		postcode2.clear();
        		town2.clear();
        		house_number2.clear();
        		visits2.clear();
                // Optionally, you can clear the text fields after insertion
                
            } else {
                System.out.println("Failed to insert data.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
		
		
		GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, fname, fname2);
        gridPane.addRow(1, lname, lname2);
        gridPane.addRow(2, street, street2);
        gridPane.addRow(3, postcode, postcode2);
        gridPane.addRow(4, town, town2);
        gridPane.addRow(5, house_number, house_number2);
        gridPane.addRow(6, visits, visits2);
        gridPane.addRow(7, add,back);
        
        Group root = new Group(fname, fname2,lname, lname2,street, street2,postcode, postcode2,town, town2,house_number, house_number2, visits, visits2,add,back);
		Scene scene = new Scene(root, 1000, 1000, Color.rgb(78, 105, 91));
        Primarystage.setTitle("CUSTOMER CREATION");
        Primarystage.setScene(scene);
        Primarystage.show();
		 
		
		
	}
	
	
	
	public static void addEmployee(Stage Primarystage) throws SQLException {
		
		Label fname = new Label("FIRST NAME");
		fname.setTranslateX(200);
		fname.setTranslateY(70);
		fname.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		fname.setTextFill(Color.WHITE);
		
		TextField fname2 = new TextField();
		fname2.setTranslateX(400);
		fname2.setTranslateY(70);
		fname2.setPrefSize(200, 30);
		
		Label lname = new Label("LAST NAME");
		lname.setTranslateX(200);
		lname.setTranslateY(120);
		lname.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		lname.setTextFill(Color.WHITE);
		
		TextField lname2 = new TextField(); 
		lname2.setTranslateX(400);
		lname2.setTranslateY(120);
		lname2.setPrefSize(200, 30);
		
		Label street = new Label("STREET ADDRESS");
		street.setTranslateX(200);
		street.setTranslateY(170);
		street.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		street.setTextFill(Color.WHITE);
		
		TextField street2 = new TextField();
		street2.setTranslateX(400);
		street2.setTranslateY(170);
		street2.setPrefSize(200, 30);
		
		Label postcode = new Label("POSTCODE");
		postcode.setTranslateX(200);
		postcode.setTranslateY(220);
		postcode.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		postcode.setTextFill(Color.WHITE);
		
		TextField postcode2 = new TextField();
		postcode2.setTranslateX(400);
		postcode2.setTranslateY(220);
		postcode2.setPrefSize(200, 30);
		

		Label house_number = new Label("HOUSE NUMBER");
		house_number.setTranslateX(200);
		house_number.setTranslateY(270);
		house_number.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		house_number.setTextFill(Color.WHITE);
		
		TextField house_number2 = new TextField();
		house_number2.setTranslateX(400);
		house_number2.setTranslateY(270);
		house_number2.setPrefSize(200, 30);
		
		Button add = new Button("ADD");
		add.setTranslateX(430);
		add.setTranslateY(350);
		add.setPrefSize(100, 40);
		add.setFont(Font.font("Tahoma", FontWeight.BOLD,15));
		
		Button passwords = new Button("CHANGE PASSWORD");
		passwords.setTranslateX(580);
		passwords.setTranslateY(350);
		passwords.setOnAction(e -> userLogin(Primarystage));
		passwords.setPrefSize(200, 40);
		passwords.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		
		Button back = new Button("BACK");
		back.setTranslateX(280);
		back.setTranslateY(350);
		back.setPrefSize(100, 40);
		back.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		
		
		back.setOnAction(event -> {
			adminChoice(Primarystage);
		});
		
		add.setOnAction(event -> {
			String firstname = fname2.getText().toUpperCase();
			String lastname = lname2.getText().toUpperCase();
			String customerstreet = street2.getText().toUpperCase();
			String customerpostcode = postcode2.getText().toUpperCase();
			Integer hnumber = Integer.parseInt(house_number2.getText().toUpperCase());
			
			
			
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedstatement = conn.prepareStatement(addEmployee)){
			preparedstatement.setString(1, firstname);
			preparedstatement.setString(2, lastname);
			preparedstatement.setString(3, customerstreet);
			preparedstatement.setString(4, customerpostcode);
			preparedstatement.setInt(5, hnumber);
			int rowsAffected = preparedstatement.executeUpdate();
			if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                fname2.clear();
        		lname2.clear();
        		street2.clear();
        		postcode2.clear();
        		house_number2.clear();
                // Optionally, you can clear the text fields after insertion
                
            } else {
                System.out.println("Failed to insert data.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
		
		
    
        Group root = new Group(fname, fname2, lname, lname2, street, street2, postcode, postcode2, house_number, house_number2, add, back, passwords);
		Scene scene = new Scene(root, 1000, 1000, Color.rgb(49, 101, 23));
        Primarystage.setTitle("ADD EMPLOYEE");
        Primarystage.setScene(scene);
        Primarystage.show();
		 
		
		
	}
	
	
	public static void removeUser(Stage primaryStage) {
		
		Label ID = new Label("CUSTOMER ID");
		ID.setTranslateX(230);
		ID.setTranslateY(100);
		ID.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		TextField IDS = new TextField();
		IDS.setTranslateX(400);
		IDS.setTranslateY(100);
		IDS.setPrefSize(200, 60);
		
		Button back = new Button("BACK");
		back.setTranslateX(400);
		back.setTranslateY(180);
		back.setPrefSize(100, 40);
		back.setOnAction(e-> adminChoice(primaryStage));
		
		Button remove = new Button("REMOVE");
		remove.setTranslateX(500);
		remove.setTranslateY(180);
		remove.setPrefSize(100, 40);
		
		remove.setOnAction(e-> {
			String I_D = IDS.getText().toUpperCase();
			
			try (Connection connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					PreparedStatement preparedstatement = connect.prepareStatement(removeCustomers)){
				preparedstatement.setString(1, I_D);
				int rowsAffected = preparedstatement.executeUpdate();
				if (rowsAffected > 0) {
	                System.out.println("Data removed successfully!");
	                IDS.clear();
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
		
//		GridPane gridPane = new GridPane();
//        gridPane.setPadding(new Insets(10));
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//        gridPane.addRow(0, ID, IDS);
//        gridPane.addRow(1, remove, back);
		
		Group root = new Group(ID, IDS, back, remove);
		Scene scene = new Scene(root, 1000, 1000, Color.rgb(135, 110, 28));
        primaryStage.setTitle("REMOVE USER");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
		
	
	public static void removeEmployee(Stage primaryStage) {
		Label ID = new Label("EMPLOYEE ID");
		ID.setTranslateX(230);
		ID.setTranslateY(410);
//		ID.setPrefSize(100, 40);
		ID.setTextFill(Color.WHITE);
		ID.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		
		TextField IDname = new TextField();
		IDname.setTranslateX(400);
		IDname.setTranslateY(400);
		IDname.setPrefSize(200, 60);
		
		
		Button back = new Button("BACK");
		back.setTranslateX(400);
		back.setTranslateY(500);
		back.setPrefSize(100, 40);
		back.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		back.setOnAction(e-> adminChoice(primaryStage));
		
		
		Button remove = new Button("REMOVE");
		remove.setTranslateX(505);
		remove.setTranslateY(500);
		remove.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		remove.setPrefSize(100, 40);
		
		remove.setOnAction(e-> {
			String IDS = IDname.getText().toUpperCase();
			
			try (Connection connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					PreparedStatement preparedstatement = connect.prepareStatement(removeUser)){
				preparedstatement.setString(1, IDS);
				int rowsAffected = preparedstatement.executeUpdate();
				if (rowsAffected > 0) {
	                System.out.println("Data removed successfully!");
	                IDname.clear();
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
		
//		GridPane gridPane = new GridPane();
//        gridPane.setPadding(new Insets(10));
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//        gridPane.addRow(0, ID, IDname);
//        gridPane.add(remove, 7, 2);
//        gridPane.add(back, 7, 3);
        Group root = new Group(ID, IDname, back, remove);
		Scene scene = new Scene(root, 1000, 1000, Color.rgb(87, 80, 54));
        primaryStage.setTitle("MySQL Data Insertion");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	
	
	public static void verify (TextField tf, PasswordField pw, Stage primaryStage) throws SQLException {
		
		if (tf.getText().isEmpty()) {
			alert(Alert.AlertType.ERROR, "FORM ERROR",
					"FIELD 1 EMPTY");
			return;
		}
		if (pw.getText().isEmpty()) {
			alert(Alert.AlertType.ERROR, "FORM ERROR",
					"FIELD EMPTY");
			return;
		}
		
		
		if (authenticateUser(tf, pw)) {
			infoBox("LOGIN SUCCESSFUL", null, "SUCCESS");
			buttons(primaryStage);
			//fetchUserInfo(primaryStage, user, password);
		}
		else {
			infoBox("PLEASE ENTER CORRECT DETAILS", null, "FAILED");
		}
		
	}
	
	
	
	private static boolean authenticateUser(TextField tf, PasswordField pw) throws SQLException {
		String username = tf.getText().toString();
		String password = pw.getText().toString();
		
		try (Connection connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			try (PreparedStatement preparedStatement = connect.prepareStatement(getPassword)){
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				try(ResultSet resultSet = preparedStatement.executeQuery()){
					return resultSet.next();
				}
			}
			
		} catch(SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	
	
    private static void alert (Alert.AlertType alertType, String title, String message) {
	        Alert alert = new Alert(alertType);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.show();
	    }
	    
	
	    
	public static void infoBox(String infoMessage, String headerText, String title){
	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setContentText(infoMessage);
	        alert.setTitle(title);
	        alert.setHeaderText(headerText);
	        alert.showAndWait();
	    }
    

	   
	public static void buttons(Stage primaryStage) throws SQLException {
	      //Creating a Button as a main page to navigate around menus
	      Button button = new Button();
	      Button button2 = new Button();
	      Button button4 = new Button();
	      Button button5 = new Button();
	      Button button6 = new Button();
	      //Setting text to the button
	      button.setText("ADMIN");
	      button2.setText("CUSTOMER");
	      button4.setText("ITEMS");
	      button5.setText("ADD");
	      button6.setText("LOG OUT");
	      //Setting the location of the button
	      
	      //admin button
	      button.setTranslateX(100);
	      button.setTranslateY(20);
	      button.setPrefSize(800, 130);
	      button.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
	      button.setOnAction(event -> {
			try {
				adminInfo(primaryStage);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	      //customer button
	      button2.setTranslateX(100);
	      button2.setTranslateY(160);
	      button2.setPrefSize(800, 130);
	      button2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
	      button2.setOnAction(event -> {
	    	  try {
				customer(primaryStage);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      });
	      //items
	      button4.setTranslateX(100);
	      button4.setTranslateY(300);
	      button4.setPrefSize(800, 130);
	      button4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
	      button4.setOnAction(e -> 
			{
				items(primaryStage);
			}
		);
	      //add
	      button5.setTranslateX(100);
	      button5.setTranslateY(440);
	      button5.setPrefSize(800, 130);
	      button5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
	      button5.setOnAction(e -> 
	    	 addUser(primaryStage)
	      );
	      //logout
	      button6.setTranslateX(100);
	      button6.setTranslateY(580);
	      button6.setPrefSize(800, 130);
	      button6.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
	      button6.setOnAction(e -> {
			try {
				start2(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	      
	      Group root = new Group(button, button2,button4, button5, button6);
	      Scene scene = new Scene(root, 1000, 1000, Color.rgb(73, 140, 138));

		  primaryStage.setScene(scene);
		  primaryStage.show();
		  primaryStage.setTitle("");
	      
	}
	 
	
	
	 
	public static void items(Stage PrimaryStage) {

		   
		   Integer item_ID = null;
		   String naming = null;
		   Double cost = null;
		   String description = null;
		     
		   
		   Scene scene = new Scene(new Group(), Color.rgb(158, 108, 52));
		   PrimaryStage.setTitle("ITEMS");
	       PrimaryStage.setHeight(1000);
	       PrimaryStage.setWidth(1000);
	       final Label label = new Label("ITEM LIST");
	       label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
	       Button back = new Button("BACK");
	       back.setTranslateX(200);
	       back.setTranslateY(500);
	       back.setPrefSize(150, 60);
	       back.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
	       back.setOnAction(e -> {
			try {
				buttons(PrimaryStage);
				table.getItems().clear();
				table.getColumns().clear();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			});
	       
	       table.setEditable(true);
	       table.setMinWidth(600);
	       
			TableColumn<searchHandler, Integer> itemsId = new TableColumn<>("item_ID");
			itemsId.setCellValueFactory(new PropertyValueFactory<>("itemsId"));
			
			TableColumn<searchHandler, String> itemNaming = new TableColumn<>("itemNaming");
			itemNaming.setCellValueFactory(new PropertyValueFactory<>("itemNaming"));
			
			TableColumn<searchHandler, Double> itemCost = new TableColumn<>("item Cost");
			itemCost.setCellValueFactory(new PropertyValueFactory<>("itemCost"));
			
			TableColumn<searchHandler, String> itemDescription = new TableColumn<>("desc");
			itemDescription.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
			
			table.getColumns().add(itemsId);
			table.getColumns().add(itemNaming);
			table.getColumns().add(itemCost);
			table.getColumns().add(itemDescription);
			table.setTranslateX(200);
			

	       try {
			   Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			   
			   try (PreparedStatement preparedStatement = connection.prepareStatement(customer_visits)){
				   
				   try (ResultSet resultSet = preparedStatement.executeQuery()){
					   
					   while (resultSet.next()) {
						   item_ID = resultSet.getInt("item_ID");
						   naming = resultSet.getString("naming");
						   cost = resultSet.getDouble("cost");
						   description = resultSet.getString("descriptions");
						   System.out.println(item_ID + naming + cost + description);
						   table.getItems().add(new searchHandler(item_ID, naming, cost, description));
						   
					   }
					   
				   }  
				  
			   }
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	        	
	        
	    VBox vbox = new VBox();
		vbox.getChildren().add(back);
		vbox.setSpacing(6);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);
		
		
		
		((Group) scene.getRoot()).getChildren().addAll(vbox);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
	   }
	   
	   
	   
	   
	   public static void customer(Stage PrimaryStage) throws SQLException{
		   	Integer customer_ID = null;
		    String firstName = null;
		    String lastName = null;
		    Integer visits = null;
		  
			
			Label label = new Label("COFFEE SHOP CUSTOMERS");
			label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
			label.setTextFill(Color.WHITE);
			
			
			adminCustomer.setEditable(true);
			
			
			TableColumn<customerHandler1, Integer> customerId = new TableColumn<>("Customer ID");
			customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
			
			TableColumn<customerHandler1, String> cFirstName = new TableColumn<>("First Name");
			cFirstName.setCellValueFactory(new PropertyValueFactory<>("cFirstName"));
			
			TableColumn<customerHandler1, String> cLastName = new TableColumn<>("Last Name");
			cLastName.setCellValueFactory(new PropertyValueFactory<>("cLastName"));
			
			TableColumn<customerHandler1, Integer> numberVisits = new TableColumn<>("visits");
			numberVisits.setCellValueFactory(new PropertyValueFactory<>("numberVisits"));
			
			adminCustomer.getColumns().add(customerId);
			adminCustomer.getColumns().add(cFirstName);
			adminCustomer.getColumns().add(cLastName);
			adminCustomer.getColumns().add(numberVisits);
			adminCustomer.setTranslateX(300);
			adminCustomer.setTranslateY(100);
			
		
			try {
				   Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				   
				   try (PreparedStatement preparedStatement = connection.prepareStatement(ADMIN_QUERY)){
					   
					   try (ResultSet resultSet = preparedStatement.executeQuery()){
						   
						   while (resultSet.next()) {
							   customer_ID = resultSet.getInt("customer_ID");					   
							   firstName = resultSet.getString("first_name");
							   lastName = resultSet.getString("last_name");
							   visits = resultSet.getInt("visits");
//							   System.out.println(customer_ID+ firstName+ lastName +street_address+post_code+ house_number +town +visits);
							   adminCustomer.getItems().add(new customerHandler1(customer_ID, firstName, lastName, visits));
							   
							   
						   }
						   
					   } 
					  
				   }
			   } catch (SQLException e) {
				   e.printStackTrace();
			   }
			Button changeVisit = new Button("CHANGE VISITS");
			changeVisit.setTranslateX(300);
			changeVisit.setTranslateY(500);
			changeVisit.setPrefSize(150, 60);
			changeVisit.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
			changeVisit.setOnAction(e -> {
			visitChange(PrimaryStage);
			adminCustomer.getItems().clear();
			adminCustomer.getColumns().clear();
			});
			
			Button back = new Button("BACK");
			back.setTranslateX(473);
			back.setTranslateY(500);
			back.setPrefSize(150, 60);
			back.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
			back.setOnAction(execute -> {
				try {
					buttons(PrimaryStage);
					adminCustomer.getItems().clear();
					adminCustomer.getColumns().clear();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			VBox vbox = new VBox();
			vbox.getChildren().addAll(back, changeVisit);
			vbox.setSpacing(6);
			vbox.setPadding(new Insets(10, 0, 0, 10));
			vbox.getChildren().addAll(label, adminCustomer);
			
			
			PrimaryStage.setTitle("CUSTOMER");
				
			Group root = new Group(label,back, changeVisit, adminCustomer);
			Scene scene = new Scene(root, 1000,1000,Color.rgb(77, 71, 48));
			PrimaryStage.setScene(scene);
			PrimaryStage.show();
			}
	   
	  
	   
	   public static void visitChange(Stage PrimaryStage) {
		   
		   Button ID = new Button("SUBMIT");
		   ID.setText("SUBMIT");
		   ID.setTranslateX(350);
		   ID.setTranslateY(500);
		   ID.setPrefSize(100, 60);
		   
		   Button back = new Button("BACK");
		   back.setText("BACK");
		   back.setPrefSize(100, 60);
		   back.setTranslateX(500);
		   back.setTranslateY(500);
		   back.setOnAction(e -> {
			try {
				customer(PrimaryStage);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		   
		   Label idLabel = new Label();
		   idLabel.setText("ENTER ID");
		   idLabel.setTranslateX(300);
		   idLabel.setTranslateY(300);
		   idLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		   
		   TextField enterID = new TextField();
		   enterID.setTranslateX(400);
		   enterID.setTranslateY(300);
		   enterID.setPromptText("ENTER ID");
		   enterID.setPrefSize(200, 40);
		   
		   
		   
		   TextField changeNumber = new TextField();
		   changeNumber.setTranslateX(400);
		   changeNumber.setTranslateY(400);
		   changeNumber.setPromptText("VISIT NUMBER");
		   changeNumber.setPrefSize(200, 40);
		   
		  
		   
		   Group root = new Group(ID, idLabel, enterID, changeNumber, back);
		   Scene scene = new Scene(root, 1000, 1000, Color.rgb(73, 140, 138));
		   PrimaryStage.setScene(scene);
		   PrimaryStage.show();
		   
		   ID.setOnAction(e-> {
			   String vis = changeNumber.getText().toString();
			   String id = enterID.getText().toString();
		   try { 
			   Connection connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		   try (PreparedStatement preparedstatement = connect.prepareStatement(changeVisit)){
				   preparedstatement.setString(1, vis);
				   preparedstatement.setString(2, id);
					int rowsAffected = preparedstatement.executeUpdate();
					if (rowsAffected > 0) {
		                System.out.println("Data inserted successfully!");
		                enterID.clear();
		                changeNumber.clear();
		                // Optionally, you can clear the text fields after insertion
		                
		            } else {
		                System.out.println("Failed to insert data.");
		            }
				}
			   
		   }catch (SQLException e1) {
			   e1.printStackTrace();}
		   });}
	   
	   
	   
	   
	   public static void adminCustomer (Stage primarystage) {
			
			
			final Label label = new Label("CUSTOMER TABLE");
			label.setTextFill(Color.WHITE);
			label.setFont(new Font("Arial", 20));
			
			privateCustomer.setEditable(true);
			
			
			TableColumn<customerHandler3, Integer> customerId = new TableColumn<>("Customer ID");
			customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
			
			TableColumn<customerHandler3, String> cFirstName = new TableColumn<>("First Name");
			cFirstName.setCellValueFactory(new PropertyValueFactory<>("cFirstName"));
			
			TableColumn<customerHandler3, String> cLastName = new TableColumn<>("Last Name");
			cLastName.setCellValueFactory(new PropertyValueFactory<>("cLastName"));
			
			TableColumn<customerHandler3, String> cStreetAddress = new TableColumn<>("STREET ADDRESS");
			cStreetAddress.setCellValueFactory(new PropertyValueFactory<>("cStreetAddress"));
			
			TableColumn<customerHandler3, String> pcode = new TableColumn<>("POSTCODE");
			pcode.setCellValueFactory(new PropertyValueFactory<>("pcode"));
			
			TableColumn<customerHandler3, String> cTowns = new TableColumn<>("TOWN");
			cTowns.setCellValueFactory(new PropertyValueFactory<>("cTowns"));
			
			TableColumn<customerHandler3, Integer> hNumber = new TableColumn<>("HOUSE NUMBER");
			hNumber.setCellValueFactory(new PropertyValueFactory<>("hNumber"));
			
			TableColumn<customerHandler3, Integer> numberVisits = new TableColumn<>("VISITS");
			numberVisits.setCellValueFactory(new PropertyValueFactory<>("numberVisits"));
				
			
			privateCustomer.getColumns().add(customerId);
			privateCustomer.getColumns().add(cFirstName);
			privateCustomer.getColumns().add(cLastName);
			privateCustomer.getColumns().add(cStreetAddress);
			privateCustomer.getColumns().add(pcode);
			privateCustomer.getColumns().add(cTowns);
			privateCustomer.getColumns().add(hNumber);
			privateCustomer.getColumns().add(numberVisits);
			privateCustomer.setTranslateX(200);
			privateCustomer.setTranslateY(50);
			
			
			   Integer customerID = null;
			   String firstName = null;
			   String lastName = null;
			   String street_address = null;
			   String post_code = null;
			   String town = null;
			   String house_number = null;
			   Integer visits = null;
			try {
				   Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				   try (PreparedStatement preparedStatment = connection.prepareStatement(ADMIN_QUERY)){
					   try (ResultSet resultSet = preparedStatment.executeQuery()){
						   while (resultSet.next()) {
							   customerID = resultSet.getInt("customer_ID");
							   
							   firstName = resultSet.getString("first_name");
							   
							   lastName = resultSet.getString("last_name");
							   
							   street_address = resultSet.getString("street_address");
							   
							   post_code = resultSet.getString("post_code");
							   
							   town = resultSet.getString("town");
							   
							   house_number = resultSet.getString("house_number");
							   
							   visits = resultSet.getInt("visits");
							   privateCustomer.getItems().add(new customerHandler3(customerID, firstName, lastName, street_address, post_code, town, house_number, visits));
							   
						   }

					   }
				   }
			   } catch (SQLException e) {
				   e.printStackTrace();
			   }

			
			Button backwards = new Button("BACK");
			backwards.setPrefSize(100, 60);
			backwards.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
			backwards.setTranslateX(230);
			backwards.setTranslateY(500);
			backwards.setOnAction(e -> {
				adminChoice(primarystage);
				privateCustomer.getItems().clear();
				privateCustomer.getColumns().clear();
			});
			
			Group root = new Group(backwards,privateCustomer, label);
			Scene scene = new Scene(root, 1000, 1000, Color.rgb(29, 125, 106));
			primarystage.setTitle("");
			primarystage.setScene(scene);

			
			primarystage.show();
			   
			   }
	  
	   
		  
	   
	   public static void adminInfo(Stage primaryStage) throws SQLException {
		    
		    Label user2 = new Label("USERNAME");
	        user2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	        user2.setTranslateX(230);
	        user2.setTranslateY(330);
	        
	        Label passwords = new Label("PASSWORD");
	        passwords.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	        passwords.setTranslateX(230);
	        passwords.setTranslateY(420);
	        
	        TextField tf = new TextField();
	        tf.setPromptText("TYPE USERNAME...");
	        tf.setTranslateX(350);
	        tf.setTranslateY(300);
	        tf.setPrefSize(300, 60);
	        
	        
	        PasswordField passw = new PasswordField();
	        passw.setPromptText("TYPE PASSWORD...");
	        passw.setAlignment(Pos.CENTER);
	        passw.setTranslateX(350);
	        passw.setTranslateY(400);
	        passw.setPrefSize(300, 60);
	        
	        Button button2 = new Button("SUBMIT");
	        button2.setOnAction(e -> {
				try {
					adminVerify(tf, passw, primaryStage);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	        button2.setTranslateX(500);
	        button2.setTranslateY(500);
	        button2.setPrefSize(100, 50);
	        button2.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
	        
	        Button back = new Button("BACK");
	        back.setTranslateX(390);
	        back.setTranslateY(500);
	        back.setPrefSize(100, 50);
	        back.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
	        back.setOnAction(e -> {
				try {
					buttons(primaryStage);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	        
	        	
//	        	 GridPane roots = new GridPane(); 
//	             roots.addRow(0, user2, tf);
//	             roots.addRow(1, passwords, passw);
//	             roots.addRow(4, button2, back);
	             
	             Group roots = new Group(user2, tf, passwords, passw, button2, back);

	             Scene scene = new Scene(roots, 1000, 1000, Color.rgb(71, 108, 88));
	             primaryStage.setScene(scene);
	             primaryStage.show();
	        };
		   
  
		

	   public static void adminChoice(Stage primaryStage) {
		Button choice1 = new Button("VIEW CUSTOMERS");
		choice1.setOnAction(e -> adminCustomer(primaryStage));
		choice1.setTranslateX(100);
		choice1.setTranslateY(20);
		choice1.setPrefSize(800, 130);
		choice1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button choice2 = new Button("VIEW EMPLOYEES");
		choice2.setOnAction(e -> {
			try {
				viewEmployee(primaryStage);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		choice2.setTranslateX(100);
		choice2.setTranslateY(160);
		choice2.setPrefSize(800, 130);
		choice2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button choice3 = new Button("REMOVE CUSTOMER");
		choice3.setOnAction(e -> removeUser(primaryStage));
		choice3.setTranslateX(100);
		choice3.setTranslateY(300);
		choice3.setPrefSize(800, 130);
		choice3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button choice4 = new Button("ADD EMPLOYEE");
		choice4.setOnAction(e -> {
			try {
				addEmployee(primaryStage);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		choice4.setTranslateX(100);
		choice4.setTranslateY(440);
		choice4.setPrefSize(800, 130);
		choice4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button choice5 = new Button("REMOVE EMPLOYEE");
		choice5.setOnAction(e -> removeEmployee(primaryStage));
		choice5.setTranslateX(100);
		choice5.setTranslateY(580);
		choice5.setPrefSize(800, 130);
		choice5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button back = new Button("BACK");
		back.setTranslateX(100);
		back.setTranslateY(715);
		back.setPrefSize(100, 40);
		back.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		back.setOnAction(e-> {
			try {
				buttons(primaryStage);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		  Group root = new Group(choice1, choice2, choice3, choice4,choice5, back);
	      Scene scene = new Scene(root, 1000, 1000, Color.rgb(75, 104, 88));
		  primaryStage.setScene(scene);
		  primaryStage.show();
	}
	   
	   
	
	   public static void viewEmployee(Stage primaryStage) throws SQLException {
			
			final Label label = new Label("COFFEE SHOP EMPLOYEE");
			label.setFont(new Font("Arial", 20));
			employees.setEditable(true);
			employees.setTranslateX(250);
			employees.setTranslateY(90);
			
		
		TableColumn<employeeHandler, Integer> employeeId = new TableColumn<>("employee_ID");
		employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
		
		TableColumn<employeeHandler, String> employeeFirst = new TableColumn<>("first_name");
		employeeFirst.setCellValueFactory(new PropertyValueFactory<>("employeeFirst"));
		
		TableColumn<employeeHandler, String> employeeLast = new TableColumn<>("last_name");
		employeeLast.setCellValueFactory(new PropertyValueFactory<>("employeeLast"));
		
		TableColumn<employeeHandler, String> streetAddress = new TableColumn<>("street_address");
		streetAddress.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
		
		TableColumn<employeeHandler, String> postcode = new TableColumn<>("post_code");
		postcode.setCellValueFactory(new PropertyValueFactory<>("postcode"));
		
		TableColumn<employeeHandler, Integer> houseNum = new TableColumn<>("house_number");
		houseNum.setCellValueFactory(new PropertyValueFactory<>("houseNum"));
		
		
		Integer employee_ID = null;
		String first_name = null;
		String last_name = null;
		String street_address = null;
		String post_code = null;
		String house_number = null;
		
		employees.getColumns().add(employeeId);
		employees.getColumns().add(employeeFirst);
		employees.getColumns().add(employeeLast);
		employees.getColumns().add(streetAddress);
		employees.getColumns().add(postcode);
		employees.getColumns().add(houseNum);

		try {
			   Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			   try (PreparedStatement preparedStatment = connection.prepareStatement(employee)){
				   try (ResultSet resultSet = preparedStatment.executeQuery()){
					   while (resultSet.next()) {
						   employee_ID = resultSet.getInt("employee_ID"); 
						   first_name = resultSet.getString("first_name");
						   last_name = resultSet.getString("last_name");
						   street_address = resultSet.getString("street_address");
						   post_code = resultSet.getString("post_code");
						   house_number = resultSet.getString("house_number");
						   employees.getItems().add(new employeeHandler(employee_ID, first_name, last_name, street_address, post_code, house_number ));
						   }}}
				   } catch (SQLException e) {
					   e.printStackTrace();
				   }
					   
		Button back = new Button("BACK");
		back.setOnAction(execute -> {
			adminChoice(primaryStage);
			employees.getItems().clear();
			employees.getColumns().clear();});
		back.setTranslateX(280);
		back.setTranslateY(500);
		back.setPrefSize(100, 60);
		back.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
			
		
		Group root = new Group(employees, back, label);
		Scene scene = new Scene(root,Color.rgb(81, 162, 159));
		
		primaryStage.setTitle("EMPLOYEES");
		primaryStage.setWidth(1000);
		primaryStage.setHeight(1000);
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	   
	   
	  
	   
	   public static void userLogin(Stage PrimaryStage) {
		   
		   Label ID =  new Label();
		   ID.setText("ID");
		   ID.setTranslateX(300);
		   ID.setTranslateY(200);
		   ID.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		   ID.setTextFill(Color.WHITE);
		   
		   TextField IDfield = new TextField();
		   IDfield.setPromptText("ENTER ID");
		   IDfield.setTranslateX(400);
		   IDfield.setTranslateY(200);
		   
		   Label passwordLabel = new Label("PASSWORD");
		   passwordLabel.setTranslateX(300);
		   passwordLabel.setTranslateY(250);
		   passwordLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		   passwordLabel.setTextFill(Color.WHITE);
		   
		   PasswordField passwords = new PasswordField();
		   passwords.setPromptText("NEW PASSWORD");
		   passwords.setTranslateX(400);
		   passwords.setTranslateY(250);
		   
		   Button back = new Button("BACK");
		   back.setTranslateX(390);
		   back.setTranslateY(300);
		   back.setPrefSize(90, 40);
		   back.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		   back.setOnAction(e -> {
			   try {
				addEmployee(PrimaryStage);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   });
		   
		   Button change = new Button("SUBMIT");
		   change.setTranslateX(490);
		   change.setTranslateY(300);
		   change.setPrefSize(90, 40);
		   change.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		   change.setOnAction(e-> {
		   
		   Integer username = Integer.parseInt(IDfield.getText());
		   String password = passwords.getText();
		   
		   try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					PreparedStatement preparedstatement = conn.prepareStatement(changePassword)){
				preparedstatement.setInt(1, username);
				preparedstatement.setString(2, password);
				int rowsAffected = preparedstatement.executeUpdate();
				if (rowsAffected > 0) {
	                System.out.println("Data inserted successfully!");
	                IDfield.clear();
	                passwords.clear();
	                
	            } else {
	                System.out.println("Failed to insert data.");
	            }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
		  
		   
		   Group root = new Group(IDfield, passwords, change, back, ID, passwordLabel);
		   Scene scene = new Scene(root, 1000, 1000, Color.rgb(77, 71, 105));
		   PrimaryStage.setScene(scene);
		   PrimaryStage.show();	
		   PrimaryStage.setTitle("CHANGE PASSWORD");
		   
	   };

		   
	   
	   
	   public static boolean adminLogin(TextField tf, PasswordField passw) throws SQLException {
		   String username = tf.getText().toString();
		   String password = passw.getText().toString();
		   
		   try (Connection connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			   try (PreparedStatement preparedstatement = connect.prepareStatement(getAdminPassword)){
					preparedstatement.setString(1,username);
					preparedstatement.setString(2,password);
					try(ResultSet resultSet = preparedstatement.executeQuery()){
						return resultSet.next();
					}
				}
				
			} catch(SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		}
				   
			   
		   
	   
	   public static void adminVerify(TextField tf, PasswordField passw, Stage primaryStage) throws SQLException {
		   
		   if(tf.getText().isEmpty()) {
		        alert(Alert.AlertType.ERROR, "Form Error!",
		                "Please enter a username and password");
		        return;
		    }
		    if(passw.getText().isEmpty()) {
		        alert(Alert.AlertType.ERROR, "Form Error!",
		                "Please enter a username password");
		        return;
		    }

		    if (adminLogin(tf, passw)) {
				infoBox("LOGIN SUCCESSFUL", null, "SUCCESS");
				adminChoice(primaryStage);
				//fetchUserInfo(primaryStage, user, password);
			}
			else {
				infoBox("PLEASE ENTER CORRECT DETAILS", null, "FAILED");
			}
			
		}
	   
	  
		public static void main(String args[]){
			
		      launch(args);
		   }
}

	   



