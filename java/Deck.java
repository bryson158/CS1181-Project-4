import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> drawPile = new ArrayList<>();
    private ArrayList<Card> discardPile = new ArrayList<>();
    private int cardsList;

    public Deck(){
        for(int i = 0; i< 4; i++){
            for(int p = 0; p < 13; p++){
                drawPile.add(new Card(i, p));
            }
        }
    }

    public void addToDiscardPile(Card card){
        discardPile.add(card);
    }

    public Card dealCard(){
        Random rng = new Random();

        return drawPile.get(rng.nextInt(drawPile.size()));
    }

}
