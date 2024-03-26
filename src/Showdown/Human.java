package Showdown;

import java.util.Scanner;

public class Human extends Player{
    private final static Scanner in = new Scanner(System.in);

    @Override
    public void nameHimself(int order){
        System.out.println("輸入玩家名稱:");
        setName(in.next());
    }
    @Override
    public void showCard(){
        if (hand.getCardList().isEmpty()){
            System.out.println(this.getName()+" 沒牌出了！！");
            setShowingCard(new Card(Card.Suit.CLUB, Card.Rank.R0));
        }
        else{
            System.out.println("【選擇出牌】");
            StringBuilder numbers = new StringBuilder();
            StringBuilder cards = new StringBuilder();

            for (int i = 0; i < getHand().size(); i++) {
                String cardVal = getHand().get(i).toString();
                numbers.append(String.format("%"+(-cardVal.length())+"s", i)).append(" ");
                cards.append(cardVal).append(" ");
            }
            System.out.println(numbers.toString().stripTrailing());
            System.out.println(cards.toString().stripTrailing());
            hand.showCard(in.nextInt(),this);
        }
    }

    @Override
    protected boolean needChange() {
        System.out.println("【交換手牌】Y/N");
        String change = in.next();
        return change.equals("Y");
    }
    public void exhangingHands(){
        StringBuilder index = new StringBuilder();
        StringBuilder name = new StringBuilder();
        for(int i=0;i<showdown.getPlayers().size();i++){
            Player player = showdown.getPlayers().get(i);
            if(player==this){ continue;}
            index.append(String.format("%"+(-player.getName().length())+"s", i)).append(" ");
            name.append(player.getName()).append(" ");
        }
        System.out.println(index);
        System.out.println(name);
        setExchangeHands(new ExchangeHands(this,showdown.getPlayers().get(in.nextInt())));
    }
}
