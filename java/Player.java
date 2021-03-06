import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<>();

    //Returns the players size of their hand.
    public int handSize(){
        return this.hand.size();
    }

    //Method for adding a card to a players hand
    public void addCardToHand(Card c){
        this.hand.add(c);
    }

    //Method for discarding a specific card from the players hand
    public void discardCardFromHand(int index, Deck deck){
        deck.addToDiscardPile(getCard(index));
        hand.remove(index);
    }

    //Returns the value of the card in a string
    public String cardString(Card c){
        String card = "";

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

    //Returns a specific card in a players hand
    public Card getCard(int cardNumber){
        return hand.get(cardNumber);
    }


    //Determines if player has won the game
    public boolean playerWonGame(){
        int check = this.getCard(0).getNumericalValue();
        for(int i = 0; i < this.handSize(); i++){
            if(check != this.getCard(i).getNumericalValue()){
                return false;
            }
        }
        return true;
    }

    //Returns the entirety of a players hand in an arraylist
    public ArrayList<Card> returnPlayerHand(){
        return this.hand;
    }
}