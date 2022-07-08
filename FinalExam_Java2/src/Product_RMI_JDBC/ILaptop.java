package Product_RMI_JDBC;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.table.DefaultTableModel;

public interface ILaptop extends Remote{
	public String add(String id, String type, String mfg, int price, String description) throws RemoteException;
	public String update(String id, String type, String mfg, int price, String description) throws RemoteException;
	public String delete(String id) throws RemoteException;
	public Object[] search(String id, Object[] ob) throws RemoteException;
}
