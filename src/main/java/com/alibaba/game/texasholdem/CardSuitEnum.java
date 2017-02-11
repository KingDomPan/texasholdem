package com.alibaba.game.texasholdem;

/**
 * Enum {@code CardSuitEnum} 扑克牌的花色.
 */
public enum CardSuitEnum {
    HEARTS("A"),
    DIAMONDS("B"),
    SPADES("C"),
    CLUBS("D");

    private String name;

    CardSuitEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
