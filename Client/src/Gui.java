import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.io.PrintWriter;


public class Gui extends JFrame {
    JTextArea display;
    PrintWriter out;
    JTextField chat;
    JButton invio;
    String message;
    Container c = getContentPane();

    public Gui(PrintWriter out){
        this.out = out;
        setFrame();
        setDisplay();
        setVisible(true);

    }

    public void setFrame(){
        setTitle("Client1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout());
    }

    public void setDisplay(){
        display = new JTextArea();
        display.setEditable(false);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(display);


        chat = new JTextField();
        chat.setHorizontalAlignment(JTextField.LEFT);
        chat.setBackground(Color.PINK);
        invio = new JButton("Invio");
        
        JPanel input = new JPanel( new BorderLayout());
        
        input.add(chat, BorderLayout.CENTER);
        input.add(invio, BorderLayout.EAST);
        input.setPreferredSize(new Dimension(400, 50));;
        invio.addActionListener(e->event());
        chat.addActionListener(e->event());

        c.add(scroll, BorderLayout.CENTER);
        c.add(input, BorderLayout.SOUTH);

    }

    public void event(){
        message = chat.getText().trim();
        if(!message.isEmpty()){
            display.append("Tu: " + message + "\n");
            out.println(message);
            chat.setText("");
            display.setCaretPosition(display.getDocument().getLength());
        }
    }

    public String getChatText(){
        return chat.getText().trim();
    }

    public void setMessage(String message){
        display.append(message);
        display.setCaretPosition(display.getDocument().getLength());
    }
}
