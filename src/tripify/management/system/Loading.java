package tripify.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
  
    public void run(){
        try{
            for (int i =0; i <= 100; i++){
                int max= bar.getMaximum();
                int value = bar.getValue();
                
                if (value<max){
                    bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username = username;
        t= new Thread(this);
        
        setSize(600,550);
        setLocation(440,200);
        setLayout(null);
       
        ImageIcon img7= new ImageIcon(ClassLoader.getSystemResource("images/load.jpg"));
        Image img8 = img7.getImage().getScaledInstance(800, 660, Image.SCALE_DEFAULT);
        ImageIcon img9 =new ImageIcon(img8);
        JLabel image = new JLabel(img9); 
        image.setBounds(0,0,800,600);
        add(image);
        
        JLabel text= new JLabel("Every Journey begins with a Single Step");
        text.setBounds(60,20,600,35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway", Font.BOLD, 25 ));
        image.add(text);
        
        bar = new JProgressBar();
        bar.setBounds(120,100,350,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading= new JLabel("Loading Please wait....");
        loading.setBounds(220,150,250,20);
        loading.setForeground(Color.WHITE);
        loading.setFont(new Font("SAN SERIF", Font.BOLD, 17 ));
        image.add(loading);
        
        JLabel lblusername= new JLabel("Welcome"+" " + username);
        lblusername.setBounds(20,450,400,40);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 25 ));
        image.add(lblusername);
        
        t.start();
        setVisible(true);
        
    }
    
    public static void main(String[]args){
        new Loading("");
                
    }
}
