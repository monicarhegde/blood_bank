package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import java.io.FileNotFoundException;
import java.sql.*;
public class javapro extends Application{
	public Statement stmt;
	public TextField name1 = new TextField();
	public DatePicker date1=new DatePicker();
	public TextField add1=new TextField();
	public TextField user1=new TextField();
	public PasswordField setp1=new PasswordField();
	public PasswordField conp1=new PasswordField();
	public TextField t1=new TextField();
	public PasswordField p1=new PasswordField();
	public Text uinfo=new Text();
	public GridPane root=new GridPane();
	public Scene scene =new Scene(root,500,500);
	public TextField ulog1=new TextField();
	public PasswordField plog1=new PasswordField();
	public ChoiceBox<String> loc = new ChoiceBox<String>();
	public ChoiceBox<String> tg = new ChoiceBox<String>();
	public GridPane log1=new GridPane();
	public Scene scene4=new Scene(log1,500,500);
	public ChoiceBox<String> loc1=new ChoiceBox<String>();
	public DatePicker apdate1=new DatePicker();
	public TextField aptime1=new TextField();
	public GridPane root2=new GridPane();
	public GridPane root1=new GridPane();
	public ChoiceBox<String> user=new ChoiceBox<String>();
	public Label val = new Label();
	public TextField phno1=new TextField();
	public ChoiceBox<String> userin=new ChoiceBox<String>();
	public Label val1 = new Label();
	public GridPane users=new GridPane();
	public Scene users1=new Scene(users,500,500);
		public static void main(String args[])
	{
		launch(args); 
		
	}

