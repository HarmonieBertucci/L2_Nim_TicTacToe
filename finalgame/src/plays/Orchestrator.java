package plays;
import games.Game;
import java.util.Scanner;
import players.Player;


public class Orchestrator {
    protected games.Game jeu;

    //constructeur prennant un Game en argument
    public Orchestrator(Game jeu) {
        this.jeu = jeu;
    }

    //permet de jouer à un jeu quelconque
    public void play() {

        while (!this.jeu.isOver()) {
        	System.out.println("\n///////////////////////////////\n");
            System.out.println(jeu.situationToString());
            for (Integer move : jeu.validMoves()) {
                String moveToString = jeu.moveToString(move);
                if (moveToString != null) {
                    System.out.println(moveToString);
                }
            }
            System.out.println("\nA vous de jouer : " + jeu.getCurrentPlayer().toString());
            jeu.execute(jeu.getCurrentPlayer().chooseMove(jeu));

        }
        System.out.println("\n///////////////////////////////\n");
        if (this.jeu.getWinner() != null) {
            System.out.println("Le gagnant de cette partie du jeu de " + this.jeu + " est " + this.jeu.getWinner().toString() + " !");
        } else {
            System.out.println("Match Nul");
        }


    }


}
