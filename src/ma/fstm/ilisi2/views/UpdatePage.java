package ma.fstm.ilisi2.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi2.controllers.ContactController;
import ma.fstm.ilisi2.models.bo.Contact;

public class UpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField phone;
	private JFrame context=this;
	ContactController ctrl=new ContactController();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePage frame = new UpdatePage(new Contact());
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
	public UpdatePage(Contact contact) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setBounds(34, 32, 63, 14);
		contentPane.add(lblNewLabel);
		
		firstName = new JTextField();
		firstName.setBounds(122, 29, 86, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		firstName.setText(contact.getFirstName());
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setBounds(34, 68, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		lastName = new JTextField();
		lastName.setBounds(122, 65, 86, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);
		lastName.setText(contact.getLastName());
		
		JLabel lblNewLabel_2 = new JLabel("phone");
		lblNewLabel_2.setBounds(34, 100, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		phone = new JTextField();
		phone.setBounds(122, 97, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		phone.setText(contact.getPhone());
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.updateContact(contact.getId(),firstName.getText(), lastName.getText(), phone.getText());
				context.dispose();
				
			}
		});
		btnNewButton.setBounds(119, 139, 89, 23);
		contentPane.add(btnNewButton);
	}

}
