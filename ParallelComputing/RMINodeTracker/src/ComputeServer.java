import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComputeServer extends UnicastRemoteObject implements ComputeService {

    public static final String ServiceName = "Compute";
    private static String localHostname;

    public ComputeServer() throws RemoteException {
    }

    public void ping() throws RemoteException {
        return;
    }

    public String sendMessage(String message) throws RemoteException {
        System.out.println("echo: " + message);
    	return message + " received at " + localHostname;
    }

    public <T> T executeTask(Task<T> t) throws RemoteException {
        System.out.println("Executing task");
        return t.execute();
    }



    public static ComputeService connect(String host, int port){

        ComputeService computeService = null;

        try {
            System.out.println("Connecting to "+ host + ":" + port);

            Registry r = LocateRegistry.getRegistry(host, port);
            computeService = (ComputeService) r.lookup(ComputeServer.ServiceName);

        } catch (Exception ex) {
            Logger.getLogger(ComputeClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return computeService;
    }

    private static RegistrationService connect_register(String masterNodeName) {
        try {
            // who am I
            localHostname = InetAddress.getLocalHost().getHostName();
            System.out.println("This is host:" + localHostname );

            // connect to the masternode registration service so other nodes can find us
            RegistrationService registrationService = RegistrationServer.connect(masterNodeName);
            if (registrationService != null) {
                registrationService.register(localHostname);
                return registrationService;
            }


        } catch (Exception ex) {
            Logger.getLogger(ComputeServer.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        System.out.println("Registration service not found!!");
        return null;
    }


    public static void main(String[] args) throws RemoteException, AlreadyBoundException, UnknownHostException {

        localHostname = InetAddress.getLocalHost().getHostName();

//        // connect and register to the master
//        String masterNodeName = RegistrationServer.DefaultMaster;
//        if (args.length > 0)
//            masterNodeName = args[0];
//
//        RegistrationService registrationService = ComputeServer.connect_register(masterNodeName);
//
//        if (registrationService != null) {
//            // just a test
//            List<String> allNodes = registrationService.getNodes();
//            System.out.println("All nodes registered on the RegistrationServer");
//            for (String node : allNodes) {
//                System.out.println(node);
//            }
//        }

        ComputeServer computeServer = new ComputeServer();

        // start the registry service on this node
//        Registry registry = LocateRegistry.getRegistry(localHostname, RegistrationServer.DefaultPort);

        Registry registry = LocateRegistry.createRegistry(RegistrationServer.DefaultPort);

        registry.bind(ComputeServer.ServiceName, computeServer);
        System.out.println(ComputeServer.ServiceName + " service running on " + localHostname + " at port " + RegistrationServer.DefaultPort);

    }

}
