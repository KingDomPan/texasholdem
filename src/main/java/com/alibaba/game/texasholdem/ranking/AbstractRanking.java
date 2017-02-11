package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.CardSuitEnum;
import com.alibaba.game.texasholdem.Player;

import java.util.List;

/**
 * Class {@code AbstractRanking} 抽象牌型解析接口, 抽象解析流程
 */
public abstract class AbstractRanking implements IRanking {

    public RankingResult resolve(Player player) {
        this.preResolve(player);
        RankingResult result = this.doResolve(player);
        this.postResolve(player, result);
        return result;
    }

    private void preResolve(Player player) {

    }

    private void postResolve(Player player, RankingResult result) {
        if (result != null) {
            result.setHighCard((player.getCards().get(0)));
        }
        player.setRankingResult(result);
    }

    protected abstract RankingResult doResolve(Player player);

    protected boolean isSameSuit(List<Card> cards) {
        if (cards == null || cards.size() == 0) {
            return false;
        }
        if (cards.size() == 1) {
            return true;
        }
        if (cards.size() > 1) {
            Card card = cards.get(0);
            CardSuitEnum suitEnum = card.getSuit();
            for (int i = 1; i < cards.size(); i++) {
                if (suitEnum != cards.get(i).getSuit()) {
                    return false;
                }
            }
        }
        return true;
    }
}
