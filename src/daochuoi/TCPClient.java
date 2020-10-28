/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daochuoi;

/**
 *
 * @author lamit
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPClient {
// khai bao socket cho client, luong vao-ra

    Socket mySocket = null;
    PrintStream os = null;
    DataInputStream is = null;
// Tao ket noi

    public TCPClient() {
        connection();
    }
    
    public void connection() {
        try {
            mySocket = new Socket("localhost", 8888);
            os = new PrintStream(mySocket.getOutputStream());
            is = new DataInputStream(mySocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } 
    }

    public void send(String str) { // gui du lieu den server
        if (mySocket != null && os != null) {
            try {
                os.println(str);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public String receive() { // nhan du lieu tra ve tu server
        if (mySocket != null && is != null) {
            try {
                String responseStr;
                if ((responseStr = is.readLine()) != null) {
                    return responseStr;
                }
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    public void close() {
        if (mySocket != null && os != null && is != null) {
            try {
                os.close();
                is.close();
                mySocket.close();
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
    public static void main(String[] args) {
        TCPClient tcpc = new TCPClient();
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap vao chuoi: ");
        String s = sc.nextLine();
        tcpc.send(s);
        System.out.println(tcpc.receive());
    }
}
