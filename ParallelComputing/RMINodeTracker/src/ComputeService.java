import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputeService extends Remote {
    void ping() throws RemoteException;
    String sendMessage(String message) throws RemoteException;
    <T> T executeTask(Task<T> t) throws RemoteException;

}