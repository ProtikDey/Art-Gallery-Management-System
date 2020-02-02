/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import database_project2.CustomerTableInsert;
import com.sun.corba.se.impl.io.IIOPInputStream;
import java.awt.BorderLayout;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author HP
 */
public class Database_project2 extends Application {
    Connection con;

    static double scene_width;
    static double scene_height;
    
    CustomerTableInsert CustomerTableInsertFromManager_class;
    CustomerTableInsert CustomerTableInsertFromEmployee_class;
    ArtistTableInsert ArtistTableInsertFromEmployee_class;
    ArtistTableInsert ArtistTableInsertFromManager_class;
    ArtTableInsert ArtTableInsertFromManager_class;
    ArtTableInsert ArtTableInsertFromEmployee_class;
    EmployeeTableInsert EmployeeTableInsertFromManager_class;
    ExhibitionTableInsert ExhibitionTableInsertFromManager_class;
    ExhibitionTableInsert ExhibitionTableInsertFromEmployee_class;
     ExhibitionTableInsert ExhibitionTableInsertFromManager_addartclass;
    ExhibitionTableInsert ExhibitionTableInsertFromEmployee_addartclass;
    HallRoomTableInsert HallRoomTableInsertFromManager_class;
    EditProfile managerEditProfile_class;
    EditProfile employeeEditProfile_class;
    EditProfile artistEditProfile_class;
    EditProfile customerEditProfile_class;
    LoginCheck managerLoginCheck_class;
    LoginCheck employeeLoginCheck_class;
    LoginCheck artistLoginCheck_class;
    LoginCheck customerLoginCheck_class;
    BillTableInsert billTableInsertFromEmployee_class;
    InformationOf_anArt an_artInfo_from_manager_class;
    InformationOf_anEmployee one_employeeInfo_from_manager_class;
    InformationOf_aCustomer one_customerInfo_from_manager_class;
    InformationOf_anArtist one_artistInfo_from_manager_class;
    InformationOf_anArt one_artInfo_from_employee_class;
    //InformationOf_anEmployee one_employeeInfo_from_manager_class;
    InformationOf_aCustomer one_customerInfo_from_employee_class;
    InformationOf_anArtist one_artistInfo_from_employee_class;
    Artist_Profile artistProfile_class;
    Manager_Profile managerProfile_class;
    Employee_Profile employeeProfile_class;
    Customer_Profile customerProfile_class;
    

    private final String user="ART_GALLERY";
    private final String password="nirobdey";
    
    String ID= new String();


    public static void main(String[] args) {
        launch(args);
    }


