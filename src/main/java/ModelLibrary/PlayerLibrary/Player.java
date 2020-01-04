/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

import EnumLibrary.Action;
import ModelLibrary.CardLibrary.Card;
import ModelLibrary.ScoreLibrary.Score;
import ModelLibrary.ScoreLibrary.Point;
import ModelLibrary.ScoreLibrary.ProductedResource;
import ModelLibrary.ScoreLibrary.RessourcePack;
import java.util.ArrayList;

/**
 *
 * @author Hicham, Aurélien
 */
public class Player {
    private UT gameBoard;
    private Score score;
    private Deck deck;
    private Deck cardsPlayed;
    private Action actionSelected;
    private Card cardSelected;
    private boolean isValidate; // A validé son tour de jeu

    public Player() {
        this.gameBoard = new UT();
        this.score = new Score();
        this.deck = new Deck();
        this.cardsPlayed = new Deck();
        
        /* Cartes test -- A SUPPRIMER */
        Card card = new Card();   
        card.setId(0);
        card.setName("Carte deck 1");
        this.deck.addCard(card);
        Card card2 = new Card();
        card2.setId(1);
        card2.setName("Carte deck 2");
        this.deck.addCard(card2);
        
        Card card3 = new Card();
        card3.setId(2);
        card3.setName("Carte played");
        this.cardsPlayed.addCard(card3);
        /* ----- */
    }

    public Player(UT gameBoard) {
        this.gameBoard = gameBoard;
        this.score = new Score();
        this.deck = new Deck();
        this.cardsPlayed = new Deck();
    }
    
    public Player(UT gameBoard, Score score, Deck deck, Deck cardsPlayed) {
        this.gameBoard = gameBoard;
        this.score = score;
        this.deck = deck;
        this.cardsPlayed = cardsPlayed;
    }
    
    public void initialize() {
        this.setIsValidate(false);
        //this.setCardSelected(null);
        //this.setActionSelected(null); 
    }
    
    public void doAction() {
        // Action 1. BUILD
        if (this.actionSelected == Action.BUILD) {
            System.out.println("Player.doAction : BUILD");
            // Vérification si ressources nécessaires
            if(this.checkResourcesToPlayCard(this.cardSelected) == true) {
                // Achat de la carte
                this.buyCard(this.getCardSelected());
                // On retire la carte du deck
                this.deck.removeCard(this.cardSelected);
                // On ajoute la carte dans la liste des cartes jouées
                this.cardsPlayed.addCard(this.cardSelected);
            }
        }
        // Action 2. BUY
        if (this.actionSelected == Action.BUY) {
            System.out.println("Player.doAction : BUY");
            // TODO
        }
        // Action 3. EVOLVE
        if (this.actionSelected == Action.EVOLVE) {
            System.out.println("Player.doAction : EVOLVE");
            System.out.println("Player.doAction : carteSelected : " + this.cardSelected.getName());
            this.deck.removeCard(cardSelected);
            this.gameBoard.evolve();
        }
        // Action 4. DISCARD
        if (this.actionSelected == Action.DISCARD) {
            System.out.println("Player.doAction : DISCARD");
            System.out.println("Player.doAction : carteSelected : " + this.cardSelected.getName());
            // On défausse la carte 
            this.deck.removeCard(this.cardSelected);
            // Le joueur gagne 3 pièces
            Point coin = this.score.getCoin();
            coin.setValue(coin.getValue() + 3);
            this.score.setCoin(coin);
        }
    }
    
    public void selectCard() {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    public void giveDeckTo(Player player) {
        throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
    }
    
    // Vérifie si le joueur à assez de ressources pour jouer la carte
    public boolean checkResourcesToPlayCard(Card card) {
        // 1. Récupération du prix de la carte
        ArrayList<RessourcePack> cost = card.getCost();
        // 2. On calcul la quantité de la nécessaire possédée par le joueur 
        //    Il faut parcourir l'ensemble des cartes jouées par le joueur 
        int totalValueGetByPlayer = 0;
        for(int i=0; i<this.cardsPlayed.getListCards().size(); i++) {
            Card cardPlayed = this.cardsPlayed.getListCards().get(i);
            for(int j=0; j<cardPlayed.getListProductRessources().size(); i++) {
                RessourcePack productedResource = cardPlayed.getListProductRessources().get(j);
                // ATTENTION, A REVOIR LE IF CI DESSOUS
                if(cost.get(0).getType() == productedResource.getType()) {
                    totalValueGetByPlayer = totalValueGetByPlayer + productedResource.getValue();
                }
            }
        }
        // 3. Vérification si le joueur à les ressources nécessaires
        // ATTENTION, A REVOIR LE IF CI DESSOUS
        if(totalValueGetByPlayer == cost.get(0).getValue()) {
            // Le joueur peut acheter la carte
            return true;
        } else {
            // Le joueur ne peut pas acheter la carte
            return false;
        }
    }
    
    // Achat d'une carte -> dépense des ressources nécessaires
    public void buyCard(Card card) {
        // TODO
        //throw new java.lang.UnsupportedOperationException("Not Implemented yet.");
        
        // 1. Récupération du prix de la carte
        // 2. Achat de la carte
    }
    
    public UT getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(UT gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    
    public Card getCardDeckByName(String name) {
        return this.deck.getCardByName(name);
    }

    public Deck getCardsPlayed() {
        return cardsPlayed;
    }

    public void setCardsPlayed(Deck cardsPlayed) {
        this.cardsPlayed = cardsPlayed;
    }
    
    public Action getActionSelected() {
        return actionSelected;
    }

    public void setActionSelected(Action actionSelected) {
        this.actionSelected = actionSelected;
        System.out.println("Action selected : " + this.actionSelected);
    }
    
    public Card getCardSelected() {
        return cardSelected;
    }

    public void setCardSelected(Card cardSelected) {
        this.cardSelected = cardSelected;
        System.out.println("Card selected : " + this.cardSelected.getName());
    }
    
    public boolean getIsValidate() {
        return this.isValidate;
    }
    
    public void setIsValidate(boolean isValidate) {
        this.isValidate = isValidate;
    }

    @Override
    public String toString() {
        return "Player{" + "gameBoard=" + gameBoard + ", score=" + score + ", deck=" + deck + ", cardsPlayed=" + cardsPlayed + '}';
    }

    
    
}
