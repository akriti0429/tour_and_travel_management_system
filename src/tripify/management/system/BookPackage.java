package tripify.management.system;

import java.awt.Choice;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*; 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BookPackage extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField tftravlers;
    JLabel labelusername,labelid, labelnumber,labelprice,labelphone;
    String username;
    JButton checkprice,bookpackage,back;
    
    BookPackage(String username){
        this.username = username;
        setBounds(350,160,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
       
        JLabel profile= new JLabel("BOOK PACKAGE");
        profile.setBounds(100, 10,500,50);
        profile.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(profile);
        
        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(30, 70,150,40);
        lblusername.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(200, 70,150,30);
        labelusername.setFont(new Font("TAHOMA", Font.PLAIN, 14));
        add(labelusername);
        
        JLabel lbpackage= new JLabel("Select Package");
        lbpackage.setBounds(30, 110,150,40);
        lbpackage.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        add(lbpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold");
        cpackage.add("Silver");
        cpackage.add("Bronze");
        cpackage.setBounds(200,120,150,40);
        cpackage.setBackground(Color.white);
        add(cpackage);
        
        JLabel lbltravlers= new JLabel("Total Travlers");
        lbltravlers.setBounds(30, 150,150,40);
        lbltravlers.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        add(lbltravlers);
        
        tftravlers = new JTextField ();
        tftravlers.setBounds(200, 160,150,25);
        tftravlers.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        add(tftravlers);
        
        JLabel lblid= new JLabel("Id");
        lblid.setBounds(30, 190,150,40);
        lblid.setFont(new Font("SAN SERIF", Font.PLAIN, 17));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(200,190,150,30);
        labelid.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        add(labelid);
        
        JLabel lblno= new JLabel("Number");
        lblno.setBounds(30, 230,150,40);
        lblno.setFont(new Font("SAN SERIF", Font.PLAIN, 17));
        add(lblno);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(200,230,150,30);
        labelnumber.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        add(labelnumber);
        
        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(30, 270,150,40);
        lblphone.setFont(new Font("SAN SERIF",Font.PLAIN, 17));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(200,270,150,30);
        labelphone.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        add(labelphone);
        
        JLabel lblprice= new JLabel("Total Price");
        lblprice.setBounds(30, 310,150,40);
        lblprice.setFont(new Font("SAN SERIF", Font.PLAIN, 17));
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setBounds(200,310,150,30);
        labelprice.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelprice);
        
        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("images/bookpackage.jpg"));
        Image img2 = img1.getImage().getScaledInstance(450, 600, Image.SCALE_DEFAULT);
        ImageIcon img3 =new ImageIcon(img2);
        JLabel image =  new JLabel(img3);
        image.setBackground(white);
        image.setBounds(180,0,880,600);
        add(image);
        
        try{
            Connect c = new Connect();
            String query = "select * from profile where username = '"+username+"'" ;
            ResultSet rs = c.s.executeQuery(query ); 
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid .setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone")); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        checkprice= new JButton("Check Price");
        checkprice.setBounds(50,390,150,35);
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setFont(new Font("SAN SERIF", Font.PLAIN, 15 ));
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage= new JButton("Book Package");
        bookpackage.setBounds(230,390,150,35);
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setFont(new Font("SAN SERIF", Font.PLAIN, 15 ));
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back= new JButton("Back");
        back.setBounds(180,450,100,35);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 15 ));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    public static void main(String[]args){
        new BookPackage("tanvikaushik0808");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== checkprice){
            String pack = cpackage.getSelectedItem();
            int cost=0;
            if (pack.equals("Gold Package")){
                cost+=12000;
            }else if (pack.equals("Silver Package")){
                cost+=25000;
            }else{
                cost+=32000;
            }
            int travlers = Integer.parseInt(tftravlers.getText());
            cost*=travlers;
            labelprice.setText("Rs"+cost);
        }else if(e.getSource()== bookpackage){
            try{
                Connect c = new Connect();
                c.s.executeUpdate("insert into book_package values ('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tftravlers.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked successfully");
                setVisible(false);
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }else{
             setVisible(false);
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}