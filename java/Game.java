import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    //Todo- Determine if the rng is needed in this class
    //Random rng = new Random();
    ArrayList<Player> playerList = new ArrayList<>();
    Human humanPlayer = new Human();
    Deck deckOfCards = new Deck();

    public static void main(String[] args){

    }

    //Main method for the game
    public static void game(){
        Scanner input = new Scanner(System.in);



        for(int i = 0; i < 4; i++){

        }

    }

    //Checks if the player has won the game
    private boolean win(){
        return false;
    }

    private void dealFristCards(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            while (players.get(i).handSize() < 4){
                players.get(i).addCardToHand(deckOfCards.dealCard());
            }
        }
    }
}
