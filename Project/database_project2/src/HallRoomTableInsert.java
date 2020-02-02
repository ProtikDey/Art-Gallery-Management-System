
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
 * @author User
 */
public class HallRoomTableInsert {
    
     static double scene_width;
    static double scene_height;
    
    Group grp;
    
    Text hall_name_txt;
    
    TextField hall_name_txtf;
    
    
     HallRoomTableInsert() 
    {
        this.scene_height = 850;
        this.scene_width = 1000;
        //this.Insertion_ID_Set_class= new Insertion_ID_Set();
        
        
        this.grp= new Group();

    
        hall_name_txt = new Text("Hall Name");
        hall_name_txt.setLayoutX(scene_width-900);
        hall_name_txt.setLayoutY(scene_height-730);
        hall_name_txt.setFill(Color.BLACK);
        hall_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        hall_name_txtf = new TextField();
        hall_name_txtf.setPromptText("Enter Hall Name");
        hall_name_txtf.setPrefColumnCount(10);
        hall_name_txtf.setLayoutX(scene_width-700);
        hall_name_txtf.setLayoutY(scene_height-750);
        
        
        grp.getChildren().addAll(hall_name_txt,hall_name_txtf);
    }
    
    
    
    
}
