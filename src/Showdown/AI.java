package Showdown;

import java.util.Scanner;

public class AI extends Player{

    @Override
    public void nameHimself(int order) {
        setName("AI-"+order);
    }
    public void showCard(){
        if (hand.getCardList().isEmpty()){
            System.out.println(this.getName()+" 沒牌出了！！");
            setShowingCard(new Card(Card.Suit.CLUB, Card.Rank.R0));
        }
        else {
            int order = (int)(Math.random()*hand.getCardList().size());
            if(order<hand.getCardList().size())
            {
                hand.showCard(order,this);
            }
            else{showCard();}
        }
    }
    @Override
    protected boolean needChange() {
        int r =(int)(Math.random()*2)+1;
        if(r>1)
        {
            return true;
        }
        return false;
    }

    @Override
    protected void exhangingHands() {
        int r = (int)(Math.random()*showdown.getPlayers().size());
        Player player = showdown.getPlayers().get(r);
        if (player==this){
            exhangingHands();
        }else{
            setExchangeHands(new ExchangeHands(this,showdown.getPlayers().get(r)));
        }
    }
}
