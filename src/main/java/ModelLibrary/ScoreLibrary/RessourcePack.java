/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.ScoreLibrary;

import EnumLibrary.Resource;

/**
 *
 * @author Hicham
 */
public class RessourcePack {
    private Resource type;
    private int value;

    public RessourcePack() {
        
    }
    
    public RessourcePack(Resource type, int value) {
        this.type = type;
        this.value = value;
    }

    public Resource getType() {
        return type;
    }

    public void setType(Resource type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cost{" + "type=" + type + ", value=" + value + '}';
    }
    
    
    
    
}
