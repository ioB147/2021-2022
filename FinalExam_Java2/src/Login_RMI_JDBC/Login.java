package Login_RMI_JDBC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import ConnectServer.Connect;
import Product_RMI_JDBC.ProductManagement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.rmi.Naming;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtacc;
	private JPasswordField txtpass;
	private JComboBox comboBox;
	JPanel panel;
	JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtaccRegister;
	private JLabel lblNewLabel_3;
	private JPasswordField txtpassRegister;
	private JLabel lblNewLabel_4;
	private JPasswordField txtpassRepeat;
	
	private final static String ALGO = "AES/CBC/PKCS5Padding";
	private static String UNICODE_FORMAT = "UTF-8";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 419, 267);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JButton btnReg = new JButton("Register");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtaccRegister.getText();
				String pass = String.valueOf(txtpassRegister.getPassword());
				String passrepeat = String.valueOf(txtpassRepeat.getPassword());
				String role = (String) comboBox.getSelectedItem();
				
				if(role.equals("Staff")) {
					if(pass.equals(passrepeat)) {
						SecretKey key = LoadFromKeyStore("keystore.keystore", "123456");
						try {
							Cipher cipher = Cipher.getInstance("AES");
							byte[] encryptionData = Encryption(passrepeat, key, cipher);
							IUser iuser = (IUser) Naming.lookup("rmi://localhost:1099/MyUser");
							String rs = iuser.register(user, new String(Base64.getEncoder().encode(encryptionData)));
							if(rs.equals("Register Successfull")) {
								JOptionPane.showMessageDialog(null, rs, "Congratulations!!!", JOptionPane.INFORMATION_MESSAGE);
							}else if(rs.equals("User exist")) {
								JOptionPane.showMessageDialog(null, rs, "Error", JOptionPane.ERROR_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, rs, "Error", JOptionPane.ERROR_MESSAGE);
							}
						} catch (Exception e2) {
//							JOptionPane.showMessageDialog(null, "Error", "", JOptionPane.ERROR_MESSAGE);
							e2.printStackTrace();
						}
						clear();
						setTitle("LOGIN");
					}else {
						JOptionPane.showMessageDialog(null, "Password isn't same PassWord Repeat \nPlease re-Enter!!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else if(role.equals("Admin")) {
					if(pass.equals(passrepeat)) {
						SecretKey key = LoadFromKeyStore("keystore.keystore", "123456");
						try {
							Cipher cipher = Cipher.getInstance("AES");
							byte[] encryptionData = Encryption(passrepeat, key, cipher);
							IUser iuser = (IUser) Naming.lookup("rmi://localhost:1099/MyUser");
							String rs = iuser.registerAdmin(user, new String(Base64.getEncoder().encode(encryptionData)));
							JOptionPane.showMessageDialog(null, rs, "Congratulations!!!", JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e2) {
//							JOptionPane.showMessageDialog(null, "Error", "", JOptionPane.ERROR_MESSAGE);
							e2.printStackTrace();
						}
						clear();
						setTitle("LOGIN");
					}else {
						JOptionPane.showMessageDialog(null, "Password isn't same PassWord Repeat \nPlease re-Enter!!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnReg.setBounds(93, 215, 108, 42);
		panel_1.add(btnReg);
		
		lblNewLabel_2 = new JLabel("User:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(30, 10, 80, 35);
		panel_1.add(lblNewLabel_2);
		
		txtaccRegister = new JTextField();
		txtaccRegister.setColumns(10);
		txtaccRegister.setBounds(200, 15, 190, 25);
		panel_1.add(txtaccRegister);
		
		lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(30, 110, 80, 35);
		panel_1.add(lblNewLabel_3);
		
		txtpassRegister = new JPasswordField();
		txtpassRegister.setColumns(10);
		txtpassRegister.setBounds(200, 115, 190, 25);
		panel_1.add(txtpassRegister);
		
		lblNewLabel_4 = new JLabel("Password Repeat:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(30, 160, 132, 35);
		panel_1.add(lblNewLabel_4);
		
		txtpassRepeat = new JPasswordField();
		txtpassRepeat.setColumns(10);
		txtpassRepeat.setBounds(200, 165, 190, 25);
		panel_1.add(txtpassRepeat);
		
		JLabel lblNewLabel_5 = new JLabel("Role:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(30, 60, 80, 35);
		panel_1.add(lblNewLabel_5);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Staff"}));
		comboBox.setBounds(200, 65, 80, 25);
		panel_1.add(comboBox);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnCancel.setBounds(234, 215, 108, 42);
		panel_1.add(btnCancel);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 419, 267);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 49, 80, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(30, 116, 80, 35);
		panel.add(lblNewLabel_1);
		
		txtacc = new JTextField();
		txtacc.setBounds(180, 54, 205, 25);
		panel.add(txtacc);
		txtacc.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(180, 121, 205, 25);
		panel.add(txtpass);
		txtpass.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				SecretKey key1 = LoadFromKeyStore("keystore.keystore", "123456");
//				Cipher cipher1 = Cipher.getInstance("AES");
//				System.out.println("Text Decrypted: "+ decryptString(encryptedData, key1, cipher1));
				String account = txtacc.getText();
				String pass = String.valueOf(txtpass.getPassword());
				
				
				if(account != "" && pass != "") {
					SecretKey key = LoadFromKeyStore("keystore.keystore", "123456");
					try {
						Cipher cipher = Cipher.getInstance("AES");
						byte[] encryptionData = Encryption(pass, key, cipher);
						IUser iuser = (IUser) Naming.lookup("rmi://localhost:1099/MyUser");
						String rs = iuser.login(account, new String(Base64.getEncoder().encode(encryptionData)));
						if(rs.equals("Login Successfull")) {
							JOptionPane.showMessageDialog(null, rs, "Congratulations!!!", JOptionPane.INFORMATION_MESSAGE);
							new ProductManagement().setVisible(true);
							setVisible(false);
						}else if(rs.equals("Login Failed")) {
							JOptionPane.showMessageDialog(null, rs, "Error", JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Error", "", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Enter User and Pass", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin.setBounds(70, 178, 118, 43);
		panel.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("REGISTER");
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnRegister.setBounds(226, 178, 118, 43);
		panel.add(btnRegister);
		
		setLocationRelativeTo(null);
	}
	public SecretKey generateKey(String encryptionType) {
		KeyGenerator keyG;
		try {
			keyG = KeyGenerator.getInstance(encryptionType);
			SecretKey myK = keyG.generateKey();
			return myK;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public SecretKey LoadFromKeyStore(String filepath, String password) {
		try {
			KeyStore keyS = KeyStore.getInstance("JCEKS");
			InputStream is = new FileInputStream(filepath);
			keyS.load(is, password.toCharArray());
			SecretKey key = (SecretKey) keyS.getKey("KeyAliasBidanh", password.toCharArray());
			return key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public byte[] Encryption(String data, SecretKey myKey, Cipher ci) {
		try {
			byte[] text = data.getBytes(UNICODE_FORMAT);
			ci.init(Cipher.ENCRYPT_MODE, myKey);
			byte[] encrypted = ci.doFinal(text);
			return encrypted;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public String Decryption(byte[] data, SecretKey Key, Cipher ci){
		try {
			ci.init(Cipher.DECRYPT_MODE, Key);
			byte[] decrypted = ci.doFinal(data);
			String str = new String(decrypted, UNICODE_FORMAT);
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String changetoXML(int id, String userName, String password) {
		return "<account>\n" + 
				"\t<id>" + id + "</id>" + 
				"\t<userName>" + userName + "</userName>" + 
				"\t<password>" + password + "</password>" + 
				"</account>";
	}
	
	public void showDL() {
		Connection con = Connect.getConnection();
		FileOutputStream fos = null;
		String sql = "select * from usertbl";
		try {
			fos = new FileOutputStream("src\\Login_RMI_JDBC\\account.xml");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void clear() {
		txtaccRegister.setText("");
		txtpassRegister.setText("");
		txtpassRepeat.setText("");
	}
}