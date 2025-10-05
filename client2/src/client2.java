import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client2 {
    public static void main(String[] args) throws IOException {
        final Socket boscheriniSocket = new Socket("localhost", 3000);
        System.out.println("connessione effettuata");
        final BufferedReader in = new BufferedReader(new InputStreamReader(boscheriniSocket.getInputStream()));
        final PrintWriter out = new PrintWriter(boscheriniSocket.getOutputStream(), true);
 
        final ThreadReader tr = new ThreadReader(in);
        final ThreadWriter tw = new ThreadWriter(out);
        
        tr.start();
        tw.start();

        try {
            tr.join();
            tw.join();
        } catch (InterruptedException e) {
            System.out.println("connessione terminata");
            boscheriniSocket.close();
        }
    }
}
