import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bookpart extends javax.swing.JFrame {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookpart window = new Bookpart();
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
	public Bookpart() {
		initialize();
		connect();
		bookpart_load();
		Book();
	}

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	private JComboBox txtbname;
	private JComboBox txtbpart;
	
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
	
	
	public void bookpart_load()
	{
		try
		{
			pstmt = conn.prepareStatement("Select * From BookPart");
			rs = pstmt.executeQuery();
			
			ResultSetMetaData rsd = rs.getMetaData();
			int c;
			
			c = rsd.getColumnCount();
			DefaultTableModel d = (DefaultTableModel) table.getModel();
			d.setRowCount(0);
			
			while (rs.next())
			{
				Vector v2 = new Vector();
				for (int i=1; i<=c; i++)
				{
					v2.add(rs.getString("id"));
						v2.add(rs.getString("bookname"));
							v2.add(rs.getString("bookpart"));
								v2.add(rs.getString("status"));
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
		frame.setBounds(100, 100, 914, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Part");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(37, 10, 205, 86);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(153, 102, 255));
		panel.setBounds(20, 159, 373, 350);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Part");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 81, 107, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Status");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(20, 139, 97, 40);
		panel.add(lblNewLabel_1_1);
		
		JComboBox txtstatus = new JComboBox();
		txtstatus.setModel(new DefaultComboBoxModel(new String[] {"Active", "Deactive"}));
		txtstatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtstatus.setBounds(127, 145, 195, 29);
		panel.add(txtstatus);
		
		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					pstmt = conn.prepareStatement("Insert into BookPart values('"+txtbname.getSelectedItem().toString()+"','"+txtbpart.getSelectedItem().toString()+"','"+txtstatus.getSelectedItem().toString()+"')");
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Bookpart created.");
						
						txtbname.setSelectedIndex(-1);
						txtbpart.setSelectedIndex(-1);
						txtstatus.setSelectedIndex(-1);
						
						bookpart_load();
						
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
		btnadd.setBounds(10, 243, 76, 47);
		panel.add(btnadd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel d1 = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				try {
					pstmt = conn.prepareStatement("UPDATE BookPart SET bookname ='"+txtbname.getSelectedItem().toString()+"',bookpart ='"+txtbpart.getSelectedItem().toString()+"',status ='"+
				txtstatus.getSelectedItem().toString()+"' WHERE id = "+Integer.parseInt(d1.getValueAt(selectIndex, 0).toString()));
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Bookpart updated.");
						
						txtbname.setSelectedIndex(-1);
						txtbpart.setSelectedIndex(-1);
						txtstatus.setSelectedIndex(-1);
						
						bookpart_load();
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
		btnEdit.setBounds(96, 243, 70, 47);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel d1 = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				try {
					pstmt = conn.prepareStatement("DELETE FROM BookPart WHERE id = "+Integer.parseInt(d1.getValueAt(selectIndex, 0).toString()));
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Bookpart deleted.");
						
						txtbname.setSelectedIndex(-1);
						txtbpart.setSelectedIndex(-1);
						txtstatus.setSelectedIndex(-1);
						
						bookpart_load();
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
		btnDelete.setBounds(188, 243, 77, 47);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(275, 243, 89, 47);
		panel.add(btnCancel);
		
		txtbname = new JComboBox();
		txtbname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtbname.setBounds(127, 27, 195, 29);
		panel.add(txtbname);
		
		JLabel lblNewLabel_1_2 = new JLabel("Book Name");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(20, 19, 107, 40);
		panel.add(lblNewLabel_1_2);
		
		txtbpart = new JComboBox();
		txtbpart.setModel(new DefaultComboBoxModel(new String[] {"Part 1", "Part 2", "Part 3", "Part 4", "Part 5"}));
		txtbpart.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtbpart.setBounds(127, 89, 195, 29);
		panel.add(txtbpart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 102, 255));
		panel_1.setBounds(430, 83, 460, 500);
		frame.getContentPane().add(panel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel d1 = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
				txtbname.setSelectedItem(d1.getValueAt(selectIndex, 1).toString());
				txtbpart.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
				txtstatus.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
				
				btnadd.setEnabled(false); 
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Book Name", "Book Part", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBounds(10, 57, 443, 433);
		panel_1.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("Part ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(37, 10, 86, 37);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Book Name");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(133, 10, 96, 37);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Status");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(374, 10, 86, 37);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Book Part");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(250, 10, 96, 37);
		panel_1.add(lblNewLabel_2_1_1);
	}
	
	public void setVisible() 
	{
		frame.setVisible(true);
	}
	
}
