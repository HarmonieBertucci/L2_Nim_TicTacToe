package players;

import games.Game;

public class NegamaxPlayer implements Player {

  //constructeur ne prennant rien en arguments
    public NegamaxPlayer() {
    }

    @Override
    public int chooseMove(Game jeu) {
        Integer meilleur_coup = null;
        Integer meilleur_valeur = null;
        Game copy;
        int evalutate_res;
        for (int move : jeu.validMoves()) {
            copy = jeu.copy();
            copy.execute(move);
            evalutate_res = -evaluate(copy);
            if (meilleur_valeur == null || evalutate_res > meilleur_valeur) {
                meilleur_valeur = evalutate_res;
                meilleur_coup = move;

            }
        }
        return meilleur_coup;
    }


    public int evaluate(Game jeu) {
        if (jeu.isOver()) {
            if (jeu.getWinner() == jeu.getCurrentPlayer()) {
                return 1;
            } else if (jeu.getWinner() == null) {
                return 0;
            } else {
                return -1;
            }
        } else {
            Integer res = null;
            Game copy;
            int evaluate_res;
            for (int move : jeu.validMoves()) {
                copy = jeu.copy();
                copy.execute(move);
                evaluate_res = -evaluate(copy);
                if (res == null || evaluate_res > res) {
                    res = evaluate_res;
                }
            }
            return res;
        }
    }
    
}
