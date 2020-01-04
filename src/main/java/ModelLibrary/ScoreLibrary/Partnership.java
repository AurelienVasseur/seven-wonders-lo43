/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.ScoreLibrary;

import EnumLibrary.Neighbour;
import EnumLibrary.Resource;
import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public class Partnership {
    
    protected Neighbour neighbour;
    protected ArrayList<Resource> concernedRessources;
    protected int newCoinCost;

    public Partnership() {
    }

    public Partnership(Neighbour neighbour, ArrayList<Resource> concernedRessources, int newCoinCost) {
        this.neighbour = neighbour;
        this.concernedRessources = concernedRessources;
        this.newCoinCost = newCoinCost;
    }

    public Neighbour getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(Neighbour neighbour) {
        this.neighbour = neighbour;
    }

    public ArrayList<Resource> getConcernedRessources() {
        return concernedRessources;
    }

    public void setConcernedRessources(ArrayList<Resource> concernedRessources) {
        this.concernedRessources = concernedRessources;
    }

    public int getNewCoinCost() {
        return newCoinCost;
    }

    public void setNewCoinCost(int newCoinCost) {
        this.newCoinCost = newCoinCost;
    }

    @Override
    public String toString() {
        return "Partnership{" + "neighbour=" + neighbour + ", concernedRessources=" + concernedRessources + ", newCoinCost=" + newCoinCost + '}';
    }
    
    
    
}
