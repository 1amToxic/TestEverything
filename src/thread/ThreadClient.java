/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import login.ClientFrm;
import login.Message;

/**
 *
 * @author lamit
 */
public class ThreadClient implements Runnable{
    private Socket mySocket;
    private String serverHost = "localhost";
    private int serverPort = 8888;
    ClientFrm jf;
    public ThreadClient(Socket mySocket,ClientFrm jf) {
        this.mySocket = mySocket;
        this.jf = jf;
    }
    
    @Override
    public void run() {
        try {
            while(true){
                ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
                Object o = ois.readObject();
                if(o instanceof Message){
                    Message mes = (Message) o;
                    if(mes.getType() == Message.Type.LOGIN_SUCCESS){
                        jf.setNotification("Success");
                    }else{
                        jf.setNotification("Fail");
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
