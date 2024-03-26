package Showdown;

import java.util.List;

import static java.util.Collections.max;
import static java.util.Comparator.comparing;

public class Showdown {
    private final int ROUNDS =13;
    private final List<Player> players;

    private final Deck deck =new Deck();
    public Showdown(List<Player> players) {
        this.players = players;
        players.forEach(p -> p.setShowdown(this));
    }

    public void start(){
        System.out.println("【遊戲開始】");
        nameThemselves();
        deck.shuffle();
        System.out.println("卡片數量："+deck.showDeck());
        drawCard();
        playRound();
    }
    public void playRound(){
        for(int i=0;i<this.ROUNDS;i++){
            System.out.println("=======第"+(i+1)+"回合=======");
            for (Player player:players) {
                player.takeTurn();
            }
            showdown();
            if(i+1==this.ROUNDS){
                gameOver();
            }
        }
    }
    public void drawCard(){
        int deckSize = deck.showDeck();
        for(int i=0;i<deckSize;i++){
            Card card = deck.drowCard();
            players.get( i % players.size()).addHandCard(card);
        }
    }
    public void nameThemselves(){
        int i =1;
        for (Player player:players) {
            player.nameHimself(i);
            i++;
        }
    }
    public void showdown(){
        Player biggestPlayer = max(players,comparing(Player::getShowingCard));
        System.out.println("【得分】"+biggestPlayer.getName());
        biggestPlayer.gainPoint();
    }
    public void gameOver(){
        Player winner = max(players,comparing(Player::getPoint));
        System.out.println("【獲勝】"+winner.getName());
    }

    public List<Player> getPlayers() {
        return players;
    }
}
