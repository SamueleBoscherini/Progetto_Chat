import java.io.PrintWriter;
import java.util.Scanner;

public class ThreadWriter extends Thread {
    Gui gui;
    private PrintWriter out;
    private Scanner scn = new Scanner(System.in);        
    private String messaggio;

    public ThreadWriter(PrintWriter out){
        this.out = out;
    } 

    @Override
    public void run() {
        do {
            System.out.println(messaggio);
        } while (!messaggio.equals("end"));

        scn.close();
    }

    public void setMessage(String messaggio){
        this.messaggio = messaggio;
    }

    public void setGui(Gui gui){
        this.gui = gui;
    }
}
