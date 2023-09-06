package tripify.management.system;

import java.awt.Choice;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.sql.*;
import javax.swing.JOptionPane;


public class AddProfile extends JFrame implements ActionListener{
    
    JLabel labelusername, labelname;
    Choice idprooof;
    JTextField tfnumber, tfcountry,tfaddress,tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton add,back;
    
    AddProfile(String username){
        setBounds(350,160,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel profile= new JLabel("USER PROFILE");
        profile.setBounds(120, 8,500,50);
        profile.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(profile);
        
        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(30, 50,150,40);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50,150,30);
        add(labelusername);
        
        JLabel lbid = new JLabel("ID");
        lbid.setBounds(30, 90,150,30);
        lbid.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(lbid);
        
        idprooof = new Choice();
        idprooof.add("Passport");
        idprooof.add("Adhar Card");
        idprooof.add("Pan Card");
        idprooof.add("Ration Card");
        idprooof.setBounds(220,90,150,30);
        idprooof.setBackground(Color.white);
        add(idprooof);
        
        JLabel lblnumber= new JLabel("Number");
        lblnumber.setBounds(30, 130,150,30);
        lblnumber.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130,150,30);
        add(tfnumber);
        
        JLabel name= new JLabel("Name");
        name.setBounds(30, 170,150,30);
        name.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(name);
        
        labelname = new JLabel();
        labelname.setBounds(220, 170,150,30);
        add(labelname);
        
        JLabel gender= new JLabel("Gender");
        gender.setBounds(30, 210,150,30);
        gender.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(gender);
        
        rmale =  new JRadioButton("Male");
        rmale.setBounds(220,210,70,30);
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale =  new JRadioButton("Female");
        rfemale.setBounds(300,210,70,30);
        rfemale.setBackground(Color.white);
        add(rfemale);
       
        ButtonGroup bg =new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel country= new JLabel("Country");
        country.setBounds(30, 250,150,30);
        country.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(country);
         
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250,150,30);
        add(tfcountry);
        
        JLabel address= new JLabel("Address");
        address.setBounds(30, 290,150,30);
        address.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(address);
         
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290,150,30);
        add(tfaddress);
        
        JLabel email= new JLabel("Email");
        email.setBounds(30, 330,150,30);
        email.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(email);
         
        tfemail= new JTextField();
        tfemail.setBounds(220, 330,150,30);
        add(tfemail);
        
        JLabel phone= new JLabel("Phone No");
        phone.setBounds(30, 370,150,30);
        phone.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        add(phone);
         
        tfphone = new JTextField();
        tfphone.setBounds(220, 370,150,30);
        add(tfphone);
        
        add= new JButton("Add");
        add.setBounds(60,420,100,35);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        add.addActionListener(this);
        add(add);
        
        back= new JButton("Back");
        back.setBounds(230,420,100,35);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 15 ));
        back.addActionListener(this);
        add(back);
        
        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("images/addprofile.jpg"));
        Image img2 = img1.getImage().getScaledInstance(300, 460, Image.SCALE_DEFAULT);
        ImageIcon img3 =new ImageIcon(img2);
        JLabel image =  new JLabel(img3);
        image.setBackground(white);
        image.setBounds(200,5,830,500);
        add(image);
        
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from data where username= '"+username+ "'"); 
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    
    }
    
    public static void main(String[]args){
         new AddProfile("tanvikaushik0808");
                 
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String username= labelusername.getText();
            String id= (String) idprooof.getSelectedItem();
            String number= tfnumber.getText();
            String name= labelname.getText();
            String gender= null;
            if(rmale.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            String country= tfcountry.getText();
            String address= tfaddress.getText();
            String phone= tfphone.getText();
            String email= tfemail.getText();
            
            try{
                Connect c =new Connect();
                String query = "insert into profile values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                c.s.execute(query);
                JOptionPane.showMessageDialog(null,"Details saved successfully");
                setVisible(false);
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }else{
            setVisible(false);
    }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
