
import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
class CustomerTableInsert {
    //Insertion_ID_Set Insertion_ID_Set_class;
     
    
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    
    Text customer_id_txt;
    Text customer_name_txt;
    Text customer_sex_txt;
    Text customer_adrs_txt;
    Text customer_phn_txt ;
    Text customer_email_txt;
    Text customer_favGen_txt;
    Text customer_username_txt;
    Text customer_password_txt;
    Text customer_dateOf_birth_txt;
    
    
    TextField customer_id_txtf;
    TextField customer_name_txtf;
    TextField customer_adrs_txtf;
    TextField customer_phn_txtf;
    TextField customer_email_txtf;
    TextField customer_favGen_txtf;
    TextField customer_username_txtf;
    TextField customer_dateOf_birth_txf;
    PasswordField customer_password_txtf ;
    
    ToggleGroup toggle_grp_customer_sex;
    RadioButton customer_sex_rbtn_male;
    RadioButton customer_sex_rbtn_female;
    RadioButton customer_sex_rbtn_other;
    
    ToggleGroup toggle_grp_customer_fav_genre;
    RadioButton customer_fav_genre_maritime_rbtn;
    RadioButton customer_fav_genre_symbolism_rbtn;
    RadioButton customer_fav_genre_renaissance_rbtn;
    RadioButton customer_fav_genre_fauvism_rbtn;
    RadioButton customer_fav_genre_postModern_rbtn;

    
    CustomerTableInsert() 
    {
        this.scene_height = 850;
        this.scene_width = 1000;
        //this.Insertion_ID_Set_class= new Insertion_ID_Set();
        
        
        this.grp= new Group();

    
        customer_id_txt = new Text("Customer_ID");
        customer_id_txt.setLayoutX(scene_width-900);
        customer_id_txt.setLayoutY(scene_height-730);
        customer_id_txt.setFill(Color.BLACK);
        customer_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        customer_name_txt = new Text("Customer_name");
        customer_name_txt.setLayoutX(scene_width-900);
        customer_name_txt.setLayoutY(scene_height-680);
        customer_name_txt.setFill(Color.BLACK);
        customer_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        customer_sex_txt = new Text("Sex");
        customer_sex_txt.setLayoutX(scene_width-900);
        customer_sex_txt.setLayoutY(scene_height-630);
        customer_sex_txt.setFill(Color.BLACK);
        customer_sex_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        customer_adrs_txt = new Text("Address");
        customer_adrs_txt.setLayoutX(scene_width-900);
        customer_adrs_txt.setLayoutY(scene_height-580);
        customer_adrs_txt.setFill(Color.BLACK);
        customer_adrs_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        customer_phn_txt = new Text("Phone_no");
        customer_phn_txt.setLayoutX(scene_width-900);
        customer_phn_txt.setLayoutY(scene_height-530);
        customer_phn_txt.setFill(Color.BLACK);
        customer_phn_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        customer_email_txt = new Text("Email_ID");
        customer_email_txt.setLayoutX(scene_width-900);
        customer_email_txt.setLayoutY(scene_height-480);
        customer_email_txt.setFill(Color.BLACK);
        customer_email_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        customer_favGen_txt = new Text("Favourite Genre");
        customer_favGen_txt.setLayoutX(scene_width-900);
        customer_favGen_txt.setLayoutY(scene_height-430);
        customer_favGen_txt.setFill(Color.BLACK);
        customer_favGen_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        customer_username_txt = new Text("Username");
        customer_username_txt.setLayoutX(scene_width-900);
        customer_username_txt.setLayoutY(scene_height-330);
        customer_username_txt.setFill(Color.BLACK);
        customer_username_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        customer_password_txt = new Text("Password");
        customer_password_txt.setLayoutX(scene_width-900);
        customer_password_txt.setLayoutY(scene_height-280);
        customer_password_txt.setFill(Color.BLACK);
        customer_password_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        customer_dateOf_birth_txt = new Text("Date of birth");
        customer_dateOf_birth_txt.setLayoutX(scene_width-900);
        customer_dateOf_birth_txt.setLayoutY(scene_height-230);
        customer_dateOf_birth_txt.setFill(Color.BLACK);
        customer_dateOf_birth_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
        //String aa=Insertion_ID_Set_class.Set_Customer_ID();
        customer_id_txtf = new TextField();
        customer_id_txtf.setPromptText("Enter Customer_ID");
        customer_id_txtf.setPrefColumnCount(10);
        customer_id_txtf.setLayoutX(scene_width-700);
        customer_id_txtf.setLayoutY(scene_height-750);

        customer_name_txtf = new TextField();
        customer_name_txtf.setPromptText("Enter Customer_name");
        customer_name_txtf.setPrefColumnCount(10);
        customer_name_txtf.setLayoutX(scene_width-700);
        customer_name_txtf.setLayoutY(scene_height-700);



        customer_adrs_txtf = new TextField();
        customer_adrs_txtf.setPromptText("Enter Address");
        customer_adrs_txtf.setPrefColumnCount(10);
        customer_adrs_txtf.setLayoutX(scene_width-700);
        customer_adrs_txtf.setLayoutY(scene_height-600);

        customer_phn_txtf = new TextField();
        customer_phn_txtf.setPromptText("Enter Phone no");
        customer_phn_txtf.setPrefColumnCount(10);
        customer_phn_txtf.setLayoutX(scene_width-700);
        customer_phn_txtf.setLayoutY(scene_height-550);

        customer_email_txtf = new TextField();
        customer_email_txtf.setPromptText("Enter Email_ID");
        customer_email_txtf.setPrefColumnCount(10);
        customer_email_txtf.setLayoutX(scene_width-700);
        customer_email_txtf.setLayoutY(scene_height-500);


        customer_favGen_txtf = new TextField();
        customer_favGen_txtf.setPromptText("Enter Favourite Genre");
        customer_favGen_txtf.setPrefColumnCount(10);
        customer_favGen_txtf.setLayoutX(scene_width-700);
        customer_favGen_txtf.setLayoutY(scene_height-450);
        
        customer_username_txtf = new TextField();
        customer_username_txtf.setPromptText("Enter user name");
        customer_username_txtf.setPrefColumnCount(10);
        customer_username_txtf.setLayoutX(scene_width-700);
        customer_username_txtf.setLayoutY(scene_height-350);
        
        
        customer_password_txtf = new PasswordField();
        customer_password_txtf.setPromptText("Enter password");
        customer_password_txtf.setPrefColumnCount(10);
        customer_password_txtf.setLayoutX(scene_width-700);
        customer_password_txtf.setLayoutY(scene_height-300);
        
        
        customer_dateOf_birth_txf = new TextField();
        customer_dateOf_birth_txf.setPromptText("Format dd-mon-yy");
        customer_dateOf_birth_txf.setPrefColumnCount(10);
        customer_dateOf_birth_txf.setLayoutX(scene_width-700);
        customer_dateOf_birth_txf.setLayoutY(scene_height-250);
        
        
        
        
        toggle_grp_customer_sex= new ToggleGroup();
        
        customer_sex_rbtn_male = new RadioButton();
        customer_sex_rbtn_male.setLayoutX(scene_width-700);
        customer_sex_rbtn_male.setLayoutY(scene_height-650);
        customer_sex_rbtn_male.setText("Male");
        customer_sex_rbtn_male.setUserData("Male");
        customer_sex_rbtn_male.setToggleGroup(toggle_grp_customer_sex);

        
        
        customer_sex_rbtn_female = new RadioButton();
        customer_sex_rbtn_female.setLayoutX(scene_width-630);
        customer_sex_rbtn_female.setLayoutY(scene_height-650);
        customer_sex_rbtn_female.setText("Female");
        customer_sex_rbtn_female.setUserData("Female");
        customer_sex_rbtn_female.setToggleGroup(toggle_grp_customer_sex);
        
        customer_sex_rbtn_other = new RadioButton();
        customer_sex_rbtn_other.setLayoutX(scene_width-540);
        customer_sex_rbtn_other.setLayoutY(scene_height-650);
        customer_sex_rbtn_other.setText("Other");
        customer_sex_rbtn_other.setUserData("Other");
        customer_sex_rbtn_other.setToggleGroup(toggle_grp_customer_sex);

        
       toggle_grp_customer_sex.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (toggle_grp_customer_sex.getSelectedToggle() != null) {
          System.out.println(toggle_grp_customer_sex.getSelectedToggle().getUserData().toString());
        }
      }
    });
        
       
     //  
       toggle_grp_customer_fav_genre= new ToggleGroup();
        
        customer_fav_genre_maritime_rbtn = new RadioButton();
        customer_fav_genre_maritime_rbtn.setLayoutX(scene_width-700);
        customer_fav_genre_maritime_rbtn.setLayoutY(scene_height-450);
        customer_fav_genre_maritime_rbtn.setText("Maritime");
        customer_fav_genre_maritime_rbtn.setUserData("Maritime");
        customer_fav_genre_maritime_rbtn.setToggleGroup(toggle_grp_customer_fav_genre);        
        
        customer_fav_genre_symbolism_rbtn = new RadioButton();
        customer_fav_genre_symbolism_rbtn.setLayoutX(scene_width-550);
        customer_fav_genre_symbolism_rbtn.setLayoutY(scene_height-450);
        customer_fav_genre_symbolism_rbtn.setText("Symbolism");
        customer_fav_genre_symbolism_rbtn.setUserData("Symbolism");
        customer_fav_genre_symbolism_rbtn.setToggleGroup(toggle_grp_customer_fav_genre);
        
        customer_fav_genre_renaissance_rbtn = new RadioButton();
        customer_fav_genre_renaissance_rbtn.setLayoutX(scene_width-400);
        customer_fav_genre_renaissance_rbtn.setLayoutY(scene_height-450);
        customer_fav_genre_renaissance_rbtn.setText("Renaissance");
        customer_fav_genre_renaissance_rbtn.setUserData("Renaissance");
        customer_fav_genre_renaissance_rbtn.setToggleGroup(toggle_grp_customer_fav_genre);

        customer_fav_genre_fauvism_rbtn = new RadioButton();
        customer_fav_genre_fauvism_rbtn.setLayoutX(scene_width-700);
        customer_fav_genre_fauvism_rbtn.setLayoutY(scene_height-400);
        customer_fav_genre_fauvism_rbtn.setText("Fauvism");
        customer_fav_genre_fauvism_rbtn.setUserData("Fauvism");
        customer_fav_genre_fauvism_rbtn.setToggleGroup(toggle_grp_customer_fav_genre);

        customer_fav_genre_postModern_rbtn = new RadioButton();
        customer_fav_genre_postModern_rbtn.setLayoutX(scene_width-550);
        customer_fav_genre_postModern_rbtn.setLayoutY(scene_height-400);
        customer_fav_genre_postModern_rbtn.setText("Post Modern");
        customer_fav_genre_postModern_rbtn.setUserData("Post Modern");
        customer_fav_genre_postModern_rbtn.setToggleGroup(toggle_grp_customer_fav_genre);

        
       toggle_grp_customer_fav_genre.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (toggle_grp_customer_fav_genre.getSelectedToggle() != null) {
          System.out.println(toggle_grp_customer_fav_genre.getSelectedToggle().getUserData().toString());
        }
      }
    });
        

        
         grp.getChildren().addAll(customer_name_txt,customer_name_txtf,customer_adrs_txt,customer_adrs_txtf,
                customer_email_txt,customer_email_txtf,customer_favGen_txt,customer_fav_genre_fauvism_rbtn,customer_fav_genre_maritime_rbtn,
                customer_fav_genre_postModern_rbtn,customer_fav_genre_renaissance_rbtn,customer_fav_genre_symbolism_rbtn,customer_phn_txt,customer_phn_txtf,
                customer_sex_txt,customer_sex_rbtn_female,customer_sex_rbtn_male,customer_sex_rbtn_other,customer_username_txt,
                customer_password_txt,customer_username_txtf,customer_password_txtf,customer_dateOf_birth_txf,customer_dateOf_birth_txt);
   
  

            }

    
    
}
