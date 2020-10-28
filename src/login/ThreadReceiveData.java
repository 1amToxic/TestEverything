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

    public ThreadReceiveData(ObjectOutputStream oos, ObjectInputStream ois, ClientFrm clientFrm) {
        this.oos = oos;
        this.ois = ois;
        this.clientFrm = clientFrm;
    }

    @Override
    public void run() {
        try {
            System.out.println("receive data");
            Object o = ois.readObject();
            System.out.println("read");
            if (o instanceof Message) {
                System.out.println("here");
                Message mes = (Message) o;
                if (mes.getType() != null) {
                    switch (mes.getType()) {
                        case LOGIN_SUCCESS:
                            clientFrm.setNotification("Login Success");
                            break;
                        case LOGIN_FAIL:
                            clientFrm.setNotification("Login Fail");
                            break;
                        case REGISTER_SUCCESS:
                            clientFrm.setNotification("Register Success");
                            break;
                        case REGISTER_FAIL:
                            clientFrm.setNotification("Register Fail");
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadReceiveData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadReceiveData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
