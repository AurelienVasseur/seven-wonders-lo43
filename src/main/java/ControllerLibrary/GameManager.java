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
import ModelLibrary.ScoreLibrary.Score;
import UtilsLibrary.JSON;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Hicham, Aurélien
 */
public class GameManager {
    protected ArrayList<Player> listPlayers;
    Formation age;
    int lap; // tour de jeu
    boolean endGame; // indique si la partie est terminée

    public GameManager() {
        this.endGame = false;
    }

    public GameManager(ArrayList<Player> listPlayers) {
        this.endGame = false;
        this.listPlayers = listPlayers;
    }
    
    public GameManager(PlayersAmount playersAmount) {
        this.endGame = false;
        int numberOfPlayers = playersAmount.getValue();
        this.listPlayers = new ArrayList<Player>();
        ArrayList<UT> listUT = this.fetchShuffledUT();
        for(int i = 0; i < numberOfPlayers; ++i) {
            //this.listPlayers.add(new Player()); // Pour tester - à supprimer
            this.listPlayers.add(new Player(listUT.get(i)));
            //listUT.remove(0);
            
            System.out.println("joueur " + i);
        }
    }
    
    private ArrayList<UT> fetchShuffledUT() {
        // TODO : Attribuer au hasard une merveille au joueur
        ArrayList<UT> listUT = JSON.readUTs("uts.json");
        Collections.shuffle(listUT);
        return listUT;
    }
    
    private Deck getDeckForAge(Formation formation) {
        // 1. Récupérer toutes les cartes en base
        Deck allCards = null;
        switch(formation) {
            case COMMONCORE:
                allCards = new Deck(JSON.readCards("cards.json"));
                break;
            case BRANCH:
                allCards = new Deck(JSON.readCards("cards2.json"));
                break;
            case SPECIALIZATION:
                allCards = new Deck(JSON.readCards("cards3.json"));
                break;
        }
        // 2. Tri en fonction de l'âge
        Deck ageCards = allCards.filterByFormation(formation);
        // 3. Tri en fonction du nombre de joueurs
        PlayersAmount playersAmount;
        int nbPlayers = this.listPlayers.size();
        if(nbPlayers == 2) {
            playersAmount = PlayersAmount.TWO;
        } else if(nbPlayers == 3) {
            playersAmount = PlayersAmount.THREE;
        } else if(nbPlayers == 4) {
            playersAmount = PlayersAmount.FOUR;
        } else if(nbPlayers == 5) {
            playersAmount = PlayersAmount.FIVE;
        } else if(nbPlayers == 6) {
            playersAmount = PlayersAmount.SIX;
        } else {
            playersAmount = PlayersAmount.SEVEN;
        }
        Deck gameCards = ageCards.filterByPlayersAmount(playersAmount);
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
        
        this.age = Formation.COMMONCORE;
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
            this.endAge(); // bataille militaire
            if(this.age.getValue() < 2) {
                switch(this.age) {
                    case COMMONCORE:
                        this.age = Formation.BRANCH;
                        break;
                    case BRANCH:
                        this.age = Formation.SPECIALIZATION;
                        break;
                }
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
        deck = this.getDeckForAge(this.age);
        // 2. Mélanger les  cartes
        deck.shuffle();        
        // 3. Distribuer les cartes
        this.distributeCards(deck);        
    }
    
    public void endAge() {
        //bataille militaire
        for(int i = 0; i < this.listPlayers.size(); ++i) {
            int previousPlayerId = i - 1;
            int nextPlayerId = i + 1;
            if(i == 0) {
                previousPlayerId = listPlayers.size() - 1;
            }
            if(i == (listPlayers.size() - 1)) {
                nextPlayerId = 0;
            }
            Player previousPlayer = listPlayers.get(previousPlayerId);
            Player currentPlayer = listPlayers.get(i);
            Player nextPlayer = listPlayers.get(nextPlayerId);
            // current player wins if it has more military points than his neighbours
            if(currentPlayer.getScore().getKnowledge().getValue() > previousPlayer.getScore().getKnowledge().getValue() && currentPlayer.getScore().getKnowledge().getValue() > nextPlayer.getScore().getKnowledge().getValue()) {
                currentPlayer.getScore().getTotalVictoryPoints().setValue(currentPlayer.getScore().getTotalVictoryPoints().getValue() + (2 * this.age.getValue() + 1));
            }
            else {
                currentPlayer.getScore().getTotalVictoryPoints().setValue(currentPlayer.getScore().getTotalVictoryPoints().getValue() - 1);
            }
        }
    }
    
    public ArrayList<Score> fetchScores() {
        ArrayList<Score> scores = new ArrayList<Score>();
        this.listPlayers.forEach((player) -> {
            //Calculate final score
            int centrifugePoints = player.getScore().getCentrifuge().getValue() * player.getScore().getCentrifuge().getValue();
            int pumpPoints = player.getScore().getPump().getValue() * player.getScore().getPump().getValue();
            int prooferPoints = player.getScore().getProofer().getValue() * player.getScore().getProofer().getValue();
            int laboPoints = centrifugePoints + pumpPoints + prooferPoints;
            int score = player.getScore().getTotalVictoryPoints().getValue() + player.getScore().getKnowledge().getValue() + (player.getScore().getCoin().getValue() / 3) + laboPoints;
            // set final score to user's Score
            player.getScore().getFinalScore().setValue(score);
            // add to result list
            scores.add(player.getScore());
        });
        return scores;
    }
    
    // Gestion de la fin de la partie
    public void end() {
        //throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
        System.out.println("Game Manager : end game");
        // 1. On détermine le classement
        // TODO
        // 2. On indique que la partie est terminée
        this.endGame = true;
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
    
    public Formation getAge() {
        return this.age;
    }

    public void setAge(Formation age) {
        this.age = age;
    }
    
    public int getLap() {
        return this.lap;
    }
    
    public void setLap(int lap) {
        this.lap = lap;
    }
    
    public boolean getEndGame() {
        return this.endGame;
    }
    
    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }
    
    @Override
    public String toString() {
        return "GameManager{" + "listPlayers=" + listPlayers + '}';
    }
    
    
}
