import java.util.ArrayList;
import java.util.Comparator;

public class Robot extends Player {
    //Handles the robots turn for drawing a card
    public void robotDrawDecison(Deck deck) {
        if (deck.discardPileSize() == 0) {
            this.addCardToHand(deck.dealCard());
        } else {
            ArrayList<Card> sortedHand = new ArrayList<>();

            sortedHand = this.returnPlayerHand();
            sortedHand.sort(Comparator.comparing(Card::getNumericalValue));

            ArrayList<Integer> numericalValueCards = new ArrayList<>();

            for (int i = 0; i < this.handSize(); i++) {
                if(sortedHand.get(i).getNumericalValue() == sortedHand.get(i-1).getNumericalValue() && i>0){
                    numericalValueCards.add(sortedHand.get(i).getNumericalValue());
                }
            }
            for(int i = 0; i < numericalValueCards.size(); i++){
                if(numericalValueCards.get(i) == deck.topDiscardNumericalValue()){
                    this.addCardToHand(deck.discardCardDraw());
                }
            }
        }
    }

    public void discardDecison(Deck deck){

    }
}