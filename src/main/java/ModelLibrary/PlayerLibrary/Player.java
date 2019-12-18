/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

import EnumLibrary.Action;
import ModelLibrary.ScoreLibrary.Score;
import ModelLibrary.ScoreLibrary.Point;

/**
 *
 * @author Hicham
 */
public class Player {
    private UT gameBoard;
    private Score score;
    private Deck deck;
    private Deck cardsPlayed;

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
    
    
    public void doAction(Action action) {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    public void selectCard() {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    public void giveDeckTo(Player player) {
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

    public Deck getCardsPlayed() {
        return cardsPlayed;
    }

    public void setCardsPlayed(Deck cardsPlayed) {
        this.cardsPlayed = cardsPlayed;
    }

    @Override
    public String toString() {
        return "Player{" + "gameBoard=" + gameBoard + ", score=" + score + ", deck=" + deck + ", cardsPlayed=" + cardsPlayed + '}';
    }

    
    
}
