import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class Client {

    public static void main(String[] args) throws RemoteException, UnknownHostException {
        // Who am I?
        String localHostname = InetAddress.getLocalHost().getHostName();
        System.out.println("This is host:" + localHostname );

        // What is the (default) host?
        String serviceHost = Server.MasterNodeName;

        // Use command line parameter to override the default host
        if (args.length > 0)
            serviceHost = args[0];

        // connect to the host and request the service
        Service service = Server.connect(serviceHost);

        // execute a remote method
        long t1, t2;

        t1 = System.currentTimeMillis();
        String greeting = service.sendMessage("Hello World at " + LocalDateTime.now());
        t2 = System.currentTimeMillis();

        System.out.println("Client side:" + greeting);
        System.out.println("SendMessage took " + (t2-t1) + " ms.");

    }
}


