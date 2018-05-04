import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
    String sendMessage(String message) throws RemoteException;
}