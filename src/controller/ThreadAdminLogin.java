package controller;

import model.VO.UsuarioVO;
import model.VO.UsuarioVONormal;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadAdminLogin extends Thread {

    private ObjectInputStream objectInput = null;
    private ObjectOutputStream objectOutput = null;

    private Server s;
    private Socket socket;

    public ThreadAdminLogin(Socket socket) {
        this.s = Server.getServer();
        this.socket = socket;

        try {

            objectInput = new ObjectInputStream(socket.getInputStream());
            objectOutput = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FALLA AQUI 1");
        }

    }

    @Override
    public void run() {

        try {
            ArrayList<String> credentials = (ArrayList<String>) objectInput.readObject();
            System.out.println("CREDENCIALES SON " + credentials.get(0) + " | " + credentials.get(1));
            //UsuarioVONormal user = s.getUsuairo(credentials);
            ArrayList<String> userconectado = s.getUsuairo2(credentials);

            System.out.println("LLEGA AQUI");

            objectOutput.writeObject(userconectado);
            objectInput.close();
            objectOutput.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
