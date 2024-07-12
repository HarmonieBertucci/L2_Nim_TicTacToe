package players;
import java.util.Scanner;
import games.Game;


public class Human implements Player {
    protected String name;
    protected Scanner scanner;

    //constructeur prennant un nom et un scanner en arguments
    public Human(String name, Scanner scanner) { //Constructeur
        this.name = name;
        this.scanner = scanner;

    }

    //méthode retournant un coup valide choisi par le joueur
    @Override
    public int chooseMove(Game jeu) {
      System.out.println("\nCoups valides : "+jeu.validMoves());
        System.out.println(" \nQuel coup avez vous choisi ?");
        String answer = scanner.next().toLowerCase();
        int answerToInteger = Integer.parseInt(answer);
        if (!jeu.isValid(answerToInteger)) {
            System.out.println("\nCe coups n'est pas valide");
            answerToInteger = chooseMove(jeu);
        }
        return answerToInteger;

      /*
      //perso j'aurais mis le code suivant pour qu'il n'y ai pas d'exception quand le coup choisi est une lettre :
        boolean debut=true;
        System.out.println("\nCoups valides : "+jeu.validMoves());
        System.out.println(" \nQuel coup avez vous choisi ?");
        String answer = scanner.next().toLowerCase();
        boolean testEntier = false;
        int i=0;
        while(i<=8){
          if (Integer.parseInt(answer)==i){
            testEntier = true;
          }
          i++;
        }

        while(debut||!jeu.isValid(Integer.parseInt(answer))||!testEntier){
          debut=false;
          System.out.println("Ce coups n'est pas valide.");
          System.out.println("\nCoups valides : "+jeu.validMoves());
          System.out.println(" \nQuel coup avez vous choisi ?");
          answer = scanner.next().toLowerCase();

          testEntier = false;
          i=0;
          while(i<=8){
            if (Integer.parseInt(answer)==i){
              testEntier = true;
            }
            i++;
          }
        }

        return Integer.parseInt(answer);*/
    }

    //méthode retournant le nom du joueur
    public String toString() {
        return this.name;
    }


}
