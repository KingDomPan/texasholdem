package com.alibaba.game.texasholdem;

/**
 * Class {@code Card} 一张扑克牌.
 */
public class Card implements Comparable<Card> {

    private CardSuitEnum suit;
    private CardRankEnum rank;

    public Card(CardSuitEnum suit, CardRankEnum rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuitEnum getSuit() {
        return suit;
    }

    public int getRankNumber() {
        return this.rank.getNumber();
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
        return this.suit.ordinal() + this.rank.getNumber();
    }

    @Override
    public String toString() {
        return this.suit.getName() + this.rank.getNumber();
    }

    /**
     * 实现Comparable接口, 获取最大的单牌, 直接使用牌的数字大小比较即可
     * 使用降序排序, 因为第一个Card极为单牌最大值
     *
     * @param o
     * @return
     */
    public int compareTo(Card o) {
        int selfNumber = this.rank.getNumber();
        int otherNumber = o.rank.getNumber();

        if (selfNumber < otherNumber) {
            return 1;
        }
        if (selfNumber > otherNumber) {
            return -1;
        }
        return 0;
    }
}
