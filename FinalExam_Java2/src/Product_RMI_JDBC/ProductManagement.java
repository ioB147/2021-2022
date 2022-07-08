package Product_RMI_JDBC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import ConnectServer.Connect;
import Login_RMI_JDBC.Login;
import Chat.*;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextPane;

public class ProductManagement extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private JTextField txtid;
	private JTextField txtType;
	private JTextField txtDescription;
	private JTextField txtprice;
	JPanel panel_4;
	JPanel panel_5;
	ChatMessageSocket cmsocket;
	JDateChooser dateChooser;
	JTextPane textPane;
	
	final String header[] = {"ID", "Type", "MFG", "Price", "Description"};
	final DefaultTableModel tablemodel = new DefaultTableModel(header, 0);
	private JTextField txtport;
	private JTextField txtsend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductManagement frame = new ProductManagement();
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
	public ProductManagement() {
		setTitle("PRODUCT MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 966, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("LogOut");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(806, 10, 150, 40);
		panel.add(btnBack);
		
		JButton btnContactAdmin = new JButton("Contact Admin");
		btnContactAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(false);
				panel_5.setVisible(true);
				
				new Client().setVisible(true);
			}
		});
		btnContactAdmin.setFont(new Font("Arial", Font.PLAIN, 16));
		btnContactAdmin.setBounds(646, 10, 150, 40);
		panel.add(btnContactAdmin);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_5.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		btnHomePage.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHomePage.setBounds(486, 10, 150, 40);
		panel.add(btnHomePage);
		
		JLabel lblNewLabel = new JLabel("Laptop Product Management");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bodoni MT Black", Font.ITALIC, 28));
		lblNewLabel.setBounds(10, 10, 466, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		
		panel_1.setBounds(10, 80, 966, 573);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 623, 573);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 10, 603, 553);
		
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBounds(10, 10, 603, 553);
		panel_2.add(panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 603, 553);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row < 0) {
					JOptionPane.showMessageDialog(null, "Row is empty", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					DefaultTableModel tbl = (DefaultTableModel) table.getModel();
					txtid.setText(table.getValueAt(row, 0).toString());
					txtType.setText(table.getValueAt(row, 1).toString());
					try {
						java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tbl.getValueAt(row, 2).toString());
						dateChooser.setDate(date);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					txtprice.setText(table.getValueAt(row, 3).toString());
					txtDescription.setText(table.getValueAt(row, 4).toString());
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Type", "MFG", "Price", "Description"
			}
		));
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Port:");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(41, 100, 42, 22);
		panel_5.add(lblNewLabel_6);
		
		txtport = new JTextField();
		txtport.setBounds(93, 99, 153, 25);
		panel_5.add(txtport);
		txtport.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(txtport.getText());
				try {
					ServerSocket ss = new ServerSocket(port);
					Thread t = new Thread() {
						public void run() {
							try {
								textPane.setText(textPane.getText()+"Starting...");
								Socket socket = ss.accept();
								cmsocket = new ChatMessageSocket(socket, textPane);
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
					};
					t.start();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnStart.setFont(new Font("Arial", Font.PLAIN, 18));
		btnStart.setBounds(465, 96, 96, 31);
		panel_5.add(btnStart);
		
		JLabel lblNewLabel_7 = new JLabel("CHAT ");
		lblNewLabel_7.setFont(new Font("Bodoni MT Black", Font.BOLD, 26));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(269, 29, 94, 31);
		panel_5.add(lblNewLabel_7);
		
		textPane = new JTextPane();
		textPane.setBounds(41, 142, 519, 316);
		panel_5.add(textPane);
		
		JLabel lblNewLabel_8 = new JLabel("Message:");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_8.setBounds(41, 479, 84, 22);
		panel_5.add(lblNewLabel_8);
		
		txtsend = new JTextField();
		txtsend.setBounds(135, 468, 330, 45);
		panel_5.add(txtsend);
		txtsend.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtsend.getText().equals("") == false) {
					cmsocket.send(txtsend.getText());
				}
				txtsend.setText("");
			}
		});
		btnSend.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSend.setBounds(475, 468, 86, 45);
		panel_5.add(btnSend);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(633, 0, 333, 573);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 70, 85, 40);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 130, 85, 40);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MFG:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 190, 85, 40);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Description:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 310, 85, 40);
		panel_3.add(lblNewLabel_4);
		
		txtid = new JTextField();
		txtid.setBounds(106, 78, 217, 23);
		panel_3.add(txtid);
		txtid.setColumns(10);
		
		txtType = new JTextField();
		txtType.setBounds(106, 138, 217, 23);
		panel_3.add(txtType);
		txtType.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(105, 318, 218, 23);
		panel_3.add(txtDescription);
		txtDescription.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Price:");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(10, 250, 85, 40);
		panel_3.add(lblNewLabel_4_1);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(106, 258, 217, 23);
		panel_3.add(txtprice);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(105, 198, 129, 23);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		panel_3.add(dateChooser);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				String type = txtType.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String mfg = sdf.format(dateChooser.getDate());
				int price = Integer.parseInt(txtprice.getText());
				String des = txtDescription.getText();
				try {
					ILaptop ilap = (ILaptop) Naming.lookup("rmi://localhost:1099/MyProduct");
					String rs = ilap.add(id, type, mfg, price, des);
					if(rs.equals("Important Info cannot empty")) {
						JOptionPane.showMessageDialog(null, rs, "Erorr", JOptionPane.ERROR_MESSAGE);
					}else if(rs.equals("ID exist")) {
						JOptionPane.showMessageDialog(null, rs, "Erorr", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, rs, "Congratulations!!!", JOptionPane.INFORMATION_MESSAGE);
						UpdateTable();
						clear();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 370, 313, 40);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				String type = txtType.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String mfg = sdf.format(dateChooser.getDate());
				int price = Integer.parseInt(txtprice.getText());
				String des = txtDescription.getText();
				
				try {
					ILaptop ilap = (ILaptop) Naming.lookup("rmi://localhost:1099/MyProduct");
					String rs = ilap.update(id, type, mfg, price, des);
					if(rs.equals("Important Info cannot empty")) {
						JOptionPane.showMessageDialog(null, rs, "Erorr", JOptionPane.ERROR_MESSAGE);
					}else if(rs.equals("ID not change")) {
						JOptionPane.showMessageDialog(null, rs, "Erorr", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, rs, "Congratulations!!!", JOptionPane.INFORMATION_MESSAGE);
						UpdateTable();
						clear();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 420, 313, 40);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				try {
					ILaptop ilap = (ILaptop) Naming.lookup("rmi://localhost:1099/MyProduct");
					String rs = ilap.delete(id);
					JOptionPane.showMessageDialog(null, rs, "", JOptionPane.INFORMATION_MESSAGE);
					UpdateTable();
					clear();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_2.setBounds(10, 470, 313, 40);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SEARCH");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				d.setRowCount(0);
				Object[] ob = new Object[5];
				try {
					ILaptop ilap = (ILaptop) Naming.lookup("rmi://localhost:1099/MyProduct");
					Object[] rs = ilap.search(id, ob);
					d.addRow(rs);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 520, 313, 40);
		panel_3.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("Laptop");
		lblNewLabel_5.setFont(new Font("Bodoni MT Black", Font.PLAIN, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(106, 10, 128, 47);
		panel_3.add(lblNewLabel_5);
		setLocationRelativeTo(null);
		UpdateTable();
		panel_5.setVisible(false);
	}
	
	public void UpdateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		String query = "select * from producttbl";
		try {
			Connection con = Connect.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5)
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void clear() {
		txtid.setText("");
		txtType.setText("");
		dateChooser.setDate(null);
		txtprice.setText("");
		txtDescription.setText("");
	}
}
