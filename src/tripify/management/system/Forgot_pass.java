package tripify.management.system;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.sql.*;

public class Forgot_pass extends JFrame implements ActionListener{
    
    JTextField tfusername, tfname, tfsecurity, tfanswer, tfpassword;
    JButton Search, Retrieve, Back;
    
    Forgot_pass(){
        setSize(800,400);
        setLocation(370,200);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JPanel panel=new JPanel();
       // panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0,0,500,400);
        panel.setLayout(null);
        add(panel);
        
        JLabel labelusername= new JLabel("Username");
        labelusername.setBounds(50,40,200,25);
        labelusername.setFont(new Font("SAN SERIF", Font.PLAIN, 17 ));
        panel.add(labelusername);
 
        tfusername= new JTextField();
        tfusername.setBounds(160,40,200,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfusername);
        
        Search= new JButton("Search");
        Search.setBounds(380,40,100,25);
        Search.setBorder(BorderFactory.createEmptyBorder());
        Search.setBorder(new LineBorder(new Color(255,255,255)));
        Search.setFont(new Font("SAN SERIF", Font.PLAIN, 15 ));
        //create.addActionListener(this);
        Search.addActionListener(this);
        panel.add(Search);
        
        JLabel labelname= new JLabel("Name");
        labelname.setBounds(50,80,200,25);
        labelname.setFont(new Font("SAN SERIF", Font.PLAIN, 17));
        panel.add(labelname);
       
        tfname= new JTextField();
        tfname.setBounds(160,80,200,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfname);
        
        JLabel labelsecurity= new JLabel("Security Ques");
        labelsecurity.setBounds(50,120,200,25);
        labelsecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 17));
        panel.add(labelsecurity);
       
        tfsecurity= new JTextField();
        tfsecurity.setBounds(160,120,200,25);
        tfsecurity.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfsecurity);
        
        JLabel labelanswer= new JLabel("Answer");
        labelanswer.setBounds(50,160,200,25);
        labelanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 17));
        panel.add(labelanswer);
       
        tfanswer= new JTextField();
        tfanswer.setBounds(160,160,200,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfanswer);
        
        Retrieve= new JButton("Retrieve");
        Retrieve.setBounds(380,160,100,25);
        Retrieve.setBorder(BorderFactory.createEmptyBorder());
        Retrieve.setBorder(new LineBorder(new Color(255,255,255)));
        Retrieve.setFont(new Font("SAN SERIF", Font.PLAIN, 15 ));
        //create.addActionListener(this);
        Retrieve.addActionListener(this);
        panel.add(Retrieve);
        
        JLabel labelpassword= new JLabel("Password");
        labelpassword.setBounds(50,200,200,25);
        labelpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 17));
        panel.add(labelpassword);
       
        tfpassword= new JTextField();
        tfpassword.setBounds(160,200,200,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfpassword);
        
        Back= new JButton("Back");
        Back.setBounds(200,250,120,30);
        Back.setBorder(BorderFactory.createEmptyBorder());
        Back.setBorder(new LineBorder(new Color(255,255,255)));
        Back.setFont(new Font("SAN SERIF", Font.PLAIN, 20 ));
        //create.addActionListener(this);
        Back.addActionListener(this);
        panel.add(Back);
        
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(400,0,400,500);
        add(panel1);
        
        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("images/pass.png"));
        Image img2 = img1.getImage().getScaledInstance(300, 360, Image.SCALE_DEFAULT);
        ImageIcon img3 =new ImageIcon(img2);
        JLabel image =  new JLabel(img3);
        image.setBackground(white);
        image.setBounds(0,0,500,360);
        panel1.add(image);
        setVisible(true);
    }
    public static void main(String []args){
        new Forgot_pass();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Search){
            try{
                String query = "select *from data where username ='"+tfusername.getText()+"'";
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfsecurity.setText(rs.getString("security"));
                }
            }
            catch(Exception ae ){
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==Retrieve){
            try{
                String query = "select *from data where answer ='"+tfanswer.getText()+"' AND username  ='"+tfusername.getText()+"'";
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                   // tfsecurity.setText(rs.getString("security"));
                }
            }
            catch(Exception ae ){
                ae.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Login();  
        }
    
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 
}
