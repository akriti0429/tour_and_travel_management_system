package tripify.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton signup,login,forgotpass;
    JTextField tfusername, tfpassword;
    
    Login(){
        setSize(1000,500);
        setLocation(260,160);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JPanel panel=new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0,0,400,600);
        panel.setLayout(null);
        add(panel);
        
        ImageIcon img4= new ImageIcon(ClassLoader.getSystemResource("images/log1.jpg"));
        Image img5 = img4.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon img6 =new ImageIcon(img5);
        JLabel image =  new JLabel(img6);
        image.setBounds(0,0,400,480);
        panel.add(image);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(400,30,600,400);
        add(panel1);
        
        JLabel labelusername= new JLabel("Username");
        labelusername.setBounds(60,40,200,25);
        labelusername.setFont(new Font("SAN SERIF", Font.PLAIN, 30 ));
        panel1.add(labelusername);
         
        tfusername= new JTextField();
        tfusername.setBounds(60,80,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(tfusername);
        
        JLabel labelpass= new JLabel("Password");
        labelpass.setBounds(60,130,200,25);
        labelpass.setFont(new Font("SAN SERIF", Font.PLAIN, 30 ));
        panel1.add(labelpass);
               
        tfpassword= new JTextField();
        tfpassword.setBounds(60,170,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(tfpassword);
        
        login= new JButton("LOGIN");
        login.setBounds(60,250,140,40);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setBorder(new LineBorder(new Color(255,255,255)));
        login.addActionListener(this);
        panel1.add(login);
        
        signup= new JButton("SIGN UP");
        signup.setBounds(230,250,140,40);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.setBorder(new LineBorder(new Color(255,255,255)));
        signup.addActionListener(this);
        panel1.add(signup);
        
        forgotpass= new JButton("Forgot Password");
        forgotpass.setBounds(400,250,140,40);
        forgotpass.setBorder(BorderFactory.createEmptyBorder());
        forgotpass.setBorder(new LineBorder(new Color(255,255,255)));
        forgotpass.addActionListener(this);
        panel1.add(forgotpass);
        
        setVisible(true);

    }
    public static void main(String[]args){
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try{
                String username =  tfusername.getText();
                String password =  tfpassword.getText();
                
                String query ="select * from data where username ='"+username+"' AND password = '"+password+"'";
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==signup){ 
            setVisible(false);
            new Signup();
        
        }
        else{
            setVisible(false);
            new Forgot_pass();
                
        }  
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
