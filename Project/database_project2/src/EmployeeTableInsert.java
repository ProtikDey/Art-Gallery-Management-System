
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
class EmployeeTableInsert {
    //Insertion_ID_Set Insertion_ID_Set_class;
     
    
    static double scene_width;
    static double scene_height;
    
    Group grp;
    
    
    Text employee_id_txt;
    Text employee_name_txt;
    Text employee_sex_txt;
    Text employee_adrs_txt;
    Text employee_manager_name_txt;
    Text employee_phn_txt ;
    Text employee_email_txt;
    Text employee_salary_txt;
    Text employee_username_txt;
    Text employee_password_txt;
    Text employee_dateOf_birth_txt;
    Text employee_join_date_txt;
    Text employee_end_date_txt;
    
    
    TextField employee_id_txtf;
    TextField employee_name_txtf;
    TextField employee_adrs_txtf;
    TextField employee_manager_name_txtf;
    TextField employee_phn_txtf;
    TextField employee_email_txtf;
    TextField employee_salary_txtf;
    TextField employee_username_txtf;
    TextField employee_dateOf_birth_txtf;
    PasswordField employee_password_txtf ;
    TextField employee_join_date_txtf;
    TextField employee_end_date_txtf;
    
    ToggleGroup toggle_grp_employee_sex;
    RadioButton employee_sex_rbtn_male;
    RadioButton employee_sex_rbtn_female;
    RadioButton employee_sex_rbtn_other;
    


    
    EmployeeTableInsert() 
    {
        this.scene_height = 850;
        this.scene_width = 1000;
        //this.Insertion_ID_Set_class= new Insertion_ID_Set();
        
        
        this.grp= new Group();

    
        employee_id_txt = new Text("Employee_ID");
        employee_id_txt.setLayoutX(scene_width-900);
        employee_id_txt.setLayoutY(scene_height-730);
        employee_id_txt.setFill(Color.BLACK);
        employee_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        employee_name_txt = new Text("Employee name");
        employee_name_txt.setLayoutX(scene_width-900);
        employee_name_txt.setLayoutY(scene_height-730);
        employee_name_txt.setFill(Color.BLACK);
        employee_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_manager_name_txt = new Text("Manager name");
        employee_manager_name_txt.setLayoutX(scene_width-900);
        employee_manager_name_txt.setLayoutY(scene_height-680);
        employee_manager_name_txt.setFill(Color.BLACK);
        employee_manager_name_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));

        employee_sex_txt = new Text("Sex");
        employee_sex_txt.setLayoutX(scene_width-900);
        employee_sex_txt.setLayoutY(scene_height-630);
        employee_sex_txt.setFill(Color.BLACK);
        employee_sex_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        employee_adrs_txt = new Text("Address");
        employee_adrs_txt.setLayoutX(scene_width-900);
        employee_adrs_txt.setLayoutY(scene_height-580);
        employee_adrs_txt.setFill(Color.BLACK);
        employee_adrs_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        employee_phn_txt = new Text("Phone_no");
        employee_phn_txt.setLayoutX(scene_width-900);
        employee_phn_txt.setLayoutY(scene_height-530);
        employee_phn_txt.setFill(Color.BLACK);
        employee_phn_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        employee_email_txt = new Text("Email_ID");
        employee_email_txt.setLayoutX(scene_width-900);
        employee_email_txt.setLayoutY(scene_height-480);
        employee_email_txt.setFill(Color.BLACK);
        employee_email_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));


        employee_salary_txt = new Text("Salary");
        employee_salary_txt.setLayoutX(scene_width-900);
        employee_salary_txt.setLayoutY(scene_height-430);
        employee_salary_txt.setFill(Color.BLACK);
        employee_salary_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_username_txt = new Text("Username");
        employee_username_txt.setLayoutX(scene_width-900);
        employee_username_txt.setLayoutY(scene_height-380);
        employee_username_txt.setFill(Color.BLACK);
        employee_username_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_password_txt = new Text("Password");
        employee_password_txt.setLayoutX(scene_width-900);
        employee_password_txt.setLayoutY(scene_height-330);
        employee_password_txt.setFill(Color.BLACK);
        employee_password_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_dateOf_birth_txt = new Text("Date of birth");
        employee_dateOf_birth_txt.setLayoutX(scene_width-900);
        employee_dateOf_birth_txt.setLayoutY(scene_height-280);
        employee_dateOf_birth_txt.setFill(Color.BLACK);
        employee_dateOf_birth_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_join_date_txt = new Text("Joining");
        employee_join_date_txt.setLayoutX(scene_width-900);
        employee_join_date_txt.setLayoutY(scene_height-230);
        employee_join_date_txt.setFill(Color.BLACK);
        employee_join_date_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        employee_end_date_txt = new Text("Retirement");
        employee_end_date_txt.setLayoutX(scene_width-900);
        employee_end_date_txt.setLayoutY(scene_height-180);
        employee_end_date_txt.setFill(Color.BLACK);
        employee_end_date_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        

        employee_id_txtf = new TextField();
        employee_id_txtf.setPromptText("Enter Employee_ID");
        employee_id_txtf.setPrefColumnCount(10);
        employee_id_txtf.setLayoutX(scene_width-700);
        employee_id_txtf.setLayoutY(scene_height-750);

        employee_name_txtf = new TextField();
        employee_name_txtf.setPromptText("Enter Employee_name");
        employee_name_txtf.setPrefColumnCount(10);
        employee_name_txtf.setLayoutX(scene_width-700);
        employee_name_txtf.setLayoutY(scene_height-750);
        
        
        employee_manager_name_txtf = new TextField();
        employee_manager_name_txtf.setPromptText("Enter Manager_name");
        employee_manager_name_txtf.setPrefColumnCount(10);
        employee_manager_name_txtf.setLayoutX(scene_width-700);
        employee_manager_name_txtf.setLayoutY(scene_height-700);



        employee_adrs_txtf = new TextField();
        employee_adrs_txtf.setPromptText("Enter Address");
        employee_adrs_txtf.setPrefColumnCount(10);
        employee_adrs_txtf.setLayoutX(scene_width-700);
        employee_adrs_txtf.setLayoutY(scene_height-600);

        employee_phn_txtf = new TextField();
        employee_phn_txtf.setPromptText("Enter Phone no");
        employee_phn_txtf.setPrefColumnCount(10);
        employee_phn_txtf.setLayoutX(scene_width-700);
        employee_phn_txtf.setLayoutY(scene_height-550);

        employee_email_txtf = new TextField();
        employee_email_txtf.setPromptText("Enter Email_ID");
        employee_email_txtf.setPrefColumnCount(10);
        employee_email_txtf.setLayoutX(scene_width-700);
        employee_email_txtf.setLayoutY(scene_height-500);


        employee_salary_txtf = new TextField();
        employee_salary_txtf.setPromptText("Enter Salary");
        employee_salary_txtf.setPrefColumnCount(10);
        employee_salary_txtf.setLayoutX(scene_width-700);
        employee_salary_txtf.setLayoutY(scene_height-450);
        
        employee_username_txtf = new TextField();
        employee_username_txtf.setPromptText("Enter user name");
        employee_username_txtf.setPrefColumnCount(10);
        employee_username_txtf.setLayoutX(scene_width-700);
        employee_username_txtf.setLayoutY(scene_height-400);
        
        
        employee_password_txtf = new PasswordField();
        employee_password_txtf.setPromptText("Enter password");
        employee_password_txtf.setPrefColumnCount(10);
        employee_password_txtf.setLayoutX(scene_width-700);
        employee_password_txtf.setLayoutY(scene_height-350);
        
        
        employee_dateOf_birth_txtf = new TextField();
        employee_dateOf_birth_txtf.setPromptText("Format dd-mon-yy");
        employee_dateOf_birth_txtf.setPrefColumnCount(10);
        employee_dateOf_birth_txtf.setLayoutX(scene_width-700);
        employee_dateOf_birth_txtf.setLayoutY(scene_height-300);
        
        
        employee_join_date_txtf = new TextField();
        employee_join_date_txtf.setPromptText("Format dd-mon-yy");
        employee_join_date_txtf.setPrefColumnCount(10);
        employee_join_date_txtf.setLayoutX(scene_width-700);
        employee_join_date_txtf.setLayoutY(scene_height-250);
        
        employee_end_date_txtf = new TextField();
        employee_end_date_txtf.setPromptText("Format dd-mon-yy");
        employee_end_date_txtf.setPrefColumnCount(10);
        employee_end_date_txtf.setLayoutX(scene_width-700);
        employee_end_date_txtf.setLayoutY(scene_height-200);
        
        
        
        
        
        toggle_grp_employee_sex= new ToggleGroup();
        
        employee_sex_rbtn_male = new RadioButton();
        employee_sex_rbtn_male.setLayoutX(scene_width-700);
        employee_sex_rbtn_male.setLayoutY(scene_height-650);
        employee_sex_rbtn_male.setText("Male");
        employee_sex_rbtn_male.setUserData("Male");
        employee_sex_rbtn_male.setToggleGroup(toggle_grp_employee_sex);

        
        
        employee_sex_rbtn_female = new RadioButton();
        employee_sex_rbtn_female.setLayoutX(scene_width-630);
        employee_sex_rbtn_female.setLayoutY(scene_height-650);
        employee_sex_rbtn_female.setText("Female");
        employee_sex_rbtn_female.setUserData("Female");
        employee_sex_rbtn_female.setToggleGroup(toggle_grp_employee_sex);
        
        employee_sex_rbtn_other = new RadioButton();
        employee_sex_rbtn_other.setLayoutX(scene_width-540);
        employee_sex_rbtn_other.setLayoutY(scene_height-650);
        employee_sex_rbtn_other.setText("Other");
        employee_sex_rbtn_other.setUserData("Other");
        employee_sex_rbtn_other.setToggleGroup(toggle_grp_employee_sex);

        
       toggle_grp_employee_sex.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (toggle_grp_employee_sex.getSelectedToggle() != null) {
          System.out.println(toggle_grp_employee_sex.getSelectedToggle().getUserData().toString());
        }
      }
    });
       

        
       
