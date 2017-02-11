package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;

/**
 * Class {@code StraightFlushComparingImpl}
 * 同花顺的大小比较(比较最大牌即可)
 */
public class StraightFlushComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        Card o1HighCard = o1.getRankingResult().getHighCard();
        Card o2HighCard = o2.getRankingResult().getHighCard();

        if (o1HighCard.getRank().getNumber() > o2HighCard.getRank().getNumber()) {
            return -1;
        }
        if (o1HighCard.getRank().getNumber() < o2HighCard.getRank().getNumber()) {
            return 1;
        }
        return 0;
    }

}
