package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

/**
 * Class {@code DefaultRankingImpl}
 * 默认实现, 返回HighCard类型
 */
public class DefaultRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = new RankingResult();
        result.setRankingEnum(RankingEnum.HIGH_CARD);

        return result;
    }

}
