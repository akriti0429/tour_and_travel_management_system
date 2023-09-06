
package tripify.management.system;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewProfile extends JFrame implements ActionListener{
    JLabel labelusername, labelname, labelid,labelnumber,labelgender,labelcountry,labeladdress,labelphone,labelemail;
    JButton back;
    ViewProfile(String username){
        setBounds(350,160,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
       
        JLabel profile= new JLabel("VIEW DETAILS");
        profile.setBounds(300, 10,500,50);
        profile.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(profile);
        
        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(30, 80,150,40);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(200, 80,150,30);
        labelusername.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelusername);
        
        JLabel lblid= new JLabel("Id");
        lblid.setBounds(30, 140,150,40);
        lblid.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(200, 140,150,30);
        labelid.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelid);
        
        JLabel lblnumber= new JLabel("Number");
        lblnumber.setBounds(30, 200,150,40);
        lblnumber.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(200, 200,150,30);
        labelnumber.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelnumber);
        
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(30, 260,150,40);
        lblname.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(200,260,150,30);
        labelname.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelname);
        
        JLabel lblgender= new JLabel("Gender");
        lblgender.setBounds(30, 320,150,30);
        lblgender.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(200,320,150,30);
        labelgender.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelgender);
       
        JLabel lblcountry= new JLabel("Country");
        lblcountry.setBounds(470, 80,150,40);
        lblcountry.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblcountry);
        
        labelcountry = new JLabel();
        labelcountry.setBounds(640, 80,150,30);
        labelcountry.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelcountry);
        
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(470, 140,150,40);
        lbladdress.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lbladdress);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(640, 140,150,30);
        labeladdress.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labeladdress);
        
        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(470, 200,150,40);
        lblphone.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(640, 200,150,30);
        labelphone.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelphone);
        
        JLabel lblemail= new JLabel("Email");
        lblemail.setBounds(470, 260,150,40);
        lblemail.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblemail);
        
        labelemail = new JLabel();
        labelemail.setBounds(640, 260,150,30);
        labelemail.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelemail);
        
        back= new JButton("Back");
        back.setBounds(370,350,100,35);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 20 ));
        back.addActionListener(this);
        add(back);
        
        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("images/view15.jpg"));
        Image img2 = img1.getImage().getScaledInstance(850, 530, Image.SCALE_DEFAULT);
        ImageIcon img3 =new ImageIcon(img2);
        JLabel image =  new JLabel(img3);
        image.setBackground(white);
        image.setBounds(0,0,850,850);
        add(image);
        
        try{
            Connect c = new Connect();
            String query = "select * from profile where username = '"+username+"'" ;
            ResultSet rs = c.s.executeQuery(query ); 
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid .setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labelphone.setText(rs.getString("phone"));
                labeladdress.setText(rs.getString("address"));
                labelemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
        
    }
    
    public static void main(String []args){
        new ViewProfile("tanvikaushik0808");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
