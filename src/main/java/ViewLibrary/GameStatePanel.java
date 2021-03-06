/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLibrary;

import javax.swing.JLabel;

/**
 *
 * @author Hicham
 */
public class GameStatePanel extends javax.swing.JPanel {

    /**
     * Creates new form GameStatePanel
     */
    public GameStatePanel() {
        initComponents();
    }

    public JLabel getjLabelFormationValue() {
        return jLabelFormationValue;
    }

    public void setjLabelFormationValue(JLabel jLabelFormationValue) {
        this.jLabelFormationValue = jLabelFormationValue;
    }

    public JLabel getjLabelLapValue() {
        return jLabelLapValue;
    }

    public void setjLabelLapValue(JLabel jLabelLapValue) {
        this.jLabelLapValue = jLabelLapValue;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFormationName = new javax.swing.JLabel();
        jLabelFormationValue = new javax.swing.JLabel();
        jLabelLapName = new javax.swing.JLabel();
        jLabelLapValue = new javax.swing.JLabel();
        jLabelGameTitle = new javax.swing.JLabel();
        jLabelGameStatusName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabelFormationName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelFormationName.setText("Formation");

        jLabelFormationValue.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelFormationValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFormationValue.setText("NONE");

        jLabelLapName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelLapName.setText("Lap");

        jLabelLapValue.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelLapValue.setText("0");

        jLabelGameTitle.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelGameTitle.setText("7 Wonders UTBM");

        jLabelGameStatusName.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelGameStatusName.setText("InGame Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(146, 146, 146)
                                    .addComponent(jLabelGameStatusName))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(jLabelGameTitle)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabelFormationValue, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelLapValue)
                                .addGap(58, 58, 58)))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabelFormationName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLapName)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGameTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGameStatusName)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFormationName)
                    .addComponent(jLabelLapName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLapValue)
                    .addComponent(jLabelFormationValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelFormationName;
    private javax.swing.JLabel jLabelFormationValue;
    private javax.swing.JLabel jLabelGameStatusName;
    private javax.swing.JLabel jLabelGameTitle;
    private javax.swing.JLabel jLabelLapName;
    private javax.swing.JLabel jLabelLapValue;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
