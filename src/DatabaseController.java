import java.sql.*;

public class DatabaseController {
    String DATABASE_URL = "jdbc:mariadb://localhost:3306/stjoseph";
    String DATABASE_USERNAME = "root";
    String DATABASE_PASSWORD = "20000000";
    static Connection appConnection;
    DatabaseController(){
        try {appConnection=DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME,DATABASE_PASSWORD);}
        
    catch(Exception e){System.out.println(e);};
    }

    public static Boolean postData(Profile registerUser){
        String mailId=registerUser.getMailId();
        String mobile=registerUser.getMobile();
        String name=registerUser.getName();
        String password=registerUser.getPassword();
        String query="insert into railway_passenger(passenger_name,passenger_mobile_number,passenger_mail_id,passenger_password) values('"+name+"','"+mobile+"','"+mailId+"','"+password+"');";
        String queryCheck="select * from railway_passenger where passenger_mail_id='"+mailId+"';";
        try {
            Statement postStatement=appConnection.createStatement();
            postStatement.execute(queryCheck);
            if(postStatement.getResultSet().first()){
                return false;
            }else
            postStatement.execute(query);
        } catch (Exception e) {
           System.out.println(e);
        }
        
        System.out.println("Success");
        return true;
    }

    public static Boolean checkLogin(Profile loginUser){
        String mail=loginUser.getMailId();
        String password=loginUser.getPassword();
        String query="select * from railway_passenger where passenger_mail_id='"+mail+"' and passenger_password='"+password+"';";
        try {
            Statement checkStatement=appConnection.createStatement();
            checkStatement.execute(query);
            return checkStatement.getResultSet().first();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
