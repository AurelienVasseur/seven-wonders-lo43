/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.ScoreLibrary;

import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public class Step {
    protected Point coinsEarned;
    protected ArrayList<RessourcePack> cost;

    public Step() {
    }

    public Step(Point coinsEarned, ArrayList<RessourcePack> cost) {
        this.coinsEarned = coinsEarned;
        this.cost = cost;
    }

    public Point getCoinsEarned() {
        return coinsEarned;
    }

    public void setCoinsEarned(Point coinsEarned) {
        this.coinsEarned = coinsEarned;
    }

    public ArrayList<RessourcePack> getCost() {
        return cost;
    }

    public void setCost(ArrayList<RessourcePack> cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Step{" + "coinsEarned=" + coinsEarned + ", cost=" + cost + '}';
    }
    
    
}