	@Override
	public void start(Stage primaryStage){
	    
		dbconnect();
		

		primaryStage.setTitle("Blood Bank");
		Button b1=new Button("Admin Login");
		b1.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
						Text t3=new Text("Password:");
						Text t2=new Text("Name:");
						Button alogin=new Button("Login");
						Button backt=new Button("Back");
						backt.setOnAction(new EventHandler<ActionEvent>()
								{

									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										primaryStage.setScene(scene);
									}
							
								});
						alogin.setOnAction(new EventHandler<ActionEvent>()
								{

									@Override
									public void handle(ActionEvent event) {
										boolean a=adminlogin(stmt);
										if(a==true)
											{System.out.println("Login successful");
											uinfo.setText("Users");
											user.getItems().addAll("A+","B+","O+","AB+","A-","B-","O-","AB-");
											user.setOnAction(new EventHandler<ActionEvent>()
													{

														@Override
														public void handle(ActionEvent event) {
															// TODO Auto-generated method stub
															Text name=new Text("Name     DOB     Gender     Bldgrp     Address     Ph no");
															root2.add(name,0,1);
															showinfo(stmt,user.getValue());
															Button back2=new Button("Logout");
															root2.add(back2,4,15);
															back2.setOnAction(new EventHandler<ActionEvent>()
																	{

																		@Override
																		public void handle(ActionEvent event) {
																			primaryStage.setScene(scene);
																		}
																
																	});
															
														}
												
													});
											
										
											
										
										
										root2.add(uinfo, 0, 0);
										root2.add(val, 0, 2);
										root2.setAlignment(Pos.TOP_CENTER);
										root2.add(user, 1, 0);
										root2.setStyle("-fx-background-color:grey;"
										+" -fx-font:normal bold 15px 'serif';");
									
										Scene scene1 =new Scene(root2,500,500);
										primaryStage.setScene(scene1);
										primaryStage.show();
											}
											
										else
											{
											Text err=new Text("Enetr correct username and poassword");
											root1.add(err,60,7);
											}
									}
							
								});
						
						
						root1.setAlignment(Pos.CENTER);
						root1.setMinSize(500, 600);
						root1.setPadding(new Insets(10,10,10,10));
						root1.add(t1,200,4);
						root1.add(p1,200,6);
						root1.add(t2, 50, 4);
						root1.add(t3, 50, 6);
						root1.add(alogin, 200, 300);
						root1.add(backt, 300, 200);
						root1.setStyle("-fx-background-color: rosybrown;"
						                +"-fx-font:normal bold 15px 'serif';");
						Scene scene =new Scene(root1,500,500);
						primaryStage.setScene(scene);
						primaryStage.show();
					}
			
				});
		{
			
		}
		Button b2=new Button("User Login");
		b2.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) {
						GridPane log=new GridPane(); 
						Text ulog=new Text("Username:");
						Text plog=new Text("Password:");
						Button backq=new Button("Back");
						log.add(backq,2,2);
						backq.setOnAction(new EventHandler<ActionEvent>()
								{

									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										primaryStage.setScene(scene);
									}
							
								});
						log.add(ulog, 0, 0);
						log.add(plog, 0, 1);
						log.add(ulog1, 1, 0);
						log.add(plog1, 1, 1);
						Button login=new Button("Login");
						log.add(login, 1, 2);
						
						login.setOnAction(new EventHandler<ActionEvent>()
								{

									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										boolean check=validateuser(stmt);
										if(check==true) {
											System.out.println("logged in");
										
										
										Button donate=new Button("Donate Blood");
										Button view=new Button("View donars");
										Button logt=new Button("Logout");
										logt.setOnAction(new EventHandler<ActionEvent>()
												{

													@Override
													public void handle(ActionEvent event) {
														// TODO Auto-generated method stub
														primaryStage.setScene(scene);
														
													}
											
												});
										view.setOnAction(new EventHandler<ActionEvent>()
												{

													@Override
													public void handle(ActionEvent event) {
														
														// TODO Auto-generated method stub
														Text use=new Text("Donars\nSelect blood group");
														users.add(use,0,0);
														userin.getItems().addAll("A+","B+","O+","AB+","A-","B-","O-","AB-");
														users.add(userin, 1, 0);
														userin.setOnAction(new EventHandler<ActionEvent>()
																{

																	@Override
																	public void handle(ActionEvent event) {
																		// TODO Auto-generated method stub
																		Text disp=new Text("Name     Ph No.");
																		users.add(disp, 0, 1);
																		showinfo1(stmt,userin.getValue());
																		users.add(val1, 0, 2);
																		Button backs=new Button("Back");
																		users.add(backs, 2, 5);
																		backs.setOnAction(new EventHandler<ActionEvent>()
																				{

																					@Override
																					public void handle(
																							ActionEvent event) {
																						// TODO Auto-generated method stub
																						primaryStage.setScene(scene4);
																					}
																			
																				});
																		
																		
																	}
															
																});
														users.setStyle("-fx-font:normal bold 15px 'serif';"
																+" -fx-background-color:lightblue;");
														users.setAlignment(Pos.CENTER);
														primaryStage.setScene(users1);
														
													}
											
												});
										Button logout =new Button("Logout");
										logout.setOnAction(new EventHandler<ActionEvent>()
												{

													@Override
													public void handle(ActionEvent event) {
														// TODO Auto-generated method stub
														primaryStage.setScene(scene);
													}
											
												});
										log1.setAlignment(Pos.CENTER);
										log1.add(donate, 0, 0);
										log1.add(view, 1, 0);
										log1.add(logt,2,3);
										log1.setHgap(5);
										log1.setStyle("-fx-font:normal bold 15px 'serif';"
										+" -fx-background-color:lightpink;");
										donate.setOnAction(new EventHandler<ActionEvent>()
												{

													@Override
													public void handle(ActionEvent event) {
														// TODO Auto-generated method stub
														
														Text name=new Text("Name");
														Text date=new Text("DOB");
														Text gen=new Text("Gender");
														tg.getItems().addAll("Gender","Female","Male");
														tg.getSelectionModel().selectFirst();
														Text add=new Text("Address");
														Text bg=new Text("Blood group");
														Text phno=new Text("Phone Number");
														/*ToggleGroup tg1=new ToggleGroup();
														RadioButton ap=new RadioButton("A+ve");
														ap.setToggleGroup(tg1);
														RadioButton bp=new RadioButton("B+ve");
														bp.setToggleGroup(tg1);
														RadioButton abp=new RadioButton("AB+ve");
														abp.setToggleGroup(tg1);
														RadioButton op=new RadioButton("O+ve");
														op.setToggleGroup(tg1);*/
														 
													        loc.getItems().addAll("select blood group","A+","B+","O+","AB+","A-","B-","O-","AB-");
													        loc.getSelectionModel().selectFirst();
														
														Button reg=new Button("Register");
														GridPane gp=new GridPane();
														gp.setMinSize(500, 600);
														gp.setPadding(new Insets(10,10,10,10));
														gp.setVgap(10);
														gp.setHgap(5);
														gp.setAlignment(Pos.CENTER);
														gp.add(name, 0, 0);
														gp.add(name1, 1, 0);
														gp.add(date, 0, 1);
														gp.add(date1, 1, 1);
														gp.add(gen, 0, 2);
														gp.add(tg, 1, 2);
														gp.add(bg, 0, 3);
														/*gp.add(ap, 1, 3);
														gp.add(bp, 1, 4);
														gp.add(abp, 1, 5);
														gp.add(op, 1, 6);*/
														gp.add(loc, 1, 3);
														gp.add(add, 0, 7);
														gp.add(phno, 0, 8);
														gp.add(phno1, 1, 8);
														gp.add(add1, 1, 7);
														gp.add(reg, 1, 18);
														Button blog1=new Button("Back");
														gp.add(blog1,4,20);
														blog1.setOnAction(new EventHandler<ActionEvent>()
																{

																	@Override
																	public void handle(ActionEvent event) {
																		primaryStage.setScene(scene4);
																	}
															
																});
														
														gp.setStyle("-fx-font:normal bold 15px 'serif';"
														+" -fx-background-color:lightblue;");
														Scene scene=new Scene(gp);
														primaryStage.setScene(scene);
														primaryStage.show();
														reg.setOnAction(new EventHandler<ActionEvent>(){

															@Override
															public void handle(ActionEvent event) {
																// TODO Auto-generated method stub
																insert(stmt);
																
																GridPane setloc=new GridPane();
																//Scene s1=new Scene(loc,500,500);
																Text selectloc=new Text("Select Location of bloodbank");
																loc1.getItems().addAll("Select area","Yelahanka","Vijayanagar","Jaynagar","Whitefield","RT Nagar");
																loc1.getSelectionModel().selectFirst();
																Text apdate=new Text("Appointment date");
																
																Text aptime=new Text("Enter appointment time");
																
																Button set=new Button("Set");
																set.setOnAction(new EventHandler<ActionEvent>()
																		{

																			@Override
																			public void handle(ActionEvent event) {
																				// TODO Auto-generated method stub
																				Text ty=new Text("Thank You");
																				setloc.add(ty, 1, 5);
																				Button back1=new Button("Back");
																				setloc.add(back1,4,15);
																				back1.setOnAction(new EventHandler<ActionEvent>()
																						{

																							@Override
																							public void handle(ActionEvent event) {
																								primaryStage.setScene(scene4);
																							}
																					
																						});
																				
																				
																			}
																	
																		});
																setloc.setAlignment(Pos.CENTER);
																setloc.setMinSize(500, 600);
																setloc.setPadding(new Insets(10,10,10,10));
																setloc.setVgap(10);
																setloc.setHgap(5);
																
																setloc.add(selectloc, 0, 0);
																setloc.add(loc1, 1, 0);
																setloc.add(apdate, 0, 1);
																setloc.add(apdate1, 1, 1);
																setloc.add(aptime, 0, 2);
																setloc.add(aptime1, 1, 2);
																setloc.add(set, 2, 3);
																setloc.setStyle("-fx-font:normal bold 15px 'serif';"
																		+" -fx-background-color:lightblue;");
																insertappoint(stmt);
					
																Scene sceneloc=new Scene(setloc,500,500);
																primaryStage.setScene(sceneloc);
																		
															}
															
														}); 
													}
											
												});
										
										primaryStage.setScene(scene4);
										primaryStage.show();
										}
										else
										{
											Text msg=new Text("Enter valid username and password");
											log.add(msg, 0, 3);
										}
									}
							
								});
						
						log.setAlignment(Pos.CENTER);
						log.setStyle("-fx-font:normal bold 15px 'serif';"
						+" -fx-background-color:lavender;");
						Scene scene3=new Scene(log,500,500);
						primaryStage.setScene(scene3);
						primaryStage.show();
						
					}
			
				});
		Button b3=new Button("User registration");
		b3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				GridPane ur=new GridPane();
				
                Text user=new Text("User Name");
				
				Text setp=new Text("Set password");
				
				Text conp=new Text("Confirm password");
				
				ur.add(user, 0, 8);
				ur.add(conp, 0, 10);
				ur.add(setp, 0, 9);
				ur.add(user1, 1, 8);
				
				ur.add(setp1, 1, 9);
				
				ur.add(conp1, 1, 10);
				Text val=new Text();
				
				Button register=new Button("Register");
				register.setOnAction(new EventHandler<ActionEvent>()
						{

							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								if(setp1.getText().equals(conp1.getText()))
								{
									val.setText("Password set");
									insertuser(stmt);
									Button blog=new Button("Back");
									ur.add(blog,4,20);
									blog.setOnAction(new EventHandler<ActionEvent>()
											{

												@Override
												public void handle(ActionEvent event) {
													primaryStage.setScene(scene);
												}
										
											});
									
								}
								else
									val.setText("Passwords doesn't match");
							}
					
						});
				ur.add(val, 0, 25);
				ur.add(register, 0, 20);
				ur.setAlignment(Pos.CENTER);
				ur.setStyle("-fx-font:normal bold 15px 'serif';"
				+" -fx-background-color:grey;");
				Scene scene2=new Scene(ur,500,500);
				primaryStage.setScene(scene2);
				primaryStage.show();
				}
				
		});
		
		root.setVgap(10);;
		root.setHgap(20);
	    root.add(b1,2,1);
	    root.add(b2,2,2);
	    root.add(b3,2, 3);
	    root.setAlignment(Pos.CENTER); 
	    
	    /*Image image=new Image("‎⁨file:///Users/monicahegde/eclipse-workspace/project/src/application/blood.jpg");
	    ImageView iv=new ImageView(image);
	    iv.setX(5);
	    iv.setY(5);
		iv.setFitHeight(450);
		iv.setFitWidth(450);
		iv.setPreserveRatio(true);*/
		
		root.setStyle("-fx-background-color:#e6b3ff;" +
				
		" -fx-font:normal bold 15px 'serif';");			
		
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
	public void dbconnect()
	{
		try {
			Connection con=null;
			
	    	Class.forName("com.mysql.cj.jdbc.Driver");	
	    	final String USER="root";
	    	final String PASS="mon12345";
	    	final String DBURL="jdbc:mysql://127.0.0.1:3306/bloodbank";
	    	con=DriverManager.getConnection(DBURL,USER,PASS);
	    	stmt=con.createStatement();
	    	System.out.println("Connected");
		}
		 catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(Statement st) {
		try {
			
		st.executeUpdate("INSERT INTO users VALUES ('"+name1.getText()+"','"+date1.getValue()+"','"+tg.getValue()+"','"+loc.getValue()+"','"+add1.getText()+"','"+phno1.getText()+"');");
		
		System.out.println("inserted");
		}
		catch(Exception e) {
			System.out.println(e);
			}
	}
		public boolean adminlogin(Statement st)
		{ 
			int a=0;
			try {
			ResultSet rs=st.executeQuery("SELECT * FROM admin WHERE auname='"+t1.getText()+"' and apass='"+p1.getText()+"';");
		if(rs.next())
			a=1;
		else 
			a=0;
		}
		catch(Exception e) {
			System.out.println(e);
			}
			if(a==1)
				return true;
			else 
				return false;
		
}
		public void showinfo(Statement st,String str)
		{ try
		{String ab="";
			ResultSet r=st.executeQuery("SELECT * FROM users WHERE bg='"+str+"';");
			while(r.next())
			{
			
				ab=ab+r.getString(1)+"     "+r.getString(2)+"     "+r.getString(3)+"     "+r.getString(4)+"     "+r.getString(5)+"     "+r.getString(6)+"\n";
				
			}
			System.out.println(ab);
			val.setText(ab);
			
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		public void insertuser(Statement s)
		{
			try
			{
			s.executeUpdate("INSERT INTO userid VALUES('"+user1.getText()+"','"+conp1.getText()+"');");
			System.out.println("Done");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		public boolean validateuser(Statement s)
		{int a=0;
			try
			{
				ResultSet r=s.executeQuery("SELECT * FROM userid WHERE username='"+ulog1.getText()+"' and password='"+plog1.getText()+"';");
				if(r.next())
				{
					a=1;
				}
				else
					a=0;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			if(a==1)
			{
				
				System.out.println("Validated");
				return true;
			}
			else 
				return false;
		}
		public void insertappoint(Statement s)
		{
			try
			{
			s.executeUpdate("INSERT INTO appoint VALUES('"+loc1.getValue()+"','"+apdate1.getValue()+"','"+aptime1.getText()+"');");
			System.out.println("OK");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		public void showinfo1(Statement s,String st)
		{
			try
			{String ab="";
				ResultSet r=s.executeQuery("SELECT * FROM users WHERE bg='"+st+"';");
				while(r.next())
				{
				
					ab=ab+r.getString(1)+"     "+r.getString(6)+"\n";
					
				}
				System.out.println(ab);
				val1.setText(ab);
				
					
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

}
