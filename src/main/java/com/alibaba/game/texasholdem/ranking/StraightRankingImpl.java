package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.List;

/**
 * Class {@code StraightRankingImpl}
 * 解析玩家手中的牌是不是顺子
 */
public class StraightRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        if (!this.isSameSuit(cards)) { // 如果是同色
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
                result.setRankingEnum(RankingEnum.STRAIGHT);
            }

        }

        return result;
    }

}
