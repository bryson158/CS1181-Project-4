import java.util.Scanner;

public class Human extends Player{

    public void drawDecison(Scanner input, Deck deck){
        System.out.println("You cards are:");

        printHand();

        if(deck.discardPileSize() == 0){
            System.out.println("The discard pile is currently empty -- you must draw a card");
            this.addCardToHand(deck.dealCard());
        }
        else {
            System.out.println("The top card in the discard pile is the" + cardString(deck.discardCardTop()));
            System.out.println("Do you want to pickup the " + cardString(deck.discardCardTop()) + " (1) or draw a card (2)?");

            int userInput = input.nextInt();

            if(userInput == 1){
                this.addCardToHand(deck.discardCardDraw());
            }
            else {
                this.addCardToHand(deck.dealCard());
            }
        }
    }

    public void discardDecison(Scanner input, Deck deck){
        System.out.println("Now you cards are:");

        printHand();
    }

    //Prints out the users hand
    private void printHand(){
        for(int i = 0; i < this.handSize(); i++){
            System.out.println("    " + this.cardString(this.getCard(i)));
        }
    }
}