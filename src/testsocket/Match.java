/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsocket;

/**
 *
 * @author lamit
 */
public class Match {
    private String firstClient,secondClient;
    private Status status;

    public Match() {
        firstClient = "";
        secondClient = "";
        this.status = Status.NONE;
    }
    public void setString(String s){
        
        if(firstClient.equals("")){
            System.out.println("AAA");
            firstClient = s;
            status = Status.WAIT;
        }
        else{
            System.out.println("BBB");
            secondClient = s;
            status = Status.COMPLETE;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
