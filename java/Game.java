import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    //Todo- Determine if the rng is needed in this class
    //Random rng = new Random();

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

        for(int i = 0; i < 3; i++){
            playersList.add(new Robot());
        }

        //Calls the method to deal the first cards
        dealFristCards(playersList, deckOfCards);


        
    }

    //Checks if the player has won the game
    private boolean win(){
        return false;
    }

    //Deals out the first round of cards
    private static void dealFristCards(ArrayList<Player> players, Deck deck){
        for(int i = 0; i < players.size(); i++){
            while (players.get(i).handSize() < 4){
                players.get(i).addCardToHand(deck.dealCard());
            }
        }
    }

    private static String getCardString(){

    }
}
