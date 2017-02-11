package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.*;
import junit.framework.TestCase;
import org.junit.Test;

public class RoyalFlushRankingImplTest extends TestCase {


    @Test
    public void testIsRoyalFlushRanking() {

        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card3 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_QUEUE);
        Card card4 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_JACK);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new RoyalFlushRankingImpl();

        RankingResult result = ranking.resolve(p);
        assertTrue(result != null);

        assertEquals(result.getRankingEnum(), RankingEnum.ROYAL_FLUSH);

        Player p2 = new Player();
        p2.addCard(card1);
        p2.addCard(card2);
        p2.addCard(card3);
        p2.addCard(card4);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new RoyalFlushRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        assertTrue(result2 == null);

    }

}
