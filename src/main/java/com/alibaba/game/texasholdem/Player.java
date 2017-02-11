package com.alibaba.game.texasholdem;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code Player} 一个玩家, 持有5张牌, 并伴随牌型的属性.
 */
public class Player {

    private List<Card> cards; // 玩家手上的五张牌

    public Player() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * 获得手上的牌的张数
     * @return
     */
    public int getCardSize() {
        return this.cards.size();
    }

    /**
     * 增加手牌
     * @param card
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }
}
