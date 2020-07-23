package common.Expression;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Expression_Checker extends JFrame {

	private JTextField textField;
	private JTextArea textArea;
	public StackBrackets stackBrackets = new StackBrackets();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Expression_Checker frame = new Expression_Checker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Expression_Checker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Expression Checker");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				String in = textField.getText();
        		char[] exp = new char[in.length()];
        		for (int i = 0; i < in.length(); i++)
           			 exp[i] = in.charAt(i);
				 boolean check = stackBrackets.checkBrackets(exp);
				textArea.append("Expression:- " + in);
				textArea.append("\n");
				if(check) {
					textArea.append("Result:- Balanced");
				 }
				 else{
					textArea.append("Result:- Not Balanced");
				 }
			}
		});
		btnNewButton.setBounds(10, 100, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 100, 89, 23);
		panel.add(btnExit);
		
		textField = new JTextField();
		textField.setBounds(171, 27, 253, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Response:-");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(192, 101, 76, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expression:-");
		lblNewLabel_1.setBounds(27, 35, 100, 23);
		panel.add(lblNewLabel_1);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 134, 414, 111);
		textArea.setEditable(false);
//        JScrollPane scroll = new JScrollPane (textArea);
//        scroll.setBounds(10,390,505,140);
//        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(textArea);
	}
}
