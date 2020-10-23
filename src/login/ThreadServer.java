/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.Message;
import login.User;

/**
 *
 * @author lamit
 */
public class ThreadServer implements Runnable {

    private ServerSocket myServer;
    private int serverPort = 8888;
    Socket clientSocket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public ThreadServer() {
        openServer();
    }

    private void openServer() {
        try {
            myServer = new ServerSocket(serverPort);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
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
                if (o instanceof Message) {
                    User user = ((Message) o).getUser();
                    if (((Message) o).getType() == Message.Type.LOGIN) {
                        if (checkLogin(user)) {
                            Message mes = new Message(user, Message.Type.LOGIN_SUCCESS);
                            oos.writeObject(mes);
                        } else {
                            Message mes = new Message(user, Message.Type.LOGIN_FAIL);
                            oos.writeObject(mes);
                        }
                    } else {
                         Message mes = new Message(user, Message.Type.REGISTER);
                         oos.writeObject(mes);    
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            clientSocket.close();
//
//            myServer.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private boolean checkLogin(User user) {
        if (user.getUsername().equals("1") && user.getPassword().equals("1")) {
            return true;
        }
        return false;
    }
}
