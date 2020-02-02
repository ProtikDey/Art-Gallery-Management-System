
import javafx.scene.Group;
import javafx.scene.control.TextField;
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
public class BillTableInsert {
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    Text bill_id_txt;
    Text customer_id_txt;
    Text art_id_txt;
    Text artist_id_txt;
    Text employee_id_txt;
    Text bill_date_txt;
    Text bill_amount_txt;
    
    TextField bill_id_txf;
    TextField customer_id_txf;
    TextField art_id_txf;
    TextField artist_id_txf;
    TextField employee_id_txf;
    TextField bill_date_txf;
    TextField bill_amount_txf;

    BillTableInsert() {
        
         this.scene_height = 850;
        this.scene_width = 1000;
        
        grp= new Group();
        
        bill_id_txt= new Text("BILL ID");
        bill_id_txt.setLayoutX(scene_width-850);
        bill_id_txt.setLayoutY(scene_height-700);
        bill_id_txt.setFill(Color.BLACK);
        bill_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        customer_id_txt= new Text("Customer Name");
        customer_id_txt.setLayoutX(scene_width-850);
        customer_id_txt.setLayoutY(scene_height-650);
        customer_id_txt.setFill(Color.BLACK);
        customer_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        art_id_txt= new Text("Art ID");
        art_id_txt.setLayoutX(scene_width-850);
        art_id_txt.setLayoutY(scene_height-600);
        art_id_txt.setFill(Color.BLACK);
        art_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        artist_id_txt= new Text("Artist Name");
        artist_id_txt.setLayoutX(scene_width-850);
        artist_id_txt.setLayoutY(scene_height-550);
        artist_id_txt.setFill(Color.BLACK);
        artist_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_id_txt= new Text("EMPLOYEE Name");
        employee_id_txt.setLayoutX(scene_width-850);
        employee_id_txt.setLayoutY(scene_height-550);
        employee_id_txt.setFill(Color.BLACK);
        employee_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         bill_date_txt= new Text("Bill Date");
        bill_date_txt.setLayoutX(scene_width-850);
        bill_date_txt.setLayoutY(scene_height-550);
        bill_date_txt.setFill(Color.BLACK);
        bill_date_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         
         bill_amount_txt= new Text("Bill Amount");
        bill_amount_txt.setLayoutX(scene_width-850);
        bill_amount_txt.setLayoutY(scene_height-500);
        bill_amount_txt.setFill(Color.BLACK);
        bill_amount_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         bill_id_txf = new TextField();
        bill_id_txf.setPromptText("Enter BILL_ID");
        bill_id_txf.setPrefColumnCount(10);
        bill_id_txf.setLayoutX(scene_width-650);
        bill_id_txf.setLayoutY(scene_height-720);
        
          customer_id_txf = new TextField();
        customer_id_txf.setPromptText("Enter Customer Name");
        customer_id_txf.setPrefColumnCount(10);
        customer_id_txf.setLayoutX(scene_width-650);
        customer_id_txf.setLayoutY(scene_height-670);
        
          art_id_txf = new TextField();
        art_id_txf.setPromptText("Enter ART_NAME");
        art_id_txf.setPrefColumnCount(10);
        art_id_txf.setLayoutX(scene_width-650);
        art_id_txf.setLayoutY(scene_height-620);
        
          artist_id_txf = new TextField();
        artist_id_txf.setPromptText("Enter ARTIST_NAME");
        artist_id_txf.setPrefColumnCount(10);
        artist_id_txf.setLayoutX(scene_width-650);
        artist_id_txf.setLayoutY(scene_height-570);
        
          employee_id_txf = new TextField();
        employee_id_txf.setPromptText("Enter EMPLOYEE_NAME");
        employee_id_txf.setPrefColumnCount(10);
        employee_id_txf.setLayoutX(scene_width-650);
        employee_id_txf.setLayoutY(scene_height-570);
        
        
        
          bill_date_txf = new TextField();
        bill_date_txf.setPromptText("Enter Bill date");
        bill_date_txf.setPrefColumnCount(10);
        bill_date_txf.setLayoutX(scene_width-650);
        bill_date_txf.setLayoutY(scene_height-570);
        
          bill_amount_txf = new TextField();
        bill_amount_txf.setPromptText("Enter Bill amount");
        bill_amount_txf.setPrefColumnCount(10);
        bill_amount_txf.setLayoutX(scene_width-650);
        bill_amount_txf.setLayoutY(scene_height-520);
        
        
        grp.getChildren().addAll(bill_amount_txf,bill_amount_txt,bill_date_txf,bill_date_txt,art_id_txf,
        art_id_txt,customer_id_txf,customer_id_txt);















        

        
        
    }
    
    
    
    
}
