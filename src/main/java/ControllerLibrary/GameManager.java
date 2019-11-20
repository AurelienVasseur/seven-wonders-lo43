/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLibrary;

import ModelLibrary.PlayerLibrary.Player;
import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public class GameManager {
    private ArrayList<Player> listPlayers;

    public GameManager() {
    }

    public GameManager(ArrayList<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public ArrayList<Player> getListPlayers() {
        return listPlayers;
    }

    public void setListPlayers(ArrayList<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    @Override
    public String toString() {
        return "GameManager{" + "listPlayers=" + listPlayers + '}';
    }
    
    
}
