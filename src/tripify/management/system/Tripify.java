package tripify.management.system;
import javax.swing.*; //swing ka andar jframe class hoti h jisse ki hum jframe class ka andar jo function h unka use kr sake images/aaron-thomas-0aNUp-RV-Pk-unsplash
import java.awt.*;


public class Tripify extends JFrame implements Runnable {
    Thread thread;
    Tripify(){
//      setSize(1200,600); // frame ka size
//      setLocation(160,145);
 
        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("images/image1.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image =  new JLabel(img3);
        add(image);
        
        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }
    public void run(){
        try{
            Thread.sleep(7000);
            new Login();
            setVisible(false);
        }catch(Exception e){
            
        }
        
    }
    public static void main(String[] args){
        Tripify frame = new Tripify();
        int x=1;
        for(int i=1;i<=500;i+=6,x+=7){
            frame.setLocation(750-(x+i)/2,400-(i/2));
            frame.setSize( x+i,i);
        try{
            Thread.sleep(10);
        }catch(Exception e){}
        }
    }
}
