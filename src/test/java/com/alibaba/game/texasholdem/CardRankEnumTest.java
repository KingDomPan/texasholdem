package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

public class CardRankEnumTest extends TestCase {

    @Test
    public void testGetNumber() {

        CardRankEnum cardRank1 = CardRankEnum.CARD_ACE;
        CardRankEnum cardRank2 = CardRankEnum.CARD_TWO;
        CardRankEnum cardRank3 = CardRankEnum.CARD_TEN;

        assertEquals(cardRank1.getNumber(), 14);
        assertEquals(cardRank2.getNumber(), 2);
        assertEquals(cardRank3.getNumber(), 10);
    }

}
