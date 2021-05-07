
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookPackage extends JFrame {
    private JPanel contentPane;
    JTextField t1, t2;
    JComboBox combo;
    Font font1 = new Font("Raleway", Font.PLAIN, 17);
    Font font2 = new Font("Raleway", Font.BOLD, 16);
    String username;
    String value;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookPackage frame = new BookPackage("", "");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BookPackage(String username, String value) {
        this.username=username;
        this.value=value;
        setBounds(250, 160, 1100, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 50, 700, 300);
        add(la1);

        JLabel lblName = new JLabel("Hotel Booking");
        lblName.setFont(new Font("Raleway", Font.BOLD, 26));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(35, 90, 200, 20);
        la2.setFont(font1);
        contentPane.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(215, 90, 200, 20);
        l1.setFont(font2);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Hotel Name :");
        lblId.setBounds(35, 130, 200, 20);
        lblId.setFont(font1);
        contentPane.add(lblId);

        JLabel Hname = new JLabel(value);
        Hname.setBounds(215, 120, 150, 30);
        Hname.setFont(font2);
        add(Hname);

        JLabel la3 = new JLabel("No. of Days :");
        la3.setBounds(35, 170, 200, 20);
        la3.setFont(font1);
        contentPane.add(la3);

        combo = new JComboBox<>(new String[] { "1", "2", "3", "4","5","6","7","8","9","10" });
        combo.setBounds(215, 170, 150, 20);
        combo.setFont(font1);
        combo.setFocusable(false);
        combo.setBackground(Color.WHITE);
        contentPane.add(combo);

        JLabel lbl1 = new JLabel("ID :");
        lbl1.setBounds(35, 210, 200, 20);
        lbl1.setFont(font1);
        contentPane.add(lbl1);

        JLabel l2 = new JLabel();
        l2.setFont(font2);
        l2.setBounds(215, 210, 200, 20);
        contentPane.add(l2);

        JLabel lbl2 = new JLabel("ID Number :");
        lbl2.setBounds(35, 250, 200, 20);
        contentPane.add(lbl2);
        lbl2.setFont(font1);

        JLabel l3 = new JLabel();
        l3.setFont(font2);
        l3.setBounds(215, 250, 200, 20);
        contentPane.add(l3);

        // JLabel lbl3 = new JLabel("Phone :");
        // lbl3.setBounds(35, 270, 200, 14);
        // contentPane.add(lbl3);

        // JLabel l4 = new JLabel();
        // l4.setBounds(215, 270, 200, 14);
        // contentPane.add(l4);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 310, 200, 20);
        lblDeposite.setFont(font1);
        contentPane.add(lblDeposite);

        JLabel l5 = new JLabel();
        l5.setFont(font2);
        l5.setBounds(215, 310, 200, 20);
        l5.setForeground(Color.RED);
        contentPane.add(l5);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from tms where username ='" + username + "'");
            while (rs.next()) {
                l2.setText(rs.getString("idtype"));
                l3.setText(rs.getString("idnumber"));

            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton b1 = new JButton("Check Price");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c1=new conn();
                    String query="Select * from `sampledb` WHERE `Hotel Name`='"+value+"'";                   
                    ResultSet rs=c1.s.executeQuery(query);
                    String Hprice=null;

                    while(rs.next()){
                        Hprice=rs.getString("Hotel's Price/Night");
                        int Money=Integer.parseInt(Hprice);
                        String hmoney= (String) combo.getSelectedItem();
                        Money *= Integer.parseInt(hmoney);
                        l5.setText(Money+"");
                    }  

                } catch (Exception ae) {
                    ae.printStackTrace();
                }
                
            
            }
        });
        b1.setBounds(30, 390, 150, 35);
        b1.setBackground(Color.BLACK);
        b1.setFont(font1);
        b1.setFocusable(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c=new conn();
                    String s1 = (String) combo.getSelectedItem();
                    if(username!=""){

            

                    String q1 = "Insert into bookhotel values('" + username + "', '" +value+ "', '"
                            + s1+ "', '" + l2.getText() + "', '" + l3.getText() + "', '" + l5.getText()+ "')";
                    c.s.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                    setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please login first");
                        setVisible(false);

                    }
                } catch (Exception ee) {
                   ee.printStackTrace();

                }
            }

                

            
        });
        btnNewButton.setBounds(200, 390, 120, 35);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setFont(font1);
        btnNewButton.setFocusable(false);
        btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(350, 390, 120, 35);
        btnExit.setBackground(Color.BLACK);
        btnExit.setFont(font1);
        btnExit.setFocusable(false);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
