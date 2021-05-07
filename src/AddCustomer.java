import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddCustomer extends JFrame implements ActionListener {
    JLabel l3, l4, l5, l6, l7, l8, l31, l1;
    JButton b1, b2;
    JTextField txn1, txn2, txn3, txn4;
    JComboBox c1;
    JRadioButton r1, r2;
    Font font1 = new Font("Helvetica", Font.PLAIN, 16);

    AddCustomer(String username) {
        setLayout(null);
        setBounds(300, 100, 900, 680);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 430, 680);
        p1.setBackground(Color.white);
        p1.setLayout(null);
        add(p1);

        ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("icons/add.jpg"));
        Image img5 = img4.getImage().getScaledInstance(430, 430, Image.SCALE_DEFAULT);
        ImageIcon img6 = new ImageIcon(img5);
        JLabel l0 = new JLabel(img6);
        l0.setBounds(0, 100, 430, 430);
        p1.add(l0);

        JPanel p2 = new JPanel();

        p2.setBounds(400, 0, 480, 680);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);
        add(p2);

        l3 = new JLabel("Hii,");
        l3.setBounds(60, 10, 220, 30);
        l3.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        p2.add(l3);

        l31 = new JLabel("Add your personal Details !");
        l31.setBounds(60, 50, 400, 34);
        l31.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
        p2.add(l31);

        l4 = new JLabel("Username :");
        l4.setForeground(Color.gray);
        l4.setBounds(120, 110, 250, 20);
        l4.setFont(new Font("Raleway", Font.PLAIN, 17));
        p2.add(l4);
        txn1 = new JTextField();
        txn1.setText(username);
        txn1.setEditable(false);
        txn1.setBounds(120, 140, 250, 30);
        p2.add(txn1);
        txn1.setFont(font1);
        txn1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        l5 = new JLabel("Choose your ID type");
        l5.setForeground(Color.gray);
        l5.setBounds(120, 185, 250, 20);
        l5.setFont(new Font("Raleway", Font.PLAIN, 17));
        p2.add(l5);

        c1 = new JComboBox<>(new String[] { "Passport", "AadharCard", "Pan Card", "Driving License" });
        c1.setBounds(120, 220, 250, 25);
        p2.add(c1);

        l6 = new JLabel("Enter your ID Number :");
        l6.setForeground(Color.gray);
        l6.setBounds(120, 260, 250, 20);
        l6.setFont(new Font("Raleway", Font.PLAIN, 17));
        p2.add(l6);
        txn2 = new JTextField();
        txn2.setBounds(120, 290, 250, 30);
        p2.add(txn2);
        txn2.setFont(font1);
        txn2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        l7 = new JLabel("Your Name:");
        l7.setForeground(Color.gray);
        l7.setBounds(120, 340, 250, 20);
        l7.setFont(new Font("Raleway", Font.PLAIN, 17));
        p2.add(l7);
        txn3 = new JTextField();
        txn3.setBounds(120, 370, 250, 30);
        p2.add(txn3);
        txn3.setEditable(false);
        txn3.setFont(font1);
        txn3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        l8 = new JLabel("Gender:");
        l8.setForeground(Color.gray);
        l8.setBounds(120, 410, 250, 20);
        l8.setFont(new Font("Raleway", Font.PLAIN, 17));
        p2.add(l8);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.white);
        r1.setBounds(120, 440, 100, 20);
        r1.setFont(font1);
        r1.setFocusable(false);
        p2.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setBounds(235, 440, 100, 20);
        r2.setFocusable(false);
        r2.setFont(font1);
        p2.add(r2);

        l8 = new JLabel("Address:");
        l8.setForeground(Color.gray);
        l8.setBounds(120, 480, 250, 20);
        l8.setFont(new Font("Raleway", Font.PLAIN, 17));
        p2.add(l8);
        txn4 = new JTextField();
        txn4.setBounds(120, 500, 250, 30);
        p2.add(txn4);
        txn4.setFont(font1);
        txn4.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        // Adding add button
        b1 = new JButton("Add Details");
        b1.addActionListener(this);
        b1.setLayout(null);
        b1.setBounds(120, 560, 120, 30);
        p2.add(b1);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setBackground(new Color(255, 255, 255));
        b1.setFocusable(false);
        b1.setFont(font1);

        // Adding back button
        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setLayout(null);
        b2.setFont(font1);
        b2.setBounds(250, 560, 120, 30);
        p2.add(b2);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setBackground(new Color(255, 255, 255));
        b2.setFocusable(false);

        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from tms where username='"+username+"'");
            while(rs.next()){
                txn3.setText(rs.getString("fullname"));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            try {
                String user= txn1.getText();
                String id = (String) c1.getSelectedItem();
                String idnumber1 = txn2.getText();
                String radio = null;
                if (r1.isSelected()) {
                    radio = "Male";
                } else if (r2.isSelected()) {
                    radio = "Female";
                }
                String useraddress = txn4.getText();

                String query = "UPDATE tms SET idtype='"+id+"',idnumber='"+idnumber1+"',gender='"+radio+"',address='"+ useraddress+"' WHERE username='"+user+"'";

                conn c2 = new conn();
                c2.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Details Added Successfully");
                this.setVisible(false);
                

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {
            this.setVisible(false);

        }

    }

    public static void main(String[] args) {
        new AddCustomer("").setVisible(true);
    }
}
