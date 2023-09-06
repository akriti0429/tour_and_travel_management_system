package tripify.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public final class CheckPackage extends JFrame{
    
    CheckPackage(){
        setBounds(350,160,850,550);
        //getContentPane().setBackground(Color.white);
        
        String[] package1 = {"GOLD PACKAGE","6 Days and 7 Nights", "Airport Assistance","Half Day City Tour","DaIly Buffet","Soft Drinks Free","Full Day 3 Island Cruice","English Speaking Guide","Book Package", "SUMMER SPECIAL","Rs 12000/-","pack1.jpg"};
        String[] package2 = {"SILVER PACKAGE"," 5 Days and 4 Nights","Toll Free and Entrance Free Ticket","Temple Visits","Historical Visits","Welcome Drinks on Arrival","Night Safari","Cruice with Dinner","Book Now", "WINTER SPECIAL","Rs 24000/-","pack2.jpg"};
        String[] package3 = {"BRONZE PACKAGE","4 Days and 3 Nights","Return Airfare", "Water Rides","Meet and Greet at Airpirt", "Free Clubbing and Horse Riding", "Hard Drinks Free","BBQ Dinner","Book Now","WINTER SPECIAL","Rs 32000/-","pack3.jpg"};
        
        JTabbedPane tab = new JTabbedPane();
        JPanel panel1 = createPackage(package1);
        tab.addTab("Package1",null,panel1);
        
        JPanel panel2 = createPackage(package2);
        tab.addTab("Package2",null,panel2);
        
        JPanel panel3 = createPackage(package3);
        tab.addTab("Package3",null,panel3);
        
        add(tab,BorderLayout.CENTER);
        
        setVisible(true);
    }
    public JPanel createPackage(String[] packy){
        JPanel panel1=new JPanel();
        panel1.setBackground(Color.white);
        panel1.setLayout(null);
        
        JLabel p1= new JLabel(packy[0]);
        p1.setBounds(100,30,500,50);
        p1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.setForeground(Color.black);
        panel1.add(p1);
        
        JLabel p2= new JLabel(packy[1]);
        p2.setBounds(50,90,500,50);
        p2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.setForeground(Color.black);
        panel1.add(p2);
        
        JLabel p3= new JLabel(packy[2]);
        p3.setBounds(50,130,500,50);
        p3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p3.setForeground(Color.black);
        panel1.add(p3);
        
        JLabel p4= new JLabel(packy[3]);
        p4.setBounds(50,170,500,50);
        p4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p4.setForeground(Color.black);
        panel1.add(p4);
        
        JLabel p5= new JLabel(packy[4]);
        p5.setBounds(50,210,500,50);
        p5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p5.setForeground(Color.black);
        panel1.add(p5);
        
        JLabel p6 = new JLabel(packy[5]);
        p6.setBounds(50,250,500,50);
        p6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p6.setForeground(Color.black);
        panel1.add(p6);
        
        JLabel p7 = new JLabel(packy[6]);
        p7.setBounds(50,290,500,50);
        p7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p7.setForeground(Color.black);
        panel1.add(p7);
        
        JLabel p11 = new JLabel(packy[7]);
        p11.setBounds(50,330,500,50);
        p11.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p11.setForeground(Color.black);
        panel1.add(p11);
        
        JLabel p8 = new JLabel(packy[8]);
        p8.setBounds(430,350,500,50);
        p8.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p8.setForeground(Color.BLUE);
        panel1.add(p8);
        
        JLabel p9 = new JLabel(packy[9]);
        p9.setBounds(150,390,500,50);
        p9.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p9.setForeground(Color.RED);
        panel1.add(p9);
        
        JLabel p10 = new JLabel(packy[10]);
        p10.setBounds(200,430,500,50);
        p10.setFont(new Font("Tahoma", Font.PLAIN, 25));
        p10.setForeground(Color.GREEN);
        panel1.add(p10);
        
        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("images/"+packy[11]));
        Image img2 = img1.getImage().getScaledInstance(350, 220, Image.SCALE_DEFAULT);
        ImageIcon img3 =new ImageIcon(img2);
        JLabel image =  new JLabel(img3);
        image.setBackground(white);
        image.setBounds(100,80,880,300);
        panel1.add(image);
        
        ImageIcon img4= new ImageIcon(ClassLoader.getSystemResource("images/back3.jpg"));
        Image img5 = img4.getImage().getScaledInstance(880, 600, Image.SCALE_DEFAULT);
        ImageIcon img6 =new ImageIcon(img5);
        JLabel image1 =  new JLabel(img6);
        image1.setBackground(white);
        image1.setBounds(0,0,880,600);
        panel1.add(image1);
        
        return panel1;
    }
    public static void main(String[]args){
        new CheckPackage();
        
    }
    
}
