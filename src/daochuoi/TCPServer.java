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
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
// Khai bao server socket, luong vao-ra, va doi tuong socket

    ServerSocket myServer = null;
    String input;
    DataInputStream is;
    PrintStream os;
    Socket clientSocket = null;
// Mo mot server socket

    public TCPServer() {
        openServer();
        listening();
    }
    
    public void openServer() {
        try {
            myServer = new ServerSocket(8888);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void listening() {
        try {
            System.out.println("start");
            clientSocket = myServer.accept();
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
// Xu li du lieu nhan duoc va tra ve
            while (true) {
// doc du lieu vao
System.out.println("123");
                input = is.readLine();
// xu li du lieu
System.out.println(input);
                ReverseString str = new ReverseString(input);
                str.reverse();
// tra ve du lieu
                os.println(str.get_string());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        TCPServer tcps = new TCPServer();
        
    }
}
