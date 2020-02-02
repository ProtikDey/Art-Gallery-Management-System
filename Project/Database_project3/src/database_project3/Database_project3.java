/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database_project3;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author HP
 */
public class Database_project3 extends Application {
    Connection con;

    static double scene_width;
    static double scene_height;


    private final String user="ART_GALLERY";
    private final String password="nirobdey";


    public static void main(String[] args) {
        launch(args);
    }


    public  Database_project3() throws SQLException
    {
        try{
            //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            String dbURL2 = "jdbc:oracle:thin:@localhost:1521:orcl";
            //con = DriverManager.getConnection(dbURL2, user, password);
            con=DriverManager.getConnection(dbURL2,user,password);
        }catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Connection prbl");

        }
    }




    public void init()
    {
        this.scene_height = 600;
        this.scene_width = 1000;



    }


    public String customer_query() throws SQLException{

        String output = null;
        Statement stmt1= con.createStatement();
        String sqlquery="SELECT * FROM CUSTOMERS";
        // PreparedStatement pst=con.prepareStatement(sqlquery);
        ResultSet rs = stmt1.executeQuery(sqlquery);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();





        while(rs.next()){



            output=rs.getString(1)+ "  "+rs.getString(2)+ "  "+rs.getString(3)+ "  "+rs.getString(4)+ "  "+rs.getInt(5)+ "  "+rs.getString(6)+ "  "+rs.getString(7);


        }


        return output ;


    }








    @Override
    public void start(Stage myStage) throws SQLException {


        Group first_grp = new Group();
        Scene first_scene = new Scene(first_grp, scene_width,scene_height);

        Group second_grp= new Group();
        Scene second_scene = new Scene(second_grp, scene_width,scene_height);

        Group insert_grp = new Group();
        Scene insert_scene= new Scene (insert_grp, scene_width,scene_height);

        Group query_grp =new Group();
        Scene query_scene = new Scene(query_grp,scene_width,scene_height);

        Group customer_grp_insrt = new Group();
        Scene customer_scene= new Scene(customer_grp_insrt,scene_width,scene_height);

//        Group login_page_grp = new Group();
//        Scene login_page_scene = new Scene(login_page_grp,scene_width, scene_height);
//        
//        Group manager_login_check_grp = new Group();
//        Scene manager_login_check_scene= new Scene ( manager_login_check_grp,scene_width,scene_height);
//        
//        

        ImageView front_image = new ImageView("file:front_image.jpg");
        front_image.setFitWidth(scene_width);
        front_image.setFitHeight(scene_height);

//        ImageView login_page_image = new ImageView("file:gallery_wall.jpg");
//        login_page_image.setFitWidth(scene_width);
//        login_page_image.setFitHeight(scene_height);

//        ImageView user_pass_image = new ImageView("file:art-gallery-wall.jpg");
//        user_pass_image.setFitWidth(scene_width);
//        user_pass_image.setFitHeight(scene_height);


        //       ImageView log_in = new ImageView("file:Member-Login-Button.png");
//        log_in.setFitHeight(30);
//        log_in.setFitWidth(100);


        Text Name = new Text("JOYNUL ART GALLERY ");
        Name.setLayoutX(scene_width-650);
        Name.setLayoutY(scene_height-50);
        Name.setFill(Color.BLUE);
        Name.setFont(Font.font("Algerian", FontWeight.BOLD, 50));


        Text Name2 = new Text("You have logged in!!!");
        Name2.setLayoutX(scene_width-700);
        Name2.setLayoutY(scene_height-800);
        Name2.setFill(Color.CHOCOLATE);
        Name2.setFont(Font.font("Algerian", FontWeight.BOLD, 30));

//        Text login_page_txt = new Text("LOG IN AS ---");
//        login_page_txt.setLayoutX(scene_width-700);
//        login_page_txt.setLayoutY(scene_height-810);
//        login_page_txt.setFill(Color.CHOCOLATE);
//        login_page_txt.setFont(Font.font("Algerian", FontWeight.BOLD, 40));


//        Text manager_login_check_txt = new Text("ARE YOU A MANAGER?");
//        manager_login_check_txt.setLayoutX(scene_width-700);
//        manager_login_check_txt.setLayoutY(scene_height-800);
//        manager_login_check_txt.setFill(Color.CHOCOLATE);
//        manager_login_check_txt.setFont(Font.font("Algerian", FontWeight.BOLD, 40));
//        
//        
        Text insert_txt=new Text("INSERT");
        insert_txt.setFill(Color.BLUE);
        insert_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,50 ));

        Text query_txt=new Text("QUERY");
        query_txt.setFill(Color.BLUE);
        query_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,50 ));

        Text table_select_txt= new Text("SELECT TABLE");
        table_select_txt.setLayoutX(scene_width-900);
        table_select_txt.setLayoutY(scene_height-750);
        table_select_txt.setFill(Color.BLACK);
        table_select_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));

        Text customer_txt= new Text("CUSTOMER");
        customer_txt.setFill(Color.BLUE);
        customer_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));

