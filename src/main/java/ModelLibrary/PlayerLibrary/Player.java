/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

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

    public Player(UT gameBoard, Score score, Deck deck, Deck cardsPlayed) {
        this.gameBoard = gameBoard;
        this.score = score;
        this.deck = deck;
        this.cardsPlayed = cardsPlayed;
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
