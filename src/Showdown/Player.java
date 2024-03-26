package Showdown;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public abstract class Player {
    private String name;
    private int point=0;
    protected Hand hand = new Hand();
    protected abstract void nameHimself(int order);
    protected Showdown showdown;
    private final Scanner in = new Scanner(System.in);
    private ExchangeHands exchangeHands;
    private Card showingCard;

    public void takeTurn(){
        if(getExchangeHands() == null){
            if(needChange()){
                exhangingHands();
            }
        }
        else{
            getExchangeHands().roundCountDown();
        }
        showCard();
    }
    protected abstract void showCard();

    protected abstract boolean needChange();
    protected abstract void exhangingHands();

    public void addHandCard(Card card){
        hand.addCard(card);
    }
    public void gainPoint(){
        setPoint(getPoint()+1);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public Showdown getShowdown() {
        return showdown;
    }

    public void setShowdown(Showdown showdown) {
        this.showdown = showdown;
    }

    public ExchangeHands getExchangeHands() {
        return exchangeHands;
    }

    public void setExchangeHands(ExchangeHands exchangeHands) {
        this.exchangeHands = exchangeHands;
    }

    public Card getShowingCard() {
        return showingCard!=null?showingCard:null;
    }

    public void setShowingCard(Card showingCard) {
        this.showingCard = showingCard;
    }
}
