import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        game();
    }

    //Main method for the game
    public static void game(){
        Scanner input = new Scanner(System.in);
        Deck deckOfCards = new Deck();
        Human humanPlayer = new Human();

        ArrayList<Player> playersList = new ArrayList<>();

        playersList.add(humanPlayer);

        ArrayList<Robot> robotList = new ArrayList<>();

        //Adds the robots to the players list
        for (int i = 0; i < 3; i++) {
            robotList.add(new Robot());
        }

        //Adds the robots to the player list
        playersList.addAll(robotList);

        //Randomizes the player list so the order in which turns are taken are random
        Collections.shuffle(playersList);

        //Calls the method to deal the first cards
        dealFirstCards(playersList, deckOfCards);

        //The bool used for the loop
        boolean gameOver = false;

        //Will run the game until someone wins the game
        while (!gameOver){
            //Calls the method to deal the first hands of the game
            dealFirstCards(playersList, deckOfCards);

            for(int i = 0; i < playersList.size(); i++){
                //Handles the human players turn
                if(playersList.get(i) == humanPlayer){
                    humanPlayer.drawDecision(input, deckOfCards);
                    humanPlayer.discardDecison(input, deckOfCards);
                }
                for(int p = 0; p < robotList.size(); p++){
                    if(playersList.get(i) == robotList.get(p)){
                        //Calls the methods needed for the robots turn
                        robotList.get(p).robotDrawDecision(deckOfCards);
                        robotList.get(p).discardDecision(deckOfCards);
                    }
                }

                //Sets the while loops bool to the result of the method used for determining the winner of the game
                gameOver = playersList.get(i).playerWonGame();
                if(gameOver){
                    //Informs the user if they lost the game
                    for(int p = 0; p < robotList.size(); p++){
                        if(robotList.get(p) == playersList.get(i)){
                            System.out.println("I won!");
                            gameOver = true;
                            break;
                        }
                    }
                    //Informs the user that they won the game
                    if(humanPlayer == playersList.get(i)){
                        System.out.println("You won!");
                        gameOver = true;
                        break;
                    }
                }
                if(gameOver){
                    break;
                }
            }
        }
    }

    //Deals out the first round of cards
    private static void dealFirstCards(ArrayList<Player> players, Deck deck) {
        for (int i = 0; i < players.size(); i++) {
            while (players.get(i).handSize() < 4) {
                players.get(i).addCardToHand(deck.dealCard());
            }
        }
    }

}