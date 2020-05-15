package controller;

import com.sun.security.ntlm.Server;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;

import javax.swing.text.html.ListView;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class ChatController implements Runnable {

    @FXML
    private TextArea messages;

    @FXML
    private TextArea users;

    @FXML
    private Button send;

    @FXML
    private Button cancel;

    @FXML
    private TextField message;

    static MulticastSocket ms = null;
    static byte[] buf= new byte[1000];
    static InetAddress group = null;
    static int port=12345;


    static boolean loop=false;


    @Override
    public void run() {

        while(loop){

            try{

                DatagramPacket p = new DatagramPacket(buf, buf.length);
                ms.receive(p);
                String text = new String(p.getData(), 0, p.getLength());
                messages.append(text + "\n");

            } catch (SocketException e){

                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) throws IOException {

        String name=null;

        ms = new MulticastSocket(port);
        group = InetAddress.getByName("225.0.0.1");

        ms.joinGroup(group);



    }

    public void onSendClick(){

        String msg = ">> " + message.getText();

        try{

            DatagramPacket pack = new DatagramPacket(msg.getBytes(), msg.length(), group, port);
            ms.send(pack);

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void onExit(){

    }
}