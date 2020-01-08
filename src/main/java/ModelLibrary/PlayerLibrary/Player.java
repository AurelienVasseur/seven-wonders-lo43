/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.PlayerLibrary;

import EnumLibrary.Action;
import EnumLibrary.CardType;
import EnumLibrary.Resource;
import ModelLibrary.CardLibrary.Card;
import ModelLibrary.ScoreLibrary.Score;
import ModelLibrary.ScoreLibrary.Point;
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
    private Card cardSelectedToBuyRessources;
    private int idPlayerCardSelectedToBuyRessources;
    private boolean isValidate; // A validé son tour de jeu
    private ArrayList<RessourcePack> productedRessources;

    public Player() {
        this.gameBoard = new UT();
        this.score = new Score();
        // Argent de départ de chaque joueur
        this.initPlayerMoney();
        this.deck = new Deck();
        this.cardsPlayed = new Deck();
        this.initProductedRessources();
    }

    public Player(UT gameBoard) {
        this.gameBoard = gameBoard;
        this.score = new Score();
        // Argent de départ de chaque joueur
        this.initPlayerMoney();
        this.deck = new Deck();
        this.cardsPlayed = new Deck();
        this.initProductedRessources();
        
    }
    
    public Player(UT gameBoard, Score score, Deck deck, Deck cardsPlayed) {
        this.gameBoard = gameBoard;
        this.score = score;
        this.deck = deck;
        this.cardsPlayed = cardsPlayed;
        this.initProductedRessources();
    }
    
    /**
     * Offre 3 pièces à chaque joueur en début de partie
     */
    public void initPlayerMoney() {
        this.score.getCoin().setValue(3);
    }
    
    /**
     * Initialise toutes les ressources récoltables par le joueur à 0
     */
    public void initProductedRessources() {
        this.productedRessources = new ArrayList<RessourcePack>();
        this.productedRessources.add(new RessourcePack(Resource.CS, 0));
        this.productedRessources.add(new RessourcePack(Resource.TM, 0));
        this.productedRessources.add(new RessourcePack(Resource.CG, 0));
        this.productedRessources.add(new RessourcePack(Resource.EC, 0));
        this.productedRessources.add(new RessourcePack(Resource.STAGE, 0));
        this.productedRessources.add(new RessourcePack(Resource.PROJET, 0));
        this.productedRessources.add(new RessourcePack(Resource.ENTREPRENEURSHIP, 0));
        this.productedRessources.add(new RessourcePack(Resource.COIN, 0));
        this.cardsPlayed.getListCards().forEach((Card card) -> {
            ArrayList<RessourcePack> cardProductRessources = card.getListProductRessources();
            cardProductRessources.forEach((RessourcePack cardProductRessource) -> {
                this.productedRessources.forEach((RessourcePack playerProductedRessource) -> {
                    if(playerProductedRessource.getType() == cardProductRessource.getType()){
                        playerProductedRessource.setValue(playerProductedRessource.getValue() + cardProductRessource.getValue());
                    }
                });
            });
        });
    }
    
    /**
     * Débute le tour du joueur (affirme qu'il n'a pas terminé son tour)
     */
    public void initialize() {
        this.setIsValidate(false); 
    }
    
    /**
     * Gestion des actions possibles par le joueur
     */
    public void doAction() {
        // Action 1. BUILD
        if (this.actionSelected == Action.BUILD) {
            this.build();
        }
        // Action 2. BUY
        // BUY étant une action particulière, elle est gérée ailleurs
        // Action 3. EVOLVE
        if (this.actionSelected == Action.EVOLVE) {
            this.evolve();
        }
        // Action 4. DISCARD
        if (this.actionSelected == Action.DISCARD) {
            this.discard();            
        }
    }
    
    /**
     * Achat d'une carte, récupération des ressources et ajout aux cartes jouées
     */
    private void build() {
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
            else {
                this.deck.removeCard(this.cardSelected);
                Point coin = this.score.getCoin();
                coin.setValue(coin.getValue() - 2);
                this.score.setCoin(coin);
            }
    }
    
    /**
     * Évolution de l'UT (merveille) si les conditions sont réunies
     */
    private void evolve() {
        System.out.println("Player.doAction : EVOLVE");
            System.out.println("Player.doAction : carteSelected : " + this.cardSelected.getName());
            this.deck.removeCard(cardSelected);
            this.tryEvolveUT();
    }
    
    /**
     * Vente d'une carte contre de l'argent
     */
    private void discard() {
        System.out.println("Player.doAction : DISCARD");
            System.out.println("Player.doAction : carteSelected : " + this.cardSelected.getName());
            // On défausse la carte 
            this.deck.removeCard(this.cardSelected);
            // Le joueur gagne 3 pièces
            Point coin = this.score.getCoin();
            coin.setValue(coin.getValue() + 3);
            this.score.setCoin(coin);
    }
    
    /**
     * Vérifie si le joueur a les ressources nécessaires pour évoluer à la N-ième étape de sa merveille
     * Le cas échéant, valide récupère les récompenses d'évolutions et valide l'évolution
     */
    private void tryEvolveUT() {
        boolean[] canEvolveWrapper = { true };
        // Vérifie que le joueur possède les ressources pour évoluer sa merveille
            switch(this.gameBoard.getEvolution()) {
                case NONE:
                    this.productedRessources.forEach((playerProductedRessource) -> {
                        this.gameBoard.getSteps().get(0).getCost().forEach((cost) -> {
                            if(playerProductedRessource.getType() == cost.getType()) {
                                if(cost.getValue() > playerProductedRessource.getValue()) {
                                    canEvolveWrapper[0] = false;
                                }
                            }
                        });
                    });
                    break;
                case FIRST:
                    this.productedRessources.forEach((playerProductedRessource) -> {
                        this.gameBoard.getSteps().get(1).getCost().forEach((cost) -> {
                            if(playerProductedRessource.getType() == cost.getType()) {
                                if(cost.getValue() > playerProductedRessource.getValue()) {
                                    canEvolveWrapper[0] = false;
                                }
                            }
                        });
                    });
                    break;
                case SECOND:
                    this.productedRessources.forEach((playerProductedRessource) -> {
                        this.gameBoard.getSteps().get(2).getCost().forEach((cost) -> {
                            if(playerProductedRessource.getType() == cost.getType()) {
                                if(cost.getValue() > playerProductedRessource.getValue()) {
                                    canEvolveWrapper[0] = false;
                                }
                            }
                        });
                    });
                    break;
            }
            // S'il peut évoluer, récupère les ressources et évolue
            if(canEvolveWrapper[0]) {
                this.gameBoard.evolve();
                switch(this.gameBoard.getEvolution()){
                    case FIRST:
                        switch(this.gameBoard.getSteps().get(0).getCoinsEarned().getType()) {
                            case VICTORY:
                                this.score.getTotalVictoryPoints().setValue(this.score.getTotalVictoryPoints().getValue() + this.gameBoard.getSteps().get(0).getCoinsEarned().getValue());
                                break;
                            case KNOWLEDGE:
                                this.score.getKnowledge().setValue(this.score.getKnowledge().getValue() + this.gameBoard.getSteps().get(0).getCoinsEarned().getValue());
                                break;
                            case COIN:
                                this.score.getCoin().setValue(this.score.getCoin().getValue() + this.gameBoard.getSteps().get(0).getCoinsEarned().getValue());
                                break;
                            case CENTRIFUGE:
                                this.score.getCentrifuge().setValue(this.score.getCentrifuge().getValue() + this.gameBoard.getSteps().get(0).getCoinsEarned().getValue());
                                break;
                            case PUMP:
                                this.score.getPump().setValue(this.score.getPump().getValue() + this.gameBoard.getSteps().get(0).getCoinsEarned().getValue());
                                break;
                            case PROOFER:
                                this.score.getProofer().setValue(this.score.getProofer().getValue() + this.gameBoard.getSteps().get(0).getCoinsEarned().getValue());
                                break;
                            default:
                                break;
                        }
                        break;
                    case SECOND:
                        switch(this.gameBoard.getSteps().get(1).getCoinsEarned().getType()) {
                            case VICTORY:
                                this.score.getTotalVictoryPoints().setValue(this.score.getTotalVictoryPoints().getValue() + this.gameBoard.getSteps().get(1).getCoinsEarned().getValue());
                                break;
                            case KNOWLEDGE:
                                this.score.getKnowledge().setValue(this.score.getKnowledge().getValue() + this.gameBoard.getSteps().get(1).getCoinsEarned().getValue());
                                break;
                            case COIN:
                                this.score.getCoin().setValue(this.score.getCoin().getValue() + this.gameBoard.getSteps().get(1).getCoinsEarned().getValue());
                                break;
                            case CENTRIFUGE:
                                this.score.getCentrifuge().setValue(this.score.getCentrifuge().getValue() + this.gameBoard.getSteps().get(1).getCoinsEarned().getValue());
                                break;
                            case PUMP:
                                this.score.getPump().setValue(this.score.getPump().getValue() + this.gameBoard.getSteps().get(1).getCoinsEarned().getValue());
                                break;
                            case PROOFER:
                                this.score.getProofer().setValue(this.score.getProofer().getValue() + this.gameBoard.getSteps().get(1).getCoinsEarned().getValue());
                                break;
                            default:
                                break;
                        }
                        break;
                    case THIRD:
                        switch(this.gameBoard.getSteps().get(2).getCoinsEarned().getType()) {
                            case VICTORY:
                                this.score.getTotalVictoryPoints().setValue(this.score.getTotalVictoryPoints().getValue() + this.gameBoard.getSteps().get(2).getCoinsEarned().getValue());
                                break;
                            case KNOWLEDGE:
                                this.score.getKnowledge().setValue(this.score.getKnowledge().getValue() + this.gameBoard.getSteps().get(2).getCoinsEarned().getValue());
                                break;
                            case COIN:
                                this.score.getCoin().setValue(this.score.getCoin().getValue() + this.gameBoard.getSteps().get(2).getCoinsEarned().getValue());
                                break;
                            case CENTRIFUGE:
                                this.score.getCentrifuge().setValue(this.score.getCentrifuge().getValue() + this.gameBoard.getSteps().get(2).getCoinsEarned().getValue());
                                break;
                            case PUMP:
                                this.score.getPump().setValue(this.score.getPump().getValue() + this.gameBoard.getSteps().get(2).getCoinsEarned().getValue());
                                break;
                            case PROOFER:
                                this.score.getProofer().setValue(this.score.getProofer().getValue() + this.gameBoard.getSteps().get(2).getCoinsEarned().getValue());
                                break;
                            default:
                                break;
                        }
                        break;
                }
            }
            // Si le joueur essaie d'évoluer sans avoir les ressources, lui prive de 2 pièces
            else {
                Point coin = this.score.getCoin();
                coin.setValue(coin.getValue() - 2);
                this.score.setCoin(coin);
            }
    }
    
    /**
     * Vérifie si le joueur possède assez de ressources pour jouer une carte
     */
    private boolean checkResourcesToPlayCard(Card card) {
        // 1. Récupération du prix de la carte
        ArrayList<RessourcePack> cost = card.getCost();
        // 2. On vérifie si le joueur possède suffisamment de ressources pour construire la carte 
        ArrayList<RessourcePack> cardCosts = card.getCost();
        if(cardCosts != null) {
            boolean[] hasResourcesStateWrapper = { true }; // wrap boolean in array to use it in lambda function below
            cardCosts.forEach((RessourcePack cardCost) -> {
                this.productedRessources.forEach((RessourcePack productedRessource) -> {
                    if(productedRessource.getType() == cardCost.getType()) {
                        if(cardCost.getType() == Resource.COIN) {
                            if(cardCost.getValue() > this.score.getCoin().getValue()) {
                                hasResourcesStateWrapper[0] = false;
                            }
                        }
                        else if(cardCost.getValue() > productedRessource.getValue()) {
                            hasResourcesStateWrapper[0] = false;
                        }
                    }
                });
            });
           return hasResourcesStateWrapper[0];
        }
        else {
            // La carte ne coûte rien à construire donc il peut la construire
            return true;
        }
        
    }
    
    /**
     * Dépense des ressources nécessaires pour acheter une carte
     */
    private void buyCard(Card card) {
        if(this.checkResourcesToPlayCard(card) == true) {
            // Ajout des ressources produites par la carte aux ressources du joueur
            this.productedRessources.forEach((playerProductedRessource) -> {
                if(card.getListProductRessources() != null) {
                    card.getListProductRessources().forEach((cardProductRessource) -> {
                    if(cardProductRessource.getType() == playerProductedRessource.getType()) {
                        playerProductedRessource.setValue(playerProductedRessource.getValue() + cardProductRessource.getValue());
                    }
                });
                }
            });
            // Ajout des éléments de scoring (score, points de victoires, etc.) offertes par la carte
            if(card.getCoinsEarned() != null) {
                    switch(card.getCoinsEarned().getType()) {
                        case VICTORY:
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + card.getCoinsEarned().getValue());
                            break;
                        case KNOWLEDGE:
                            this.getScore().getKnowledge().setValue(this.getScore().getKnowledge().getValue() + card.getCoinsEarned().getValue());
                            break;
                        case ASSOCIATION:
                            this.getScore().getAssociation().setValue(this.getScore().getAssociation().getValue() + card.getCoinsEarned().getValue());
                            break;
                        case COIN:
                            this.getScore().getCoin().setValue(this.getScore().getCoin().getValue() + card.getCoinsEarned().getValue());
                            break;
                        case CENTRIFUGE:
                            this.getScore().getCentrifuge().setValue(this.getScore().getCentrifuge().getValue() + card.getCoinsEarned().getValue());
                            break;
                        case PUMP:
                            this.getScore().getPump().setValue(this.getScore().getPump().getValue() + card.getCoinsEarned().getValue());
                            break;
                        case PROOFER:
                            this.getScore().getProofer().setValue(this.getScore().getProofer().getValue() + card.getCoinsEarned().getValue());
                            break;
                        case VICTORYPOINT_PER_CREDITCARD:
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + (card.getCoinsEarned().getValue() * this.getNumberOfPlayedCardsByType(CardType.CREDIT)));
                            break;
                        case VICTORYPOINT_PER_SKILLCARD:
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + (card.getCoinsEarned().getValue() * this.getNumberOfPlayedCardsByType(CardType.SKILL)));
                            break;
                        case VICTORYPOINT_PER_LIBRARYCARD:
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + (card.getCoinsEarned().getValue() * this.getNumberOfPlayedCardsByType(CardType.LIBRARY)));
                            break;
                        case VICTORYPOINT_PER_ADMINISTRATIONCARD:
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + (card.getCoinsEarned().getValue() * this.getNumberOfPlayedCardsByType(CardType.ASSOCIATION)));
                            break;
                        case VICTORYPOINT_PER_CLASSROOMCARD:
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + (card.getCoinsEarned().getValue() * this.getNumberOfPlayedCardsByType(CardType.CLASSROOM)));
                            break;
                        case VICTORYPOINT_PER_LABORATORYCARD:
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + (card.getCoinsEarned().getValue() * this.getNumberOfPlayedCardsByType(CardType.LABORATORY)));
                            break;
                        case VICTORYPOINT_PER_ASSOCIATIONCARD:
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + (card.getCoinsEarned().getValue() * this.getNumberOfPlayedCardsByType(CardType.ASSOCIATION)));
                            break;
                        case VICTORYPOINT_PER_UTSTEP:
                            int evolutionCoeff = 0;
                            switch(this.gameBoard.getEvolution()) {
                                case FIRST:
                                    evolutionCoeff = 1;
                                    break;
                                case SECOND:
                                    evolutionCoeff = 2;
                                    break;
                                case THIRD:
                                    evolutionCoeff = 3;
                                    break;
                            }
                            this.getScore().getTotalVictoryPoints().setValue(this.getScore().getTotalVictoryPoints().getValue() + (card.getCoinsEarned().getValue() * evolutionCoeff));
                            break;
                    }
                }
        }
    }
    
    /**
     * Retourne le nombre de cartes jouées d'un certain type
     */
    private int getNumberOfPlayedCardsByType(CardType type) {
        int[] nbCards = { 0 };
        this.cardsPlayed.getListCards().forEach((card) -> {
            if(card.getType() == type) {
                nbCards[0]++;
            }
        });
        return nbCards[0];
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
    
    public Card getCardPlayedByName(String name) {
        return this.cardsPlayed.getCardByName(name);
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
    
    public Card getCardSelectedToBuyRessources() {
        return this.cardSelectedToBuyRessources;
    }
    
    public void setCardSelectedToBuyRessources(Card cardSelectedToBuyRessources) {
        this.cardSelectedToBuyRessources = cardSelectedToBuyRessources;
    }
    
    public int getIdPlayerCardSelectedToBuyRessources() {
        return this.idPlayerCardSelectedToBuyRessources;
    }
    
    public void setIdPlayerCardSelectedToBuyRessources(int idPlayerCardSelectedToBuyRessources) {
        this.idPlayerCardSelectedToBuyRessources = idPlayerCardSelectedToBuyRessources;
    }
    
    public boolean getIsValidate() {
        return this.isValidate;
    }
    
    public void setIsValidate(boolean isValidate) {
        this.isValidate = isValidate;
    }

    public ArrayList<RessourcePack> getProductedRessources() {
        return productedRessources;
    }

    public void setProductedRessources(ArrayList<RessourcePack> productedRessources) {
        this.productedRessources = productedRessources;
    }

    @Override
    public String toString() {
        return "Player{" + "gameBoard=" + gameBoard + ", score=" + score + ", deck=" + deck + ", cardsPlayed=" + cardsPlayed + '}';
    }

    
    
}
