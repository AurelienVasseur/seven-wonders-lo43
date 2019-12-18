/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

import EnumLibrary.Evolution;
import EnumLibrary.UTCity;
import ModelLibrary.ScoreLibrary.RessourcePack;
import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public class UT {
    private int id;
    private UTCity name;
    private Evolution evolution;
    private ArrayList<RessourcePack> listProductRessources;

    public UT() {
    }

    public UT(int id, UTCity name, Evolution evolution, ArrayList<RessourcePack> listProductRessources) {
        this.id = id;
        this.name = name;
        this.evolution = evolution;
        this.listProductRessources = listProductRessources;
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

    public ArrayList<RessourcePack> getListProductRessources() {
        return listProductRessources;
    }

    public void setListProductRessources(ArrayList<RessourcePack> listProductRessources) {
        this.listProductRessources = listProductRessources;
    }

    @Override
    public String toString() {
        return "UT{" + "id=" + id + ", name=" + name + ", evolution=" + evolution + ", listProductRessources=" + listProductRessources + '}';
    }

    
    
}
