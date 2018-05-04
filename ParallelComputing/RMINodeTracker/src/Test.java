import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

/**
 * Created by Richard on 8/22/2016.
 */
public class Test {

    public static void main(String[] args) throws RemoteException, UnknownHostException, AlreadyBoundException, NotBoundException {
        ComputeServer computeServer = new ComputeServer();

        // who am I
        String localHostname = InetAddress.getLocalHost().getHostName();
        System.out.println("This is host:" + localHostname );


        Registry registry;

        try {
            registry = LocateRegistry.createRegistry(RegistrationServer.DefaultPort);
        } catch (Exception e)
        {
            System.out.println("Registry was running");
            // start the registry service on this node
            registry = LocateRegistry.getRegistry(RegistrationServer.DefaultPort);
        }

        try {
            registry = LocateRegistry.createRegistry(RegistrationServer.DefaultPort);
        } catch (Exception e)
        {
            System.out.println("Registry was running");
            // start the registry service on this node
            registry = LocateRegistry.getRegistry(RegistrationServer.DefaultPort);
        }

        ComputeService computeService = null;
        try {
            computeService = (ComputeService) registry.lookup(ComputeServer.ServiceName);
        }
        catch (Exception e)
        {
            System.out.println("service is not running");
            registry.bind(ComputeServer.ServiceName, computeServer);
        }

        try {
            computeService = (ComputeService) registry.lookup(ComputeServer.ServiceName);
        }
        catch (Exception e)
        {
            System.out.println("service is not running");
            registry.bind(ComputeServer.ServiceName, computeServer);
        }

        if (computeService != null)
            computeService.sendMessage("Testing");

        System.out.println(ComputeServer.ServiceName + " service running on " + localHostname + " at port " + RegistrationServer.DefaultPort);
    }


}