    public  Database_project2() throws SQLException
    {
        try{
            //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            String dbURL2 = "jdbc:oracle:thin:@localhost:1521:orcl";
            //con = DriverManager.getConnection(dbURL2, user, password);
            con=DriverManager.getConnection(dbURL2,user,password);
        }catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Connection prbl");

        }
    }

    



    public void init() throws SQLException 
    {
        this.scene_height = 850;
        this.scene_width = 1000;
        
        this.CustomerTableInsertFromManager_class= new CustomerTableInsert();
        this.CustomerTableInsertFromEmployee_class= new CustomerTableInsert();
        this.ArtistTableInsertFromManager_class= new ArtistTableInsert();
        this.ArtistTableInsertFromEmployee_class= new ArtistTableInsert();
        this.ArtTableInsertFromManager_class= new ArtTableInsert();
        this.ArtTableInsertFromEmployee_class= new ArtTableInsert();
        this.EmployeeTableInsertFromManager_class = new EmployeeTableInsert();
        this.ExhibitionTableInsertFromManager_class=new ExhibitionTableInsert();
        this.ExhibitionTableInsertFromEmployee_class= new ExhibitionTableInsert();
        this.ExhibitionTableInsertFromManager_addartclass=new ExhibitionTableInsert();
        this.ExhibitionTableInsertFromEmployee_addartclass=new ExhibitionTableInsert();
        this.HallRoomTableInsertFromManager_class= new HallRoomTableInsert();
        this.managerEditProfile_class= new EditProfile();
        this.employeeEditProfile_class= new EditProfile();
        this.artistEditProfile_class= new EditProfile();
        this.customerEditProfile_class= new EditProfile();
        this.managerLoginCheck_class= new LoginCheck();
        this.employeeLoginCheck_class = new LoginCheck();
        this.artistLoginCheck_class= new LoginCheck();
        this.customerLoginCheck_class=new LoginCheck();
       
        this.billTableInsertFromEmployee_class=new BillTableInsert();
        this.an_artInfo_from_manager_class= new InformationOf_anArt();
        this.one_artInfo_from_employee_class=new InformationOf_anArt();
        this.one_employeeInfo_from_manager_class= new InformationOf_anEmployee();
        this.one_artistInfo_from_manager_class= new InformationOf_anArtist();
        this.one_artistInfo_from_employee_class=new InformationOf_anArtist();
        this.one_customerInfo_from_manager_class= new InformationOf_aCustomer();
        this.one_customerInfo_from_employee_class= new InformationOf_aCustomer();
        this.artistProfile_class= new Artist_Profile();
        this.managerProfile_class= new Manager_Profile();
        this.employeeProfile_class= new Employee_Profile();
        this.customerProfile_class= new Customer_Profile();
        
        
        



    }


     public  String[] customer_query() throws SQLException, ClassNotFoundException {
         
         String []output_all_customer = new String[100];
         for(int i=0;i<100;i++)
         {
             output_all_customer[i]="";
         }
         
         int i=0;
         
         //Connection con = null;
            System.out.println("enterd");
         try{

                        Statement stmt1= con.createStatement();

            String sqlquery="SELECT * FROM CUSTOMERS";
            
            
            
        
           ResultSet rs = stmt1.executeQuery(sqlquery);
           
            while(rs.next()){
                
                
                output_all_customer[i]=rs.getString(1)+ "   "+rs.getString(2)+ "    "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7)+"   "+rs.getString(8)+"   "+rs.getString(9);

                //output[i]=rs.getString(1)+ "  "+rs.getString(2);
                //query_show.setText("query");
                i++;
                
                
            }
            
            stmt1.close();
            //con.close();
        }catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Connection prbl");

        }
    
            

            return output_all_customer ;
      }
     
     public  String[] employees_under( ) throws SQLException,ClassNotFoundException{
         String []output_employees_under = new String[100];
         
         for(int i=0;i<100;i++){
             output_employees_under[i]="";
         }
         int i=0;
         
         try{
            // Statement stmt1=con.createStatement();
             String sqlcommand="SELECT * FROM EMPLOYEES WHERE MANAGER_ID=(SELECT MANAGER_ID FROM MANAGERS WHERE MANAGER_ID=?)";
             
             PreparedStatement pst78=con.prepareStatement(sqlcommand);
             pst78.setString(1, ID);


              ResultSet rs = pst78.executeQuery();
              System.out.println("after query");
           
            while(rs.next()){
                
                
                output_employees_under[i]=rs.getString(1)+ "   "+rs.getString(2)+ "    "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7)+"   "+rs.getString(8)+"   "+rs.getString(9);

                //output[i]=rs.getString(1)+ "  "+rs.getString(2);
                //query_show.setText("query");
                i++;
                System.out.println("hihihi");
                
                
            }
            
            pst78.close();
             
           
         }catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Connection prbl");
         
     } 
         return output_employees_under;
     }
     
     
     public String[] maritime_art() throws SQLException{
         
           String []output_maritime = new String[100];
         
         for(int i=0;i<100;i++){
             output_maritime[i]="";
         }
         int i=0;
         
     
            if(con!=null){
                    try{
                        String sqlcommand="SELECT ART_TITLE,FETCH_ARTIST(ARTIST_ID),DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE ART_GENRE='Maritime Art'";
                        PreparedStatement pst70=con.prepareStatement(sqlcommand);
                        
                        ResultSet rs=pst70.executeQuery();
                        
                        while(rs.next()){
                            output_maritime[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5);
                            i++;
                        }
                        
                        pst70.close();
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                        
                    }
                }
            
            return output_maritime;
            }
     
     
     
          public String[] symbolism() throws SQLException{
         
           String []output_symbolism = new String[100];
         
         for(int i=0;i<100;i++){
             output_symbolism[i]="";
         }
         int i=0;
         
     
            if(con!=null){
                    try{
                        String sqlcommand="SELECT ART_TITLE,FETCH_ARTIST(ARTIST_ID),DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE ART_GENRE='Symbolism'";
                        PreparedStatement pst70=con.prepareStatement(sqlcommand);
                        
                        ResultSet rs=pst70.executeQuery();
                        
                        while(rs.next()){
                            output_symbolism[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5);
                            i++;
                        }
                        
                        pst70.close();
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                        
                    }
                }
            
            return output_symbolism;
            }
     
          
          
        public String[] renaissance() throws SQLException{
         
           String []output_renaissance = new String[100];
         
         for(int i=0;i<100;i++){
             output_renaissance[i]="";
         }
         int i=0;
         
     
            if(con!=null){
                    try{
                        String sqlcommand="SELECT ART_TITLE,FETCH_ARTIST(ARTIST_ID),DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE ART_GENRE='Renaissance'";
                        PreparedStatement pst70=con.prepareStatement(sqlcommand);
                        
                        ResultSet rs=pst70.executeQuery();
                        
                        while(rs.next()){
                            output_renaissance[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5);
                            i++;
                        }
                        
                        pst70.close();
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                        
                    }
                }
            
            return output_renaissance;
            }
        
        
        
         public String[] fauvism() throws SQLException{
         
           String []output_fauvism = new String[100];
         
         for(int i=0;i<100;i++){
             output_fauvism[i]="";
         }
         int i=0;
         
     
            if(con!=null){
                    try{
                        String sqlcommand="SELECT ART_TITLE,FETCH_ARTIST(ARTIST_ID),DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE ART_GENRE='Fauvism'";
                        PreparedStatement pst70=con.prepareStatement(sqlcommand);
                        
                        ResultSet rs=pst70.executeQuery();
                        
                        while(rs.next()){
                            output_fauvism[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5);
                            i++;
                        }
                        
                        pst70.close();
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                        
                    }
                }
            
            return output_fauvism;
            }
         
         
        public String[] post_modern() throws SQLException{
         
           String []output_post_modern = new String[100];
         
         for(int i=0;i<100;i++){
             output_post_modern[i]="";
         }
         int i=0;
         
     
            if(con!=null){
                    try{
                        String sqlcommand="SELECT ART_TITLE,FETCH_ARTIST(ARTIST_ID),DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE ART_GENRE='Post Modern'";
                        PreparedStatement pst70=con.prepareStatement(sqlcommand);
                        
                        ResultSet rs=pst70.executeQuery();
                        
                        while(rs.next()){
                            output_post_modern[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5);
                            i++;
                        }
                        
                        pst70.close();
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                        
                    }
                }
            
            return output_post_modern;
            }
        
        
        public String[] less2k() throws SQLException{
         
           String []output_less2k = new String[100];
         
         for(int i=0;i<100;i++){
             output_less2k[i]="";
         }
         int i=0;
         
     
            if(con!=null){
                    try{
                        String sqlcommand="SELECT ART_TITLE,FETCH_ARTIST(ARTIST_ID),ART_GENRE,DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE PRICE<2000";
                        PreparedStatement pst70=con.prepareStatement(sqlcommand);
                        
                        ResultSet rs=pst70.executeQuery();
                        
                        System.out.println("2k");
                        
                        while(rs.next()){
                            output_less2k[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6);
                            i++;
                        }
                        System.out.println("22k");
                        
                        pst70.close();
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                        
                    }
                }
            
            return output_less2k;
            }
        
        
        
         public String[] from_2_5() throws SQLException{
         
           String []output_2k_5k = new String[100];
         
         for(int i=0;i<100;i++){
             output_2k_5k[i]="";
         }
         int i=0;
         
     
            if(con!=null){
                    try{
                        String sqlcommand="SELECT ART_TITLE,FETCH_ARTIST(ARTIST_ID),ART_GENRE,DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE PRICE BETWEEN 2000 AND 5000";
                        PreparedStatement pst70=con.prepareStatement(sqlcommand);
                        
                        ResultSet rs=pst70.executeQuery();
                        
                        while(rs.next()){
                            output_2k_5k[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6);
                            i++;
                        }
                        
                        pst70.close();
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                        
                    }
                }
            
            return output_2k_5k;
            }
         
         
         
        public String[] more5k() throws SQLException{
         
           String []output_more5k = new String[100];
         
         for(int i=0;i<100;i++){
             output_more5k[i]="";
         }
         int i=0;
         
     
            if(con!=null){
                    try{
                        String sqlcommand="SELECT ART_TITLE,FETCH_ARTIST(ARTIST_ID),ART_GENRE,DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE PRICE>5000";
                        PreparedStatement pst70=con.prepareStatement(sqlcommand);
                        
                        ResultSet rs=pst70.executeQuery();
                        
                        while(rs.next()){
                            output_more5k[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6);
                            i++;
                        }
                        
                        pst70.close();
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                        
                    }
                }
            
            return output_more5k;
            }
        
        
        public String[] payslip_mine()throws SQLException{
            
            String []output_payslip=new String[100];
            
            for(int i=0;i<100;i++){
                output_payslip[i]="";
                
            }
            
            int i=0;
            
            if(con!=null){
                try{
                    
                    String sqlcommand="SELECT PAYSLIP_ID,ART_ID,FETCH_ART(ART_ID),PAYSLIP_DATE,PAYSLIP_AMOUNT FROM PAYSLIP WHERE ARTIST_ID=?";
                    PreparedStatement pst50=con.prepareStatement(sqlcommand);
                    
                    pst50.setString(1, ID);
                    
                    ResultSet rs=pst50.executeQuery();
                    System.out.println("llllllllllllllllllll");
                    System.out.println(ID);
                    
                    while(rs.next()){
                        
                        output_payslip[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5);
                        i++;
                        System.out.println("pppppppppppppppp");
                    }
                    
                }catch(SQLClientInfoException e){
                    System.out.println(e.toString());
                    System.out.println("in pay exception");
                          
                }
            }
            
            return output_payslip;
        }
        
        
        public String[] bills_mine() throws SQLException{
            
            String []output_bill=new String[100];
            
            for(int i=0;i<100;i++){
                
                output_bill[i]="";
            }
            
            int i=0;
            
            if(con!=null){
                
                try{
                    
                    String sqlcommand="SELECT BILL_ID,CUSTOMER_ID,FETCH_CUSTOMER(CUSTOMER_ID),ART_ID,FETCH_ART(ART_ID),ARTIST_ID,FETCH_ARTIST(ARTIST_ID),BILL_DATE,BILL_AMOUNT FROM BILL WHERE CUSTOMER_ID=? ";
                    
                    PreparedStatement pst100=con.prepareStatement(sqlcommand);
                    
                    pst100.setString(1,ID);
                    
                    ResultSet rs= pst100.executeQuery();
                    System.out.println("jjjjjjjjjjj");
                    
                    while(rs.next()){
                        output_bill[i]=rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9);
                        i++;
                        System.out.println("kkkkkkkkkkkk");
                    }
                    pst100.close();
                }catch(SQLException e){
                    System.out.println(e.toString());
                }
            }
            
            return output_bill;
                   
            
        }
        
        public String[] current_ex() throws SQLClientInfoException {
        String []output_cex=new String [100];
        
        for(int i=0;i<100;i++){
            output_cex[i]="";
        }
        
        int i=0;
        
        if(con!=null){
            
            try{
                
                String sqlcommand="SELECT EXHIBITION_NAME,FETCH_HALL(HALL_ID),START_DATE,END_DATE FROM EXHIBITIONS WHERE  SYSDATE BETWEEN START_DATE AND END_DATE";
                
                PreparedStatement pst20=con.prepareStatement(sqlcommand);
                
                ResultSet rs=pst20.executeQuery();
                
                while(rs.next()){
                    output_cex[i]=rs.getString(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getString(4);
                }
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        
        return output_cex;
    
    
}
     
     
    public String[] past_ex() throws SQLClientInfoException {
        String []output_pex=new String [100];
        
        for(int i=0;i<100;i++){
            output_pex[i]="";
        }
        
        int i=0;
        
        if(con!=null){
            
            try{
                
                String sqlcommand="SELECT EXHIBITION_NAME,FETCH_HALL(HALL_ID),START_DATE,END_DATE FROM EXHIBITIONS WHERE  END_DATE<SYSDATE";
                
                PreparedStatement pst20=con.prepareStatement(sqlcommand);
                
                ResultSet rs=pst20.executeQuery();
                
                while(rs.next()){
                    output_pex[i]=rs.getString(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getString(4);
                }
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        
        return output_pex;
    
    
}
         public String[] up_ex() throws SQLClientInfoException {
        String []output_uex=new String [100];
        
        for(int i=0;i<100;i++){
            output_uex[i]="";
        }
        
        int i=0;
        
        if(con!=null){
            
            try{
                
                String sqlcommand="SELECT EXHIBITION_NAME,FETCH_HALL(HALL_ID),START_DATE,END_DATE FROM EXHIBITIONS WHERE  START_DATE>SYSDATE";
                
                PreparedStatement pst20=con.prepareStatement(sqlcommand);
                
                ResultSet rs=pst20.executeQuery();
                
                while(rs.next()){
                    output_uex[i]=rs.getString(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getString(4);
                }
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        
        return output_uex;
    
    
}
         
//         public String Set_Customer_ID() throws SQLException{
//        String output_customer_ID= new String();
//        
//        if(con!=null){
//                    try{
//                        String sqlcommand="SELECT MAX(CUSTOMER_ID) FROM CUSTOMERS";
//                        PreparedStatement pst110=con.prepareStatement(sqlcommand);
//                        
//                        ResultSet rs=pst110.executeQuery();
//                        
//                        while(rs.next()){
//                            output_customer_ID=rs.getString(1);
//                            
//                        }
//                        
//                        pst110.close();
//                        
//                    }catch(SQLException e){
//                        System.out.println(e.toString());
//                        
//                        
//                    }
//                }
//        System.out.println("inserted at ID set");
//        System.out.println(output_customer_ID);
//            
//            return output_customer_ID;
//            }
     
     
     
     

//public String[] arts_of_artist() throws SQLException,ClassNotFoundException {
//         
//          String []output_arts_of_artist = new String[100];
//         
//         for(int i=0;i<100;i++){
//             output_arts_of_artist[i]="";
//         }
//         int i=0;
//         
//         try{
//             Statement stmt2=con.createStatement();
//             String sqlcommand="SELECT A1.Artist_name ,A2.Price,A2.Status FROM Artists A1 JOIN Arts A2 ON (A1.Artist_Id=A2.Artist_Id) WHERE A1.Artist_ID=3";
//            
//             
//              ResultSet rs = stmt2.executeQuery(sqlcommand);
//           
//            while(rs.next()){
//                
//                
//                output_arts_of_artist[i]=rs.getString(1)+ "   "+rs.getString(2)+ "    "+rs.getString(3);//+"   "+rs.getString(6)+"   "+rs.getString(7)+"   "+rs.getString(8)+"   "+rs.getString(9);
//
//                //output[i]=rs.getString(1)+ "  "+rs.getString(2);
//                //query_show.setText("query");
//                i++;
//                
//                
//            }
//            
//            stmt2.close();
//             
//           
//         }catch (SQLException e) {
//            System.out.println(e.toString());
//            System.out.println("Connection prbl");
//         
//     } 
//         return output_arts_of_artist;
//         
//}









    @Override
    public void start(Stage myStage) throws SQLException, ClassNotFoundException {


        Group first_grp = new Group();
        Scene first_scene = new Scene(first_grp, scene_width,scene_height);
        
        Group login_page_grp = new Group();
        Scene login_page_scene = new Scene(login_page_grp,scene_width, scene_height);


//        Group second_grp= new Group();
//        Scene second_scene = new Scene(second_grp, scene_width,scene_height);
//
//        Group insert_grp = new Group();
//        Scene insert_scene= new Scene (insert_grp, scene_width,scene_height);
//
//        Group query_grp =new Group();
//        Scene query_scene = new Scene(query_grp,scene_width,scene_height);

        Group customer_table_insert_from_manager_grp = new Group();
        Scene customer_table_insert_from_manager_scene= new Scene(customer_table_insert_from_manager_grp,scene_width,scene_height);
        
        
        Group customer_table_insert_from_employee_grp = new Group();
        Scene customer_table_insert_from_employee_scene = new Scene(customer_table_insert_from_employee_grp,scene_width,scene_height);
        
        Group artist_table_insert_from_manager_grp= new Group();
        Scene artist_table_insert_from_manager_scene=new Scene(artist_table_insert_from_manager_grp,scene_width,scene_height);
        
        Group artist_table_insert_from_employee_grp= new Group();
        Scene artist_table_insert_from_employee_scene=new Scene(artist_table_insert_from_employee_grp,scene_width,scene_height);
        
        
        Group art_table_insert_from_manager_grp= new Group();
        Scene art_table_insert_from_manager_scene= new Scene(art_table_insert_from_manager_grp,scene_width,scene_height);
        
        Group employee_table_insert_from_manager_grp=new Group();
        Scene employee_table_insert_from_manager_scene=new Scene(employee_table_insert_from_manager_grp,scene_width,scene_height);
//        
        Group art_table_insert_from_employee_grp= new Group();
        Scene art_table_insert_from_employee_scene= new Scene(art_table_insert_from_employee_grp,scene_width,scene_height);
        
        Group exhibition_table_insert_from_manager_grp=new Group();
        Scene exhibition_table_insert_from_manager_scene= new Scene(exhibition_table_insert_from_manager_grp,scene_width,scene_height);
        
        
        Group exhibition_table_insert_from_manager_addartgrp=new Group();
        Scene exhibition_table_insert_from_manager_addartscne =new Scene(exhibition_table_insert_from_manager_addartgrp,scene_width,scene_height);
        
        Group exhibition_table_insert_from_employee_addartgrp=new Group();
        Scene exhibition_table_insert_from_employee_addartscne =new Scene(exhibition_table_insert_from_employee_addartgrp,scene_width,scene_height);
        
        Group exhibition_table_insert_from_employee_grp=new Group();
        Scene exhibition_table_insert_from_employee_scene=new Scene(exhibition_table_insert_from_employee_grp,scene_width,scene_height);

        
        Group hallroom_table_insert_from_manager_grp= new Group();
        Scene hallroom_table_insert_from_manager_scene= new Scene(hallroom_table_insert_from_manager_grp,scene_width,scene_height);
        
        Group bill_table_insert_from_employee_grp = new Group();
        Scene bill_table_insert_from_employee_scene = new Scene(bill_table_insert_from_employee_grp,scene_width,scene_height);
        
        
        
        Group customer_table_show_from_manager_grp = new Group();
        Scene customer_table_show_from_manager_scene = new Scene(customer_table_show_from_manager_grp,scene_width,scene_height);
        
               
        Group manager_login_check_grp = new Group();
        Scene manager_login_check_scene= new Scene ( manager_login_check_grp,scene_width,scene_height);
        
        Group manager_homepage_grp = new Group();
        Scene manager_homepage_scene = new Scene(manager_homepage_grp,scene_width,scene_height);
        
        Group manager_profile_grp = new Group();
        Scene manager_profile_scene = new Scene(manager_profile_grp,scene_width,scene_height);
        
        Group manager_edit_profile_grp = new Group();
        Scene manager_edit_profile_scene = new Scene(manager_edit_profile_grp,scene_width,scene_height);
        
        Group manager_insertTables_grp = new Group();
        Scene manager_insertTables_scene = new Scene(manager_insertTables_grp,scene_width,scene_height);
        
        Group manager_showTables_grp = new Group();
        Scene manager_showTables_scene = new Scene(manager_showTables_grp,scene_width,scene_height);
        
        Group manager_query_page_grp = new Group();
        Scene manager_query_page_scene  = new Scene(manager_query_page_grp,scene_width,scene_height);
        
        Group manager_employeesUnderMe_grp= new Group();
        Scene manager_employeesUnderMe_scene = new Scene(manager_employeesUnderMe_grp,scene_width,scene_height);
        
        Group manager_employeeInfo_grp = new Group();
        Scene manager_employeeInfo_scene = new Scene (manager_employeeInfo_grp,scene_width,scene_height);
        
        Group manager_customerInfo_grp = new Group();
        Scene manager_customerInfo_scene = new Scene(manager_customerInfo_grp,scene_width,scene_height);
        
        Group manager_artistInfo_grp = new Group();
        Scene manager_artistInfo_scene = new Scene(manager_artistInfo_grp,scene_width,scene_height);
        
        Group manager_artInfo_grp = new Group();
        Scene manager_artInfo_scene = new Scene(manager_artInfo_grp,scene_width,scene_height);
        
        Group manager_artsOfartist_grp = new Group();
        Scene manager_artsOfartist_scene = new Scene(manager_artsOfartist_grp,scene_width,scene_height);
        
        Group manager_artStatus_grp = new Group();
        Scene manager_artStatus_scene = new Scene(manager_artStatus_grp,scene_width,scene_height);
        
        Group manager_bill_from_date_grp= new Group();
        Scene manager_bill_from_date_scene= new Scene(manager_bill_from_date_grp,scene_width,scene_height);
        
        
        
        Group employee_login_check_grp = new Group();
        Scene employee_login_check_scene = new Scene(employee_login_check_grp,scene_width,scene_height);
        
        Group employee_homepage_grp = new Group();
        Scene employee_homepage_scene = new Scene(employee_homepage_grp,scene_width,scene_height);
        
        Group employee_insertTables_grp = new Group();
        Scene employee_insertTables_scene = new Scene(employee_insertTables_grp,scene_width,scene_height);
        
        Group employee_edit_profile_grp = new Group();
        Scene employee_edit_profile_scene = new Scene(employee_edit_profile_grp,scene_width,scene_height);
        
        Group employee_profile_grp = new Group();
        Scene employee_profile_scene = new Scene(employee_profile_grp,scene_width,scene_height);
        
        Group employee_query_page_grp = new Group();
        Scene employee_query_page_scene  = new Scene(employee_query_page_grp,scene_width,scene_height);
              
        Group employee_customerInfo_grp = new Group();
        Scene employee_customerInfo_scene = new Scene(employee_customerInfo_grp,scene_width,scene_height);
        
        Group employee_artistInfo_grp = new Group();
        Scene employee_artistInfo_scene = new Scene(employee_artistInfo_grp,scene_width,scene_height);
        
        Group employee_artInfo_grp = new Group();
        Scene employee_artInfo_scene = new Scene(employee_artInfo_grp,scene_width,scene_height);
        
        Group employee_artsOfartist_grp = new Group();
        Scene employee_artsOfartist_scene = new Scene(employee_artsOfartist_grp,scene_width,scene_height);
        
        Group employee_artStatus_grp = new Group();
        Scene employee_artStatus_scene = new Scene(employee_artStatus_grp,scene_width,scene_height);
        
        
        
        
        Group artist_login_check_grp = new Group();
        Scene artist_login_check_scene = new Scene(artist_login_check_grp,scene_width,scene_height);
        
        Group artist_homepage_grp = new Group();
        Scene artist_homepage_scene = new Scene(artist_homepage_grp,scene_width,scene_height);
        
        Group artist_profile_grp= new Group();
        Scene artist_profile_scene = new Scene(artist_profile_grp,scene_width,scene_height);
        
        Group artist_edit_profile_grp= new Group();
        Scene artist_edit_profile_scene = new Scene(artist_edit_profile_grp,scene_width,scene_height);
        
        Group artist_query_grp= new Group();
        Scene artist_query_scene = new Scene(artist_query_grp,scene_width,scene_height);
        
        Group artist_current_exhibitions_page_grp= new Group();
        Scene artist_current_exhibitions_page_scene = new Scene(artist_current_exhibitions_page_grp,scene_width,scene_height);
        
        Group artist_upcoming_exhibitions_page_grp= new Group();
        Scene artist_upcoming_exhibitions_page_scene = new Scene(artist_upcoming_exhibitions_page_grp,scene_width,scene_height);
        
         Group artist_past_exhibitions_page_grp= new Group();
        Scene artist_past_exhibitions_page_scene = new Scene(artist_past_exhibitions_page_grp,scene_width,scene_height);
        
         Group artist_payslip_page_grp= new Group();
        Scene artist_payslip_page_scene = new Scene(artist_payslip_page_grp,scene_width,scene_height);
        
        Group artist_artsOfartist_page_grp= new Group();
        Scene artist_artsOfartist_page_scene = new Scene(artist_artsOfartist_page_grp,scene_width,scene_height);
        
        Group artist_artsBYprice_upto2k_page_grp= new Group();
        Scene artist_artsBYprice_upto2k_page_scene = new Scene(artist_artsBYprice_upto2k_page_grp,scene_width,scene_height);
        
        Group artist_artsBYprice_2kto5k_page_grp= new Group();
        Scene artist_artsBYprice_2kto5k_page_scene = new Scene(artist_artsBYprice_2kto5k_page_grp,scene_width,scene_height);
        
        Group artist_artsBYprice_above5k_page_grp= new Group();
        Scene artist_artsBYprice_above5k_page_scene = new Scene(artist_artsBYprice_above5k_page_grp,scene_width,scene_height);
        
        Group artist_artsBYtype_maritime_page_grp= new Group();
        Scene artist_artsBYtype_maritime_page_scene = new Scene(artist_artsBYtype_maritime_page_grp,scene_width,scene_height);
        
        Group artist_artsBYtype_symbolism_page_grp= new Group();
        Scene artist_artsBYtype_symbolism_page_scene = new Scene(artist_artsBYtype_symbolism_page_grp,scene_width,scene_height);
        
        Group artist_artsBYtype_renaissance_page_grp= new Group();
        Scene artist_artsBYtype_renaissance_page_scene = new Scene(artist_artsBYtype_renaissance_page_grp,scene_width,scene_height);
        
        Group artist_artsBYtype_fauvism_page_grp= new Group();
        Scene artist_artsBYtype_fauvism_page_scene = new Scene(artist_artsBYtype_fauvism_page_grp,scene_width,scene_height);
        
        Group artist_artsBYtype_postModern_page_grp= new Group();
        Scene artist_artsBYtype_postModern_page_scene = new Scene(artist_artsBYtype_postModern_page_grp,scene_width,scene_height);
        
        
        
        
        
        Group customer_login_check_grp = new Group();
        Scene customer_login_check_scene = new Scene(customer_login_check_grp,scene_width,scene_height);
        
        Group customer_homepage_grp = new Group();
        Scene customer_homepage_scene = new Scene(customer_homepage_grp,scene_width,scene_height);
        
        Group customer_profile_grp= new Group();
        Scene customer_profile_scene = new Scene(customer_profile_grp,scene_width,scene_height);
        
        Group customer_edit_profile_grp= new Group();
        Scene customer_edit_profile_scene = new Scene(customer_edit_profile_grp,scene_width,scene_height);
        
        Group customer_query_grp= new Group();
        Scene customer_query_scene = new Scene(customer_query_grp,scene_width,scene_height);
        
        Group customer_current_exhibitions_page_grp= new Group();
        Scene customer_current_exhibitions_page_scene = new Scene(customer_current_exhibitions_page_grp,scene_width,scene_height);
        
        Group customer_upcoming_exhibitions_page_grp= new Group();
        Scene customer_upcoming_exhibitions_page_scene = new Scene(customer_upcoming_exhibitions_page_grp,scene_width,scene_height);
        
         Group customer_past_exhibitions_page_grp= new Group();
        Scene customer_past_exhibitions_page_scene = new Scene(customer_past_exhibitions_page_grp,scene_width,scene_height);
        
         Group customer_bill_page_grp= new Group();
        Scene customer_bill_page_scene = new Scene(customer_bill_page_grp,scene_width,scene_height);
        
        Group customer_artsOfartist_page_grp= new Group();
        Scene customer_artsOfartist_page_scene = new Scene(customer_artsOfartist_page_grp,scene_width,scene_height);
        
        Group customer_artsBYprice_upto2k_page_grp= new Group();
        Scene customer_artsBYprice_upto2k_page_scene = new Scene(customer_artsBYprice_upto2k_page_grp,scene_width,scene_height);
        
        Group customer_artsBYprice_2kto5k_page_grp= new Group();
        Scene customer_artsBYprice_2kto5k_page_scene = new Scene(customer_artsBYprice_2kto5k_page_grp,scene_width,scene_height);
        
        Group customer_artsBYprice_above5k_page_grp= new Group();
        Scene customer_artsBYprice_above5k_page_scene = new Scene(customer_artsBYprice_above5k_page_grp,scene_width,scene_height);
        
        Group customer_artsBYtype_maritime_page_grp= new Group();
        Scene customer_artsBYtype_maritime_page_scene = new Scene(customer_artsBYtype_maritime_page_grp,scene_width,scene_height);
        
        Group customer_artsBYtype_symbolism_page_grp= new Group();
        Scene customer_artsBYtype_symbolism_page_scene = new Scene(customer_artsBYtype_symbolism_page_grp,scene_width,scene_height);
        
        Group customer_artsBYtype_renaissance_page_grp= new Group();
        Scene customer_artsBYtype_renaissance_page_scene = new Scene(customer_artsBYtype_renaissance_page_grp,scene_width,scene_height);
        
        Group customer_artsBYtype_fauvism_page_grp= new Group();
        Scene customer_artsBYtype_fauvism_page_scene = new Scene(customer_artsBYtype_fauvism_page_grp,scene_width,scene_height);
        
        Group customer_artsBYtype_postModern_page_grp= new Group();
        Scene customer_artsBYtype_postModern_page_scene = new Scene(customer_artsBYtype_postModern_page_grp,scene_width,scene_height);
        
        
        
        
        
        
        
        
        Group guest_homepage_grp = new Group();
        Scene guest_homepage_scene = new Scene (guest_homepage_grp,scene_width,scene_height);
        
        Group guest_current_exhibitions_page_grp= new Group();
        Scene guest_current_exhibitions_page_scene = new Scene(guest_current_exhibitions_page_grp,scene_width,scene_height);
        
        Group guest_upcoming_exhibitions_page_grp= new Group();
        Scene guest_upcoming_exhibitions_page_scene = new Scene(guest_upcoming_exhibitions_page_grp,scene_width,scene_height);
        
         Group guest_past_exhibitions_page_grp= new Group();
        Scene guest_past_exhibitions_page_scene = new Scene(guest_past_exhibitions_page_grp,scene_width,scene_height);
        
        
        
                
        
        

        ImageView front_image = new ImageView("file:front_image.jpg");
        front_image.setFitWidth(scene_width);
        front_image.setFitHeight(scene_height);

        ImageView login_page_backgrnd_image = new ImageView("file:gallery_wall.jpg");
        login_page_backgrnd_image.setFitWidth(scene_width);
        login_page_backgrnd_image.setFitHeight(scene_height);

        
        ImageView back_btn_img = new ImageView("file:back-button.png");
        back_btn_img.setFitWidth(60);
        back_btn_img.setFitHeight(45);
        
        ImageView logout_btn_img = new ImageView("file:logout-button1.png");
        logout_btn_img.setFitWidth(80);
        logout_btn_img.setFitHeight(38);
        
        ImageView home_btn_img= new ImageView("file:homepage_icon.png");
        home_btn_img.setFitWidth(90);
        home_btn_img.setFitHeight(30);


//        ImageView log_in_img = new ImageView("file:Member-Login-Button.png");
//        log_in_img.setFitHeight(30);
//        log_in_img.setFitWidth(100);


        Text Name = new Text("JOYNUL ART GALLERY ");
        Name.setLayoutX(scene_width-750);
        Name.setLayoutY(scene_height-50);
        Name.setFill(Color.ALICEBLUE);
        Name.setFont(Font.font("Algerian", FontWeight.BOLD, 50));


//        Text Name2 = new Text("You have logged in!!!");
//        Name2.setLayoutX(scene_width-700);
//        Name2.setLayoutY(scene_height-800);
//        Name2.setFill(Color.CHOCOLATE);
//        Name2.setFont(Font.font("Algerian", FontWeight.BOLD, 30));

        Text login_page_txt = new Text("LOG IN AS ---");
        login_page_txt.setLayoutX(scene_width-700);
        login_page_txt.setLayoutY(scene_height-810);
        login_page_txt.setFill(Color.CHOCOLATE);
        login_page_txt.setFont(Font.font("Algerian", FontWeight.BOLD, 40));


//        Text manager_login_check_txt = new Text("ARE YOU A MANAGER?");
//        manager_login_check_txt.setLayoutX(scene_width-700);
//        manager_login_check_txt.setLayoutY(scene_height-800);
//        manager_login_check_txt.setFill(Color.CHOCOLATE);
//        manager_login_check_txt.setFont(Font.font("Algerian", FontWeight.BOLD, 40));
//        
//        
        Text insert_txt=new Text("INSERT");
        insert_txt.setFill(Color.BLUE);
        insert_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));

        Text query_txt=new Text("QUERY");
        query_txt.setFill(Color.BLUE);
        query_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text edit_profile_txt=new Text("EDIT PROFILE");
        edit_profile_txt.setFill(Color.BLUE);
        edit_profile_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text show_table_txt=new Text("SHOW TABLES");
        show_table_txt.setFill(Color.BLUE);
        show_table_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text changes_txt=new Text("SHOW CHANGES");
        changes_txt.setFill(Color.BLUE);
        changes_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        



        Text table_select_txt= new Text("SELECT TABLE");
        table_select_txt.setLayoutX(scene_width-900);
        table_select_txt.setLayoutY(scene_height-750);
        table_select_txt.setFill(Color.BLACK);
        table_select_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));

        Text customer_txt= new Text("CUSTOMER");
        customer_txt.setFill(Color.BLUE);
        customer_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));

        Text artist_txt= new Text("ARTIST");
        artist_txt.setFill(Color.BLUE);
        artist_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text manager_txt= new Text("MANAGER");
        manager_txt.setFill(Color.BLUE);
        manager_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text employee_txt= new Text("EMPLOYEE");
        employee_txt.setFill(Color.BLUE);
        employee_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text arts_txt= new Text("ARTS");
        arts_txt.setFill(Color.BLUE);
        arts_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
         Text hallroom_txt= new Text("HALLROOM");
        hallroom_txt.setFill(Color.BLUE);
        hallroom_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
         Text exhibiton_txt= new Text("EXHIBITION");
        exhibiton_txt.setFill(Color.BLUE);
        exhibiton_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text bill_txt= new Text("BILL");
        bill_txt.setFill(Color.BLUE);
        bill_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text payslip_txt= new Text("PAYSLIP");
        payslip_txt.setFill(Color.BLUE);
        payslip_txt.setFont(Font.font("Segoe Script",FontWeight.BOLD,30 ));
        
        Text manager_art_status_page_art_id_txt= new Text("Art ID");
        manager_art_status_page_art_id_txt.setLayoutX(scene_width-800);
        manager_art_status_page_art_id_txt.setLayoutY(scene_height-700);
        manager_art_status_page_art_id_txt.setFill(Color.BLACK);
        manager_art_status_page_art_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
        
        Text manager_art_status_page_status_txt= new Text();
        manager_art_status_page_status_txt.setLayoutX(scene_width-800);
        manager_art_status_page_status_txt.setLayoutY(scene_height-500);
        manager_art_status_page_status_txt.setFill(Color.BLACK);
        manager_art_status_page_status_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
        
        
        TextField manager_art_status_page_art_id_txf= new TextField();
        manager_art_status_page_art_id_txf.setPromptText("Enter Art_ID");
        manager_art_status_page_art_id_txf.setPrefColumnCount(10);
        manager_art_status_page_art_id_txf.setLayoutX(scene_width-800);
        manager_art_status_page_art_id_txf.setLayoutY(scene_height-650);
        
        
        Text employee_art_status_page_art_id_txt= new Text("Art ID");
        employee_art_status_page_art_id_txt.setLayoutX(scene_width-800);
        employee_art_status_page_art_id_txt.setLayoutY(scene_height-700);
        employee_art_status_page_art_id_txt.setFill(Color.BLACK);
        employee_art_status_page_art_id_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
        
        Text employee_art_status_page_status_txt= new Text();
        employee_art_status_page_status_txt.setLayoutX(scene_width-800);
        employee_art_status_page_status_txt.setLayoutY(scene_height-500);
        employee_art_status_page_status_txt.setFill(Color.BLACK);
        employee_art_status_page_status_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
        
        
        TextField employee_art_status_page_art_id_txf= new TextField();
        employee_art_status_page_art_id_txf.setPromptText("Enter Art_ID");
        employee_art_status_page_art_id_txf.setPrefColumnCount(10);
        employee_art_status_page_art_id_txf.setLayoutX(scene_width-800);
        employee_art_status_page_art_id_txf.setLayoutY(scene_height-650);
        
//        Text employeesUnderme_page_txt= new Text();
//        employeesUnderme_page_txt.setLayoutX(scene_width-800);
//        employeesUnderme_page_txt.setLayoutY(scene_height-700);
//        employeesUnderme_page_txt.setFill(Color.BLACK);
//        employeesUnderme_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
//        
        Text manager_employeeInfo_page_txt= new Text("EMPLOYEE ID");
        manager_employeeInfo_page_txt.setLayoutX(scene_width-800);
        manager_employeeInfo_page_txt.setLayoutY(scene_height-700);
        manager_employeeInfo_page_txt.setFill(Color.BLACK);
        manager_employeeInfo_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField manager_employeeInfo_page_txtf= new TextField();
        manager_employeeInfo_page_txtf.setPromptText("Enter Employee_ID");
        manager_employeeInfo_page_txtf.setPrefColumnCount(10);
        manager_employeeInfo_page_txtf.setLayoutX(scene_width-800);
        manager_employeeInfo_page_txtf.setLayoutY(scene_height-650);
        
//        Text manager_employeeInfo_page_result_txt= new Text();
//        manager_employeeInfo_page_result_txt.setLayoutX(scene_width-800);
//        manager_employeeInfo_page_result_txt.setLayoutY(scene_height-500);
//        manager_employeeInfo_page_result_txt.setFill(Color.BLACK);
//        manager_employeeInfo_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
//        
        Text managerr_customerInfo_page_txt= new Text("CUSTOMER ID");
        managerr_customerInfo_page_txt.setLayoutX(scene_width-800);
        managerr_customerInfo_page_txt.setLayoutY(scene_height-700);
        managerr_customerInfo_page_txt.setFill(Color.BLACK);
        managerr_customerInfo_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField managerr_customerInfo_page_txtf= new TextField();
        managerr_customerInfo_page_txtf.setPromptText("Enter Customer_ID");
        managerr_customerInfo_page_txtf.setPrefColumnCount(10);
        managerr_customerInfo_page_txtf.setLayoutX(scene_width-800);
        managerr_customerInfo_page_txtf.setLayoutY(scene_height-650);
        
        Text employee_customerInfo_page_txt= new Text("CUSTOMER ID");
        employee_customerInfo_page_txt.setLayoutX(scene_width-800);
        employee_customerInfo_page_txt.setLayoutY(scene_height-700);
        employee_customerInfo_page_txt.setFill(Color.BLACK);
        employee_customerInfo_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField employee_customerInfo_page_txtf= new TextField();
        employee_customerInfo_page_txtf.setPromptText("Enter Customer_ID");
        employee_customerInfo_page_txtf.setPrefColumnCount(10);
        employee_customerInfo_page_txtf.setLayoutX(scene_width-800);
        employee_customerInfo_page_txtf.setLayoutY(scene_height-650);
        
        
        Text manager_customerInfo_page_result_txt= new Text();
        manager_customerInfo_page_result_txt.setLayoutX(scene_width-800);
        manager_customerInfo_page_result_txt.setLayoutY(scene_height-500);
        manager_customerInfo_page_result_txt.setFill(Color.BLACK);
        manager_customerInfo_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
        
         Text managerr_artistInfo_page_txt= new Text("ARTIST ID");
        managerr_artistInfo_page_txt.setLayoutX(scene_width-800);
        managerr_artistInfo_page_txt.setLayoutY(scene_height-700);
        managerr_artistInfo_page_txt.setFill(Color.BLACK);
        managerr_artistInfo_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField managerr_artistInfo_page_txtf= new TextField();
        managerr_artistInfo_page_txtf.setPromptText("Enter Artist_ID");
        managerr_artistInfo_page_txtf.setPrefColumnCount(10);
        managerr_artistInfo_page_txtf.setLayoutX(scene_width-800);
        managerr_artistInfo_page_txtf.setLayoutY(scene_height-650);
        
        
        Text employee_artistInfo_page_txt= new Text("ARTIST ID");
        employee_artistInfo_page_txt.setLayoutX(scene_width-800);
        employee_artistInfo_page_txt.setLayoutY(scene_height-700);
        employee_artistInfo_page_txt.setFill(Color.BLACK);
        employee_artistInfo_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField employee_artistInfo_page_txtf= new TextField();
        employee_artistInfo_page_txtf.setPromptText("Enter Artist_ID");
        employee_artistInfo_page_txtf.setPrefColumnCount(10);
        employee_artistInfo_page_txtf.setLayoutX(scene_width-800);
        employee_artistInfo_page_txtf.setLayoutY(scene_height-650);
        
        
        Text manager_artistInfo_page_result_txt= new Text();
        manager_artistInfo_page_result_txt.setLayoutX(scene_width-800);
        manager_artistInfo_page_result_txt.setLayoutY(scene_height-500);
        manager_artistInfo_page_result_txt.setFill(Color.BLACK);
        manager_artistInfo_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
        
        
         Text managerr_artInfo_page_txt= new Text("ART ID");
        managerr_artInfo_page_txt.setLayoutX(scene_width-800);
        managerr_artInfo_page_txt.setLayoutY(scene_height-700);
        managerr_artInfo_page_txt.setFill(Color.BLACK);
        managerr_artInfo_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField managerr_artInfo_page_txtf= new TextField();
        managerr_artInfo_page_txtf.setPromptText("Enter Art_ID");
        managerr_artInfo_page_txtf.setPrefColumnCount(10);
        managerr_artInfo_page_txtf.setLayoutX(scene_width-800);
        managerr_artInfo_page_txtf.setLayoutY(scene_height-650);
        
        Text employee_artInfo_page_txt= new Text("ART ID");
        employee_artInfo_page_txt.setLayoutX(scene_width-800);
        employee_artInfo_page_txt.setLayoutY(scene_height-700);
        employee_artInfo_page_txt.setFill(Color.BLACK);
        employee_artInfo_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField employee_artInfo_page_txtf= new TextField();
        employee_artInfo_page_txtf.setPromptText("Enter Art_ID");
        employee_artInfo_page_txtf.setPrefColumnCount(10);
        employee_artInfo_page_txtf.setLayoutX(scene_width-800);
        employee_artInfo_page_txtf.setLayoutY(scene_height-650);
        
        
        
//        Text manager_artInfo_page_result_txt= new Text();
//        manager_artInfo_page_result_txt.setLayoutX(scene_width-800);
//        manager_artInfo_page_result_txt.setLayoutY(scene_height-500);
//        manager_artInfo_page_result_txt.setFill(Color.BLACK);
//        manager_artInfo_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
//        
         Text managerr_artOfartist_page_txt= new Text("ARTIST ID");
        managerr_artOfartist_page_txt.setLayoutX(scene_width-800);
        managerr_artOfartist_page_txt.setLayoutY(scene_height-700);
        managerr_artOfartist_page_txt.setFill(Color.BLACK);
        managerr_artOfartist_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField managerr_artOfartist_page_txtf= new TextField();
        managerr_artOfartist_page_txtf.setPromptText("Enter Artist_ID");
        managerr_artOfartist_page_txtf.setPrefColumnCount(10);
        managerr_artOfartist_page_txtf.setLayoutX(scene_width-800);
        managerr_artOfartist_page_txtf.setLayoutY(scene_height-650);
        
         Text employee_artOfartist_page_txt= new Text("ARTIST ID");
        employee_artOfartist_page_txt.setLayoutX(scene_width-800);
        employee_artOfartist_page_txt.setLayoutY(scene_height-700);
        employee_artOfartist_page_txt.setFill(Color.BLACK);
        employee_artOfartist_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField employee_artOfartist_page_txtf= new TextField();
        employee_artOfartist_page_txtf.setPromptText("Enter Artist_ID");
        employee_artOfartist_page_txtf.setPrefColumnCount(10);
        employee_artOfartist_page_txtf.setLayoutX(scene_width-800);
        employee_artOfartist_page_txtf.setLayoutY(scene_height-650);
        
        Text customer_artOfartist_page_txt= new Text("ARTIST ID");
        customer_artOfartist_page_txt.setLayoutX(scene_width-800);
        customer_artOfartist_page_txt.setLayoutY(scene_height-700);
        customer_artOfartist_page_txt.setFill(Color.BLACK);
        customer_artOfartist_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField customer_artOfartist_page_txtf= new TextField();
        customer_artOfartist_page_txtf.setPromptText("Enter Artist_ID");
        customer_artOfartist_page_txtf.setPrefColumnCount(10);
        customer_artOfartist_page_txtf.setLayoutX(scene_width-800);
        customer_artOfartist_page_txtf.setLayoutY(scene_height-650);
        
        Text artist_artOfartist_page_txt= new Text("ARTIST ID");
        artist_artOfartist_page_txt.setLayoutX(scene_width-800);
        artist_artOfartist_page_txt.setLayoutY(scene_height-700);
        artist_artOfartist_page_txt.setFill(Color.BLACK);
        artist_artOfartist_page_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        TextField artist_artOfartist_page_txtf= new TextField();
        artist_artOfartist_page_txtf.setPromptText("Enter Artist_ID");
        artist_artOfartist_page_txtf.setPrefColumnCount(10);
        artist_artOfartist_page_txtf.setLayoutX(scene_width-800);
        artist_artOfartist_page_txtf.setLayoutY(scene_height-650);
        
        
        
//        Text manager_artOfartist_page_result_txt= new Text();
//        manager_artOfartist_page_result_txt.setLayoutX(scene_width-800);
//        manager_artOfartist_page_result_txt.setLayoutY(scene_height-500);
//        manager_artOfartist_page_result_txt.setFill(Color.BLACK);
//        manager_artOfartist_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,30 ));
//        
        
        
        
        

        
        
        
        
        
        

       
        Text Submit_txt = new Text("Submit");
        Submit_txt.setFill(Color.BLACK);
        Submit_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text OK_txt = new Text("OK");
        OK_txt.setFill(Color.BLACK);
        OK_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text back_txt = new Text("BACK");
        back_txt.setFill(Color.BLACK);
        back_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        




        //Text query_show= new Text(customer_query()); // problem in this statement
        Text manager_bill_from_date_result_txt= new Text();
        //String customer_table_show_str= new String();
        //customer_table_show_str= String.join("\n",customer_query());
       // customer_table_show_str= String.join("\n",customer_query());

       // manager_bill_from_date_result_txt.setText(customer_table_show_str);
        manager_bill_from_date_result_txt.setLayoutX(20);
        manager_bill_from_date_result_txt.setLayoutY(400);
        manager_bill_from_date_result_txt.setFill(Color.BLACK);
        manager_bill_from_date_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         Text customer_table_show_txt= new Text();
        String customer_table_show_str= new String();
        customer_table_show_str= String.join("\n",customer_query());
        customer_table_show_str= String.join("\n",customer_query());

        customer_table_show_txt.setText(customer_table_show_str);
        customer_table_show_txt.setLayoutX(20);
        customer_table_show_txt.setLayoutY(200);
        customer_table_show_txt.setFill(Color.BLACK);
        customer_table_show_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        Text employeeUnderM_txt=new Text();
        String employeeUnderM_show_str= new String();
        employeeUnderM_show_str= String.join("\n",employees_under());
        employeeUnderM_txt.setText(employeeUnderM_show_str);
        employeeUnderM_txt.setLayoutX(20);
        employeeUnderM_txt.setLayoutY(200);
        employeeUnderM_txt.setFill(Color.BLACK);
        employeeUnderM_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text managerr_artsOfartist_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        managerr_artsOfartist_page_result_txt.setLayoutX(20);
        managerr_artsOfartist_page_result_txt.setLayoutY(400);
        managerr_artsOfartist_page_result_txt.setFill(Color.BLACK);
        managerr_artsOfartist_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text employee_artsOfartist_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        employee_artsOfartist_page_result_txt.setLayoutX(20);
        employee_artsOfartist_page_result_txt.setLayoutY(400);
        employee_artsOfartist_page_result_txt.setFill(Color.BLACK);
        employee_artsOfartist_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text manager_bill_from_date_page_from_txt=new Text("From"); 
        manager_bill_from_date_page_from_txt.setLayoutX(50);
        manager_bill_from_date_page_from_txt.setLayoutY(200);
        manager_bill_from_date_page_from_txt.setFill(Color.BLACK);
        manager_bill_from_date_page_from_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 )); 
        
          
        Text manager_bill_from_date_page_to_txt=new Text("To");
        manager_bill_from_date_page_to_txt.setLayoutX(500);
        manager_bill_from_date_page_to_txt.setLayoutY(200);
        manager_bill_from_date_page_to_txt.setFill(Color.BLACK);
        manager_bill_from_date_page_to_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         TextField manager_bill_from_date_page_from_txtf=new TextField();
         manager_bill_from_date_page_from_txtf.setPromptText("Format dd-mm-yy");
         manager_bill_from_date_page_from_txtf.setPrefColumnCount(10);
        manager_bill_from_date_page_from_txtf.setLayoutX(130);
        manager_bill_from_date_page_from_txtf.setLayoutY(180);
        
        
          
        TextField manager_bill_from_date_page_to_txtf=new TextField();
        manager_bill_from_date_page_to_txtf.setPromptText("Format dd-mm-yy");
        manager_bill_from_date_page_to_txtf.setPrefColumnCount(10);
        manager_bill_from_date_page_to_txtf.setLayoutX(550);
        manager_bill_from_date_page_to_txtf.setLayoutY(180);
       
        
        
        Text customer_artsOfartist_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        customer_artsOfartist_page_result_txt.setLayoutX(20);
        customer_artsOfartist_page_result_txt.setLayoutY(400);
        customer_artsOfartist_page_result_txt.setFill(Color.BLACK);
        customer_artsOfartist_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text artist_artsOfartist_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        artist_artsOfartist_page_result_txt.setLayoutX(20);
        artist_artsOfartist_page_result_txt.setLayoutY(400);
        artist_artsOfartist_page_result_txt.setFill(Color.BLACK);
        artist_artsOfartist_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         Text customer_current_exhi_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        String customer_current_exhi_page_result_str=new String();
        customer_current_exhi_page_result_str=String.join("\n",current_ex());
        customer_current_exhi_page_result_txt.setText(customer_current_exhi_page_result_str);
        customer_current_exhi_page_result_txt.setLayoutX(20);
        customer_current_exhi_page_result_txt.setLayoutY(400);
        customer_current_exhi_page_result_txt.setFill(Color.BLACK);
        customer_current_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text customer_upcoming_exhi_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
                String customer_upcoming_exhi_page_result_str=new String();
        customer_upcoming_exhi_page_result_str=String.join("\n",up_ex());
        customer_upcoming_exhi_page_result_txt.setText(customer_upcoming_exhi_page_result_str);
        customer_upcoming_exhi_page_result_txt.setLayoutX(20);
        customer_upcoming_exhi_page_result_txt.setLayoutY(400);
        customer_upcoming_exhi_page_result_txt.setFill(Color.BLACK);
        customer_upcoming_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text customer_past_exhi_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
          String customer_past_exhi_page_result_str=new String();
        customer_past_exhi_page_result_str=String.join("\n",past_ex());
        customer_past_exhi_page_result_txt.setText(customer_past_exhi_page_result_str);
        customer_past_exhi_page_result_txt.setLayoutX(20);
        customer_past_exhi_page_result_txt.setLayoutY(400);
        customer_past_exhi_page_result_txt.setFill(Color.BLACK);
        customer_past_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        Text artist_current_exhi_page_result_txt=new Text();
        
        String artist_current_exhi_page_result_str=new String();
        artist_current_exhi_page_result_str=String.join("\n",current_ex());
        artist_current_exhi_page_result_txt.setText(artist_current_exhi_page_result_str);
        
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        artist_current_exhi_page_result_txt.setLayoutX(20);
        artist_current_exhi_page_result_txt.setLayoutY(400);
        artist_current_exhi_page_result_txt.setFill(Color.BLACK);
        artist_current_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text artist_upcoming_exhi_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        String artist_upcoming_exhi_page_result_str=new String();
        artist_upcoming_exhi_page_result_str=String.join("\n",up_ex());
        artist_upcoming_exhi_page_result_txt.setText(artist_upcoming_exhi_page_result_str);
        
        artist_upcoming_exhi_page_result_txt.setLayoutX(20);
        artist_upcoming_exhi_page_result_txt.setLayoutY(400);
        artist_upcoming_exhi_page_result_txt.setFill(Color.BLACK);
        artist_upcoming_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text artist_past_exhi_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        String artist_past_exhi_page_result_str=new String();
        artist_past_exhi_page_result_str=String.join("\n",past_ex());
        artist_past_exhi_page_result_txt.setText(artist_past_exhi_page_result_str);
        
        artist_past_exhi_page_result_txt.setLayoutX(20);
        artist_past_exhi_page_result_txt.setLayoutY(400);
        artist_past_exhi_page_result_txt.setFill(Color.BLACK);
        artist_past_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        Text guest_current_exhi_page_result_txt=new Text();
        String guest_current_exhi_page_result_str=new String();
        guest_current_exhi_page_result_str=String.join("\n",current_ex());
        guest_current_exhi_page_result_txt.setText(guest_current_exhi_page_result_str);
        
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        guest_current_exhi_page_result_txt.setLayoutX(20);
        guest_current_exhi_page_result_txt.setLayoutY(400);
        guest_current_exhi_page_result_txt.setFill(Color.BLACK);
        guest_current_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text guest_upcoming_exhi_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        String guest_upcoming_exhi_page_result_str=new String();
        guest_upcoming_exhi_page_result_str=String.join("\n",up_ex());
        guest_upcoming_exhi_page_result_txt.setText(guest_upcoming_exhi_page_result_str);
        
        guest_upcoming_exhi_page_result_txt.setLayoutX(20);
        guest_upcoming_exhi_page_result_txt.setLayoutY(400);
        guest_upcoming_exhi_page_result_txt.setFill(Color.BLACK);
        guest_upcoming_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text guest_past_exhi_page_result_txt=new Text();
        //String artsOfartist_page_result_str= new String();
//        //employeeUnderM_show_str= String.join("\n",employees_under());
        //artsOfartist_page_reslut_txt.setText(artsOfartist_page_result_str);
        String guest_past_exhi_page_result_str=new String();
        guest_past_exhi_page_result_str=String.join("\n",past_ex());
        guest_past_exhi_page_result_txt.setText(guest_past_exhi_page_result_str);
        
        guest_past_exhi_page_result_txt.setLayoutX(20);
        guest_past_exhi_page_result_txt.setLayoutY(400);
        guest_past_exhi_page_result_txt.setFill(Color.BLACK);
        guest_past_exhi_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
        
        
        Text artist_artsBYprice_upto2k_page_result_txt=new Text();
        String artist_artsBYprice_upto2k_page_str=new String();
        artist_artsBYprice_upto2k_page_str=String.join("\n", less2k());
         artist_artsBYprice_upto2k_page_result_txt.setText(artist_artsBYprice_upto2k_page_str);

        
        artist_artsBYprice_upto2k_page_result_txt.setLayoutX(100);
        artist_artsBYprice_upto2k_page_result_txt.setLayoutY(300);
        artist_artsBYprice_upto2k_page_result_txt.setFill(Color.BLACK);
        artist_artsBYprice_upto2k_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text artist_artsBYprice_2kto5k_page_result_txt=new Text();
         String artist_artsBYprice_2kto5k_page_result_str=new String();
         artist_artsBYprice_2kto5k_page_result_str=String.join("\n", from_2_5());
         artist_artsBYprice_2kto5k_page_result_txt.setText(artist_artsBYprice_2kto5k_page_result_str);

        artist_artsBYprice_2kto5k_page_result_txt.setLayoutX(20);
        artist_artsBYprice_2kto5k_page_result_txt.setLayoutY(400);
        artist_artsBYprice_2kto5k_page_result_txt.setFill(Color.BLACK);
        artist_artsBYprice_2kto5k_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text artist_artsBYprice_above5k_page_result_txt=new Text(); 
         String artist_artsByprice_above5k_page_result_str=new String();
         artist_artsByprice_above5k_page_result_str=String.join("\n",more5k());
         artist_artsBYprice_above5k_page_result_txt.setText(artist_artsByprice_above5k_page_result_str);
        artist_artsBYprice_above5k_page_result_txt.setLayoutX(20);
        artist_artsBYprice_above5k_page_result_txt.setLayoutY(400);
        artist_artsBYprice_above5k_page_result_txt.setFill(Color.BLACK);
        artist_artsBYprice_above5k_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        Text customer_artsBYprice_upto2k_page_result_txt=new Text();
        String customer_artsBypricr_upto2k_page_result_str=new String();
        customer_artsBypricr_upto2k_page_result_str=String.join("\n",less2k());
        customer_artsBYprice_upto2k_page_result_txt.setText(customer_artsBypricr_upto2k_page_result_str);
        customer_artsBYprice_upto2k_page_result_txt.setLayoutX(20);
        customer_artsBYprice_upto2k_page_result_txt.setLayoutY(400);
        customer_artsBYprice_upto2k_page_result_txt.setFill(Color.BLACK);
        customer_artsBYprice_upto2k_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text customer_artsBYprice_2kto5k_page_result_txt=new Text(); 
         
         String customer_artsBYprice_2kto5k_page_result_str=new String();
         customer_artsBYprice_2kto5k_page_result_str=String.join("\n",from_2_5());
         customer_artsBYprice_2kto5k_page_result_txt.setText(customer_artsBYprice_2kto5k_page_result_str);
        customer_artsBYprice_2kto5k_page_result_txt.setLayoutX(20);
        customer_artsBYprice_2kto5k_page_result_txt.setLayoutY(400);
        customer_artsBYprice_2kto5k_page_result_txt.setFill(Color.BLACK);
        customer_artsBYprice_2kto5k_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text customer_artsBYprice_above5k_page_result_txt=new Text(); 
         String customer_artsBYprice_above5k_page_result_str=new String();
         customer_artsBYprice_above5k_page_result_str=String.join("\n", more5k());
         customer_artsBYprice_above5k_page_result_txt.setText(customer_artsBYprice_above5k_page_result_str);
        customer_artsBYprice_above5k_page_result_txt.setLayoutX(20);
        customer_artsBYprice_above5k_page_result_txt.setLayoutY(400);
        customer_artsBYprice_above5k_page_result_txt.setFill(Color.BLACK);
        customer_artsBYprice_above5k_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text customer_artsBYtype_maritime_page_result_txt=new Text();
         String customer_artsBYtype_maritime_page_result_str=new String();
         customer_artsBYtype_maritime_page_result_str=String.join("\n",maritime_art());
         customer_artsBYtype_maritime_page_result_txt.setText(customer_artsBYtype_maritime_page_result_str);
        customer_artsBYtype_maritime_page_result_txt.setLayoutX(20);
        customer_artsBYtype_maritime_page_result_txt.setLayoutY(400);
        customer_artsBYtype_maritime_page_result_txt.setFill(Color.BLACK);
        customer_artsBYtype_maritime_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text customer_artsBYtype_symbolism_page_result_txt=new Text();
         String customer_artsBYtype_symbolism_page_result_str=new String();
         customer_artsBYtype_symbolism_page_result_str=String.join("\n",symbolism());
         customer_artsBYtype_symbolism_page_result_txt.setText(customer_artsBYtype_symbolism_page_result_str);
        customer_artsBYtype_symbolism_page_result_txt.setLayoutX(20);
        customer_artsBYtype_symbolism_page_result_txt.setLayoutY(400);
        customer_artsBYtype_symbolism_page_result_txt.setFill(Color.BLACK);
        customer_artsBYtype_symbolism_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text customer_artsBYtype_renaissance_page_result_txt=new Text(); 
         String customer_artsBYtype_renaissance_page_result_str=new String();
         customer_artsBYtype_renaissance_page_result_str=String.join("\n",renaissance());
         customer_artsBYtype_renaissance_page_result_txt.setText(customer_artsBYtype_renaissance_page_result_str);
        customer_artsBYtype_renaissance_page_result_txt.setLayoutX(20);
        customer_artsBYtype_renaissance_page_result_txt.setLayoutY(400);
        customer_artsBYtype_renaissance_page_result_txt.setFill(Color.BLACK);
        customer_artsBYtype_renaissance_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        

         Text customer_artsBYtype_fauvism_page_result_txt=new Text(); 
         String customer_artsBYtype_fauvism_page_result_str=new String();
         customer_artsBYtype_fauvism_page_result_str=String.join("\n", fauvism());
         customer_artsBYtype_fauvism_page_result_txt.setText(customer_artsBYtype_fauvism_page_result_str);
         
        customer_artsBYtype_fauvism_page_result_txt.setLayoutX(20);
        customer_artsBYtype_fauvism_page_result_txt.setLayoutY(400);
        customer_artsBYtype_fauvism_page_result_txt.setFill(Color.BLACK);
        customer_artsBYtype_fauvism_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         Text customer_artsBYtype_postModern_page_result_txt=new Text();
         String customer_artsBYtype_postModern_page_result_str=new String();
         customer_artsBYtype_postModern_page_result_str=String.join("\n",post_modern());
         customer_artsBYtype_postModern_page_result_txt.setText(customer_artsBYtype_postModern_page_result_str);
        customer_artsBYtype_postModern_page_result_txt.setLayoutX(20);
        customer_artsBYtype_postModern_page_result_txt.setLayoutY(400);
        customer_artsBYtype_postModern_page_result_txt.setFill(Color.BLACK);
        customer_artsBYtype_postModern_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
         Text artist_artsBYtype_maritime_page_result_txt=new Text(); 
          String artist_artsBYtype_maritime_page_result_str=new String();
         artist_artsBYtype_maritime_page_result_str=String.join("\n",maritime_art());
         artist_artsBYtype_maritime_page_result_txt.setText(artist_artsBYtype_maritime_page_result_str);
        artist_artsBYtype_maritime_page_result_txt.setLayoutX(20);
        artist_artsBYtype_maritime_page_result_txt.setLayoutY(400);
        artist_artsBYtype_maritime_page_result_txt.setFill(Color.BLACK);
        artist_artsBYtype_maritime_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text artist_artsBYtype_symbolism_page_result_txt=new Text(); 
          String artist_artsBYtype_symbolism_page_result_str=new String();
         artist_artsBYtype_symbolism_page_result_str=String.join("\n",symbolism());
         artist_artsBYtype_symbolism_page_result_txt.setText(artist_artsBYtype_symbolism_page_result_str);
        artist_artsBYtype_symbolism_page_result_txt.setLayoutX(20);
        artist_artsBYtype_symbolism_page_result_txt.setLayoutY(400);
        artist_artsBYtype_symbolism_page_result_txt.setFill(Color.BLACK);
        artist_artsBYtype_symbolism_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
         Text artist_artsBYtype_renaissance_page_result_txt=new Text();
         String artist_artsBYtype_renaissance_page_result_str=new String();
         artist_artsBYtype_renaissance_page_result_str=String.join("\n",renaissance());
         artist_artsBYtype_renaissance_page_result_txt.setText(artist_artsBYtype_renaissance_page_result_str);
        artist_artsBYtype_renaissance_page_result_txt.setLayoutX(20);
        artist_artsBYtype_renaissance_page_result_txt.setLayoutY(400);
        artist_artsBYtype_renaissance_page_result_txt.setFill(Color.BLACK);
        artist_artsBYtype_renaissance_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        

         Text artist_artsBYtype_fauvism_page_result_txt=new Text(); 
         String artist_artsBYtype_fauvism_page_result_str=new String();
         artist_artsBYtype_fauvism_page_result_str=String.join("\n", fauvism());
         artist_artsBYtype_fauvism_page_result_txt.setText(artist_artsBYtype_fauvism_page_result_str);
        artist_artsBYtype_fauvism_page_result_txt.setLayoutX(20);
        artist_artsBYtype_fauvism_page_result_txt.setLayoutY(400);
        artist_artsBYtype_fauvism_page_result_txt.setFill(Color.BLACK);
        artist_artsBYtype_fauvism_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
         Text artist_artsBYtype_postModern_page_result_txt=new Text();
         String artist_artsBYtype_postModern_page_result_str=new String();
         artist_artsBYtype_postModern_page_result_str=String.join("\n",post_modern());
         artist_artsBYtype_postModern_page_result_txt.setText(artist_artsBYtype_postModern_page_result_str);
        artist_artsBYtype_postModern_page_result_txt.setLayoutX(20);
        artist_artsBYtype_postModern_page_result_txt.setLayoutY(400);
        artist_artsBYtype_postModern_page_result_txt.setFill(Color.BLACK);
        artist_artsBYtype_postModern_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        Text artist_payslip_page_result_txt=new Text(); 
       
        artist_payslip_page_result_txt.setLayoutX(500);
        artist_payslip_page_result_txt.setLayoutY(300);
        artist_payslip_page_result_txt.setFill(Color.BLACK);
        artist_payslip_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text customer_bill_page_result_txt=new Text(); 
        String customer_bill_page_result_str=new String();
        customer_bill_page_result_str=String.join("\n",bills_mine());
        customer_bill_page_result_txt.setText(customer_bill_page_result_str);
        
        customer_bill_page_result_txt.setLayoutX(20);
        customer_bill_page_result_txt.setLayoutY(400);
        customer_bill_page_result_txt.setFill(Color.BLACK);
        customer_bill_page_result_txt.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        

        

        


        

        


        Text error_show = new Text("error");
        error_show.setLayoutX(400);
        error_show.setLayoutY(700);
        error_show.setFill(Color.BLACK);
        error_show.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text manager_loginCheck_page_error_show = new Text();
        manager_loginCheck_page_error_show.setLayoutX(scene_width-700);
        manager_loginCheck_page_error_show.setLayoutY(scene_height-200);
        manager_loginCheck_page_error_show.setFill(Color.RED);
        manager_loginCheck_page_error_show.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text employee_loginCheck_page_error_show = new Text();
        employee_loginCheck_page_error_show.setLayoutX(scene_width-700);
        employee_loginCheck_page_error_show.setLayoutY(scene_height-200);
        employee_loginCheck_page_error_show.setFill(Color.RED);
        employee_loginCheck_page_error_show.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text artist_loginCheck_page_error_show = new Text();
        artist_loginCheck_page_error_show.setLayoutX(scene_width-700);
        artist_loginCheck_page_error_show.setLayoutY(scene_height-200);
        artist_loginCheck_page_error_show.setFill(Color.RED);
        artist_loginCheck_page_error_show.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        Text customer_loginCheck_page_error_show = new Text();
        customer_loginCheck_page_error_show.setLayoutX(scene_width-700);
        customer_loginCheck_page_error_show.setLayoutY(scene_height-200);
        customer_loginCheck_page_error_show.setFill(Color.RED);
        customer_loginCheck_page_error_show.setFont(Font.font("Arial",FontWeight.BOLD,20 ));
        
        
        
        
        MenuButton guest_homepage_explore_mbtn = new MenuButton();
        guest_homepage_explore_mbtn.setText("Explore");
        guest_homepage_explore_mbtn.setLayoutX(scene_width-800);
        guest_homepage_explore_mbtn.setLayoutY(scene_height-700);
        MenuItem guest_current_exhibition_mitem = new MenuItem("Current Exhibitions");
        MenuItem guest_upcoming_exhibition_mitem = new MenuItem("Upcoming Exhibitions");
        MenuItem guest_past_exhibition_mitem = new MenuItem("Past Exhibitions");
        guest_homepage_explore_mbtn.getItems().addAll(guest_current_exhibition_mitem,guest_upcoming_exhibition_mitem,guest_past_exhibition_mitem);
        
        guest_current_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(guest_current_exhibitions_page_scene);
            }
        });
        
        guest_upcoming_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(guest_upcoming_exhibitions_page_scene);
            }
        });
        
         guest_past_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(guest_past_exhibitions_page_scene);
            }
        });
         
         
         Button guest_current_exhi_page_back_btn= new Button();
        guest_current_exhi_page_back_btn.setLayoutX(scene_width-950);
        guest_current_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        guest_current_exhi_page_back_btn.setText("BACK");
        guest_current_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                myStage.setScene(guest_homepage_scene);

                
            }
        });
        
         Button guest_upcoming_exhi_page_back_btn= new Button();
        guest_upcoming_exhi_page_back_btn.setLayoutX(scene_width-950);
        guest_upcoming_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        guest_upcoming_exhi_page_back_btn.setText("BACK");
        guest_upcoming_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                myStage.setScene(guest_homepage_scene);

                
            }
        });
       
        
         Button guest_past_exhi_page_back_btn= new Button();
        guest_past_exhi_page_back_btn.setLayoutX(scene_width-950);
        guest_past_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        guest_past_exhi_page_back_btn.setText("BACK");
        guest_past_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                myStage.setScene(guest_homepage_scene);

                
            }
        });
       



        
        
       




        Button log_in_btn = new Button();
        log_in_btn.setLayoutX(scene_width-100);
        log_in_btn.setLayoutY(scene_height-800);
        log_in_btn.setText(" LOG IN");
        
        //log_in_btn.setGraphic(log_in_img);
        log_in_btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(login_page_scene);
            }
        });
        
        Button guest_access_btn = new Button();
        guest_access_btn.setLayoutX(scene_width-950);
        guest_access_btn.setLayoutY(scene_height-800);
        guest_access_btn.setText("GUEST ACCESS");
        guest_access_btn.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event)
            {
               myStage.setScene(guest_homepage_scene);
            }
        });

