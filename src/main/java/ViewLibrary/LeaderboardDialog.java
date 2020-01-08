/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLibrary;

import ControllerLibrary.GameManager;
import ModelLibrary.ScoreLibrary.Score;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hicham
 */
public class LeaderboardDialog extends JDialog {
    GameManager gameManager;

    public LeaderboardDialog(GameManager gameManager) {
        this.gameManager = gameManager;
        // Configure le jDialog
        this.setTitle( "Leaderboard" );
        this.setModal( true );
        this.setResizable( false );
        this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        this.getContentPane().setLayout( new BorderLayout() );
        // Crée et rempli le jTable (tableau des scores)
        this.createLeaderboard();
        // Pack et affiche la fenêtre
        this.pack();
        this.setVisible(true);
    }
    
    /**
     * Instancie et rempli le tableau des scores avec les données des joueurs et l'ajoute à la jDialog
     */
    private void createLeaderboard() {
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

    this.add(new JScrollPane(jtable), BorderLayout.CENTER);
    this.setSize(300, 150);
  }
    
}
