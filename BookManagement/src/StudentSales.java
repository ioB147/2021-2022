import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.System.Logger;

public class StudentSales {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtid;
	private JComboBox txtbname;
	private JComboBox txtbpart;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSales window = new StudentSales();
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
	public StudentSales() {
		initialize();
		connect();
		Book();
		Sales_load();
	}
	
	Connection conn;
	//for book
	PreparedStatement pstmt;
	ResultSet rs;
	//for part
	PreparedStatement pstmt1;
	ResultSet rs1;
	
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
	
	public void Book()
	{
		try {
			pstmt = conn.prepareStatement("SELECT * FROM Book");
			rs = pstmt.executeQuery();
			
			txtbname.removeAllItems();
			
			while (rs.next())
			{
				txtbname.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void Sales_load()
	{
		try
		{
			pstmt = conn.prepareStatement("Select * From Sales");
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
					v2.add(rs.getString("id"));
						v2.add(rs.getString("studentid"));
						v2.add(rs.getString("studentname"));
							v2.add(rs.getString("book"));
							v2.add(rs.getString("bookpart"));
								
				}
				d.addRow(v2);
			}
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 978, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentSales = new JLabel("Student Sales");
		lblStudentSales.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblStudentSales.setBounds(363, 10, 278, 86);
		frame.getContentPane().add(lblStudentSales);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(153, 102, 255));
		panel.setBounds(11, 173, 443, 402);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 27, 107, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Part");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(30, 245, 97, 40);
		panel.add(lblNewLabel_1_1);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtname.setColumns(10);
		txtname.setBounds(153, 82, 252, 32);
		panel.add(txtname);
		
		txtbpart = new JComboBox();
		txtbpart.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtbpart.setBounds(153, 245, 195, 29);
		panel.add(txtbpart);
		
		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					pstmt = conn.prepareStatement("Insert into Sales values('"+txtid.getText()+"','"+txtname.getText()+"','"+txtbname.getSelectedItem().toString()+"','"+txtbpart.getSelectedItem().toString()+"')");
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Record added.");
						Sales_load();
						
						txtid.setText("");
						txtname.setText("");
						
						txtbname.setSelectedIndex(-1);
						txtbpart.setSelectedIndex(-1);
						
					}else 
					{
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnadd.setBounds(30, 312, 76, 47);
		panel.add(btnadd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel d1 = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				try {
					pstmt = conn.prepareStatement("UPDATE Sales SET studentid ='"+txtid.getText()+"',studentname ='"+txtname.getText()+"',book ='"+txtbname.getSelectedItem().toString()+"',bookpart ='"+txtbpart.getSelectedItem().toString()+"' WHERE id = "+Integer.parseInt(d1.getValueAt(selectIndex, 0).toString()));
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Updated!");
						Sales_load();
						txtid.setText("");
						txtname.setText("");
						
					
						txtbname.setSelectedIndex(-1);
						txtbpart.setSelectedIndex(-1);
						
						
						btnadd.setEnabled(true);
					}else 
					{
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEdit.setBounds(138, 312, 70, 47);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel d1 = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				try {
					pstmt = conn.prepareStatement("DELETE FROM Sales WHERE id = "+Integer.parseInt(d1.getValueAt(selectIndex, 0).toString()));
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Record deleted.");
						Sales_load();
						
						txtid.setText("");
						txtname.setText("");
						txtbname.setSelectedIndex(-1);
						txtbpart.setSelectedIndex(-1);
						
						
						btnadd.setEnabled(true);
					}else 
					{
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(240, 312, 77, 47);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(340, 312, 89, 47);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Student Name");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(20, 77, 127, 40);
		panel.add(lblNewLabel_1_2);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid.setColumns(10);
		txtid.setBounds(153, 32, 252, 32);
		panel.add(txtid);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Book");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(30, 177, 97, 40);
		panel.add(lblNewLabel_1_1_1);
		
		txtbname = new JComboBox();
		txtbname.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				try {
					pstmt1 = conn.prepareStatement("SELECT * FROM BookPart WHERE bookname = '"+txtbname.getSelectedItem().toString()+"'");
					rs1 = pstmt1.executeQuery();
					
					txtbpart.removeAllItems();
					while (rs1.next())
					{
						txtbpart.addItem(rs1.getString(3));
					}
				} catch (SQLException ex) {
					java.util.logging.Logger.getLogger(StudentSales.class.getName()).log(Level.SEVERE, null, ex);
				}
				
			}
		});
		txtbname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtbname.setBounds(153, 183, 195, 29);
		panel.add(txtbname);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 102, 255));
		panel_1.setBounds(464, 109, 495, 525);
		frame.getContentPane().add(panel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel d1 = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
				txtid.setText(d1.getValueAt(selectIndex, 1).toString());
				txtname.setText(d1.getValueAt(selectIndex, 2).toString());
				txtbname.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
				txtbpart.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
				
				
				btnadd.setEnabled(false); 
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Student ID", "Student Name", "Book Name", "Book Part"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBounds(9, 59, 476, 456);
		panel_1.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(77, 12, 86, 37);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Student Name");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(173, 12, 119, 37);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Book Name");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(303, 12, 96, 37);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Book Part");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(409, 12, 86, 37);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("ID");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(23, 12, 31, 37);
		panel_1.add(lblNewLabel_2_2);
	}
	
	public void setVisible() 
	{
		frame.setVisible(true);
	}
	
}
