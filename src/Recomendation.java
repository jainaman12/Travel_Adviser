import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class Recomendation extends JFrame implements ActionListener {
    JComboBox c1, c2, c3;
    JButton b;

    Recomendation() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(400, 150, 820, 500);
        ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("icons/table.png"));
        Image img5 = img4.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon img6 = new ImageIcon(img5);
        JLabel l0 = new JLabel(img6);
        l0.setBounds(500, 20, 300, 400);
        // l0.setLayout(new BorderLayout());
        // l0.setHorizontalAlignment(JLabel.CENTER);
        add(l0);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 500, 40);
        p1.setBackground(new Color(255, 51, 153));
        add(p1);

        JLabel l1 = new JLabel("Recomendation System");
        l1.setFont(new Font("Tamoha", Font.BOLD, 17));
        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setBounds(0, 40, 500, 40);
        p2.setBackground(new Color(255, 153, 204));
        add(p2);

        JLabel l2 = new JLabel("Find your perfect holiday package");
        l2.setFont(new Font("San serif", Font.BOLD, 20));
        p2.add(l2);

        JLabel l3 = new JLabel(
                "<html>Book package on the basic of Three criteria:<br/>1. Cost of Your Package<br/>2. Number of days<br/>3. Accomodation Type</html>");
        l3.setFont(new Font("San serif", Font.BOLD, 14));
        l3.setBounds(30, 110, 500, 80);
        add(l3);

        JLabel l4 = new JLabel("Compare Cost with Days:");
        l4.setFont(new Font("San serif", Font.BOLD, 14));
        l4.setBounds(40, 220, 250, 30);
        add(l4);

        JLabel l5 = new JLabel("Compare Cost with Accomodation:");
        l5.setFont(new Font("San serif", Font.BOLD, 14));
        l5.setBounds(40, 250, 250, 30);
        add(l5);

        JLabel l6 = new JLabel("Compare Days with Accomodation:");
        l6.setFont(new Font("San serif", Font.BOLD, 14));
        l6.setBounds(40, 280, 250, 30);
        add(l6);

        String acc[] = { "2", "3", "4", "5", "6", "7", "8", "9" };
        c1 = new JComboBox<>(acc);
        c1.setBounds(300, 220, 180, 25);
        add(c1);

        c2 = new JComboBox<>(acc);
        c2.setBounds(300, 250, 180, 25);
        add(c2);

        c3 = new JComboBox<>(acc);
        c3.setBounds(300, 280, 180, 25);
        add(c3);

        b = new JButton("<html><center>Search for<br/> Recomendations</center></html>");
        b.setBounds(230, 350, 150, 40);
        b.addActionListener(this);
        add(b);

        // f.setBounds(550,250,500,500);

    }

    public static void main(String[] args) {
        new Recomendation().setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            String a = (String) c1.getSelectedItem();
            int x = Integer.parseInt(a);
            String b = (String) c2.getSelectedItem();
            int y = Integer.parseInt(b);
            String c = (String) c3.getSelectedItem();
            int z = Integer.parseInt(c);

            new Criteria(x, y, z);
            this.setVisible(false);

        }

    }

}
