import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 102, 255));
		frame.setBounds(100, 100, 638, 661);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(87, 70, 456, 515);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book b = new Book();
				b.setVisible();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(151, 49, 150, 66);
		panel.add(btnNewButton);
		
		JButton btnBookPart = new JButton("Book Part");
		btnBookPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Bookpart bpart = new Bookpart();
				bpart.setVisible();
				
			}
		});
		btnBookPart.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBookPart.setBounds(151, 138, 150, 66);
		panel.add(btnBookPart);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentSales sale = new StudentSales();
				sale.setVisible();
				
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStudent.setBounds(151, 232, 150, 66);
		panel.add(btnStudent);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Search search = new Search();
				search.setVisible();
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(151, 323, 150, 66);
		panel.add(btnSearch);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login login = new Login();
				login.setVisible();
				frame.setVisible(false);
				
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(151, 412, 150, 66);
		panel.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Book Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(175, 10, 329, 67);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void setVisible() 
	{
		frame.setVisible(true);
	}

}
