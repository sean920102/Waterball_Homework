package Showdown;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cardList=new ArrayList<Card>();
    public void addCard(Card card){
        cardList.add(card);
    }
    public void showCard(int order,Player player){
        player.setShowingCard(cardList.get(order));
        cardList.remove(order);
        System.out.println(player.getName()+"打出："+player.getShowingCard());
    }
    public List<Card> getCardList() {
        return cardList;
    }
    public int size() {
        return cardList.size();
    }
    public Card get(int index) {
        return cardList.get(index);
    }
}
