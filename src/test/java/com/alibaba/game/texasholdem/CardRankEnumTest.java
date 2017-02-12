package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

public class CardRankEnumTest extends TestCase {

    @Test
    public void testGetNumber() {

        CardRankEnum cardRank1 = CardRankEnum.CARD_ACE;
        CardRankEnum cardRank2 = CardRankEnum.CARD_TWO;
        CardRankEnum cardRank3 = CardRankEnum.CARD_TEN;

        assertEquals(14, cardRank1.getNumber().intValue());
        assertEquals(2, cardRank2.getNumber().intValue());
        assertEquals(10, cardRank3.getNumber().intValue());
    }

}
