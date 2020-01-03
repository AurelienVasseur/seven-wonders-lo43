/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

import EnumLibrary.Action;
import ModelLibrary.CardLibrary.Card;
import ModelLibrary.ScoreLibrary.Score;
import ModelLibrary.ScoreLibrary.Point;

/**
 *
 * @author Hicham, Aurélien
 */
public class Player {
    private UT gameBoard;
    private Score score;
    private Deck deck;
    private Deck cardsPlayed;
    private Action actionSelected;
    private Card cardSelected;
    private boolean isValidate; // A validé son tour de jeu

    public Player() {
    }

    public Player(UT gameBoard) {
        this.gameBoard = gameBoard;
        this.score = new Score();
        this.deck = new Deck();
        this.cardsPlayed = new Deck();
    }
    
    public Player(UT gameBoard, Score score, Deck deck, Deck cardsPlayed) {
        this.gameBoard = gameBoard;
        this.score = score;
        this.deck = deck;
        this.cardsPlayed = cardsPlayed;
    }
    
    
    public void doAction() {
        // Action 1. BUILD
        if (this.actionSelected == Action.BUILD) {
            System.out.println("Player.doAction : BUILD");
            // Vérification si ressources nécessaires
            if(this.checkResourcesToPlayCard(this.getCardSelected()) == true) {
                // Achat de la carte
                this.buyCard(this.getCardSelected());
                // On retire la carte du deck
                this.deck.removeCard(this.getCardSelected());
                this.cardsPlayed.addCard(this.cardSelected);
            }
        }
        // Action 2. BUY
        if (this.actionSelected == Action.BUY) {
            System.out.println("Player.doAction : BUY");
            // TODO
        }
        // Action 3. EVOLVE
        if (this.actionSelected == Action.EVOLVE) {
            System.out.println("Player.doAction : EVOLVE");
            this.gameBoard.evolve();
        }
        // Action 4. DISCARD
        if (this.actionSelected == Action.DISCARD) {
            System.out.println("Player.doAction : DISCARD");
            // On défausse la carte 
            this.deck.removeCard(this.cardSelected);
            // Le joueur gagne 3 pièces
            Point coin = this.score.getCoin();
            coin.setValue(coin.getValue() + 3);
            this.score.setCoin(coin);
        }
    }
    
    public void selectCard() {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    public void giveDeckTo(Player player) {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    // Vérifie si le joueur à assez de ressources pour jouer la carte
    public boolean checkResourcesToPlayCard(Card card) {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    // Achat d'une carte -> dépense des ressources nécessaires
    public void buyCard(Card card) {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    public UT getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(UT gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    
    public Card getCardDeckByName(String name) {
        return this.deck.getCardByName(name);
    }

    public Deck getCardsPlayed() {
        return cardsPlayed;
    }

    public void setCardsPlayed(Deck cardsPlayed) {
        this.cardsPlayed = cardsPlayed;
    }
    
    public Action getActionSelected() {
        return actionSelected;
    }

    public void setActionSelected(Action actionSelected) {
        this.actionSelected = actionSelected;
        System.out.println("Action selected : " + this.actionSelected);
    }
    
    public Card getCardSelected() {
        return cardSelected;
    }

    public void setCardSelected(Card cardSelected) {
        this.cardSelected = cardSelected;
        System.out.println("Card selected : " + this.cardSelected.getName());
    }
    
    public boolean getIsValidate() {
        return this.isValidate;
    }
    
    public void setIsValidate(boolean isValidate) {
        this.isValidate = isValidate;
    }

    @Override
    public String toString() {
        return "Player{" + "gameBoard=" + gameBoard + ", score=" + score + ", deck=" + deck + ", cardsPlayed=" + cardsPlayed + '}';
    }

    
    
}
