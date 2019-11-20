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
    protected String name;
    protected CardType type;
    protected Cost cost;
    protected Age age;
    protected Point coinsEarned;
    protected List<ProductedResource> production;
    protected PlayersAmount minimumPlayersRequiredToBePlayed;
    protected List<Card> cardsBecomingFreeAfterPlayingThisCard;
    protected Card cardRequiredToBePlayedBeforeInOrderToPlayThisCardForFree;
}
