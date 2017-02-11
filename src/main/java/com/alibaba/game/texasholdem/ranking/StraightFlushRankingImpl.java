package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.List;

/**
 * Class {@code StraightFlushRankingImpl}
 * 解析玩家手中的牌是不是同花顺(即是 最大牌是K 且同色)
 */
public class StraightFlushRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        if (this.isSameSuit(cards)) { // 如果是同色
            boolean isStraight = true;
            Card previousCard = null;
            for (Card card : cards) {
                if (previousCard != null) {
                    if (card.getRank().getNumber() - previousCard.getRank().getNumber() != -1) {
                        isStraight = false;
                        break;
                    }
                }
                previousCard = card;
            }
            if (isStraight == true) {
                result = new RankingResult();
                result.setRankingEnum(RankingEnum.STRAIGHT_FLUSH);
            }

        }

        return result;
    }

}
