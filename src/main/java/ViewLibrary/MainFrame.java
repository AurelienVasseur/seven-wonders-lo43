/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLibrary;

import ControllerLibrary.GameManager;
import EnumLibrary.PlayersAmount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JPanel leaderboardPanel;
    private JPanel endPanel;
    protected GameManager gameManager;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
        //this.gameManager.start();  // A ACTIVER
        
        this.remove(this.playersAmountSelectionPanel);
        this.playersAmountSelectionPanel.removeAll();
        this.playersPanel = new JPanel();
        for(int i = 0; i < playersAmount.getValue(); ++i) {
            PlayerPanel playerPanel = new PlayerPanel(this, i);
            playersPanel.add(playerPanel);
        }
        this.getContentPane().add(this.playersPanel);
        this.pack();
        this.setVisible(true);
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
