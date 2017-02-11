package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.CardRankEnum;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RuleRankingEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code FlushRankingImpl}
 * 解析玩家手中的牌是不是同花(花色连续一样)
 */
public class FlushRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        if (this.isSameSuit(cards)) { // 如果是同色
            result = new RankingResult();
            result.setRankingEnum(RuleRankingEnum.FLUSH);
        }

        return result;
    }

}
