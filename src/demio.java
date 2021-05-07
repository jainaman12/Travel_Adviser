import javax.swing.*;
import java.awt.*;


class demio extends JFrame{
    JComboBox c1;
    demio(){
    setTitle("Search Hotels");
    setLayout(new GridBagLayout());
    setBounds(100,100,500,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JLabel background = new JLabel(new ImageIcon("C:/Users/Dewa/Desktop/travel management system project/src/icons/travel1.jpg"));
    background.setLayout(new BorderLayout());
    add(background);

    JLabel label = new JLabel("I'm on fire");
    label.setFont(label.getFont().deriveFont(Font.BOLD, 48));
    label.setForeground(Color.WHITE);
    label.setHorizontalAlignment(JLabel.CENTER);
    background.add(label);

    c1 = new JComboBox<>(new String[] { "Delhi", "Haldwani", "Hyderabad", "Mumbai","Goa","Assam" });
    c1.setBounds(120, 200, 250, 30);
    background.add(c1);

    c1.setFocusable(false);

    
    }



    public static void main(String[] args) {
        new demio().setVisible(true);
    }

}
