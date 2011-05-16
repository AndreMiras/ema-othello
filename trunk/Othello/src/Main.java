/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author andre
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
        Joueur joueur1 = new Joueur(Couleur.NOIR, plateau,TypeJoueur.HUMAIN);
        // Joueur joueur2 = new Joueur(Couleur.BLANC, plateau, TypeJoueur.AUTOMATE);
        Joueur joueur2 = new Joueur(Couleur.BLANC, plateau, TypeJoueur.AUTOMATE);
        //création de l'IHM du plateau
        IHMplateau ihm = new IHMplateau(plateau, joueur1, joueur2);
        //association de l'IHM au plateau
        plateau.setInterface(ihm);

    }

}
