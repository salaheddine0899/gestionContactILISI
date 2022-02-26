package ma.fstm.ilisi2.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi2.controllers.ContactController;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage extends JFrame {

	private JPanel contentPane;
	private JLabel msg;
	private JFrame context=this;

	public JLabel getMsg() {
		return msg;
	}

	public void setMsg(JLabel msg) {
		this.msg = msg;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		msg = new JLabel("");
		msg.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg.setBounds(22, 39, 391, 69);
		contentPane.add(msg);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactController ctrl=new ContactController();
				ctrl.backHome();
				context.dispose();
			}
		});
		btnNewButton.setBounds(151, 164, 89, 23);
		contentPane.add(btnNewButton);
	}

}
