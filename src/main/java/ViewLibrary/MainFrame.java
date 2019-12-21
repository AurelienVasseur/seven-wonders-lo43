/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLibrary;

import EnumLibrary.PlayersAmount;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Hicham
 */
public class MainFrame extends javax.swing.JFrame {
    private HomePanel homePanel;
    private PlayersAmountSelectionPanel playersAmountSelectionPanel;

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
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //jframe.setLayout(new BorderLayout());
        this.setVisible(true);
        
        
        
        this.homePanel = new HomePanel(this);
        //homePanel.setVisible(true);
        this.getContentPane().add(this.homePanel);
        
        this.pack();
        this.setVisible(true);
    }
    
    public void displayPlayersAmountSelection() {
        this.playersAmountSelectionPanel = new PlayersAmountSelectionPanel(this);
        this.getContentPane().remove(this.homePanel);
        this.getContentPane().add(this.playersAmountSelectionPanel);
        this.pack();
        this.setVisible(true);
    }
    
    public void displayGame(PlayersAmount playersAmount) {
        this.remove(this.playersAmountSelectionPanel);
        for(int i = 0; i < playersAmount.getValue(); ++i) {
            this.getContentPane().add(new PlayerPanel(i));
        }
        this.pack();
        this.setVisible(true);
    }
    
}
