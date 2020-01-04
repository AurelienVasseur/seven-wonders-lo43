/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLibrary;

import ControllerLibrary.GameManager;
import EnumLibrary.PlayersAmount;
import ModelLibrary.CardLibrary.Card;
import UtilsLibrary.JSON;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Hicham, Aurélien
 */
public class MainFrame extends javax.swing.JFrame {
    private HomePanel homePanel;
    private PlayersAmountSelectionPanel playersAmountSelectionPanel;
    private JPanel playersPanel;
    /* -- */
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelLap;
    /* -- */
    private JPanel leaderboardPanel;
    private JPanel endPanel;
    protected GameManager gameManager;
    protected ArrayList<PlayerPanel> listPlayersPanel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new MainFrame();
        ArrayList<Card> allCards = JSON.readCards("cards.json");
        System.out.println(allCards.toString());
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
        this.jLabelAge = new javax.swing.JLabel();
        this.jLabelLap = new javax.swing.JLabel();
        this.jLabelAge.setText("Age : " + this.gameManager.getAge());
        this.jLabelLap.setText("Lap : " + this.gameManager.getLap());
        playersPanel.add(this.jLabelAge);
        playersPanel.add(this.jLabelLap);
        
        for(int i = 0; i < playersAmount.getValue(); ++i) {
            PlayerPanel playerPanel = new PlayerPanel(this, i);
            this.listPlayersPanel.add(playerPanel);
            playersPanel.add(playerPanel);
        }
        this.getContentPane().add(this.playersPanel);
        this.pack();
        this.setVisible(true);
    }
    
    public void guiUpdatePlayersPanel() {
        this.jLabelAge.setText("Age : " + this.gameManager.getAge());
        this.jLabelLap.setText("Lap : " + this.gameManager.getLap());
        for(int i = 0; i < this.listPlayersPanel.size(); ++i) {
            this.listPlayersPanel.get(i).guiUpdate();
        }
    }
    
    public void displayLeaderboard() {
        this.remove(this.playersPanel);
        this.playersPanel.removeAll();
        this.leaderboardPanel = new JPanel();
        Object[][] donnees = {
                {"0", "Sykes"},
                {"1", "Van de Kampf"},
                {"2", "Cuthbert"},
                {"3", "Valance"},
                {"4", "Schrödinger"},
                {"5", "Duke"},
                {"6", "Trump"},
        };
 
        String[] entetes = {"PlayerID", "Score"};
        JTable jtable = new JTable(donnees, entetes);
        this.leaderboardPanel.add(jtable);
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
