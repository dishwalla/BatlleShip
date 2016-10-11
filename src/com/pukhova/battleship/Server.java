package com.pukhova.battleship;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public class Server {

    public void connect(){
        ServerSocket serverSocket=null;
        boolean listening=true;

        try{
            serverSocket=new ServerSocket(1234);
        }
        catch(IOException e){
            System.err.println("Could not listen on port 1234");
            System.exit(-1);
        }

        while(listening){
            try {
                Socket clientSocket = serverSocket.accept();
                InetAddress add = clientSocket.getInetAddress();
                String host = add.getHostName();
                System.out.println(host);
             //   CommandProcessorThread clientThread = new CommandProcessorThread(clientSocket);
             //   clientThread.setMachineName(host);
             //   clientThread.start();
            }

            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
