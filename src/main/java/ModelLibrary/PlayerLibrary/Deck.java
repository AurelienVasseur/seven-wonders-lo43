/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

import EnumLibrary.Formation;
import EnumLibrary.PlayersAmount;
import ModelLibrary.CardLibrary.Card;
import java.util.ArrayList;
import java.util.Collections;

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
        Collections.shuffle(this.listCards);
    }
    
    public Deck filterByFormation(Formation formation) {
        ArrayList<Card> filteredCards = this.getListCards();
        filteredCards.removeIf(card -> (card.getFormation().getValue() != formation.getValue()));
        return new Deck(filteredCards);
    }
    
    public Deck filterByPlayersAmount(PlayersAmount playersAmount) {
        ArrayList<Card> filteredCards = this.getListCards();
        filteredCards.removeIf(card -> (card.getMinimumPlayersRequiredToBePlayed().getValue() != playersAmount.getValue()));
        return new Deck (filteredCards);
    }
    
    public Deck subDeck(int fromIndex, int toIndex) {
        ArrayList<Card> subList = new ArrayList<Card>(toIndex - fromIndex);
        subList.addAll(this.listCards.subList(fromIndex, toIndex));
        return new Deck(subList);
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
