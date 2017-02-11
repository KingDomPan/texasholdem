package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

public class PlayerTest extends TestCase {

    @Test
    public void testAddCard() {
        Poker poker = new Poker();
        Player player = new Player();
        for (int i = 0; i < Constants.HAND_CARD_NUMERS; i++) {
            player.addCard(poker.dispatch());
        }
        assertEquals(5, player.getCardSize());
    }

}
