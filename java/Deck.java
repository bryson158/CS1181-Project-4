import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> drawPile;
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
        if(drawPile.size() == 0){
            System.out.println("The discard pile was shuffled into the deck.");
            this.outOfCardShuffle();
        }
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

    //Returns the top card from the discard pile
    public Card discardCardTop() {
        return discardPile.get(discardPile.size()-1);
    }

    //Draws from the discard pile and removes the card from the discard pile list
    public Card discardCardDraw(){
        Card card = discardCardTop();
        this.discardPile.remove(card);
        return card;
    }

    //Shuffles the discard pile and resets it to be the draw pile now
    public void outOfCardShuffle(){
        this.drawPile = discardPile;
        discardPile.clear();
        System.out.println("The discard pile has been shuffled into the deck.");
    }

    public int topDiscardNumericalValue(){
        return this.discardCardTop().getNumericalValue();
    }
}