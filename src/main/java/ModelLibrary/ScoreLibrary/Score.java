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
    private Point finalScore;
    private Point totalVictoryPoints;
    private Point coin;
    private Point knowledge;
    private Point association;
    private Point centrifuge;
    private Point pump;
    private Point proofer;

    public Score() {
        this.finalScore = new Point();
        this.totalVictoryPoints = new Point();
        this.knowledge = new Point();
        this.coin = new Point();
        this.association = new Point();
        this.centrifuge = new Point();
        this.pump = new Point();
        this.proofer = new Point();
    }

    public Score(Point finalScore, Point totalVictoryPoints, Point coin, Point knowledge, Point association, Point centrifuge, Point pump, Point proofer) {
        this.finalScore = finalScore;
        this.totalVictoryPoints = totalVictoryPoints;
        this.coin = coin;
        this.knowledge = knowledge;
        this.association = association;
        this.centrifuge = centrifuge;
        this.pump = pump;
        this.proofer = proofer;
    }

    public Point getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Point finalScore) {
        this.finalScore = finalScore;
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

    public Point getCentrifuge() {
        return centrifuge;
    }

    public void setCentrifuge(Point centrifuge) {
        this.centrifuge = centrifuge;
    }

    public Point getPump() {
        return pump;
    }

    public void setPump(Point pump) {
        this.pump = pump;
    }

    public Point getProofer() {
        return proofer;
    }

    public void setProofer(Point proofer) {
        this.proofer = proofer;
    }

    @Override
    public String toString() {
        return "Score{" + "finalScore=" + finalScore + ", totalVictoryPoints=" + totalVictoryPoints + ", coin=" + coin + ", knowledge=" + knowledge + ", association=" + association + ", centrifuge=" + centrifuge + ", pump=" + pump + ", proofer=" + proofer + '}';
    }
    
}
