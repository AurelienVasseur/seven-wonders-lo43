/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.ScoreLibrary;

/**
 *
 * @author Hicham, Aurélien
 */
public class Score {
    private Point totalVictoryPoints;
    private Point coin;
    private Point knowledge;
    private Point association;

    public Score() {
        this.totalVictoryPoints = new Point();
        this.knowledge = new Point();
        this.coin = new Point();
        this.association = new Point();
    }

    public Score(Point totalVictoryPoints, Point coin, Point knowledge, Point association) {
        this.totalVictoryPoints = totalVictoryPoints;
        this.coin = coin;
        this.knowledge = knowledge;
        this.association = association;
    }

    public Point getTotalVictoryPoints() {
        return totalVictoryPoints;
    }

    public void setTotalVictoryPoints(Point totalVictoryPoints) {
        this.totalVictoryPoints = totalVictoryPoints;
    }

    public Point getCoin() {
        return coin;
    }

    public void setCoin(Point coin) {
        this.coin = coin;
    }

    public Point getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Point knowledge) {
        this.knowledge = knowledge;
    }

    public Point getAssociation() {
        return association;
    }

    public void setAssociation(Point association) {
        this.association = association;
    }

    @Override
    public String toString() {
        return "Score{" + "totalVictoryPoints=" + totalVictoryPoints + ", coin=" + coin + ", knowledge=" + knowledge + ", association=" + association + '}';
    }

    
}
