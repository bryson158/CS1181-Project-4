public class Card extends Deck {
    private int suit;
    private int numericalValue;

    public Card(int suit, int cardNumber) {
        this.numericalValue = cardNumber;
        this.suit = suit;
    }

    public int getSuit(){
        return this.suit;
    }

    public int getNumericalValue(){
        return this.numericalValue;
    }
}