
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
 * @author User
 */
public class InformationOf_anArt {
    static double scene_width;
    static double scene_height;
    
    Group grp;
    Text artTitle_txt;
    Text art_genre_txt;
    Text artist_name_txt;
    Text dateOfcreation_txt;
    Text price_txt;
    Text status_txt;
    
    
    Text artTitle_result_txt;
    Text art_genre_result_txt;
    Text artist_name_result_txt;
    Text dateOfcreation_result_txt;
    Text price_result_txt;
    Text status_result_txt;

    InformationOf_anArt() {
        this.scene_height = 850;
        this.scene_width = 1000;
        
        grp= new Group();
        
        artTitle_txt= new Text("ART TITLE");
        artTitle_txt.setLayoutX(scene_width-900);
        artTitle_txt.setLayoutY(scene_height-500);
        artTitle_txt.setFill(Color.BLACK);
        artTitle_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        art_genre_txt= new Text("ART GENRE");
        art_genre_txt.setLayoutX(scene_width-900);
        art_genre_txt.setLayoutY(scene_height-450);
        art_genre_txt.setFill(Color.BLACK);
        art_genre_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        
        artist_name_txt= new Text("ARTIST NAME");
        artist_name_txt.setLayoutX(scene_width-900);
        artist_name_txt.setLayoutY(scene_height-400);
        artist_name_txt.setFill(Color.BLACK);
        artist_name_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        dateOfcreation_txt= new Text("DATE OF CREATION");
        dateOfcreation_txt.setLayoutX(scene_width-900);
        dateOfcreation_txt.setLayoutY(scene_height-350);
        dateOfcreation_txt.setFill(Color.BLACK);
        dateOfcreation_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,16 ));
        
        price_txt= new Text("PRICE");
        price_txt.setLayoutX(scene_width-900);
        price_txt.setLayoutY(scene_height-300);
        price_txt.setFill(Color.BLACK);
        price_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        status_txt= new Text("STATUS");
        status_txt.setLayoutX(scene_width-900);
        status_txt.setLayoutY(scene_height-250);
        status_txt.setFill(Color.BLACK);
        status_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        
        
        
        
        artTitle_result_txt= new Text();
        artTitle_result_txt.setLayoutX(scene_width-700);
        artTitle_result_txt.setLayoutY(scene_height-500);
        artTitle_result_txt.setFill(Color.BLACK);
        artTitle_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        
        art_genre_result_txt= new Text();
        art_genre_result_txt.setLayoutX(scene_width-700);
        art_genre_result_txt.setLayoutY(scene_height-450);
        art_genre_result_txt.setFill(Color.BLACK);
        art_genre_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        artist_name_result_txt= new Text();
        artist_name_result_txt.setLayoutX(scene_width-700);
        artist_name_result_txt.setLayoutY(scene_height-400);
        artist_name_result_txt.setFill(Color.BLACK);
        artist_name_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        
        dateOfcreation_result_txt= new Text();
        dateOfcreation_result_txt.setLayoutX(scene_width-700);
        dateOfcreation_result_txt.setLayoutY(scene_height-350);
        dateOfcreation_result_txt.setFill(Color.BLACK);
        dateOfcreation_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        price_result_txt= new Text();
        price_result_txt.setLayoutX(scene_width-700);
        price_result_txt.setLayoutY(scene_height-300);
        price_result_txt.setFill(Color.BLACK);
        price_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        status_result_txt= new Text();
        status_result_txt.setLayoutX(scene_width-700);
        status_result_txt.setLayoutY(scene_height-250);
        status_result_txt.setFill(Color.BLACK);
        status_result_txt.setFont(Font.font("Times New Roman",FontWeight.BOLD,20 ));
        
        
        
        grp.getChildren().addAll(artTitle_result_txt,artTitle_txt,art_genre_result_txt,art_genre_txt,artist_name_result_txt,
                artist_name_txt,price_result_txt,price_txt,status_result_txt,status_txt,dateOfcreation_result_txt,dateOfcreation_txt);
        
        
        
        
    }
    
    
    
    
    
}
