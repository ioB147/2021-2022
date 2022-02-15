import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Book {

	JFrame frame;
	private JTextField txtbook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book window = new Book();
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
	public Book() {
		initialize();
		connect();
		book_load();
	}

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	private JTable table_2;
	
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
	
	
	public void book_load()
	{
		try
		{
			pstmt = conn.prepareStatement("Select * From Book");
			rs = pstmt.executeQuery();
			
			ResultSetMetaData rsd = rs.getMetaData();
			int c;
			
			c = rsd.getColumnCount();
			DefaultTableModel d = (DefaultTableModel)table_2.getModel();
			d.setRowCount(0);
			
			while (rs.next())
			{
				Vector v2 = new Vector();
				for (int i=1; i<=c; i++)
				{
					v2.add(rs.getString("id"));
						v2.add(rs.getString("bname"));
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
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 914, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(39, 34, 138, 70);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(153, 102, 255));
		panel.setBounds(10, 159, 373, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 74, 107, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Status");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(20, 134, 97, 40);
		panel.add(lblNewLabel_1_1);
		
		txtbook = new JTextField();
		txtbook.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtbook.setBounds(127, 74, 195, 32);
		panel.add(txtbook);
		txtbook.setColumns(10);
		
		JComboBox txtstatus = new JComboBox();
		txtstatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtstatus.setModel(new DefaultComboBoxModel(new String[] {"Active", "Deactive"}));
		txtstatus.setBounds(127, 141, 195, 29);
		panel.add(txtstatus);
		
		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					pstmt = conn.prepareStatement("Insert into Book values('"+txtbook.getText()+"','"+txtstatus.getSelectedItem().toString()+"')");
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Book created.");
						
						txtbook.setText("");
						txtstatus.setSelectedIndex(-1);
						txtbook.requestFocus();
						book_load();
						
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
				
				DefaultTableModel d1 = (DefaultTableModel)table_2.getModel();
				int selectIndex = table_2.getSelectedRow();
				
				try {
					pstmt = conn.prepareStatement("UPDATE Book SET bname ='"+txtbook.getText()+"',status ='"+txtstatus.getSelectedItem().toString()+"' WHERE id = "+Integer.parseInt(d1.getValueAt(selectIndex, 0).toString()));
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Book updated.");
						
						txtbook.setText("");
						txtstatus.setSelectedIndex(-1);
						
						txtbook.requestFocus();
						book_load();
						btnadd.setEnabled(true); 
						
					}else 
					{
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} catch (Exception e2) {
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
				
				DefaultTableModel d1 = (DefaultTableModel)table_2.getModel();
				int selectIndex = table_2.getSelectedRow();
				
				try {
					pstmt = conn.prepareStatement("DELETE FROM Book WHERE id ="+Integer.parseInt(d1.getValueAt(selectIndex, 0).toString()));
					
					int k = pstmt.executeUpdate();
					
					if (k==1)
					{
						JOptionPane.showMessageDialog(null, "Book deleted.");
						
						txtbook.setText("");
						txtstatus.setSelectedIndex(-1);
						
						txtbook.requestFocus();
						book_load();
						btnadd.setEnabled(true); 
						
					}else 
					{
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} catch (Exception e2) {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 102, 255));
		panel_1.setBounds(416, 104, 460, 484);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel d1 = (DefaultTableModel)table_2.getModel();
				int selectIndex = table_2.getSelectedRow();
				
				int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
				txtbook.setText(d1.getValueAt(selectIndex, 1).toString());
				txtstatus.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
				
				btnadd.setEnabled(false); 
			}
		});
		table_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book ID", "Book Name", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_2.setBounds(10, 57, 443, 419);
		panel_1.add(table_2);
		
		JLabel lblNewLabel_2 = new JLabel("Book ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(52, 10, 86, 37);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel("Book Name");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(189, 10, 96, 37);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Status");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(356, 10, 86, 37);
		panel_1.add(lblNewLabel_2_2);
	}
	
	
	public void setVisible() 
	{
		frame.setVisible(true);
	}

}

