import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public synchronized static void main(String[] args)  throws IOException{
        Scanner scn = new Scanner(System.in);
        System.out.println("Sto aspettando un client");
        ServerSocket ss = new ServerSocket(3000);
        
        Socket sc = ss.accept();
        ClientThread t1 = new ClientThread(sc);
        System.out.println("primo client connesso");
        
        Socket sc2 = ss.accept();
        ClientThread t2 = new ClientThread(sc2);
        System.out.println("secondo client connesso");
        
        t1.setThread(t2);
        t2.setThread(t1);
        
        t2.start();
        t1.start();
        
        ss.close();
        scn.close();
    }
}