//        Button insert_btn = new Button();
//        insert_btn.setLayoutX(scene_width-650);
//        insert_btn.setLayoutY(scene_height-550);
//        insert_btn.setGraphic(insert_txt);
//        insert_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                //System.out.println("Hello World!");
//                //myStage.setScene(insert_scene);
//            }
//        });
//
//        Button query_btn= new Button ();
//        query_btn.setLayoutX(scene_width-650);
//        query_btn.setLayoutY(scene_height-400);
//        query_btn.setGraphic(query_txt);
//        query_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                //System.out.println("Hello World!");
//
//                //myStage.setScene( query_scene);
//            }
//        });

       
        
        
        
        
        
        



        Button login_page_Customer_btn= new Button();
        login_page_Customer_btn.setLayoutX(scene_width-650);
        login_page_Customer_btn.setLayoutY(scene_height-250);
        //login_page_Customer_btn.setGraphic(customer_txt);
        login_page_Customer_btn.setText("CUSTOMER");
        login_page_Customer_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( customer_login_check_scene);
            }
        });



        Button login_page_artist_btn= new Button();
        login_page_artist_btn.setLayoutX(scene_width-650);
        login_page_artist_btn.setLayoutY(scene_height-400);
        //login_page_artist_btn.setGraphic(artist_txt);
        login_page_artist_btn.setText("ARTIST");
        login_page_artist_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(artist_login_check_scene);
            }
        });


        
        Button login_page_manager_btn= new Button();
        login_page_manager_btn.setLayoutX(scene_width-650);
        login_page_manager_btn.setLayoutY(scene_height-700);
        //login_page_manager_btn.setGraphic(manager_txt);
        login_page_manager_btn.setText("MANAGER");
        login_page_manager_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(manager_login_check_scene);
            }
        });


        Button login_page_employee_btn= new Button();
        //System.out.println("Hello World!");
        login_page_employee_btn.setLayoutX(scene_width-650);
        login_page_employee_btn.setLayoutY(scene_height-550);
        //login_page_employee_btn.setGraphic(employee_txt);
        login_page_employee_btn.setText("EMPLOYEE");
        login_page_employee_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                   myStage.setScene(employee_login_check_scene);
            }
        });
        
        Button login_page_back_btn= new Button();
        login_page_back_btn.setLayoutX(scene_width-950);
        login_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        login_page_back_btn.setText("BACK");
        login_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                                   myStage.setScene(first_scene);

                
            }
        });
       

        
        
        
        
        Button manager_login_check_submit_btn = new Button();
        manager_login_check_submit_btn.setLayoutX(scene_width-650);
        manager_login_check_submit_btn.setLayoutY(scene_height-150);
        //manager_login_check_submit_btn.setGraphic(Submit_txt);
        manager_login_check_submit_btn.setText("SUBMIT");
        manager_login_check_submit_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                
                    if(con!=null){
                        try{
                            System.out.println("asd");
                            String given_username=managerLoginCheck_class.username_txtf.getText();
                            String given_password=managerLoginCheck_class.password_txtf.getText();
                            
                            String sqlcommand= "SELECT MANAGER_ID FROM MANAGERS WHERE USER_NAME=? AND PASSWORD=? ";
                           PreparedStatement pst56=con.prepareStatement(sqlcommand);
                           
                            System.out.println(given_username);
                            System.out.println(given_password);
                           
                           pst56.setString(1,given_username);
                           pst56.setString(2,given_password);
                            System.out.println("asd");
                           
                           ResultSet rs=pst56.executeQuery();
                            System.out.println("asdasdfasd");
                           
                           while(rs.next()){
                               System.out.println("in while");
                               ID=rs.getString(1);
                               myStage.setScene(manager_homepage_scene);
                               
                           }
                          // myStage.setScene(manager_homepage_scene);
                               manager_loginCheck_page_error_show.setText("Invalid Username or Password");

                            System.out.println(ID);
                           pst56.close();
                           
                           
                            
                        }catch(SQLException e){
                            System.out.println(e.toString());
                            System.out.println("pblm");
                        }
                    }
                    managerLoginCheck_class.username_txtf.clear();
                    managerLoginCheck_class.password_txtf.clear();
                        
                    
                
                   // System.out.println(managerLoginCheck_class.username_txtf.getText());
                    //System.out.println(managerLoginCheck_class.password_txtf.getText());
                    
                    
                   // ID="habijabi";
                  // myStage.setScene(manager_homepage_scene);
            }
        });
        
        Button manager_login_check_back_btn= new Button();
        manager_login_check_back_btn.setLayoutX(scene_width-950);
        manager_login_check_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        manager_login_check_back_btn.setText("BACK");
        manager_login_check_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                managerLoginCheck_class.username_txtf.clear();
                    managerLoginCheck_class.password_txtf.clear();
                     
                           manager_loginCheck_page_error_show.setText("");
                
                                   myStage.setScene(login_page_scene);

                
            }
        });
       
        
        
        Button manager_homepage_insert_btn= new Button();
        manager_homepage_insert_btn.setLayoutX(scene_width-650);
        manager_homepage_insert_btn.setLayoutY(scene_height-700);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        manager_homepage_insert_btn.setText("NEW REGISTER");
        manager_homepage_insert_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println(ID);
                myStage.setScene(manager_insertTables_scene);
            }
        });
        
         Button manager_homepage_profile_btn= new Button();
        manager_homepage_profile_btn.setLayoutX(scene_width-650);
        manager_homepage_profile_btn.setLayoutY(scene_height-600);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        manager_homepage_profile_btn.setText("PROFILE");
        manager_homepage_profile_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                                if(con!=null)
                {
                    try{
                        
                        String sqlcommand="SELECT * FROM MANAGERS WHERE MANAGER_ID=?";
                        PreparedStatement pst5=con.prepareStatement(sqlcommand);
                        
                        pst5.setString(1, ID);
                        
                        
                        ResultSet rs=pst5.executeQuery();
                        
                        while(rs.next()){
                            
                            managerProfile_class.manager_ID_result_txt.setText(rs.getString(1));
                            managerProfile_class.manager_name_result_txt.setText(rs.getString(2));
                            managerProfile_class.username_result_txt.setText(rs.getString(11));
                            managerProfile_class.password_result_txt.setText(rs.getString(12));
                            managerProfile_class.address_result_txt.setText(rs.getString(5));
                            managerProfile_class.sex_result_txt.setText(rs.getString(4));
                            managerProfile_class.phone_no_result_txt.setText(rs.getString(6));
                            managerProfile_class.email_ID_result_txt.setText(rs.getString(7));
                           managerProfile_class.salary_result_txt.setText(rs.getString(10));
                            managerProfile_class.dateOf_birth_result_txt.setText(rs.getString(3));
                             managerProfile_class.join_date_result_txt.setText(rs.getString(8));
                              managerProfile_class.end_date_result_txt.setText(rs.getString(9));
                                
                    }
                        pst5.close();

                myStage.setScene(artist_profile_scene);
            }catch(SQLException e){
                        System.out.println(e.toString());
            }
                
                }
                System.out.println(ID);
                myStage.setScene(manager_profile_scene);
            }
        });
        
        
        
        
        Button manager_profile_page_edit_profile_btn= new Button();
        manager_profile_page_edit_profile_btn.setLayoutX(scene_width-650);
        manager_profile_page_edit_profile_btn.setLayoutY(scene_height-150);
        //manager_homepage_edit_profile_btn.setGraphic(edit_profile_txt);
        manager_profile_page_edit_profile_btn.setText("EDIT PROFILE");
        manager_profile_page_edit_profile_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                 if(con!=null){
                    try{
                        
                        String sqlcommand="SELECT USER_NAME,ADDRESS,PASSWORD,EMAIL_ID,PHONE_NO FROM MANAGERS WHERE MANAGER_ID=?";
                        
                        PreparedStatement pst44=con.prepareStatement(sqlcommand);
                        
                        pst44.setString(1,ID);
                        ResultSet rs=pst44.executeQuery();
                        
                        while(rs.next()){
                            managerEditProfile_class.new_username_txf.setText(rs.getString(1));
                            managerEditProfile_class.new_address_txf.setText(rs.getString(2));
                            managerEditProfile_class.new_password_txf.setText(rs.getString(3));
                            managerEditProfile_class.new_email_id_txf.setText(rs.getString(4));
                            managerEditProfile_class.new_phone_no_txf.setText(rs.getString(5));
                        }
                        
                        pst44.close();
                     
                        
                    }catch(SQLException e)
                    {
                        System.out.println(e.toString()); 
                             
                    }
                }
                myStage.setScene(manager_edit_profile_scene);
            }
        });
        
         Button manager_profile_page_logout_btn= new Button();
        manager_profile_page_logout_btn.setLayoutX(scene_width-150);
        manager_profile_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        manager_profile_page_logout_btn.setText("LOG OUT");
        manager_profile_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                ID="";
                manager_loginCheck_page_error_show.setText("");

                myStage.setScene(login_page_scene);
            }
        });
        
         Button manager_profile_page_home_btn= new Button();
        manager_profile_page_home_btn.setLayoutX(scene_width-950);
        manager_profile_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_profile_page_home_btn.setText("HOME");
        manager_profile_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(manager_homepage_scene);
            }
        });
        
        Button manager_homepage_showTables_btn= new Button();
        manager_homepage_showTables_btn.setLayoutX(scene_width-650);
        manager_homepage_showTables_btn.setLayoutY(scene_height-100);
        //manager_homepage_showTables_btn.setGraphic(show_table_txt);
        manager_homepage_showTables_btn.setText("ALL ABOUT");
        manager_homepage_showTables_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(manager_showTables_scene);
            }
        });
        
        Button manager_homepage_query_btn= new Button();
        manager_homepage_query_btn.setLayoutX(scene_width-650);
        manager_homepage_query_btn.setLayoutY(scene_height-500);
        //manager_homepage_query_btn.setGraphic(query_txt);
        manager_homepage_query_btn.setText("EXPLORE");
        manager_homepage_query_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(manager_query_page_scene);
            }
        });
//        
//        Button manager_homepage_changes_btn= new Button();
//        manager_homepage_changes_btn.setLayoutX(scene_width-650);
//        manager_homepage_changes_btn.setLayoutY(scene_height-300);
//        manager_homepage_changes_btn.setGraphic(changes_txt);
//        manager_homepage_changes_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                //System.out.println("Hello World!");
//                //myStage.setScene(manager_login_check_scene);
//            }
//        });
        
        Button manager_homepage_logout_btn= new Button();
        manager_homepage_logout_btn.setLayoutX(scene_width-150);
        manager_homepage_logout_btn.setLayoutY(scene_height-820);
        //manager_homepage_logout_btn.setGraphic(logout_btn_img);
        manager_homepage_logout_btn.setText("LOG OUT");
        manager_homepage_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println(ID);
                manager_loginCheck_page_error_show.setText("");

                myStage.setScene(login_page_scene);
            }
        });
        
         Button manager_edit_profile_page_logout_btn= new Button();
        manager_edit_profile_page_logout_btn.setLayoutX(scene_width-150);
        manager_edit_profile_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        manager_edit_profile_page_logout_btn.setText("LOG OUT");
        manager_edit_profile_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                ID="";
                manager_loginCheck_page_error_show.setText("");

                myStage.setScene(login_page_scene);
            }
        });
        
         Button manager_edit_profile_page_home_btn= new Button();
        manager_edit_profile_page_home_btn.setLayoutX(scene_width-950);
        manager_edit_profile_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_edit_profile_page_home_btn.setText("HOME");
        manager_edit_profile_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(manager_homepage_scene);
            }
        });
        
         Button manager_edit_profile_page_ok_btn= new Button();
        manager_edit_profile_page_ok_btn.setLayoutX(scene_width-700);
        manager_edit_profile_page_ok_btn.setLayoutY(scene_height-450);
        //manager_edit_profile_page_ok_btn.setGraphic(OK_txt);
        manager_edit_profile_page_ok_btn.setText("OK");
        manager_edit_profile_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                   if(con!=null){
                    
                    try{
                       // Statement stmt4=con.createStatement();
                       
                       
                        
                        String u_username =managerEditProfile_class.new_username_txf.getText();
                        String u_address = managerEditProfile_class.new_address_txf.getText();
                        String u_phone= managerEditProfile_class.new_phone_no_txf.getText();
                        String u_email= managerEditProfile_class.new_email_id_txf.getText();
                        String u_password=managerEditProfile_class.new_password_txf.getText();
                        
                        String sqlcommand= "UPDATE MANAGERS SET USER_NAME=? ,ADDRESS=?, PHONE_NO=?,EMaIL_ID=?,PASSWORD=? WHERE MANAGER_ID=? ";
                        PreparedStatement pst34 =con.prepareStatement(sqlcommand);
                        
                        
                        pst34.setString(1,u_username);
                        pst34.setString(2,u_address);
                        pst34.setString(3,u_phone);
                        pst34.setString(4,u_email);
                        pst34.setString(5,u_password);
                        pst34.setString(6, ID);
                        
                        pst34.executeUpdate();
                        pst34.close();
                        
                        //String sqlcommand="UPDATE MANAGERS SET USER_NAME ''='"+u_username+"','ADDRESS'='"+u_address+"','PHONE_NUMBER'='"+u_phone+"','EMAIL_ID'='"+u_email+"','PASSWORD'='"+u_password"'"
          
                        
                        //stmt4.executeQuery(sqlcommand);
                        
                   } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
            }
        });
        
        
        
        
         Button manager_insertTables_page_customer_btn= new Button();
        manager_insertTables_page_customer_btn.setLayoutX(scene_width-650);
        manager_insertTables_page_customer_btn.setLayoutY(scene_height-700);
        //manager_insertTables_page_customer_btn.setGraphic(customer_txt);
        manager_insertTables_page_customer_btn.setText("CUSTOMERS");
        manager_insertTables_page_customer_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( customer_table_insert_from_manager_scene);
            }
        });
        
         Button manager_insertTables_page_employee_btn= new Button();
        manager_insertTables_page_employee_btn.setLayoutX(scene_width-650);
        manager_insertTables_page_employee_btn.setLayoutY(scene_height-600);
        //manager_insertTables_page_employee_btn.setGraphic(employee_txt);
        manager_insertTables_page_employee_btn.setText("EMPLOYEES");
        manager_insertTables_page_employee_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( employee_table_insert_from_manager_scene);
            }
        });
        
         Button manager_insertTables_page_artist_btn= new Button();
        manager_insertTables_page_artist_btn.setLayoutX(scene_width-650);
        manager_insertTables_page_artist_btn.setLayoutY(scene_height-500);
        //manager_insertTables_page_artist_btn.setGraphic(artist_txt);
        manager_insertTables_page_artist_btn.setText("ARTISTS");
        manager_insertTables_page_artist_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene(artist_table_insert_from_manager_scene);
            }
        });
        
         Button manager_insertTables_page_arts_btn= new Button();
        manager_insertTables_page_arts_btn.setLayoutX(scene_width-650);
        manager_insertTables_page_arts_btn.setLayoutY(scene_height-400);
        //manager_insertTables_page_arts_btn.setGraphic(arts_txt);
        manager_insertTables_page_arts_btn.setText("ARTS");
        manager_insertTables_page_arts_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( art_table_insert_from_manager_scene);
            }
        });
        
         Button manager_insertTables_page_hallroom_btn= new Button();
        manager_insertTables_page_hallroom_btn.setLayoutX(scene_width-650);
        manager_insertTables_page_hallroom_btn.setLayoutY(scene_height-300);
        //manager_insertTables_page_hallroom_btn.setGraphic(hallroom_txt);
        manager_insertTables_page_hallroom_btn.setText("HALLROOM");
        manager_insertTables_page_hallroom_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( hallroom_table_insert_from_manager_scene);
            }
        });
        
         Button manager_insertTables_page_exhibition_btn= new Button();
        manager_insertTables_page_exhibition_btn.setLayoutX(scene_width-650);
        manager_insertTables_page_exhibition_btn.setLayoutY(scene_height-200);
        //manager_insertTables_page_exhibition_btn.setGraphic(exhibiton_txt);
        manager_insertTables_page_exhibition_btn.setText("EXHIBITIONS");
        manager_insertTables_page_exhibition_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( exhibition_table_insert_from_manager_scene);
            }
        });
        
         Button manager_insertTables_page_logout_btn= new Button();
        manager_insertTables_page_logout_btn.setLayoutX(scene_width-150);
        manager_insertTables_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        manager_insertTables_page_logout_btn.setText("LOG OUT");
        manager_insertTables_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                           manager_loginCheck_page_error_show.setText("");
                
                System.out.println(ID);
                myStage.setScene(login_page_scene);
            }
        });
        
         Button manager_insertTables_page_home_btn= new Button();
        manager_insertTables_page_home_btn.setLayoutX(scene_width-950);
        manager_insertTables_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_insertTables_page_home_btn.setText("HOME");
        manager_insertTables_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(manager_homepage_scene);
            }
        });
        
        
        Button Customer_table_insert_from_manager_ok_btn = new Button();
        Customer_table_insert_from_manager_ok_btn.setLayoutX(scene_width-550);
        Customer_table_insert_from_manager_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        Customer_table_insert_from_manager_ok_btn.setText("OK");
        Customer_table_insert_from_manager_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                        
                        System.out.println(CustomerTableInsertFromManager_class.customer_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                        String c_name=CustomerTableInsertFromManager_class.customer_name_txtf.getText();
                        String c_sex=CustomerTableInsertFromManager_class.toggle_grp_customer_sex.getSelectedToggle().getUserData().toString();
                        String c_adrs =CustomerTableInsertFromManager_class.customer_adrs_txtf.getText();
                        String c_phn= CustomerTableInsertFromManager_class.customer_phn_txtf.getText();
                        String c_email= CustomerTableInsertFromManager_class.customer_email_txtf.getText();
                        String c_favGen=CustomerTableInsertFromManager_class.toggle_grp_customer_fav_genre.getSelectedToggle().getUserData().toString();
                        String c_username = CustomerTableInsertFromManager_class.customer_username_txtf.getText();
                        String c_password = CustomerTableInsertFromManager_class.customer_password_txtf.getText();
                        String c_dateOfbirth= CustomerTableInsertFromManager_class.customer_dateOf_birth_txf.getText();
                        
                        
                        
//                        String sqlCommand = "INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE,DATE_OF_BIRTH) VALUES('"+ c_id+ "','"+ c_name+ "',' "+c_username+ " ',' "+c_password+" ','" +c_sex+ "','" +c_adrs+ "','" +c_phn +"','" + c_email+"','"+c_favGen+"','"+c_dateOfbirth+"')";
//                        // String sqlCommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE)"+
//                             //    "VALUES('005','gh','af','gf',7,'Sb','oD')";
//    
//                        stmt.executeUpdate(sqlCommand);

                            String sqlcommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE,DATE_OF_BIRTH) VALUES(SET_CUSTOMERID,?,?,?,?,?,?,?,?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_username);
                            pst110.setString(3,c_password);
                            pst110.setString(4,c_sex);
                            pst110.setString(5,c_adrs);
                            pst110.setString(6,c_phn);
                            pst110.setString(7,c_email);
                            pst110.setString(8,c_favGen);
                            pst110.setString(9,c_dateOfbirth);
                            
                            pst110.executeQuery();
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                CustomerTableInsertFromManager_class.customer_id_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_name_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_adrs_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_phn_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_email_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_favGen_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_username_txtf.setText("");        
                CustomerTableInsertFromManager_class.customer_password_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_dateOf_birth_txf.clear();
                
                CustomerTableInsertFromManager_class.toggle_grp_customer_sex.getToggles().removeAll(
                        CustomerTableInsertFromManager_class.customer_sex_rbtn_male,CustomerTableInsertFromManager_class.customer_sex_rbtn_female,
                        CustomerTableInsertFromManager_class.customer_sex_rbtn_other);
                CustomerTableInsertFromManager_class.toggle_grp_customer_fav_genre.getToggles().removeAll(
                    CustomerTableInsertFromManager_class.customer_fav_genre_fauvism_rbtn,CustomerTableInsertFromManager_class.customer_fav_genre_maritime_rbtn,
                        CustomerTableInsertFromManager_class.customer_fav_genre_postModern_rbtn,CustomerTableInsertFromManager_class.customer_fav_genre_renaissance_rbtn,
                        CustomerTableInsertFromManager_class.customer_fav_genre_symbolism_rbtn);

                
//                customer_sex_rbtn_male.setUserData("");
//                customer_sex_rbtn_female.setUserData("");
//                customer_sex_rbtn_other.setUserData("");
                
                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        
        
        Button customer_table_insert_page_from_manager_back_btn= new Button();
        customer_table_insert_page_from_manager_back_btn.setLayoutX(scene_width-950);
        customer_table_insert_page_from_manager_back_btn.setLayoutY(scene_height-800);
        customer_table_insert_page_from_manager_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        customer_table_insert_page_from_manager_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                
                
                CustomerTableInsertFromManager_class.customer_id_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_name_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_adrs_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_phn_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_email_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_favGen_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_username_txtf.setText("");        
                CustomerTableInsertFromManager_class.customer_password_txtf.setText("");
                CustomerTableInsertFromManager_class.customer_dateOf_birth_txf.clear();
                
                CustomerTableInsertFromManager_class.toggle_grp_customer_sex.getToggles().removeAll(
                        CustomerTableInsertFromManager_class.customer_sex_rbtn_male,CustomerTableInsertFromManager_class.customer_sex_rbtn_female,
                        CustomerTableInsertFromManager_class.customer_sex_rbtn_other);
                CustomerTableInsertFromManager_class.toggle_grp_customer_fav_genre.getToggles().removeAll(
                    CustomerTableInsertFromManager_class.customer_fav_genre_fauvism_rbtn,CustomerTableInsertFromManager_class.customer_fav_genre_maritime_rbtn,
                        CustomerTableInsertFromManager_class.customer_fav_genre_postModern_rbtn,CustomerTableInsertFromManager_class.customer_fav_genre_renaissance_rbtn,
                        CustomerTableInsertFromManager_class.customer_fav_genre_symbolism_rbtn);

                                   myStage.setScene(manager_insertTables_scene);

                
            }
        });
        
        
        Button artist_table_insert_from_manager_ok_btn = new Button();
        artist_table_insert_from_manager_ok_btn.setLayoutX(scene_width-550);
        artist_table_insert_from_manager_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        artist_table_insert_from_manager_ok_btn.setText("OK");
        artist_table_insert_from_manager_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                        
                        System.out.println(ArtistTableInsertFromManager_class.artist_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                        String c_name=ArtistTableInsertFromManager_class.artist_name_txtf.getText();
                        String c_sex=ArtistTableInsertFromManager_class.toggle_grp_artist_sex.getSelectedToggle().getUserData().toString();
                        String c_adrs =ArtistTableInsertFromManager_class.artist_adrs_txtf.getText();
                        String c_phn= ArtistTableInsertFromManager_class.artist_phn_txtf.getText();
                        String c_email= ArtistTableInsertFromManager_class.artist_email_txtf.getText();
                        String c_favGen=ArtistTableInsertFromManager_class.toggle_grp_artist_fav_genre.getSelectedToggle().getUserData().toString();
                        String c_username = ArtistTableInsertFromManager_class.artist_username_txtf.getText();
                        String c_password = ArtistTableInsertFromManager_class.artist_password_txtf.getText();
                        String c_dateOfbirth= ArtistTableInsertFromManager_class.artist_dateOf_birth_txf.getText();
                        
                        
                        
//                        String sqlCommand = "INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE,DATE_OF_BIRTH) VALUES('"+ c_id+ "','"+ c_name+ "',' "+c_username+ " ',' "+c_password+" ','" +c_sex+ "','" +c_adrs+ "','" +c_phn +"','" + c_email+"','"+c_favGen+"','"+c_dateOfbirth+"')";
//                        // String sqlCommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE)"+
//                             //    "VALUES('005','gh','af','gf',7,'Sb','oD')";
//    
//                        stmt.executeUpdate(sqlCommand);

                            String sqlcommand="INSERT INTO ARTISTS(ARTIST_ID,ARTIST_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,MAIN_GENRE,DATE_OF_BIRTH) VALUES(SET_ARTISTID,?,?,?,?,?,?,?,?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_username);
                            pst110.setString(3,c_password);
                            pst110.setString(4,c_sex);
                            pst110.setString(5,c_adrs);
                            pst110.setString(6,c_phn);
                            pst110.setString(7,c_email);
                            pst110.setString(8,c_favGen);
                            pst110.setString(9,c_dateOfbirth);
                            
                            pst110.executeQuery();
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                ArtistTableInsertFromManager_class.artist_id_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_name_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_adrs_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_phn_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_email_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_favGen_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_username_txtf.setText("");        
                ArtistTableInsertFromManager_class.artist_password_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_dateOf_birth_txf.clear();
                
                ArtistTableInsertFromManager_class.toggle_grp_artist_sex.getToggles().removeAll(
                        ArtistTableInsertFromManager_class.artist_sex_rbtn_male,ArtistTableInsertFromManager_class.artist_sex_rbtn_female,
                        ArtistTableInsertFromManager_class.artist_sex_rbtn_other);
                ArtistTableInsertFromManager_class.toggle_grp_artist_fav_genre.getToggles().removeAll(
                    ArtistTableInsertFromManager_class.artist_fav_genre_fauvism_rbtn,ArtistTableInsertFromManager_class.artist_fav_genre_maritime_rbtn,
                        ArtistTableInsertFromManager_class.artist_fav_genre_postModern_rbtn,ArtistTableInsertFromManager_class.artist_fav_genre_renaissance_rbtn,
                        ArtistTableInsertFromManager_class.artist_fav_genre_symbolism_rbtn);

                
//                customer_sex_rbtn_male.setUserData("");
//                customer_sex_rbtn_female.setUserData("");
//                customer_sex_rbtn_other.setUserData("");
                
                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        

        
        Button artist_table_insert_page_from_manager_back_btn= new Button();
        artist_table_insert_page_from_manager_back_btn.setLayoutX(scene_width-950);
        artist_table_insert_page_from_manager_back_btn.setLayoutY(scene_height-800);
        artist_table_insert_page_from_manager_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        artist_table_insert_page_from_manager_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                
                 ArtistTableInsertFromManager_class.artist_id_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_name_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_adrs_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_phn_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_email_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_favGen_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_username_txtf.setText("");        
                ArtistTableInsertFromManager_class.artist_password_txtf.setText("");
                ArtistTableInsertFromManager_class.artist_dateOf_birth_txf.clear();
                
                ArtistTableInsertFromManager_class.toggle_grp_artist_sex.getToggles().removeAll(
                        ArtistTableInsertFromManager_class.artist_sex_rbtn_male,ArtistTableInsertFromManager_class.artist_sex_rbtn_female,
                        ArtistTableInsertFromManager_class.artist_sex_rbtn_other);
                ArtistTableInsertFromManager_class.toggle_grp_artist_fav_genre.getToggles().removeAll(
                    ArtistTableInsertFromManager_class.artist_fav_genre_fauvism_rbtn,ArtistTableInsertFromManager_class.artist_fav_genre_maritime_rbtn,
                        ArtistTableInsertFromManager_class.artist_fav_genre_postModern_rbtn,ArtistTableInsertFromManager_class.artist_fav_genre_renaissance_rbtn,
                        ArtistTableInsertFromManager_class.artist_fav_genre_symbolism_rbtn);

                                   myStage.setScene(manager_insertTables_scene);

                
            }
        });
        
        
        Button art_table_insert_from_manager_ok_btn = new Button();
        art_table_insert_from_manager_ok_btn.setLayoutX(scene_width-550);
        art_table_insert_from_manager_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        art_table_insert_from_manager_ok_btn.setText("OK");
        art_table_insert_from_manager_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                        
                       // System.out.println(ArtTableInsertFromManager_class.art_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                       String c_name=ArtTableInsertFromManager_class.art_title_txtf.getText();
                        String c_aname=ArtTableInsertFromManager_class.artist_name_txtf.getText();
                       String c_favGen=ArtTableInsertFromManager_class.toggle_grp_art_genre.getSelectedToggle().getUserData().toString();
                       String c_date=ArtTableInsertFromManager_class.art_date_txtf.getText();
                       String c_price=ArtTableInsertFromManager_class.art_price_txtf.getText();
                        String c_status=ArtTableInsertFromManager_class.toggle_grp_art_status.getSelectedToggle().getUserData().toString();
                        
                        
//                        String sqlCommand = "INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE,DATE_OF_BIRTH) VALUES('"+ c_id+ "','"+ c_name+ "',' "+c_username+ " ',' "+c_password+" ','" +c_sex+ "','" +c_adrs+ "','" +c_phn +"','" + c_email+"','"+c_favGen+"','"+c_dateOfbirth+"')";
//                        // String sqlCommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE)"+
//                             //    "VALUES('005','gh','af','gf',7,'Sb','oD')";
//    
//                        stmt.executeUpdate(sqlCommand);

                            String sqlcommand="INSERT INTO ARTS(ART_ID,ART_TITLE,ARTIST_ID,ART_GENRE,DATE_OF_CREATION,PRICE,STATUS) VALUES(SET_ARTID,?,FETCH_ARTISTID(?),?,?,?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside art");
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_aname);
                            pst110.setString(3,c_favGen);
                            pst110.setString(4,c_date);
                            pst110.setString(5,c_price);
                            pst110.setString(6,c_status);
           
                            
                            pst110.executeQuery();
                            
                            System.out.println("inside art 2");
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                ArtTableInsertFromManager_class.art_title_txtf.setText("");
                ArtTableInsertFromManager_class.artist_name_txtf.setText("");
               // ArtTableInsertFromManager_class.artist_name_txtf.setText("");
                ArtTableInsertFromManager_class.art_date_txtf.setText("");
                ArtTableInsertFromManager_class.art_price_txtf.setText("");
      
                
               
                ArtTableInsertFromManager_class.toggle_grp_art_genre.getToggles().removeAll(
                    ArtTableInsertFromManager_class.art_genre_fauvism_rbtn,ArtTableInsertFromManager_class.art_genre_maritime_rbtn,
                        ArtTableInsertFromManager_class.art_genre_postModern_rbtn,ArtTableInsertFromManager_class.art_genre_renaissance_rbtn,
                        ArtTableInsertFromManager_class.art_genre_symbolism_rbtn);
                
                ArtTableInsertFromManager_class.toggle_grp_art_status.getToggles().removeAll(
                      ArtTableInsertFromManager_class.art_status_rbtn_available,ArtTableInsertFromManager_class.art_status_rbtn_sold  
                );

                
