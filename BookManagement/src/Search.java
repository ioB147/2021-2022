import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.awt.event.ActionEvent;

public class Search {

	private JFrame frame;
	private JTextField txtid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public Search() {
		initialize();
		connect();
	}

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void connect() 
	{
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-B180HJK\\KEN;databaseName=BookManagement;user=sa;password=Phuc11@5");
			System.out.println("Connection success.");
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 931, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 255));
		panel.setBounds(29, 29, 854, 586);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(93, 30, 119, 40);
		panel.add(lblNewLabel);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtid.setBounds(210, 30, 208, 40);
		panel.add(txtid);
		txtid.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBounds(81, 112, 694, 420);
		panel.add(table);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					pstmt = conn.prepareStatement("SELECT studentid, studentname, book, bookpart FROM Sales WHERE studentid ='"+txtid.getText()+"'");
					rs = pstmt.executeQuery();
					
					ResultSetMetaData rsd = rs.getMetaData();
					int c;
					
					c = rsd.getColumnCount();
					DefaultTableModel d = (DefaultTableModel)table.getModel();
					d.setRowCount(0);
					
					while (rs.next())
					{
						Vector v2 = new Vector();
						for (int i=1; i<=c; i++)
						{
								v2.add(rs.getString("studentid"));
								v2.add(rs.getString("studentname"));
								v2.add(rs.getString("book"));
								v2.add(rs.getString("bookpart"));
										
						}
						d.addRow(v2);
					}
					
				}
				catch (SQLException ex) {
					java.util.logging.Logger.getLogger(Bookpart.class.getName()).log(Level.SEVERE, null, ex);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(454, 30, 98, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(129, 80, 83, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(285, 80, 119, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Book");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(505, 80, 83, 34);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Book Part");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(648, 80, 83, 34);
		panel.add(lblNewLabel_1_2_1);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuit.setBounds(750, 30, 83, 40);
		panel.add(btnQuit);
	}
	
	public void setVisible() 
	{
		frame.setVisible(true);
	}
	
	
}
