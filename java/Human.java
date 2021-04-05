import java.util.Scanner;

public class Human extends Player{

    //Handles the humans draw decision and input
    public void drawDecision(Scanner input, Deck deck){
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
                System.out.println("You drew the " + this.cardString(this.getCard(4)));
            }
        }
    }

    //Handles the players discard decision
    public void discardDecison(Scanner input, Deck deck){
        System.out.println("Now you cards are:");

        printHand();

        System.out.println("Which card do you want to discard (1-5)?");

        int userInput = input.nextInt();

        switch (userInput){
            case 1:
                this.discardCardFromHand( 0, deck);
                break;
            case 2:
                this.discardCardFromHand(1, deck);
                break;
            case 3:
                this.discardCardFromHand(2, deck);
                break;
            case 4:
                this.discardCardFromHand(3, deck);
                break;
            case 5:
                this.discardCardFromHand(4, deck);
                break;
        }
    }

    //Prints out the users hand in string form
    private void printHand(){
        for(int i = 0; i < this.handSize(); i++){
            System.out.println("    " + (i+1) + this.cardString(this.getCard(i)));
        }
    }
}