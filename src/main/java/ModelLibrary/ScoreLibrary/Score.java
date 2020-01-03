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
    private Point classroom;
    private Point coin;
    private Point ut;
    private Point library;
    private Point laboratory;
    private Point administration;
    private Point association;

    public Score() {
        this.totalVictoryPoints = new Point();
        this.classroom = new Point();
        this.coin = new Point();
        this.ut = new Point();
        this.library = new Point();
        this.laboratory = new Point();
        this.administration = new Point();
        this.association = new Point();
    }

    public Score(Point totalVictoryPoints, Point classroom, Point coin, Point ut, Point library, Point laboratory, Point administration, Point association) {
        this.totalVictoryPoints = totalVictoryPoints;
        this.classroom = classroom;
        this.coin = coin;
        this.ut = ut;
        this.library = library;
        this.laboratory = laboratory;
        this.administration = administration;
        this.association = association;
    }

    public Point getTotalVictoryPoints() {
        return totalVictoryPoints;
    }

    public void setTotalVictoryPoints(Point totalVictoryPoints) {
        this.totalVictoryPoints = totalVictoryPoints;
    }

    public Point getClassroom() {
        return classroom;
    }

    public void setClassroom(Point classroom) {
        this.classroom = classroom;
    }

    public Point getCoin() {
        return coin;
    }

    public void setCoin(Point coin) {
        this.coin = coin;
    }

    public Point getUt() {
        return ut;
    }

    public void setUt(Point ut) {
        this.ut = ut;
    }

    public Point getLibrary() {
        return library;
    }

    public void setLibrary(Point library) {
        this.library = library;
    }

    public Point getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Point laboratory) {
        this.laboratory = laboratory;
    }

    public Point getAdministration() {
        return administration;
    }

    public void setAdministration(Point administration) {
        this.administration = administration;
    }

    public Point getAssociation() {
        return association;
    }

    public void setAssociation(Point association) {
        this.association = association;
    }

    @Override
    public String toString() {
        return "Score{" + "totalVictoryPoints=" + totalVictoryPoints + ", classroom=" + classroom + ", coin=" + coin + ", ut=" + ut + ", library=" + library + ", laboratory=" + laboratory + ", administration=" + administration + ", association=" + association + '}';
    }

    
    
}
