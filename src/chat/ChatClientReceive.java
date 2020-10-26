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
public class ChatClientReceive implements Runnable {

    ObjectOutputStream oos;
    ObjectInputStream ois;
    ClientChatFrm chatFrm;
    int idClient;
    public ChatClientReceive(ObjectOutputStream oos, ObjectInputStream ois, ClientChatFrm chatFrm,int idClient) {
        this.oos = oos;
        this.ois = ois;
        this.chatFrm = chatFrm;
        this.idClient = idClient;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object o = ois.readObject();
                if (o instanceof Message) {
                    Message mes = (Message) o;
//                    if(idClient != mes.getId()){
                        chatFrm.appendText(mes.toString());
//                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ChatClientReceive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChatClientReceive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChatClientReceive.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