//        Text artist_txt= new Text("ARTIST");
//        artist_txt.setFill(Color.BLUE);
//        artist_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
//        
//        Text manager_txt= new Text("MANAGER");
//        manager_txt.setFill(Color.BLUE);
//        manager_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
//        
//        Text employee_txt= new Text("EMPLOYEE");
//        employee_txt.setFill(Color.BLUE);
//        employee_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
//        
//        Text username_txt= new Text("USER NAME");
//        username_txt.setFill(Color.BLUE);
//        username_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
//        
//        Text password_txt= new Text("PASSWORD");
//        password_txt.setFill(Color.BLUE);
//        password_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));



        Text customer_id_txt = new Text("Customer_ID");
        customer_id_txt.setLayoutX(scene_width-900);
        customer_id_txt.setLayoutY(scene_height-730);
        customer_id_txt.setFill(Color.BLACK);
        customer_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        Text customer_name_txt = new Text("Customer_name");
        customer_name_txt.setLayoutX(scene_width-900);
        customer_name_txt.setLayoutY(scene_height-680);
        customer_name_txt.setFill(Color.BLACK);
        customer_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        Text customer_sex_txt = new Text("Sex");
        customer_sex_txt.setLayoutX(scene_width-900);
        customer_sex_txt.setLayoutY(scene_height-630);
        customer_sex_txt.setFill(Color.BLACK);
        customer_sex_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        Text customer_adrs_txt = new Text("Address");
        customer_adrs_txt.setLayoutX(scene_width-900);
        customer_adrs_txt.setLayoutY(scene_height-580);
        customer_adrs_txt.setFill(Color.BLACK);
        customer_adrs_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        Text customer_phn_txt = new Text("Phone_no");
        customer_phn_txt.setLayoutX(scene_width-900);
        customer_phn_txt.setLayoutY(scene_height-530);
        customer_phn_txt.setFill(Color.BLACK);
        customer_phn_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        Text customer_email_txt = new Text("Email_ID");
        customer_email_txt.setLayoutX(scene_width-900);
        customer_email_txt.setLayoutY(scene_height-480);
        customer_email_txt.setFill(Color.BLACK);
        customer_email_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        Text customer_favGen_txt = new Text("Favourite Genre");
        customer_favGen_txt.setLayoutX(scene_width-900);
        customer_favGen_txt.setLayoutY(scene_height-430);
        customer_favGen_txt.setFill(Color.BLACK);
        customer_favGen_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text customer_username_txt = new Text("Username");
        customer_username_txt.setLayoutX(scene_width-900);
        customer_username_txt.setLayoutY(scene_height-380);
        customer_username_txt.setFill(Color.BLACK);
        customer_username_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text customer_password_txt = new Text("Password");
        customer_password_txt.setLayoutX(scene_width-900);
        customer_password_txt.setLayoutY(scene_height-330);
        customer_password_txt.setFill(Color.BLACK);
        customer_password_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        

        Text OK_txt = new Text("OK");
        OK_txt.setFill(Color.BLACK);
        OK_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        Text Submit_txt = new Text("Submit");
        Submit_txt.setFill(Color.BLACK);
        Submit_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));



        //Text query_show= new Text(customer_query()); // problem in this statement
        Text query_show= new Text("Customer");


        query_show.setLayoutX(120);
        query_show.setLayoutY(200);
        query_show.setFill(Color.BLACK);
        query_show.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        Text error_show = new Text("error!");
        error_show.setLayoutX(400);
        error_show.setLayoutY(700);
        error_show.setFill(Color.BLACK);
        error_show.setFont(Font.font("Arial",FontWeight.BOLD,20 ));








