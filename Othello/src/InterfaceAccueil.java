
import javax.swing.JOptionPane;

/*
 * InterfaceAccueil.java
 * Author : Miras Andre & Tomio Nicolas
 */
public class InterfaceAccueil extends javax.swing.JFrame {

    /** Creates new form InterfaceAccueil */
    public InterfaceAccueil() {
        initComponents();
        this.setVisible(true);
        this.pack();
    }

    private void afficePopup()
    {
        JOptionPane.showMessageDialog(this, "Vous avez choisi les deux mêmes couleurs");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        choixJoueur1 = new javax.swing.JComboBox();
        choixJoueur2 = new javax.swing.JComboBox();
        choixAutomateJoueur1 = new javax.swing.JComboBox();
        choixAutomateJoueur2 = new javax.swing.JComboBox();
        choixCouleurJoueur1 = new javax.swing.JComboBox();
        choixCouleurJoueur2 = new javax.swing.JComboBox();
        boutonJouer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Choix des joueurs");

        jLabel2.setText("Joueur 1");

        jLabel3.setText("Joueur 2");

        choixJoueur1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Automate", "Humain" }));

        choixJoueur2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Automate", "Humain" }));
        choixJoueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choixJoueur2ActionPerformed(evt);
            }
        });

        choixAutomateJoueur1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aléatoire", "Meilleur Coup", "Arbre" }));

        choixAutomateJoueur2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aléatoire", "Meilleur Coup", "Arbre" }));

        choixCouleurJoueur1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Noir", "Blanc" }));

        choixCouleurJoueur2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blanc", "Noir" }));

        boutonJouer.setText("Jouer");
        boutonJouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonJouerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(choixCouleurJoueur1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(choixAutomateJoueur1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choixJoueur1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(choixCouleurJoueur2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(choixAutomateJoueur2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choixJoueur2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boutonJouer, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(187, 187, 187))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixJoueur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choixJoueur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixAutomateJoueur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choixAutomateJoueur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixCouleurJoueur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choixCouleurJoueur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(boutonJouer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonJouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonJouerActionPerformed

         Plateau plateau = new Plateau();
         AbstractJoueur joueur1 = null;
         AbstractJoueur joueur2 = null;

         /*
          * On recupere la couleur du joueur 1
          */
         Couleur couleurJoueur1 = null;
         
         if (choixCouleurJoueur1.getSelectedItem()=="Noir")
         {
            couleurJoueur1 = Couleur.NOIR;
         }
         else if (choixCouleurJoueur1.getSelectedItem()=="Blanc")
         {
            couleurJoueur1 = Couleur.BLANC;
         }
         
         /*
          * On recupere la couleur du joueur 2
          */
         Couleur couleurJoueur2 = null;

         if (choixCouleurJoueur2.getSelectedItem()=="Noir")
         {
            couleurJoueur2 = Couleur.NOIR;
         }
         else if (choixCouleurJoueur2.getSelectedItem()=="Blanc")
         {
            couleurJoueur2 = Couleur.BLANC;
         }


        /*
         * Création du premier joueur
         */

        if (choixJoueur1.getSelectedItem() == "Humain")
        {
            // TODO: fix this
            joueur1 = new JoueurMeilleurCoup1(couleurJoueur1, plateau,TypeJoueur.HUMAIN);
        }
        else if(choixJoueur1.getSelectedItem() == "Automate")
        {
            if(choixAutomateJoueur1.getSelectedItem() == "Aléatoire")
            {
                joueur1 = new JoueurRandomIA(couleurJoueur1, plateau);
            }
            else if (choixAutomateJoueur1.getSelectedItem() == "Meilleur Coup")
            {
                joueur1 = new JoueurMeilleurCoup1(couleurJoueur1, plateau);
            }
            else if(choixAutomateJoueur1.getSelectedItem() == "Arbre")
            {
                joueur1 = new JoueurIntelligentPrudentIA(couleurJoueur1, plateau);
            }
        }


       
         /*
          * Création du deuxieme joueur
          */
        if (choixJoueur2.getSelectedItem() == "Humain")
        {
            joueur2 = new JoueurMeilleurCoup1(couleurJoueur2, plateau,TypeJoueur.HUMAIN);
        }
        else if(choixJoueur2.getSelectedItem() == "Automate")
        {
            if(choixAutomateJoueur2.getSelectedItem() == "Aléatoire")
            {
                joueur2 = new JoueurRandomIA(couleurJoueur2, plateau);
            }
            else if (choixAutomateJoueur2.getSelectedItem() == "Meilleur Coup")
            {
                joueur2 = new JoueurMeilleurCoup1(couleurJoueur2, plateau);
            }
            else if(choixAutomateJoueur2.getSelectedItem() == "Arbre")
            {
                joueur2 = new JoueurIntelligentPrudentIA(couleurJoueur2, plateau,TypeJoueur.AUTOMATE);
            }
        }

         /*
          * Vérification que l'utilisateur n'a pas choisi deux fois la meme couleur
          * Si oui, on affiche un message d'avertissement
          * sinon on lance le jeu
          */


         if(couleurJoueur1 == couleurJoueur2)
         {
             this.afficePopup();
         }
         else
         {
            //création de l'IHM du plateau
            IHMplateau ihm = new IHMplateau(plateau, joueur1, joueur2);
            //association de l'IHM au plateau
            plateau.setInterface(ihm);
         }

    }//GEN-LAST:event_boutonJouerActionPerformed

    private void choixJoueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choixJoueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choixJoueur2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceAccueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonJouer;
    private javax.swing.JComboBox choixAutomateJoueur1;
    private javax.swing.JComboBox choixAutomateJoueur2;
    private javax.swing.JComboBox choixCouleurJoueur1;
    private javax.swing.JComboBox choixCouleurJoueur2;
    private javax.swing.JComboBox choixJoueur1;
    private javax.swing.JComboBox choixJoueur2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