//                customer_sex_rbtn_male.setUserData("");
//                customer_sex_rbtn_female.setUserData("");
//                customer_sex_rbtn_other.setUserData("");
                
                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        

        
        Button art_table_insert_page_from_manager_back_btn= new Button();
        art_table_insert_page_from_manager_back_btn.setLayoutX(scene_width-950);
        art_table_insert_page_from_manager_back_btn.setLayoutY(scene_height-800);
        art_table_insert_page_from_manager_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        art_table_insert_page_from_manager_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                 ArtTableInsertFromManager_class.art_title_txtf.setText("");
                ArtTableInsertFromManager_class.artist_name_txtf.setText("");
               // ArtTableInsertFromManager_class.artist_name_txtf.setText("");
                ArtTableInsertFromManager_class.art_date_txtf.setText("");
                ArtTableInsertFromManager_class.art_price_txtf.setText("");
      
                
               
                ArtTableInsertFromManager_class.toggle_grp_art_genre.getToggles().removeAll(
                    ArtTableInsertFromManager_class.art_genre_fauvism_rbtn,ArtTableInsertFromManager_class.art_genre_maritime_rbtn,
                        ArtTableInsertFromManager_class.art_genre_postModern_rbtn,ArtTableInsertFromManager_class.art_genre_renaissance_rbtn,
                        ArtTableInsertFromManager_class.art_genre_symbolism_rbtn);
                
                ArtTableInsertFromManager_class.toggle_grp_art_status.getToggles().removeAll(
                      ArtTableInsertFromManager_class.art_status_rbtn_available,ArtTableInsertFromManager_class.art_status_rbtn_sold  
                );
                                   myStage.setScene(manager_insertTables_scene);

                
            }
        });
        
        
        Button employee_table_insert_from_manager_ok_btn = new Button();
        employee_table_insert_from_manager_ok_btn.setLayoutX(scene_width-550);
        employee_table_insert_from_manager_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        employee_table_insert_from_manager_ok_btn.setText("OK");
        employee_table_insert_from_manager_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                       System.out.println(EmployeeTableInsertFromManager_class.employee_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                        String c_name=EmployeeTableInsertFromManager_class.employee_name_txtf.getText();
                        String c_sex=EmployeeTableInsertFromManager_class.toggle_grp_employee_sex.getSelectedToggle().getUserData().toString();
                        String c_adrs =EmployeeTableInsertFromManager_class.employee_adrs_txtf.getText();
                        String c_mname = EmployeeTableInsertFromManager_class.employee_manager_name_txtf.getText();
                        
                        
                        String c_phn= EmployeeTableInsertFromManager_class.employee_phn_txtf.getText();
                        String c_email= EmployeeTableInsertFromManager_class.employee_email_txtf.getText();
                        String c_salary=EmployeeTableInsertFromManager_class.employee_salary_txtf.getText();
                        //String c_favGen=EmployeeTableInsertFromManager_class.toggle_grp_customer_fav_genre.getSelectedToggle().getUserData().toString();
                        String c_username = EmployeeTableInsertFromManager_class.employee_username_txtf.getText();
                        String c_password = EmployeeTableInsertFromManager_class.employee_password_txtf.getText();
                        String c_dateOfbirth= EmployeeTableInsertFromManager_class.employee_dateOf_birth_txtf.getText();
                        String c_join_date= EmployeeTableInsertFromManager_class.employee_join_date_txtf.getText();
                        String c_end_date=EmployeeTableInsertFromManager_class.employee_end_date_txtf.getText();
                        
                       // System.out.println(ArtTableInsertFromManager_class.art_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                      
                        
                        
//                        String sqlCommand = "INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE,DATE_OF_BIRTH) VALUES('"+ c_id+ "','"+ c_name+ "',' "+c_username+ " ',' "+c_password+" ','" +c_sex+ "','" +c_adrs+ "','" +c_phn +"','" + c_email+"','"+c_favGen+"','"+c_dateOfbirth+"')";
//                        // String sqlCommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE)"+
//                             //    "VALUES('005','gh','af','gf',7,'Sb','oD')";
//    
//                        stmt.executeUpdate(sqlCommand);

                            String sqlcommand="INSERT INTO EMPLOYEES(EMPLOYEE_ID,EMPLOYEE_NAME,USER_NAME,PASSWORD,MANAGER_ID,ADDRESS,SEX,SALARY,PHONE_NO,EMAIL_ID,DATE_OF_BIRTH,JOIN_DATE,END_DATE) VALUES(SET_EMPLOYEEID,?,?,?,FETCH_MANAGERID(?),?,?,?,?,?,?,?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            System.out.println(c_mname);
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_username);
                            pst110.setString(3,c_password);
                            pst110.setString(4,c_mname);
                            pst110.setString(5,c_adrs);
                            pst110.setString(6,c_sex);
                            pst110.setString(7,c_salary);
                            pst110.setString(8,c_phn);
                            pst110.setString(9,c_email);
                            pst110.setString(10,c_dateOfbirth);
                            pst110.setString(11,c_join_date);
                            pst110.setString(12,c_end_date);
           
                            
                            pst110.executeQuery();
                            
                            System.out.println("inside art 2");
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                EmployeeTableInsertFromManager_class.employee_name_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_adrs_txtf.setText("");
               // ArtTableInsertFromManager_class.artist_name_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_manager_name_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_phn_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_email_txtf.setText("");
                        
                EmployeeTableInsertFromManager_class.employee_salary_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_username_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_password_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_dateOf_birth_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_join_date_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_end_date_txtf.setText("");
                        
      
                
               
       
                
                EmployeeTableInsertFromManager_class.toggle_grp_employee_sex.getToggles().removeAll(
                      EmployeeTableInsertFromManager_class.employee_sex_rbtn_male,EmployeeTableInsertFromManager_class.employee_sex_rbtn_female,
                       EmployeeTableInsertFromManager_class.employee_sex_rbtn_other
                );

                
//                customer_sex_rbtn_male.setUserData("");
//                customer_sex_rbtn_female.setUserData("");
//                customer_sex_rbtn_other.setUserData("");
                
                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        

        
        Button employee_table_insert_page_from_manager_back_btn= new Button();
        employee_table_insert_page_from_manager_back_btn.setLayoutX(scene_width-950);
        employee_table_insert_page_from_manager_back_btn.setLayoutY(scene_height-800);
        employee_table_insert_page_from_manager_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        employee_table_insert_page_from_manager_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                
                 EmployeeTableInsertFromManager_class.employee_name_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_adrs_txtf.setText("");
               // ArtTableInsertFromManager_class.artist_name_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_manager_name_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_phn_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_email_txtf.setText("");
                        
                EmployeeTableInsertFromManager_class.employee_salary_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_username_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_password_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_dateOf_birth_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_join_date_txtf.setText("");
                EmployeeTableInsertFromManager_class.employee_end_date_txtf.setText("");
                        
      
                
               
       
                
                EmployeeTableInsertFromManager_class.toggle_grp_employee_sex.getToggles().removeAll(
                      EmployeeTableInsertFromManager_class.employee_sex_rbtn_male,EmployeeTableInsertFromManager_class.employee_sex_rbtn_female,
                       EmployeeTableInsertFromManager_class.employee_sex_rbtn_other
                );
                                   myStage.setScene(manager_insertTables_scene);

                
            }
        });
        
        
        Button exhibition_table_insert_from_manager_ok_btn = new Button();
        exhibition_table_insert_from_manager_ok_btn.setLayoutX(scene_width-550);
        exhibition_table_insert_from_manager_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_manager_ok_btn.setText("OK");
        exhibition_table_insert_from_manager_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                       String c_name=ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText();
                       String c_hname=ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText();
                       String c_aname=ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText();
                       String c_start_date=ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText();
                       String c_end_date=ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText();
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_hname);
                            pst110.setString(3,c_aname);
                            pst110.setString(4,c_start_date);
                            pst110.setString(5,c_end_date);

           
                            
                            pst110.executeQuery();
                            
                            System.out.println("inside art 2");
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
 //                   ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        
              
        Button exhibition_table_insert_from_manager_more_art_btn = new Button();
        exhibition_table_insert_from_manager_more_art_btn.setLayoutX(scene_width-500);
        exhibition_table_insert_from_manager_more_art_btn.setLayoutY(scene_height-650);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_manager_more_art_btn.setText("Add Arts");
        exhibition_table_insert_from_manager_more_art_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
//                       String c_name=ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText();
//                       String c_hname=ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText();
//                       String c_aname=ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText();
//                       String c_start_date=ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText();
//                       String c_end_date=ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText();
                       
                       
                       ExhibitionTableInsertFromManager_addartclass.exhibition_name_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText());
                       ExhibitionTableInsertFromManager_addartclass.exhibition_hall_name_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText());
                      // ExhibitionTableInsertFromManager_addartclass.exhibition_art_name_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText());
                       ExhibitionTableInsertFromManager_addartclass.exhibition_start_date_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText());
                      ExhibitionTableInsertFromManager_addartclass.exhibition_end_date_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText());
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
//                            pst110.setString(1,c_name);
//                            pst110.setString(2,c_hname);
//                            pst110.setString(3,c_aname);
//                            pst110.setString(4,c_start_date);
//                            pst110.setString(5,c_end_date);
//
//           
//                            
//                            pst110.executeQuery();
//                            
//                            System.out.println("inside art 2");
//                            
//                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                        //error_show.setText("ERROR");
//                        //customer_grp_insrt.getChildren().add(error_show);
//                       // System.out.println("pblm at OK ");
//                       //ex.printStackTrace();
//                      
//                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
               myStage.setScene(exhibition_table_insert_from_manager_addartscne);
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        Button exhibition_table_insert_from_manager_more_exhibition_btn = new Button();
        exhibition_table_insert_from_manager_more_exhibition_btn.setLayoutX(scene_width-500);
        exhibition_table_insert_from_manager_more_exhibition_btn.setLayoutY(scene_height-600);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_manager_more_exhibition_btn.setText("Add Exhibitions");
        exhibition_table_insert_from_manager_more_exhibition_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
//                       String c_name=ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText();
//                       String c_hname=ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText();
//                       String c_aname=ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText();
//                       String c_start_date=ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText();
//                       String c_end_date=ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText();
                       
                       
                       ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
                       ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                       ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
                       ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
                      ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
//                            pst110.setString(1,c_name);
//                            pst110.setString(2,c_hname);
//                            pst110.setString(3,c_aname);
//                            pst110.setString(4,c_start_date);
//                            pst110.setString(5,c_end_date);
//
//           
//                            
//                            pst110.executeQuery();
//                            
//                            System.out.println("inside art 2");
//                            
//                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                        //error_show.setText("ERROR");
//                        //customer_grp_insrt.getChildren().add(error_show);
//                       // System.out.println("pblm at OK ");
//                       //ex.printStackTrace();
//                      
//                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
              // myStage.setScene(exhibition_table_insert_from_manager_addartscne);
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        
        
        
        Button exhibition_table_insert_from_manager_moreart_ok_btn = new Button();
        exhibition_table_insert_from_manager_moreart_ok_btn.setLayoutX(scene_width-550);
        exhibition_table_insert_from_manager_moreart_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_manager_moreart_ok_btn.setText("OK");
        exhibition_table_insert_from_manager_moreart_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                       String c_name=ExhibitionTableInsertFromManager_addartclass.exhibition_name_txtf.getText();
                       String c_hname=ExhibitionTableInsertFromManager_addartclass.exhibition_hall_name_txtf.getText();
                       String c_aname=ExhibitionTableInsertFromManager_addartclass.exhibition_art_name_txtf.getText();
                       String c_start_date=ExhibitionTableInsertFromManager_addartclass.exhibition_start_date_txtf.getText();
                       String c_end_date=ExhibitionTableInsertFromManager_addartclass.exhibition_end_date_txtf.getText();
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_SAME_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_hname);
                            pst110.setString(3,c_aname);
                            pst110.setString(4,c_start_date);
                            pst110.setString(5,c_end_date);

           
                            
                            pst110.executeQuery();
                            
                            System.out.println("inside art 2");
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
 //                   ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        Button exhibition_table_insert_from_manager_more_page_more_art_btn = new Button();
        exhibition_table_insert_from_manager_more_page_more_art_btn.setLayoutX(scene_width-500);
        exhibition_table_insert_from_manager_more_page_more_art_btn.setLayoutY(scene_height-650);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_manager_more_page_more_art_btn.setText("Add Arts");
        exhibition_table_insert_from_manager_more_page_more_art_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
//                       String c_name=ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText();
//                       String c_hname=ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText();
//                       String c_aname=ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText();
//                       String c_start_date=ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText();
//                       String c_end_date=ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText();
                       
                       
                       ExhibitionTableInsertFromManager_addartclass.exhibition_name_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText());
                       ExhibitionTableInsertFromManager_addartclass.exhibition_hall_name_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText());
                      // ExhibitionTableInsertFromManager_addartclass.exhibition_art_name_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText());
                       ExhibitionTableInsertFromManager_addartclass.exhibition_start_date_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText());
                      ExhibitionTableInsertFromManager_addartclass.exhibition_end_date_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText());
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
//                            pst110.setString(1,c_name);
//                            pst110.setString(2,c_hname);
//                            pst110.setString(3,c_aname);
//                            pst110.setString(4,c_start_date);
//                            pst110.setString(5,c_end_date);
//
//           
//                            
//                            pst110.executeQuery();
//                            
//                            System.out.println("inside art 2");
//                            
//                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                        //error_show.setText("ERROR");
//                        //customer_grp_insrt.getChildren().add(error_show);
//                       // System.out.println("pblm at OK ");
//                       //ex.printStackTrace();
//                      
//                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
               myStage.setScene(exhibition_table_insert_from_manager_addartscne);
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        Button exhibition_table_insert_page_from_manager_addart_back_btn= new Button();
        exhibition_table_insert_page_from_manager_addart_back_btn.setLayoutX(scene_width-950);
        exhibition_table_insert_page_from_manager_addart_back_btn.setLayoutY(scene_height-800);
        exhibition_table_insert_page_from_manager_addart_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        exhibition_table_insert_page_from_manager_addart_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                   ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
                                   myStage.setScene(exhibition_table_insert_from_manager_scene);

                
            }
        });
 
        
        

        
  
        

        
        Button exhibition_table_insert_page_from_manager_back_btn= new Button();
        exhibition_table_insert_page_from_manager_back_btn.setLayoutX(scene_width-950);
        exhibition_table_insert_page_from_manager_back_btn.setLayoutY(scene_height-800);
        exhibition_table_insert_page_from_manager_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        exhibition_table_insert_page_from_manager_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                   ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
                                   myStage.setScene(manager_insertTables_scene);

                
            }
        });
 


        Button hallroom_table_insert_from_manager_ok_btn = new Button();
        hallroom_table_insert_from_manager_ok_btn.setLayoutX(scene_width-550);
        hallroom_table_insert_from_manager_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        hallroom_table_insert_from_manager_ok_btn.setText("OK");
        hallroom_table_insert_from_manager_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                        String c_name=HallRoomTableInsertFromManager_class.hall_name_txtf.getText();
                       
                            String sqlcommand="INSERT INTO HALLROOM(HALL_ID,HALL_NAME) VALUES(SET_HALLID,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
                            pst110.setString(1,c_name);

           
                            
                            pst110.executeQuery();
                            
                            System.out.println("inside art 2");
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                HallRoomTableInsertFromManager_class.hall_name_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        

        
        Button hallroom_table_insert_page_from_manager_back_btn= new Button();
        hallroom_table_insert_page_from_manager_back_btn.setLayoutX(scene_width-950);
        hallroom_table_insert_page_from_manager_back_btn.setLayoutY(scene_height-800);
        hallroom_table_insert_page_from_manager_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        hallroom_table_insert_page_from_manager_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                HallRoomTableInsertFromManager_class.hall_name_txtf.setText("");
                                   myStage.setScene(manager_insertTables_scene);

                
            }
        });

        Button manager_showTables_page_customer_btn= new Button();
        manager_showTables_page_customer_btn.setLayoutX(scene_width-620);
        manager_showTables_page_customer_btn.setLayoutY(scene_height-750);
        //manager_showTables_page_customer_btn.setGraphic(customer_txt);
        manager_showTables_page_customer_btn.setText("CUSTOMERS");
        manager_showTables_page_customer_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( customer_table_show_from_manager_scene);
            }
        });
        
        
        Button customer_table_show_page_from_manager_back_btn= new Button();
        customer_table_show_page_from_manager_back_btn.setLayoutX(scene_width-950);
        customer_table_show_page_from_manager_back_btn.setLayoutY(scene_height-800);
        customer_table_show_page_from_manager_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        customer_table_show_page_from_manager_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                                   myStage.setScene(manager_showTables_scene);

                
            }
        });
        
        
        
        
         Button manager_showTables_page_employee_btn= new Button();
        manager_showTables_page_employee_btn.setLayoutX(scene_width-620);
        manager_showTables_page_employee_btn.setLayoutY(scene_height-670);
        //manager_showTables_page_employee_btn.setGraphic(employee_txt);
        manager_showTables_page_employee_btn.setText("EMPLOYEES");
        manager_showTables_page_employee_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
         Button manager_showTables_page_manager_btn= new Button();
        manager_showTables_page_manager_btn.setLayoutX(scene_width-620);
        manager_showTables_page_manager_btn.setLayoutY(scene_height-590);
        //manager_showTables_page_manager_btn.setGraphic(manager_txt);
        manager_showTables_page_manager_btn.setText("MANAGERS");
        manager_showTables_page_manager_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
         Button manager_showTables_page_artist_btn= new Button();
        manager_showTables_page_artist_btn.setLayoutX(scene_width-620);
        manager_showTables_page_artist_btn.setLayoutY(scene_height-510);
        //manager_showTables_page_artist_btn.setGraphic(artist_txt);
        manager_showTables_page_artist_btn.setText("ARTISTS");
        manager_showTables_page_artist_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
         Button manager_showTables_page_art_btn= new Button();
        manager_showTables_page_art_btn.setLayoutX(scene_width-620);
        manager_showTables_page_art_btn.setLayoutY(scene_height-430);
        //manager_showTables_page_art_btn.setGraphic(arts_txt);
        manager_showTables_page_art_btn.setText("ARTS");
        manager_showTables_page_art_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
         Button manager_showTables_page_hallroom_btn= new Button();
        manager_showTables_page_hallroom_btn.setLayoutX(scene_width-620);
        manager_showTables_page_hallroom_btn.setLayoutY(scene_height-350);
        //manager_showTables_page_hallroom_btn.setGraphic(hallroom_txt);
        manager_showTables_page_hallroom_btn.setText("HALLROOM");
        manager_showTables_page_hallroom_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
         Button manager_showTables_page_exhitbition_btn= new Button();
        manager_showTables_page_exhitbition_btn.setLayoutX(scene_width-620);
        manager_showTables_page_exhitbition_btn.setLayoutY(scene_height-270);
        //manager_showTables_page_exhitbition_btn.setGraphic(exhibiton_txt);
        manager_showTables_page_exhitbition_btn.setText("EXHIBITIONS");
        manager_showTables_page_exhitbition_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
         Button manager_showTables_page_bill_btn= new Button();
        manager_showTables_page_bill_btn.setLayoutX(scene_width-620);
        manager_showTables_page_bill_btn.setLayoutY(scene_height-190);
        //manager_showTables_page_bill_btn.setGraphic(bill_txt);
        manager_showTables_page_bill_btn.setText("BILLS");
        manager_showTables_page_bill_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
         Button manager_showTables_page_payslip_btn= new Button();
        manager_showTables_page_payslip_btn.setLayoutX(scene_width-620);
        manager_showTables_page_payslip_btn.setLayoutY(scene_height-110);
        //manager_showTables_page_payslip_btn.setGraphic(payslip_txt);
        manager_showTables_page_payslip_btn.setText("PAYSLIPS");
        manager_showTables_page_payslip_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
        Button manager_showTables_page_home_btn= new Button();
        manager_showTables_page_home_btn.setLayoutX(scene_width-950);
        manager_showTables_page_home_btn.setLayoutY(scene_height-820);
        //manager_showTables_page_home_btn.setGraphic(payslip_txt);
        manager_showTables_page_home_btn.setText("HOME");
        manager_showTables_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene(manager_homepage_scene);
            }
        });
        
        Button manager_showTables_page_logout_btn= new Button();
        manager_showTables_page_logout_btn.setLayoutX(scene_width-150);
        manager_showTables_page_logout_btn.setLayoutY(scene_height-820);
        //manager_showTables_page_home_btn.setGraphic(payslip_txt);
        manager_showTables_page_logout_btn.setText("LOGOUT");
        manager_showTables_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                           manager_loginCheck_page_error_show.setText("");
               myStage.setScene(login_page_scene);
            }
        });
        
        
        Button manager_query_page_employeeUnderMe_btn = new Button();
        manager_query_page_employeeUnderMe_btn.setLayoutX(scene_width-650);
        manager_query_page_employeeUnderMe_btn.setLayoutY(scene_height-700);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        manager_query_page_employeeUnderMe_btn.setText("EMPLOYEES UNDER ME");
        manager_query_page_employeeUnderMe_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_insertTables_scene);
                //employeeUnderM_txt.setText();
                //employeeUnderM_txt.setText(employeeUnderM_show_str);
                
                String []output_employees_under = new String[100];
         
         for(int i=0;i<100;i++){
             output_employees_under[i]="";
         }
         int i=0;
         
         try{
            // Statement stmt1=con.createStatement();
             String sqlcommand="SELECT * FROM EMPLOYEES WHERE MANAGER_ID=(SELECT MANAGER_ID FROM MANAGERS WHERE MANAGER_ID=?)";
             
             PreparedStatement pst78=con.prepareStatement(sqlcommand);
             pst78.setString(1, ID);


              ResultSet rs = pst78.executeQuery();
              System.out.println("after query");
           
            while(rs.next()){
                
                
                output_employees_under[i]=rs.getString(1)+ "   "+rs.getString(2)+ "    "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7)+"   "+rs.getString(8)+"   "+rs.getString(9);

                //output[i]=rs.getString(1)+ "  "+rs.getString(2);
                //query_show.setText("query");
                i++;
                System.out.println("hihihi");
                
                
            }
            
            pst78.close();
             
           
         }catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Connection prbl");
         
     } 
        String employees_under_page_result_str= new String();
        employees_under_page_result_str= String.join("\n",output_employees_under);
        employeeUnderM_txt.setText(employees_under_page_result_str);
                myStage.setScene(manager_employeesUnderMe_scene);
            
            }
        });
        
        MenuButton manager_query_page_informationOf_mbtn= new MenuButton();
        manager_query_page_informationOf_mbtn.setText("Information of a/an...");
        manager_query_page_informationOf_mbtn.setLayoutX(scene_width-650);
        manager_query_page_informationOf_mbtn.setLayoutY(scene_height-600);
        
        MenuItem manager_query_page_employeeInfo_mitem = new MenuItem("Employee");
        MenuItem manager_query_page_customerInfo_mitem = new MenuItem("Customer");
        MenuItem manager_query_page_artistInfo_mitem = new MenuItem("Artist");
        MenuItem manager_query_page_artInfo_mitem = new MenuItem("Art");
        
        manager_query_page_informationOf_mbtn.getItems().addAll(manager_query_page_artInfo_mitem,manager_query_page_artistInfo_mitem,
                manager_query_page_customerInfo_mitem,manager_query_page_employeeInfo_mitem);
        
//        
//        Button manager_query_page_employeeInfo_btn = new Button();
//        manager_query_page_employeeInfo_btn.setLayoutX(scene_width-650);
//        manager_query_page_employeeInfo_btn.setLayoutY(scene_height-600);
//        //manager_homepage_insert_btn.setGraphic(insert_txt);
//        manager_query_page_employeeInfo_btn.setText("ONE EMPLOYEE'S INFORMATION");
        manager_query_page_employeeInfo_mitem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(manager_employeeInfo_scene);
                
            }
        });
        
        
//        Button manager_query_page_customerInfo_btn = new Button();
//        manager_query_page_customerInfo_btn.setLayoutX(scene_width-650);
//        manager_query_page_customerInfo_btn.setLayoutY(scene_height-500);
//        //manager_homepage_insert_btn.setGraphic(insert_txt);
//        manager_query_page_customerInfo_btn.setText("ONE CUSTOMER'S INFORMATION");
        manager_query_page_customerInfo_mitem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_insertTables_scene);
                myStage.setScene(manager_customerInfo_scene);
            }
        });
        
//         Button manager_query_page_artistInfo_btn = new Button();
//        manager_query_page_artistInfo_btn.setLayoutX(scene_width-650);
//        manager_query_page_artistInfo_btn.setLayoutY(scene_height-400);
//        //manager_homepage_insert_btn.setGraphic(insert_txt);
//        manager_query_page_artistInfo_btn.setText("ONE ARTIST'S INFORMATION");
        manager_query_page_artistInfo_mitem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_insertTables_scene);
                myStage.setScene(manager_artistInfo_scene);
            }
        });
        
