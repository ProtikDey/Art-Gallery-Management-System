
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
public class Employee_Profile {
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    Text employee_ID_txt;
    Text employee_name_txt;
    Text username_txt;
    Text password_txt;
    Text address_txt;
    Text sex_txt;
    Text phone_no_txt;
    Text email_ID_txt;
    Text salary_txt;
    Text dateOf_birth_txt;
    Text join_date_txt;
    Text end_date_txt;
    Text manager_ID_txt;
    
    
    
    Text employee_ID_result_txt;
    Text employee_name_result_txt;
    Text username_result_txt;
    Text password_result_txt;
    Text address_result_txt;
    Text sex_result_txt;
    Text phone_no_result_txt;
    Text email_ID_result_txt;
    Text salary_result_txt;
    Text dateOf_birth_result_txt;
    Text join_date_result_txt;
    Text end_date_result_txt;
    Text manager_ID_result_txt;

    
    Employee_Profile(){
         this.scene_height = 850;
        this.scene_width = 1000;
        
        grp= new Group();
        
        employee_ID_txt = new Text("ID");
        employee_ID_txt.setLayoutX(scene_width-900);
        employee_ID_txt.setLayoutY(scene_height-730);
        employee_ID_txt.setFill(Color.BLACK);
        employee_ID_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_name_txt = new Text("NAME");
        employee_name_txt.setLayoutX(scene_width-900);
        employee_name_txt.setLayoutY(scene_height-680);
        employee_name_txt.setFill(Color.BLACK);
        employee_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
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
        
        salary_txt = new Text("SALARY");
        salary_txt.setLayoutX(scene_width-900);
        salary_txt.setLayoutY(scene_height-330);
        salary_txt.setFill(Color.BLACK);
        salary_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         dateOf_birth_txt = new Text("DATE OF BIRTH");
        dateOf_birth_txt.setLayoutX(scene_width-900);
        dateOf_birth_txt.setLayoutY(scene_height-280);
        dateOf_birth_txt.setFill(Color.BLACK);
        dateOf_birth_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        join_date_txt = new Text("JOIN DATE");
        join_date_txt.setLayoutX(scene_width-900);
        join_date_txt.setLayoutY(scene_height-230);
        join_date_txt.setFill(Color.BLACK);
        join_date_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        end_date_txt = new Text("END DATE");
        end_date_txt.setLayoutX(scene_width-900);
        end_date_txt.setLayoutY(scene_height-180);
        end_date_txt.setFill(Color.BLACK);
        end_date_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        manager_ID_txt = new Text("ID");
        manager_ID_txt.setLayoutX(scene_width-900);
        manager_ID_txt.setLayoutY(scene_height-130);
        manager_ID_txt.setFill(Color.BLACK);
        manager_ID_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
        
        employee_ID_result_txt = new Text("ggg");
        employee_ID_result_txt.setLayoutX(scene_width-650);
        employee_ID_result_txt.setLayoutY(scene_height-730);
        employee_ID_result_txt.setFill(Color.BLACK);
        employee_ID_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_name_result_txt = new Text("skdj");
        employee_name_result_txt.setLayoutX(scene_width-650);
        employee_name_result_txt.setLayoutY(scene_height-680);
        employee_name_result_txt.setFill(Color.BLACK);
        employee_name_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        username_result_txt = new Text("asd");
        username_result_txt.setLayoutX(scene_width-650);
        username_result_txt.setLayoutY(scene_height-630);
        username_result_txt.setFill(Color.BLACK);
        username_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         password_result_txt = new Text("c");
        password_result_txt.setLayoutX(scene_width-650);
        password_result_txt.setLayoutY(scene_height-580);
        password_result_txt.setFill(Color.BLACK);
        password_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         address_result_txt = new Text("sdcv");
        address_result_txt.setLayoutX(scene_width-650);
        address_result_txt.setLayoutY(scene_height-530);
        address_result_txt.setFill(Color.BLACK);
        address_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         sex_result_txt = new Text("sdf");
        sex_result_txt.setLayoutX(scene_width-650);
        sex_result_txt.setLayoutY(scene_height-480);
        sex_result_txt.setFill(Color.BLACK);
        sex_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         phone_no_result_txt = new Text("dcv");
        phone_no_result_txt.setLayoutX(scene_width-650);
        phone_no_result_txt.setLayoutY(scene_height-430);
        phone_no_result_txt.setFill(Color.BLACK);
        phone_no_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         email_ID_result_txt = new Text("zsv");
        email_ID_result_txt.setLayoutX(scene_width-650);
        email_ID_result_txt.setLayoutY(scene_height-380);
        email_ID_result_txt.setFill(Color.BLACK);
        email_ID_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        salary_result_txt = new Text("sdf");
        salary_result_txt.setLayoutX(scene_width-650);
        salary_result_txt.setLayoutY(scene_height-330);
        salary_result_txt.setFill(Color.BLACK);
        salary_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         dateOf_birth_result_txt = new Text("zcv");
        dateOf_birth_result_txt.setLayoutX(scene_width-650);
        dateOf_birth_result_txt.setLayoutY(scene_height-280);
        dateOf_birth_result_txt.setFill(Color.BLACK);
        dateOf_birth_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        join_date_result_txt = new Text("asdf");
        join_date_result_txt.setLayoutX(scene_width-650);
        join_date_result_txt.setLayoutY(scene_height-230);
        join_date_result_txt.setFill(Color.BLACK);
        join_date_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        end_date_result_txt = new Text("sdf");
        end_date_result_txt.setLayoutX(scene_width-650);
        end_date_result_txt.setLayoutY(scene_height-180);
        end_date_result_txt.setFill(Color.BLACK);
        end_date_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        manager_ID_result_txt = new Text("ggg");
        manager_ID_result_txt.setLayoutX(scene_width-650);
        manager_ID_result_txt.setLayoutY(scene_height-130);
        manager_ID_result_txt.setFill(Color.BLACK);
        manager_ID_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
        
        grp.getChildren().addAll(address_result_txt,address_txt,manager_ID_result_txt,manager_ID_txt,employee_name_result_txt,employee_name_txt,
                dateOf_birth_result_txt,dateOf_birth_txt,email_ID_result_txt,email_ID_txt,salary_result_txt,salary_txt,password_result_txt,
                password_txt,phone_no_result_txt,phone_no_txt,sex_result_txt,sex_txt,username_result_txt,username_txt,
                join_date_result_txt,join_date_txt,end_date_result_txt,end_date_txt,employee_ID_result_txt,employee_ID_txt);
        
        
    }
        
        
    

    
    
    
    
}
