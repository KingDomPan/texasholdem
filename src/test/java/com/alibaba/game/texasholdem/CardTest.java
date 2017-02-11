package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTest extends TestCase {

    @Test
    public void testEquals() {

        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card3 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);

        assertEquals(card, card);
        assertEquals(card, card2);
        assertFalse(card == card3);
    }

    @Test
    public void testHashcode() {

        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card3 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);

        assertEquals(card.hashCode(), card.hashCode());
        assertEquals(card.hashCode(), card2.hashCode());
        assertFalse(card.hashCode() == card3.hashCode());
    }

    @Test
    public void testToString() {

        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_JACK);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_QUEUE);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_KING);

        assertEquals(card.toString(), "A14");
        assertEquals(card2.toString(), "C11");
        assertEquals(card3.toString(), "B12");
        assertEquals(card4.toString(), "D13");
    }

    @Test
    public void testCompareTo() {
        List<Card> cards = new ArrayList<Card>();
        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_QUEUE);

        cards.add(card);
        cards.add(card2);
        cards.add(card3);

        Collections.sort(cards);

        assertEquals(card, cards.get(0));
        assertEquals(card2, cards.get(1));
        assertEquals(card3, cards.get(2));
    }

}
