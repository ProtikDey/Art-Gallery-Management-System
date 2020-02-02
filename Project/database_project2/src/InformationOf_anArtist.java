import javafx.scene.Group;
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
public class InformationOf_anArtist {
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    Text artist_name_txt;
    //Text manager_name_txt;
    Text address_txt;
    Text sex_txt;
    //Text salary_txt;
    Text phone_no_txt;
    Text email_ID_txt;
    Text dateOf_birth_txt;
    //Text join_date_txt;
    //Text end_date_txt;
    Text main_genre_txt;
    
    Text artist_name_result_txt;
    //Text manager_name_result_txt;
    Text address_result_txt;
    Text sex_result_txt;
    //Text salary_result_txt;
    Text phone_no_result_txt;
    Text email_ID_result_txt;
    Text dateOf_birth_result_txt;
    //Text join_date_result_txt;
    //Text end_date_result_txt;
    Text main_genre_result_txt;
    
    
    
    InformationOf_anArtist() {
        this.scene_height = 850;
        this.scene_width = 1000;
        
        grp= new Group();
        
        artist_name_txt= new Text("ARTIST NAME");
        artist_name_txt.setLayoutX(scene_width-900);
        artist_name_txt.setLayoutY(scene_height-500);
        artist_name_txt.setFill(Color.BLACK);
        artist_name_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
       
         address_txt= new Text("ADDRESS");
        address_txt.setLayoutX(scene_width-900);
        address_txt.setLayoutY(scene_height-460);
        address_txt.setFill(Color.BLACK);
        address_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        sex_txt= new Text("GENDER");
        sex_txt.setLayoutX(scene_width-900);
        sex_txt.setLayoutY(scene_height-420);
        sex_txt.setFill(Color.BLACK);
        sex_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        

        phone_no_txt= new Text("PHONE NO");
        phone_no_txt.setLayoutX(scene_width-900);
        phone_no_txt.setLayoutY(scene_height-380);
        phone_no_txt.setFill(Color.BLACK);
        phone_no_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        email_ID_txt= new Text("EMAIL ID");
        email_ID_txt.setLayoutX(scene_width-900);
        email_ID_txt.setLayoutY(scene_height-340);
        email_ID_txt.setFill(Color.BLACK);
        email_ID_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        dateOf_birth_txt= new Text("DATE OF BIRTH");
        dateOf_birth_txt.setLayoutX(scene_width-900);
        dateOf_birth_txt.setLayoutY(scene_height-300);
        dateOf_birth_txt.setFill(Color.BLACK);
        dateOf_birth_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        main_genre_txt= new Text("MAIN GENRE");
        main_genre_txt.setLayoutX(scene_width-900);
        main_genre_txt.setLayoutY(scene_height-260);
        main_genre_txt.setFill(Color.BLACK);
        main_genre_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        
        
        
        
        
        artist_name_result_txt= new Text();
        artist_name_result_txt.setLayoutX(scene_width-650);
        artist_name_result_txt.setLayoutY(scene_height-500);
        artist_name_result_txt.setFill(Color.BLACK);
        artist_name_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
     
         address_result_txt= new Text();
        address_result_txt.setLayoutX(scene_width-650);
        address_result_txt.setLayoutY(scene_height-460);
        address_result_txt.setFill(Color.BLACK);
        address_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        sex_result_txt= new Text();
        sex_result_txt.setLayoutX(scene_width-650);
        sex_result_txt.setLayoutY(scene_height-420);
        sex_result_txt.setFill(Color.BLACK);
        sex_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        phone_no_result_txt= new Text();
        phone_no_result_txt.setLayoutX(scene_width-650);
        phone_no_result_txt.setLayoutY(scene_height-380);
        phone_no_result_txt.setFill(Color.BLACK);
        phone_no_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        email_ID_result_txt= new Text();
        email_ID_result_txt.setLayoutX(scene_width-650);
        email_ID_result_txt.setLayoutY(scene_height-340);
        email_ID_result_txt.setFill(Color.BLACK);
        email_ID_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        dateOf_birth_result_txt= new Text();
        dateOf_birth_result_txt.setLayoutX(scene_width-650);
        dateOf_birth_result_txt.setLayoutY(scene_height-300);
        dateOf_birth_result_txt.setFill(Color.BLACK);
        dateOf_birth_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        main_genre_result_txt= new Text();
        main_genre_result_txt.setLayoutX(scene_width-650);
        main_genre_result_txt.setLayoutY(scene_height-260);
        main_genre_result_txt.setFill(Color.BLACK);
        main_genre_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
   
        
        
        grp.getChildren().addAll(address_result_txt,address_txt,dateOf_birth_result_txt,dateOf_birth_txt,email_ID_result_txt,email_ID_txt,
                artist_name_result_txt,artist_name_txt,phone_no_result_txt,phone_no_txt,sex_result_txt,sex_txt,main_genre_result_txt,
                main_genre_txt);
                
        
        
        
        
        
        
        
        
        
        
    }
    
    
}
