import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class RailwayUserRegisterAndLoginView{
    static DatabaseController dbConnect=new DatabaseController();
   public static JButton Register;
   public static JButton Login;
    public static void homeScreen(){
        JFrame home=new JFrame("Register and Login");
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Register =new JButton("Register");
        Register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				home.setVisible(false);
				RegisterScreen();
			}
		}) ;
        Login =new JButton("Login");
        Login.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                home.setVisible(false);
				LoginScreen();
                
            }
            
        });
        home.setBounds(1000,200,400,400);
        Register.setBounds(100, 100, 200, 30);
        Login.setBounds(100, 200, 200, 30);
        home.setLayout(null);
        home.setVisible(true);
        home.add(Register);
        home.add(Login);
     
    }
    public static void setRegisterText(JTextField name,JTextField mail,JTextField password,JTextField mobile){
        name.setText("VISHAL");
        mail.setText("example@domain.com");
        password.setText("1111");
        mobile.setText("9876543210");
    }
    public static void setLoginText(JTextField mail,JTextField password){
        
        mail.setText("example@domain.com");
        password.setText("1111");
    }
    public static void RegisterScreen(){
        JFrame Register=new JFrame("Register");
        Register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton Submit =new JButton("Submit");
        Register.setBounds(1000,200,400,400);
        JLabel nameLabel=new JLabel("Name");
        JLabel mobileLabel=new JLabel("Mobile");
        JLabel mailLabel=new JLabel("Mail Id");
        JLabel passwordLabel=new JLabel("Password");
       
        JTextField Name =new JTextField(20);
        JTextField Mobile =new JTextField(10);
        JTextField Mail =new JTextField(30);
        JPasswordField Password =new JPasswordField(20);
        setRegisterText(Name,Mail,Password,Mobile);
        nameLabel.setBounds(50, 20, 100, 20);
        mobileLabel.setBounds(50, 50, 100, 20);
        mailLabel.setBounds(50, 80, 100, 20);
        passwordLabel.setBounds(50, 110, 100, 20);
        Name.setBounds(150, 20, 130, 20);
        Mobile.setBounds(150, 50, 130, 20);
        Mail.setBounds(150, 80, 130, 20);
        Password.setBounds(150, 110, 130, 20);
        Submit.setBounds(150, 130, 100, 35);
        Register.add(nameLabel);
        Register.add(mobileLabel);
        Register.add(mailLabel);
        Register.add(passwordLabel);
        Register.add(Name);
        Register.add(Mobile);
        Register.add(Mail);
        Register.add(Password);
        Register.add(Submit);
        Register.setLayout(null);
        Register.setVisible(true);
        Submit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              Profile registerUser=new Profile(Name.getText(),Mobile.getText(),Mail.getText(),Password.getText());
              if(Name.getText().isEmpty() || Mail.getText().isEmpty() || Password.getText().isEmpty())
              {JOptionPane.showMessageDialog(Register,"Enter Fields",
                "Insufficient Data", JOptionPane.WARNING_MESSAGE);}
             else if(!dbConnect.postData(registerUser)){
                JOptionPane.showMessageDialog(Register,"MailID already exists",
                "Error", JOptionPane.WARNING_MESSAGE);
             }else{
                JOptionPane.showMessageDialog(Register,"Registered Successfully",
                "Success", JOptionPane.WARNING_MESSAGE);
             }
                
            }});


    } 
    public static void LoginScreen(){
        JFrame Login=new JFrame("Login");
        Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton Submit =new JButton("Submit");
        Login.setBounds(1000,200,400,400);
       
        

        JTextField Mail =new JTextField(30);
        JTextField Password =new JPasswordField(20);
        
        setLoginText(Mail,Password);
        JLabel mailLabel=new JLabel("Mail Id");
        JLabel passwordLabel=new JLabel("Password");
        
        mailLabel.setBounds(50, 20, 100, 20);
        passwordLabel.setBounds(50, 50, 100, 20);

        Submit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              Profile loginUser=new Profile();
              loginUser.setMailId(Mail.getText());
              loginUser.setPassword(Password.getText());
              if(dbConnect.checkLogin(loginUser)){
                JOptionPane.showMessageDialog(Login,"Logged in Successfully!",
                "Success", JOptionPane.WARNING_MESSAGE);
              }else{
                JOptionPane.showMessageDialog(Login,"Wrong MailID or Password",
                "Error", JOptionPane.WARNING_MESSAGE);
                
              }
                
            }});

        Mail.setBounds(150, 20, 130, 20);
        Password.setBounds(150, 50, 130, 20);
        Submit.setBounds(150, 80, 130, 20);
        Login.add(mailLabel);
        Login.add(passwordLabel);
        Login.add(Mail);
        Login.add(Password);
        Login.add(Submit);
        Login.setLayout(null);
        Login.setVisible(true);

    }
    
}