//         Button manager_query_page_artInfo_btn = new Button();
//        manager_query_page_artInfo_btn.setLayoutX(scene_width-650);
//        manager_query_page_artInfo_btn.setLayoutY(scene_height-300);
//        //manager_homepage_insert_btn.setGraphic(insert_txt);
//        manager_query_page_artInfo_btn.setText("ONE ART'S INFORMATION");
        manager_query_page_artInfo_mitem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_insertTables_scene);
                myStage.setScene(manager_artInfo_scene);
            }
        });
        
        
        Button manager_query_page_artsOfartist_btn = new Button();
        manager_query_page_artsOfartist_btn.setLayoutX(scene_width-650);
        manager_query_page_artsOfartist_btn.setLayoutY(scene_height-500);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        manager_query_page_artsOfartist_btn.setText("ARTS OF AN ARTIST");
        manager_query_page_artsOfartist_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                //System.out.println("Hello World!");
                myStage.setScene(manager_artsOfartist_scene);
            }
        });
        
        Button manager_query_page_artStatus_btn = new Button();
        manager_query_page_artStatus_btn.setLayoutX(scene_width-650);
        manager_query_page_artStatus_btn.setLayoutY(scene_height-400);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        manager_query_page_artStatus_btn.setText("STATUS OF AN ART");
        manager_query_page_artStatus_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                
                //System.out.println("Hello World!");
                myStage.setScene(manager_artStatus_scene);
            }
        });
        
        
         Button  manager_query_page_bill_from_date_btn = new Button();
        manager_query_page_bill_from_date_btn.setLayoutX(scene_width-650);
        manager_query_page_bill_from_date_btn.setLayoutY(scene_height-300);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        manager_query_page_bill_from_date_btn.setText("Check Bill");
        manager_query_page_bill_from_date_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                
                //System.out.println("Hello World!");
                
                
                myStage.setScene(manager_bill_from_date_scene);
            }
        });
        
        
        
         Button manager_query_page_logout_btn= new Button();
        manager_query_page_logout_btn.setLayoutX(scene_width-150);
        manager_query_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        manager_query_page_logout_btn.setText("LOG OUT");
        manager_query_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                           manager_loginCheck_page_error_show.setText("");
                myStage.setScene(login_page_scene);
            }
        });
        
         Button manager_query_page_home_btn= new Button();
        manager_query_page_home_btn.setLayoutX(scene_width-950);
        manager_query_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_query_page_home_btn.setText("HOME");
        manager_query_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(manager_homepage_scene);
            }
        });
        
         Button manager_art_status_page_ok_btn= new Button();
        manager_art_status_page_ok_btn.setLayoutX(scene_width-750);
        manager_art_status_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_art_status_page_ok_btn.setText("OK");
        manager_art_status_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                
                    if(con!=null){
                    try{
                        //Statement stmt2=con.createStatement();
                        
                        
                        System.out.println("inside catch");
                        String a_status=manager_art_status_page_art_id_txf.getText();
                        
                        String sqlcommand="SELECT SEARCH_ART_STATUS(ART_ID) FROM ARTS WHERE ART_ID=? ";
                        PreparedStatement pst= con.prepareStatement(sqlcommand);
                        System.out.println("pst inside");
                        pst.setString(1, a_status);
                        System.out.println("after set string");
                        ResultSet rs=pst.executeQuery();
                        System.out.println("execute");
                        
                        while(rs.next()){
                            
                            manager_art_status_page_status_txt.setText(rs.getString(1).toString());
                        }
                        pst.close();
                        
                    } catch(SQLException e){
                        System.out.println(e.toString());
                        System.out.println("pbl");
                    }
                }
                manager_art_status_page_art_id_txf.clear();
                
            }
        });
        
         Button manager_art_status_page_back_btn= new Button();
        manager_art_status_page_back_btn.setLayoutX(scene_width-950);
        manager_art_status_page_back_btn.setLayoutY(scene_height-800);
        manager_art_status_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        manager_art_status_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                manager_art_status_page_status_txt.setText("");
                                   myStage.setScene(manager_query_page_scene);

                
            }
        });
        
        
        Button manager_employeeInfo_page_ok_btn= new Button();
        manager_employeeInfo_page_ok_btn.setLayoutX(scene_width-750);
        manager_employeeInfo_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_employeeInfo_page_ok_btn.setText("OK");
        manager_employeeInfo_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                
                  if(con!=null){
                    try{
                        String a_id=manager_employeeInfo_page_txtf.getText();
                        String sqlcommand="SELECT EMPLOYEE_NAME,FETCH_MANAGER(MANAGER_ID),ADDRESS,SEX,SALARY,PHONE_NO,EMAIL_ID,DATE_OF_BIRTH,JOIN_DATE,END_DATE FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
                        
                        PreparedStatement pst99=con.prepareStatement(sqlcommand);
                        pst99.setString(1,a_id);
                        
                        ResultSet rs=pst99.executeQuery();
                        
                        while(rs.next()){
//                            an_artInfo_from_manager_class.artTitle_result_txt.setText(rs.getString(1).toString());
//                            an_artInfo_from_manager_class.art_genre_result_txt.setText(rs.getString(2).toString());
//                            an_artInfo_from_manager_class.artist_name_result_txt.setText(rs.getString(3).toString());
//                            an_artInfo_from_manager_class.dateOfcreation_result_txt.setText(rs.getString(4));
//                            an_artInfo_from_manager_class.price_result_txt.setText(rs.getString(5).toString());
//                            an_artInfo_from_manager_class.status_result_txt.setText(rs.getString(6).toString());

                             one_employeeInfo_from_manager_class.employee_name_result_txt.setText(rs.getString(1).toString());
                             one_employeeInfo_from_manager_class.manager_name_result_txt.setText(rs.getString(2));
                              one_employeeInfo_from_manager_class.address_result_txt.setText(rs.getString(3));
                               one_employeeInfo_from_manager_class.sex_result_txt.setText(rs.getString(4));
                                one_employeeInfo_from_manager_class.salary_result_txt.setText(rs.getString(5));
                                 one_employeeInfo_from_manager_class.phone_no_result_txt.setText(rs.getString(6));
                                  one_employeeInfo_from_manager_class.email_ID_result_txt.setText(rs.getString(7));
                                   one_employeeInfo_from_manager_class.dateOf_birth_result_txt.setText(rs.getString(8));
                                    one_employeeInfo_from_manager_class.join_date_result_txt.setText(rs.getString(9));
                                     one_employeeInfo_from_manager_class.end_date_result_txt.setText(rs.getString(10));
                            
                            
                            
                        }
                        
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                    }
                }
                
                manager_employeeInfo_page_txtf.clear();
                //manager_employeeInfo_page_result_txt.setText("result");
            }
        });
        
         Button manager_employeeInfo_page_back_btn= new Button();
        manager_employeeInfo_page_back_btn.setLayoutX(scene_width-950);
        manager_employeeInfo_page_back_btn.setLayoutY(scene_height-800);
        manager_employeeInfo_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        manager_employeeInfo_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //manager_employeeInfo_page_result_txt.setText("");
                one_employeeInfo_from_manager_class.address_result_txt.setText("");
                one_employeeInfo_from_manager_class.dateOf_birth_result_txt.setText("");
                one_employeeInfo_from_manager_class.email_ID_result_txt.setText("");
                one_employeeInfo_from_manager_class.employee_name_result_txt.setText("");
                one_employeeInfo_from_manager_class.end_date_result_txt.setText("");
                one_employeeInfo_from_manager_class.join_date_result_txt.setText("");
                one_employeeInfo_from_manager_class.manager_name_result_txt.setText("");
                one_employeeInfo_from_manager_class.phone_no_result_txt.setText("");
                one_employeeInfo_from_manager_class.salary_result_txt.setText("");
                one_employeeInfo_from_manager_class.sex_result_txt.setText("");
                
                
                                   myStage.setScene(manager_query_page_scene);

                
            }
        });
        
        
         Button manager_customerInfo_page_ok_btn= new Button();
        manager_customerInfo_page_ok_btn.setLayoutX(scene_width-750);
        manager_customerInfo_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_customerInfo_page_ok_btn.setText("OK");
        manager_customerInfo_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                    if(con!=null){
                    try{
                        String c_id=managerr_customerInfo_page_txtf.getText();
                        String sqlcommand="SELECT CUSTOMER_NAME,ADDRESS,SEX,PHONE_NO,EMAIL_ID,DATE_OF_BIRTH,FAVORITE_GENRE FROM CUSTOMERS WHERE CUSTOMER_ID=?";
                       
                        PreparedStatement pst12=con.prepareStatement(sqlcommand);
                        pst12.setString(1, c_id);
                        
                        ResultSet rs=pst12.executeQuery();
                        
                        while(rs.next()){
                            one_customerInfo_from_manager_class.customer_name_result_txt.setText(rs.getString(1));
                            one_customerInfo_from_manager_class.address_result_txt.setText(rs.getString(2));
                            one_customerInfo_from_manager_class.sex_result_txt.setText(rs.getString(3));
                            one_customerInfo_from_manager_class.phone_no_result_txt.setText(rs.getString(4));
                            one_customerInfo_from_manager_class.email_ID_result_txt.setText(rs.getString(5));
                            one_customerInfo_from_manager_class.dateOf_birth_result_txt.setText(rs.getString(6));
                            one_customerInfo_from_manager_class.favorite_genre_result_txt.setText(rs.getString(7));
                            
			
                        }
			pst12.close();
                    }catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                    }

            }
                    managerr_customerInfo_page_txtf.clear();
                    }
                 
                });
        
        
         Button manager_customerInfo_page_back_btn= new Button();
        manager_customerInfo_page_back_btn.setLayoutX(scene_width-950);
        manager_customerInfo_page_back_btn.setLayoutY(scene_height-800);
        manager_customerInfo_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        manager_customerInfo_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                            one_customerInfo_from_manager_class.customer_name_result_txt.setText("");
                            one_customerInfo_from_manager_class.address_result_txt.setText("");
                            one_customerInfo_from_manager_class.sex_result_txt.setText("");
                            one_customerInfo_from_manager_class.phone_no_result_txt.setText("");
                            one_customerInfo_from_manager_class.email_ID_result_txt.setText("");
                            one_customerInfo_from_manager_class.dateOf_birth_result_txt.setText("");
                            one_customerInfo_from_manager_class.favorite_genre_result_txt.setText("");





                                   myStage.setScene(manager_query_page_scene);

                
            }
        });
        
        
         Button manager_artistInfo_page_ok_btn= new Button();
        manager_artistInfo_page_ok_btn.setLayoutX(scene_width-750);
        manager_artistInfo_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_artistInfo_page_ok_btn.setText("OK");
        manager_artistInfo_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                if(con!=null){
                    try{
                        String a_id=managerr_artistInfo_page_txtf.getText();
                        //int A_ID=Integer.parseInt(a_id);
                        System.out.println(a_id);
                        String sqlcommand="SELECT ARTIST_NAME ,ADDRESS,SEX,PHONE_NO,EMAIL_ID,DATE_OF_BIRTH,MAIN_GENRE FROM ARTISTS WHERE ARTIST_ID=?";
                        
                        PreparedStatement pst99=con.prepareStatement(sqlcommand);
                        pst99.setString(1,a_id);
                       // pst99.setInt(1, A_ID);
                        
                        ResultSet rs=pst99.executeQuery();
                        
                        while(rs.next()){
                            one_artistInfo_from_manager_class.artist_name_result_txt.setText(rs.getString(1));
                            one_artistInfo_from_manager_class.address_result_txt.setText(rs.getString(2));
                            one_artistInfo_from_manager_class.sex_result_txt.setText(rs.getString(3));
                            one_artistInfo_from_manager_class.phone_no_result_txt.setText(rs.getString(4));
                            one_artistInfo_from_manager_class.email_ID_result_txt.setText(rs.getString(5));
                            one_artistInfo_from_manager_class.dateOf_birth_result_txt.setText(rs.getString(6));
                            one_artistInfo_from_manager_class.main_genre_result_txt.setText(rs.getString(7));
                           // one_artistInfo_from_manager_class.artist_name_result_txt.setText(rs.getString(1));
                            

                            
                            
                        }
                        pst99.close();
                        
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                    }
                }
                managerr_artistInfo_page_txtf.clear();
                //manager_artistInfo_page_result_txt.setText("result");
            }
        });
        
         Button manager_artistInfo_page_back_btn= new Button();
        manager_artistInfo_page_back_btn.setLayoutX(scene_width-950);
        manager_artistInfo_page_back_btn.setLayoutY(scene_height-800);
        manager_artistInfo_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        manager_artistInfo_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                            one_artistInfo_from_manager_class.artist_name_result_txt.setText("");
                            one_artistInfo_from_manager_class.address_result_txt.setText("");
                            one_artistInfo_from_manager_class.sex_result_txt.setText("");
                            one_artistInfo_from_manager_class.phone_no_result_txt.setText("");
                            one_artistInfo_from_manager_class.email_ID_result_txt.setText("");
                            one_artistInfo_from_manager_class.dateOf_birth_result_txt.setText("");
                            one_artistInfo_from_manager_class.main_genre_result_txt.setText("");


                                   myStage.setScene(manager_query_page_scene);

                
            }
        });
        
        
         Button manager_artInfo_page_ok_btn= new Button();
        manager_artInfo_page_ok_btn.setLayoutX(scene_width-750);
        manager_artInfo_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_artInfo_page_ok_btn.setText("OK");
        manager_artInfo_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                if(con!=null){
                    try{
                        String a_id=managerr_artInfo_page_txtf.getText();
                        int A_ID=Integer.parseInt(a_id);
                        System.out.println(a_id);
                        String sqlcommand="SELECT ART_TITLE,ART_GENRE, FETCH_ARTIST(ARTIST_ID),DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE ART_ID=?";
                        
                        PreparedStatement pst99=con.prepareStatement(sqlcommand);
                        //pst99.setString(1,a_id);
                        pst99.setInt(1, A_ID);
                        
                        ResultSet rs=pst99.executeQuery();
                        
                        while(rs.next()){
//                            one_employeeInfo_from_manager_class.employee_name_result_txt.setText(rs.getString(1));
//                             one_employeeInfo_from_manager_class.manager_name_result_txt.setText(rs.getString(2));
//                              one_employeeInfo_from_manager_class.address_result_txt.setText(rs.getString(3));
//                               one_employeeInfo_from_manager_class.sex_result_txt.setText(rs.getString(4));
//                                one_employeeInfo_from_manager_class.salary_result_txt.setText(rs.getString(5));
//                                 one_employeeInfo_from_manager_class.phone_no_result_txt.setText(rs.getString(6));
//                                  one_employeeInfo_from_manager_class.email_ID_result_txt.setText(rs.getString(7));
//                                   one_employeeInfo_from_manager_class.dateOf_birth_result_txt.setText(rs.getString(8));
//                                    one_employeeInfo_from_manager_class.join_date_result_txt.setText(rs.getString(9));
//                                     one_employeeInfo_from_manager_class.end_date_result_txt.setText(rs.getString(10));
//                            
                              an_artInfo_from_manager_class.artTitle_result_txt.setText(rs.getString(1).toString());
                            an_artInfo_from_manager_class.art_genre_result_txt.setText(rs.getString(2).toString());
                            an_artInfo_from_manager_class.artist_name_result_txt.setText(rs.getString(3).toString());
                            an_artInfo_from_manager_class.dateOfcreation_result_txt.setText(rs.getString(4));
                            an_artInfo_from_manager_class.price_result_txt.setText(rs.getString(5).toString());
                            an_artInfo_from_manager_class.status_result_txt.setText(rs.getString(6).toString());
                            
                            
                        }
                        
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                    }
                }
                managerr_artInfo_page_txtf.clear();
                //manager_artInfo_page_result_txt.setText("result");
            }
        });
        
         Button manager_artInfo_page_back_btn= new Button();
        manager_artInfo_page_back_btn.setLayoutX(scene_width-950);
        manager_artInfo_page_back_btn.setLayoutY(scene_height-800);
        manager_artInfo_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        manager_artInfo_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                an_artInfo_from_manager_class.artTitle_result_txt.setText("");
                an_artInfo_from_manager_class.art_genre_result_txt.setText("");
                an_artInfo_from_manager_class.artist_name_result_txt.setText("");
                an_artInfo_from_manager_class.dateOfcreation_result_txt.setText("");
                an_artInfo_from_manager_class.price_result_txt.setText("");
                an_artInfo_from_manager_class.status_result_txt.setText("");
                
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //manager_artInfo_page_result_txt.setText("");
                                   myStage.setScene(manager_query_page_scene);

                
            }
        });
        
        
         Button manager_artOfartist_page_ok_btn= new Button();
        manager_artOfartist_page_ok_btn.setLayoutX(scene_width-750);
        manager_artOfartist_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_artOfartist_page_ok_btn.setText("OK");
        manager_artOfartist_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String []output_artists_art=new String[100];
                
                for(int i=0;i<100;i++){
                    output_artists_art[i]="";
                }
                int i=0;
                if(con!=null){
                    try{
                        String artist_art=managerr_artOfartist_page_txtf.getText();
                        
                        String sqlcommand="SELECT A2.Art_ID,A2.Art_title ,A2.Price,A2.Status FROM Artists A1 JOIN Arts A2 ON (A1.Artist_Id=A2.Artist_Id) WHERE A1.Artist_ID=?";
                          System.out.println(sqlcommand);                 
                                               
                                                
                        
                        PreparedStatement pst1=con.prepareStatement(sqlcommand);
                        pst1.setString(1, artist_art);
                        System.out.println("sdff");
                        
                        ResultSet rs=pst1.executeQuery();
                        System.out.println("asda");
                        
                        while(rs.next()){
                            
                            output_artists_art[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4);
                            i++;
                        }
                        pst1.close();
                    }catch(SQLException e){
                        System.out.println("probem in arts ");
                    }
                }
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                managerr_artOfartist_page_txtf.clear();
                
                String artsOfartist_page_result_str= new String();
                              artsOfartist_page_result_str=String.join("\n",output_artists_art);

        //employeeUnderM_show_str= String.join("\n",employees_under());
                managerr_artsOfartist_page_result_txt.setText(artsOfartist_page_result_str);

                
                
                //artsOfartist_page_reslut_txt.setText("result");
            }
        });
        
         Button manager_artOfartist_page_back_btn= new Button();
        manager_artOfartist_page_back_btn.setLayoutX(scene_width-950);
        manager_artOfartist_page_back_btn.setLayoutY(scene_height-800);
        manager_artOfartist_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        manager_artOfartist_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                managerr_artsOfartist_page_result_txt.setText("");
                                   myStage.setScene(manager_query_page_scene);

                
            }
        });
        
        
                
         Button manager_bill_from_date_page_ok_btn= new Button();
        manager_bill_from_date_page_ok_btn.setLayoutX(scene_width-250);
        manager_bill_from_date_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        manager_bill_from_date_page_ok_btn.setText("OK");
        manager_bill_from_date_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String []output_bill_from_date=new String[100];
                
                for(int i=0;i<100;i++){
                    output_bill_from_date[i]="";
                }
                int i=0;
                if(con!=null){
                    try{
                        String from_date=manager_bill_from_date_page_from_txtf.getText();
                        String to_date=manager_bill_from_date_page_to_txtf.getText();
                        
                        String sqlcommand="SELECT BILL_ID,CUSTOMER_ID,FETCH_CUSTOMER(CUSTOMER_ID),ART_ID,FETCH_ART(ART_ID),ARTIST_ID,FETCH_ARTIST(ARTIST_ID),BILL_DATE,BILL_AMOUNT FROM BILL WHERE BILL_DATE>? AND BILL_DATE<? ";
                          System.out.println(sqlcommand);                 
                                               
                                                
                        
                        PreparedStatement pst1=con.prepareStatement(sqlcommand);
                        pst1.setString(1, from_date);
                        pst1.setString(2,to_date);
                        System.out.println("sdff");
                        
                        ResultSet rs=pst1.executeQuery();
                        System.out.println("asda");
                        
                        while(rs.next()){
                            
                            output_bill_from_date[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9);
                            i++;
                        }
                        pst1.close();
                    }catch(SQLException e){
                        System.out.println("probem in arts ");
                    }
                }
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                manager_bill_from_date_page_from_txtf.clear();
                manager_bill_from_date_page_to_txtf.clear();
                
                String manager_bills_from_date_page_result_str= new String();
                              manager_bills_from_date_page_result_str=String.join("\n",output_bill_from_date);

        //employeeUnderM_show_str= String.join("\n",employees_under());
                manager_bill_from_date_result_txt.setText(manager_bills_from_date_page_result_str);

                
                
                //artsOfartist_page_reslut_txt.setText("result");
            }
        });
        
        
        Button manager_bills_from_date_page_back_btn= new Button();
        manager_bills_from_date_page_back_btn.setLayoutX(scene_width-950);
        manager_bills_from_date_page_back_btn.setLayoutY(scene_height-800);
        manager_bills_from_date_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        manager_bills_from_date_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                manager_bill_from_date_result_txt.setText("");
                manager_bill_from_date_page_from_txtf.clear();
                manager_bill_from_date_page_to_txtf.clear();
                                   myStage.setScene(manager_query_page_scene);

                
            }
        });
        
        
        
        
         Button manager_employeesUnderMe_page_back_btn= new Button();
        manager_employeesUnderMe_page_back_btn.setLayoutX(scene_width-950);
        manager_employeesUnderMe_page_back_btn.setLayoutY(scene_height-800);
        manager_employeesUnderMe_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        manager_employeesUnderMe_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                employeeUnderM_txt.setText("");
                                   myStage.setScene(manager_query_page_scene);

                
            }
        });
        
        
        
        
        
        
        
        
         Button employee_login_check_submit_btn = new Button();
        employee_login_check_submit_btn.setLayoutX(scene_width-650);
        employee_login_check_submit_btn.setLayoutY(scene_height-150);
        //manager_login_check_submit_btn.setGraphic(Submit_txt);
        employee_login_check_submit_btn.setText("SUBMIT");
        employee_login_check_submit_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                if(con!=null){
                        try{
                            System.out.println("asd");
                            String given_username=employeeLoginCheck_class.username_txtf.getText();
                            String given_password=employeeLoginCheck_class.password_txtf.getText();
                            
                            String sqlcommand= "SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE USER_NAME=? AND PASSWORD=? ";
                           PreparedStatement pst56=con.prepareStatement(sqlcommand);
                           
                            System.out.println(given_username);
                            System.out.println(given_password);
                           
                           pst56.setString(1,given_username);
                           pst56.setString(2,given_password);
                            System.out.println("asd");
                           
                           ResultSet rs=pst56.executeQuery();
                            System.out.println("asdasdfasd");
                           
                           while(rs.next()){
                               System.out.println("in while");
                               ID=rs.getString(1);
                               myStage.setScene(employee_homepage_scene);
                               
                           }
                            employee_loginCheck_page_error_show.setText("Invalid Username or Password");
                  
                          // myStage.setScene(manager_homepage_scene);
                            System.out.println(ID);
                           pst56.close();
                           
                           
                            
                        }catch(SQLException e){
                            System.out.println(e.toString());
                            System.out.println("pblm");
                        }
                  // myStage.setScene(employee_homepage_scene);
                }
                
                employeeLoginCheck_class.username_txtf.clear();
                employeeLoginCheck_class.password_txtf.clear();
            }
        });
        
        Button employee_login_check_back_btn= new Button();
        employee_login_check_back_btn.setLayoutX(scene_width-950);
        employee_login_check_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        employee_login_check_back_btn.setText("BACK");
        employee_login_check_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                employeeLoginCheck_class.username_txtf.clear();
                employeeLoginCheck_class.password_txtf.clear();
                
                employee_loginCheck_page_error_show.setText("");
                
                 myStage.setScene(login_page_scene);

                
            }
        });
        
        
         Button employee_homepage_insert_btn= new Button();
        employee_homepage_insert_btn.setLayoutX(scene_width-650);
        employee_homepage_insert_btn.setLayoutY(scene_height-700);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        employee_homepage_insert_btn.setText("NEW REGISTER");
        employee_homepage_insert_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(employee_insertTables_scene);
            }
        });
        
         Button employee_homepage_profile_btn= new Button();
        employee_homepage_profile_btn.setLayoutX(scene_width-650);
        employee_homepage_profile_btn.setLayoutY(scene_height-600);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        employee_homepage_profile_btn.setText("PROFILE");
        employee_homepage_profile_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                if(con!=null)
                {
                    try{
                        
                        String sqlcommand="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
                        PreparedStatement pst5=con.prepareStatement(sqlcommand);
                        
                        pst5.setString(1, ID);
                        
                        
                        ResultSet rs=pst5.executeQuery();
                        
                        while(rs.next()){
                            
                            employeeProfile_class.employee_ID_result_txt.setText(rs.getString(1));
                            employeeProfile_class.employee_name_result_txt.setText(rs.getString(2));
                            employeeProfile_class.username_result_txt.setText(rs.getString(3));
                            employeeProfile_class.password_result_txt.setText(rs.getString(4));
                            
                            employeeProfile_class.address_result_txt.setText(rs.getString(6));
                            employeeProfile_class.sex_result_txt.setText(rs.getString(7));
                            employeeProfile_class.phone_no_result_txt.setText(rs.getString(9));
                            employeeProfile_class.email_ID_result_txt.setText(rs.getString(10));
                           employeeProfile_class.salary_result_txt.setText(rs.getString(8));
                            employeeProfile_class.dateOf_birth_result_txt.setText(rs.getString(11));
                             employeeProfile_class.join_date_result_txt.setText(rs.getString(12));
                              employeeProfile_class.end_date_result_txt.setText(rs.getString(13));
                                
                    }
                        pst5.close();

                //myStage.setScene(artist_profile_scene);
            }catch(SQLException e){
                        System.out.println(e.toString());
            }
                
                }
                myStage.setScene(employee_profile_scene);
            }
        });
        
        
        Button employee_profile_page_edit_profile_btn= new Button();
        employee_profile_page_edit_profile_btn.setLayoutX(scene_width-650);
        employee_profile_page_edit_profile_btn.setLayoutY(scene_height-100);
        //manager_homepage_edit_profile_btn.setGraphic(edit_profile_txt);
        employee_profile_page_edit_profile_btn.setText("EDIT PROFILE");
        employee_profile_page_edit_profile_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                if(con!=null){
                    try{
                        
                        String sqlcommand="SELECT USER_NAME,ADDRESS,PASSWORD,EMAIL_ID,PHONE_NO FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
                        
                        PreparedStatement pst44=con.prepareStatement(sqlcommand);
                        
                        pst44.setString(1,ID);
                        ResultSet rs=pst44.executeQuery();
                        
                        while(rs.next()){
                            employeeEditProfile_class.new_username_txf.setText(rs.getString(1));
                            employeeEditProfile_class.new_address_txf.setText(rs.getString(2));
                            employeeEditProfile_class.new_password_txf.setText(rs.getString(3));
                            employeeEditProfile_class.new_email_id_txf.setText(rs.getString(4));
                            employeeEditProfile_class.new_phone_no_txf.setText(rs.getString(5));
                        }
                        
                        pst44.close();
                     
                        
                    }catch(SQLException e)
                    {
                        System.out.println(e.toString()); 
                             
                    }
                }

                myStage.setScene(employee_edit_profile_scene);
            }
        });
        
        Button employee_profile_page_logout_btn= new Button();
        employee_profile_page_logout_btn.setLayoutX(scene_width-150);
        employee_profile_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        employee_profile_page_logout_btn.setText("LOG OUT");
        employee_profile_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                           employee_loginCheck_page_error_show.setText("");
                myStage.setScene(login_page_scene);
            }
        });
        
         Button employee_profile_page_home_btn= new Button();
        employee_profile_page_home_btn.setLayoutX(scene_width-950);
        employee_profile_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_profile_page_home_btn.setText("HOME");
        employee_profile_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(employee_homepage_scene);
            }
        });
        
        
        Button employee_homepage_showTables_btn= new Button();
        employee_homepage_showTables_btn.setLayoutX(scene_width-650);
        employee_homepage_showTables_btn.setLayoutY(scene_height-500);
        //manager_homepage_showTables_btn.setGraphic(show_table_txt);
        employee_homepage_showTables_btn.setText("ALL ABOUT");
        employee_homepage_showTables_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_showTables_scene);
            }
        });
        
        Button employee_homepage_query_btn= new Button();
        employee_homepage_query_btn.setLayoutX(scene_width-650);
        employee_homepage_query_btn.setLayoutY(scene_height-500);
        //manager_homepage_query_btn.setGraphic(query_txt);
        employee_homepage_query_btn.setText("EXPLORE");
        employee_homepage_query_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(employee_query_page_scene);
            }
        });
        
        Button employee_homepage_logout_btn= new Button();
        employee_homepage_logout_btn.setLayoutX(scene_width-150);
        employee_homepage_logout_btn.setLayoutY(scene_height-820);
        //manager_homepage_logout_btn.setGraphic(logout_btn_img);
        employee_homepage_logout_btn.setText("LOG OUT");
        employee_homepage_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                           employee_loginCheck_page_error_show.setText("");
                myStage.setScene(login_page_scene);
            }
        });
       
        
          Button employee_insertTables_page_customer_btn= new Button();
        employee_insertTables_page_customer_btn.setLayoutX(scene_width-650);
        employee_insertTables_page_customer_btn.setLayoutY(scene_height-700);
        //manager_insertTables_page_customer_btn.setGraphic(customer_txt);
        employee_insertTables_page_customer_btn.setText("CUSTOMERS");
        employee_insertTables_page_customer_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(customer_table_insert_from_employee_scene);
            }
        });
        
        
         Button employee_insertTables_page_artist_btn= new Button();
        employee_insertTables_page_artist_btn.setLayoutX(scene_width-650);
        employee_insertTables_page_artist_btn.setLayoutY(scene_height-600);
        //manager_insertTables_page_artist_btn.setGraphic(artist_txt);
        employee_insertTables_page_artist_btn.setText("ARTISTS");
        employee_insertTables_page_artist_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( artist_table_insert_from_employee_scene);
            }
        });
        
         Button employee_insertTables_page_arts_btn= new Button();
        employee_insertTables_page_arts_btn.setLayoutX(scene_width-650);
        employee_insertTables_page_arts_btn.setLayoutY(scene_height-500);
        //manager_insertTables_page_arts_btn.setGraphic(arts_txt);
        employee_insertTables_page_arts_btn.setText("ARTS");
        employee_insertTables_page_arts_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene(art_table_insert_from_employee_scene);
            }
        });
       
   
       
         Button employee_insertTables_page_exhibition_btn= new Button();
        employee_insertTables_page_exhibition_btn.setLayoutX(scene_width-650);
        employee_insertTables_page_exhibition_btn.setLayoutY(scene_height-400);
        //manager_insertTables_page_exhibition_btn.setGraphic(exhibiton_txt);
        employee_insertTables_page_exhibition_btn.setText("EXHIBITIONS");
        employee_insertTables_page_exhibition_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene( exhibition_table_insert_from_employee_scene);
            }
        });
        
          Button employee_insertTables_page_bill_btn= new Button();
        employee_insertTables_page_bill_btn.setLayoutX(scene_width-650);
        employee_insertTables_page_bill_btn.setLayoutY(scene_height-300);
        //manager_insertTables_page_exhibition_btn.setGraphic(exhibiton_txt);
        employee_insertTables_page_bill_btn.setText("BILLS");
        employee_insertTables_page_bill_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               myStage.setScene(bill_table_insert_from_employee_scene);
            }
        });
        
        
          Button employee_insertTables_page_payslip_btn= new Button();
        employee_insertTables_page_payslip_btn.setLayoutX(scene_width-650);
        employee_insertTables_page_payslip_btn.setLayoutY(scene_height-200);
        //manager_insertTables_page_exhibition_btn.setGraphic(exhibiton_txt);
        employee_insertTables_page_payslip_btn.setText("PAYSLIPS");
        employee_insertTables_page_payslip_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               //myStage.setScene( customer_table_insert_scene);
            }
        });
        
         Button employee_insertTables_page_logout_btn= new Button();
        employee_insertTables_page_logout_btn.setLayoutX(scene_width-150);
        employee_insertTables_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        employee_insertTables_page_logout_btn.setText("LOG OUT");
        employee_insertTables_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                           employee_loginCheck_page_error_show.setText("");
                myStage.setScene(login_page_scene);
            }
        });
        
         Button employee_insertTables_page_home_btn= new Button();
        employee_insertTables_page_home_btn.setLayoutX(scene_width-950);
        employee_insertTables_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_insertTables_page_home_btn.setText("HOME");
        employee_insertTables_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(employee_homepage_scene);
            }
        });
        
        
         Button Customer_table_insert_from_employee_ok_btn = new Button();
        Customer_table_insert_from_employee_ok_btn.setLayoutX(scene_width-550);
        Customer_table_insert_from_employee_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        Customer_table_insert_from_employee_ok_btn.setText("OK");
        Customer_table_insert_from_employee_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               // System.out.println(customer_name_txtf.getText());
                if(con!=null){
                    
                    try {
                       // System.out.println("Connected  1");
                       // System.out.println("Cu");
                      //  System.out.println(customer_name_txtf.getText());
                        
                        Statement stmt=con.createStatement();
                        
                        System.out.println(CustomerTableInsertFromEmployee_class.customer_id_txtf.getLength()); 
                        String c_id=CustomerTableInsertFromEmployee_class.customer_id_txtf.getText();
                        String c_name=CustomerTableInsertFromEmployee_class.customer_name_txtf.getText();
                        String c_sex=CustomerTableInsertFromEmployee_class.toggle_grp_customer_sex.getSelectedToggle().getUserData().toString();
                        String c_adrs =CustomerTableInsertFromEmployee_class.customer_adrs_txtf.getText();
                        String c_phn= CustomerTableInsertFromEmployee_class.customer_phn_txtf.getText();
                        String c_email= CustomerTableInsertFromEmployee_class.customer_email_txtf.getText();
                        String c_favGen=CustomerTableInsertFromEmployee_class.toggle_grp_customer_fav_genre.getSelectedToggle().getUserData().toString();
                        String c_username = CustomerTableInsertFromEmployee_class.customer_username_txtf.getText();
                        String c_password = CustomerTableInsertFromEmployee_class.customer_password_txtf.getText();
                        String c_dateOfbirth = CustomerTableInsertFromEmployee_class.customer_dateOf_birth_txf.getText();
                        
                        
                        
                        String sqlCommand = "INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE,DATE_OF_BIRTH) VALUES('"+ c_id+ "','"+ c_name+ "',' "+c_username+ " ',' "+c_password+" ','" +c_sex+ "','" +c_adrs+ "','" +c_phn +"','" + c_email+"','"+c_favGen+"','"+c_dateOfbirth+"')";
                        // String sqlCommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE)"+
                             //    "VALUES('005','gh','af','gf',7,'Sb','oD')";
    
                        stmt.executeUpdate(sqlCommand);
                        //con.commit();
                        //System.out.println("Connect 2");
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
                
                CustomerTableInsertFromEmployee_class.customer_id_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_name_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_adrs_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_phn_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_email_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_favGen_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_username_txtf.setText("");        
                CustomerTableInsertFromEmployee_class.customer_password_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_dateOf_birth_txf.clear();
                
                CustomerTableInsertFromEmployee_class.toggle_grp_customer_sex.getToggles().removeAll(
                        CustomerTableInsertFromEmployee_class.customer_sex_rbtn_male,CustomerTableInsertFromEmployee_class.customer_sex_rbtn_female,
                        CustomerTableInsertFromEmployee_class.customer_sex_rbtn_other);
                CustomerTableInsertFromEmployee_class.toggle_grp_customer_fav_genre.getToggles().removeAll(
                        CustomerTableInsertFromEmployee_class.customer_fav_genre_fauvism_rbtn,CustomerTableInsertFromEmployee_class.customer_fav_genre_maritime_rbtn,
                        CustomerTableInsertFromEmployee_class.customer_fav_genre_postModern_rbtn,CustomerTableInsertFromEmployee_class.customer_fav_genre_renaissance_rbtn,
                        CustomerTableInsertFromEmployee_class.customer_fav_genre_symbolism_rbtn);
                
//                customer_sex_rbtn_male.setUserData("");
//                customer_sex_rbtn_female.setUserData("");
//                customer_sex_rbtn_other.setUserData("");
                
                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        Button customer_table_insert_page_from_employee_back_btn= new Button();
        customer_table_insert_page_from_employee_back_btn.setLayoutX(scene_width-950);
        customer_table_insert_page_from_employee_back_btn.setLayoutY(scene_height-800);
        customer_table_insert_page_from_employee_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        customer_table_insert_page_from_employee_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                
                CustomerTableInsertFromEmployee_class.customer_id_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_name_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_adrs_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_phn_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_email_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_favGen_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_username_txtf.setText("");        
                CustomerTableInsertFromEmployee_class.customer_password_txtf.setText("");
                CustomerTableInsertFromEmployee_class.customer_dateOf_birth_txf.clear();
                
                CustomerTableInsertFromEmployee_class.toggle_grp_customer_sex.getToggles().removeAll(
                        CustomerTableInsertFromEmployee_class.customer_sex_rbtn_male,CustomerTableInsertFromEmployee_class.customer_sex_rbtn_female,
                        CustomerTableInsertFromEmployee_class.customer_sex_rbtn_other);
                CustomerTableInsertFromEmployee_class.toggle_grp_customer_fav_genre.getToggles().removeAll(
                        CustomerTableInsertFromEmployee_class.customer_fav_genre_fauvism_rbtn,CustomerTableInsertFromEmployee_class.customer_fav_genre_maritime_rbtn,
                        CustomerTableInsertFromEmployee_class.customer_fav_genre_postModern_rbtn,CustomerTableInsertFromEmployee_class.customer_fav_genre_renaissance_rbtn,
                        CustomerTableInsertFromEmployee_class.customer_fav_genre_symbolism_rbtn);
                
                                   myStage.setScene(employee_insertTables_scene);

                
            }
        });
        
        Button artist_table_insert_from_employee_ok_btn = new Button();
        artist_table_insert_from_employee_ok_btn.setLayoutX(scene_width-550);
        artist_table_insert_from_employee_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        artist_table_insert_from_employee_ok_btn.setText("OK");
        artist_table_insert_from_employee_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                        
                        System.out.println(ArtistTableInsertFromEmployee_class.artist_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                        String c_name=ArtistTableInsertFromEmployee_class.artist_name_txtf.getText();
                        String c_sex=ArtistTableInsertFromEmployee_class.toggle_grp_artist_sex.getSelectedToggle().getUserData().toString();
                        String c_adrs =ArtistTableInsertFromEmployee_class.artist_adrs_txtf.getText();
                        String c_phn= ArtistTableInsertFromEmployee_class.artist_phn_txtf.getText();
                        String c_email= ArtistTableInsertFromEmployee_class.artist_email_txtf.getText();
                        String c_favGen=ArtistTableInsertFromEmployee_class.toggle_grp_artist_fav_genre.getSelectedToggle().getUserData().toString();
                        String c_username = ArtistTableInsertFromEmployee_class.artist_username_txtf.getText();
                        String c_password = ArtistTableInsertFromEmployee_class.artist_password_txtf.getText();
                        String c_dateOfbirth= ArtistTableInsertFromEmployee_class.artist_dateOf_birth_txf.getText();
                        
                        
                        
//                        String sqlCommand = "INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE,DATE_OF_BIRTH) VALUES('"+ c_id+ "','"+ c_name+ "',' "+c_username+ " ',' "+c_password+" ','" +c_sex+ "','" +c_adrs+ "','" +c_phn +"','" + c_email+"','"+c_favGen+"','"+c_dateOfbirth+"')";
//                        // String sqlCommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE)"+
//                             //    "VALUES('005','gh','af','gf',7,'Sb','oD')";
//    
//                        stmt.executeUpdate(sqlCommand);

                            String sqlcommand="INSERT INTO ARTISTS(ARTIST_ID,ARTIST_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,MAIN_GENRE,DATE_OF_BIRTH) VALUES(SET_ARTISTID,?,?,?,?,?,?,?,?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_username);
                            pst110.setString(3,c_password);
                            pst110.setString(4,c_sex);
                            pst110.setString(5,c_adrs);
                            pst110.setString(6,c_phn);
                            pst110.setString(7,c_email);
                            pst110.setString(8,c_favGen);
                            pst110.setString(9,c_dateOfbirth);
                            
                            pst110.executeQuery();
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                ArtistTableInsertFromEmployee_class.artist_id_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_name_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_adrs_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_phn_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_email_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_favGen_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_username_txtf.setText("");        
                ArtistTableInsertFromEmployee_class.artist_password_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_dateOf_birth_txf.clear();
                
                ArtistTableInsertFromEmployee_class.toggle_grp_artist_sex.getToggles().removeAll(
                        ArtistTableInsertFromEmployee_class.artist_sex_rbtn_male,ArtistTableInsertFromEmployee_class.artist_sex_rbtn_female,
                        ArtistTableInsertFromEmployee_class.artist_sex_rbtn_other);
                ArtistTableInsertFromEmployee_class.toggle_grp_artist_fav_genre.getToggles().removeAll(
                    ArtistTableInsertFromEmployee_class.artist_fav_genre_fauvism_rbtn,ArtistTableInsertFromEmployee_class.artist_fav_genre_maritime_rbtn,
                        ArtistTableInsertFromEmployee_class.artist_fav_genre_postModern_rbtn,ArtistTableInsertFromEmployee_class.artist_fav_genre_renaissance_rbtn,
                        ArtistTableInsertFromEmployee_class.artist_fav_genre_symbolism_rbtn);

                
//                customer_sex_rbtn_male.setUserData("");
//                customer_sex_rbtn_female.setUserData("");
//                customer_sex_rbtn_other.setUserData("");
                
                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        

        
        Button artist_table_insert_page_from_employee_back_btn= new Button();
        artist_table_insert_page_from_employee_back_btn.setLayoutX(scene_width-950);
        artist_table_insert_page_from_employee_back_btn.setLayoutY(scene_height-800);
        artist_table_insert_page_from_employee_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        artist_table_insert_page_from_employee_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                
                ArtistTableInsertFromEmployee_class.artist_id_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_name_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_adrs_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_phn_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_email_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_favGen_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_username_txtf.setText("");        
                ArtistTableInsertFromEmployee_class.artist_password_txtf.setText("");
                ArtistTableInsertFromEmployee_class.artist_dateOf_birth_txf.clear();
                
                ArtistTableInsertFromEmployee_class.toggle_grp_artist_sex.getToggles().removeAll(
                        ArtistTableInsertFromEmployee_class.artist_sex_rbtn_male,ArtistTableInsertFromEmployee_class.artist_sex_rbtn_female,
                        ArtistTableInsertFromEmployee_class.artist_sex_rbtn_other);
                ArtistTableInsertFromEmployee_class.toggle_grp_artist_fav_genre.getToggles().removeAll(
                    ArtistTableInsertFromEmployee_class.artist_fav_genre_fauvism_rbtn,ArtistTableInsertFromEmployee_class.artist_fav_genre_maritime_rbtn,
                        ArtistTableInsertFromEmployee_class.artist_fav_genre_postModern_rbtn,ArtistTableInsertFromEmployee_class.artist_fav_genre_renaissance_rbtn,
                        ArtistTableInsertFromEmployee_class.artist_fav_genre_symbolism_rbtn);
                                   myStage.setScene(employee_insertTables_scene);

                
            }
        });
        
        
        Button art_table_insert_from_employee_ok_btn = new Button();
        art_table_insert_from_employee_ok_btn.setLayoutX(scene_width-550);
        art_table_insert_from_employee_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        art_table_insert_from_employee_ok_btn.setText("OK");
        art_table_insert_from_employee_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                        
                       // System.out.println(ArtTableInsertFromManager_class.art_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                       String c_name=ArtTableInsertFromEmployee_class.art_title_txtf.getText();
                        String c_aname=ArtTableInsertFromEmployee_class.artist_name_txtf.getText();
                       String c_favGen=ArtTableInsertFromEmployee_class.toggle_grp_art_genre.getSelectedToggle().getUserData().toString();
                       String c_date=ArtTableInsertFromEmployee_class.art_date_txtf.getText();
                       String c_price=ArtTableInsertFromEmployee_class.art_price_txtf.getText();
                        String c_status=ArtTableInsertFromEmployee_class.toggle_grp_art_status.getSelectedToggle().getUserData().toString();
                        
                        
