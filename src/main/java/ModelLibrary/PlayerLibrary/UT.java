/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

import EnumLibrary.Evolution;
import EnumLibrary.UTCity;
import ModelLibrary.ScoreLibrary.RessourcePack;
import ModelLibrary.ScoreLibrary.Step;
import java.util.ArrayList;

/**
 *
 * @author Hicham, Aurélien
 */
public class UT {
    private int id;
    private UTCity name;
    private Evolution evolution;
    private ArrayList<RessourcePack> initialProductRessources;
    private ArrayList<Step> steps;

    public UT() {
        this.evolution = Evolution.NONE;
    }

    public UT(int id, UTCity name, Evolution evolution, ArrayList<RessourcePack> initialProductRessources , ArrayList<Step> steps) {
        this.id = id;
        this.name = name;
        this.evolution = evolution;
        this.initialProductRessources = initialProductRessources;
        this.steps = steps;
    }
    
    public void evolve() {
        if(null != this.evolution) switch (this.evolution) {
            case NONE:
                this.evolution = Evolution.FIRST;
                break;
            case FIRST:
                this.evolution = Evolution.SECOND;
                break;
            case SECOND:
                this.evolution = Evolution.THIRD;
                break;
            default:
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UTCity getName() {
        return name;
    }

    public void setName(UTCity name) {
        this.name = name;
    }

    public Evolution getEvolution() {
        return evolution;
    }

    public void setEvolution(Evolution evolution) {
        this.evolution = evolution;
    }

    public ArrayList<RessourcePack> getInitialProductRessources() {
        return initialProductRessources;
    }

    public void setInitialProductRessources(ArrayList<RessourcePack> initialProductRessources) {
        this.initialProductRessources = initialProductRessources;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "UT{" + "id=" + id + ", name=" + name + ", evolution=" + evolution + ", initialProductRessources=" + initialProductRessources + ", steps=" + steps + '}';
    }

    
}
