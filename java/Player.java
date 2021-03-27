import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<>();

    //Returns the players size of their hand.
    public int handSize(){
        return this.hand.size();
    }

    public void addCardToHand(Card c){
        hand.add(c);
    }

    public void discardCardFromHand(Card c, Deck deck){
        hand.remove(c);
        deck.addToDiscardPile(c);
    }

    //Returns the value of the card in a string
    public String cardString(int index){
        String card = "";

        Card c = this.hand.get(index);

        switch (c.getNumericalValue()){
            case 0:
                card += " Two of ";
                break;
            case 1:
                card += " Three of ";
                break;
            case 2:
                card += " Four of ";
                break;
            case 3:
                card += " Five of ";
                break;
            case 4:
                card += " Six of ";
                break;
            case 5:
                card += " Seven of ";
                break;
            case 6:
                card += " Eight of ";
                break;
            case 7:
                card += " Nine of ";
                break;
            case 8:
                card += " Ten of ";
                break;
            case 9:
                card += " Jack of ";
                break;
            case 10:
                card += " Queen of ";
                break;
            case 11:
                card += " King of ";
                break;
            case 12:
                card += " Ace of ";
        }

        switch (c.getSuit()){
            case 0:
                card += "Spades";
                break;
            case 1:
                card += "Hearts";
                break;
            case 2:
                card += "Diamonds";
                break;
            case 3:
                card += "Clubs";
                break;
        }

        return card;
    }

}
