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
 * @author Hicham, Aurélien
 */
public class Deck {
    private ArrayList<Card> listCards;

    public Deck() {
        this.listCards = new ArrayList<Card>();
    }

    public Deck(ArrayList<Card> listCards) {
        this.listCards = listCards;
    }

    /**
     * Mélange le deck
     */
    public void shuffle() {
        Collections.shuffle(this.listCards);
    }
    
    /**
     * Filtre les cartes par formation (age)
     */
    public Deck filterByFormation(Formation formation) {
        ArrayList<Card> filteredCards = this.getListCards();
        filteredCards.removeIf(card -> (card.getFormation().getValue() != formation.getValue()));
        System.out.println("Result filterByFormation : " + filteredCards.size() + " cards");
        return new Deck(filteredCards);
    }
    
    /**
     * Filtre les cartes par nombre de joueurs
     */
    public Deck filterByPlayersAmount(PlayersAmount playersAmount) {
        //ArrayList<Card> filteredCards = this.getListCards();
        ArrayList<Card> filteredCards = new ArrayList<Card>();
        // Cas particuler si 2 joueurs il faut également prendre les cartes avec minimum 3 joueurs
        PlayersAmount nbPlayers;
        if(playersAmount == PlayersAmount.TWO) {
            nbPlayers = PlayersAmount.THREE;
        } else {
            nbPlayers = playersAmount;
        }
        filteredCards.removeIf(card -> ((card.getMinimumPlayersRequiredToBePlayed().getValue() > nbPlayers.getValue())));
        for(int i=0; i< this.getListCards().size(); i++) {
            if(this.getListCards().get(i).getMinimumPlayersRequiredToBePlayed().getValue() <= nbPlayers.getValue()) {
                filteredCards.add(this.getListCards().get(i));
            }
        }
        System.out.println("Result filterByPlayersAmount : " + filteredCards.size() + " cards");
        return new Deck (filteredCards);
    }
    
    /**
     * Récupère une partie du deck
     */
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
