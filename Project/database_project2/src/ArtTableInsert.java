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
public class ArtTableInsert {
        
            
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    
    Text art_title_txt;
    Text artist_name_txt;
    Text art_gen_txt;
    Text art_date_txt;
    Text art_price_txt;
    Text art_status_text;
    
    
    
    TextField art_title_txtf;
    TextField artist_name_txtf;
    TextField art_gen_txtf;
    TextField art_date_txtf;
    TextField art_price_txtf;
    TextField art_status_txtf;
    
    ToggleGroup toggle_grp_art_status;
    RadioButton art_status_rbtn_sold;
    RadioButton art_status_rbtn_available;
    
    
    ToggleGroup toggle_grp_art_genre;
    RadioButton art_genre_maritime_rbtn;
    RadioButton art_genre_symbolism_rbtn;
    RadioButton art_genre_renaissance_rbtn;
    RadioButton art_genre_fauvism_rbtn;
    RadioButton art_genre_postModern_rbtn;
    
    
     ArtTableInsert() 
    {
        this.scene_height = 850;
        this.scene_width = 1000;
        //this.Insertion_ID_Set_class= new Insertion_ID_Set();
        
        
        this.grp= new Group();

    
        art_title_txt = new Text("Art Title");
        art_title_txt.setLayoutX(scene_width-900);
        art_title_txt.setLayoutY(scene_height-730);
        art_title_txt.setFill(Color.BLACK);
        art_title_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        artist_name_txt = new Text("Artist_name");
        artist_name_txt.setLayoutX(scene_width-900);
        artist_name_txt.setLayoutY(scene_height-680);
        artist_name_txt.setFill(Color.BLACK);
        artist_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        art_gen_txt = new Text("Art Genre");
        art_gen_txt.setLayoutX(scene_width-900);
        art_gen_txt.setLayoutY(scene_height-630);
        art_gen_txt.setFill(Color.BLACK);
        art_gen_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        art_date_txt = new Text("Date of Creation");
        art_date_txt.setLayoutX(scene_width-900);
        art_date_txt.setLayoutY(scene_height-530);
        art_date_txt.setFill(Color.BLACK);
        art_date_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        art_price_txt = new Text("Price");
        art_price_txt.setLayoutX(scene_width-900);
        art_price_txt.setLayoutY(scene_height-480);
        art_price_txt.setFill(Color.BLACK);
        art_price_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        art_status_text = new Text("Status");
        art_status_text.setLayoutX(scene_width-900);
        art_status_text.setLayoutY(scene_height-430);
        art_status_text.setFill(Color.BLACK);
        art_status_text.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
        art_title_txtf = new TextField();
        art_title_txtf.setPromptText("Enter Art_Title");
        art_title_txtf.setPrefColumnCount(10);
        art_title_txtf.setLayoutX(scene_width-700);
        art_title_txtf.setLayoutY(scene_height-750);
        
        
         artist_name_txtf = new TextField();
        artist_name_txtf.setPromptText("Enter Artist_name");
        artist_name_txtf.setPrefColumnCount(10);
        artist_name_txtf.setLayoutX(scene_width-700);
        artist_name_txtf.setLayoutY(scene_height-700);
        
//        art_gen_txtf = new TextField();
//        art_gen_txtf.setPromptText("Enter Art Genre");
//        art_gen_txtf.setPrefColumnCount(10);
//        art_gen_txtf.setLayoutX(scene_width-700);
//        art_gen_txtf.setLayoutY(scene_height-600);
//        
//        
        art_date_txtf = new TextField();
        art_date_txtf.setPromptText("Enter Date");
        art_date_txtf.setPrefColumnCount(10);
        art_date_txtf.setLayoutX(scene_width-700);
        art_date_txtf.setLayoutY(scene_height-550);
        
        art_price_txtf = new TextField();
        art_price_txtf.setPromptText("Enter Art Price");
        art_price_txtf.setPrefColumnCount(10);
        art_price_txtf.setLayoutX(scene_width-700);
        art_price_txtf.setLayoutY(scene_height-500);
        
//        art_status_txtf = new TextField();
//        art_status_txtf.setPromptText("Enter Art Status");
//        art_status_txtf.setPrefColumnCount(10);
//        art_status_txtf.setLayoutX(scene_width-700);
//        art_status_txtf.setLayoutY(scene_height-450);
//        
        
        
        
        toggle_grp_art_status= new ToggleGroup();
        
        art_status_rbtn_sold = new RadioButton();
        art_status_rbtn_sold.setLayoutX(scene_width-700);
        art_status_rbtn_sold.setLayoutY(scene_height-450);
        art_status_rbtn_sold.setText("Sold");
        art_status_rbtn_sold.setUserData("Sold");
        art_status_rbtn_sold.setToggleGroup(toggle_grp_art_status);

        
        
        art_status_rbtn_available = new RadioButton();
        art_status_rbtn_available.setLayoutX(scene_width-620);
        art_status_rbtn_available.setLayoutY(scene_height-450);
        art_status_rbtn_available.setText("Available");
        art_status_rbtn_available.setUserData("Available");
        art_status_rbtn_available.setToggleGroup(toggle_grp_art_status);
        
      toggle_grp_art_status.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (toggle_grp_art_status.getSelectedToggle() != null) {
          System.out.println(toggle_grp_art_status.getSelectedToggle().getUserData().toString());
        }
      }
    });
      
      
       toggle_grp_art_genre= new ToggleGroup();
        
        art_genre_maritime_rbtn = new RadioButton();
        art_genre_maritime_rbtn.setLayoutX(scene_width-700);
        art_genre_maritime_rbtn.setLayoutY(scene_height-650);
        art_genre_maritime_rbtn.setText("Maritime");
        art_genre_maritime_rbtn.setUserData("Maritime");
        art_genre_maritime_rbtn.setToggleGroup(toggle_grp_art_genre);        
        
        art_genre_symbolism_rbtn = new RadioButton();
        art_genre_symbolism_rbtn.setLayoutX(scene_width-550);
        art_genre_symbolism_rbtn.setLayoutY(scene_height-650);
        art_genre_symbolism_rbtn.setText("Symbolism");
        art_genre_symbolism_rbtn.setUserData("Symbolism");
        art_genre_symbolism_rbtn.setToggleGroup(toggle_grp_art_genre);
        
        art_genre_renaissance_rbtn = new RadioButton();
        art_genre_renaissance_rbtn.setLayoutX(scene_width-400);
        art_genre_renaissance_rbtn.setLayoutY(scene_height-650);
        art_genre_renaissance_rbtn.setText("Renaissance");
        art_genre_renaissance_rbtn.setUserData("Renaissance");
        art_genre_renaissance_rbtn.setToggleGroup(toggle_grp_art_genre);

        art_genre_fauvism_rbtn = new RadioButton();
        art_genre_fauvism_rbtn.setLayoutX(scene_width-700);
        art_genre_fauvism_rbtn.setLayoutY(scene_height-600);
        art_genre_fauvism_rbtn.setText("Fauvism");
        art_genre_fauvism_rbtn.setUserData("Fauvism");
        art_genre_fauvism_rbtn.setToggleGroup(toggle_grp_art_genre);

        art_genre_postModern_rbtn = new RadioButton();
        art_genre_postModern_rbtn.setLayoutX(scene_width-550);
        art_genre_postModern_rbtn.setLayoutY(scene_height-600);
        art_genre_postModern_rbtn.setText("Post Modern");
        art_genre_postModern_rbtn.setUserData("Post Modern");
        art_genre_postModern_rbtn.setToggleGroup(toggle_grp_art_genre);

        
       toggle_grp_art_genre.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (toggle_grp_art_genre.getSelectedToggle() != null) {
          System.out.println(toggle_grp_art_genre.getSelectedToggle().getUserData().toString());
        }
      }
    });
       
       
       grp.getChildren().addAll(art_title_txt,art_title_txtf,artist_name_txt,artist_name_txtf,art_gen_txt,
               art_genre_fauvism_rbtn,art_genre_maritime_rbtn,art_genre_postModern_rbtn,
               art_genre_renaissance_rbtn,
               art_genre_symbolism_rbtn,art_date_txt,art_date_txtf,
               art_price_txt,
              art_price_txtf,art_status_text,art_status_rbtn_available,art_status_rbtn_sold
               );
        
        
        
    }
     

             

        
}