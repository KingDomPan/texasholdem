package com.alibaba.game.texasholdem;

/**
 * Enum {@code CardSuitEnum} 扑克牌的花色.
 */
public enum CardSuitEnum {
    A("红桃", 1000),
    B("方块", 1),
    C("黑桃", 10000),
    D("梅花", 100);

    private String name;
    private int priority;
    private Object q;

    CardSuitEnum(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
