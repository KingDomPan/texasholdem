package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

public class PokerTest extends TestCase {

    @Test
    public void testGetSize() {
        Poker poker = new Poker();
        assertEquals(52, poker.getSize());
    }

    @Test
    public void testDispatch() {
        Poker poker = new Poker();

        poker.dispatch();
        assertEquals(51, poker.getSize());

        poker.dispatch();
        assertEquals(50, poker.getSize());
    }
}
