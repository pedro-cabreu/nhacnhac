/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pedroebruno.nhacnhac;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author costa
 */
public class NhacNhac extends javax.swing.JFrame {

    /**
     * Creates new form NhacNhac
    */
    
    public int turn = 1;
    public String[] p1Options = {"Grande", "Médio", "Pequeno"}; 
    public String[] p2Options = {"Grande", "Médio", "Pequeno"}; 
    public int[] boardPlayer = new int[9];
    public String[] boardSize = new String[9];   

    public void setP1Options(String[] p1Options) {
        this.p1Options = p1Options;
    }

    public void setP2Options(String[] p2Options) {
        this.p2Options = p2Options;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setBoardPlayer(int[] boardPlayer) {
        this.boardPlayer = boardPlayer;
    }

    public void setBoardSize(String[] boardSize) {
        this.boardSize = boardSize;
    }
    
    public NhacNhac() {
        initComponents();
    }
    
    public void setButtonLabel(JButton button, String choosed){
        
        if(turn == 1){
            
            button.setText("X");
            
            switch(choosed){
                
                case "Grande":
                    button.setFont(new Font("Serif", Font.PLAIN, 60));
                    break;
                case "Médio":
                    button.setFont(new Font("Serif", Font.PLAIN, 24));
                    break;
                case "Pequeno":
                    button.setFont(new Font("Serif", Font.PLAIN, 12));
                    break;
            }
        }else{
            
            button.setText("O");
            
            switch(choosed){
                
                case "Grande":
                    button.setFont(new Font("Serif", Font.PLAIN, 60));
                    break;
                case "Médio":
                    button.setFont(new Font("Serif", Font.PLAIN, 24));
                    break;
                case "Pequeno":
                    button.setFont(new Font("Serif", Font.PLAIN, 12));
                    break;
            }
        }
    }
    
    public void setPlayOnArray(int n, String size){
                    
        boardPlayer[n - 1] = turn;
        boardSize[n - 1] = size;

        // System.out.println(boardPlayer);
        // System.out.println(boardSize);
    }
    
    public void finishGame(int winner){
        
        JOptionPane.showMessageDialog(rootPane, "O jogador " + winner + " venceu!");
        resetGame();
    }
    
    public void checkVictory(){
        
         if(boardPlayer[0] == 2 && boardPlayer[1]  == 2 && boardPlayer[2] == 2){

            finishGame(2);
        }

        else if(boardPlayer[0] == 1 && boardPlayer[1] == 1 && boardPlayer[2] == 1){

            finishGame(1);
        }

        else if(boardPlayer[3] == 2 && boardPlayer[4] == 2 && boardPlayer[5] == 2){

            finishGame(2);
        }

        else if(boardPlayer[3] == 1 && boardPlayer[4] == 1 && boardPlayer[5] == 1){

            finishGame(1);
        }

        else if(boardPlayer[6] == 2 && boardPlayer[7] == 2 && boardPlayer[8] == 2){

            finishGame(2);
        }

        else if(boardPlayer[6] == 1 && boardPlayer[7] == 1 && boardPlayer[8] == 1){

            finishGame(1);
        }

        else if(boardPlayer[0] == 2 && boardPlayer[3] == 2 && boardPlayer[6] == 2){

            finishGame(2);
        }

        else if(boardPlayer[0] == 1 && boardPlayer[3] == 1 && boardPlayer[6] == 1){

            finishGame(1);
        }

        else if(boardPlayer[1] == 2 && boardPlayer[4] == 2 && boardPlayer[7] == 2){

            finishGame(2);
        }

        else if(boardPlayer[1] == 1 && boardPlayer[4] == 1 && boardPlayer[7] == 1){

            finishGame(1);
        }

        else if(boardPlayer[2] == 2 && boardPlayer[5] == 2 && boardPlayer[8] == 2){

            finishGame(2);
        }

        else if(boardPlayer[2] == 1 && boardPlayer[5] == 1 && boardPlayer[8] == 1){

            finishGame(1);
        }

        else if(boardPlayer[0] == 2 && boardPlayer[4] == 2 && boardPlayer[8] == 2){

            finishGame(2);
        }

        else if(boardPlayer[0] == 1 && boardPlayer[4] == 1 && boardPlayer[8] == 1){

            finishGame(1);
        }

        else if(boardPlayer[2] == 2 && boardPlayer[4] == 2 && boardPlayer[6] == 2){

            finishGame(2);
        }

        else if(boardPlayer[2] == 1 && boardPlayer[4] == 1 && boardPlayer[6] == 1){

            finishGame(1);
        }
    }
    
    public boolean isPlayValid(int n, String size){
        
        if(boardPlayer[n - 1] == 0){ // Se a posição do tabuleiro estiver vazia
            
            return true;
        }else{
            
            String currentSize = boardSize[n - 1];
            
            if(currentSize == "Grande"){ // Se a peça colocada for grande, invalidar
                
                return false;
            }
            
            if(currentSize == size){ // Se as peças tiverem o mesmo valor, invalidar
                
                return false;
            }
            
            if(currentSize == "Médio" && size == "Grande"){ // Se a peça colocada for grande e atual for média, validar
                
                return true;
            }
            
            if(currentSize == "Médio" && size == "Pequeno"){ // Se a peça colocada for pequena e atual for média, invalidar
                
                return false;
            }
            
            if(currentSize == "Pequeno" && size == "Médio"){ // Se a peça colocada for grande e atual for média, validar
            
                return true;
            }
            
            if(currentSize == "Pequeno" && size == "Grande"){ // Se a peça colocada for grande e atual for pequena, validar
                
                return true;
            }
                
            System.out.println("Tamanho na posição: " + currentSize);
            System.out.println("Tamanho clicado pelo jogador: " + size);
            
            return false;
        }
    }
    
    public void resetGame(){
        
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        String[] options = { "Grande", "Médio", "Pequeno" };
        this.setP1Options(options);
        this.setP2Options(options);
        this.setBoardPlayer(new int[9]);
        this.setBoardSize(new String[9]);
        this.setTurn(1);
   }
    
    public void buttonClicked(JButton btn, int n){
        
        if(p2Options.length == 0){
            
            JOptionPane.showConfirmDialog(rootPane, "Nenhuma peça restante! Jogo empatado", "Game Over", JOptionPane.OK_CANCEL_OPTION);
            
            resetGame();
            
        }else{
            
            if(turn == 1){ // Player 1
            
                // Alert com select de tamanho
                String choosed = (String)JOptionPane.showInputDialog(
                    this.rootPane,
                    "Escolha o tamanho da peça:", 
                    "Jogador 1",            
                    JOptionPane.PLAIN_MESSAGE,
                    null,            
                    p1Options, 
                    p1Options[0] 
                );

                if(choosed != null){

                    if(isPlayValid(n, choosed)){

                        // Remove a opção do tamanho do select
                        ArrayList<String> list = new ArrayList<String>(Arrays.asList(p1Options));
                        list.remove(choosed);
                        p1Options = list.toArray(new String[0]);

                        setPlayOnArray(n, choosed); // Coloca a jogada no array do tabuleiro

                        setButtonLabel(btn, choosed); // Troca a label do botão

                        turn = 2; // Seta a vez do jogador 2
                    }else{
                        // Jogada Inválida
                        JOptionPane.showMessageDialog(rootPane, "Jogada Inválida");
                    }
                }

            }else{ // Player 2

                String choosed = (String)JOptionPane.showInputDialog(
                    this.rootPane,
                    "Escolha o tamanho da peça:", 
                    "Jogador 2",            
                    JOptionPane.PLAIN_MESSAGE,
                    null,            
                    p2Options, 
                    p2Options[0] 
                );

                if(choosed != null){

                    if(isPlayValid(n, choosed)){

                        // Remove a opção do tamanho do select
                        ArrayList<String> list = new ArrayList<String>(Arrays.asList(p2Options));
                        list.remove(choosed);
                        p2Options = list.toArray(new String[0]);

                        setPlayOnArray(n, choosed); // Coloca a jogada no array do tabuleiro

                        setButtonLabel(btn, choosed); // Troca a label do botão

                        turn = 1; // Seta a vez do jogador 2
                    }else{

                        // Jogada Inválida
                        JOptionPane.showMessageDialog(rootPane, "Jogada Inválida");
                    }
                }
            }

            checkVictory();
            turnLabel.setText("Vez do jogador: " + turn);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        turnLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn4 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        resetButton = new javax.swing.JMenuItem();
        closeButton = new javax.swing.JMenuItem();
        aboutButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NhacNhac v1.0");
        setIconImages(null);

        turnLabel.setFont(new java.awt.Font("MS Gothic", 2, 12)); // NOI18N
        turnLabel.setText("Vez do jogador: 1");

        jLabel2.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel2.setText("NhacNhac");

        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn2.setToolTipText("");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Jogo");

        resetButton.setText("Reiniciar");
        resetButton.setToolTipText("");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jMenu1.add(resetButton);

        closeButton.setText("Sair");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton(evt);
            }
        });
        jMenu1.add(closeButton);

        jMenuBar1.add(jMenu1);

        aboutButton.setText("Sobre");
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutButtonMouseClicked(evt);
            }
        });
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        jMenuBar1.add(aboutButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(turnLabel)
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(217, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(201, 201, 201)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(turnLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel2)
                    .addContainerGap(364, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn1, 1);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn2, 2);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn3, 3);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn5, 5);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn4, 4);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn6, 6);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn7, 7);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn8, 8);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
        buttonClicked(btn9, 9);
    }//GEN-LAST:event_btn9ActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void closeButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeButton

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void aboutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "NhacNhac v1.0\nPedro Abreu 26854-5\nBruno Anacleto 26717-4\nProgramação Orientada a Objetos III - UNIFAE");
    }//GEN-LAST:event_aboutButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhacNhac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhacNhac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhacNhac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhacNhac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhacNhac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutButton;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JMenuItem closeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem resetButton;
    private javax.swing.JLabel turnLabel;
    // End of variables declaration//GEN-END:variables
}
