package games;
import players.*;

public abstract class AbstractGame implements Game {

    protected Player joueur_1;
    protected Player joueur_2;
    protected Player joueur_courant;

    //constructeur prennant deux joueurs en arguments
    public AbstractGame(Player joueur_1, Player joueur_2) { //Constructeur
        this.joueur_1 = joueur_1;
        this.joueur_2 = joueur_2;

        //joueur courant initialisé en joueur1
        this.joueur_courant = joueur_1;
    }

    //méthode abstraite éxécutant le coup donné
    protected abstract void doExecute(int coup);

    //méthode renvoyant le joueur courant
    public players.Player getCurrentPlayer() {
        return this.joueur_courant;
    }

    //méthode appelant doexecute et changeant le joueur courant
    public void execute(int coup) {
        doExecute(coup);
        if (this.getCurrentPlayer() == this.joueur_1) {
            this.joueur_courant = this.joueur_2;
        } else {
            this.joueur_courant = this.joueur_1;
        }
    }


}
