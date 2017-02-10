package com.alibaba.game.texasholdem;

/**
 * Enum {@code CardRankEnum} 扑克牌的数字.
 */
public enum CardRankEnum {
    CardTwo(2),
    CardThree(3),
    CardFour(4),
    CardFive(5),
    CardSix(6),
    CardSeven(7),
    CardEight(8),
    CardNight(9),
    CardTen(10),
    CardJACK(11),
    CardQueue(12),
    CardKing(13),
    CardAce(14);

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