//       
//        
//        TextField manager_login_check_username_txtf = new TextField();
//        manager_login_check_username_txtf.setPromptText("Enter User Name");
//        manager_login_check_username_txtf.setPrefColumnCount(10);
//        manager_login_check_username_txtf.getText();        
//        manager_login_check_username_txtf.setLayoutX(scene_width-600);
//        manager_login_check_username_txtf.setLayoutY(scene_height-550);
//       
//        TextField manager_login_check_password_txtf = new TextField();
//        manager_login_check_password_txtf.setPromptText("Enter Password");
//        manager_login_check_password_txtf.setPrefColumnCount(10);
//        manager_login_check_password_txtf.getText();        
//        manager_login_check_password_txtf.setLayoutX(scene_width-600);
//        manager_login_check_password_txtf.setLayoutY(scene_height-400);



        TextField customer_id_txtf = new TextField();
        customer_id_txtf.setPromptText("Enter Customer_ID");
        customer_id_txtf.setPrefColumnCount(10);
        customer_id_txtf.getText();
        customer_id_txtf.setLayoutX(scene_width-700);
        customer_id_txtf.setLayoutY(scene_height-750);

        TextField customer_name_txtf = new TextField();
        customer_name_txtf.setPromptText("Enter Customer_name");
        customer_name_txtf.setPrefColumnCount(10);
        customer_name_txtf.getText();
        customer_name_txtf.setLayoutX(scene_width-700);
        customer_name_txtf.setLayoutY(scene_height-700);


