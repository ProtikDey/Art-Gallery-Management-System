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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ExhibitionTableInsert {
    
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    
    Text exhibition_name_txt;
    Text exhibition_hall_name_txt;
    Text exhibition_art_name_txt;
    Text exhibition_start_date_txt;
    Text exhibition_end_date_txt;
    
    
    
    TextField exhibition_name_txtf;
    TextField exhibition_hall_name_txtf;
    TextField exhibition_art_name_txtf;
    TextField exhibition_start_date_txtf;
    TextField exhibition_end_date_txtf;


        
    ExhibitionTableInsert() 
    {
        this.scene_height = 850;
        this.scene_width = 1000;
        //this.Insertion_ID_Set_class= new Insertion_ID_Set();
        
        
        this.grp= new Group();

    
        exhibition_name_txt = new Text("Exhibition_name");
        exhibition_name_txt.setLayoutX(scene_width-900);
        exhibition_name_txt.setLayoutY(scene_height-730);
        exhibition_name_txt.setFill(Color.BLACK);
        exhibition_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        exhibition_hall_name_txt = new Text("Hall_name");
        exhibition_hall_name_txt.setLayoutX(scene_width-900);
        exhibition_hall_name_txt.setLayoutY(scene_height-680);
        exhibition_hall_name_txt.setFill(Color.BLACK);
        exhibition_hall_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        exhibition_art_name_txt = new Text("Art_name");
        exhibition_art_name_txt.setLayoutX(scene_width-900);
        exhibition_art_name_txt.setLayoutY(scene_height-630);
        exhibition_art_name_txt.setFill(Color.BLACK);
        exhibition_art_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        exhibition_start_date_txt = new Text("Start Date");
        exhibition_start_date_txt.setLayoutX(scene_width-900);
        exhibition_start_date_txt.setLayoutY(scene_height-580);
        exhibition_start_date_txt.setFill(Color.BLACK);
        exhibition_start_date_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        exhibition_end_date_txt = new Text("End Date");
        exhibition_end_date_txt.setLayoutX(scene_width-900);
        exhibition_end_date_txt.setLayoutY(scene_height-530);
        exhibition_end_date_txt.setFill(Color.BLACK);
        exhibition_end_date_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        exhibition_name_txtf = new TextField();
        exhibition_name_txtf.setPromptText("Enter Exhibition Name");
        exhibition_name_txtf.setPrefColumnCount(10);
        exhibition_name_txtf.setLayoutX(scene_width-700);
        exhibition_name_txtf.setLayoutY(scene_height-750);

        exhibition_hall_name_txtf = new TextField();
        exhibition_hall_name_txtf.setPromptText("Enter Hall name");
        exhibition_hall_name_txtf.setPrefColumnCount(10);
        exhibition_hall_name_txtf.setLayoutX(scene_width-700);
        exhibition_hall_name_txtf.setLayoutY(scene_height-700);
        
        exhibition_art_name_txtf = new TextField();
        exhibition_art_name_txtf.setPromptText("Enter Art name");
        exhibition_art_name_txtf.setPrefColumnCount(10);
        exhibition_art_name_txtf.setLayoutX(scene_width-700);
        exhibition_art_name_txtf.setLayoutY(scene_height-650);



        exhibition_start_date_txtf = new TextField();
        exhibition_start_date_txtf.setPromptText("Format dd-mm-yy");
        exhibition_start_date_txtf.setPrefColumnCount(10);
        exhibition_start_date_txtf.setLayoutX(scene_width-700);
        exhibition_start_date_txtf.setLayoutY(scene_height-600);

        exhibition_end_date_txtf = new TextField();
        exhibition_end_date_txtf.setPromptText("Format dd-mm-yy");
        exhibition_end_date_txtf.setPrefColumnCount(10);
        exhibition_end_date_txtf.setLayoutX(scene_width-700);
        exhibition_end_date_txtf.setLayoutY(scene_height-550);
        
        
        grp.getChildren().addAll(exhibition_name_txt,exhibition_name_txtf,exhibition_hall_name_txt,exhibition_hall_name_txtf,exhibition_art_name_txt,
                exhibition_art_name_txtf,exhibition_start_date_txt,
                exhibition_start_date_txtf,exhibition_end_date_txt,exhibition_end_date_txtf);
    }

    
    
}
