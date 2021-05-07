import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.TableCellRenderer;

class Hoteltable extends JFrame implements ActionListener {
    Font font1 = new Font("Helvetica", Font.PLAIN, 24);
    Font font2 = new Font("Helvetica", Font.PLAIN, 16);
    JTable jTable1;
    JButton b1;
    String username;
    // DefaultTableModel model;

    Hoteltable(String location,String username) {
        this.username=username;

        getContentPane().setBackground(Color.white);
        setBounds(240, 30, 1200, 750);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 30, 1200, 750);
        p1.setBackground(new Color(255, 255, 255));
        add(p1);
        p1.setLayout(new FlowLayout());
        DefaultTableModel model = new DefaultTableModel() {
            // int column=4;
            // int row=jTable1.getSelectedRow();
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return true;

            }

            
        };

        // Setting the properties of JTable and DefaultTableModel
        jTable1 = new JTable(model);
        model = (DefaultTableModel) jTable1.getModel();

        Object[] newIdentifiers = new Object[] { "Hotel Image", "Hotel Name", "Star Rating", "Location", "Hotel's Price/night","Book Hotel" };
        model.setColumnIdentifiers(newIdentifiers);
        jTable1.setFillsViewportHeight(true);
        p1.add(new JScrollPane(jTable1));
        jTable1.setPreferredScrollableViewportSize(new Dimension(1000, 600));
        jTable1.getColumn("Hotel Image").setCellRenderer(new CellRenderer());
        // jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.setFont(new Font("Raleway", Font.PLAIN, 17));
        jTable1.getTableHeader().setFont(new Font("Raleway", Font.BOLD, 18));
        jTable1.setCellSelectionEnabled(true);
        jTable1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // centering the contents
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTable1.getColumn("Book Hotel").setCellRenderer(new ButtonRenderer());jTable1.getColumn("Book Hotel").setCellEditor(new ButtonEditor(this));  

        try {

            // Storing MySQL query in A string variable
            String query = "select * from sampledb where Location='" + location + "'";

            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery(query);

            while (rs.next()) {
                String Hname = rs.getString("Hotel Name");
                String Hrating = rs.getString("Star Rating");
                String Hlocation = rs.getString("Location");
                String Hprice = rs.getString("Hotel's Price/Night");
                byte[] imagedata = rs.getBytes("Hotel Image");


                // String selectedImagePath=rs.getString("Hotel Image");
                JLabel imageLabel = new JLabel();
                ImageIcon imageicon = new ImageIcon(imagedata);
                Image img = imageicon.getImage().getScaledInstance(180, 175, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));

                if (Hlocation.equals(location)) {
                    model.addRow(new Object[] { imageLabel,Hname, Hrating, Hlocation, Hprice});

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid city name");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   class ButtonRenderer implements TableCellRenderer
   {   
        JButton button;   
        boolean enabled = true;   
         
        public ButtonRenderer() 
        {   
            button = new JButton(); 
        }   
         
        public Component getTableCellRendererComponent(JTable table,   
                                                       Object value,   
                                                       boolean isSelected,   
                                                       boolean hasFocus,   
                                                       int row, int column) {    
            button.setText("Book Hotel");   
            button.setEnabled(enabled); 
            button.setBackground(Color.white);
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setFont(new Font("Raleway", Font.BOLD,17));
           
            return button;   
        };   
         
        public void setEnabled(boolean enabled) {   
            this.enabled = enabled;   
        } 

        


    } 

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {   
    JButton button;   
    boolean enabled = true;   
    int clickCountToStart = 1;   
     
    public ButtonEditor(ActionListener al) {   
        button = new JButton();   
        button.addActionListener(this);   
        button.addActionListener(al);     
    }   
     
    public Component getTableCellEditorComponent(JTable table,   
                                                 Object value,   
                                                 boolean isSelected,   
                                                 int row, int column) {   
        String text = (String)value;     
        button.setActionCommand(text);   
        button.setEnabled(enabled); 
        
        return button;   
    }   
     
    public void setEnabled(boolean enabled) {   
        this.enabled = enabled;   
    }   
     
    public Object getCellEditorValue() {   
        return button.getText();   
    }   
     
    public boolean isCellEditable(EventObject anEvent) {   
        if (anEvent instanceof MouseEvent) {   
            return ((MouseEvent)anEvent).getClickCount() >= clickCountToStart;   
        }   
        return true;   
    }   
     
    public void actionPerformed(ActionEvent e) {   
        super.stopCellEditing();   
        if(e.getSource()==button){
            int column = 1;
            int row = jTable1.getSelectedRow();
            String value = jTable1.getModel().getValueAt(row, column).toString();
            //this.setVisible(false);
            this.enabled=false;

            new BookPackage(username, value).setVisible(true);
            
        }
    }  
}  
 

    

    class CellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) 
        {

            TableColumn tb = jTable1.getColumn("Hotel Image");
            tb.setMaxWidth(180);
            tb.setMinWidth(180);
            jTable1.setRowHeight(180);

            return (Component) value;
        }
    }

    

    public static void main(String[] args) {
        new Hoteltable("","").setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        
        

    }

    
}
