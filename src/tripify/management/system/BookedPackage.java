
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

public class BookedPackage extends JFrame implements ActionListener{
    JLabel labelusername,labelpackage, labeltravlers, labelid,labelnumber,labelphone,labelprice;
    JButton back;
    BookedPackage(String username){
        setBounds(350,160,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
       
        JLabel profile= new JLabel("BOOKED DETAILS");
        profile.setBounds(100, 10,500,50);
        profile.setFont(new Font("Tahoma", Font.BOLD, 30));
        profile.setForeground(Color.blue);
        add(profile);
        
        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(30, 80,150,40);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(200, 80,150,30);
        labelusername.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelusername);
        
        JLabel lblpackage= new JLabel("Package");
        lblpackage.setBounds(30, 120,150,40);
        lblpackage.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblpackage);
        
        labelpackage = new JLabel();
        labelpackage.setBounds(200, 120,150,30);
        labelpackage.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelpackage);
        
        JLabel lbltravlers= new JLabel("Travlers");
        lbltravlers.setBounds(30, 160,150,40);
        lbltravlers.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lbltravlers);
        
        labeltravlers = new JLabel();
        labeltravlers.setBounds(200, 160,150,30);
        labeltravlers.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labeltravlers);
        
        JLabel lblid= new JLabel("Id");
        lblid.setBounds(30, 200,200,40);
        lblid.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(200,200,150,30);
        labelid.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelid);
        
        JLabel lblnumber= new JLabel("Id Number");
        lblnumber.setBounds(30, 240,150,30);
        lblnumber.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(200,240,150,30);
        labelnumber.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelnumber);
       
        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(30, 280,150,40);
        lblphone.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(200, 280,150,30);
        labelphone.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelphone);
        
        JLabel lblprice= new JLabel("Price");
        lblprice.setBounds(30, 320,150,40);
        lblprice.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        add(lblprice);
        
        labelprice= new JLabel();
        labelprice.setBounds(200, 320,150,30);
        labelprice.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        add(labelprice);

        
        back= new JButton("Back");
        back.setBounds(170,400,100,35);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 20 ));
        back.addActionListener(this);
        add(back);
        
//        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("images/booked.png"));
//        Image img2 = img1.getImage().getScaledInstance(400, 550, Image.SCALE_DEFAULT);
//        ImageIcon img3 =new ImageIcon(img2);
//        JLabel image =  new JLabel(img3);
//        image.setBackground(white);
//        image.setBounds(200,10,800,550);
//        add(image);
        
        ImageIcon img4= new ImageIcon(ClassLoader.getSystemResource("images/book1.jpg"));
        Image img5 = img4.getImage().getScaledInstance(880, 600, Image.SCALE_DEFAULT);
        ImageIcon img6 =new ImageIcon(img5);
        JLabel image1 =  new JLabel(img6);
        image1.setBackground(white);
        image1.setBounds(0,0,880,600);
        add(image1);
        
        try{
            Connect c = new Connect();
            String query = "select * from book_package where username = '"+username+"'" ;
            ResultSet rs = c.s.executeQuery(query ); 
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid .setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labeltravlers.setText(rs.getString("travlers"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
        
    }
    
    public static void main(String []args){
        new BookedPackage("tanvikaushik0808");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