//                        String sqlCommand = "INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,USER_NAME,PASSWORD,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE,DATE_OF_BIRTH) VALUES('"+ c_id+ "','"+ c_name+ "',' "+c_username+ " ',' "+c_password+" ','" +c_sex+ "','" +c_adrs+ "','" +c_phn +"','" + c_email+"','"+c_favGen+"','"+c_dateOfbirth+"')";
//                        // String sqlCommand="INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,SEX,ADDRESS,PHONE_NO,EMAIL_ID,FAVORITE_GENRE)"+
//                             //    "VALUES('005','gh','af','gf',7,'Sb','oD')";
//    
//                        stmt.executeUpdate(sqlCommand);

                            String sqlcommand="INSERT INTO ARTS(ART_ID,ART_TITLE,ARTIST_ID,ART_GENRE,DATE_OF_CREATION,PRICE,STATUS) VALUES(SET_ARTID,?,FETCH_ARTISTID(?),?,?,?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside art");
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_aname);
                            pst110.setString(3,c_favGen);
                            pst110.setString(4,c_date);
                            pst110.setString(5,c_price);
                            pst110.setString(6,c_status);
           
                            
                            pst110.executeQuery();
                            
                            System.out.println("inside art 2");
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                ArtTableInsertFromEmployee_class.art_title_txtf.setText("");
                ArtTableInsertFromEmployee_class.artist_name_txtf.setText("");
               // ArtTableInsertFromManager_class.artist_name_txtf.setText("");
                ArtTableInsertFromEmployee_class.art_date_txtf.setText("");
                ArtTableInsertFromEmployee_class.art_price_txtf.setText("");
      
                
               
                ArtTableInsertFromEmployee_class.toggle_grp_art_genre.getToggles().removeAll(
                    ArtTableInsertFromEmployee_class.art_genre_fauvism_rbtn,ArtTableInsertFromEmployee_class.art_genre_maritime_rbtn,
                        ArtTableInsertFromEmployee_class.art_genre_postModern_rbtn,ArtTableInsertFromEmployee_class.art_genre_renaissance_rbtn,
                        ArtTableInsertFromEmployee_class.art_genre_symbolism_rbtn);
                
                ArtTableInsertFromEmployee_class.toggle_grp_art_status.getToggles().removeAll(
                      ArtTableInsertFromEmployee_class.art_status_rbtn_available,ArtTableInsertFromEmployee_class.art_status_rbtn_sold  
                );

                
//                customer_sex_rbtn_male.setUserData("");
//                customer_sex_rbtn_female.setUserData("");
//                customer_sex_rbtn_other.setUserData("");
                
                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        

        
        Button art_table_insert_page_from_employee_back_btn= new Button();
        art_table_insert_page_from_employee_back_btn.setLayoutX(scene_width-950);
        art_table_insert_page_from_employee_back_btn.setLayoutY(scene_height-800);
        art_table_insert_page_from_employee_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        art_table_insert_page_from_employee_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                
                ArtTableInsertFromEmployee_class.art_title_txtf.setText("");
                ArtTableInsertFromEmployee_class.artist_name_txtf.setText("");
               // ArtTableInsertFromManager_class.artist_name_txtf.setText("");
                ArtTableInsertFromEmployee_class.art_date_txtf.setText("");
                ArtTableInsertFromEmployee_class.art_price_txtf.setText("");
      
                
               
                ArtTableInsertFromEmployee_class.toggle_grp_art_genre.getToggles().removeAll(
                    ArtTableInsertFromEmployee_class.art_genre_fauvism_rbtn,ArtTableInsertFromEmployee_class.art_genre_maritime_rbtn,
                        ArtTableInsertFromEmployee_class.art_genre_postModern_rbtn,ArtTableInsertFromEmployee_class.art_genre_renaissance_rbtn,
                        ArtTableInsertFromEmployee_class.art_genre_symbolism_rbtn);
                
                ArtTableInsertFromEmployee_class.toggle_grp_art_status.getToggles().removeAll(
                      ArtTableInsertFromEmployee_class.art_status_rbtn_available,ArtTableInsertFromEmployee_class.art_status_rbtn_sold  
                );

                                   myStage.setScene(employee_insertTables_scene);

                
            }
        });
        
        
        
        Button exhibition_table_insert_from_employee_ok_btn = new Button();
        exhibition_table_insert_from_employee_ok_btn.setLayoutX(scene_width-550);
        exhibition_table_insert_from_employee_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_employee_ok_btn.setText("OK");
        exhibition_table_insert_from_employee_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                       String c_name=ExhibitionTableInsertFromEmployee_class.exhibition_name_txtf.getText();
                       String c_hname=ExhibitionTableInsertFromEmployee_class.exhibition_hall_name_txtf.getText();
                       String c_aname=ExhibitionTableInsertFromEmployee_class.exhibition_art_name_txtf.getText();
                       String c_start_date=ExhibitionTableInsertFromEmployee_class.exhibition_start_date_txtf.getText();
                       String c_end_date=ExhibitionTableInsertFromEmployee_class.exhibition_end_date_txtf.getText();
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_hname);
                            pst110.setString(3,c_aname);
                            pst110.setString(4,c_start_date);
                            pst110.setString(5,c_end_date);

           
                            
                            pst110.executeQuery();
                            
                            System.out.println("inside art 2");
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromEmployee_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromEmployee_class.exhibition_hall_name_txtf.setText("");
//                    ExhibitionTableInsertFromEmployee_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromEmployee_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromEmployee_class.exhibition_end_date_txtf.setText("");
//      
                        
      
                
               
       
                
              
              

                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        Button exhibition_table_insert_from_employee_more_art_btn = new Button();
        exhibition_table_insert_from_employee_more_art_btn.setLayoutX(scene_width-500);
        exhibition_table_insert_from_employee_more_art_btn.setLayoutY(scene_height-650);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_employee_more_art_btn.setText("Add Arts");
        exhibition_table_insert_from_employee_more_art_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
//                       String c_name=ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText();
//                       String c_hname=ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText();
//                       String c_aname=ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText();
//                       String c_start_date=ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText();
//                       String c_end_date=ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText();
                       
                       
                       ExhibitionTableInsertFromEmployee_addartclass.exhibition_name_txtf.setText(ExhibitionTableInsertFromEmployee_class.exhibition_name_txtf.getText());
                       ExhibitionTableInsertFromEmployee_addartclass.exhibition_hall_name_txtf.setText(ExhibitionTableInsertFromEmployee_class.exhibition_hall_name_txtf.getText());
                      // ExhibitionTableInsertFromManager_addartclass.exhibition_art_name_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText());
                       ExhibitionTableInsertFromEmployee_addartclass.exhibition_start_date_txtf.setText(ExhibitionTableInsertFromEmployee_class.exhibition_start_date_txtf.getText());
                      ExhibitionTableInsertFromEmployee_addartclass.exhibition_end_date_txtf.setText(ExhibitionTableInsertFromEmployee_class.exhibition_end_date_txtf.getText());
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
//                            pst110.setString(1,c_name);
//                            pst110.setString(2,c_hname);
//                            pst110.setString(3,c_aname);
//                            pst110.setString(4,c_start_date);
//                            pst110.setString(5,c_end_date);
//
//           
//                            
//                            pst110.executeQuery();
//                            
//                            System.out.println("inside art 2");
//                            
//                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                        //error_show.setText("ERROR");
//                        //customer_grp_insrt.getChildren().add(error_show);
//                       // System.out.println("pblm at OK ");
//                       //ex.printStackTrace();
//                      
//                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
               myStage.setScene(exhibition_table_insert_from_employee_addartscne);
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        Button exhibition_table_insert_from_employee_more_exhibition_btn = new Button();
        exhibition_table_insert_from_employee_more_exhibition_btn.setLayoutX(scene_width-500);
        exhibition_table_insert_from_employee_more_exhibition_btn.setLayoutY(scene_height-600);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_employee_more_exhibition_btn.setText("Add Exhibitions");
        exhibition_table_insert_from_employee_more_exhibition_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
//                       String c_name=ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText();
//                       String c_hname=ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText();
//                       String c_aname=ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText();
//                       String c_start_date=ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText();
//                       String c_end_date=ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText();
                       
                       
                       ExhibitionTableInsertFromEmployee_class.exhibition_name_txtf.setText("");
                       ExhibitionTableInsertFromEmployee_class.exhibition_hall_name_txtf.setText("");
                       ExhibitionTableInsertFromEmployee_class.exhibition_art_name_txtf.setText("");
                       ExhibitionTableInsertFromEmployee_class.exhibition_start_date_txtf.setText("");
                      ExhibitionTableInsertFromEmployee_class.exhibition_end_date_txtf.setText("");
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
//                            pst110.setString(1,c_name);
//                            pst110.setString(2,c_hname);
//                            pst110.setString(3,c_aname);
//                            pst110.setString(4,c_start_date);
//                            pst110.setString(5,c_end_date);
//
//           
//                            
//                            pst110.executeQuery();
//                            
//                            System.out.println("inside art 2");
//                            
//                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                        //error_show.setText("ERROR");
//                        //customer_grp_insrt.getChildren().add(error_show);
//                       // System.out.println("pblm at OK ");
//                       //ex.printStackTrace();
//                      
//                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
              // myStage.setScene(exhibition_table_insert_from_manager_addartscne);
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        

        
        Button exhibition_table_insert_page_from_employee_back_btn= new Button();
        exhibition_table_insert_page_from_employee_back_btn.setLayoutX(scene_width-950);
        exhibition_table_insert_page_from_employee_back_btn.setLayoutY(scene_height-800);
        exhibition_table_insert_page_from_employee_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        exhibition_table_insert_page_from_employee_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                                  ExhibitionTableInsertFromEmployee_class.exhibition_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_art_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_start_date_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_end_date_txtf.setText("");
                                   myStage.setScene(manager_insertTables_scene);

                
            }
        });
        
        
        Button exhibition_table_insert_from_employee_moreart_ok_btn = new Button();
        exhibition_table_insert_from_employee_moreart_ok_btn.setLayoutX(scene_width-550);
        exhibition_table_insert_from_employee_moreart_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_employee_moreart_ok_btn.setText("OK");
        exhibition_table_insert_from_employee_moreart_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
                       String c_name=ExhibitionTableInsertFromEmployee_addartclass.exhibition_name_txtf.getText();
                       String c_hname=ExhibitionTableInsertFromEmployee_addartclass.exhibition_hall_name_txtf.getText();
                       String c_aname=ExhibitionTableInsertFromEmployee_addartclass.exhibition_art_name_txtf.getText();
                       String c_start_date=ExhibitionTableInsertFromEmployee_addartclass.exhibition_start_date_txtf.getText();
                       String c_end_date=ExhibitionTableInsertFromEmployee_addartclass.exhibition_end_date_txtf.getText();
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_SAME_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
                            pst110.setString(1,c_name);
                            pst110.setString(2,c_hname);
                            pst110.setString(3,c_aname);
                            pst110.setString(4,c_start_date);
                            pst110.setString(5,c_end_date);

           
                            
                            pst110.executeQuery();
                            
                            System.out.println("inside art 2");
                            
                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
 //                   ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
               //myStage.setScene();
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
        
        
        Button exhibition_table_insert_page_from_employee_addart_back_btn= new Button();
        exhibition_table_insert_page_from_employee_addart_back_btn.setLayoutX(scene_width-950);
        exhibition_table_insert_page_from_employee_addart_back_btn.setLayoutY(scene_height-800);
        exhibition_table_insert_page_from_employee_addart_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        exhibition_table_insert_page_from_employee_addart_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                   ExhibitionTableInsertFromEmployee_class.exhibition_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_art_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_start_date_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_end_date_txtf.setText("");
                                   myStage.setScene(exhibition_table_insert_from_employee_scene);

                
            }
        });
        
        Button exhibition_table_insert_from_employee_more_page_more_art_btn = new Button();
        exhibition_table_insert_from_employee_more_page_more_art_btn.setLayoutX(scene_width-500);
        exhibition_table_insert_from_employee_more_page_more_art_btn.setLayoutY(scene_height-650);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        exhibition_table_insert_from_employee_more_page_more_art_btn.setText("Add Arts");
        exhibition_table_insert_from_employee_more_page_more_art_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

               
               
                if(con!=null){
                    
                    try {

                        
                       // Statement stmt=con.createStatement();
                       
                      // System.out.println(HallRoomTableInsertFromManager_class.hall_id_txtf.getLength()); 
                       // String c_id=CustomerTableInsertFromManager_class.customer_id_txtf.getText();
//                       String c_name=ExhibitionTableInsertFromManager_class.exhibition_name_txtf.getText();
//                       String c_hname=ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.getText();
//                       String c_aname=ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText();
//                       String c_start_date=ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.getText();
//                       String c_end_date=ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.getText();
                       
                       
                       ExhibitionTableInsertFromEmployee_addartclass.exhibition_name_txtf.setText(ExhibitionTableInsertFromEmployee_class.exhibition_name_txtf.getText());
                       ExhibitionTableInsertFromEmployee_addartclass.exhibition_hall_name_txtf.setText(ExhibitionTableInsertFromEmployee_class.exhibition_hall_name_txtf.getText());
                      // ExhibitionTableInsertFromManager_addartclass.exhibition_art_name_txtf.setText(ExhibitionTableInsertFromManager_class.exhibition_art_name_txtf.getText());
                       ExhibitionTableInsertFromEmployee_addartclass.exhibition_start_date_txtf.setText(ExhibitionTableInsertFromEmployee_class.exhibition_start_date_txtf.getText());
                      ExhibitionTableInsertFromEmployee_addartclass.exhibition_end_date_txtf.setText(ExhibitionTableInsertFromEmployee_class.exhibition_end_date_txtf.getText());
                       
                            String sqlcommand="INSERT INTO EXHIBITIONS(EXHIBITION_ID,EXHIBITION_NAME,HALL_ID,ART_ID,START_DATE,END_DATE) VALUES(SET_EXHIBITIONID,?,FETCH_HALLID(?),FETCH_ARTID(?),?,?)";
                            PreparedStatement pst110=con.prepareStatement(sqlcommand);
                            
                            System.out.println("after sqlcommand");
                            
                            System.out.println("inside employee");
                            
//                            pst110.setString(1,c_name);
//                            pst110.setString(2,c_hname);
//                            pst110.setString(3,c_aname);
//                            pst110.setString(4,c_start_date);
//                            pst110.setString(5,c_end_date);
//
//           
//                            
//                            pst110.executeQuery();
//                            
//                            System.out.println("inside art 2");
//                            
//                            pst110.close();
                                   
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                        //error_show.setText("ERROR");
//                        //customer_grp_insrt.getChildren().add(error_show);
//                       // System.out.println("pblm at OK ");
//                       //ex.printStackTrace();
//                      
//                      
                    }
                   
                     
                    
                }
//                try {
//                    Insertion_ID_Set_class=new Insertion_ID_Set();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                    ExhibitionTableInsertFromManager_class.exhibition_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_hall_name_txtf.setText("");
                    ExhibitionTableInsertFromEmployee_class.exhibition_art_name_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_start_date_txtf.setText("");
//                    ExhibitionTableInsertFromManager_class.exhibition_end_date_txtf.setText("");
      
                        
      
                
               
       
                
              
              

                


                
               myStage.setScene(exhibition_table_insert_from_employee_addartscne);
                      //customer_name_txt.setFill(Color.RED);

            }
                    
        });
 
        
 
 
        
        
        
         Button bill_table_insert_from_employee_ok_btn = new Button();
        bill_table_insert_from_employee_ok_btn.setLayoutX(scene_width-550);
        bill_table_insert_from_employee_ok_btn.setLayoutY(scene_height-150);
        //Customer_table_insert_ok_btn.setGraphic(OK_txt);
        bill_table_insert_from_employee_ok_btn.setText("OK");
        bill_table_insert_from_employee_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
               // System.out.println(customer_name_txtf.getText());
                if(con!=null){
                    
                    try {
                       // System.out.println("Connected  1");
                       // System.out.println("Cu");
                      //  System.out.println(customer_name_txtf.getText());
                        
                                        

                        String b_id=billTableInsertFromEmployee_class.bill_id_txf.getText();
                        String c_id=billTableInsertFromEmployee_class.customer_id_txf.getText();
                        String art_id=billTableInsertFromEmployee_class.art_id_txf.getText();
                        System.out.println(art_id);
                        String artist_id=billTableInsertFromEmployee_class.artist_id_txf.getText();
                        String employee_id=billTableInsertFromEmployee_class.employee_id_txf.getText();
                        String b_date=billTableInsertFromEmployee_class.bill_date_txf.getText();
                        String b_amount=billTableInsertFromEmployee_class.bill_amount_txf.getText();
                        
                        System.out.println(c_id);

                       
                        String sqlCommand = "INSERT INTO BILL(BILL_ID,CUSTOMER_ID,ART_ID,ARTIST_ID,EMPLOYEE_ID,BILL_DATE,BILL_AMOUNT) VALUES(SET_BILLID,FETCH_CUSTOMERID(?),?,FETCH_ARTISTID_FROM_ARTID(?),?,?,?)" ;

                         PreparedStatement pst120= con.prepareStatement(sqlCommand);
                         
                         pst120.setString(1, c_id);
                         pst120.setString(2, art_id);
                         pst120.setString(3, art_id);
                         pst120.setString(4, ID);
                         pst120.setString(5, b_date);
                         pst120.setString(6, b_amount);
                         
                         pst120.executeQuery();
                         pst120.close();
                        
                        //stmt.executeUpdate(sqlCommand);
                                  
                    } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                        //error_show.setText("ERROR");
                        //customer_grp_insrt.getChildren().add(error_show);
                       // System.out.println("pblm at OK ");
                       //ex.printStackTrace();
                      
                      
                    }
                   
                     
                    
                }
                    
                  billTableInsertFromEmployee_class.art_id_txf.setText("");
                  billTableInsertFromEmployee_class.artist_id_txf.setText("");
                  billTableInsertFromEmployee_class.bill_amount_txf.setText("");
                  billTableInsertFromEmployee_class.bill_date_txf.setText("");
                  billTableInsertFromEmployee_class.bill_id_txf.setText("");
                  billTableInsertFromEmployee_class.customer_id_txf.setText("");
                  billTableInsertFromEmployee_class.employee_id_txf.setText("");

            }
                    
        });
        
        
        
        
        
        
        Button bill_table_insert_page_from_employee_back_btn= new Button();
        bill_table_insert_page_from_employee_back_btn.setLayoutX(scene_width-950);
        bill_table_insert_page_from_employee_back_btn.setLayoutY(scene_height-800);
        bill_table_insert_page_from_employee_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        bill_table_insert_page_from_employee_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                             billTableInsertFromEmployee_class.art_id_txf.setText("");
                  billTableInsertFromEmployee_class.artist_id_txf.setText("");
                  billTableInsertFromEmployee_class.bill_amount_txf.setText("");
                  billTableInsertFromEmployee_class.bill_date_txf.setText("");
                  billTableInsertFromEmployee_class.bill_id_txf.setText("");
                  billTableInsertFromEmployee_class.customer_id_txf.setText("");
                  billTableInsertFromEmployee_class.employee_id_txf.setText("");
                                   myStage.setScene(employee_insertTables_scene);

                
            }
        });
        
        
        
        
         Button employee_edit_profile_page_logout_btn= new Button();
        employee_edit_profile_page_logout_btn.setLayoutX(scene_width-150);
        employee_edit_profile_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        employee_edit_profile_page_logout_btn.setText("LOG OUT");
        employee_edit_profile_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                           employee_loginCheck_page_error_show.setText("");
                myStage.setScene(login_page_scene);
            }
        });
        
         Button employee_edit_profile_page_home_btn= new Button();
        employee_edit_profile_page_home_btn.setLayoutX(scene_width-950);
        employee_edit_profile_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_edit_profile_page_home_btn.setText("HOME");
        employee_edit_profile_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(employee_homepage_scene);
            }
        });
        
         Button employee_edit_profile_page_ok_btn= new Button();
        employee_edit_profile_page_ok_btn.setLayoutX(scene_width-700);
        employee_edit_profile_page_ok_btn.setLayoutY(scene_height-450);
        //manager_edit_profile_page_ok_btn.setGraphic(OK_txt);
        employee_edit_profile_page_ok_btn.setText("OK");
        employee_edit_profile_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                                   if(con!=null){
                    
                    try{
                       // Statement stmt4=con.createStatement();
                       
                       
                        
                        String u_username =employeeEditProfile_class.new_username_txf.getText();
                        String u_address = employeeEditProfile_class.new_address_txf.getText();
                        String u_phone= employeeEditProfile_class.new_phone_no_txf.getText();
                        String u_email= employeeEditProfile_class.new_email_id_txf.getText();
                        String u_password=employeeEditProfile_class.new_password_txf.getText();
                        
                        String sqlcommand= "UPDATE EMPLOYEES SET USER_NAME=? ,ADDRESS=?, PHONE_NO=?,EMAIL_ID=?,PASSWORD=? WHERE EMPLOYEE_ID=? ";
                        PreparedStatement pst34 =con.prepareStatement(sqlcommand);
                        
                        
                        pst34.setString(1,u_username);
                        pst34.setString(2,u_address);
                        pst34.setString(3,u_phone);
                        pst34.setString(4,u_email);
                        pst34.setString(5,u_password);
                        pst34.setString(6, ID);
                        
                        pst34.executeUpdate();
                        pst34.close();
                        
                        //String sqlcommand="UPDATE MANAGERS SET USER_NAME ''='"+u_username+"','ADDRESS'='"+u_address+"','PHONE_NUMBER'='"+u_phone+"','EMAIL_ID'='"+u_email+"','PASSWORD'='"+u_password"'"
          
                        
                        //stmt4.executeQuery(sqlcommand);
                        
                   } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                

            }
        });
        
        
        
         MenuButton employee_query_page_informationOf_mbtn= new MenuButton();
        employee_query_page_informationOf_mbtn.setText("Information of a/an...");
        employee_query_page_informationOf_mbtn.setLayoutX(scene_width-650);
        employee_query_page_informationOf_mbtn.setLayoutY(scene_height-600);
        
        //MenuItem manager_query_page_employeeInfo_mitem = new MenuItem("Employee");
        MenuItem employee_query_page_customerInfo_mitem = new MenuItem("Customer");
        MenuItem employee_query_page_artistInfo_mitem = new MenuItem("Artist");
        MenuItem employee_query_page_artInfo_mitem = new MenuItem("Art");
        
        employee_query_page_informationOf_mbtn.getItems().addAll(employee_query_page_artInfo_mitem,employee_query_page_artistInfo_mitem,
                employee_query_page_customerInfo_mitem);
        

        employee_query_page_customerInfo_mitem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_insertTables_scene);
                myStage.setScene(employee_customerInfo_scene);
            }
        });
        

        employee_query_page_artistInfo_mitem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_insertTables_scene);
                myStage.setScene(employee_artistInfo_scene);
            }
        });
        
//         Button manager_query_page_artInfo_btn = new Button();
//        manager_query_page_artInfo_btn.setLayoutX(scene_width-650);
//        manager_query_page_artInfo_btn.setLayoutY(scene_height-300);
//        //manager_homepage_insert_btn.setGraphic(insert_txt);
//        manager_query_page_artInfo_btn.setText("ONE ART'S INFORMATION");
        employee_query_page_artInfo_mitem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_insertTables_scene);
                myStage.setScene(employee_artInfo_scene);
            }
        });
        
        
        Button employee_query_page_artsOfartist_btn = new Button();
        employee_query_page_artsOfartist_btn.setLayoutX(scene_width-650);
        employee_query_page_artsOfartist_btn.setLayoutY(scene_height-500);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        employee_query_page_artsOfartist_btn.setText("ARTS OF AN ARTIST");
        employee_query_page_artsOfartist_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                //System.out.println("Hello World!");
                myStage.setScene(employee_artsOfartist_scene);
            }
        });
        
        Button employee_query_page_artStatus_btn = new Button();
        employee_query_page_artStatus_btn.setLayoutX(scene_width-650);
        employee_query_page_artStatus_btn.setLayoutY(scene_height-400);
        //manager_homepage_insert_btn.setGraphic(insert_txt);
        employee_query_page_artStatus_btn.setText("STATUS OF AN ART");
        employee_query_page_artStatus_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                
                //System.out.println("Hello World!");
                myStage.setScene(employee_artStatus_scene);
            }
        });
        
        
          Button employee_query_page_logout_btn= new Button();
        employee_query_page_logout_btn.setLayoutX(scene_width-150);
        employee_query_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        employee_query_page_logout_btn.setText("LOG OUT");
        employee_query_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                 employee_loginCheck_page_error_show.setText("");
                myStage.setScene(login_page_scene);
            }
        });
        
         Button employee_query_page_home_btn= new Button();
        employee_query_page_home_btn.setLayoutX(scene_width-950);
        employee_query_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_query_page_home_btn.setText("HOME");
        employee_query_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(employee_homepage_scene);
            }
        });
        
         Button employee_art_status_page_ok_btn= new Button();
        employee_art_status_page_ok_btn.setLayoutX(scene_width-750);
        employee_art_status_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_art_status_page_ok_btn.setText("OK");
        employee_art_status_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                
                    if(con!=null){
                    try{
                        //Statement stmt2=con.createStatement();
                        
                        
                        System.out.println("inside catch");
                        String a_status=employee_art_status_page_art_id_txf.getText();
                        
                        String sqlcommand="SELECT SEARCH_ART_STATUS(ART_ID) FROM ARTS WHERE ART_ID=? ";
                        PreparedStatement pst= con.prepareStatement(sqlcommand);
                        System.out.println("pst inside");
                        pst.setString(1, a_status);
                        System.out.println("after set string");
                        ResultSet rs=pst.executeQuery();
                        System.out.println("execute");
                        
                        while(rs.next()){
                            
                            employee_art_status_page_status_txt.setText(rs.getString(1).toString());
                        }
                        pst.close();
                        
                    } catch(SQLException e){
                        System.out.println(e.toString());
                        System.out.println("pbl");
                    }
                }
                employee_art_status_page_art_id_txf.clear();
                
            }
        });
        
         Button employee_art_status_page_back_btn= new Button();
        employee_art_status_page_back_btn.setLayoutX(scene_width-950);
        employee_art_status_page_back_btn.setLayoutY(scene_height-800);
        employee_art_status_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        employee_art_status_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                employee_art_status_page_status_txt.setText("");
                                   myStage.setScene(employee_query_page_scene);

                
            }
        });
        
        
