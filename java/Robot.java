import java.util.ArrayList;
import java.util.Collections;

public class Robot extends Player {
    //Handles the robots turn for drawing a card
    public void robotDrawDecision(Deck deck) {
        //System.out.println("Robot turn");

        //Forces the robot to draw from the draw pile if the discard pile is empty
        if (deck.discardPileSize() == 0) {
            System.out.println("I drew a card");
            this.addCardToHand(deck.dealCard());
        }
        else if(deck.drawPileSize() == 0){
            deck.outOfCardShuffle();
            System.out.println("The discard pile has been shuffled and added to the draw pile");
            deck.dealCard();
        }
        else {
            boolean drawnCard = false;

            //Determines if the card in the discard pile is in the robots hand. if it is it will draw the card.
            // Regardless of the other cards in the hand
            for (int i = 0; i < this.handSize(); i++) {
                if(this.getCard(i).getNumericalValue() == deck.topDiscardNumericalValue()){
                    System.out.println("I picked up the" + deck.discardCardTop().cardString());
                    this.addCardToHand(deck.discardCardDraw());
                    drawnCard = true;
                    break;
                }
            }
            if(!drawnCard){
                this.addCardToHand(deck.dealCard());
                System.out.println("I drew a card.");
            }

        }
    }

    //Handles the decision for the robot for choosing a card to discard.
    public void discardDecision(Deck deck){
        //Stores the players hand locally
        ArrayList<Card> hand = returnPlayerHand();

        Card lastCardDrawn = hand.get(hand.size()-1);

        boolean lastCardMatches = false;

        //Determines if the last card drawn matches with another card in the hand
        for(int i = 0; i < hand.size() - 1; i++){
            if(hand.get(i).getNumericalValue() == lastCardDrawn.getNumericalValue()){
                lastCardMatches = true;
                break;
            }
        }

        //This arrayList stores the numerical values of the cards without duplicates
        ArrayList<Integer> numericalValues = new ArrayList<>();
        Collections.sort(numericalValues);

        int mostMatchesValue = 0;


        //Last card matched with another this will make the decision for the "Robot"
        if(lastCardMatches){
            for(int i = 0; i < this.handSize(); i++){
                if(!numericalValues.contains(hand.get(i).getNumericalValue())){
                    numericalValues.add(hand.get(i).getNumericalValue());
                }
            }

            int mostMatches = 0;

            for(int i = 0; i < numericalValues.size(); i++){
                int temp = countOccurrences(numericalValues, numericalValues.get(i));
                if(temp > mostMatches){
                    mostMatches = temp;
                    mostMatchesValue = numericalValues.get(i);
                }
            }

            //Discards the card that the player doesn't have the most of a kind of
            for(int i = 0; i < this.handSize(); i++){
                if(this.getCard(i).getNumericalValue() != mostMatchesValue){
                    System.out.println("I discarded the" + this.getCard(i).cardString());
                    this.discardCardFromHand(i, deck);
                    break;
                }
            }


        }
        //Discards the last card drawn since it doesn't match with any other card in the hand
        else {
            System.out.println("I discarded the" + this.getCard(this.handSize()-1).cardString());
            this.discardCardFromHand(this.handSize()-1, deck);
        }
    }

    //counts how frequently a number appears in the list
    static int countOccurrences(ArrayList<Integer> arr, int x)
    {
        int count = 0;
        for (int i=0; i < arr.size(); i++)
            if (x == arr.get(i))
                count++;
        return count;
    }
}