/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.ScoreLibrary;

import EnumLibrary.PointType;

/**
 *
 * @author Hicham
 */
public class Point {
    private PointType type;
    private int value;

    public Point() {
        
    }
    
    public Point(PointType type, int value) {
        this.type = type;
        this.value = value;
    }

    public PointType getType() {
        return type;
    }

    public void setType(PointType type) {
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
        return "Point{" + "type=" + type + ", value=" + value + '}';
    }
    
    
    
}
