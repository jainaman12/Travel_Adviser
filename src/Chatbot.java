import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Chatbot extends JFrame {

	JTextArea ca;
	private JTextField cf = new JTextField();
	JButton b;

	Chatbot() {
		// Layout and Properties defined in Constructer

		setBounds(1100, 400, 400, 400);
		setLayout(null);
		JPanel f = new JPanel();
		// f.setResizable(false);
		f.setLayout(null);
		f.setBounds(0, 0, 400, 400);
		f.setBackground(Color.cyan);
		add(f);

		// f.setTitle("ChatBot");
		ca = new JTextArea();
		ca.setText("Hello!! Welcome to TRAVEL MANTU," + "\n" + "How may I help you?");
		ca.setSize(395,310);
		//ca.setLocation(1, 1);
		ca.setFont(new Font("Raleway", Font.PLAIN, 16));
		ca.setBackground(Color.WHITE);
		ca.setEditable(false);
		// JScrollPane scroll = new JScrollPane(ca);

		// // scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// //middlepane.add(scroll);

		f.add(ca);

		f.add(cf);

		// f.add(new JScrollPane(ca));
		cf.setSize(300, 30);
		cf.setLocation(1, 320);
		b = new JButton("SEND");
		b.setBounds(300, 320, 90, 30);
		f.add(b);

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == b) { // Message sents on Click button

					String text = cf.getText().toLowerCase();
					ca.setForeground(Color.BLACK);

					ca.append("\n" + "                                        " + "You: " + text + "\n");
					cf.setText("");

					if (text.contains("hi")) { // input Checking
						replyMeth("Hi there");
					} else if (text.contains("hello")) {
						replyMeth("hi ,I'm Good :).Thankyou for asking");
					} else if (text.contains("how are you")) {
						replyMeth("I'm Good :).Thankyou for asking");
					} else if (text.contains("your name")) {
						replyMeth("I'm the Travel Mantu chatbot");
					}

					else if (text.contains("contact details")) {
						replyMeth("You can contact us:"+"\n"+"travelmantu.info@gmail.com");

					}
					else if (text.contains("please give contact details")) {
						replyMeth("You can contact us:"+"\n"+"travelmantu.info@gmail.com");} 
					else if (text.contains("bye")) {
						replyMeth("Bye! Feel free to contact again");
					} else
						replyMeth("Sorry , I Can't Understand");

				}

			}

		});

	}

	public void replyMeth(String s) { // Reply Method
		ca.append("ChatBot :" + s + "\n");

	}

	// Driver Class

	public static void main(String[] args) { // main class

		new Chatbot().setVisible(true); // instantiation
	}

}
