/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oantuti.model;

/**
 *
 * @author lamit
 */
public class Message {
    private Object content;
    private MesType mesType;

    public Message(Object content, MesType mesType) {
        this.content = content;
        this.mesType = mesType;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public MesType getMesType() {
        return mesType;
    }

    public void setMesType(MesType mesType) {
        this.mesType = mesType;
    }
    
    public static enum MesType{
        //login,register
        LOGIN,
        LOGIN_SUCCESS,
        LOGIN_FAIL,
        REGISTER,
        REGISTER_FAIL,
        REGISTER_SUCCESS,
        //yeu cau choi game
        REQUEST_PLAY,
        ACCEPT_REQUEST,
        DENY_REQUEST,
        //choi game
        START_GAME,
        SEND_CHOICE,
        REPLY_RESULT,
        //scoreboard
        GET_SCOREBOARD,
        REPLY_SCOREBOARD
    }
}