//        TextField customer_sex_txtf = new TextField();
//        customer_sex_txtf.setPromptText("Enter Sex");
//        customer_sex_txtf.setPrefColumnCount(10);
//        customer_sex_txtf.getText();
//        customer_sex_txtf.setLayoutX(scene_width-700);
//        customer_sex_txtf.setLayoutY(scene_height-650);


        TextField customer_adrs_txtf = new TextField();
        customer_adrs_txtf.setPromptText("Enter Address");
        customer_adrs_txtf.setPrefColumnCount(10);
        customer_adrs_txtf.getText();
        customer_adrs_txtf.setLayoutX(scene_width-700);
        customer_adrs_txtf.setLayoutY(scene_height-600);

        TextField customer_phn_txtf = new TextField();
        customer_phn_txtf.setPromptText("Enter Phone no");
        customer_phn_txtf.setPrefColumnCount(10);
        customer_phn_txtf.getText();
        customer_phn_txtf.setLayoutX(scene_width-700);
        customer_phn_txtf.setLayoutY(scene_height-550);

        TextField customer_email_txtf = new TextField();
        customer_email_txtf.setPromptText("Enter Email_ID");
        customer_email_txtf.setPrefColumnCount(10);
        customer_email_txtf.getText();
        customer_email_txtf.setLayoutX(scene_width-700);
        customer_email_txtf.setLayoutY(scene_height-500);


        TextField customer_favGen_txtf = new TextField();
        customer_favGen_txtf.setPromptText("Enter Favourite Genre");
        customer_favGen_txtf.setPrefColumnCount(10);
        customer_favGen_txtf.getText();
        customer_favGen_txtf.setLayoutX(scene_width-700);
        customer_favGen_txtf.setLayoutY(scene_height-450);
        
         TextField customer_username_txtf = new TextField();
        customer_username_txtf.setPromptText("Enter user name");
        customer_username_txtf.setPrefColumnCount(10);
        customer_username_txtf.getText();        
        customer_username_txtf.setLayoutX(scene_width-700);
        customer_username_txtf.setLayoutY(scene_height-400);
        
        
         TextField customer_password_txtf = new TextField();
        customer_password_txtf.setPromptText("Enter password");
        customer_password_txtf.setPrefColumnCount(10);
        customer_password_txtf.getText();        
        customer_password_txtf.setLayoutX(scene_width-700);
        customer_password_txtf.setLayoutY(scene_height-350);





        Button log_in_btn = new Button();
        log_in_btn.setLayoutX(scene_width-70);
        log_in_btn.setLayoutY(scene_height-570);
        log_in_btn.setText(" LOG IN");
        //log_in_btn.setGraphic(log_in);
        log_in_btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(second_scene);
                // myStage.setScene(login_page_scene);
            }
        });
        
        Button log_in_as_guest_button = new Button();
        log_in_as_guest_button.setLayoutX(scene_width-900);
        log_in_as_guest_button.setLayoutY(scene_height-800);
        log_in_as_guest_button.setText("LOG IN AS GUEST");
        log_in_as_guest_button.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event)
            {
               // mystage.setScene
            }
        });

        Button insert_btn = new Button();
        insert_btn.setLayoutX(scene_width-650);
        insert_btn.setLayoutY(scene_height-550);
        insert_btn.setGraphic(insert_txt);
        insert_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(insert_scene);
            }
        });

        Button query_btn= new Button ();
        query_btn.setLayoutX(scene_width-650);
        query_btn.setLayoutY(scene_height-400);
        query_btn.setGraphic(query_txt);
        query_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");

                myStage.setScene( query_scene);
            }
        });

        Button Customer_btn= new Button();
        Customer_btn.setLayoutX(scene_width-650);
        Customer_btn.setLayoutY(scene_height-600);
        Customer_btn.setGraphic(customer_txt);
        Customer_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene( customer_scene);
            }
        });
        
        
        final ToggleGroup toggle_grp_customer = new ToggleGroup();
        
        RadioButton customer_sex_rbtn_male = new RadioButton();
        customer_sex_rbtn_male.setLayoutX(scene_width-700);
        customer_sex_rbtn_male.setLayoutY(scene_height-650);
        customer_sex_rbtn_male.setText("Male");
        customer_sex_rbtn_male.setUserData("Male");
        customer_sex_rbtn_male.setToggleGroup(toggle_grp_customer);

        
        
        RadioButton customer_sex_rbtn_female = new RadioButton();
        customer_sex_rbtn_female.setLayoutX(scene_width-630);
        customer_sex_rbtn_female.setLayoutY(scene_height-650);
        customer_sex_rbtn_female.setText("Female");
        customer_sex_rbtn_female.setUserData("Female");
        customer_sex_rbtn_female.setToggleGroup(toggle_grp_customer);
        
        RadioButton customer_sex_rbtn_other = new RadioButton();
        customer_sex_rbtn_other.setLayoutX(scene_width-540);
        customer_sex_rbtn_other.setLayoutY(scene_height-650);
        customer_sex_rbtn_other.setText("Other");
        customer_sex_rbtn_other.setUserData("Other");
        customer_sex_rbtn_other.setToggleGroup(toggle_grp_customer);

        
        toggle_grp_customer.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (toggle_grp_customer.getSelectedToggle() != null) {
          System.out.println(toggle_grp_customer.getSelectedToggle().getUserData().toString());
        }
      }
    });
        
        
        
        
        
        



//        Button login_page_Customer_btn= new Button();
//        login_page_Customer_btn.setLayoutX(scene_width-650);
//        login_page_Customer_btn.setLayoutY(scene_height-250);
//        login_page_Customer_btn.setGraphic(customer_txt);
//        login_page_Customer_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                //System.out.println("Hello World!");
//                myStage.setScene( customer_scene);
//            }
//        });



//        Button login_page_artist_btn= new Button();
//        login_page_artist_btn.setLayoutX(scene_width-650);
//        login_page_artist_btn.setLayoutY(scene_height-400);
//        login_page_artist_btn.setGraphic(artist_txt);
//        login_page_artist_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                //System.out.println("Hello World!");
//                //myStage.setScene( customer_scene);
//            }
//        });


//        
//        Button login_page_manager_btn= new Button();
//        login_page_manager_btn.setLayoutX(scene_width-650);
//        login_page_manager_btn.setLayoutY(scene_height-700);
//        login_page_manager_btn.setGraphic(manager_txt);
//        login_page_manager_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                //System.out.println("Hello World!");
//                //myStage.setScene(manager_login_check_scene);
//            }
//        });


