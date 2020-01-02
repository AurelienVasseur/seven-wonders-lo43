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
import java.util.function.Consumer;

/**
 *
 * @author Hicham, Aurélien
 */
public class Deck {
    private ArrayList<Card> listCards;

    public Deck() {
        Card card = new Card(); //// A SUPPRIMER - TOUT
        card.setName("Carte test");
        this.listCards = new ArrayList<Card>();
        this.listCards.add(card);
        System.out.println("Ajout carte. Size : " + this.listCards.size());
        System.out.println(card);
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
    
    public Card getCardByName(String name) {
        for(int i=0; i < (this.listCards.size()); i++) {
            if (this.listCards.get(i).getName() == null ? name == null : this.listCards.get(i).getName().equals(name)) {
                return this.listCards.get(i);
            }
        }
        return null;
    }
    
    public void addCard(Card card) {
        this.listCards.add(card);
    }
    
    public void removeCard(Card card) {
        for(int i=0; i < (this.listCards.size()); i++) {
            if (this.listCards.get(i).getId() == card.getId()) {
                this.listCards.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Deck{" + "listCards=" + listCards + '}';
    }
    
    
}
