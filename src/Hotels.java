import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Hotels extends JFrame implements ActionListener {
    Font font1 = new Font("Raleway", Font.PLAIN, 24);
    Font font2 = new Font("Raleway", Font.PLAIN, 16);
    JButton btn1;
    JComboBox c1;
    String username;
    

    Hotels(String username) {
        this.username=username;
        setTitle("Search Hotels");
        getContentPane().setBackground(Color.white);
        setBounds(300, 150, 1000, 500);
        setLayout(null);
        //setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 500, 500);
        p1.setBackground(new Color(255,255,255));
        add(p1);

        JPanel p2=new JPanel();
        p2.setBounds(500,0,500,500);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);
        add(p2);
        


        ImageIcon img4= new ImageIcon(ClassLoader.getSystemResource("icons/dest2.png"));
            Image img5=img4.getImage().getScaledInstance(500,500 , Image.SCALE_DEFAULT);
            ImageIcon img6=new ImageIcon(img5);
            JLabel l0=new JLabel(img6);
            l0.setBounds(0, 0, 500, 500);
            //l0.setLayout(new BorderLayout());
            // l0.setHorizontalAlignment(JLabel.CENTER);
            p1.add(l0);

        JLabel l1 = new JLabel("Enter the location you want to visit");
        l1.setBounds(60, 100, 500, 40);
        l1.setForeground(Color.BLACK);
        l1.setFont(font1);
        p2.add(l1);

        c1 = new JComboBox<>(new String[] { "Delhi", "Nainital", "Shimla", "Mumbai","Kerala","Goa","Kashmir","Hyderabad" });
        c1.setBounds(120, 200, 250, 30);
        p2.add(c1);
        c1.setFont(font2);
        c1.setFocusable(false);

        btn1 = new JButton("Search Hotels");
        btn1.setBounds(165, 280, 170, 35);
        btn1.setBackground(new Color(255, 255, 255));
        btn1.setForeground(Color.BLACK);
        btn1.addActionListener(this);
        btn1.setFocusable(false);
        btn1.setFont(font2);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //btn1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(btn1);

        
        

    }

    public static void main(String[] args) {
        new Hotels("").setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){

            String location= (String) c1.getSelectedItem();
            
            new Hoteltable(location,username).setVisible(true);
            this.setVisible(false);

        }

    }

}