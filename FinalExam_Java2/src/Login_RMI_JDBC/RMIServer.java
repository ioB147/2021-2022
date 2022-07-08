package Login_RMI_JDBC;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import Product_RMI_JDBC.LaptopObject;

public class RMIServer {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/MyUser", new UserObject());
			Naming.rebind("rmi://localhost:1099/MyProduct", new LaptopObject());
			System.out.println("Server ready!!!");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
