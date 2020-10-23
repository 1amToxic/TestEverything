
import chat.ChatServer;
import login.ThreadServer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamit
 */
public class MainRun {
    public static void main(String[] args) {
        Thread server = new Thread(new ThreadServer());
        server.start();
    }
}
