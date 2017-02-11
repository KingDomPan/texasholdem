package com.alibaba.game.texasholdem;

import junit.framework.TestCase;
import org.junit.Test;

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

        assertEquals(card.toString(), "Card: Suit is A, Rank is 14");
        assertEquals(card2.toString(), "Card: Suit is C, Rank is 11");
        assertEquals(card3.toString(), "Card: Suit is B, Rank is 12");
        assertEquals(card4.toString(), "Card: Suit is D, Rank is 13");
    }

}
