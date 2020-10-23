/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamit
 */
public class ThreadReceiveData implements Runnable {

    ObjectOutputStream oos;
    ObjectInputStream ois;
    ClientFrm clientFrm;

    public ThreadReceiveData(ObjectOutputStream oos, ObjectInputStream ois,  ClientFrm clientFrm) {
        this.oos = oos;
        this.ois = ois;
        this.clientFrm = clientFrm;
    }

    @Override
    public void run() {
        try {
            Object o = ois.readObject();
            if (o instanceof Message) {
                Message mes = (Message) o;
                if (mes.getType() == Message.Type.LOGIN_SUCCESS) {
                    clientFrm.setNotification("Success");
                } else {
                    clientFrm.setNotification("Fail");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadReceiveData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadReceiveData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
