package games;
import players.*;
import java.util.ArrayList;

public class Nim extends AbstractGame {
    private int taille_initiale;
    private int nombre_max_allu;
    private int taille_courante;

    //constructeur prennant la taille initiale du tas, le nombre max d'allumettes a prendre par tour et deux joueurs en arguments
    public Nim(int taille_initiale, int nombre_max_allu, Player joueur_1, Player joueur_2) { //Constructeur
        super(joueur_1, joueur_2);
        this.taille_initiale = taille_initiale;
        this.taille_courante = taille_initiale;
        this.nombre_max_allu = nombre_max_allu;
    }
    //retourne la taille initiale du tas
    public int getInitialNbMatches() {
        return this.taille_initiale;
    }

    //retourne la taille courante du tas
    public int getCurrentNbMatches() {
        return this.taille_courante;
    }

    //met a jour le jeu
    @Override
    protected void doExecute(int coup) {
        this.taille_courante = getCurrentNbMatches() - coup;
    }

    //renvoie une liste des coups valides
    @Override
    public ArrayList<Integer> validMoves() {
        ArrayList<Integer> liste = new ArrayList<Integer>();
        for (int i = 1; i <= getCurrentNbMatches(); i++) {
            if (i <= this.nombre_max_allu) {
                liste.add(i);
            }
        }
        return liste;
    }

    //retourne une représentation de la situation courante
    @Override
    public String situationToString() {

        return "Il reste " + getCurrentNbMatches() + " allumettes.";
    }

    //réécrit un coup un chaine de caractères
    @Override
    public String moveToString(int move) {
      return null;
    }


    //détermine si un nombre d'allumettes représente un coup valide
    @Override
    public boolean isValid(int nombre_allu) { // car renvoie oui ou non
        return (nombre_allu > 0 && nombre_allu <= nombre_max_allu && nombre_allu <= taille_courante);
    }

    //affiche le nom du jeu
    @Override
    public String toString(){
        return "Nim";
    }

    //détermine si le jeu est terminé
    @Override
    public boolean isOver() {
        return (this.taille_courante == 0);
    }

    //renvoie qui est le gagnant
    @Override
    public Player getWinner() {
        if (isOver()) {
            return super.getCurrentPlayer();
        } else {
            return null;
        }
    }

    //renvoie une copie du jeu
    @Override
    public Game copy() {
        Nim copyjeu = new Nim(this.taille_initiale, this.nombre_max_allu, this.joueur_1, this.joueur_2);
        copyjeu.taille_courante = this.getCurrentNbMatches();
        copyjeu.joueur_courant = super.getCurrentPlayer();
        return copyjeu;
    }
}
