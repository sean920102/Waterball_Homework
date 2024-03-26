package Showdown;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cardStack=new Stack<Card>();
    public Deck() {
        Card.Suit[] suits = Card.Suit.values();
        Card.Rank[] ranks = Card.Rank.values();
        for (Card.Suit suit : suits) {
            for (Card.Rank rank : ranks) {
                if(!rank.toString().equals("0")){
                    cardStack.push(new Card(suit, rank));
                }
            }
        }
    }

    public Stack<Card> getCardStack() {
        return cardStack;
    }

    public void shuffle(){
        Collections.shuffle(cardStack);
    }
    public Card drowCard(){
        return cardStack.pop();
    }

    public int showDeck(){
        return cardStack.size();
    }
}
