package tripify.management.system;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addProfile, viewProfile, updateProfile, checkpackage, bookpackage,about;
    JButton bookedpackage,viewhotels,destinations,bookhotel,bookedhotel,payments,deletedata;
    Dashboard(String username){
        this.username= username;
        setBounds(0,0,1600,1000);
        setLayout(null);
        
        JPanel p1 =  new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,70);
        add(p1);
        
        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("images/icon3.png"));
        Image img2 = img1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon img3 =new ImageIcon(img2);
        JLabel icon =  new JLabel(img3);
        icon.setBackground(white);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel head =  new JLabel("Dashboard");
        head.setBounds(87,14,300,40);
        head.setForeground(Color.white);
        head.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(head);
        
        JPanel p2 =  new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,70,300,1000);
        add(p2);
        
        addProfile= new JButton("User Profile");
        addProfile.setBounds(0,0,300,50);
        addProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addProfile.setBackground(new Color(0,0,102));
        addProfile.setForeground(Color.white);
        addProfile.setMargin(new Insets(0,0,0,138));
        addProfile.addActionListener(this);
        p2.add(addProfile);
        
        updateProfile= new JButton("Update Profile");
        updateProfile.setBounds(0,50,300,50);
        updateProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
        updateProfile.setBackground(new Color(0,0,102));
        updateProfile.setForeground(Color.white);
        updateProfile.setMargin(new Insets(0,0,0,110));
        updateProfile.addActionListener(this);
        p2.add(updateProfile);
        
        viewProfile= new JButton("View Profile");
        viewProfile.setBounds(0,100,300,50);
        viewProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
        viewProfile.setBackground(new Color(0,0,102));
        viewProfile.setForeground(Color.white);
        viewProfile.setMargin(new Insets(0,0,0,126));
        viewProfile.addActionListener(this);
        p2.add(viewProfile);
        
        
        checkpackage= new JButton("Check Package ");
        checkpackage.setBounds(0,150,300,50);
        checkpackage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        checkpackage.setBackground(new Color(0,0,102));
        checkpackage.setForeground(Color.white);
        checkpackage.setMargin(new Insets(0,0,0,96));
        checkpackage.addActionListener(this);
        p2.add(checkpackage);
        
        bookpackage= new JButton("Book Package ");
        bookpackage.setBounds(0,200,300,50);
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.white);
        bookpackage.setMargin(new Insets(0,0,0,102 ));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        bookedpackage= new JButton("Booked Package ");
        bookedpackage.setBounds(0,250,300,50);
        bookedpackage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        bookedpackage.setBackground(new Color(0,0,102));
        bookedpackage.setForeground(Color.white);
        bookedpackage.setMargin(new Insets(0,0,0,82 ));
        bookedpackage.addActionListener(this);
        p2.add(bookedpackage);
        
        viewhotels= new JButton("View Hotels ");
        viewhotels.setBounds(0,300,300,50);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 18));
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.white);
        viewhotels.setMargin(new Insets(0,0,0,120 ));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotel= new JButton("Book Hotel");
        bookhotel.setBounds(0,350,300,50);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.white);
        bookhotel.setMargin(new Insets(0,0,0,130 ));
        bookhotel.addActionListener(this);
        p2.add(bookhotel); 
        
        bookedhotel= new JButton("View Booked Hotel");
        bookedhotel.setBounds(0,400,300,50);
        bookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        bookedhotel.setBackground(new Color(0,0,102));
        bookedhotel.setForeground(Color.white);
        bookedhotel.setMargin(new Insets(0,0,0,66 ));
        bookedhotel.addActionListener(this);
        p2.add(bookedhotel); 
        
        destinations= new JButton("Destinations");
        destinations.setBounds(0,450,300,50);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 18));
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setMargin(new Insets(0,0,0,118 ));
        destinations.addActionListener(this);
        p2.add(destinations); 
        
        payments = new JButton("Payments");
        payments.setBounds(0,500,300,50);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 18));
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setMargin(new Insets(0,0,0,134 ));
        payments.addActionListener(this);
        p2.add(payments); 
        
        deletedata = new JButton("Delete Details");
        deletedata.setBounds(0,550,300,50);
        deletedata.setFont(new Font("Tahoma", Font.PLAIN, 18));
        deletedata.setBackground(new Color(0,0,102));
        deletedata.setForeground(Color.white);
        deletedata.setMargin(new Insets(0,0,0,100));
        deletedata.addActionListener(this);
        p2.add(deletedata);
        
        about = new JButton("About");
        about.setBounds(0,600,300,50);
        about.setFont(new Font("Tahoma", Font.PLAIN, 18));
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setMargin(new Insets(0,0,0,160));
        about.addActionListener(this);
        p2.add(about); 
        
        
        ImageIcon img7= new ImageIcon(ClassLoader.getSystemResource("images/dash5.jpg"));
        Image img8 = img7.getImage().getScaledInstance(1420, 860, Image.SCALE_DEFAULT);
        ImageIcon img9 =new ImageIcon(img8);
        JLabel image = new JLabel(img9); 
        image.setBounds(0,0,1650,860);
        add(image);
        
        JLabel text = new JLabel("Travel Management System");
        text.setBounds(650,70,1000,70);
        image.add(text);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("Raleway", Font.PLAIN, 55));
        
        JLabel text1 = new JLabel("-Dream Away, Fly Away...");
        text1.setBounds(1150,100,1000,100);
        image.add(text1);
        text1.setForeground(Color.white);
        text1.setFont(new Font ("Raleway", Font.PLAIN, 30));
        
        
        setVisible(true);
            
        
    }
    
    public static void main(String [] args){
        new Dashboard("tanvikaushik0808");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== addProfile){
            new AddProfile(username);
        }else if(e.getSource()== viewProfile){
            new ViewProfile(username);
        }else if(e.getSource()== updateProfile){
            new UpdateProfile(username);
        }else if(e.getSource()== checkpackage){
            new CheckPackage();
        }else if(e.getSource()== bookpackage){
            new BookPackage(username);
        }else if(e.getSource()== bookedpackage){
            new BookedPackage(username);
        }else if(e.getSource()== viewhotels){
            new ViewHotels();
        }else if(e.getSource()== destinations){
            new Destinations();
        }else if(e.getSource()== bookhotel){
            new BookHotel(username);
        }else if(e.getSource()== bookedhotel){
            new BookedHotel(username);
        }else if(e.getSource()== payments){
            new Payment();
        }else if(e.getSource()== about){
            new About();
        }else if(e.getSource()== deletedata){
            new DeleteData(username );
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
