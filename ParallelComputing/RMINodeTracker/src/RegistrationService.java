import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * Created by Richard on 8/22/2016.
 */
public interface RegistrationService  extends Remote {
    Boolean isOnline() throws  RemoteException;
    String register(String nodeName) throws RemoteException;
    List<String> getNodes() throws RemoteException;


}
