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
// Formation = Age
public enum Formation {
    COMMONCORE(0),
    BRANCH(1),
    SPECIALIZATION(2);
    
    private final int value;
    private Formation(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
}
