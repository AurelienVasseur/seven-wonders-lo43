/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.ScoreLibrary;

/**
 *
 * @author Hicham
 */
public class Score {
    private Point military;
    private Point coin;
    private Point wonder;
    private Point civilian;
    private Point scientific;
    private Point commercial;
    private Point guild;

    public Score() {
    }

    public Score(Point military, Point coin, Point wonder, Point civilian, Point scientific, Point commercial, Point guild) {
        this.military = military;
        this.coin = coin;
        this.wonder = wonder;
        this.civilian = civilian;
        this.scientific = scientific;
        this.commercial = commercial;
        this.guild = guild;
    }

    public Point getMilitary() {
        return military;
    }

    public void setMilitary(Point military) {
        this.military = military;
    }

    public Point getCoin() {
        return coin;
    }

    public void setCoin(Point coin) {
        this.coin = coin;
    }

    public Point getWonder() {
        return wonder;
    }

    public void setWonder(Point wonder) {
        this.wonder = wonder;
    }

    public Point getCivilian() {
        return civilian;
    }

    public void setCivilian(Point civilian) {
        this.civilian = civilian;
    }

    public Point getScientific() {
        return scientific;
    }

    public void setScientific(Point scientific) {
        this.scientific = scientific;
    }

    public Point getCommercial() {
        return commercial;
    }

    public void setCommercial(Point commercial) {
        this.commercial = commercial;
    }

    public Point getGuild() {
        return guild;
    }

    public void setGuild(Point guild) {
        this.guild = guild;
    }

    @Override
    public String toString() {
        return "Score{" + "military=" + military + ", coin=" + coin + ", wonder=" + wonder + ", civilian=" + civilian + ", scientific=" + scientific + ", commercial=" + commercial + ", guild=" + guild + '}';
    }
    
    
}