//        Button manager_employeeInfo_page_ok_btn= new Button();
//        manager_employeeInfo_page_ok_btn.setLayoutX(scene_width-750);
//        manager_employeeInfo_page_ok_btn.setLayoutY(scene_height-600);
//        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
//        manager_employeeInfo_page_ok_btn.setText("OK");
//        manager_employeeInfo_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                //System.out.println("Hello World!");
//                //myStage.setScene(manager_homepage_scene);
//                
//                  if(con!=null){
//                    try{
//                        String a_id=manager_employeeInfo_page_txtf.getText();
//                        String sqlcommand="SELECT EMPLOYEE_NAME,FETCH_MANAGER(MANAGER_ID),ADDRESS,SEX,SALARY,PHONE_NO,EMAIL_ID,DATE_OF_BIRTH,JOIN_DATE,END_DATE FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
//                        
//                        PreparedStatement pst99=con.prepareStatement(sqlcommand);
//                        pst99.setString(1,a_id);
//                        
//                        ResultSet rs=pst99.executeQuery();
//                        
//                        while(rs.next()){
////                            an_artInfo_from_manager_class.artTitle_result_txt.setText(rs.getString(1).toString());
////                            an_artInfo_from_manager_class.art_genre_result_txt.setText(rs.getString(2).toString());
////                            an_artInfo_from_manager_class.artist_name_result_txt.setText(rs.getString(3).toString());
////                            an_artInfo_from_manager_class.dateOfcreation_result_txt.setText(rs.getString(4));
////                            an_artInfo_from_manager_class.price_result_txt.setText(rs.getString(5).toString());
////                            an_artInfo_from_manager_class.status_result_txt.setText(rs.getString(6).toString());
//
//                             one_employeeInfo_from_manager_class.employee_name_result_txt.setText(rs.getString(1).toString());
//                             one_employeeInfo_from_manager_class.manager_name_result_txt.setText(rs.getString(2));
//                              one_employeeInfo_from_manager_class.address_result_txt.setText(rs.getString(3));
//                               one_employeeInfo_from_manager_class.sex_result_txt.setText(rs.getString(4));
//                                one_employeeInfo_from_manager_class.salary_result_txt.setText(rs.getString(5));
//                                 one_employeeInfo_from_manager_class.phone_no_result_txt.setText(rs.getString(6));
//                                  one_employeeInfo_from_manager_class.email_ID_result_txt.setText(rs.getString(7));
//                                   one_employeeInfo_from_manager_class.dateOf_birth_result_txt.setText(rs.getString(8));
//                                    one_employeeInfo_from_manager_class.join_date_result_txt.setText(rs.getString(9));
//                                     one_employeeInfo_from_manager_class.end_date_result_txt.setText(rs.getString(10));
//                            
//                            
//                            
//                        }
//                        
//                        
//                    }catch(SQLException e){
//                        System.out.println(e.toString());
//                    }
//                }
//                
//                manager_employeeInfo_page_txtf.clear();
//                //manager_employeeInfo_page_result_txt.setText("result");
//            }
//        });
//        
//         Button manager_employeeInfo_page_back_btn= new Button();
//        manager_employeeInfo_page_back_btn.setLayoutX(scene_width-950);
//        manager_employeeInfo_page_back_btn.setLayoutY(scene_height-800);
//        manager_employeeInfo_page_back_btn.setText("BACK");
//        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
//        manager_employeeInfo_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                
//               
//                //managerLoginCheck_class.username_txtf.setText("");
//                //managerLoginCheck_class.password_txtf.setText("");
//                //manager_employeeInfo_page_result_txt.setText("");
//                one_employeeInfo_from_manager_class.address_result_txt.setText("");
//                one_employeeInfo_from_manager_class.dateOf_birth_result_txt.setText("");
//                one_employeeInfo_from_manager_class.email_ID_result_txt.setText("");
//                one_employeeInfo_from_manager_class.employee_name_result_txt.setText("");
//                one_employeeInfo_from_manager_class.end_date_result_txt.setText("");
//                one_employeeInfo_from_manager_class.join_date_result_txt.setText("");
//                one_employeeInfo_from_manager_class.manager_name_result_txt.setText("");
//                one_employeeInfo_from_manager_class.phone_no_result_txt.setText("");
//                one_employeeInfo_from_manager_class.salary_result_txt.setText("");
//                one_employeeInfo_from_manager_class.sex_result_txt.setText("");
//                
//                
//                                   myStage.setScene(manager_query_page_scene);
//
//                
//            }
//        });
//        
        
         Button employee_customerInfo_page_ok_btn= new Button();
        employee_customerInfo_page_ok_btn.setLayoutX(scene_width-750);
        employee_customerInfo_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_customerInfo_page_ok_btn.setText("OK");
        employee_customerInfo_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                    if(con!=null){
                    try{
                        String c_id=employee_customerInfo_page_txtf.getText();
                        String sqlcommand="SELECT CUSTOMER_NAME,ADDRESS,SEX,PHONE_NO,EMAIL_ID,DATE_OF_BIRTH,FAVORITE_GENRE FROM CUSTOMERS WHERE CUSTOMER_ID=?";
                       
                        PreparedStatement pst12=con.prepareStatement(sqlcommand);
                        pst12.setString(1, c_id);
                        
                        ResultSet rs=pst12.executeQuery();
                        
                        while(rs.next()){
                            one_customerInfo_from_employee_class.customer_name_result_txt.setText(rs.getString(1));
                            one_customerInfo_from_employee_class.address_result_txt.setText(rs.getString(2));
                            one_customerInfo_from_employee_class.sex_result_txt.setText(rs.getString(3));
                            one_customerInfo_from_employee_class.phone_no_result_txt.setText(rs.getString(4));
                            one_customerInfo_from_employee_class.email_ID_result_txt.setText(rs.getString(5));
                            one_customerInfo_from_employee_class.dateOf_birth_result_txt.setText(rs.getString(6));
                            one_customerInfo_from_employee_class.favorite_genre_result_txt.setText(rs.getString(7));
                            
			
                        }
			pst12.close();
                    }catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                    }

            }
                    employee_customerInfo_page_txtf.clear();
                    }
                 
                });
        
        
         Button employee_customerInfo_page_back_btn= new Button();
        employee_customerInfo_page_back_btn.setLayoutX(scene_width-950);
        employee_customerInfo_page_back_btn.setLayoutY(scene_height-800);
        employee_customerInfo_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        employee_customerInfo_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                            one_customerInfo_from_employee_class.customer_name_result_txt.setText("");
                            one_customerInfo_from_employee_class.address_result_txt.setText("");
                            one_customerInfo_from_employee_class.sex_result_txt.setText("");
                            one_customerInfo_from_employee_class.phone_no_result_txt.setText("");
                            one_customerInfo_from_employee_class.email_ID_result_txt.setText("");
                            one_customerInfo_from_employee_class.dateOf_birth_result_txt.setText("");
                            one_customerInfo_from_employee_class.favorite_genre_result_txt.setText("");





                                   myStage.setScene(employee_query_page_scene);

                
            }
        });
        
        
         Button employee_artistInfo_page_ok_btn= new Button();
        employee_artistInfo_page_ok_btn.setLayoutX(scene_width-750);
        employee_artistInfo_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_artistInfo_page_ok_btn.setText("OK");
        employee_artistInfo_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                if(con!=null){
                    try{
                        String a_id=employee_artistInfo_page_txtf.getText();
                        //int A_ID=Integer.parseInt(a_id);
                        System.out.println(a_id);
                        String sqlcommand="SELECT ARTIST_NAME ,ADDRESS,SEX,PHONE_NO,EMAIL_ID,DATE_OF_BIRTH,MAIN_GENRE FROM ARTISTS WHERE ARTIST_ID=?";
                        
                        PreparedStatement pst99=con.prepareStatement(sqlcommand);
                        pst99.setString(1,a_id);
                       // pst99.setInt(1, A_ID);
                        
                        ResultSet rs=pst99.executeQuery();
                        
                        while(rs.next()){
                            one_artistInfo_from_employee_class.artist_name_result_txt.setText(rs.getString(1));
                            one_artistInfo_from_employee_class.address_result_txt.setText(rs.getString(2));
                            one_artistInfo_from_employee_class.sex_result_txt.setText(rs.getString(3));
                            one_artistInfo_from_employee_class.phone_no_result_txt.setText(rs.getString(4));
                            one_artistInfo_from_employee_class.email_ID_result_txt.setText(rs.getString(5));
                            one_artistInfo_from_employee_class.dateOf_birth_result_txt.setText(rs.getString(6));
                            one_artistInfo_from_employee_class.main_genre_result_txt.setText(rs.getString(7));
                           // one_artistInfo_from_manager_class.artist_name_result_txt.setText(rs.getString(1));
                            

                            
                            
                        }
                        pst99.close();
                        
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                    }
                }
                employee_artistInfo_page_txtf.clear();
                //manager_artistInfo_page_result_txt.setText("result");
            }
        });
        
         Button employee_artistInfo_page_back_btn= new Button();
        employee_artistInfo_page_back_btn.setLayoutX(scene_width-950);
        employee_artistInfo_page_back_btn.setLayoutY(scene_height-800);
        employee_artistInfo_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        employee_artistInfo_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                            one_artistInfo_from_employee_class.artist_name_result_txt.setText("");
                            one_artistInfo_from_employee_class.address_result_txt.setText("");
                            one_artistInfo_from_employee_class.sex_result_txt.setText("");
                            one_artistInfo_from_employee_class.phone_no_result_txt.setText("");
                            one_artistInfo_from_employee_class.email_ID_result_txt.setText("");
                            one_artistInfo_from_employee_class.dateOf_birth_result_txt.setText("");
                            one_artistInfo_from_employee_class.main_genre_result_txt.setText("");


                                   myStage.setScene(employee_query_page_scene);

                
            }
        });
        
        
         Button employee_artInfo_page_ok_btn= new Button();
        employee_artInfo_page_ok_btn.setLayoutX(scene_width-750);
        employee_artInfo_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_artInfo_page_ok_btn.setText("OK");
        employee_artInfo_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                if(con!=null){
                    try{
                        String a_id=employee_artInfo_page_txtf.getText();
                        int A_ID=Integer.parseInt(a_id);
                        System.out.println(a_id);
                        String sqlcommand="SELECT ART_TITLE,ART_GENRE, FETCH_ARTIST(ARTIST_ID),DATE_OF_CREATION,PRICE,STATUS FROM ARTS WHERE ART_ID=?";
                        
                        PreparedStatement pst99=con.prepareStatement(sqlcommand);
                        //pst99.setString(1,a_id);
                        pst99.setInt(1, A_ID);
                        
                        ResultSet rs=pst99.executeQuery();
                        
                        while(rs.next()){
//                            one_employeeInfo_from_manager_class.employee_name_result_txt.setText(rs.getString(1));
//                             one_employeeInfo_from_manager_class.manager_name_result_txt.setText(rs.getString(2));
//                              one_employeeInfo_from_manager_class.address_result_txt.setText(rs.getString(3));
//                               one_employeeInfo_from_manager_class.sex_result_txt.setText(rs.getString(4));
//                                one_employeeInfo_from_manager_class.salary_result_txt.setText(rs.getString(5));
//                                 one_employeeInfo_from_manager_class.phone_no_result_txt.setText(rs.getString(6));
//                                  one_employeeInfo_from_manager_class.email_ID_result_txt.setText(rs.getString(7));
//                                   one_employeeInfo_from_manager_class.dateOf_birth_result_txt.setText(rs.getString(8));
//                                    one_employeeInfo_from_manager_class.join_date_result_txt.setText(rs.getString(9));
//                                     one_employeeInfo_from_manager_class.end_date_result_txt.setText(rs.getString(10));
//                            
                            one_artInfo_from_employee_class.artTitle_result_txt.setText(rs.getString(1).toString());
                            one_artInfo_from_employee_class.art_genre_result_txt.setText(rs.getString(2).toString());
                            one_artInfo_from_employee_class.artist_name_result_txt.setText(rs.getString(3).toString());
                            one_artInfo_from_employee_class.dateOfcreation_result_txt.setText(rs.getString(4));
                            one_artInfo_from_employee_class.price_result_txt.setText(rs.getString(5).toString());
                            one_artInfo_from_employee_class.status_result_txt.setText(rs.getString(6).toString());
                            
                            
                        }
                        
                        
                    }catch(SQLException e){
                        System.out.println(e.toString());
                    }
                }
                employee_artInfo_page_txtf.clear();
                //manager_artInfo_page_result_txt.setText("result");
            }
        });
        
         Button employee_artInfo_page_back_btn= new Button();
        employee_artInfo_page_back_btn.setLayoutX(scene_width-950);
        employee_artInfo_page_back_btn.setLayoutY(scene_height-800);
        employee_artInfo_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        employee_artInfo_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                one_artInfo_from_employee_class.artTitle_result_txt.setText("");
                one_artInfo_from_employee_class.art_genre_result_txt.setText("");
                one_artInfo_from_employee_class.artist_name_result_txt.setText("");
                one_artInfo_from_employee_class.dateOfcreation_result_txt.setText("");
                one_artInfo_from_employee_class.price_result_txt.setText("");
                one_artInfo_from_employee_class.status_result_txt.setText("");
                
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //manager_artInfo_page_result_txt.setText("");
                                   myStage.setScene(employee_query_page_scene);

                
            }
        });
        
        
         Button employee_artOfartist_page_ok_btn= new Button();
        employee_artOfartist_page_ok_btn.setLayoutX(scene_width-750);
        employee_artOfartist_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        employee_artOfartist_page_ok_btn.setText("OK");
        employee_artOfartist_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String []output_artists_art=new String[100];
                
                for(int i=0;i<100;i++){
                    output_artists_art[i]="";
                }
                int i=0;
                if(con!=null){
                    try{
                        String artist_art=employee_artOfartist_page_txtf.getText();
                        
                        String sqlcommand="SELECT A2.Art_ID,A2.Art_title ,A2.Price,A2.Status FROM Artists A1 JOIN Arts A2 ON (A1.Artist_Id=A2.Artist_Id) WHERE A1.Artist_ID=?";
                          System.out.println(sqlcommand);                 
                                               
                                                
                        
                        PreparedStatement pst1=con.prepareStatement(sqlcommand);
                        pst1.setString(1, artist_art);
                        System.out.println("sdff");
                        
                        ResultSet rs=pst1.executeQuery();
                        System.out.println("asda");
                        
                        while(rs.next()){
                            
                            output_artists_art[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4);
                            i++;
                        }
                        pst1.close();
                    }catch(SQLException e){
                        System.out.println("probem in arts ");
                    }
                }
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                employee_artOfartist_page_txtf.clear();
                
                String artsOfartist_page_result_str= new String();
                              artsOfartist_page_result_str=String.join("\n",output_artists_art);

        //employeeUnderM_show_str= String.join("\n",employees_under());
                employee_artsOfartist_page_result_txt.setText(artsOfartist_page_result_str);

                
                
                //artsOfartist_page_reslut_txt.setText("result");
            }
        });
        
         Button employee_artOfartist_page_back_btn= new Button();
        employee_artOfartist_page_back_btn.setLayoutX(scene_width-950);
        employee_artOfartist_page_back_btn.setLayoutY(scene_height-800);
        employee_artOfartist_page_back_btn.setText("BACK");
        //customer_table_insert_page_from_manager_back_btn.setGraphic(back_btn_img);
        employee_artOfartist_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                employee_artsOfartist_page_result_txt.setText("");
                                   myStage.setScene(employee_query_page_scene);

                
            }
        });
        
        
        
        
        
        
        
        
        
         Button artist_login_check_submit_btn = new Button();
        artist_login_check_submit_btn.setLayoutX(scene_width-650);
        artist_login_check_submit_btn.setLayoutY(scene_height-150);
        //manager_login_check_submit_btn.setGraphic(Submit_txt);
        artist_login_check_submit_btn.setText("SUBMIT");
        artist_login_check_submit_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                if(con!=null){
                        try{
                            System.out.println("asd");
                            String given_username=artistLoginCheck_class.username_txtf.getText();
                            String given_password=artistLoginCheck_class.password_txtf.getText();
                            
                            String sqlcommand= "SELECT ARTIST_ID FROM ARTISTS WHERE USER_NAME=? AND PASSWORD=? ";
                           PreparedStatement pst56=con.prepareStatement(sqlcommand);
                           
                            System.out.println(given_username);
                            System.out.println(given_password);
                           
                           pst56.setString(1,given_username);
                           pst56.setString(2,given_password);
                            System.out.println("asd");
                           
                           ResultSet rs=pst56.executeQuery();
                            System.out.println("asdasdfasd");
                           
                           while(rs.next()){
                               System.out.println("in while");
                               ID=rs.getString(1);
                               myStage.setScene(artist_homepage_scene);
                               
                           }
                           
                           artist_loginCheck_page_error_show.setText("Invalid Username or Password");
                          // myStage.setScene(manager_homepage_scene);
                            System.out.println(ID);
                           pst56.close();
                           
                           
                            
                        }catch(SQLException e){
                            System.out.println(e.toString());
                            System.out.println("pblm");
                        }
                  // myStage.setScene(employee_homepage_scene);
                }
                
                artistLoginCheck_class.username_txtf.clear();
                artistLoginCheck_class.password_txtf.clear();
            }
        });
        
        
        
        
         Button artist_login_check_back_btn= new Button("BACK");
        artist_login_check_back_btn.setLayoutX(scene_width-950);
        artist_login_check_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        //employee_login_check_back_btn.setText("BACK");
        artist_login_check_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                artistLoginCheck_class.username_txtf.clear();
                artistLoginCheck_class.password_txtf.clear();
                
                artist_loginCheck_page_error_show.setText("");
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                 myStage.setScene(login_page_scene);

                
            }
        });
        
  
        
        
        Button artist_homepage_profile_btn= new Button();
        artist_homepage_profile_btn.setLayoutX(scene_width-650);
        artist_homepage_profile_btn.setLayoutY(scene_height-600);
        //manager_homepage_edit_profile_btn.setGraphic(edit_profile_txt);
        artist_homepage_profile_btn.setText("PROFILE");
        artist_homepage_profile_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                if(con!=null)
                {
                    try{
                        
                        String sqlcommand="SELECT * FROM ARTISTS WHERE ARTIST_ID=?";
                        PreparedStatement pst5=con.prepareStatement(sqlcommand);
                        
                        pst5.setString(1, ID);
                        
                        
                        ResultSet rs=pst5.executeQuery();
                        
                        while(rs.next()){
                            
                            artistProfile_class.artist_ID_result_txt.setText(rs.getString(1));
                            artistProfile_class.artist_name_result_txt.setText(rs.getString(2));
                            artistProfile_class.username_result_txt.setText(rs.getString(3));
                            artistProfile_class.password_result_txt.setText(rs.getString(4));
                            artistProfile_class.address_result_txt.setText(rs.getString(5));
                            artistProfile_class.sex_result_txt.setText(rs.getString(6));
                            artistProfile_class.phone_no_result_txt.setText(rs.getString(7));
                            artistProfile_class.email_ID_result_txt.setText(rs.getString(8));
                            artistProfile_class.main_genre_result_txt.setText(rs.getString(9));
                            artistProfile_class.dateOf_birth_result_txt.setText(rs.getString(10));
                                
                    }
                        pst5.close();

                myStage.setScene(artist_profile_scene);
            }catch(SQLException e){
                        System.out.println(e.toString());
            }
                
                }

                myStage.setScene(artist_profile_scene);
            }
        });
        

        
        Button artist_homepage_query_btn= new Button();
        artist_homepage_query_btn.setLayoutX(scene_width-650);
        artist_homepage_query_btn.setLayoutY(scene_height-450);
        //manager_homepage_query_btn.setGraphic(query_txt);
        artist_homepage_query_btn.setText("EXPLORE");
        artist_homepage_query_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(artist_query_scene);
            }
        });

        Button artist_homepage_logout_btn= new Button();
        artist_homepage_logout_btn.setLayoutX(scene_width-150);
        artist_homepage_logout_btn.setLayoutY(scene_height-820);
        //manager_homepage_logout_btn.setGraphic(logout_btn_img);
        artist_homepage_logout_btn.setText("LOG OUT");
        artist_homepage_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                artist_loginCheck_page_error_show.setText("");
                System.out.println(ID);
                myStage.setScene(login_page_scene);
            }
        });
        
         Button artist_profile_page_logout_btn= new Button();
        artist_profile_page_logout_btn.setLayoutX(scene_width-150);
        artist_profile_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        artist_profile_page_logout_btn.setText("LOG OUT");
        artist_profile_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                artist_loginCheck_page_error_show.setText("");
                ID="";
                myStage.setScene(login_page_scene);
            }
        });
        
         Button artist_profile_page_home_btn= new Button();
        artist_profile_page_home_btn.setLayoutX(scene_width-950);
        artist_profile_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        artist_profile_page_home_btn.setText("HOME");
        artist_profile_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(artist_homepage_scene);
            }
        });
        
         Button artist_profile_page_editProfile_btn= new Button();
        artist_profile_page_editProfile_btn.setLayoutX(scene_width-400);
        artist_profile_page_editProfile_btn.setLayoutY(scene_height-200);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        artist_profile_page_editProfile_btn.setText("EDIT PROFILE");
        artist_profile_page_editProfile_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                if(con!=null){
                    try{
                        
                        String sqlcommand="SELECT  USER_NAME,ADDRESS,PHONE_NO,EMAIL_ID,PASSWORD FROM ARTISTS WHERE ARTIST_ID=?";
                        PreparedStatement pst80=con.prepareStatement(sqlcommand);
                        
                        pst80.setString(1, ID);
                        
                        ResultSet rs=pst80.executeQuery();
                        
                        while(rs.next()){
                            artistEditProfile_class.new_username_txf.setText(rs.getString(1));
                            artistEditProfile_class.new_address_txf.setText(rs.getString(2));
                            artistEditProfile_class.new_password_txf.setText(rs.getString(3));
                            artistEditProfile_class.new_email_id_txf.setText(rs.getString(4));
                            artistEditProfile_class.new_phone_no_txf.setText(rs.getString(5));
                        }
                        
                        pst80.close();
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                    }
                }
                myStage.setScene(artist_edit_profile_scene);
            }
        });
        
        
        
        Button artist_edit_profile_page_logout_btn= new Button();
        artist_edit_profile_page_logout_btn.setLayoutX(scene_width-150);
        artist_edit_profile_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        artist_edit_profile_page_logout_btn.setText("LOG OUT");
        artist_edit_profile_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                artist_loginCheck_page_error_show.setText("");
                ID="";
                myStage.setScene(login_page_scene);
            }
        });
        
         Button artist_edit_profile_page_home_btn= new Button();
        artist_edit_profile_page_home_btn.setLayoutX(scene_width-950);
        artist_edit_profile_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        artist_edit_profile_page_home_btn.setText("HOME");
        artist_edit_profile_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(artist_homepage_scene);
            }
        });
        
         Button artist_edit_profile_page_ok_btn= new Button();
        artist_edit_profile_page_ok_btn.setLayoutX(scene_width-700);
        artist_edit_profile_page_ok_btn.setLayoutY(scene_height-450);
        //manager_edit_profile_page_ok_btn.setGraphic(OK_txt);
        artist_edit_profile_page_ok_btn.setText("OK");
        artist_edit_profile_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                   if(con!=null){
                    
                    try{
                        
                       // Statement stmt4=con.createStatement();
                       
                       
                        
                        String u_username =artistEditProfile_class.new_username_txf.getText();
                        String u_address = artistEditProfile_class.new_address_txf.getText();
                        String u_phone= artistEditProfile_class.new_phone_no_txf.getText();
                        String u_email= artistEditProfile_class.new_email_id_txf.getText();
                        String u_password=artistEditProfile_class.new_password_txf.getText();
                        
                        String sqlcommand= "UPDATE ARTISTS SET USER_NAME=? ,ADDRESS=?, PHONE_NO=?,EMaIL_ID=?,PASSWORD=? WHERE ARTIST_ID=? ";
                        PreparedStatement pst34 =con.prepareStatement(sqlcommand);
                        
                        
                        pst34.setString(1,u_username);
                        pst34.setString(2,u_address);
                        pst34.setString(3,u_phone);
                        pst34.setString(4,u_email);
                        pst34.setString(5,u_password);
                        pst34.setString(6, ID);
                        
                        pst34.executeUpdate();
                        pst34.close();
                        
                        //String sqlcommand="UPDATE MANAGERS SET USER_NAME ''='"+u_username+"','ADDRESS'='"+u_address+"','PHONE_NUMBER'='"+u_phone+"','EMAIL_ID'='"+u_email+"','PASSWORD'='"+u_password"'"
          
                        
                        //stmt4.executeQuery(sqlcommand);
                        
                   } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                  artistEditProfile_class.new_address_txf.clear();
                  artistEditProfile_class.new_email_id_txf.clear();
                  artistEditProfile_class.new_password_txf.clear();
                  artistEditProfile_class.new_phone_no_txf.clear();
                  artistEditProfile_class.new_username_txf.clear();
               //System.out.println("Hello World!");
               // myStage.setScene(artist_homepage_scene);
            }
        });
        
        
        MenuButton artist_query_page_exhibition_mbtn = new MenuButton();
        artist_query_page_exhibition_mbtn.setText("Exhibitions");
        artist_query_page_exhibition_mbtn.setLayoutX(scene_width-800);
        artist_query_page_exhibition_mbtn.setLayoutY(scene_height-700);
        MenuItem artist_current_exhibition_mitem = new MenuItem("Current Exhibitions");
        MenuItem artist_upcoming_exhibition_mitem = new MenuItem("Upcoming Exhibitions");
        MenuItem artist_past_exhibition_mitem = new MenuItem("Past Exhibitions");
        artist_query_page_exhibition_mbtn.getItems().addAll(artist_current_exhibition_mitem,artist_upcoming_exhibition_mitem,artist_past_exhibition_mitem);
        
        artist_current_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_current_exhibitions_page_scene);
            }
        });
        
        artist_upcoming_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_upcoming_exhibitions_page_scene);
            }
        });
        
         artist_past_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
               myStage.setScene(artist_past_exhibitions_page_scene);
            }
        });
         
         
         Button artist_current_exhi_page_back_btn= new Button();
        artist_current_exhi_page_back_btn.setLayoutX(scene_width-950);
        artist_current_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_current_exhi_page_back_btn.setText("BACK");
        artist_current_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //myStage.setScene();
               myStage.setScene(artist_query_scene);

                
            }
        });
        
         Button artist_upcoming_exhi_page_back_btn= new Button();
        artist_upcoming_exhi_page_back_btn.setLayoutX(scene_width-950);
        artist_upcoming_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_upcoming_exhi_page_back_btn.setText("BACK");
        artist_upcoming_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
       
        
        Button artist_past_exhi_page_back_btn= new Button();
        artist_past_exhi_page_back_btn.setLayoutX(scene_width-950);
        artist_past_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_past_exhi_page_back_btn.setText("BACK");
        artist_past_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
        
        
        Button artist_query_page_payslip_btn= new Button();
        artist_query_page_payslip_btn.setLayoutX(scene_width-800);
        artist_query_page_payslip_btn.setLayoutY(scene_height-600);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_query_page_payslip_btn.setText("PAYSLIPS OF MINE");
        artist_query_page_payslip_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
           String []output_payslip=new String[100];
            
            for(int i=0;i<100;i++){
                output_payslip[i]="";
                
            }
            
            int i=0;
            
            if(con!=null){
                try{
                    
                    String sqlcommand="SELECT PAYSLIP_ID,ART_ID,FETCH_ART(ART_ID),PAYSLIP_DATE,PAYSLIP_AMOUNT FROM PAYSLIP WHERE ARTIST_ID=?";
                    PreparedStatement pst50=con.prepareStatement(sqlcommand);
                    
                    pst50.setString(1, ID);
                    
                    ResultSet rs=pst50.executeQuery();
                    System.out.println("llllllllllllllllllll");
                    System.out.println(ID);
                    
                    while(rs.next()){
                        
                        output_payslip[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5);
                        i++;
                        System.out.println("pppppppppppppppp");
                    }
                    
                }
                          
                 catch (SQLException ex) {
                   Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
            
          String artist_payslip_page_result_str= new String();
        artist_payslip_page_result_str= String.join("\n",output_payslip);
        artist_payslip_page_result_txt.setText(artist_payslip_page_result_str);
                
               myStage.setScene(artist_payslip_page_scene);

                
            }
        });
        
        Button artist_payslip_page_back_btn= new Button();
        artist_payslip_page_back_btn.setLayoutX(scene_width-950);
        artist_payslip_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_payslip_page_back_btn.setText("BACK");
        artist_payslip_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
       

         Button artist_query_page_artsOfartist_btn= new Button();
        artist_query_page_artsOfartist_btn.setLayoutX(scene_width-800);
        artist_query_page_artsOfartist_btn.setLayoutY(scene_height-500);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_query_page_artsOfartist_btn.setText("SEARCH ARTS OF AN ARTIST");
        artist_query_page_artsOfartist_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_artsOfartist_page_scene);

                
            }
        });
        
         Button artist_artOfartist_page_ok_btn= new Button();
        artist_artOfartist_page_ok_btn.setLayoutX(scene_width-750);
        artist_artOfartist_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        artist_artOfartist_page_ok_btn.setText("OK");
        artist_artOfartist_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String []output_artists_art=new String[100];
                
                for(int i=0;i<100;i++){
                    output_artists_art[i]="";
                }
                int i=0;
                if(con!=null){
                    try{
                        String artist_art=artist_artOfartist_page_txtf.getText();
                        
                        String sqlcommand="SELECT A2.Art_ID,A2.Art_title ,A2.Price,A2.Status FROM Artists A1 JOIN Arts A2 ON (A1.Artist_Id=A2.Artist_Id) WHERE A1.Artist_ID=?";
                          System.out.println(sqlcommand);                 
                                               
                                                
                        
                        PreparedStatement pst1=con.prepareStatement(sqlcommand);
                        pst1.setString(1, artist_art);
                        System.out.println("sdff");
                        
                        ResultSet rs=pst1.executeQuery();
                        System.out.println("asda");
                        
                        while(rs.next()){
                            
                            output_artists_art[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4);
                            i++;
                        }
                        pst1.close();
                    }catch(SQLException e){
                        System.out.println("probem in arts ");
                    }
                }
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                artist_artOfartist_page_txtf.clear();
                
                String artsOfartist_page_result_str= new String();
                              artsOfartist_page_result_str=String.join("\n",output_artists_art);

        //employeeUnderM_show_str= String.join("\n",employees_under());
                artist_artsOfartist_page_result_txt.setText(artsOfartist_page_result_str);

                
                
                //artsOfartist_page_reslut_txt.setText("result");
            }
        });
        
        
        Button artist_artsOfartist_page_back_btn= new Button();
        artist_artsOfartist_page_back_btn.setLayoutX(scene_width-950);
        artist_artsOfartist_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsOfartist_page_back_btn.setText("BACK");
        artist_artsOfartist_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
       
        
         MenuButton artist_query_page_artsBYprice_mbtn = new MenuButton();
        artist_query_page_artsBYprice_mbtn.setText("SEARCH ARTS BY PRICE");
        artist_query_page_artsBYprice_mbtn.setLayoutX(scene_width-800);
        artist_query_page_artsBYprice_mbtn.setLayoutY(scene_height-400);
        MenuItem artist_artsBYprice_upto2k_mitem = new MenuItem("LESS THAN 2 THOUSANDS");
        MenuItem artist_artsBYprice_2kto5k_mitem = new MenuItem("2 THOUSANDS TO 5 THOUSANDS");
        MenuItem artist_artsBYprice_above5k_mitem = new MenuItem("MORE THAN 5 THOUSANDS");
        artist_query_page_artsBYprice_mbtn.getItems().addAll(artist_artsBYprice_upto2k_mitem,artist_artsBYprice_2kto5k_mitem,artist_artsBYprice_above5k_mitem);
        
        artist_artsBYprice_upto2k_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_artsBYprice_upto2k_page_scene);
            }
        });
        
        artist_artsBYprice_2kto5k_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_artsBYprice_2kto5k_page_scene);
            }
        });
        
         artist_artsBYprice_above5k_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_artsBYprice_above5k_page_scene);
            }
        });
        
         
         
         Button artist_artsBYprice_upto2k_page_back_btn= new Button();
        artist_artsBYprice_upto2k_page_back_btn.setLayoutX(scene_width-950);
        artist_artsBYprice_upto2k_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsBYprice_upto2k_page_back_btn.setText("BACK");
        artist_artsBYprice_upto2k_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //myStage.setScene();
               myStage.setScene(artist_query_scene);

                
            }
        });
        
         Button artist_artsBYprice_2kto5k_page_back_btn= new Button();
        artist_artsBYprice_2kto5k_page_back_btn.setLayoutX(scene_width-950);
        artist_artsBYprice_2kto5k_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsBYprice_2kto5k_page_back_btn.setText("BACK");
        artist_artsBYprice_2kto5k_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
       
        
        Button artist_artsBYprice_above5k_page_back_btn= new Button();
        artist_artsBYprice_above5k_page_back_btn.setLayoutX(scene_width-950);
        artist_artsBYprice_above5k_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsBYprice_above5k_page_back_btn.setText("BACK");
        artist_artsBYprice_above5k_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
         
         MenuButton artist_query_page_artsBYtype_mbtn = new MenuButton();
        artist_query_page_artsBYtype_mbtn.setText("SEARCH ARTS BY TYPE");
        artist_query_page_artsBYtype_mbtn.setLayoutX(scene_width-800);
        artist_query_page_artsBYtype_mbtn.setLayoutY(scene_height-300);
        MenuItem artist_artsBYtype_maritime_mitem = new MenuItem("MARITIME ART");
        MenuItem artist_artsBYtype_symbolism_mitem = new MenuItem("SYMBOLISM");
        MenuItem artist_artsBYtype_renaissance_mitem = new MenuItem("RENAISSANCE");
        MenuItem artist_artsBYtype_fauvism_mitem = new MenuItem("FAUVISM");
        MenuItem artist_artsBYtype_postModern_mitem = new MenuItem("POST MODERN");
        
        artist_query_page_artsBYtype_mbtn.getItems().addAll(artist_artsBYtype_maritime_mitem,artist_artsBYtype_symbolism_mitem,
                artist_artsBYtype_renaissance_mitem,artist_artsBYtype_fauvism_mitem,artist_artsBYtype_postModern_mitem);
        
        
        
        artist_artsBYtype_maritime_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                
         
                myStage.setScene(artist_artsBYtype_maritime_page_scene);
            }
        });
        
        artist_artsBYtype_symbolism_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_artsBYtype_symbolism_page_scene);
            }
        });
        
         artist_artsBYtype_renaissance_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_artsBYtype_renaissance_page_scene);
            }
        });
        
          artist_artsBYtype_fauvism_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_artsBYtype_fauvism_page_scene);
            }
        });
        
         artist_artsBYtype_postModern_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(artist_artsBYtype_postModern_page_scene);
            }
        });
        
         
         
         Button artist_artsBYtype_maritime_page_back_btn= new Button();
        artist_artsBYtype_maritime_page_back_btn.setLayoutX(scene_width-950);
        artist_artsBYtype_maritime_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsBYtype_maritime_page_back_btn.setText("BACK");
        artist_artsBYtype_maritime_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //myStage.setScene();
               myStage.setScene(artist_query_scene);

                
            }
        });
        
         Button artist_artsBYtype_symbolism_page_back_btn= new Button();
        artist_artsBYtype_symbolism_page_back_btn.setLayoutX(scene_width-950);
        artist_artsBYtype_symbolism_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsBYtype_symbolism_page_back_btn.setText("BACK");
        artist_artsBYtype_symbolism_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
       
        
        Button artist_artsBYtype_renaissance_page_back_btn= new Button();
        artist_artsBYtype_renaissance_page_back_btn.setLayoutX(scene_width-950);
        artist_artsBYtype_renaissance_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsBYtype_renaissance_page_back_btn.setText("BACK");
        artist_artsBYtype_renaissance_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
         
        Button artist_artsBYtype_fauvism_page_back_btn= new Button();
        artist_artsBYtype_fauvism_page_back_btn.setLayoutX(scene_width-950);
        artist_artsBYtype_fauvism_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsBYtype_fauvism_page_back_btn.setText("BACK");
        artist_artsBYtype_fauvism_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
         
        Button artist_artsBYtype_postModern_page_back_btn= new Button();
        artist_artsBYtype_postModern_page_back_btn.setLayoutX(scene_width-950);
        artist_artsBYtype_postModern_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        artist_artsBYtype_postModern_page_back_btn.setText("BACK");
        artist_artsBYtype_postModern_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(artist_query_scene);

                
            }
        });
        
        
        Button artist_query_page_logout_btn= new Button();
        artist_query_page_logout_btn.setLayoutX(scene_width-150);
        artist_query_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        artist_query_page_logout_btn.setText("LOG OUT");
        artist_query_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                artist_loginCheck_page_error_show.setText("");
                ID="";
                myStage.setScene(login_page_scene);
            }
        });
        
         Button artist_query_page_home_btn= new Button();
        artist_query_page_home_btn.setLayoutX(scene_width-950);
        artist_query_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        artist_query_page_home_btn.setText("HOME");
        artist_query_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(artist_homepage_scene);
            }
        });
        
         
        
        
        
        
        
        
        
         Button customer_login_check_submit_btn = new Button();
        customer_login_check_submit_btn.setLayoutX(scene_width-650);
        customer_login_check_submit_btn.setLayoutY(scene_height-150);
        //manager_login_check_submit_btn.setGraphic(Submit_txt);
        customer_login_check_submit_btn.setText("SUBMIT");
        customer_login_check_submit_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                if(con!=null){
                        try{
                            System.out.println("asd");
                            String given_username=customerLoginCheck_class.username_txtf.getText();
                            String given_password=customerLoginCheck_class.password_txtf.getText();
                            
                            String sqlcommand= "SELECT CUSTOMER_ID FROM CUSTOMERS WHERE USER_NAME=? AND PASSWORD=? ";
                           PreparedStatement pst56=con.prepareStatement(sqlcommand);
                           
                            System.out.println(given_username);
                            System.out.println(given_password);
                           
                           pst56.setString(1,given_username);
                           pst56.setString(2,given_password);
                            System.out.println("asd");
                           
                           ResultSet rs=pst56.executeQuery();
                            System.out.println("asdasdfasd");
                           
                           while(rs.next()){
                               System.out.println("in while");
                               ID=rs.getString(1);
                               myStage.setScene(customer_homepage_scene);
                               
                           }
                           
                           customer_loginCheck_page_error_show.setText("Invalid Username or Password");
                          // myStage.setScene(manager_homepage_scene);
                            System.out.println(ID);
                           pst56.close();
                           
                           
                            
                        }catch(SQLException e){
                            System.out.println(e.toString());
                            System.out.println("pblm");
                        }
                  // myStage.setScene(employee_homepage_scene);
                }
                
                customerLoginCheck_class.username_txtf.clear();
                customerLoginCheck_class.password_txtf.clear();
            }
        });
        
        
        
        
         Button customer_login_check_back_btn= new Button("BACK");
        customer_login_check_back_btn.setLayoutX(scene_width-950);
        customer_login_check_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        //employee_login_check_back_btn.setText("BACK");
        customer_login_check_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                customerLoginCheck_class.username_txtf.clear();
                customerLoginCheck_class.password_txtf.clear();
                
                customer_loginCheck_page_error_show.setText("");
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                 myStage.setScene(login_page_scene);

                
            }
        });
        
        
         Button customer_homepage_profile_btn= new Button();
        customer_homepage_profile_btn.setLayoutX(scene_width-650);
        customer_homepage_profile_btn.setLayoutY(scene_height-600);
        //manager_homepage_edit_profile_btn.setGraphic(edit_profile_txt);
        customer_homepage_profile_btn.setText("PROFILE");
        customer_homepage_profile_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                if(con!=null)
                {
                    try{
                        
                        String sqlcommand="SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID=?";
                        PreparedStatement pst5=con.prepareStatement(sqlcommand);
                        
                        pst5.setString(1, ID);
                        
                        
                        ResultSet rs=pst5.executeQuery();
                        
                        while(rs.next()){
                            
                            customerProfile_class.customer_ID_result_txt.setText(rs.getString(1));
                            customerProfile_class.customer_name_result_txt.setText(rs.getString(2));
                            customerProfile_class.username_result_txt.setText(rs.getString(3));
                            customerProfile_class.password_result_txt.setText(rs.getString(4));
                            customerProfile_class.sex_result_txt.setText(rs.getString(5));
                            customerProfile_class.address_result_txt.setText(rs.getString(6));

                            customerProfile_class.phone_no_result_txt.setText(rs.getString(7));
                            customerProfile_class.email_ID_result_txt.setText(rs.getString(8));
                            customerProfile_class.favourite_genre_result_txt.setText(rs.getString(9));
                            customerProfile_class.dateOf_birth_result_txt.setText(rs.getString(10));
                                
                    }
                        pst5.close();

                myStage.setScene(artist_profile_scene);
            }catch(SQLException e){
                        System.out.println(e.toString());
            }
                
                }

                myStage.setScene(customer_profile_scene);
            }
        });
        

        
        Button customer_homepage_query_btn= new Button();
        customer_homepage_query_btn.setLayoutX(scene_width-650);
        customer_homepage_query_btn.setLayoutY(scene_height-450);
        //manager_homepage_query_btn.setGraphic(query_txt);
        customer_homepage_query_btn.setText("EXPLORE");
        customer_homepage_query_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(customer_query_scene);
            }
        });

        Button customer_homepage_logout_btn= new Button();
        customer_homepage_logout_btn.setLayoutX(scene_width-150);
        customer_homepage_logout_btn.setLayoutY(scene_height-820);
        //manager_homepage_logout_btn.setGraphic(logout_btn_img);
        customer_homepage_logout_btn.setText("LOG OUT");
        customer_homepage_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                customer_loginCheck_page_error_show.setText("");
                System.out.println(ID);
                myStage.setScene(login_page_scene);
            }
        });
        
        
        
         Button customer_profile_page_logout_btn= new Button();
        customer_profile_page_logout_btn.setLayoutX(scene_width-150);
        customer_profile_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        customer_profile_page_logout_btn.setText("LOG OUT");
        customer_profile_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                customer_loginCheck_page_error_show.setText("");
                ID="";
                myStage.setScene(login_page_scene);
            }
        });
        
         Button customer_profile_page_home_btn= new Button();
        customer_profile_page_home_btn.setLayoutX(scene_width-950);
        customer_profile_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        customer_profile_page_home_btn.setText("HOME");
        customer_profile_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(customer_homepage_scene);
            }
        });
        
         Button customer_profile_page_editProfile_btn= new Button();
        customer_profile_page_editProfile_btn.setLayoutX(scene_width-400);
        customer_profile_page_editProfile_btn.setLayoutY(scene_height-200);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        customer_profile_page_editProfile_btn.setText("EDIT PROFILE");
        customer_profile_page_editProfile_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                if(con!=null){
                    try{
                        
                        String sqlcommand="SELECT  USER_NAME,ADDRESS,PHONE_NO,EMAIL_ID,PASSWORD FROM CUSTOMERS WHERE CUSTOMER_ID=?";
                        PreparedStatement pst80=con.prepareStatement(sqlcommand);
                        
                        pst80.setString(1, ID);
                        
                        ResultSet rs=pst80.executeQuery();
                        
                        while(rs.next()){
                            customerEditProfile_class.new_username_txf.setText(rs.getString(1));
                            customerEditProfile_class.new_address_txf.setText(rs.getString(2));
                            customerEditProfile_class.new_password_txf.setText(rs.getString(3));
                            customerEditProfile_class.new_email_id_txf.setText(rs.getString(4));
                            customerEditProfile_class.new_phone_no_txf.setText(rs.getString(5));
                        }
                        
                        pst80.close();
                    }catch(SQLException e){
                        System.out.println(e.toString());
                        
                    }
                }
                myStage.setScene(customer_edit_profile_scene);
            }
        });
        
  
        
        
         Button customer_edit_profile_page_logout_btn= new Button();
        customer_edit_profile_page_logout_btn.setLayoutX(scene_width-150);
        customer_edit_profile_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        customer_edit_profile_page_logout_btn.setText("LOG OUT");
        customer_edit_profile_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                customer_loginCheck_page_error_show.setText("");
                ID="";
                myStage.setScene(login_page_scene);
            }
        });
        
         Button customer_edit_profile_page_home_btn= new Button();
        customer_edit_profile_page_home_btn.setLayoutX(scene_width-950);
        customer_edit_profile_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        customer_edit_profile_page_home_btn.setText("HOME");
        customer_edit_profile_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(customer_homepage_scene);
            }
        });
        
         Button customer_edit_profile_page_ok_btn= new Button();
        customer_edit_profile_page_ok_btn.setLayoutX(scene_width-700);
        customer_edit_profile_page_ok_btn.setLayoutY(scene_height-450);
        //manager_edit_profile_page_ok_btn.setGraphic(OK_txt);
        customer_edit_profile_page_ok_btn.setText("OK");
        customer_edit_profile_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                   if(con!=null){
                    
                    try{
                        
                       // Statement stmt4=con.createStatement();
                       
                       
                        
                        String u_username =customerEditProfile_class.new_username_txf.getText();
                        String u_address = customerEditProfile_class.new_address_txf.getText();
                        String u_phone= customerEditProfile_class.new_phone_no_txf.getText();
                        String u_email= customerEditProfile_class.new_email_id_txf.getText();
                        String u_password=customerEditProfile_class.new_password_txf.getText();
                        
                        String sqlcommand= "UPDATE CUSTOMERS SET USER_NAME=? ,ADDRESS=?, PHONE_NO=?,EMaIL_ID=?,PASSWORD=? WHERE CUSTOMER_ID=? ";
                        PreparedStatement pst34 =con.prepareStatement(sqlcommand);
                        
                        
                        pst34.setString(1,u_username);
                        pst34.setString(2,u_address);
                        pst34.setString(3,u_phone);
                        pst34.setString(4,u_email);
                        pst34.setString(5,u_password);
                        pst34.setString(6, ID);
                        
                        pst34.executeUpdate();
                        pst34.close();
                        
                        //String sqlcommand="UPDATE MANAGERS SET USER_NAME ''='"+u_username+"','ADDRESS'='"+u_address+"','PHONE_NUMBER'='"+u_phone+"','EMAIL_ID'='"+u_email+"','PASSWORD'='"+u_password"'"
          
                        
                        //stmt4.executeQuery(sqlcommand);
                        
                   } catch (SQLException ex) {
                        Logger.getLogger(Database_project2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                  customerEditProfile_class.new_address_txf.clear();
                  customerEditProfile_class.new_email_id_txf.clear();
                  customerEditProfile_class.new_password_txf.clear();
                  customerEditProfile_class.new_phone_no_txf.clear();
                  customerEditProfile_class.new_username_txf.clear();
               //System.out.println("Hello World!");
               // myStage.setScene(artist_homepage_scene);
            }
        });
        
        
        
        MenuButton customer_query_page_exhibition_mbtn = new MenuButton();
        customer_query_page_exhibition_mbtn.setText("Exhibitions");
        customer_query_page_exhibition_mbtn.setLayoutX(scene_width-800);
        customer_query_page_exhibition_mbtn.setLayoutY(scene_height-700);
        MenuItem customer_current_exhibition_mitem = new MenuItem("Current Exhibitions");
        MenuItem customer_upcoming_exhibition_mitem = new MenuItem("Upcoming Exhibitions");
        MenuItem customer_past_exhibition_mitem = new MenuItem("Past Exhibitions");
        customer_query_page_exhibition_mbtn.getItems().addAll(customer_current_exhibition_mitem,customer_upcoming_exhibition_mitem,customer_past_exhibition_mitem);
        
        customer_current_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_current_exhibitions_page_scene);
            }
        });
        
        customer_upcoming_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_upcoming_exhibitions_page_scene);
            }
        });
        
         customer_past_exhibition_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
               myStage.setScene(customer_past_exhibitions_page_scene);
            }
        });
         
         
         Button customer_current_exhi_page_back_btn= new Button();
        customer_current_exhi_page_back_btn.setLayoutX(scene_width-950);
        customer_current_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_current_exhi_page_back_btn.setText("BACK");
        customer_current_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //myStage.setScene();
               myStage.setScene(customer_query_scene);

                
            }
        });
        
         Button customer_upcoming_exhi_page_back_btn= new Button();
        customer_upcoming_exhi_page_back_btn.setLayoutX(scene_width-950);
        customer_upcoming_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_upcoming_exhi_page_back_btn.setText("BACK");
        customer_upcoming_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
       
        
        Button customer_past_exhi_page_back_btn= new Button();
        customer_past_exhi_page_back_btn.setLayoutX(scene_width-950);
        customer_past_exhi_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_past_exhi_page_back_btn.setText("BACK");
        customer_past_exhi_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
        
        
        Button customer_query_page_bill_btn= new Button();
        customer_query_page_bill_btn.setLayoutX(scene_width-800);
        customer_query_page_bill_btn.setLayoutY(scene_height-600);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_query_page_bill_btn.setText("TOTAL BILLS");
        customer_query_page_bill_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                String []output_bill=new String[100];
            
            for(int i=0;i<100;i++){
                
                output_bill[i]="";
            }
            
            int i=0;
            
            if(con!=null){
                
                try{
                    
                    String sqlcommand="SELECT BILL_ID,CUSTOMER_ID,FETCH_CUSTOMER(CUSTOMER_ID),ART_ID,FETCH_ART(ART_ID),ARTIST_ID,FETCH_ARTIST(ARTIST_ID),BILL_DATE,BILL_AMOUNT FROM BILL WHERE CUSTOMER_ID=? ";
                    
                    PreparedStatement pst100=con.prepareStatement(sqlcommand);
                    
                    pst100.setString(1,ID);
                    
                    ResultSet rs= pst100.executeQuery();
                    System.out.println("jjjjjjjjjjj");
                    
                    while(rs.next()){
                        output_bill[i]=rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9);
                        i++;
                        System.out.println("kkkkkkkkkkkk");
                    }
                    pst100.close();
                }catch(SQLException e){
                    System.out.println(e.toString());
                }
            }
            
         String customer_bill_page_result_str= new String();
        customer_bill_page_result_str= String.join("\n",output_bill);
        customer_bill_page_result_txt.setText(customer_bill_page_result_str);
               myStage.setScene(customer_bill_page_scene);

                
            }
        });
        
        
        
        Button customer_bill_page_back_btn= new Button();
        customer_bill_page_back_btn.setLayoutX(scene_width-950);
        customer_bill_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_bill_page_back_btn.setText("BACK");
        customer_bill_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
       

         Button customer_query_page_artsOfartist_btn= new Button();
        customer_query_page_artsOfartist_btn.setLayoutX(scene_width-800);
        customer_query_page_artsOfartist_btn.setLayoutY(scene_height-500);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_query_page_artsOfartist_btn.setText("SEARCH ARTS OF AN ARTIST");
        customer_query_page_artsOfartist_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_artsOfartist_page_scene);

                
            }
        });
        
        Button customer_artsOfartist_page_back_btn= new Button();
        customer_artsOfartist_page_back_btn.setLayoutX(scene_width-950);
        customer_artsOfartist_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsOfartist_page_back_btn.setText("BACK");
        customer_artsOfartist_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
        
         Button customer_artOfartist_page_ok_btn= new Button();
        customer_artOfartist_page_ok_btn.setLayoutX(scene_width-750);
        customer_artOfartist_page_ok_btn.setLayoutY(scene_height-600);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        customer_artOfartist_page_ok_btn.setText("OK");
        customer_artOfartist_page_ok_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String []output_artists_art=new String[100];
                
                for(int i=0;i<100;i++){
                    output_artists_art[i]="";
                }
                int i=0;
                if(con!=null){
                    try{
                        String artist_art=customer_artOfartist_page_txtf.getText();
                        
                        String sqlcommand="SELECT A2.Art_ID,A2.Art_title ,A2.Price,A2.Status FROM Artists A1 JOIN Arts A2 ON (A1.Artist_Id=A2.Artist_Id) WHERE A1.Artist_ID=?";
                          System.out.println(sqlcommand);                 
                                               
                                                
                        
                        PreparedStatement pst1=con.prepareStatement(sqlcommand);
                        pst1.setString(1, artist_art);
                        System.out.println("sdff");
                        
                        ResultSet rs=pst1.executeQuery();
                        System.out.println("asda");
                        
                        while(rs.next()){
                            
                            output_artists_art[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4);
                            i++;
                        }
                        pst1.close();
                    }catch(SQLException e){
                        System.out.println("probem in arts ");
                    }
                }
                //System.out.println("Hello World!");
                //myStage.setScene(manager_homepage_scene);
                customer_artOfartist_page_txtf.clear();
                
                String artsOfartist_page_result_str= new String();
                              artsOfartist_page_result_str=String.join("\n",output_artists_art);

        //employeeUnderM_show_str= String.join("\n",employees_under());
                customer_artsOfartist_page_result_txt.setText(artsOfartist_page_result_str);

                
                
                //artsOfartist_page_reslut_txt.setText("result");
            }
        });
        
       
        
         MenuButton customer_query_page_artsBYprice_mbtn = new MenuButton();
        customer_query_page_artsBYprice_mbtn.setText("SEARCH ARTS BY PRICE");
        customer_query_page_artsBYprice_mbtn.setLayoutX(scene_width-800);
        customer_query_page_artsBYprice_mbtn.setLayoutY(scene_height-400);
        MenuItem customer_artsBYprice_upto2k_mitem = new MenuItem("LESS THAN 2 THOUSANDS");
        MenuItem customer_artsBYprice_2kto5k_mitem = new MenuItem("2 THOUSANDS TO 5 THOUSANDS");
        MenuItem customer_artsBYprice_above5k_mitem = new MenuItem("MORE THAN 5 THOUSANDS");
        customer_query_page_artsBYprice_mbtn.getItems().addAll(customer_artsBYprice_upto2k_mitem,customer_artsBYprice_2kto5k_mitem,customer_artsBYprice_above5k_mitem);
        
        customer_artsBYprice_upto2k_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_artsBYprice_upto2k_page_scene);
            }
        });
        
        customer_artsBYprice_2kto5k_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_artsBYprice_2kto5k_page_scene);
            }
        });
        
         customer_artsBYprice_above5k_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_artsBYprice_above5k_page_scene);
            }
        });
        
         
         
         Button customer_artsBYprice_upto2k_page_back_btn= new Button();
        customer_artsBYprice_upto2k_page_back_btn.setLayoutX(scene_width-950);
        customer_artsBYprice_upto2k_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsBYprice_upto2k_page_back_btn.setText("BACK");
        customer_artsBYprice_upto2k_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //myStage.setScene();
               myStage.setScene(customer_query_scene);

                
            }
        });
        
         Button customer_artsBYprice_2kto5k_page_back_btn= new Button();
        customer_artsBYprice_2kto5k_page_back_btn.setLayoutX(scene_width-950);
        customer_artsBYprice_2kto5k_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsBYprice_2kto5k_page_back_btn.setText("BACK");
        customer_artsBYprice_2kto5k_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
       
        
        Button customer_artsBYprice_above5k_page_back_btn= new Button();
        customer_artsBYprice_above5k_page_back_btn.setLayoutX(scene_width-950);
        customer_artsBYprice_above5k_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsBYprice_above5k_page_back_btn.setText("BACK");
        customer_artsBYprice_above5k_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
         
         MenuButton customer_query_page_artsBYtype_mbtn = new MenuButton();
        customer_query_page_artsBYtype_mbtn.setText("SEARCH ARTS BY TYPES");
        customer_query_page_artsBYtype_mbtn.setLayoutX(scene_width-800);
        customer_query_page_artsBYtype_mbtn.setLayoutY(scene_height-300);
        MenuItem customer_artsBYtype_maritime_mitem = new MenuItem("MARITIME ART");
        MenuItem customer_artsBYtype_symbolism_mitem = new MenuItem("SYMBOLISM");
        MenuItem customer_artsBYtype_renaissance_mitem = new MenuItem("RENAISSANCE");
        MenuItem customer_artsBYtype_fauvism_mitem = new MenuItem("FAUVISM");
        MenuItem customer_artsBYtype_postModern_mitem = new MenuItem("POST MODERN");
        
        customer_query_page_artsBYtype_mbtn.getItems().addAll(customer_artsBYtype_maritime_mitem,customer_artsBYtype_symbolism_mitem,
                customer_artsBYtype_renaissance_mitem,customer_artsBYtype_fauvism_mitem,customer_artsBYtype_postModern_mitem);
        
        
        
        customer_artsBYtype_maritime_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_artsBYtype_maritime_page_scene);
            }
        });
        
        customer_artsBYtype_symbolism_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_artsBYtype_symbolism_page_scene);
            }
        });
        
         customer_artsBYtype_renaissance_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_artsBYtype_renaissance_page_scene);
            }
        });
        
          customer_artsBYtype_fauvism_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_artsBYtype_fauvism_page_scene);
            }
        });
        
         customer_artsBYtype_postModern_mitem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //myStage.setScene(second_scene);
                myStage.setScene(customer_artsBYtype_postModern_page_scene);
            }
        });
        
         
         
         Button customer_artsBYtype_maritime_page_back_btn= new Button();
        customer_artsBYtype_maritime_page_back_btn.setLayoutX(scene_width-950);
        customer_artsBYtype_maritime_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsBYtype_maritime_page_back_btn.setText("BACK");
        customer_artsBYtype_maritime_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                //myStage.setScene();
               myStage.setScene(customer_query_scene);

                
            }
        });
        
         Button customer_artsBYtype_symbolism_page_back_btn= new Button();
        customer_artsBYtype_symbolism_page_back_btn.setLayoutX(scene_width-950);
        customer_artsBYtype_symbolism_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsBYtype_symbolism_page_back_btn.setText("BACK");
        customer_artsBYtype_symbolism_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
       
        
        Button customer_artsBYtype_renaissance_page_back_btn= new Button();
        customer_artsBYtype_renaissance_page_back_btn.setLayoutX(scene_width-950);
        customer_artsBYtype_renaissance_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsBYtype_renaissance_page_back_btn.setText("BACK");
        customer_artsBYtype_renaissance_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
         
        Button customer_artsBYtype_fauvism_page_back_btn= new Button();
        customer_artsBYtype_fauvism_page_back_btn.setLayoutX(scene_width-950);
        customer_artsBYtype_fauvism_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsBYtype_fauvism_page_back_btn.setText("BACK");
        customer_artsBYtype_fauvism_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
         
        Button customer_artsBYtype_postModern_page_back_btn= new Button();
        customer_artsBYtype_postModern_page_back_btn.setLayoutX(scene_width-950);
        customer_artsBYtype_postModern_page_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        customer_artsBYtype_postModern_page_back_btn.setText("BACK");
        customer_artsBYtype_postModern_page_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
               myStage.setScene(customer_query_scene);

                
            }
        });
        
        
        Button customer_query_page_logout_btn= new Button();
        customer_query_page_logout_btn.setLayoutX(scene_width-150);
        customer_query_page_logout_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_logout_btn.setGraphic(logout_btn_img);
        customer_query_page_logout_btn.setText("LOG OUT");
        customer_query_page_logout_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                customer_loginCheck_page_error_show.setText("");
                ID="";
                myStage.setScene(login_page_scene);
            }
        });
        
         Button customer_query_page_home_btn= new Button();
        customer_query_page_home_btn.setLayoutX(scene_width-950);
        customer_query_page_home_btn.setLayoutY(scene_height-820);
        //manager_edit_profile_page_home_btn.setGraphic(home_btn_img);
        customer_query_page_home_btn.setText("HOME");
        customer_query_page_home_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                myStage.setScene(customer_homepage_scene);
            }
        });

        
        
        
        
         Button guest_homepage_back_btn= new Button();
        guest_homepage_back_btn.setLayoutX(scene_width-950);
        guest_homepage_back_btn.setLayoutY(scene_height-800);
        //back_btn.setText("BACK");
        //manager_login_check_back_btn.setGraphic(back_btn_img);
        guest_homepage_back_btn.setText("BACK");
        guest_homepage_back_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
               
                //managerLoginCheck_class.username_txtf.setText("");
                //managerLoginCheck_class.password_txtf.setText("");
                myStage.setScene(first_scene);

                
            }
        });
        
        
        
        
        
        
        


        




       
        
        
        
        
 

       
  




       // second_grp.getChildren().addAll( Name2,insert_btn,query_btn  );

        //insert_grp.getChildren().addAll(table_select_txt,Customer_btn);
        
        customer_table_insert_from_manager_grp.getChildren().addAll(CustomerTableInsertFromManager_class.grp,Customer_table_insert_from_manager_ok_btn,
                customer_table_insert_page_from_manager_back_btn);
        
        customer_table_insert_from_employee_grp.getChildren().addAll(CustomerTableInsertFromEmployee_class.grp,Customer_table_insert_from_employee_ok_btn,
                customer_table_insert_page_from_employee_back_btn);
        
        artist_table_insert_from_manager_grp.getChildren().addAll(ArtistTableInsertFromManager_class.grp,artist_table_insert_from_manager_ok_btn,
                artist_table_insert_page_from_manager_back_btn);
        artist_table_insert_from_employee_grp.getChildren().addAll(ArtistTableInsertFromEmployee_class.grp,artist_table_insert_from_employee_ok_btn,
                artist_table_insert_page_from_employee_back_btn);
        
        art_table_insert_from_manager_grp.getChildren().addAll(ArtTableInsertFromManager_class.grp,art_table_insert_from_manager_ok_btn,
                art_table_insert_page_from_manager_back_btn);
        
        art_table_insert_from_employee_grp.getChildren().addAll(ArtTableInsertFromEmployee_class.grp,art_table_insert_from_employee_ok_btn,
                art_table_insert_page_from_employee_back_btn);
        
        employee_table_insert_from_manager_grp.getChildren().addAll(EmployeeTableInsertFromManager_class.grp,employee_table_insert_from_manager_ok_btn,
                employee_table_insert_page_from_manager_back_btn);
               
         exhibition_table_insert_from_manager_grp.getChildren().addAll(ExhibitionTableInsertFromManager_class.grp,exhibition_table_insert_from_manager_ok_btn,
                       exhibition_table_insert_from_manager_more_art_btn,exhibition_table_insert_page_from_manager_back_btn,
                       exhibition_table_insert_from_manager_more_exhibition_btn);
               
         exhibition_table_insert_from_employee_grp.getChildren().addAll(ExhibitionTableInsertFromEmployee_class.grp,exhibition_table_insert_from_employee_ok_btn,
                       exhibition_table_insert_from_employee_more_art_btn,exhibition_table_insert_page_from_employee_back_btn,
                       exhibition_table_insert_from_employee_more_exhibition_btn);
         
         exhibition_table_insert_from_manager_addartgrp.getChildren().addAll(ExhibitionTableInsertFromManager_addartclass.grp, exhibition_table_insert_from_manager_moreart_ok_btn,
                 exhibition_table_insert_page_from_manager_addart_back_btn,exhibition_table_insert_from_manager_more_page_more_art_btn);
               
          
         exhibition_table_insert_from_employee_addartgrp.getChildren().addAll(ExhibitionTableInsertFromEmployee_addartclass.grp,exhibition_table_insert_from_employee_moreart_ok_btn,
                 exhibition_table_insert_page_from_employee_addart_back_btn,exhibition_table_insert_from_employee_more_page_more_art_btn);
         
         hallroom_table_insert_from_manager_grp.getChildren().addAll(HallRoomTableInsertFromManager_class.grp,hallroom_table_insert_from_manager_ok_btn,
                  hallroom_table_insert_page_from_manager_back_btn);
        
      
        
        
        bill_table_insert_from_employee_grp.getChildren().addAll(billTableInsertFromEmployee_class.grp,bill_table_insert_page_from_employee_back_btn,
                bill_table_insert_from_employee_ok_btn);
        
        customer_table_show_from_manager_grp.getChildren().addAll(customer_table_show_txt,customer_table_show_page_from_manager_back_btn);


        //query_grp.getChildren().addAll(query_show);

        login_page_grp.getChildren().addAll(login_page_backgrnd_image, login_page_txt,login_page_manager_btn,login_page_employee_btn,login_page_artist_btn,
                login_page_Customer_btn,login_page_back_btn);
                     
        manager_login_check_grp.getChildren().addAll(managerLoginCheck_class.grp,manager_login_check_submit_btn,manager_login_check_back_btn,manager_loginCheck_page_error_show);
        
        manager_homepage_grp.getChildren().addAll(manager_homepage_insert_btn,manager_homepage_profile_btn,manager_homepage_showTables_btn,
                manager_homepage_query_btn,manager_homepage_logout_btn);
        manager_profile_grp.getChildren().addAll(managerProfile_class.grp,manager_profile_page_edit_profile_btn,manager_profile_page_home_btn,
                manager_profile_page_logout_btn);
        manager_edit_profile_grp.getChildren().addAll(managerEditProfile_class.grp,manager_edit_profile_page_home_btn,manager_edit_profile_page_logout_btn,
                manager_edit_profile_page_ok_btn);
        
        manager_insertTables_grp.getChildren().addAll(manager_insertTables_page_artist_btn,manager_insertTables_page_arts_btn,manager_insertTables_page_customer_btn,
                manager_insertTables_page_employee_btn,manager_insertTables_page_exhibition_btn,manager_insertTables_page_hallroom_btn,
                manager_insertTables_page_home_btn,manager_insertTables_page_logout_btn);
        
        manager_showTables_grp.getChildren().addAll(manager_showTables_page_art_btn,manager_showTables_page_artist_btn,manager_showTables_page_bill_btn,
                manager_showTables_page_customer_btn,manager_showTables_page_employee_btn,manager_showTables_page_exhitbition_btn,manager_showTables_page_hallroom_btn,
                manager_showTables_page_home_btn,manager_showTables_page_logout_btn,manager_showTables_page_manager_btn,
                manager_showTables_page_payslip_btn);
        
        manager_query_page_grp.getChildren().addAll(manager_query_page_employeeUnderMe_btn,manager_query_page_home_btn,manager_query_page_logout_btn,
                manager_query_page_artsOfartist_btn,manager_query_page_artStatus_btn,manager_query_page_informationOf_mbtn,
                manager_query_page_bill_from_date_btn);
        
        manager_artStatus_grp.getChildren().addAll(manager_art_status_page_art_id_txf,manager_art_status_page_art_id_txt,manager_art_status_page_back_btn,
                manager_art_status_page_ok_btn,manager_art_status_page_status_txt);
        
        manager_employeeInfo_grp.getChildren().addAll(one_employeeInfo_from_manager_class.grp,manager_employeeInfo_page_back_btn,manager_employeeInfo_page_ok_btn,
                manager_employeeInfo_page_txt,manager_employeeInfo_page_txtf);
        
         manager_customerInfo_grp.getChildren().addAll(one_customerInfo_from_manager_class.grp,manager_customerInfo_page_back_btn,manager_customerInfo_page_ok_btn,
                managerr_customerInfo_page_txt,managerr_customerInfo_page_txtf);
         
          manager_artistInfo_grp.getChildren().addAll(one_artistInfo_from_manager_class.grp,manager_artistInfo_page_back_btn,manager_artistInfo_page_ok_btn,
                managerr_artistInfo_page_txt,managerr_artistInfo_page_txtf);
          
           manager_artInfo_grp.getChildren().addAll(an_artInfo_from_manager_class.grp,manager_artInfo_page_back_btn,manager_artInfo_page_ok_btn,
                managerr_artInfo_page_txt,managerr_artInfo_page_txtf);
           
        manager_artsOfartist_grp.getChildren().addAll(manager_artOfartist_page_back_btn,manager_artOfartist_page_ok_btn,
                managerr_artOfartist_page_txt,managerr_artOfartist_page_txtf,managerr_artsOfartist_page_result_txt);
           
        manager_employeesUnderMe_grp.getChildren().addAll(employeeUnderM_txt,manager_employeesUnderMe_page_back_btn);
        
        manager_bill_from_date_grp.getChildren().addAll(manager_bill_from_date_page_from_txt,manager_bill_from_date_page_to_txt,
                manager_bill_from_date_page_from_txtf,manager_bill_from_date_page_to_txtf,manager_bill_from_date_result_txt,
                manager_bill_from_date_page_ok_btn,manager_bills_from_date_page_back_btn);
        
        
        
        employee_login_check_grp.getChildren().addAll(employeeLoginCheck_class.grp,employee_login_check_back_btn,employee_login_check_submit_btn,employee_loginCheck_page_error_show);
        
        employee_homepage_grp.getChildren().addAll(employee_homepage_profile_btn,employee_homepage_insert_btn,employee_homepage_query_btn,
                employee_homepage_logout_btn);
        employee_profile_grp.getChildren().addAll(employeeProfile_class.grp,employee_profile_page_edit_profile_btn,employee_profile_page_home_btn,
                employee_profile_page_logout_btn);
        
        employee_insertTables_grp.getChildren().addAll(employee_insertTables_page_artist_btn,employee_insertTables_page_arts_btn,employee_insertTables_page_bill_btn,
                employee_insertTables_page_customer_btn,employee_insertTables_page_exhibition_btn,employee_insertTables_page_home_btn,employee_insertTables_page_logout_btn,
                employee_insertTables_page_payslip_btn);
        
        employee_edit_profile_grp.getChildren().addAll(employeeEditProfile_class.grp,employee_edit_profile_page_home_btn,
                employee_edit_profile_page_logout_btn,employee_edit_profile_page_ok_btn);
        
        employee_query_page_grp.getChildren().addAll(employee_query_page_home_btn,employee_query_page_logout_btn,
                employee_query_page_artsOfartist_btn,employee_query_page_artStatus_btn,employee_query_page_informationOf_mbtn);
        
        employee_artStatus_grp.getChildren().addAll(employee_art_status_page_art_id_txf,employee_art_status_page_art_id_txt,employee_art_status_page_back_btn,
                employee_art_status_page_ok_btn,employee_art_status_page_status_txt);
       
        employee_customerInfo_grp.getChildren().addAll(one_customerInfo_from_employee_class.grp,employee_customerInfo_page_back_btn,employee_customerInfo_page_ok_btn,
                employee_customerInfo_page_txt,employee_customerInfo_page_txtf);
         
        employee_artistInfo_grp.getChildren().addAll(one_artistInfo_from_employee_class.grp,employee_artistInfo_page_back_btn,employee_artistInfo_page_ok_btn,
                employee_artistInfo_page_txt,employee_artistInfo_page_txtf);
          
        employee_artInfo_grp.getChildren().addAll(one_artInfo_from_employee_class.grp,employee_artInfo_page_back_btn,employee_artInfo_page_ok_btn,
                employee_artInfo_page_txt,employee_artInfo_page_txtf);
           
        employee_artsOfartist_grp.getChildren().addAll(employee_artOfartist_page_back_btn,employee_artOfartist_page_ok_btn,
                employee_artOfartist_page_txt,employee_artOfartist_page_txtf,employee_artsOfartist_page_result_txt);
           

        
        
        
        
        
        artist_login_check_grp.getChildren().addAll(artistLoginCheck_class.grp,artist_login_check_back_btn,artist_login_check_submit_btn,
                artist_loginCheck_page_error_show);
        artist_homepage_grp.getChildren().addAll(artist_homepage_logout_btn,artist_homepage_profile_btn,artist_homepage_query_btn);
                
        artist_profile_grp.getChildren().addAll(artistProfile_class.grp,artist_profile_page_editProfile_btn,artist_profile_page_home_btn,artist_profile_page_logout_btn);
        artist_edit_profile_grp.getChildren().addAll(artistEditProfile_class.grp,artist_edit_profile_page_home_btn,artist_edit_profile_page_logout_btn,
                artist_edit_profile_page_ok_btn);
        
        artist_query_grp.getChildren().addAll(artist_query_page_payslip_btn,artist_query_page_exhibition_mbtn,artist_query_page_artsBYprice_mbtn,artist_query_page_artsBYtype_mbtn,
                artist_query_page_artsOfartist_btn,artist_query_page_home_btn,artist_query_page_logout_btn);
        
        artist_current_exhibitions_page_grp.getChildren().addAll(artist_current_exhi_page_back_btn,artist_current_exhi_page_result_txt);
        
        artist_past_exhibitions_page_grp.getChildren().addAll(artist_past_exhi_page_back_btn,artist_past_exhi_page_result_txt);
        
        artist_upcoming_exhibitions_page_grp.getChildren().addAll(artist_upcoming_exhi_page_back_btn,artist_upcoming_exhi_page_result_txt);
        
        artist_payslip_page_grp.getChildren().addAll(artist_payslip_page_back_btn,artist_payslip_page_result_txt);
        
        artist_artsOfartist_page_grp.getChildren().addAll(artist_artsOfartist_page_back_btn,artist_artsOfartist_page_result_txt,
                artist_artOfartist_page_txt,artist_artOfartist_page_txtf,artist_artOfartist_page_ok_btn);
        
        artist_artsBYprice_upto2k_page_grp.getChildren().addAll(artist_artsBYprice_upto2k_page_back_btn,artist_artsBYprice_upto2k_page_result_txt);
        
        artist_artsBYprice_2kto5k_page_grp.getChildren().addAll(artist_artsBYprice_2kto5k_page_back_btn,artist_artsBYprice_2kto5k_page_result_txt);
        
        artist_artsBYprice_above5k_page_grp.getChildren().addAll(artist_artsBYprice_above5k_page_back_btn,artist_artsBYprice_above5k_page_result_txt);
        
        artist_artsBYtype_maritime_page_grp.getChildren().addAll(artist_artsBYtype_maritime_page_back_btn,artist_artsBYtype_maritime_page_result_txt);
        
        artist_artsBYtype_symbolism_page_grp.getChildren().addAll(artist_artsBYtype_symbolism_page_back_btn,artist_artsBYtype_symbolism_page_result_txt);
        
        artist_artsBYtype_renaissance_page_grp.getChildren().addAll(artist_artsBYtype_renaissance_page_back_btn,artist_artsBYtype_renaissance_page_result_txt);
        
        artist_artsBYtype_fauvism_page_grp.getChildren().addAll(artist_artsBYtype_fauvism_page_back_btn,artist_artsBYtype_fauvism_page_result_txt);
        
        artist_artsBYtype_postModern_page_grp.getChildren().addAll(artist_artsBYtype_postModern_page_back_btn,artist_artsBYtype_postModern_page_result_txt);
        
        
        
        
        
        customer_login_check_grp.getChildren().addAll(customerLoginCheck_class.grp,customer_login_check_back_btn,customer_login_check_submit_btn,
                customer_loginCheck_page_error_show);
        customer_homepage_grp.getChildren().addAll(customer_homepage_logout_btn,customer_homepage_profile_btn,customer_homepage_query_btn);
        customer_profile_grp.getChildren().addAll(customerProfile_class.grp,customer_profile_page_editProfile_btn,customer_profile_page_home_btn,customer_profile_page_logout_btn);
        customer_edit_profile_grp.getChildren().addAll(customerEditProfile_class.grp,customer_edit_profile_page_home_btn,customer_edit_profile_page_logout_btn,
                customer_edit_profile_page_ok_btn);
        customer_query_grp.getChildren().addAll(customer_query_page_bill_btn,customer_query_page_exhibition_mbtn,customer_query_page_artsBYprice_mbtn,customer_query_page_artsBYtype_mbtn,
                customer_query_page_artsOfartist_btn,customer_query_page_home_btn,customer_query_page_logout_btn);
        
        //artist_payslip_page_grp.getChildren().addAll(artist_payslip_page_back_btn);
        customer_current_exhibitions_page_grp.getChildren().addAll(customer_current_exhi_page_back_btn,customer_current_exhi_page_result_txt);
        
        customer_past_exhibitions_page_grp.getChildren().addAll(customer_past_exhi_page_back_btn,customer_past_exhi_page_result_txt);
        
        customer_upcoming_exhibitions_page_grp.getChildren().addAll(customer_upcoming_exhi_page_back_btn,customer_upcoming_exhi_page_result_txt);
        
        customer_bill_page_grp.getChildren().addAll(customer_bill_page_back_btn,customer_bill_page_result_txt);
        
        customer_artsOfartist_page_grp.getChildren().addAll(customer_artsOfartist_page_back_btn,customer_artOfartist_page_txt,
                customer_artOfartist_page_txtf,customer_artsOfartist_page_result_txt,customer_artOfartist_page_ok_btn);
        
        customer_artsBYprice_upto2k_page_grp.getChildren().addAll(customer_artsBYprice_upto2k_page_back_btn,customer_artsBYprice_upto2k_page_result_txt);
        
        customer_artsBYprice_2kto5k_page_grp.getChildren().addAll(customer_artsBYprice_2kto5k_page_back_btn,customer_artsBYprice_2kto5k_page_result_txt);
        
        customer_artsBYprice_above5k_page_grp.getChildren().addAll(customer_artsBYprice_above5k_page_back_btn,customer_artsBYprice_above5k_page_result_txt);
        
        customer_artsBYtype_maritime_page_grp.getChildren().addAll(customer_artsBYtype_maritime_page_back_btn,customer_artsBYtype_maritime_page_result_txt);
        
        customer_artsBYtype_symbolism_page_grp.getChildren().addAll(customer_artsBYtype_symbolism_page_back_btn,customer_artsBYtype_symbolism_page_result_txt);
        
        customer_artsBYtype_renaissance_page_grp.getChildren().addAll(customer_artsBYtype_renaissance_page_back_btn,customer_artsBYtype_renaissance_page_result_txt);
        
        customer_artsBYtype_fauvism_page_grp.getChildren().addAll(customer_artsBYtype_fauvism_page_back_btn,customer_artsBYtype_fauvism_page_result_txt);
        
        customer_artsBYtype_postModern_page_grp.getChildren().addAll(customer_artsBYtype_postModern_page_back_btn,customer_artsBYtype_postModern_page_result_txt);
        
        
        
        
        
        guest_homepage_grp.getChildren().addAll(guest_homepage_back_btn,guest_homepage_explore_mbtn);
        
        guest_current_exhibitions_page_grp.getChildren().addAll(guest_current_exhi_page_back_btn,guest_current_exhi_page_result_txt);
        
        guest_upcoming_exhibitions_page_grp.getChildren().addAll(guest_upcoming_exhi_page_back_btn,guest_upcoming_exhi_page_result_txt);
        
        guest_past_exhibitions_page_grp.getChildren().addAll(guest_past_exhi_page_back_btn,guest_past_exhi_page_result_txt);


        
        
        
        myStage.setTitle("JOYNUL ART GALLERY ");


        myStage.setScene(first_scene);
        first_grp.getChildren().addAll(front_image,Name,log_in_btn,guest_access_btn);
        myStage.show();
        


    }

    /**
     * @param args the command line arguments
     */

}  