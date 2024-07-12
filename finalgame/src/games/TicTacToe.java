package games;
import players.*;
import java.util.ArrayList;

public class TicTacToe extends AbstractGame {
    protected Player[][] Plateau;

    //constructeur prennant deux joueurs en arguments
    public TicTacToe(Player joueur_1, Player joueur_2) {
        super(joueur_1, joueur_2); //Constructeur
        this.Plateau = new Player[3][3];

    }
    //met à jour le jeu
    @Override
    protected void doExecute(int coup) {
        int ligne = coup / 3;
        int col = coup % 3;
        this.Plateau[ligne][col] = this.joueur_courant;
    }

    //détermine si un coup donné est un coup valide
    public boolean isValid(int coup) {  //Vérifie que le coup est valide
        int ligne = coup / 3;
        int col = coup % 3;

        return ((coup <= 8) && (coup >= 0) && this.Plateau[ligne][col] == null);

    }
    //retourne la liste de tous les coups valides dans la situation courante
    public ArrayList<Integer> validMoves() { //Renvoi la liste des coups valides
        ArrayList<Integer> coup_valides = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            if (this.Plateau[i / 3][i % 3] == null) {
                coup_valides.add(i);
            }
        }
        return coup_valides;
    }

    //détermine si une case et sa rangée sont complétés
    public boolean wins(Player joueur, int row, int column, int deltaRow, int deltaColumn) {
        return joueur.equals(this.Plateau[row][column]) &&
                joueur.equals(this.Plateau[row + deltaRow][column + deltaColumn]) &&
                joueur.equals(this.Plateau[row + 2 * deltaRow][column + 2 * deltaColumn]);

    }

    //renvoie qui est le gagnant en vérifiant si les trois sont bien alignés
    public Player getWinner() {
        for (int i = 0; i < 3; i++) {
            if (wins(this.joueur_1, i, 0, 0, 1)) {
                return this.joueur_1;
            }
            if (wins(this.joueur_2, i, 0, 0, 1)) {
                return this.joueur_2;
            }
            if (wins(this.joueur_1, 0, i, 1, 0)) {
                return this.joueur_1;
            }
            if (wins(this.joueur_2, 0, i, 1, 0)) {
                return this.joueur_2;
            }
        }

        if (wins(this.joueur_1, 0, 0, 1, 1)) {
            return this.joueur_1;
        }
        if (wins(this.joueur_2, 0, 0, 1, 1)) {
            return this.joueur_2;
        }

        if (wins(this.joueur_1, 0, 2, 1, -1)) {
            return this.joueur_1;
        }
        if (wins(this.joueur_2, 0, 2, 1, -1)) {
            return this.joueur_2;
        }

        return null;
    }


    //détermine si le jeu est terminé
    public boolean isOver() { //C'est fini quand qqun à gagné ou quand il n'y a plus de coups possibles
        return (getWinner() != null || validMoves().size() == 0);
    }

    //retourne la représentation naturelle d'un coup
    public String moveToString(int move) {
        return move + " = " + "(" + ((move / 3) + 1) + ", " + ((move % 3) + 1) + ")";
    }

    //retourne une représentation du plateau courant
    public String situationToString() {
        String chaine = "  1 2 3" + System.lineSeparator(); //Le rendu écran du plateau, lignes par lignes
        for (int i = 0; i < 3; i++) {
            chaine += i + 1;
            for (int j = 0; j < 3; j++) {
                if (Plateau[i][j] == joueur_1) {
                    chaine += " X"; //Remplace le point par le sigle du joueur
                } else if (Plateau[i][j] == joueur_2) {
                    chaine += " O"; //Remplace le point par le sigle du joueur
                } else {
                    chaine += " .";
                }
            }
            chaine += System.lineSeparator();
        }
        return chaine;
    }

    //affiche le nom du jeu
    @Override
    public String toString(){
        return "TicTacToe";
    }

    //renvoie une copie du jeu
    @Override
    public Game copy() {
            TicTacToe copy = new TicTacToe(this.joueur_1, this.joueur_2);
            copy.joueur_courant = super.joueur_courant;

            copy.Plateau = new Player[3][3];
            for (int i=0;i<9;i++){
                int ligne = i / 3;
                int col = i % 3 ;
                copy.Plateau[ligne][col]=this.Plateau[ligne][col];
            }

            return copy;
        }

}
