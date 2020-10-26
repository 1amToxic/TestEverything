/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oantuti.model;

import java.util.Date;

/**
 *
 * @author lamit
 */
public class Game {
    private int id;
    private User user;
    private Date timeCreate;
    private int resultGame;
    private Choice choice;

    public Game(int id, User user, Date timeCreate, int resultGame, Choice choice) {
        this.id = id;
        this.user = user;
        this.timeCreate = timeCreate;
        this.resultGame = resultGame;
        this.choice = choice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public int getResultGame() {
        return resultGame;
    }

    public void setResultGame(int resultGame) {
        this.resultGame = resultGame;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
    
    public static enum Choice{
        BUA,
        KEO,
        BAO
    }
}
