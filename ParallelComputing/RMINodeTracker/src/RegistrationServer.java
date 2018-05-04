import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Richard on 8/22/2016.
 */
public class RegistrationServer extends UnicastRemoteObject implements RegistrationService {

    public static  final String DefaultMaster = "PI11";
    public static final int DefaultPort = 1199;

    private static final String ServiceName = "Registration";

    // holds a list of registered nodes
    private List<String> nodes;



    public RegistrationServer() throws RemoteException {
        nodes = new ArrayList<>();
    }

    public static RegistrationService connect(String host){

        RegistrationService registrationService = null;

        try {
            System.out.println("Connecting to "+ host);

            Registry r = LocateRegistry.getRegistry(host, RegistrationServer.DefaultPort);
            registrationService = (RegistrationService) r.lookup(RegistrationServer.ServiceName);

        } catch (Exception ex) {
            Logger.getLogger(ComputeClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registrationService;
    }


    public Boolean isOnline() throws RemoteException {
        return true;
    }

    public String register(String nodeName) throws RemoteException {

        // add the nodeName to our list of nodes
        nodes.add(nodeName);

        String msg = "Node:" + nodeName + " registered ";
        System.out.println(msg);
        return msg;
    }

    public List<String> getNodes() throws RemoteException {
        return nodes;
    }


    public static void main(String[] args) {
        try {
            // the registration service runs on the master node
            String hostName = InetAddress.getLocalHost().getHostName();

            // create a RegistrationServer object for the registration service
            RegistrationServer registrationServer = new RegistrationServer();

            Registry registry;
            // start the registry service on this host
            try {
                registry = LocateRegistry.createRegistry(RegistrationServer.DefaultPort);
            } catch (Exception e)
            {
                System.out.println("Registry was running already");
                // get the registry service that is running already on this node
                registry = LocateRegistry.getRegistry(RegistrationServer.DefaultPort);
            }


            RegistrationService registrationService = null;
            try {
                registrationService = (RegistrationService) registry.lookup(RegistrationServer.ServiceName);
            }
            catch (Exception e)
            {
                System.out.println("Registration service is not running");
                System.out.println("Starting up Registration Service");
                registry.bind(RegistrationServer.ServiceName, registrationServer);
                registrationService = (RegistrationService) registry.lookup(RegistrationServer.ServiceName);
            }

            if (registrationService.isOnline()) {
                System.out.println(RegistrationServer.ServiceName + " service running on " + hostName + " at port " + RegistrationServer.DefaultPort);
            }

//            ComputeServer computeServer = new ComputeServer();
//            registry.bind(ComputeServer.ServiceName, computeServer);
//            System.out.println(ComputeServer.ServiceName + " service running on " + hostName + " at port " + RegistrationServer.DefaultPort);

        } catch (Exception ex) {
            Logger.getLogger(ComputeServer.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

}