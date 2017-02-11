package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.*;
import junit.framework.TestCase;
import org.junit.Test;

public class OnePairRankingImplTest extends TestCase {


    @Test
    public void testIsOnePairRanking() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_JACK);
        Card card9 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card11);
        p.addCard(card12);
        p.addCard(card9);

        IRanking ranking = new OnePairRankingImpl();

        RankingResult result = ranking.resolve(p);
        assertTrue(result != null);

        assertEquals(result.getRankingEnum(), RankingEnum.ONE_PAIR);

        Player p2 = new Player();
        p2.addCard(card13);
        p2.addCard(card11);
        p2.addCard(card12);
        p2.addCard(card9);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new OnePairRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        assertTrue(result2 == null);

    }

}
