import java.io.BufferedReader;

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

            System.out.println("Il Client2 è uscito dalla chat digita 'end' per chiudere la chat");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
