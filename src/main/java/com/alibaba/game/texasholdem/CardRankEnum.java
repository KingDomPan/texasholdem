package com.alibaba.game.texasholdem;

/**
 * Enum {@code CardRankEnum} 扑克牌的数字.
 */
public enum CardRankEnum {
    CARD_TWO(2),
    CARD_THREE(3),
    CARD_FOUR(4),
    CARD_FIVE(5),
    CARD_SIX(6),
    CARD_SEVEN(7),
    CARD_EIGHT(8),
    CARD_NINE(9),
    CARD_TEN(10),
    CARD_JACK(11),
    CARD_QUEUE(12),
    CARD_KING(13),
    CARD_ACE(14);

    private int number;

    CardRankEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
