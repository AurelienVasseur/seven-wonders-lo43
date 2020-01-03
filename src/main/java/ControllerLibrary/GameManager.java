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
 * @author Hicham, Aurélien
 */
public class GameManager {
    protected ArrayList<Player> listPlayers;
    int age;
    int lap; // tour de jeu

    public GameManager() {
    }

    public GameManager(ArrayList<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }
    
    public GameManager(PlayersAmount playersAmount) {
        int numberOfPlayers = playersAmount.getValue();
        this.listPlayers = new ArrayList<Player>();
        //ArrayList<UT> listUT = this.fetchShuffledUT();
        for(int i = 0; i < numberOfPlayers; ++i) {
            this.listPlayers.add(new Player()); // Pour tester - à supprimer
            //this.listPlayers.add(new Player(listUT.get(0)));
            //listUT.remove(0);
            
            System.out.println("joueur " + i);
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
        this.initializePlayers();
        
        this.age = 1;
        this.lap = 1;
        this.initAge();
        System.out.println("Age : " + this.age + " / Tour : " + this.lap);
    }
    
    public void initializePlayers() {
        for(int i = 0; i < this.listPlayers.size(); ++i) {
            // Initialize player 
            this.listPlayers.get(i).initialize();
        }
    }
    
    public boolean checkIfPlayersValidate() {
        boolean test = true;
        for(int i = 0; (i < this.listPlayers.size()) && (test == true); ++i) {
            if(this.listPlayers.get(i).getIsValidate() != true) {
                test = false;
            }
        }
        if(test == true) {
            System.out.println("Joueurs READY");
        } else {
            System.out.println("Joueurs NON READY");
        }
        return test;
    }
    
    public void playTurn() {
        System.out.println("GameManager : playTurn");
        
        // Gestion des actions sélectionnées par les joueurs
        System.out.println("GameManager : players do action");
        for(int i = 0; i < this.listPlayers.size(); ++i) {
            this.listPlayers.get(i).doAction();
        }
        // Passage à la main suivante
        System.out.println("GameManager : players change deck");
        Deck deckPlayerBefore = this.listPlayers.get(this.listPlayers.size()-1).getDeck();
        Deck deckTmp;
        for(int i = 0; i < this.listPlayers.size(); ++i) {
            Player player = this.listPlayers.get(i);
            deckTmp = player.getDeck();
            player.setDeck(deckPlayerBefore);
            this.listPlayers.set(i, player);
            deckPlayerBefore = deckTmp;
        }
        
        // Passage au tour suivant
        this.nextLap();
        
        this.initializePlayers();
    }
    
    // Gestion passage au tour / à l'âge suivant
    public void nextLap() {
        if(this.lap < 6) {
            this.lap++;
           
        } else {
            if(this.age < 3) {
                this.age++;
                this.lap = 1;
                this.initAge();
            } else {
                this.end();
            }
        }
    }
    
    public void initAge() {
        // 1. Générer le deck correspondant à l'âge
        Deck deck = new Deck();
        switch (this.age) {
            case 1:
                //deck = this.getDeckForAge(Formation.COMMONCORE);  // A ACTIVER !!!
                break;
            case 2:
                //deck = this.getDeckForAge(Formation.BRANCH);  // A ACTIVER !!!
                break;
            case 3:
                //deck = this.getDeckForAge(Formation.SPECIALIZATION);  // A ACTIVER !!!
                break;
            default:
                break;
        }
        // 2. Mélanger les  cartes
        //deck.shuffle();        // A ACTIVER !!!
        // 3. Distribuer les cartes
        //this.distributeCards(deck);        // A ACTIVER !!!
    }
    
    public void updateLeaderboard() {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    // Gestion de la fin de la partie
    public void end() {
        //throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
        System.out.println("Game Manager : end game");
    }
    
    
    
    
    
    

    public ArrayList<Player> getListPlayers() {
        return listPlayers;
    }

    public void setListPlayers(ArrayList<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }
    
    public Player getPlayer(int id) {
        return listPlayers.get(id);
    }
    
    public void setPlayer(Player player, int id) {
        this.listPlayers.set(id, player);
    }
    
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public int getLap() {
        return this.lap;
    }
    
    public void setLap(int lap) {
        this.lap = lap;
    }
    
    @Override
    public String toString() {
        return "GameManager{" + "listPlayers=" + listPlayers + '}';
    }
    
    
}
