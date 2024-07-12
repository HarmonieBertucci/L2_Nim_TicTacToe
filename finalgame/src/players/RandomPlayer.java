package players;
import games.Game;

public class RandomPlayer implements Player {
    protected java.util.Random random;

    //constructeur prennant un random en argument
    public RandomPlayer(java.util.Random random) {
        this.random = random;
    }

    //méthode retournant un coup valide au hazard
    @Override
    public int chooseMove(Game jeu) {
        return jeu.validMoves().get(this.random.nextInt(jeu.validMoves().size()));

    }

    //méthode retournant le nom du joueur
    public String toString() {
        return "Joueur aléatoire n° " + this.hashCode();
    }

}
