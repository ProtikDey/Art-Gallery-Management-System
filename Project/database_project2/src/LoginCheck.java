

import javafx.scene.Group;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
public class LoginCheck {
    static double scene_width;
    static double scene_height;
    
    Group grp;
    Text username_txt;
    Text password_txt;
    
    TextField username_txtf ;
    PasswordField password_txtf;
    ImageView backgrnd_image;
    
    LoginCheck()
    {
        this.scene_height = 850;
        this.scene_width = 1000;
        
        grp= new Group();
        
        
        ImageView backgrnd_image = new ImageView("file:art-gallery-wall.jpg");
        backgrnd_image.setFitWidth(scene_width);
        backgrnd_image.setFitHeight(scene_height);
        
        
        username_txt= new Text("USER NAME");
        username_txt.setLayoutX(scene_width-600);
        username_txt.setLayoutY(scene_height-580);
        username_txt.setFill(Color.BROWN);
        username_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        password_txt= new Text("PASSWORD");
        password_txt.setLayoutX(scene_width-600);
        password_txt.setLayoutY(scene_height-430);
        password_txt.setFill(Color.BROWN);
        password_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        
        
          
        username_txtf = new TextField();
        username_txtf.setPromptText("Enter User Name");
        username_txtf.setPrefColumnCount(10);     
        username_txtf.setLayoutX(scene_width-600);
        username_txtf.setLayoutY(scene_height-550);
       
         password_txtf = new PasswordField();
        password_txtf.setPromptText("Enter Password");
        password_txtf.setPrefColumnCount(10);      
        password_txtf.setLayoutX(scene_width-600);
        password_txtf.setLayoutY(scene_height-400);
        
        
        grp.getChildren().addAll(backgrnd_image,username_txt,username_txtf,password_txt,password_txtf);





    }
    
}
