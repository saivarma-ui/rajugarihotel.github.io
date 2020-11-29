package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {

    private static int PORT = 1099;
    private static ServerRMI server;
    
    private ClientRMI() {
        super();
    }
    
    public static ServerRMI getServer() {
        if(server == null) {
            Registry registry;
            try {
                registry = LocateRegistry.getRegistry(PORT);
                server = (ServerRMI) registry.lookup("monserveurrmi");
            } catch (RemoteException|NotBoundException e) {
                e.printStackTrace();
            }
        }
        return server;
    }
}
