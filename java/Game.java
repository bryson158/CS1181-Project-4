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

        //Adds the robots to the players list
        for (int i = 0; i < 3; i++) {
            playersList.add(new Robot());
        }

        //Calls the method to deal the first cards
        dealFirstCards(playersList, deckOfCards);

        //Will run the game until someone wins the game
        while (!win()) {
            for(int i = 0; i < humanPlayer.handSize(); i++){
                    System.out.println("    " + i + humanPlayer.cardString(humanPlayer.getCard(i)));
            }
        }
    }

    //Checks if the player has won the game
    private static boolean win(){
        return false;
    }

    //Deals out the first round of cards
    private static void dealFirstCards(ArrayList<Player> players, Deck deck){
        for(int i = 0; i < players.size(); i++){
            while (players.get(i).handSize() < 4){
                players.get(i).addCardToHand(deck.dealCard());
            }
        }
        System.out.println("Your cards are:");
    }

    //Method for allowing the human player to make their decisions
    private static void playerDrawDecision(Deck deckOfCards, Scanner input, Player humanPlayer){
        if(deckOfCards.drawPileSize() == 0){
            System.out.println("The draw pile is empty you must draw a card from the discard pile: ");
            humanPlayer.addCardToHand(deckOfCards.);
        }
        else if(deckOfCards.discardPileSize() == 0){
            System.out.println("The discard pile is empty -- you must draw a card");
            humanPlayer.addCardToHand(deckOfCards.discardCardTop());
        }
        else {
            System.out.println("Do you want to pick up " + );
        }
    }
}