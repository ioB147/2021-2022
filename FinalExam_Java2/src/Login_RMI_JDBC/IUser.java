package Login_RMI_JDBC;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote{
	public String login(String acc, String pass) throws RemoteException;
	public String register(String acc, String passrepeat) throws RemoteException;
	public String registerAdmin(String acc, String passrepeat) throws RemoteException;
}
