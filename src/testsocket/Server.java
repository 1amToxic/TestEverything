/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamit
 */
public class Server {
    private ServerSocket myServer;
    private Socket clientSocket;
    private int port = 3333;
    Match match;
    public Server() {
        match = new Match();
        openServer(port);
        while(true){
            listening();
            if(match.getStatus()==Status.COMPLETE){
                response();
            }
//            try {
//                clientSocket.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
    private void response(){
        try {
            clientSocket = myServer.accept();
//            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
//            String s = new String("Success");
//            oos.writeObject(s);
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            dos.writeBytes("Success");;
//            oos.close();
            dos.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void openServer(int port){
        try {
            myServer = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void listening(){
        try {
            clientSocket = myServer.accept();
//            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
//            Object o = ois.readObject();
//            match.setString((String)o);
//            ois.close();
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            String s = dis.readLine();
            match.setString(s);
            dis.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch (ClassNotFoundException ex) {
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//        } 
    }
    public static void main(String[] args) {
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);

        } catch (Exception e) {

            e.printStackTrace();
        }
        Server serverView = new Server();
    }
}
