/*
 * Main.java
 * Author : Miras Andre & Tomio Nicolas
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /*// création d'un plateau
        Plateau plateau = new Plateau();
        //déclaration des joueurs
        // AbstractJoueur joueur1 = new JoueurMeilleurCoup1(Couleur.NOIR, plateau);
        AbstractJoueur joueur1 = new JoueurMeilleurCoup1(Couleur.NOIR, plateau);

        // AbstractJoueur joueur1 = new JoueurRandomIA(Couleur.NOIR, plateau,TypeJoueur.AUTOMATE);
        // AbstractJoueur joueur1 = new JoueurMeilleurCoup1(Couleur.NOIR, plateau, TypeJoueur.HUMAIN);
        AbstractJoueur joueur2 = new JoueurIntelligentPrudentIA(Couleur.BLANC, plateau, 4);
        //création de l'IHM du plateau
        IHMplateau ihm = new IHMplateau(plateau, joueur1, joueur2);
        //association de l'IHM au plateau
        plateau.setInterface(ihm);*/

        /*
         * On affiche l'interface acceuil qui permet de choisir
         * le type de joueur
         */
         InterfaceAccueil accueil = new InterfaceAccueil();
    }

}
