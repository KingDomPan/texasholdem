package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.RuleRankingEnum;

/**
 * Class {@code RankingResult} 牌型解析接口的返回值
 */
public class RankingResult {

    private Card highCard; // 5张牌中最大的值
    private RuleRankingEnum rankingEnum; // 牌型

    public Card getHighCard() {
        return highCard;
    }

    public void setHighCard(Card highCard) {
        this.highCard = highCard;
    }

    public RuleRankingEnum getRankingEnum() {
        return rankingEnum;
    }

    public void setRankingEnum(RuleRankingEnum rankingEnum) {
        this.rankingEnum = rankingEnum;
    }
}
