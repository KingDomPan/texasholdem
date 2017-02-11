package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

public class DealerTest extends TestCase {

    @Test
    public void testDealer() {
        Player player1 = new Player();
        Player player2 = new Player();

        Dealer dealer = new Dealer(player1, player2);

        assertEquals(2, dealer.getPlayerSize());

        Player player3 = new Player();
        dealer.join(player3);
        assertEquals(3, dealer.getPlayerSize());

        dealer.start();
        assertEquals(5, player1.getCardSize());
        assertEquals(5, player2.getCardSize());
        assertEquals(5, player3.getCardSize());
    }

}
