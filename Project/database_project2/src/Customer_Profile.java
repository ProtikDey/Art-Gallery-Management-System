import javafx.scene.Group;
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
public class Customer_Profile {
static double scene_width;
    static double scene_height;
    
    Group grp;
    
    Text customer_ID_txt;
    Text customer_name_txt;
    Text username_txt;
    Text password_txt;
    Text address_txt;
    Text sex_txt;
    Text phone_no_txt;
    Text email_ID_txt;
    Text favourite_genre_txt;
    Text dateOf_birth_txt;
    
    
    Text customer_ID_result_txt;
    Text customer_name_result_txt;
    Text username_result_txt;
    Text password_result_txt;
    Text address_result_txt;
    Text sex_result_txt;
    Text phone_no_result_txt;
    Text email_ID_result_txt;
    Text favourite_genre_result_txt;
    Text dateOf_birth_result_txt;
    
    Customer_Profile(){
         this.scene_height = 850;
        this.scene_width = 1000;
        
        grp= new Group();
        
        customer_ID_txt = new Text("ID");
        customer_ID_txt.setLayoutX(scene_width-900);
        customer_ID_txt.setLayoutY(scene_height-730);
        customer_ID_txt.setFill(Color.BLACK);
        customer_ID_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        customer_name_txt = new Text("NAME");
        customer_name_txt.setLayoutX(scene_width-900);
        customer_name_txt.setLayoutY(scene_height-680);
        customer_name_txt.setFill(Color.BLACK);
        customer_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        username_txt = new Text("USERNAME");
        username_txt.setLayoutX(scene_width-900);
        username_txt.setLayoutY(scene_height-630);
        username_txt.setFill(Color.BLACK);
        username_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         password_txt = new Text("PASSWORD");
        password_txt.setLayoutX(scene_width-900);
        password_txt.setLayoutY(scene_height-580);
        password_txt.setFill(Color.BLACK);
        password_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         address_txt = new Text("ADDRESS");
        address_txt.setLayoutX(scene_width-900);
        address_txt.setLayoutY(scene_height-530);
        address_txt.setFill(Color.BLACK);
        address_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         sex_txt = new Text("GENDER");
        sex_txt.setLayoutX(scene_width-900);
        sex_txt.setLayoutY(scene_height-480);
        sex_txt.setFill(Color.BLACK);
        sex_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         phone_no_txt = new Text("PHONE NO");
        phone_no_txt.setLayoutX(scene_width-900);
        phone_no_txt.setLayoutY(scene_height-430);
        phone_no_txt.setFill(Color.BLACK);
        phone_no_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         email_ID_txt = new Text("EMAIL ID");
        email_ID_txt.setLayoutX(scene_width-900);
        email_ID_txt.setLayoutY(scene_height-380);
        email_ID_txt.setFill(Color.BLACK);
        email_ID_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        favourite_genre_txt = new Text("FAVORITE GENRE");
        favourite_genre_txt.setLayoutX(scene_width-900);
        favourite_genre_txt.setLayoutY(scene_height-330);
        favourite_genre_txt.setFill(Color.BLACK);
        favourite_genre_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         dateOf_birth_txt = new Text("DATE OF BIRTH");
        dateOf_birth_txt.setLayoutX(scene_width-900);
        dateOf_birth_txt.setLayoutY(scene_height-280);
        dateOf_birth_txt.setFill(Color.BLACK);
        dateOf_birth_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
        customer_ID_result_txt = new Text();
        customer_ID_result_txt.setLayoutX(scene_width-650);
        customer_ID_result_txt.setLayoutY(scene_height-730);
        customer_ID_result_txt.setFill(Color.BLACK);
        customer_ID_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        customer_name_result_txt = new Text();
        customer_name_result_txt.setLayoutX(scene_width-650);
        customer_name_result_txt.setLayoutY(scene_height-680);
        customer_name_result_txt.setFill(Color.BLACK);
        customer_name_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        username_result_txt = new Text();
        username_result_txt.setLayoutX(scene_width-650);
        username_result_txt.setLayoutY(scene_height-630);
        username_result_txt.setFill(Color.BLACK);
        username_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         password_result_txt = new Text();
        password_result_txt.setLayoutX(scene_width-650);
        password_result_txt.setLayoutY(scene_height-580);
        password_result_txt.setFill(Color.BLACK);
        password_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         address_result_txt = new Text();
        address_result_txt.setLayoutX(scene_width-650);
        address_result_txt.setLayoutY(scene_height-530);
        address_result_txt.setFill(Color.BLACK);
        address_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         sex_result_txt = new Text();
        sex_result_txt.setLayoutX(scene_width-650);
        sex_result_txt.setLayoutY(scene_height-480);
        sex_result_txt.setFill(Color.BLACK);
        sex_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         phone_no_result_txt = new Text();
        phone_no_result_txt.setLayoutX(scene_width-650);
        phone_no_result_txt.setLayoutY(scene_height-430);
        phone_no_result_txt.setFill(Color.BLACK);
        phone_no_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         email_ID_result_txt = new Text();
        email_ID_result_txt.setLayoutX(scene_width-650);
        email_ID_result_txt.setLayoutY(scene_height-380);
        email_ID_result_txt.setFill(Color.BLACK);
        email_ID_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        favourite_genre_result_txt = new Text();
        favourite_genre_result_txt.setLayoutX(scene_width-650);
        favourite_genre_result_txt.setLayoutY(scene_height-330);
        favourite_genre_result_txt.setFill(Color.BLACK);
        favourite_genre_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         dateOf_birth_result_txt = new Text();
        dateOf_birth_result_txt.setLayoutX(scene_width-650);
        dateOf_birth_result_txt.setLayoutY(scene_height-280);
        dateOf_birth_result_txt.setFill(Color.BLACK);
        dateOf_birth_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        grp.getChildren().addAll(address_result_txt,address_txt,customer_ID_result_txt,customer_ID_txt,customer_name_result_txt,customer_name_txt,
                dateOf_birth_result_txt,dateOf_birth_txt,email_ID_result_txt,email_ID_txt,favourite_genre_result_txt,favourite_genre_txt,password_result_txt,
                password_txt,phone_no_result_txt,phone_no_txt,sex_result_txt,sex_txt,username_result_txt,username_txt);
        
        
    }
        

}
