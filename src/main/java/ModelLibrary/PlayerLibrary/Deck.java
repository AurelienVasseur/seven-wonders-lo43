/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

import ModelLibrary.CardLibrary.Card;
import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public class Deck {
    private ArrayList<Card> listCards;

    public Deck() {
    }

    public Deck(ArrayList<Card> listCards) {
        this.listCards = listCards;
    }

    
    public void shuffle() {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    
    
    
    
    
    public ArrayList<Card> getListCards() {
        return listCards;
    }

    public void setListCards(ArrayList<Card> listCards) {
        this.listCards = listCards;
    }

    @Override
    public String toString() {
        return "Deck{" + "listCards=" + listCards + '}';
    }
    
    
}
