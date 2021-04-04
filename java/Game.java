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

        for(int i = 0; i < robotList.size(); i++){
            playersList.add(robotList.get(i));
        }

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
                if(playersList.get(i) == humanPlayer){
                    humanPlayer.drawDecison(input, deckOfCards);
                }

                boolean gameWon = playersList.get(i).playerWonGame();
                if(gameWon){
                    for(int p = 0; p < robotList.size(); p++){
                        if(robotList.get(p) == playersList.get(i)){
                            System.out.println("I Won!");
                            gameOver = true;
                            break;
                        }
                    }
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