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
    private int id;
    private Wonder gameBoard;
    private Score score;
    private Point victoryPoints;

    public Player() {
    }

    public Player(int id, Wonder gameBoard, Score score, Point victoryPoints) {
        this.id = id;
        this.gameBoard = gameBoard;
        this.score = score;
        this.victoryPoints = victoryPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Wonder getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Wonder gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Point getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(Point victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", gameBoard=" + gameBoard + ", score=" + score + ", victoryPoints=" + victoryPoints + '}';
    }
    
    
}
