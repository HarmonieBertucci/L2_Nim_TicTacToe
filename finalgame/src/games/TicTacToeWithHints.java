package games;
import players.*;
import java.util.ArrayList;


public class TicTacToeWithHints extends TicTacToe {

  //constructeur prennant deux joueurs en arguments
    public TicTacToeWithHints(Player joueur_1, Player joueur_2) { //Constructeur
        super(joueur_1, joueur_2);
    }

    //méthode retournant les indices pour le joueur courant
    public ArrayList<Integer> hints() {
      Player adversaire ;
      if (super.getCurrentPlayer()==super.joueur_1){
        adversaire=super.joueur_2;
      }
      else{
        adversaire=super.joueur_1;
      }
      ArrayList<Integer> hint = new ArrayList<Integer>() ;

      for(int coup=0;coup<9;coup++){
        int ligne = coup / 3;
        int col = coup % 3 ;
        if ((!super.joueur_1.equals(super.Plateau[ligne][col]))&&(!super.joueur_2.equals(super.Plateau[ligne][col]))){
          super.Plateau[ligne][col]=adversaire;

          if(super.getWinner()==adversaire){
            hint.add(coup);
          }
          super.Plateau[ligne][col]=null;
        }
      }
      return hint;
    }

    public String situationToString() {
        String chaine = "  1 2 3" + System.lineSeparator(); //Le rendu écran du plateau, lignes par lignes
        ArrayList<Integer> hints = hints();
        for (int i = 0; i < 3; i++) {
            chaine += i + 1;
            for (int j = 0; j < 3; j++) {
                if (Plateau[i][j] == joueur_1) {
                    chaine += " X"; //Remplace le point par le sigle du joueur
                } else if (Plateau[i][j] == joueur_2) {
                    chaine += " O"; //Remplace le point par le sigle du joueur
                } else if (hints.contains(j + (i * 3))) {
                    chaine += " !";//Remplace le point par "!" représentant la menace
                } else {
                    chaine += " .";
                }
            }
            chaine += System.lineSeparator();
        }
        return chaine + "\n\nAttention aux cases : " + hints()+"\n";
    }

    //affiche le nom du jeu
    @Override
    public String toString(){
        return "TicTacToeWithHints";
    }
}
