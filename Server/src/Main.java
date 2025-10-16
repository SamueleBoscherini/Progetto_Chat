import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public synchronized static void main(String[] args)  throws IOException{
        Scanner scn = new Scanner(System.in);
        int num = 0;
        System.out.println("Sto aspettando un client");
        ServerSocket ss = new ServerSocket(3000);
        ListaThread lista = new ListaThread();

        
        do {
            Socket sc = ss.accept();
            lista.add(new ClientThread(sc, lista));
            lista.avvio();
            System.out.println("Un utente è stato connesso");

        } while (num<4);

        scn.close();
        ss.close();
    }
}


