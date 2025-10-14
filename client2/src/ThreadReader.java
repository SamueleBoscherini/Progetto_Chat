import java.io.BufferedReader;
import java.io.IOException;

public class ThreadReader extends Thread {
    private BufferedReader in;
    private Gui gui;
    private String messaggio = "";

    public ThreadReader(BufferedReader in, Gui gui){
        this.in = in;
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            do {
                messaggio = in.readLine();
                if(messaggio.equals("end")) break;
                gui.setMessage(messaggio + "\n");
                System.out.println(messaggio);
            } while (true);
            System.out.println("Il Client1 è uscito dalla chat digita 'end' per chiudere la chat");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
