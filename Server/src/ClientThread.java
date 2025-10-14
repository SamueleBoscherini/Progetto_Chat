import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread  extends Thread {
    Socket ss;
    Log log;
    String messaggio;
    ClientThread t2 = null;
    BufferedReader in;
    PrintWriter out;
    public ClientThread(Socket ss ){
        this.ss = ss;
        messaggio = "";
        log = new Log();
    }

    public void setThread(ClientThread t2){
        this.t2 = t2;
    }

    public void sendMassage(String c){
        synchronized(this){
            t2.out.println(c);
        }
        
    }
    
    @Override
    public void run(){
    
        try{        
            in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            out = new PrintWriter(ss.getOutputStream(), true);
            if(log.exists()){
                log.readLog(out,getName());
            }
            do {
                messaggio = in.readLine();
                log.createLog(messaggio, getName());
                sendMassage("Client"+ getName() + ": " + messaggio);
            } while (!messaggio.equals("end"));
            log.closeLog();
        } catch (IOException e) {
                e.printStackTrace();

        }
        System.out.println("connessione terminata");
   }

   public int setNameThread(int num){
        setName(String.valueOf(num));
        num += 1;
        return num ;
   }

}
