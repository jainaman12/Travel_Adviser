
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Viewbooked extends JFrame {
    private JPanel contentPane;
    Font f1=new Font("Raleway",Font.BOLD,15);
    Font f2=new Font("Raleway",Font.PLAIN,16);

    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Viewbooked frame = new Viewbooked("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Viewbooked(String username) {
        setBounds(410, 150, 870, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 50, 365, 350);
        add(la1);

        JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
        lblName.setFont(new Font("Raleway", Font.PLAIN, 22));
        lblName.setBounds(65, 2, 350, 53);
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setBounds(35, 70, 200, 25);
        contentPane.add(lb3);
        lb3.setFont(f1);

        JLabel l1 = new JLabel();
        l1.setBounds(200, 70, 200, 25);
        contentPane.add(l1);
        l1.setFont(f2);

        JLabel lblId = new JLabel("Name :");
        lblId.setBounds(35, 110, 200, 25);
        contentPane.add(lblId);
        lblId.setFont(f1);

        JLabel l2 = new JLabel();
        l2.setBounds(200, 110, 200, 25);
        contentPane.add(l2);
        l2.setFont(f2);

       

        JLabel lb2 = new JLabel("Email ID :");
        lb2.setBounds(35, 150, 200, 25);
        contentPane.add(lb2);
        lb2.setFont(f1);

        JLabel l3 = new JLabel();
        l3.setBounds(200, 150, 300, 25);
        contentPane.add(l3);
        l3.setFont(f2);

        JLabel lblName_1 = new JLabel("Number of Days :");
        lblName_1.setBounds(35, 190, 200, 25);
        contentPane.add(lblName_1);
        lblName_1.setFont(f1);

        JLabel l4 = new JLabel("");
        l4.setBounds(200, 190, 200, 25);
        contentPane.add(l4);
        l4.setFont(f2);

        JLabel lblId1 = new JLabel("Booked Hotel Name :");
        lblId1.setBounds(35, 230, 200, 25);
        contentPane.add(lblId1);
        lblId1.setFont(f1);

        JLabel l5 = new JLabel();
        l5.setBounds(200, 230, 200, 25);
        contentPane.add(l5);
        l5.setFont(f2);

        JLabel la3 = new JLabel("Hotel Cost :");
        la3.setBounds(35, 270, 200, 25);
        contentPane.add(la3);
        la3.setFont(f1);

        JLabel l11 = new JLabel();
        l11.setForeground(Color.RED);
        l11.setBounds(200, 270, 200, 25);
        contentPane.add(l11);
        l11.setFont(f2);

        



        JLabel lblReserveRoomNumber = new JLabel("Booked Package :");
        lblReserveRoomNumber.setBounds(35, 325, 200, 25);
        contentPane.add(lblReserveRoomNumber);
        lblReserveRoomNumber.setFont(f1);

        JLabel l7 = new JLabel();
        l7.setBounds(200, 325, 200, 25);
        contentPane.add(l7);
        l7.setFont(f2);

        JLabel lblCheckInStatus = new JLabel("Number of Persons :");
        lblCheckInStatus.setBounds(35, 365, 200, 25);
        contentPane.add(lblCheckInStatus);
        lblCheckInStatus.setFont(f1);
        

        JLabel l8 = new JLabel();
        l8.setBounds(200, 365, 200, 25);
        contentPane.add(l8);
        l8.setFont(f2);

        // JLabel lblDeposite = new JLabel("Phone :");
        // lblDeposite.setBounds(35, 390, 200, 25);
        // contentPane.add(lblDeposite);

        // JLabel l9 = new JLabel();
        // l9.setBounds(200, 390, 200, 25);
        // contentPane.add(l9);

        JLabel la2 = new JLabel("Package Cost :");
        la2.setBounds(35, 405, 200, 25);
        contentPane.add(la2);
        la2.setFont(f1);

        JLabel l10 = new JLabel();
        l10.setForeground(Color.RED);
        l10.setBounds(200, 405, 200, 25);
        contentPane.add(l10);
        l10.setFont(f2);


        
        
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bookpackage where username = '" + username + "'");
            while (rs.next()) {
                
                
                
                l7.setText(rs.getString("PackageName"));
                l8.setText(rs.getString("totalPersons"));
                l10.setText("Rs "+rs.getString("packagePrice"));
                

            }
            conn c1 = new conn();
            
            ResultSet rs1 = c1.s.executeQuery("select * from tms where username = '" + username + "'");
            while (rs1.next()) {
                l1.setText(username);
                l2.setText(rs1.getString("fullname"));
                l3.setText(rs1.getString("email"));

            }
            conn c3 = new conn();

            ResultSet rs2 = c3.s.executeQuery("select * from bookhotel where username = '" + username + "'");
            while (rs2.next()) {
                int days=rs2.getInt("totalDays");
                String dayss=String.valueOf(days);
                l4.setText(dayss);
                l11.setText("Rs "+rs2.getString("totalPrice"));
                l5.setText(rs2.getString("hotelName"));
                

            }

            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
