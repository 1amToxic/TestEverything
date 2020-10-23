/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamit
 */
public class ThreadSendData implements Runnable{
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Message mes;
    public ThreadSendData( ObjectOutputStream oos, ObjectInputStream ois, Message mes) {
        this.oos = oos;
        this.ois = ois;
        this.mes = mes;
    }
    
    @Override
    public void run() {
        try {
            oos.writeObject(mes);
        } catch (IOException ex) {
            Logger.getLogger(ThreadSendData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
