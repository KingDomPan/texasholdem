package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Map;

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

    @Test
    public void testGetCardsRankCountMap() {
        Player player = new Player();

        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_JACK);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_QUEUE);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_KING);
        Card card5 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_KING);

        player.addCard(card);
        player.addCard(card2);
        player.addCard(card3);
        player.addCard(card4);
        player.addCard(card5);

        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        assertEquals(new Integer(2), rankCount.get(new Integer(CardRankEnum.CARD_KING.getNumber())));
        assertEquals(new Integer(1), rankCount.get(new Integer(CardRankEnum.CARD_ACE.getNumber())));
        assertEquals(new Integer(1), rankCount.get(new Integer(CardRankEnum.CARD_QUEUE.getNumber())));
        assertEquals(new Integer(1), rankCount.get(new Integer(CardRankEnum.CARD_JACK.getNumber())));
    }

}
