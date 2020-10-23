/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamit
 */
public class ChatClientSend implements Runnable{
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Message mes;

    public ChatClientSend(ObjectOutputStream oos, ObjectInputStream ois, Message mes) {
        this.oos = oos;
        this.ois = ois;
        this.mes = mes;
    }
    
    @Override
    public void run() {
        try {
            oos.writeObject(mes);
        } catch (IOException ex) {
            Logger.getLogger(ChatClientSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
