package Product_RMI_JDBC;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Product_RMI_JDBC.ProductManagement;

import ConnectServer.Connect;

public class LaptopObject extends UnicastRemoteObject implements ILaptop{
	
	public LaptopObject() throws RemoteException{
		
	}

	@Override
	public String add(String id, String type, String mfg, int price, String description) throws RemoteException {
		Connection con = Connect.getConnection();
		try {
			if(id.equals("") == true || type.equals("") == true || mfg.equals("")) {
				return "Important Info cannot empty";
			}else {
				String sql = "select * from producttbl where id = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					return "ID exist";
				}else {
					String query = "insert into producttbl values(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, id);
					ps.setString(2, type);
					ps.setString(3, mfg);
					ps.setInt(4, price);
					ps.setString(5, description);
					ps.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Important Info cannot empty";
		}
		return "ADD Successfull!";	
	}

	@Override
	public String update(String id, String type, String mfg, int price, String description) throws RemoteException {
		Connection con = Connect.getConnection();
		try {
			if(id.equals("") == true || type.equals("") == true || mfg.equals("") == true) {
				return "Important Info cannot empty";
			}else {
				String sql = "select * from producttbl where id = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				ResultSet rs = pst.executeQuery();
				if(!rs.next()) {
					return "ID not change";
				}else {
					String query = "update producttbl set type = ?, MFG = ?, price = ?, description = ? where id = ?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, type);
					ps.setString(2, mfg);
					ps.setInt(3, price);
					ps.setString(4, description);
					ps.setString(5, id);
					ps.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UPDATE Successfull!";
	}

	@Override
	public String delete(String id) throws RemoteException {
		int check = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		try {
			Connection con = Connect.getConnection();
			String query = "delete from producttbl where id = '" + id + "'";
			Statement stm = con.createStatement();
			if(check == JOptionPane.YES_OPTION) {
				stm.executeUpdate(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE Successfull!";
	}

	@Override
	public Object[] search(String id, Object[] ob) throws RemoteException {
		try {
			Connection con = Connect.getConnection();
			String query = "select * from producttbl where id like '%" + id + "%'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				ob[0] = rs.getString(1); 
				ob[1] = rs.getString(2); 
				ob[2] = rs.getDate(3); 
				ob[3] = rs.getInt(4); 
				ob[4] = rs.getString(5); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
	
}
