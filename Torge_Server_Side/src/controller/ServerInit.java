package controller;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ServerInit {

    private static Server s = null;
    private static int uniqueId;
    private ArrayList<ClientChatThread> users;
    private static int port=1234;
    public static String hostname="localhost";
    private static boolean serverIsRunning;

    private static SimpleDateFormat sdf;



    public ServerInit(int port){
        this.port = port;
        users = new ArrayList<ClientChatThread>();
        sdf= new SimpleDateFormat("HH:mm:ss");

    }


    public static void start() throws UnknownHostException, IOException {

        serverIsRunning = true;

        try {


            ServerSocket ss = new ServerSocket(port);
            ClientChatThread cct;
            while(serverIsRunning){

                    displayMsg("Server waiting for clients on port "+ port + ".");

                   Socket socket = new Socket(hostname, port);
                     socket = ss.accept();

                    cct = new ClientChatThread(socket);

                    cct.start();

            }

        } catch (Exception e){
            e.printStackTrace();
        }



    }


    public static void displayMsg(String msg){
        String time = sdf.format(new Date()) + " " + msg;
        System.out.println(time);
    }

    public static Server getS() {
        return s;
    }

    public static void setS(Server s) {
        ServerInit.s = s;
    }



    public static void main(String[] args) throws IOException {

        start();
    }

}
