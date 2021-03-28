public class Card {
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

    public String cardString(){
        String card = "";

        switch (this.getNumericalValue()){
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

        switch (this.getSuit()){
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