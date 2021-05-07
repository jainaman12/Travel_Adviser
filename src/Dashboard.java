import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.sql.*;
import javax.mail.*;
import java.util.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Dashboard extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, c1,rbutton;
    String username;
    JLabel user;
    Font f1 = new Font("Raleway", Font.BOLD, 19);

    Dashboard(String username) {
        this.username = username;

        getContentPane().setBackground(Color.WHITE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(20, 10, 1490, 40);
        p1.setBackground(new Color(255, 133, 102));
        add(p1);
        String text = "Learn more about Covid-19";
        JLabel hyperlink = new JLabel(text);
        hyperlink.setForeground(Color.BLACK);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hyperlink.setBounds(450, 5, 300, 20);
        p1.add(hyperlink);
        hyperlink.setFont(f1);
        hyperlink.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(
                            new URI("https://www.cdc.gov/coronavirus/2019-ncov/travelers/travel-during-covid19.html"));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText(text);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + text + "</a></html>");
            }
        });

        JPanel p2 = new JPanel();
        p2.setBounds(0, 50, 1600, 100);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);
        add(p2);

        /*
         * JLabel l1=new JLabel("Travel Mantu"); l1.setForeground(Color.BLACK);
         * l1.setFont(new Font("raleway", Font.BOLD,50)); l1.setBounds(750, 70, 500,
         * 30); p2.add(l1);
         */

        ImageIcon img1 = new ImageIcon(
                "C:/Users/12.amanjain/Desktop/travel management system project-20210405T183214Z-001/travel management system project/src/icons/logomain.png");
        Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel l2 = new JLabel(img3);
        l2.setBounds(30, 0, 100, 100);
        p2.add(l2);

        ImageIcon img10 = new ImageIcon(
                "C:/Users/12.amanjain/Desktop/travel management system project-20210405T183214Z-001/travel management system project/src/icons/logo1.jpg");
        Image img11 = img10.getImage().getScaledInstance(600, 70, Image.SCALE_DEFAULT);
        ImageIcon img12 = new ImageIcon(img11);
        JLabel l21 = new JLabel(img12);
        l21.setBounds(500, 10, 600, 70);
        p2.add(l21);

        // Adding login and signup button
        b9 = new JButton("Login");
        b9.setBounds(1280, 20, 100, 34);
        b9.setBackground(new Color(255, 138, 71));
        b9.setFont(new Font("Raleway", Font.PLAIN, 17));
        b9.setFocusable(false);
        b9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b9.addActionListener(this);
        p2.add(b9);

        user = new JLabel();
        user.setBounds(1260, 20, 120, 34);
        user.setFont(new Font("Raleway", Font.BOLD, 18));
        user.setForeground(new Color(255, 69, 0));
        p2.add(user);

        b10 = new JButton("Signup");
        b10.setBounds(1400, 20, 100, 34);
        b10.setBackground(new Color(255, 138, 71));
        b10.setFont(new Font("Raleway", Font.PLAIN, 17));
        b10.setFocusable(false);
        b10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b10.addActionListener(this);
        p2.add(b10);

        b11 = new JButton("LogOut");
        b11.setBounds(1400, 20, 100, 34);
        b11.setBackground(new Color(255, 138, 71));
        b11.setFont(new Font("Raleway", Font.PLAIN, 17));
        b11.setFocusable(false);
        b11.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b11.addActionListener(this);
        b11.setVisible(false);
        p2.add(b11);

        JPanel p3 = new JPanel();
        p3.setBounds(20, 120, 1480, 100);
        p3.setBackground(Color.WHITE);
        p3.setLayout(null);
        add(p3);

        ImageIcon img6 = new ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        Image img7 = img6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon img8 = new ImageIcon(img7);
        b1 = new JButton(img8);
        b1.setText("Hotels");
        b1.setBorder(null);
        b1.setMargin(new Insets(0, 0, 0, 0));
        b1.setBounds(55, 25, 130, 50);
        b1.setBackground(new Color(255, 138, 71));
        b1.setFont(new Font("Raleway", Font.BOLD, 18));
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p3.add(b1);

        // ImageIcon imgbutton2 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        // Image imgbutton3 = imgbutton2.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // ImageIcon imgbutton4 = new ImageIcon(imgbutton3);
        b2 = new JButton("Destinations");
        // b2.setText();
        b2.setBounds(415, 25, 130, 50);
        b2.setBorder(null);
        b2.setBackground(new Color(252, 97, 112));
        b2.setFont(new Font("Raleway", Font.BOLD, 18));
        b2.setFocusable(false);
        b2.addActionListener(this);
        // b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p3.add(b2);

        // ImageIcon imgbutton5 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        // Image imgbutton6 = imgbutton5.getImage().getScaledInstance(50, 50,
        // Image.SCALE_DEFAULT);
        // ImageIcon imgbutton7 = new ImageIcon(imgbutton6);
        b3 = new JButton("Book Package");
        // b3.setText("Hotels");
        b3.setBorder(null);
        b3.setBounds(235, 25, 130, 50);
        b3.setBackground(new Color(140, 238, 238));
        b3.setFont(new Font("Raleway", Font.BOLD, 17));
        b3.setFocusable(false);
        b3.addActionListener(this);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p3.add(b3);

        // ImageIcon imgbutton8 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        // Image imgbutton9 = imgbutton8.getImage().getScaledInstance(50, 50,
        // Image.SCALE_DEFAULT);
        // ImageIcon imgbutton10 = new ImageIcon(imgbutton9);
        b4 = new JButton("View Booking");
        // b4.setText("Hotels");
        b4.setBounds(585, 25, 130, 50);
        b4.setBorder(null);
        b4.setBackground(new Color(38, 191, 191));
        b4.setFont(new Font("Raleway", Font.BOLD, 17));
        b4.setFocusable(false);
        b4.addActionListener(this);
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p3.add(b4);

        // ImageIcon imgbutton11 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        // Image imgbutton12 = imgbutton11.getImage().getScaledInstance(50, 50,
        // Image.SCALE_DEFAULT);
        // ImageIcon imgbutton13 = new ImageIcon(imgbutton12);
        b5 = new JButton("Calculator");
        // b5.setText("Hotels");
        b5.setBorder(null);
        b5.setBounds(1275, 25, 130, 50);
        b5.setBackground(new Color(255, 215, 71));
        b5.setFont(new Font("Raleway", Font.BOLD, 17));
        b5.setFocusable(false);
        b5.addActionListener(this);
        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p3.add(b5);

        // ImageIcon imgbutton14 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        // Image imgbutton15 = imgbutton14.getImage().getScaledInstance(50, 50,
        // Image.SCALE_DEFAULT);
        // ImageIcon imgbutton16 = new ImageIcon(imgbutton15);
        b6 = new JButton("Write A Review");
        // b6.setText("Hotels");
        b6.setBorder(null);
        b6.setBounds(1095, 25, 130, 50);
        b6.setBackground(new Color(255, 138, 71));
        b6.setFont(new Font("Raleway", Font.BOLD, 17));
        b6.setFocusable(false);
        b6.addActionListener(this);
        b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p3.add(b6);

        // ImageIcon imgbutton17 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        // Image imgbutton18 = imgbutton17.getImage().getScaledInstance(50, 50,
        // Image.SCALE_DEFAULT);
        // ImageIcon imgbutton19 = new ImageIcon(imgbutton18);
        b7 = new JButton("Update Details");
        b7.setBorder(null);
        b7.setBounds(925, 25, 130, 50);
        b7.setBackground(new Color(252, 97, 112));
        b7.setFont(new Font("Raleway", Font.BOLD, 17));
        b7.setFocusable(false);
        b7.addActionListener(this);
        b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p3.add(b7);

        // ImageIcon imgbutton20 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        // Image imgbutton21 = imgbutton20.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // ImageIcon imgbutton22 = new ImageIcon(imgbutton21);
        b8 = new JButton("Add Details");
        b8.setBounds(755, 25, 130, 50);
        b8.setBorder(null);
        b8.setBackground(new Color(140, 238, 238));
        b8.setFont(new Font("Raleway", Font.BOLD, 17));
        b8.addActionListener(this);
        b8.setBorder(BorderFactory.createEmptyBorder());
        b8.setFocusable(false);
        b8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p3.add(b8);

        JPanel p4 = new JPanel();
        p4.setBounds(0, 225, 1600, 50);
        p4.setLayout(null);
        p4.setBackground(new Color(0, 0, 108));
        add(p4);
        ImageIcon imgbutton23 = new ImageIcon(ClassLoader.getSystemResource("icons/user.png"));
        Image imgbutton24 = imgbutton23.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon imgbutton25 = new ImageIcon(imgbutton24);
        JLabel l5 = new JLabel(imgbutton25);
        l5.setBounds(5, 5, 40, 40);
        p4.add(l5);
        // Adding label in p4 panel
        JLabel l6 = new JLabel("Dashboard");
        l6.setForeground(Color.white);
        l6.setFont(new Font("Tahoma", Font.BOLD, 22));
        l6.setBounds(55, 5, 300, 40);
        p4.add(l6);

        // Creating a new JPanel for main content
        JPanel p5 = new JPanel();
        p5.setBounds(0, 275, 1600, 530);
        p5.setBackground(new Color(0, 0, 108));
        p5.setLayout(null);
        add(p5);

        ImageIcon mainimg = new ImageIcon(
                "C:/Users/12.amanjain/Desktop/travel management system project-20210405T183214Z-001/travel management system project/src/icons/home.jpg");
        Image mainimg1 = mainimg.getImage().getScaledInstance(1600, 530, Image.SCALE_DEFAULT);
        ImageIcon mainimg2 = new ImageIcon(mainimg1);
        JLabel l4 = new JLabel(mainimg2);
        l4.setBounds(0, 0, 1600, 530);
        p5.add(l4);


        rbutton = new JButton("<html>Search your desired Holiday!</html>");
        rbutton.setFont(new Font("Raleway", Font.BOLD, 20));
        rbutton.setForeground(Color.WHITE);
        rbutton.setBorder(null);
        rbutton.setFocusable(false);
        rbutton. setOpaque(false);
        rbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rbutton.setBorder(BorderFactory.createEmptyBorder());
        rbutton.setBorderPainted(false);
        rbutton.setBackground(new Color(0, 0, 108));
        rbutton.setBounds(670, 0, 300, 50);
        p4.add(rbutton);
        rbutton.addActionListener(this);

        JLabel l16 = new JLabel("ChatBot");
        l16.setForeground(Color.white);
        l16.setFont(new Font("Tahoma", Font.BOLD, 20));
        l16.setBounds(1350, 5, 100, 40);
        p4.add(l16);
        ImageIcon icon = new ImageIcon(
                "C:/Users/12.amanjain/Desktop/travel management system project-20210405T183214Z-001/travel management system project/src/icons/chatbot.png");
        Image bot2 = icon.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH);
        ImageIcon bot3 = new ImageIcon(bot2);
        c1 = new JButton(bot3);
        c1.setBorder(null);
        c1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c1.setBorder(BorderFactory.createEmptyBorder());
        c1.addActionListener(this);
        c1.setBackground(new Color(0, 0, 108));
        c1.setBounds(1450, 0, 60, 50);
        p4.add(c1);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b8) {
            if(username!=""){
            new AddCustomer(username).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please Login to see full Details");
            }
        } else if (ae.getSource() == b4) {
            if (username != "") {
                new Viewbooked(username).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please Login to see full Details");
            }
        }else if (ae.getSource() == rbutton) {
            new Recomendation().setVisible(true);
        }

        else if (ae.getSource() == b5) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
            }

        } else if (ae.getSource() == c1) {
            new Chatbot().setVisible(true);

        } else if (ae.getSource() == b7) {
            if(username!=""){
            new updateCustomer(username).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please Login to see full Details");
            }
        } else if (ae.getSource() == b1) {
            new Hotels(username).setVisible(true);
        } else if (ae.getSource() == b2) {
            new Destination().setVisible(true);
        } else if (ae.getSource() == b9) {
            new Login1().setVisible(true);
        } else if (ae.getSource() == b6) {
            new review();
        }

        else if (ae.getSource() == b10) {
            new Signup().setVisible(true);
        } else if (ae.getSource() == b11) {
            username = "";
            b9.setVisible(true);
            b10.setVisible(true);
            user.setVisible(false);

        } else if (ae.getSource() == b3) {
            new CheckPackage(username).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Dashboard("").setVisible(true);
    }

    // Adding login Frame
    public class Login1 extends JFrame implements ActionListener {
        JButton btn1, btn2, btn3;
        JTextField tf1;
        JPasswordField tf2;

        Login1() {
            Font font1 = new Font("Helvetica", Font.PLAIN, 16);

            setLayout(null);

            getContentPane().setBackground(Color.white);

            setBounds(300, 100, 800, 600);

            JPanel p1 = new JPanel();
            p1.setLayout(null);
            p1.setBounds(0, 0, 400, 600);
            add(p1);
            ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/login02.jpg"));
            Image img2 = img1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
            ImageIcon img3 = new ImageIcon(img2);
            JLabel l1 = new JLabel(img3);
            l1.setLayout(null);
            p1.setBackground(Color.white);
            l1.setBounds(0, 0, 400, 600);
            p1.add(l1);

            JPanel p2 = new JPanel();
            p2.setLayout(null);
            p2.setBounds(400, 0, 400, 600);
            p2.setBackground(Color.WHITE);
            add(p2);

            ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("icons/loginlock.png"));
            Image img5 = img4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon img6 = new ImageIcon(img5);
            JLabel l2 = new JLabel(img6);
            l2.setBounds(135, 40, 100, 100);
            p2.add(l2);

            JLabel l3 = new JLabel("USER LOGIN");
            l3.setBounds(90, 150, 200, 30);
            l3.setFont(new Font("San serif", Font.PLAIN, 30));
            l3.setForeground(Color.DARK_GRAY);
            p2.add(l3);

            JLabel l4 = new JLabel("Username:");
            l4.setBounds(60, 230, 100, 20);
            l4.setFont(new Font("San serif", Font.PLAIN, 17));
            l4.setForeground(Color.gray);
            p2.add(l4);
            tf1 = new JTextField();
            tf1.setBounds(60, 250, 250, 30);
            p2.add(tf1);
            tf1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
            tf1.setFont(font1);

            JLabel l5 = new JLabel("Password:");
            l5.setBounds(60, 295, 100, 20);
            l5.setFont(new Font("San serif", Font.PLAIN, 17));
            l5.setForeground(Color.gray);
            p2.add(l5);
            tf2 = new JPasswordField();
            tf2.setBounds(60, 315, 250, 30);
            p2.add(tf2);
            tf2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            tf2.setFont(font1);

            btn1 = new JButton("LOGIN");
            btn1.setBounds(60, 390, 110, 30);
            btn1.setBackground(new Color(102, 163, 255));
            btn1.setForeground(Color.WHITE);
            btn1.addActionListener(this);
            btn1.setFocusable(false);
            btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn1.setBorder(BorderFactory.createEmptyBorder());
            p2.add(btn1);

            btn2 = new JButton("SIGN UP");
            btn2.addActionListener(this);
            btn2.setBackground(new Color(255, 255, 255));
            btn2.setBounds(60, 485, 250, 30);
            btn2.setFocusable(false);
            btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            p2.add(btn2);

            btn3 = new JButton("Forget Password?");
            btn3.setBounds(200, 390, 120, 30);
            btn3.setFont(new Font("Raleway", Font.PLAIN, 13));
            btn3.addActionListener(this);
            btn3.setFocusable(false);
            btn3.setBorder(BorderFactory.createEmptyBorder());
            btn3.setBackground(new Color(255, 255, 255));
            p2.add(btn3);
            btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            setVisible(true);

            JLabel l9 = new JLabel("-------------------------" + " " + "Or" + " " + "---------------------------");
            l9.setBounds(70, 440, 250, 30);
            p2.add(l9);

        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn1) {

                try {

                    String username01 = tf1.getText();
                    String password01 = tf2.getText();
                    String query = "select * from tms where username='" + username01 + "'AND password='" + password01
                            + "'";
                    conn connection = new conn();
                    ResultSet rs = connection.s.executeQuery(query);

                    if (rs.next()) {
                        this.setVisible(false);
                        b9.setVisible(false);
                        username = username01;
                        user.setVisible(true);
                        user.setText("Hii," + " " + username);
                        b10.setVisible(false);
                        b11.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Login");
                    }

                } catch (Exception ae) {

                }

            } else if (e.getSource() == btn2) {
                new Signup().setVisible(true);
                this.setVisible(false);
            } else {
                this.setVisible(false);
                new forgetPassword().setVisible(true);

            }

        }

    }

    class Signup extends JFrame implements ActionListener {

        Random rand = new Random();
        int randomCode = rand.nextInt(999999);
        JLabel l3, l4, l5, l6, l7, l8, l31, l1;
        JButton b1, b2, b3;
        JTextField txn0, txn1, txn2, txn3, txn4;

        Signup() {
            Font font1 = new Font("Helvetica", Font.PLAIN, 16);

            setLayout(null);
            setBounds(300, 100, 900, 680);
            getContentPane().setBackground(Color.WHITE);

            JPanel p1 = new JPanel();
            p1.setBounds(0, 0, 430, 680);
            p1.setBackground(new Color(58, 175, 169));
            p1.setLayout(null);
            add(p1);

            ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("icons/welcome.jpg"));
            Image img5 = img4.getImage().getScaledInstance(430, 680, Image.SCALE_DEFAULT);
            ImageIcon img6 = new ImageIcon(img5);
            JLabel l0 = new JLabel(img6);
            l0.setBounds(0, 0, 430, 680);
            p1.add(l0);

            JPanel p2 = new JPanel();

            p2.setBounds(400, 0, 480, 680);
            p2.setBackground(Color.WHITE);
            p2.setLayout(null);
            add(p2);

            l3 = new JLabel("Hello,");
            l3.setBounds(60, 60, 220, 30);
            l3.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
            p2.add(l3);

            l31 = new JLabel("Let's Create Your Account !");
            l31.setBounds(60, 100, 400, 28);
            l31.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
            p2.add(l31);

            l1 = new JLabel("Already Have an Account?");
            l1.setBounds(60, 135, 200, 25);
            l1.setForeground(Color.gray);
            l1.setBackground(new Color(255, 255, 255));
            l1.setFont(new Font("Raleway", Font.PLAIN, 16));
            p2.add(l1);
            b3 = new JButton("Login Here");
            b3.setLayout(null);
            b3.setForeground(new Color(195, 7, 63));
            b3.setBorder(BorderFactory.createEmptyBorder());
            b3.setBackground(new Color(255, 255, 255));
            b3.setBounds(260, 130, 100, 35);
            b3.setFont(new Font("Raleway", Font.PLAIN, 17));
            p2.add(b3);
            b3.addActionListener(this);
            b3.setFocusable(false);
            b3.setCursor(new Cursor(Cursor.HAND_CURSOR));

            l4 = new JLabel("Username");
            l4.setForeground(Color.gray);
            l4.setBounds(120, 170, 250, 20);
            l4.setFont(new Font("Raleway", Font.PLAIN, 17));
            p2.add(l4);
            txn1 = new JTextField();
            txn1.setBounds(120, 190, 250, 30);
            p2.add(txn1);
            txn1.setFont(font1);
            txn1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

            l5 = new JLabel("Full Name");
            l5.setForeground(Color.gray);
            l5.setBounds(120, 235, 250, 20);
            l5.setFont(new Font("Raleway", Font.PLAIN, 17));
            p2.add(l5);
            txn2 = new JTextField();
            txn2.setFont(font1);
            txn2.setLayout(null);
            txn2.setBounds(120, 255, 250, 30);
            p2.add(txn2);
            txn2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

            l6 = new JLabel("Email");
            l6.setBounds(120, 305, 250, 20);
            l6.setForeground(Color.gray);
            l6.setFont(new Font("Raleway", Font.PLAIN, 17));
            p2.add(l6);
            txn3 = new JTextField();
            txn3.setFont(font1);
            txn3.setBounds(120, 325, 250, 30);
            txn3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
            p2.add(txn3);

            l7 = new JLabel("Password");
            l7.setForeground(Color.gray);
            l7.setBounds(120, 375, 250, 20);
            l7.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
            p2.add(l7);
            txn4 = new JPasswordField();
            txn4.setFont(font1);
            txn4.setBounds(120, 395, 250, 30);
            txn4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            p2.add(txn4);

            b2 = new JButton("SIGNUP");
            b2.setLayout(null);
            b2.addActionListener(this);
            b2.setBounds(145, 455, 200, 30);
            p2.add(b2);
            b2.setBackground(new Color(255, 255, 255));
            b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b2.setFocusable(false);

            l8 = new JLabel("Enter Verification Code");
            l8.setForeground(Color.gray);
            l8.setBounds(120, 500, 220, 25);
            l8.setFont(new Font("Raleway", Font.PLAIN, 17));
            p2.add(l8);
            txn0 = new JTextField();
            txn0.setBounds(120, 530, 250, 30);
            txn0.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
            txn0.setFont(font1);
            p2.add(txn0);

            b1 = new JButton("LOGIN");
            b1.addActionListener(this);
            b1.setLayout(null);
            b1.setBounds(145, 590, 200, 30);
            p2.add(b1);
            b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b1.setBackground(new Color(255, 255, 255));
            b1.setFocusable(false);

            // Setting initial visibility to false
            l8.setVisible(false);
            txn0.setVisible(false);
            b1.setVisible(false);

        }

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == b1) {
                if (Integer.valueOf(txn0.getText()) == randomCode) {
                    String username = txn1.getText();
                    String fullname = txn2.getText();
                    String email = txn3.getText();
                    String password = txn4.getText();

                    String query = "Insert into tms (username,fullname,email,password)values('" + username + "','"
                            + fullname + "','" + email + "','" + password + "')";

                    try {
                        conn c9 = new conn();
                        c9.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Account Created successfully");
                        this.setVisible(false);
                        new Login1().setVisible(true);
                    } catch (Exception ea) {
                        ea.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Entered code is incorrect" + "\n" + "Please, enter the code again");

                }

            } else if (e.getSource() == b2)

            {
                txn0.setVisible(true);
                l8.setVisible(true);
                b1.setVisible(true);

                // Sending mail for Verification
                try {
                    String host = "smtp.gmail.com";
                    String user = "travelmantu.info@gmail.com";
                    String pass = "123@Mantu";
                    String to = txn3.getText();
                    String name = txn2.getText();
                    String subject = "Verify Your Account";
                    String message = "Hi" + " " + name + "," + "\n" + "Your Verification code is=" + " " + randomCode;
                    boolean sessionDebug = false;
                    Properties pros = System.getProperties();
                    pros.put("mail.smtp.starttls.enable", "true");
                    pros.put("mail.smtp.host", "host");
                    pros.put("mail.smtp.port", "587");
                    pros.put("mail.smtp.auth", "true");
                    pros.put("mail.smtp.starttls.required", "true");

                    // java.security.Security.addProvider(new Provider());
                    Session mailSession = Session.getDefaultInstance(pros, null);
                    mailSession.setDebug(sessionDebug);
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(user));
                    InternetAddress[] address = { new InternetAddress(to) };
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setText(message);
                    Transport transport = mailSession.getTransport("smtp");
                    transport.connect(host, user, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    JOptionPane.showMessageDialog(null, "Verification code has been sent to your email");

                } catch (Exception ea) {
                    ea.printStackTrace();

                }

            }

            else {
                this.setVisible(false);
                new Login1().setVisible(true);

            }
        }
    }

    class forgetPassword extends JFrame implements ActionListener {
        Random rand = new Random();
        int randomCode = rand.nextInt(999999);
        JLabel l1, l2, l3, l4, l5, l6, l8;
        JButton b1, b2, b3, b4;
        JTextField txn1, txn2, txn3, txn4, txn5;

        forgetPassword() {
            Font font1 = new Font("Helvetica", Font.PLAIN, 16);
            setLayout(null);
            setBounds(300, 100, 900, 650);
            getContentPane().setBackground(new Color(22, 119, 176));

            // Creating JPanel for image
            JPanel p2 = new JPanel();
            p2.setBounds(0, 0, 450, 650);
            p2.setLayout(null);
            add(p2);

            ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpass.jpg"));
            Image img5 = img4.getImage().getScaledInstance(450, 650, Image.SCALE_DEFAULT);
            ImageIcon img6 = new ImageIcon(img5);
            JLabel l0 = new JLabel(img6);
            l0.setBounds(0, 0, 450, 650);
            p2.add(l0);

            // Creating new JPanel

            JPanel p1 = new JPanel();
            p1.setBounds(450, 0, 450, 650);
            p1.setBackground(new Color(255, 255, 255));
            p1.setLayout(null);
            add(p1);

            l1 = new JLabel("Forget Password?");
            l1.setBounds(25, 50, 300, 35);
            l1.setForeground(new Color(22, 119, 176));
            l1.setFont(new Font("Raleway", Font.BOLD, 30));
            p1.add(l1);

            /*
             * l2=new JLabel("Username"); l2.setForeground(new Color(42, 157, 143 ));
             * l2.setBounds(40, 170, 100, 30); l2.setFont(new Font("Helvetica Neue",
             * Font.PLAIN,18)); p1.add(l2); txn1=new JTextField(); txn1.setBounds(160, 170,
             * 220, 30); p1.add(txn1); b1=new JButton("Search"); b1.setLayout(null);
             * b1.addActionListener(this); b1.setBounds(400, 170, 100, 30); p1.add(b1);
             * b1.setFocusable(false);
             * 
             * 
             * 
             * l3=new JLabel("Full Name"); l3.setForeground(new Color(42, 157, 143 ));
             * l3.setBounds(40, 220, 100, 30); l3.setFont(new Font("Helvetica Neue",
             * Font.PLAIN,18)); p1.add(l3); txn2=new JTextField(); txn2.setEditable(false);
             * txn2.setBounds(160, 220, 220, 30); p1.add(txn2);
             */

            l4 = new JLabel("Enter your Email-ID associated");
            l8 = new JLabel("with your account");
            l8.setBounds(110, 150, 400, 25);
            l4.setForeground(Color.darkGray);
            l4.setBounds(58, 130, 400, 25);
            l4.setFont(new Font("Raleway", Font.PLAIN, 20));
            l8.setFont(new Font("Raleway", Font.PLAIN, 20));
            l4.setForeground(Color.darkGray);
            p1.add(l8);
            p1.add(l4);
            txn3 = new JTextField();
            txn3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            txn3.setBounds(75, 200, 250, 30);
            txn3.setFont(font1);
            p1.add(txn3);

            // Creating Send Verification Button

            b2 = new JButton("Send Verification code");
            b2.setLayout(null);
            b2.setBackground(Color.WHITE);
            b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b2.addActionListener(this);
            b2.setBounds(100, 270, 200, 30);
            p1.add(b2);
            b2.setFocusable(false);

            // Creating EnterCode text and verify button
            l5 = new JLabel("Enter code");
            l5.setForeground(Color.DARK_GRAY);
            l5.setBounds(75, 330, 100, 20);
            l5.setFont(new Font("Raleway", Font.PLAIN, 17));
            p1.add(l5);
            txn4 = new JTextField();
            txn4.setBounds(75, 355, 250, 30);
            txn4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            txn4.setFont(font1);
            p1.add(txn4);

            // Creating Verification code Button
            b4 = new JButton("Verify code");
            b4.setLayout(null);
            b4.addActionListener(this);
            b4.setBackground(Color.white);
            b4.setBounds(100, 410, 200, 30);
            p1.add(b4);
            b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b4.setFocusable(false);

            l6 = new JLabel("Enter New password");
            l6.setForeground(Color.DARK_GRAY);
            l6.setBounds(75, 455, 200, 20);
            l6.setFont(new Font("Raleway", Font.PLAIN, 17));
            p1.add(l6);
            txn5 = new JPasswordField();
            txn5.setBounds(75, 485, 250, 30);
            txn5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            txn5.setFont(font1);
            p1.add(txn5);

            b3 = new JButton("Login to your Account");
            b3.setLayout(null);
            b3.addActionListener(this);
            b3.setBounds(100, 540, 200, 30);
            p1.add(b3);
            b3.setBackground(Color.WHITE);
            b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b3.setFocusable(false);

            // Setting the initial visibility to false
            l5.setVisible(false);
            txn4.setVisible(false);
            b4.setVisible(false);

            txn5.setVisible(false);
            l6.setVisible(false);
            b3.setVisible(false);

        }

        // abstract method calling
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == b1) {
                /*
                 * conn c3=new conn(); String cuser=new String(); String cname=new String();
                 * String cemail=new String();
                 * 
                 * try { String search="select * from tms where username='"+txn1.getText()+"'";
                 * ResultSet rs=c3.s.executeQuery(search);
                 * 
                 * while(rs.next()) { cname=rs.getString("fullname");
                 * cemail=rs.getString("email"); cuser=rs.getString("username");
                 * 
                 * } if(cuser.equals(txn1.getText())){ txn2.setText(cname);
                 * txn3.setText(cemail); } else{ JOptionPane.showMessageDialog(null,
                 * "User does not Exist"); }
                 * 
                 * 
                 * } catch (Exception ae) { }
                 */

            } else if (e.getSource() == b2) {

                try {
                    // code for connection with database
                    conn c3 = new conn();
                    String cuser = new String();
                    String cname = new String();
                    String cemail = new String();

                    String search = "select * from tms where email='" + txn3.getText() + "'";
                    ResultSet rs = c3.s.executeQuery(search);

                    while (rs.next()) {
                        cname = rs.getString("fullname");
                        cuser = rs.getString("username");
                        cemail = rs.getString("email");

                    }
                    // code for email verification

                    String host = "smtp.gmail.com";
                    String user = "travelmantu.info@gmail.com";
                    String pass = "Mantu@123";
                    String to = cemail;
                    String name = cname;
                    String subject = "Reset Your Password";
                    String message = "Hi" + " " + name + "," + "\n" + "Your reset code is=" + " " + randomCode;
                    boolean sessionDebug = false;
                    Properties pros = System.getProperties();
                    pros.put("mail.smtp.starttls.enable", "true");
                    pros.put("mail.smtp.host", "host");
                    pros.put("mail.smtp.port", "587");
                    pros.put("mail.smtp.auth", "true");
                    pros.put("mail.smtp.starttls.required", "true");

                    // java.security.Security.addProvider(new Provider());
                    Session mailSession = Session.getDefaultInstance(pros, null);
                    mailSession.setDebug(sessionDebug);
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(user));
                    InternetAddress[] address = { new InternetAddress(to) };
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setText(message);
                    Transport transport = mailSession.getTransport("smtp");
                    transport.connect(host, user, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    JOptionPane.showMessageDialog(null, "Code has been sent to your email");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "User does not exist");
                }
                l5.setVisible(true);
                txn4.setVisible(true);
                b4.setVisible(true);

            } else if (e.getSource() == b3) {

                String mail = txn3.getText();
                String updatedPass = txn5.getText();
                String updateQuery = "UPDATE tms SET password='" + updatedPass + "' WHERE email='" + mail + "'";
                try {
                    conn c2 = new conn();
                    c2.s.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "Password changed successfully");
                    new Login1().setVisible(true);
                    this.setVisible(false);

                } catch (Exception exception) {

                }

            }

            else if (e.getSource() == b4) {
                if (Integer.valueOf(txn4.getText()) == randomCode) {

                    txn5.setVisible(true);
                    l6.setVisible(true);
                    b3.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Verification Code");

                }

            }

        }

    }
}
