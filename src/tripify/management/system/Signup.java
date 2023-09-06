package tripify.management.system;
import java.awt.Choice;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener{
    
    JButton create,back; //globally define
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;
    public Signup(JButton create) throws HeadlessException {
        this.create = create;
    }
    Signup(){
//        setBounds(350,200,900,360);
        setSize(1000,400);
        setLocation(260,160);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JPanel panel=new JPanel();
       // panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0,0,600,500);
        panel.setLayout(null);
        add(panel);
        
        JLabel labelusername= new JLabel("Username");
        labelusername.setBounds(50,40,200,25);
        labelusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20 ));
        panel.add(labelusername);
 
        tfusername= new JTextField();
        tfusername.setBounds(250,40,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfusername);
        
        JLabel labelname= new JLabel("Name");
        labelname.setBounds(50,80,200,25);
        labelname.setFont(new Font("SAN SERIF", Font.PLAIN, 20 ));
        panel.add(labelname);
       
        tfname= new JTextField();
        tfname.setBounds(250,80,300,30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfname);
        
        JLabel labelpass= new JLabel("Password");
        labelpass.setBounds(50,120,200,25);
        labelpass.setFont(new Font("SAN SERIF", Font.PLAIN, 20 ));
        panel.add(labelpass);
       
        tfpassword= new JTextField();
        tfpassword.setBounds(250,120,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfpassword);
        
        JLabel labelsecurity= new JLabel("Security Question");
        labelsecurity.setBounds(50,160,200,25);
        labelsecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 20 ));
        panel.add(labelsecurity);
        
        security= new Choice();
        security.add("your favt sport?");
        security.add("your favt song?");
        security.add("your pet name?");
        security.add("your favt person?");
        security.setBounds(250,160,200,25);
        panel.add(security);
        
        JLabel labelanswer= new JLabel("Answer");
        labelanswer.setBounds(50,200,200,25);
        labelanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 20 ));
        panel.add(labelanswer);
       
        tfanswer= new JTextField();
        tfanswer.setBounds(250,200,300,30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tfanswer);
        
        create= new JButton("Create");
        create.setBounds(80,270,150,50);
        create.setBorder(BorderFactory.createEmptyBorder());
        create.setBorder(new LineBorder(new Color(255,255,255)));
        create.setFont(new Font("SAN SERIF", Font.PLAIN, 15 ));
        create.addActionListener(this);
        panel.add(create);
        
        back= new JButton("Back");
        back.setBounds(280,270,150,50);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBorder(new LineBorder(new Color(255,255,255)));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 15 ));
        back.addActionListener(this);
        panel.add(back);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(400,0,600,500);
        add(panel1);
        
        ImageIcon img7= new ImageIcon(ClassLoader.getSystemResource("images/user.jpg"));
        Image img8 = img7.getImage().getScaledInstance(350, 360, Image.SCALE_DEFAULT);
        ImageIcon img9 =new ImageIcon(img8);
        JLabel image =  new JLabel(img9);
        image.setBackground(white);
        image.setBounds(0,0,830,360);
        panel1.add(image);
        
        setVisible(true);
    }
    
  public static void main(String[]args ){
      new Signup();
  }  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){
            String username= tfusername.getText();
            String name= tfname.getText();
            String password= tfpassword.getText();
            String question= security.getSelectedItem();
            String answer= tfanswer.getText();

            String query = "insert into data values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Connect c = new Connect();
                c.s.executeUpdate(query);
                //4.executing mysqlquery
                JOptionPane.showMessageDialog(null, "Account created successfully");
                setVisible(false);
                new Login();
            }
            catch(Exception ae ){
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new Login();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
