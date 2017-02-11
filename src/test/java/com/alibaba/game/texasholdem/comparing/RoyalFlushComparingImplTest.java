package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.*;
import com.alibaba.game.texasholdem.ranking.IRanking;
import com.alibaba.game.texasholdem.ranking.RankingResult;
import com.alibaba.game.texasholdem.ranking.RoyalFlushRankingImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class RoyalFlushComparingImplTest extends TestCase {

    @Test
    public void testComparing() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card3 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_QUEUE);
        Card card4 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_JACK);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);

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


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);
        Card card22 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card23 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);
        Card card24 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_JACK);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TEN);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new RoyalFlushRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        assertTrue(result2 != null);
        assertEquals(result2.getRankingEnum(), RankingEnum.ROYAL_FLUSH);

        assertEquals(0, p.compareTo(p2));
    }
}
