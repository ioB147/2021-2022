package Login_RMI_JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import ConnectServer.Connect;

public class UserObject extends UnicastRemoteObject implements IUser{
	
	public UserObject() throws RemoteException{
		
	}

	@Override
	public String login(String acc, String pass) throws RemoteException {
		try {
			Connection con = Connect.getConnection();
			String query = "select * from usertbl where userName=? and userPass=?";
			PreparedStatement pst = con.prepareCall(query);
			pst.setString(1, acc);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if(!rs.next()) {
				return "Login Failed";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Login Successfull";
	}

	@Override
	public String register(String acc, String pass) throws RemoteException {
		Connection con = Connect.getConnection();
		try {
			if(acc.equals("") || pass.equals("")) {
				return "Important Info cannot empty";
			}else {
				String sql = "select * from usertbl where userName = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, acc);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					return "User exist";
				}else {
					String query = "insert into usertbl values(NULL,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, acc);
					ps.setString(2, pass);
					ps.executeUpdate();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Register Successfull";
	}

	@Override
	public String registerAdmin(String acc, String passrepeat) throws RemoteException {
		File file = new File("src/AdminAccount.xml");
		try {
			FileInputStream fis = new FileInputStream(file);
			byte b[] = new byte[100000];
			b = fis.readAllBytes();
			
			String s = new String(b);
			int pos = 0;
			int length = s.length();
			int dem = 0;
			for(int i = length - 1; i >= 0; i--) {
				if(s.charAt(i) == '>') {
					dem ++;
				}
				if(dem == 3) {
					pos = i;
					break;
				}
			}
			
			String sCopy = "";
			for(int i = 0; i <= pos; i++) {
				sCopy += s.charAt(i);
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			User user = new User(acc, passrepeat);
			sCopy += user.toXML() + "\r\n" 
					+ "\t</UserPassAdmin>\r\n"
					+ "</AdminAccount>";
			byte[] data = sCopy.getBytes("UTF-8");
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Register Successfull!";
	}
	
}
