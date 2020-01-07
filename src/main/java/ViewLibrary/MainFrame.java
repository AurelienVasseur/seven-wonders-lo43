/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLibrary;

import ControllerLibrary.GameManager;
import EnumLibrary.PlayersAmount;
import ModelLibrary.CardLibrary.Card;
import ModelLibrary.PlayerLibrary.UT;
import ModelLibrary.ScoreLibrary.Score;
import UtilsLibrary.JSON;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
        // TODO code application logic here
        new MainFrame();
        ArrayList<Card> age1 = JSON.readCards("cards.json");
        System.out.println(age1.toString());
        ArrayList<Card> age2 = JSON.readCards("cards2.json");
        System.out.println(age2.toString());
        ArrayList<Card> age3 = JSON.readCards("cards3.json");
        System.out.println(age3.toString());
        
        ArrayList<UT> allUTs = JSON.readUTs("uts.json");
        System.out.println(allUTs.toString());
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
    
    public void displayHome() {
        this.homePanel = new HomePanel(this);
        this.getContentPane().add(this.homePanel);
        this.pack();
        this.setVisible(true);
    }
    
    public void displayPlayersAmountSelection() {
        this.getContentPane().remove(this.homePanel);
        this.homePanel.removeAll();
        this.playersAmountSelectionPanel = new PlayersAmountSelectionPanel(this);
        this.getContentPane().add(this.playersAmountSelectionPanel);
        this.pack();
        this.setVisible(true);
    }
    
    public void displayGame(PlayersAmount playersAmount) {
        // Initialisation du Game Manager
        this.gameManager = new GameManager(playersAmount);
        this.gameManager.start();  
        
        this.remove(this.playersAmountSelectionPanel);
        this.playersAmountSelectionPanel.removeAll();
        
                
        this.playersPanel = new JPanel();
        this.playersPanel.setPreferredSize(new Dimension(1280, 5760));
        this.playersScrollPane = new JScrollPane(playersPanel);
        this.playersPanel.setAutoscrolls(true);
        this.playersScrollPane.setPreferredSize(new Dimension(1280,720));
        // only a configuration to the jScrollPane...
        this.playersScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.playersScrollPane.getVerticalScrollBar().setUnitIncrement(30);
        
        this.gameStatePanel = new GameStatePanel();
        this.gameStatePanel.getjLabelFormationValue().setText(this.gameManager.getAge().toString());
        this.gameStatePanel.getjLabelLapValue().setText(Integer.toString(this.gameManager.getLap()));
        playersPanel.add(this.gameStatePanel);
        
        
        for(int i = 0; i < playersAmount.getValue(); ++i) {
            PlayerPanel playerPanel = new PlayerPanel(this, i);
            playerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            this.listPlayersPanel.add(playerPanel);
            playersPanel.add(playerPanel);
        }
        this.getContentPane().add(this.playersScrollPane);
        this.pack();
        this.setVisible(true);
    }
    
    public void guiUpdatePlayersPanel() {
        this.gameStatePanel.getjLabelFormationValue().setText(this.gameManager.getAge().toString());
        this.gameStatePanel.getjLabelLapValue().setText(Integer.toString(this.gameManager.getLap()));
        for(int i = 0; i < this.listPlayersPanel.size(); ++i) {
            this.listPlayersPanel.get(i).guiUpdate();
        }
    }
    
    public void endGame() {
        if(this.gameIsFinish == false) {
            this.gameIsFinish = true;
            this.displayLeaderboard();
        }
    }
    
    public void displayLeaderboard() {
        this.remove(this.playersScrollPane);
        this.playersPanel.removeAll();
        this.leaderboardPanel = new JPanel();
        
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
        this.leaderboardPanel.add(new JScrollPane(jtable));
        JButton showEndButton = new JButton("Continue");
        showEndButton.addActionListener(new ActionListener() {          
            public void actionPerformed(ActionEvent e) {
                displayEnd();
            }
        });
        this.leaderboardPanel.add(showEndButton);
        this.getContentPane().add(this.leaderboardPanel);
        this.pack();
        this.setVisible(true);
    }
    
    public void displayEnd(){
        this.remove(this.leaderboardPanel);
        this.leaderboardPanel.removeAll();
        this.endPanel = new EndPanel(this);
        this.getContentPane().add(this.endPanel);
        this.pack();
        this.setVisible(true);
    }
    
    public void end(){
        this.remove(this.endPanel);
        this.dispose();
    }
    
    public void playAgain() {
        this.remove(this.endPanel);
        this.displayHome();
    }
    
}
