package ma.fstm.ilisi2.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi2.controllers.ContactController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameContact extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField phone;
	private JFrame context=this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameContact frame = new FrameContact();
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
	public FrameContact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setBounds(34, 32, 63, 14);
		contentPane.add(lblNewLabel);
		
		firstName = new JTextField();
		firstName.setBounds(122, 29, 86, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setBounds(34, 68, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		lastName = new JTextField();
		lastName.setBounds(122, 65, 86, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("phone");
		lblNewLabel_2.setBounds(34, 100, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		phone = new JTextField();
		phone.setBounds(122, 97, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactController ctrl=new ContactController();
				Boolean res=ctrl.addContact(firstName.getText(), lastName.getText(), phone.getText());
				if(res)
					context.dispose();
				else
					JOptionPane.showMessageDialog(context, "please enter a phone number");
				
			}
		});
		btnNewButton.setBounds(119, 139, 89, 23);
		contentPane.add(btnNewButton);
	}
}
