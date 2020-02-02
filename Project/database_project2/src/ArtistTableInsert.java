
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
class ArtistTableInsert {
    //Insertion_ID_Set Insertion_ID_Set_class;
     
    
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    
    Text artist_id_txt;
    Text artist_name_txt;
    Text artist_sex_txt;
    Text artist_adrs_txt;
    Text artist_phn_txt ;
    Text artist_email_txt;
    Text artist_favGen_txt;
    Text artist_username_txt;
    Text artist_password_txt;
    Text artist_dateOf_birth_txt;
    
    
    TextField artist_id_txtf;
    TextField artist_name_txtf;
    TextField artist_adrs_txtf;
    TextField artist_phn_txtf;
    TextField artist_email_txtf;
    TextField artist_favGen_txtf;
    TextField artist_username_txtf;
    TextField artist_dateOf_birth_txf;
    PasswordField artist_password_txtf ;
    
    ToggleGroup toggle_grp_artist_sex;
    RadioButton artist_sex_rbtn_male;
    RadioButton artist_sex_rbtn_female;
    RadioButton artist_sex_rbtn_other;
    
    ToggleGroup toggle_grp_artist_fav_genre;
    RadioButton artist_fav_genre_maritime_rbtn;
    RadioButton artist_fav_genre_symbolism_rbtn;
    RadioButton artist_fav_genre_renaissance_rbtn;
    RadioButton artist_fav_genre_fauvism_rbtn;
    RadioButton artist_fav_genre_postModern_rbtn;

    
    ArtistTableInsert() 
    {
        this.scene_height = 850;
        this.scene_width = 1000;
        //this.Insertion_ID_Set_class= new Insertion_ID_Set();
        
        
        this.grp= new Group();

    
        artist_id_txt = new Text("Artist_ID");
        artist_id_txt.setLayoutX(scene_width-900);
        artist_id_txt.setLayoutY(scene_height-730);
        artist_id_txt.setFill(Color.BLACK);
        artist_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        artist_name_txt = new Text("Artist_name");
        artist_name_txt.setLayoutX(scene_width-900);
        artist_name_txt.setLayoutY(scene_height-680);
        artist_name_txt.setFill(Color.BLACK);
        artist_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        artist_sex_txt = new Text("Sex");
        artist_sex_txt.setLayoutX(scene_width-900);
        artist_sex_txt.setLayoutY(scene_height-630);
        artist_sex_txt.setFill(Color.BLACK);
        artist_sex_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        artist_adrs_txt = new Text("Address");
        artist_adrs_txt.setLayoutX(scene_width-900);
        artist_adrs_txt.setLayoutY(scene_height-580);
        artist_adrs_txt.setFill(Color.BLACK);
        artist_adrs_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        artist_phn_txt = new Text("Phone_no");
        artist_phn_txt.setLayoutX(scene_width-900);
        artist_phn_txt.setLayoutY(scene_height-530);
        artist_phn_txt.setFill(Color.BLACK);
        artist_phn_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        artist_email_txt = new Text("Email_ID");
        artist_email_txt.setLayoutX(scene_width-900);
        artist_email_txt.setLayoutY(scene_height-480);
        artist_email_txt.setFill(Color.BLACK);
        artist_email_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        artist_favGen_txt = new Text("Main Genre");
        artist_favGen_txt.setLayoutX(scene_width-900);
        artist_favGen_txt.setLayoutY(scene_height-430);
        artist_favGen_txt.setFill(Color.BLACK);
        artist_favGen_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        artist_username_txt = new Text("Username");
        artist_username_txt.setLayoutX(scene_width-900);
        artist_username_txt.setLayoutY(scene_height-330);
        artist_username_txt.setFill(Color.BLACK);
        artist_username_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        artist_password_txt = new Text("Password");
        artist_password_txt.setLayoutX(scene_width-900);
        artist_password_txt.setLayoutY(scene_height-280);
        artist_password_txt.setFill(Color.BLACK);
        artist_password_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        artist_dateOf_birth_txt = new Text("Date of birth");
        artist_dateOf_birth_txt.setLayoutX(scene_width-900);
        artist_dateOf_birth_txt.setLayoutY(scene_height-230);
        artist_dateOf_birth_txt.setFill(Color.BLACK);
        artist_dateOf_birth_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
        //String aa=Insertion_ID_Set_class.Set_Customer_ID();
        artist_id_txtf = new TextField();
        artist_id_txtf.setPromptText("Enter Artist_ID");
        artist_id_txtf.setPrefColumnCount(10);
        artist_id_txtf.setLayoutX(scene_width-700);
        artist_id_txtf.setLayoutY(scene_height-750);

        artist_name_txtf = new TextField();
        artist_name_txtf.setPromptText("Enter Artist_name");
        artist_name_txtf.setPrefColumnCount(10);
        artist_name_txtf.setLayoutX(scene_width-700);
        artist_name_txtf.setLayoutY(scene_height-700);



        artist_adrs_txtf = new TextField();
        artist_adrs_txtf.setPromptText("Enter Address");
        artist_adrs_txtf.setPrefColumnCount(10);
        artist_adrs_txtf.setLayoutX(scene_width-700);
        artist_adrs_txtf.setLayoutY(scene_height-600);

        artist_phn_txtf = new TextField();
        artist_phn_txtf.setPromptText("Enter Phone no");
        artist_phn_txtf.setPrefColumnCount(10);
        artist_phn_txtf.setLayoutX(scene_width-700);
        artist_phn_txtf.setLayoutY(scene_height-550);

        artist_email_txtf = new TextField();
        artist_email_txtf.setPromptText("Enter Email_ID");
        artist_email_txtf.setPrefColumnCount(10);
        artist_email_txtf.setLayoutX(scene_width-700);
        artist_email_txtf.setLayoutY(scene_height-500);


        artist_favGen_txtf = new TextField();
        artist_favGen_txtf.setPromptText("Enter Main Genre");
        artist_favGen_txtf.setPrefColumnCount(10);
        artist_favGen_txtf.setLayoutX(scene_width-700);
        artist_favGen_txtf.setLayoutY(scene_height-450);
        
        artist_username_txtf = new TextField();
        artist_username_txtf.setPromptText("Enter user name");
        artist_username_txtf.setPrefColumnCount(10);
        artist_username_txtf.setLayoutX(scene_width-700);
        artist_username_txtf.setLayoutY(scene_height-350);
        
        
        artist_password_txtf = new PasswordField();
        artist_password_txtf.setPromptText("Enter password");
        artist_password_txtf.setPrefColumnCount(10);
        artist_password_txtf.setLayoutX(scene_width-700);
        artist_password_txtf.setLayoutY(scene_height-300);
        
        
        artist_dateOf_birth_txf = new TextField();
        artist_dateOf_birth_txf.setPromptText("Format dd-mon-yy");
        artist_dateOf_birth_txf.setPrefColumnCount(10);
        artist_dateOf_birth_txf.setLayoutX(scene_width-700);
        artist_dateOf_birth_txf.setLayoutY(scene_height-250);
        
        
        
        
        toggle_grp_artist_sex= new ToggleGroup();
        
        artist_sex_rbtn_male = new RadioButton();
        artist_sex_rbtn_male.setLayoutX(scene_width-700);
        artist_sex_rbtn_male.setLayoutY(scene_height-650);
        artist_sex_rbtn_male.setText("Male");
        artist_sex_rbtn_male.setUserData("Male");
        artist_sex_rbtn_male.setToggleGroup(toggle_grp_artist_sex);

        
        
        artist_sex_rbtn_female = new RadioButton();
        artist_sex_rbtn_female.setLayoutX(scene_width-630);
        artist_sex_rbtn_female.setLayoutY(scene_height-650);
        artist_sex_rbtn_female.setText("Female");
        artist_sex_rbtn_female.setUserData("Female");
        artist_sex_rbtn_female.setToggleGroup(toggle_grp_artist_sex);
        
        artist_sex_rbtn_other = new RadioButton();
        artist_sex_rbtn_other.setLayoutX(scene_width-540);
        artist_sex_rbtn_other.setLayoutY(scene_height-650);
        artist_sex_rbtn_other.setText("Other");
        artist_sex_rbtn_other.setUserData("Other");
        artist_sex_rbtn_other.setToggleGroup(toggle_grp_artist_sex);

        
       toggle_grp_artist_sex.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (toggle_grp_artist_sex.getSelectedToggle() != null) {
          System.out.println(toggle_grp_artist_sex.getSelectedToggle().getUserData().toString());
        }
      }
    });
        
       
     //  
       toggle_grp_artist_fav_genre= new ToggleGroup();
        
        artist_fav_genre_maritime_rbtn = new RadioButton();
        artist_fav_genre_maritime_rbtn.setLayoutX(scene_width-700);
        artist_fav_genre_maritime_rbtn.setLayoutY(scene_height-450);
        artist_fav_genre_maritime_rbtn.setText("Maritime");
        artist_fav_genre_maritime_rbtn.setUserData("Maritime");
        artist_fav_genre_maritime_rbtn.setToggleGroup(toggle_grp_artist_fav_genre);        
        
        artist_fav_genre_symbolism_rbtn = new RadioButton();
        artist_fav_genre_symbolism_rbtn.setLayoutX(scene_width-550);
        artist_fav_genre_symbolism_rbtn.setLayoutY(scene_height-450);
        artist_fav_genre_symbolism_rbtn.setText("Symbolism");
        artist_fav_genre_symbolism_rbtn.setUserData("Symbolism");
        artist_fav_genre_symbolism_rbtn.setToggleGroup(toggle_grp_artist_fav_genre);
        
        artist_fav_genre_renaissance_rbtn = new RadioButton();
        artist_fav_genre_renaissance_rbtn.setLayoutX(scene_width-400);
        artist_fav_genre_renaissance_rbtn.setLayoutY(scene_height-450);
        artist_fav_genre_renaissance_rbtn.setText("Renaissance");
        artist_fav_genre_renaissance_rbtn.setUserData("Renaissance");
        artist_fav_genre_renaissance_rbtn.setToggleGroup(toggle_grp_artist_fav_genre);

        artist_fav_genre_fauvism_rbtn = new RadioButton();
        artist_fav_genre_fauvism_rbtn.setLayoutX(scene_width-700);
        artist_fav_genre_fauvism_rbtn.setLayoutY(scene_height-400);
        artist_fav_genre_fauvism_rbtn.setText("Fauvism");
        artist_fav_genre_fauvism_rbtn.setUserData("Fauvism");
        artist_fav_genre_fauvism_rbtn.setToggleGroup(toggle_grp_artist_fav_genre);

        artist_fav_genre_postModern_rbtn = new RadioButton();
        artist_fav_genre_postModern_rbtn.setLayoutX(scene_width-550);
        artist_fav_genre_postModern_rbtn.setLayoutY(scene_height-400);
        artist_fav_genre_postModern_rbtn.setText("Post Modern");
        artist_fav_genre_postModern_rbtn.setUserData("Post Modern");
        artist_fav_genre_postModern_rbtn.setToggleGroup(toggle_grp_artist_fav_genre);

        
       toggle_grp_artist_fav_genre.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (toggle_grp_artist_fav_genre.getSelectedToggle() != null) {
          System.out.println(toggle_grp_artist_fav_genre.getSelectedToggle().getUserData().toString());
        }
      }
    });
        

        
         grp.getChildren().addAll(artist_name_txt,artist_name_txtf,artist_adrs_txt,artist_adrs_txtf,
                artist_email_txt,artist_email_txtf,artist_favGen_txt,artist_fav_genre_fauvism_rbtn,artist_fav_genre_maritime_rbtn,
                artist_fav_genre_postModern_rbtn,artist_fav_genre_renaissance_rbtn,artist_fav_genre_symbolism_rbtn,artist_phn_txt,artist_phn_txtf,
                artist_sex_txt,artist_sex_rbtn_female,artist_sex_rbtn_male,artist_sex_rbtn_other,artist_username_txt,
                artist_password_txt,artist_username_txtf,artist_password_txtf,artist_dateOf_birth_txf,artist_dateOf_birth_txt);
   
  

            }

    
    
}
