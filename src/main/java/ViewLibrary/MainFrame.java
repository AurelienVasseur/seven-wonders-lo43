/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLibrary;

import ControllerLibrary.GameManager;
import EnumLibrary.PlayersAmount;
import ModelLibrary.ScoreLibrary.Score;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hicham, Aurélien
 */
public class MainFrame extends javax.swing.JFrame {
    private HomePanel homePanel;
    private PlayersAmountSelectionPanel playersAmountSelectionPanel;
    
    private JScrollPane playersScrollPane;
    private JPanel playersPanel;
    /* -- */
    private GameStatePanel gameStatePanel;
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelLap;
    /* -- */
    private JPanel leaderboardPanel;
    private JPanel endPanel;
    protected GameManager gameManager;
    protected ArrayList<PlayerPanel> listPlayersPanel;
    private boolean gameIsFinish;  // flag pour gérer la fin de partie

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instanciation de l'application graphique
        new MainFrame();
    }
    
    
    public MainFrame() {
        this.initComponents();
    }
    
    private void initComponents(){
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.layout = new GroupLayout(this.getContentPane());
        //this.getContentPane().setLayout(this.layout);
        //this.getContentPane().setLayout(null);
        this.setVisible(true);
        
        this.listPlayersPanel = new ArrayList<PlayerPanel>();
        this.gameIsFinish = false;
        
        this.displayHome();
    }
    
    /**
     * Affichage de l'écran principal
     */
    public void displayHome() {
        this.homePanel = new HomePanel(this);
        this.getContentPane().add(this.homePanel);
        this.pack();
        this.setVisible(true);
    }
    
    /**
     * Affiche de l'écran de sélection du nombre de joueurs
     */
    public void displayPlayersAmountSelection() {
        this.getContentPane().remove(this.homePanel);
        this.homePanel.removeAll();
        this.playersAmountSelectionPanel = new PlayersAmountSelectionPanel(this);
        this.getContentPane().add(this.playersAmountSelectionPanel);
        this.pack();
        this.setVisible(true);
    }
    
    /**
     * Affiche l'écran de jeu
     */
    public void displayGame(PlayersAmount playersAmount) {
        // Initialisation du Game Manager
        this.gameManager = new GameManager(playersAmount);
        this.gameManager.start();  
        // Retrait du panel précédent
        this.remove(this.playersAmountSelectionPanel);
        this.playersAmountSelectionPanel.removeAll();
        // Configuration du panel des joueurs
        this.playersPanel = new JPanel();
        this.playersPanel.setPreferredSize(new Dimension(1280, 6000));
        this.playersScrollPane = new JScrollPane(playersPanel);
        this.playersPanel.setAutoscrolls(true);
        this.playersScrollPane.setPreferredSize(new Dimension(1280,720));
        // only a configuration to the jScrollPane...
        this.playersScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.playersScrollPane.getVerticalScrollBar().setUnitIncrement(30);
        // Ajout du status de la partie en haut du panel
        this.gameStatePanel = new GameStatePanel();
        this.gameStatePanel.getjLabelFormationValue().setText(this.gameManager.getAge().toString());
        this.gameStatePanel.getjLabelLapValue().setText(Integer.toString(this.gameManager.getLap()));
        playersPanel.add(this.gameStatePanel);
        
        // Ajout des panel de chaque joueur
        for(int i = 0; i < playersAmount.getValue(); ++i) {
            PlayerPanel playerPanel = new PlayerPanel(this, i);
            playerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            this.listPlayersPanel.add(playerPanel);
            playersPanel.add(playerPanel);
        }
        // Affichage du résultat graphique à l'écran
        this.getContentPane().add(this.playersScrollPane);
        this.pack();
        this.setVisible(true);
    }
    
    /**
     * Mise à jour de l'ensemble des données affichés dans les panels de chaque joueur
     */
    public void guiUpdatePlayersPanel() {
        this.gameStatePanel.getjLabelFormationValue().setText(this.gameManager.getAge().toString());
        this.gameStatePanel.getjLabelLapValue().setText(Integer.toString(this.gameManager.getLap()));
        for(int i = 0; i < this.listPlayersPanel.size(); ++i) {
            this.listPlayersPanel.get(i).guiUpdate();
        }
    }
    
    /**
     * En cas de fin de partie, quitte la partie et affiche le tableau des scores final
     */
    public void endGame() {
        if(this.gameIsFinish == false) {
            this.gameIsFinish = true;
            this.displayLeaderboard();
        }
    }
    
    /**
     * Affichage du tableau des scores de fin de partie
     */
    public void displayLeaderboard() {
        // Retrait des panels de la partie achevée
        this.remove(this.playersScrollPane);
        this.playersPanel.removeAll();
        this.leaderboardPanel = new JPanel();
        // Prépare le tableau de scores
        String[] entetes = {"PlayerID", "Score", "Victory Points", "Military Points", "Coins", "Centrifuge", "Pump", "Proofer"};
        DefaultTableModel tableModel = new DefaultTableModel(entetes, 0);
        JTable jtable = new JTable(tableModel);
        ArrayList<Score> scores = this.gameManager.fetchScores();
        for(int i = 0; i < scores.size(); ++i) {
            String playerId = Integer.toString(i);
            String score = Integer.toString(scores.get(i).getFinalScore().getValue());
            String victoryPoints = Integer.toString(scores.get(i).getTotalVictoryPoints().getValue());
            String militaryPoints = Integer.toString(scores.get(i).getKnowledge().getValue());
            String coins = Integer.toString(scores.get(i).getCoin().getValue());
            String centrifuge = Integer.toString(scores.get(i).getCentrifuge().getValue());
            String pump = Integer.toString(scores.get(i).getPump().getValue());
            String proofer = Integer.toString(scores.get(i).getProofer().getValue());
            String[] row = { playerId, score, victoryPoints, militaryPoints, coins, centrifuge, pump, proofer };
            tableModel.addRow(row);
        }
        // Ajoute le tableau des scores au panel
        this.leaderboardPanel.add(new JScrollPane(jtable));
        JButton showEndButton = new JButton("Continue");
        // Lorsque l'utilisateur clique sur 'showEnd' ou 'Continuer', affiche l'écran de fin
        showEndButton.addActionListener(new ActionListener() {          
            public void actionPerformed(ActionEvent e) {
                displayEnd();
            }
        });
        // Affiche l'ensemble des éléments à l'écran
        this.leaderboardPanel.add(showEndButton);
        this.getContentPane().add(this.leaderboardPanel);
        this.pack();
        this.setVisible(true);
    }
    
    /**
     * Supprime le tableau des scores de fin de partie et affiche l'écran de fin (rejouer/quitter)
     */
    public void displayEnd(){
        this.remove(this.leaderboardPanel);
        this.leaderboardPanel.removeAll();
        this.endPanel = new EndPanel(this);
        this.getContentPane().add(this.endPanel);
        this.pack();
        this.setVisible(true);
    }
    
    /**
     * Libère l'ensemble de la mémoire des éléments graphique
     */
    public void end(){
        this.remove(this.endPanel);
        this.dispose();
    }
    
    /**
     * Retourne à l'écran d'accueil afin de pouvoir rejouer
     */
    public void playAgain() {
        this.remove(this.endPanel);
        this.displayHome();
    }
    
}
