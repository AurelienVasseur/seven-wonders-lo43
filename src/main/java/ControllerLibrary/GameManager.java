/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLibrary;

import EnumLibrary.Formation;
import EnumLibrary.PlayersAmount;
import ModelLibrary.PlayerLibrary.Deck;
import ModelLibrary.PlayerLibrary.Player;
import ModelLibrary.PlayerLibrary.UT;
import UtilsLibrary.JSON;
import java.util.ArrayList;
import java.util.Collections;

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
    
    public GameManager(PlayersAmount playersAmount) {
        int numberOfPlayers = playersAmount.getValue();
        this.listPlayers = new ArrayList<Player>();
        ArrayList<UT> listUT = this.fetchShuffledUT();
        for(int i = 0; i < numberOfPlayers; ++i) {
            this.listPlayers.add(new Player(listUT.get(0)));
            listUT.remove(0);
        }
    }
    
    private ArrayList<UT> fetchShuffledUT() {
        // TODO : Attribuer au hasard une merveille au joueur
        ArrayList<UT> listUT = JSON.readUTs("ut.json");
        Collections.shuffle(listUT);
        return listUT;
    }
    
    private Deck getDeckForAge(Formation formation) {
        // Récupérer toutes les cartes en base, les tri en fonction de l'age et du nombre de joueur
        Deck allCards = new Deck(JSON.readCards("cards.json"));
        Deck ageCards = allCards.filterByFormation(formation);
        return ageCards;
    }
    
    private void distributeCards(Deck currentAgeDeck) {
        for(int i = 0; i < this.listPlayers.size(); ++i) {
            Deck playerDeck = currentAgeDeck.subDeck(7*i, 7*i + 7);
            this.listPlayers.get(i).setDeck(playerDeck);
        }
    }
    
    public void start() {
        // 1. Générer le deck pour le premier age
        Deck firstAgeDeck = this.getDeckForAge(Formation.COMMONCORE);
        // 2. Mélanger les cartes
        firstAgeDeck.shuffle();
        // 3. Distribuer les cartes du deck aux joueurs
        this.distributeCards(firstAgeDeck);
        
        // 4. Proposer aux joueurs de jouer leur tour
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    public void playTurn() {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    public void updateLeaderboard() {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    public void end() {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
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
