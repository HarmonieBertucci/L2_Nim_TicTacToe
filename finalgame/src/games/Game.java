package games;
import players.*;
import java.util.ArrayList;

public interface Game{

  //méthode éxécutant le coup donné et changeant le joueur courant
  public void execute(int coup);

  //méthode renvoyant le joueur courant
  public Player getCurrentPlayer();

  //renvoie une liste des coups valides()
  public abstract ArrayList<Integer> validMoves();

  //retourne une représentation de la situation courante
  public abstract String situationToString();

  //réécrit un coup un chaine de caractères
  public abstract String moveToString(int coup);

  //détermine si le jeu est terminé
  public abstract boolean isOver();

  //renvoie qui est le gagnant
  public abstract Player getWinner();

  //détermine si un nombre d'allumettes représente un coup valide
  public abstract boolean isValid(int coup);

  //méthode permettant la copie qu'un jeu
  public abstract Game copy();

}
