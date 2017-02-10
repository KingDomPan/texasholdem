package com.alibaba.game.texasholdem;

/**
 * Class {@code Card} 一张扑克牌.
 */
public class Card {

    private CardSuitEnum suit;
    private CardRankEnum rank;

    public Card(CardSuitEnum suit, CardRankEnum rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuitEnum getSuit() {
        return suit;
    }

    public void setSuit(CardSuitEnum suit) {
        this.suit = suit;
    }

    public CardRankEnum getRank() {
        return rank;
    }

    public void setRank(CardRankEnum rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (this.suit.getName() != card.suit.getName()) return false;
        return this.rank.getNumber() == card.rank.getNumber();

    }

    @Override
    public int hashCode() {
        return this.suit.getPriority() + this.rank.getNumber();
    }

    @Override
    public String toString() {
        return "Card: Suit is " + this.suit.getName() + ", Rank is " + this.rank.getNumber();
    }
}