//    grp.getChildren().addAll(employee_name_txt,
//                employee_name_txtf,
//                employee_manager_name_txt,
//                employee_manager_name_txtf,
//                employee_sex_txt,
//                employee_sex_rbtn_male,
//                employee_sex_rbtn_female,
//                employee_sex_rbtn_other,
//                employee_adrs_txt,
//                employee_adrs_txtf,
//                employee_phn_txt,
//                employee_phn_txtf,
//                employee_email_txt,
//                employee_email_txtf,
//                employee_salary_txt,
//                employee_salary_txtf,
//                employee_username_txt,
//                employee_username_txtf,
//                employee_password_txt,
//                employee_password_txtf,
//                employee_dateOf_birth_txt,
//                employee_dateOf_birth_txtf,
//                employee_join_date_txt,
//                employee_join_date_txtf,
//                employee_end_date_txt,
//                employee_end_date_txtf);


grp.getChildren().addAll(employee_name_txt,
                employee_name_txtf,
                employee_manager_name_txt,
                employee_manager_name_txtf,
                employee_sex_txt,
                employee_sex_rbtn_male,
                employee_sex_rbtn_female,
                employee_sex_rbtn_other,
                employee_adrs_txt,
                employee_adrs_txtf,
                employee_phn_txt,
                employee_phn_txtf,
                employee_email_txt,
                employee_email_txtf,
                employee_salary_txt,
                employee_salary_txtf,
                employee_username_txt,
                employee_username_txtf,
                employee_password_txt,
                employee_password_txtf,
                employee_dateOf_birth_txt,
                employee_dateOf_birth_txtf,
                employee_join_date_txt,
                employee_join_date_txtf,
                employee_end_date_txt,
                employee_end_date_txtf);
    }
}
 
        

        
        
