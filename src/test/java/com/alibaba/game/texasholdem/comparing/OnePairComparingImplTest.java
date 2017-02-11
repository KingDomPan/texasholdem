package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.*;
import com.alibaba.game.texasholdem.ranking.IRanking;
import com.alibaba.game.texasholdem.ranking.OnePairRankingImpl;
import com.alibaba.game.texasholdem.ranking.RankingResult;
import junit.framework.TestCase;
import org.junit.Test;

public class OnePairComparingImplTest extends TestCase {

    @Test
    public void testComparingOneSamePair() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FIVE);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new OnePairRankingImpl();
        RankingResult result = ranking.resolve(p);

        assertTrue(result != null);
        assertEquals(result.getRankingEnum(), RankingEnum.ONE_PAIR);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_EIGHT);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_THREE);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FIVE);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new OnePairRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        assertTrue(result2 != null);
        assertEquals(result2.getRankingEnum(), RankingEnum.ONE_PAIR);

        assertEquals(-1, p.compareTo(p2));
    }

    @Test
    public void testComparingNotSamePair() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TEN);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FIVE);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new OnePairRankingImpl();
        RankingResult result = ranking.resolve(p);

        assertTrue(result != null);
        assertEquals(result.getRankingEnum(), RankingEnum.ONE_PAIR);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SIX);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new OnePairRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        assertTrue(result2 != null);
        assertEquals(result2.getRankingEnum(), RankingEnum.ONE_PAIR);

        assertEquals(-1, p.compareTo(p2));
    }
}
