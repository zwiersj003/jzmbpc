import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;


class SlowTask implements Task<Boolean>, Serializable {

    long delay;

    public SlowTask(long delay) {
        this.delay = delay;
    }

    @Override
    public Boolean execute() {
        System.out.println("Start a slow task that takes " + delay + " ms.");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow task done");
        return true;
    }
}


public class ComputeClient {


    public static void main(String[] args) throws RemoteException, UnknownHostException {
        String targetNode;

        if (args.length == 0) {
            System.out.println("Specify target compute node");
            return;
        } else {
            // what is the Target
            targetNode = args[0];
        }

        // who am I
        String localHostname = InetAddress.getLocalHost().getHostName();
        System.out.println("This is host:" + localHostname );


        ComputeService computeService = ComputeServer.connect(targetNode, RegistrationServer.DefaultPort);

        long t1, t2;

        t1 = System.currentTimeMillis();
        computeService.ping();
        t2 = System.currentTimeMillis();
        System.out.println("Ping took " + (t2-t1) + " ms.");

        t1 = System.currentTimeMillis();
        String greeting = computeService.sendMessage("Hello World at " + LocalDateTime.now());
        t2 = System.currentTimeMillis();

        System.out.println("ComputeClient side:" + greeting);
        System.out.println("SendMessage took " + (t2-t1) + " ms.");

        t1 = System.currentTimeMillis();
        Boolean test = computeService.executeTask(new SlowTask(3000));
        t2 = System.currentTimeMillis();
        System.out.println("Slow task execution took " + (t2-t1) + " ms.");
    }
}


