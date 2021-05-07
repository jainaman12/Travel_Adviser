import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class CheckPackage extends JFrame implements ActionListener {
  JButton b1, b2, b3;
  JTabbedPane tabbedPane;
  JComboBox combo, combo1, combo2;
  Font f1 = new Font("Raleway", Font.PLAIN, 17);
  // Font f2=new Font("Raleway",Font.PLAIN,16);
  String user;

  public static void main(String[] args) {
    new CheckPackage("").setVisible(true);
  }

  CheckPackage(String username) {
    this.user = username;
    setBounds(350, 150, 900, 600);
    setVisible(true);
    String[] package1 = new String[] { "package1.jpg", "GOLD PACKAGE", "6 days and 7 Nights",
        "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet",
        "Full Day 3 Island Cruise", "English Speaking Guide", "Summer Special", "package1", "Rs 35000/-" };
    String[] package2 = new String[] { "package2.jpg", "SILVER PACKAGE", "5 days and 4 Nights",
        "Toll Free and Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari",
        "Full Day 3 Island Cruise", "Cruise with Dinner", "Winter Special", "package2", "Rs 25000/-" };
    String[] package3 = new String[] { "package3.jpg", "BRONZE PACKAGE", "4 days and 3 Nights", "Return Airfare",
        "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet",
        "Stay in 5 Star Hotel", "BBQ Dinner", "Winter Special", "package3", "Rs 20000/-" };

    tabbedPane = new JTabbedPane();
    JPanel p1 = createPackage(package1);
    tabbedPane.addTab("Package 1", null, p1);
    JLabel l23 = new JLabel("Number of Persons -");
    l23.setBounds(35, 360, 200, 20);
    l23.setFont(f1);
    p1.add(l23);

    combo = new JComboBox<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
    combo.setBounds(230, 360, 150, 20);
    // combo.setFont();
    combo.setFocusable(false);
    combo.setBackground(Color.WHITE);
    combo.setFont(f1);
    p1.add(combo);
    b1 = new JButton("Book Now");
    b1.setBounds(35, 450, 150, 30);
    b1.addActionListener(this);
    b1.setFocusable(false);
    b1.setBackground(Color.white);
    b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    b1.setFont(new Font("Raleway", Font.PLAIN, 18));
    p1.add(b1);

    JPanel p2 = createPackage(package2);
    tabbedPane.addTab("Package 2", null, p2);
    JLabel l231 = new JLabel("Number of Persons -");
    l231.setBounds(35, 360, 200, 20);
    l231.setFont(f1);
    p2.add(l231);
    combo1 = new JComboBox<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
    combo1.setBounds(230, 360, 150, 20);
    // combo1.setFont();
    combo1.setFocusable(false);
    combo1.setBackground(Color.WHITE);
    combo1.setFont(f1);
    p2.add(combo1);
    b2 = new JButton("Book Now");
    b2.setBounds(35, 450, 150, 30);
    b2.addActionListener(this);
    b2.setFocusable(false);
    b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    b2.setBackground(Color.white);
    b2.setFont(new Font("Raleway", Font.PLAIN, 18));
    p2.add(b2);

    JPanel p3 = createPackage(package3);
    tabbedPane.addTab("Package 3", null, p3);
    JLabel l232 = new JLabel("Number of Persons -");
    l232.setBounds(35, 360, 200, 20);
    l232.setFont(f1);
    p3.add(l232);
    combo2 = new JComboBox<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
    combo2.setBounds(230, 360, 150, 20);
    // combo2.setFont();
    combo2.setFocusable(false);
    combo2.setFont(f1);
    combo2.setBackground(Color.WHITE);

    p3.add(combo2);
    b3 = new JButton("Book Now");
    b3.setBounds(35, 450, 150, 30);
    b3.addActionListener(this);
    b3.setFocusable(false);
    b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    b3.setBackground(Color.white);
    b3.setFont(new Font("Raleway", Font.PLAIN, 18));
    p3.add(b3);

    add(tabbedPane);
  }

  public JPanel createPackage(String[] pack) {
    JPanel p1 = new JPanel();
    p1.setLayout(null);
    p1.setFont(f1);
    p1.setBackground(Color.WHITE);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[0]));
    Image i3 = i1.getImage().getScaledInstance(550, 300, Image.SCALE_DEFAULT);
    ImageIcon i2 = new ImageIcon(i3);
    JLabel l1 = new JLabel(i2);
    l1.setBounds(400, 0, 450, 420);
    p1.add(l1);

    JLabel lblName = new JLabel(pack[1]);
    lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
    lblName.setBounds(50, 5, 350, 53);

    p1.add(lblName);

    JLabel l3 = new JLabel(pack[2]);
    l3.setForeground(Color.RED);
    l3.setBounds(35, 70, 350, 20);
    p1.add(l3);
    l3.setFont(f1);

    JLabel lblId = new JLabel(pack[3]);
    lblId.setForeground(Color.BLUE);
    lblId.setBounds(35, 110, 350, 20);
    p1.add(lblId);
    lblId.setFont(f1);

    JLabel l2 = new JLabel(pack[4]);
    l2.setForeground(Color.RED);
    l2.setBounds(35, 150, 350, 20);
    l2.setFont(f1);
    p1.add(l2);

    JLabel lblName_1 = new JLabel(pack[5]);
    lblName_1.setForeground(Color.BLUE);
    lblName_1.setBounds(35, 190, 350, 20);
    lblName_1.setFont(f1);
    p1.add(lblName_1);

    JLabel lblGender = new JLabel(pack[6]);
    lblGender.setForeground(Color.RED);
    lblGender.setBounds(35, 230, 350, 20);
    lblGender.setFont(f1);
    p1.add(lblGender);

    JLabel lblCountry = new JLabel(pack[7]);
    lblCountry.setForeground(Color.BLUE);
    lblCountry.setBounds(35, 270, 350, 20);
    lblCountry.setFont(f1);
    p1.add(lblCountry);

    JLabel lblReserveRoomNumber = new JLabel(pack[8]);
    lblReserveRoomNumber.setForeground(Color.RED);
    lblReserveRoomNumber.setBounds(35, 310, 350, 20);
    p1.add(lblReserveRoomNumber);
    lblReserveRoomNumber.setFont(f1);

    // JLabel lblCheckInStatus = new JLabel(pack[9]);
    // lblCheckInStatus.setForeground(Color.BLUE);
    // lblCheckInStatus.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
    // lblCheckInStatus.setBounds(35, 400, 350, 30);
    // p1.add(lblCheckInStatus);

    // JLabel lblDeposite = new JLabel(pack[10]);
    // lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
    // lblDeposite.setBounds(35, 460, 400, 40);
    // p1.add(lblDeposite);

    JLabel la1 = new JLabel(pack[11]);
    la1.setForeground(Color.RED);
    la1.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
    la1.setBounds(600, 460, 400, 40);
    p1.add(la1);

    return p1;
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b1) {

      try {
        if (user != "") {
          String s1 = (String) combo.getSelectedItem();
          int tp=Integer.parseInt(s1);
          int newtp=tp*35000;
          conn c1 = new conn();
          String query1 = "Select idtype,idnumber from tms where Username='" + user + "'";
          ResultSet rs = c1.s.executeQuery(query1);
          while (rs.next()) {
            String id = rs.getString("idtype");
            String idn = rs.getString("idnumber");
            conn c2 = new conn();
            String query = "Insert into bookpackage values('" + user + "','" + tp + "','" + id + "','" + idn
                + "','Package 1','"+newtp+"')";
            c2.s.executeUpdate(query);

          }

          JOptionPane.showMessageDialog(null, "Package-1 Booked Successfully");
        } else {
          JOptionPane.showMessageDialog(null, "Please login first");
          this.setVisible(false);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

    }
    if (ae.getSource() == b2) {
      try {
        if (user != "") {
          String s1 = (String) combo.getSelectedItem();
          conn c1 = new conn();int tp=Integer.parseInt(s1);
          int newtp=tp*25000;
          String query1 = "Select idtype,idnumber from tms where Username='" + user + "'";
          ResultSet rs = c1.s.executeQuery(query1);
          while (rs.next()) {
            String id = rs.getString("idtype");
            String idn = rs.getString("idnumber");
            conn c2 = new conn();
            String query = "Insert into bookpackage values('" + user + "','" + tp + "','" + id + "','" + idn
                + "','Package 2','"+newtp+"')";
            c2.s.executeUpdate(query);

          }

          JOptionPane.showMessageDialog(null, "Package-2 Booked Successfully");
        } else {
          JOptionPane.showMessageDialog(null, "Please login first");
          this.setVisible(false);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

    }
    if (ae.getSource() == b3) {
      try {
        if (user != "") {
          String s1 = (String) combo.getSelectedItem();
          conn c1 = new conn();
          int tp=Integer.parseInt(s1);
          int newtp=tp*20000;
          String query1 = "Select idtype,idnumber from tms where Username='" + user + "'";
          ResultSet rs = c1.s.executeQuery(query1);
          while (rs.next()) {
            String id = rs.getString("idtype");
            String idn = rs.getString("idnumber");
            conn c2 = new conn();
            String query = "Insert into bookpackage values('" + user + "','" + tp + "','" + id + "','" + idn
                + "','Package 3','"+newtp+"')";
            c2.s.executeUpdate(query);

          }

          JOptionPane.showMessageDialog(null, "Package-3 Booked Successfully");
        } else {
          JOptionPane.showMessageDialog(null, "Please login first");
          this.setVisible(false);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

    }

  }
}