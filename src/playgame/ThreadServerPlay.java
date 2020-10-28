/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playgame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamit
 */
public class ThreadServerPlay implements Runnable {
    ArrayList<Message> listMes = new ArrayList<>();
    ServerSocket myServer;
    Socket clientSocket;
    int serverPort = 8888;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    public ThreadServerPlay() {
        openConnection();
    }

    private void openConnection() {
        try {
            myServer = new ServerSocket(serverPort);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServerPlay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            clientSocket = myServer.accept();
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            
            while (true) {
                Object o = ois.readObject();
                if(o instanceof Message){
                    Message mes = (Message) o;
                    listMes.add(mes);
//                    if(listMes)
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadServerPlay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadServerPlay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
