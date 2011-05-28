/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // création d'un plateau
        Plateau plateau = new Plateau();
        //déclaration des joueurs
        AbstractJoueur joueur1 = new JoueurRandomIA(Couleur.NOIR, plateau,TypeJoueur.HUMAIN);
        // Joueur joueur2 = new Joueur(Couleur.BLANC, plateau, TypeJoueur.AUTOMATE);
        AbstractJoueur joueur2 = new JoueurMeilleurCoup1(Couleur.BLANC, plateau, TypeJoueur.HUMAIN);
        //création de l'IHM du plateau
        IHMplateau ihm = new IHMplateau(plateau, joueur1, joueur2);
        //association de l'IHM au plateau
        plateau.setInterface(ihm);

    }

}
