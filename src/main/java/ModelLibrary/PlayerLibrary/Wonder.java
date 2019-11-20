/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

/**
 *
 * @author Hicham
 */
public class Wonder {
    private Deck deck;
    private Deck playedCards;

    public Wonder() {
    }
    
    public Wonder(Deck deck, Deck playedCards) {
        this.deck = deck;
        this.playedCards = playedCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Deck getPlayedCards() {
        return playedCards;
    }

    public void setPlayedCards(Deck playedCards) {
        this.playedCards = playedCards;
    }

    @Override
    public String toString() {
        return "Wonder{" + "deck=" + deck + ", playedCards=" + playedCards + '}';
    }
    
    
    
}
