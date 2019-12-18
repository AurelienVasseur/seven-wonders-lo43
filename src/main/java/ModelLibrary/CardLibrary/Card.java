/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.CardLibrary;


import EnumLibrary.CardType;
import EnumLibrary.Formation;
import EnumLibrary.PlayersAmount;
import ModelLibrary.ScoreLibrary.Point;
import ModelLibrary.ScoreLibrary.RessourcePack;
import ModelLibrary.ScoreLibrary.ProductedResource;
import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public class Card {
    protected int id;
    protected String name;
    protected CardType type;
    protected RessourcePack cost;
    protected Formation formation;
    protected Point coinsEarned;
    protected ArrayList<ProductedResource> listProductRessources;
    protected PlayersAmount minimumPlayersRequiredToBePlayed;
    protected ArrayList<Card> cardsBecomingFreeAfterPlayingThisCard;
    protected Card cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree;

    public Card() {
    }

    public Card(int id, String name, CardType type, RessourcePack cost, Formation formation, Point coinsEarned, ArrayList<ProductedResource> listProductRessources, PlayersAmount minimumPlayersRequiredToBePlayed, ArrayList<Card> cardsBecomingFreeAfterPlayingThisCard, Card cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.formation = formation;
        this.coinsEarned = coinsEarned;
        this.listProductRessources = listProductRessources;
        this.minimumPlayersRequiredToBePlayed = minimumPlayersRequiredToBePlayed;
        this.cardsBecomingFreeAfterPlayingThisCard = cardsBecomingFreeAfterPlayingThisCard;
        this.cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree = cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public RessourcePack getCost() {
        return cost;
    }

    public void setCost(RessourcePack cost) {
        this.cost = cost;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Point getCoinsEarned() {
        return coinsEarned;
    }

    public void setCoinsEarned(Point coinsEarned) {
        this.coinsEarned = coinsEarned;
    }

    public ArrayList<ProductedResource> getListProductRessources() {
        return listProductRessources;
    }

    public void setListProductRessources(ArrayList<ProductedResource> listProductRessources) {
        this.listProductRessources = listProductRessources;
    }

    public PlayersAmount getMinimumPlayersRequiredToBePlayed() {
        return minimumPlayersRequiredToBePlayed;
    }

    public void setMinimumPlayersRequiredToBePlayed(PlayersAmount minimumPlayersRequiredToBePlayed) {
        this.minimumPlayersRequiredToBePlayed = minimumPlayersRequiredToBePlayed;
    }

    public ArrayList<Card> getCardsBecomingFreeAfterPlayingThisCard() {
        return cardsBecomingFreeAfterPlayingThisCard;
    }

    public void setCardsBecomingFreeAfterPlayingThisCard(ArrayList<Card> cardsBecomingFreeAfterPlayingThisCard) {
        this.cardsBecomingFreeAfterPlayingThisCard = cardsBecomingFreeAfterPlayingThisCard;
    }

    public Card getCardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree() {
        return cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree;
    }

    public void setCardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree(Card cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree) {
        this.cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree = cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree;
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", name=" + name + ", type=" + type + ", cost=" + cost + ", formation=" + formation + ", coinsEarned=" + coinsEarned + ", listProductRessources=" + listProductRessources + ", minimumPlayersRequiredToBePlayed=" + minimumPlayersRequiredToBePlayed + ", cardsBecomingFreeAfterPlayingThisCard=" + cardsBecomingFreeAfterPlayingThisCard + ", cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree=" + cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree + '}';
    }

    
    
}
