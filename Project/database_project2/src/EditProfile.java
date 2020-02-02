

import javafx.scene.Group;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sun.security.util.Password;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class EditProfile {
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    Text new_username_txt;
    Text new_address_txt;
    Text new_phone_no_txt;
    Text new_email_id_txt;
    Text new_password_txt;
    
    TextField new_username_txf;
    TextField new_address_txf;
    TextField new_phone_no_txf;
    TextField new_email_id_txf;
    PasswordField new_password_txf;

    EditProfile() {
        
        this.scene_height = 850;
        this.scene_width = 1000;
        
        grp= new Group();
        
        new_username_txt = new Text("New Username");
        new_username_txt.setLayoutX(scene_width-900);
        new_username_txt.setLayoutY(scene_height-730);
        new_username_txt.setFill(Color.BLACK);
        new_username_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        new_address_txt = new Text("New Address");
        new_address_txt.setLayoutX(scene_width-900);
        new_address_txt.setLayoutY(scene_height-680);
        new_address_txt.setFill(Color.BLACK);
        new_address_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        new_phone_no_txt = new Text("New Phone No");
        new_phone_no_txt.setLayoutX(scene_width-900);
        new_phone_no_txt.setLayoutY(scene_height-630);
        new_phone_no_txt.setFill(Color.BLACK);
        new_phone_no_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         new_email_id_txt = new Text("New Email ID");
        new_email_id_txt.setLayoutX(scene_width-900);
        new_email_id_txt.setLayoutY(scene_height-580);
        new_email_id_txt.setFill(Color.BLACK);
        new_email_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         new_password_txt = new Text("New Password");
        new_password_txt.setLayoutX(scene_width-900);
        new_password_txt.setLayoutY(scene_height-530);
        new_password_txt.setFill(Color.BLACK);
        new_password_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
         new_username_txf = new TextField();
        new_username_txf.setPromptText("Enter Username");
        new_username_txf.setPrefColumnCount(10);
        new_username_txf.setLayoutX(scene_width-700);
        new_username_txf.setLayoutY(scene_height-750);
        
         new_address_txf = new TextField();
        new_address_txf.setPromptText("Enter Address");
        new_address_txf.setPrefColumnCount(10);
        new_address_txf.setLayoutX(scene_width-700);
        new_address_txf.setLayoutY(scene_height-700);
        
         new_phone_no_txf = new TextField();
        new_phone_no_txf.setPromptText("Enter Phone No");
        new_phone_no_txf.setPrefColumnCount(10);
        new_phone_no_txf.setLayoutX(scene_width-700);
        new_phone_no_txf.setLayoutY(scene_height-650);
        
         new_email_id_txf = new TextField();
        new_email_id_txf.setPromptText("Enter Email ID");
        new_email_id_txf.setPrefColumnCount(10);
        new_email_id_txf.setLayoutX(scene_width-700);
        new_email_id_txf.setLayoutY(scene_height-600);
        
         new_password_txf = new PasswordField();
        new_password_txf.setPromptText("Enter Email ID");
        new_password_txf.setPrefColumnCount(10);
        new_password_txf.setLayoutX(scene_width-700);
        new_password_txf.setLayoutY(scene_height-550);
        
        grp.getChildren().addAll(new_username_txt,new_address_txt,new_phone_no_txt,new_email_id_txt,new_password_txt,
                new_username_txf,new_address_txf,new_phone_no_txf,new_email_id_txf,new_password_txf);











    }
    
    
    
    
    
}
