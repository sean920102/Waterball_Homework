package Showdown;

import static java.lang.String.format;

public class Card implements Comparable<Card>{
    private final Rank rank;
    private final Suit suit;

    public Card(Suit suit,Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public enum Rank{
        R0("0"),
        R2("2"),R3("3"),R4("4"),R5("5"),
        R6("6"),R7("7"),R8("8"),R9("9"),R10("10")
        ,RJ("J"),RQ("Q"),RK("K"),RA("A");
        private final String res;
        Rank(String res) {
            this.res = res;
        }

        public String toString() {
            return res;
        }
    }
    public enum Suit{
        CLUB('♣'),
        DIAMOND('♦'),
        HEART('♥'),
        SPADE('♠');
        private final char res;
        Suit(char res) {
            this.res = res;
        }
        public String toString() {
            return String.valueOf(res);
        }
    }
    @Override
    public int compareTo(Card card) {
        if (card==null){
            return -1;
        }
        if (this.getRank() == card.getRank()) {
            return this.getSuit().compareTo(card.getSuit());
        }
        return this.getRank().compareTo(card.getRank());
    }
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString(){
        return format("%s%s",suit,rank);
    }
}
