/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnumLibrary;

/**
 *
 * @author Hicham, Aurélien
 */
public enum PlayersAmount {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    MINIMUM(2),
    MAXIMUM(7);
    
    private final int value;
    private PlayersAmount(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
}
