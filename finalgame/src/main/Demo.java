package main;

import games.*;
import players.*;
import plays.*;

import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Orchestrator orchestrator;

        Scanner scanner_1 = new Scanner(System.in);

        Player player_1;
        Player player_2;

        Random random = new Random();

        System.out.println("\nBonjour, vous allez pouvoir jouer a un jeux : Nim ou Tic Tac Toe, mais d'abord :\n");

        System.out.println("Quel type de joueur est le joueur 1 ? \n- Utilisateur : 1 \n- Joueur Aléatoire: 2 \n- Joueur Negamax : 3 \n Votre réponse : "); // Choix Joueurs
        String answer_player = scanner_1.next();

        while (!answer_player.equals("1")&&!answer_player.equals("2")&&!answer_player.equals("3")) {
            System.out.println("\nType de joueur incorrect ; veuillez saisir le bon chiffre :\n- Utilisateur : 1 \n- Joueur Aléatoire: 2 \n- Joueur Negamax : 3 \n Votre réponse : "); // Choix Joueurs
            answer_player = scanner_1.next();
        }

        if (answer_player.equals("1")) {
            System.out.println("\nQuel est le pseudo du joueur 1 ?");
            String joueur_1 = scanner_1.next();
            player_1 = new Human(joueur_1, scanner_1);
        } else if (answer_player.equals("2")) {
            player_1 = new RandomPlayer(random);
        } else {
            player_1 = new NegamaxPlayer();
        }


        System.out.println("\nQuel type de joueur est le joueur 2 \n- Utilisateur : 1 \n- Joueur Aléatoire: 2 \n- Joueur Negamax : 3 \n Votre réponse : "); // Choix Joueurs
        answer_player = scanner_1.next();
        while (!answer_player.equals("1")&&!answer_player.equals("2")&&!answer_player.equals("3")) {
            System.out.println("\nType de joueur incorrect ; veuillez saisir le bon chiffre :\n- Utilisateur : 1 \n- Joueur Aléatoire: 2 \n- Joueur Negamax : 3 \n Votre réponse : "); // Choix Joueurs
            answer_player = scanner_1.next();
        }

        if (answer_player.equals("1")) {
            System.out.println("\nQuel est le pseudo du joueur 2 ?"); //Joueur 1
            String joueur_2 = scanner_1.next();
            player_2 = new Human(joueur_2, scanner_1);
        } else if (answer_player.equals("2")) {
            player_2 = new RandomPlayer(random);
        } else {
            player_2 = new NegamaxPlayer();
        }

        System.out.println("\nÀ quel jeu voulez-vous jouer ? \n- Nim : 1 \n- TicTacToe : 2 \n- TicTacToe with hints : 3 \nVotre réponse : ");
        String answer = scanner_1.next().toLowerCase();

        while(!answer.equals("1")&&!answer.equals("2")&&!answer.equals("3")){
          System.out.println("\nSaisie incorrecte ; À quel jeu voulez-vous jouer ? \n- Nim : 1 \n- TicTacToe : 2 \n- TicTacToe with hints : 3 \nVotre réponse : "); // Choix Joueurs
          answer = scanner_1.next();
        }

        if (answer.equals("1")) {
            System.out.println("\nQuelle est la taille initiale du tas d'allumettes ?"); //Taille initiale
            int taille_initial = Integer.parseInt(scanner_1.next());
            System.out.println("\nQuel est le nombre maximum d'allumettes qu'un joueur peut retirer ?");// Nb max d'allu
            int nombre_max_allu = Integer.parseInt(scanner_1.next());
            Nim JeuNim = new Nim(taille_initial, nombre_max_allu, player_1, player_2); // Nim est la classe
            //Orchestrator.playGame(JeuNim);
            orchestrator = new Orchestrator(JeuNim);
            orchestrator.play();

        } else if (answer.equals("2")) {
          System.out.println("\n///////////////////////////////\n");
            System.out.println("\nLe joueur 1 à les croix (X), et le joueur 2 les cercles (O)\n");
            TicTacToe JeuTicTacToe = new TicTacToe(player_1, player_2);
            orchestrator = new plays.Orchestrator(JeuTicTacToe);
            orchestrator.play();

        } else if (answer.equals("3")) {
          System.out.println("\n///////////////////////////////\n");
            System.out.println("\nLe joueur 1 à les croix (X), et le joueur 2 les cercles (O)\n");
            TicTacToeWithHints JeuTicTacToeWithHints = new TicTacToeWithHints(player_1, player_2);
            orchestrator = new plays.Orchestrator(JeuTicTacToeWithHints);
            orchestrator.play();
        }

    }
}
