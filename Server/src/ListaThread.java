import java.util.ArrayList;

public class ListaThread {
    int num = 1;
    ArrayList<ClientThread> lista;

    public ListaThread(){
        lista = new ArrayList<>();
    }

    public void add(ClientThread t){
        t.setNameThread(num);
        num++;
        lista.add(t);
    }

    public void avvio(){
        if(lista.get(lista.size()-1) instanceof ClientThread){
            lista.get(lista.size()-1).start();
        }
    }

    public void broadcast(String messaggio,ClientThread t){
        for (ClientThread thread : lista) {
            if(!thread.equals(t)){
                t.sendMassage("Client"+ t.getName() + ": " + messaggio,thread);
            }
        }
    }

}
