package controller;

import com.sun.security.ntlm.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientChatThread extends Thread{


    private ObjectInputStream entradaIncidencia;
    private ObjectOutputStream salidaIncidencia;
    private Server s;
    private Socket socket;
    private int uniqueId;



    public ClientChatThread(){ }


    @Override
    public void run() {
        super.run();







    }

    public ClientChatThread(Socket s){
        this.socket = s;
    }









}
