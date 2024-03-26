package Showdown;

public class ExchangeHands {
    private final Player exchanger;
    private final Player exchangee;

    private int COUNT =3;

    public ExchangeHands(Player exchanger, Player exchangee) {
        this.exchanger = exchanger;
        this.exchangee = exchangee;
        exchangeHands();
    }

    public void exchangeHands(){
        Hand hand = this.exchanger.hand;
        this.exchanger.setHand(this.exchangee.hand);
        this.exchangee.setHand(hand);
        System.out.println(this.exchanger.getName()+" 與 "+this.exchangee.getName()+" 交換手牌");
    }
    public void roundCountDown(){
        COUNT--;
        if(COUNT==0){
            exchangeHands();
        }
    }

    public int getCOUNT() {
        return COUNT;
    }
}