//        Button login_page_employee_btn= new Button();
//        //System.out.println("Hello World!");
//             login_page_employee_btn.setLayoutX(scene_width-650);
//        login_page_employee_btn.setLayoutY(scene_height-550);
//        login_page_employee_btn.setGraphic(employee_txt);
//        login_page_employee_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                   //myStage.setScene( customer_scene);
//            }
//        });
//        
//        
//        Button manager_login_check_submit_btn = new Button();
//        manager_login_check_submit_btn.setLayoutX(scene_width-650);
//        manager_login_check_submit_btn.setLayoutY(scene_height-150);
//        manager_login_check_submit_btn.setGraphic(Submit_txt);
//        manager_login_check_submit_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                   //myStage.setScene( customer_scene);
//            }
//        });
//        
//        

        Button Customer_ok_btn = new Button();
        Customer_ok_btn.setLayoutX(scene_width-550);
        Customer_ok_btn.setLayoutY(scene_height-150);
        Customer_ok_btn.setGraphic(OK_txt);
        Customer_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               // System.out.println(customer_name_txtf.getText());
                if(con!=null){
                    
                    try {
                       // System.out.println("Connected  1");
                       // System.out.println("Cu");
                      //  System.out.println(customer_name_txtf.getText());
                        
                        Statement stmt=con.createStatement();
                        
                        System.out.println(customer_id_txtf.getLength()); 
                        String c_id=customer_id_txtf.getText();
                        String c_name=customer_name_txtf.getText();
                        String c_sex=toggle_grp_customer.getSelectedToggle().getUserData().toString();
                        String c_adrs = customer_adrs_txtf.getText();
                        String c_phn= customer_phn_txtf.getText();
                        String c_email= customer_email_txtf.getText();
                        String c_favGen=customer_favGen_txtf.getText();
                        String c_username = customer_username_txtf.getText();
                        String c_password = customer_password_txtf.getText();
                        
                        
                        
                        String sqlCommand = "INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE) VALUES('"+ c_id+ "','"+ c_name+ "',' "+c_username+ " ',' "+c_password+" ','" +c_sex+ "','" +c_adrs+ "','" +c_phn +"','" + c_email+"','"+c_favGen+"')";
                        // String sqlCommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE)"+
                             //    "VALUES('005','gh','af','gf',7,'Sb','oD')";
    
                        stmt.executeUpdate(sqlCommand);
                        //con.commit();
                        //System.out.println("Connect 2");
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project3.class.getName()).log(Level.SEVERE, null, ex);
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                    }
                   
                     
                    
                }
                
               myStage.setScene(second_scene);
            }
                    
        });
        
  




        second_grp.getChildren().addAll( Name2,insert_btn,query_btn  );

        insert_grp.getChildren().addAll(table_select_txt,Customer_btn);
        customer_grp_insrt.getChildren().addAll(customer_id_txt,customer_id_txtf,customer_name_txt,customer_name_txtf,customer_adrs_txt,customer_adrs_txtf,
                customer_email_txt,customer_email_txtf,customer_favGen_txt,customer_favGen_txtf,customer_phn_txt,customer_phn_txtf,
                customer_sex_txt,customer_sex_rbtn_female,customer_sex_rbtn_male,customer_sex_rbtn_other,customer_username_txt,
                customer_password_txt,customer_username_txtf,customer_password_txtf,Customer_ok_btn);


        query_grp.getChildren().addAll(query_show);

//        login_page_grp.getChildren().addAll(login_page_image, login_page_txt,login_page_manager_btn,login_page_employee_btn,login_page_artist_btn,
//                login_page_Customer_btn);
//        
//        
//        manager_login_check_grp.getChildren().addAll(user_pass_image,manager_login_check_txt,manager_login_check_username_txtf,
//                manager_login_check_password_txtf,manager_login_check_submit_btn);
//        
        myStage.setTitle("JOYNUL ART GALLERY ");


        myStage.setScene(first_scene);
        first_grp.getChildren().addAll(front_image,Name,log_in_btn);
        myStage.show();


    }

    /**
     * @param args the command line arguments
     */

}