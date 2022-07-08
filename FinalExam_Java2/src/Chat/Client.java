package Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtport;
	private JTextField txthost;
	private JTextField txtsend;
	private ChatMessageSocket cmsocket;
	JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 606, 343);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Port:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 60, 25);
		panel.add(lblNewLabel);
		
		txtport = new JTextField();
		txtport.setBounds(80, 10, 96, 25);
		panel.add(txtport);
		txtport.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Host:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(229, 10, 60, 25);
		panel.add(lblNewLabel_1);
		
		txthost = new JTextField();
		txthost.setBounds(299, 10, 130, 25);
		panel.add(txthost);
		txthost.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String host = txthost.getText();
				int port = Integer.parseInt(txtport.getText());
				try {
					Socket s = new Socket(host, port);
					cmsocket = new ChatMessageSocket(s, textPane);
					textPane.setText(textPane.getText() + "Connected!!!");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnConnect.setFont(new Font("Arial", Font.PLAIN, 16));
		btnConnect.setBounds(481, 8, 115, 29);
		panel.add(btnConnect);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 66, 586, 192);
		panel.add(textPane);
		
		JLabel lblNewLabel_2 = new JLabel("Message:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 292, 90, 41);
		panel.add(lblNewLabel_2);
		
		txtsend = new JTextField();
		txtsend.setBounds(110, 292, 365, 41);
		panel.add(txtsend);
		txtsend.setColumns(10);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtsend.getText().equals("") == false) {
					cmsocket.send(txtsend.getText());
				}
				txtsend.setText("");
			}
		});
		btnSend.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSend.setBounds(481, 292, 115, 41);
		panel.add(btnSend);
	}
}
