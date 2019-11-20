/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.CardLibrary;


import java.util.List;
import EnumLibrary.CardType;
import EnumLibrary.Age;
import EnumLibrary.PlayersAmount;
import ModelLibrary.ScoreLibrary.Point;
import ModelLibrary.ScoreLibrary.Cost;
import ModelLibrary.ScoreLibrary.ProductedResource;

/**
 *
 * @author Hicham
 */
public class Card {
    protected int id;
    protected String name;
    protected CardType type;
    protected Cost cost;
    protected Age age;
    protected Point coinsEarned;
    protected List<ProductedResource> production;
    protected PlayersAmount minimumPlayersRequiredToBePlayed;
    protected List<Card> cardsBecomingFreeAfterPlayingThisCard;
    protected Card cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree;

    public Card(){
        
    }
    
    public Card(int id, String name, CardType type, Cost cost, Age age, Point coinsEarned, List<ProductedResource> production, PlayersAmount minimumPlayersRequiredToBePlayed, List<Card> cardsBecomingFreeAfterPlayingThisCard, Card cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.age = age;
        this.coinsEarned = coinsEarned;
        this.production = production;
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

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Point getCoinsEarned() {
        return coinsEarned;
    }

    public void setCoinsEarned(Point coinsEarned) {
        this.coinsEarned = coinsEarned;
    }

    public List<ProductedResource> getProduction() {
        return production;
    }

    public void setProduction(List<ProductedResource> production) {
        this.production = production;
    }

    public PlayersAmount getMinimumPlayersRequiredToBePlayed() {
        return minimumPlayersRequiredToBePlayed;
    }

    public void setMinimumPlayersRequiredToBePlayed(PlayersAmount minimumPlayersRequiredToBePlayed) {
        this.minimumPlayersRequiredToBePlayed = minimumPlayersRequiredToBePlayed;
    }

    public List<Card> getCardsBecomingFreeAfterPlayingThisCard() {
        return cardsBecomingFreeAfterPlayingThisCard;
    }

    public void setCardsBecomingFreeAfterPlayingThisCard(List<Card> cardsBecomingFreeAfterPlayingThisCard) {
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
        return "Card{" + "id=" + id + ", name=" + name + ", type=" + type + ", cost=" + cost + ", age=" + age + ", coinsEarned=" + coinsEarned + ", production=" + production + ", minimumPlayersRequiredToBePlayed=" + minimumPlayersRequiredToBePlayed + ", cardsBecomingFreeAfterPlayingThisCard=" + cardsBecomingFreeAfterPlayingThisCard + ", cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree=" + cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree + '}';
    }
    
    
}
