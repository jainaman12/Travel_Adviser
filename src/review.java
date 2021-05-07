import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.sql.*;


class review extends JFrame implements ActionListener{
    JButton b;
    JRadioButtonMenuItem r1,r2,r3,r4,r5;
    JTextField tf1,tf2,tf3;
    JTextArea tf4;
    JFrame f;

    review(){
 

         f= new JFrame("Feedback/Quries");
            
        JPanel panel=new JPanel();  
        panel.setBounds(0, 0, 500, 40);    
        panel.setBackground(new Color(213, 134, 145, 123));
        
        JLabel l1=new JLabel("Feedback/Qurey Form");
        l1.setFont(new Font("San serif", Font.BOLD,15));
        panel.add(l1);

        JLabel l2 = new JLabel("Username:");
        l2.setFont(new Font("San serif", Font.BOLD,12));
        l2.setBounds(20, 60, 100, 25);
        f.add(l2);

         tf1 = new JTextField();
        tf1.setBounds(150, 60, 150, 25);
        f.add(tf1);

        JLabel l3 = new JLabel("Email Id:");
        l3.setFont(new Font("San serif", Font.BOLD,12));
        l3.setBounds(20, 100, 100, 25);
        f.add(l3);

         tf2 = new JTextField();
        tf2.setBounds(150, 100, 150, 25);
        f.add(tf2);

        JLabel l4 = new JLabel("Subject:");
        l4.setFont(new Font("San serif", Font.BOLD,12));
        l4.setBounds(20, 140, 100, 25);
        f.add(l4);

         tf3 = new JTextField();
        tf3.setBounds(150, 140, 150, 25);
        f.add(tf3);

        JLabel l5 = new JLabel("Your Feedback/Query");
        l5.setFont(new Font("San serif", Font.BOLD,12));
        l5.setBounds(20, 180, 150, 25);
        f.add(l5);

         tf4 = new JTextArea();
        tf4.setBounds(150, 180, 300, 100);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        tf4.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
        f.add(tf4);

        JLabel l6 = new JLabel("Your Overall Experience:");
        l6.setFont(new Font("San serif", Font.BOLD,12));
        l6.setBounds(20, 300, 150, 25);
        f.add(l6);
        JLabel l7 = new JLabel("Rating/star:");
        l7.setFont(new Font("San serif", Font.BOLD,12));
        l7.setBounds(20, 315, 150, 25);
        f.add(l7);

         r1 = new JRadioButtonMenuItem("1");
         r2 = new JRadioButtonMenuItem("2");
         r3 = new JRadioButtonMenuItem("3");
         r4 = new JRadioButtonMenuItem("4");
         r5 = new JRadioButtonMenuItem("5");
        r1.setBounds(170, 300, 40, 40);
        r2.setBounds(210, 300, 40, 40);
        r3.setBounds(250, 300, 40, 40);
        r4.setBounds(290, 300, 40, 40);
        r5.setBounds(330, 300, 40, 40);
        f.add(r1);
        f.add(r2);
        f.add(r3);
        f.add(r4);
        f.add(r5);

         b = new JButton("SUBMIT");
        b.setBounds(200, 370, 100, 40);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        f.add(b);

        b.addActionListener(this);





        f.add(panel);  
                f.setBounds(550,250,500,500); 
                f.getContentPane().setBackground(Color.WHITE); 
                f.setLayout(null);    
                f.setVisible(true);  
   
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            try {
                String name = tf1.getText();
                String email = tf2.getText();
                String subject = tf3.getText();
                String message = tf4.getText();

                String rb=" ";
                if (r1.isSelected()) {
                     rb = "1";
                }
  
                else if (r2.isSelected()) {
                    rb = "2";
                }
                else if(r3.isSelected()){
                    rb = "3";
                }
                else if(r4.isSelected()){
                    rb = "4";
                }
                else{
                    rb = "5";
                }
                String query = "Insert Into review values('"+name+"','"+email+"','"+subject +"','"+message+"','"+rb+"')";
                conn c = new conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Thank you for your valuable review");
                f.setVisible(false);
                

            } catch (Exception ae) {
                //TODO: handle exception
            }
            
        }
        
    }
    public static void main(String[] args){
        new review();

    }
}
