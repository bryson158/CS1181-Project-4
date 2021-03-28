import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> drawPile = new ArrayList<>();
    private ArrayList<Card> discardPile = new ArrayList<>();

    //Creates the deck of cards
    public Deck(){
        ArrayList<Card> cardList = new ArrayList<>();
        for(int i = 0; i< 4; i++){
            for(int p = 0; p < 13; p++){
                cardList.add(new Card(i, p));
            }
        }
        this.drawPile = cardList;
    }

    //Adds a card to the discard pile
    public void addToDiscardPile(Card card){
        discardPile.add(card);
    }

    //Deals a card and chooses it at random
    public Card dealCard(){
        Random rng = new Random();

        Card cardPicked = drawPile.get(rng.nextInt(drawPile.size()));

        //Removes the card from the draw pile
        drawPile.remove(cardPicked);

        return cardPicked;
    }

    //returns the size of the draw pile
    public int drawPileSize(){
        return drawPile.size();
    }

    //Returns the size of the discard pile
    public int discardPileSize(){
        return discardPile.size();
    }

    public Card discardCardTop() {
        return discardPile.get(discardPile.size()-1);
    }
}