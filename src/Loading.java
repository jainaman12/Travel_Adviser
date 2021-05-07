import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    JProgressBar p;
    Thread t;
    String username;

    public void run() {
        
            try {
                int i=0;
                for (i = 0; i <= 100; i++) {
                    Thread.sleep(50);// Pausing execution for 50 milliseconds
                    p.setValue(i);// Setting value of Progress Bar

                }

                if (i==100)
                    new Loading("").setVisible(false);
                    new Dashboard(username).setVisible(true);
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    

    Loading(String user) {
        t = new Thread(this);
        username = user;

        setBounds(300, 150, 900, 600);
        setLayout(null);
        getContentPane().setBackground(new Color(58, 175, 169));
        JLabel l1 = new JLabel("Travel And Tourism");
        l1.setBounds(210, 50, 900, 40);
        l1.setFont(new Font("Raleway", Font.BOLD, 47));
        l1.setForeground(Color.WHITE);
        add(l1);
        JLabel l2 = new JLabel("Management System");
        l2.setBounds(308, 93, 400, 30);
        l2.setFont(new Font("Raleway", Font.BOLD, 25));
        l2.setForeground(new Color(23, 37, 42));
        add(l2);

        // Adding Progress Bar
        p = new JProgressBar();
        p.setBounds(210, 380, 450, 40);
        p.setBorderPainted(true);
        p.setStringPainted(true);
        p.setBackground(Color.WHITE);
        p.setForeground(new Color(23, 37, 42));
        p.setFont(new Font("Raleway", Font.BOLD, 16));
        p.setValue(0);
        t.start();
        add(p);

        JLabel l3 = new JLabel("Please Wait...");
        l3.setBounds(535, 420, 150, 25);
        l3.setFont(new Font("Raleway", Font.BOLD, 19));
        l3.setForeground(new Color(23, 37, 42));
        add(l3);

        JLabel l4 = new JLabel("Welcome" + " " + " " + username);
        l4.setBounds(10, 530, 300, 25);
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setForeground(new Color(24, 38, 40));
        add(l4);

        // Adding gif to the Frame

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/loading02.gif"));
        Image img1 = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel l0 = new JLabel(img2);
        l0.setBounds(350, 180, 150, 150);
        add(l0);

    }

    public static void main(String[] args) {
        new Loading("").setVisible(true);

    }

}
