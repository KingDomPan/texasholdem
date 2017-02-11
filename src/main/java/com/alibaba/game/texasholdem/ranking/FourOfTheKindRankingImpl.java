package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RuleRankingEnum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Class {@code FourOfTheKindRankingImpl}
 * 解析玩家手中的牌是不是四条(四张连续相同的牌)
 */
public class FourOfTheKindRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        Map<Integer, Integer> rankCount = new HashMap<Integer, Integer>();
        for (Card card : cards) {
            Integer number = new Integer(card.getRank().getNumber());
            if (!rankCount.containsKey(number)) {
                rankCount.put(number, 1);
            } else {
                rankCount.put(number, rankCount.get(number) + 1);
            }
        }

        boolean hasFour = false;

        Iterator<Map.Entry<Integer, Integer>> it = rankCount.entrySet().iterator();
        while(it.hasNext()) {
            if (it.next().getValue() == 4) {
                hasFour = true;
                break;
            }
        }

        if (hasFour) {
            result = new RankingResult();
            result.setRankingEnum(RuleRankingEnum.FOUR_OF_A_KIND);
        }

        return result;
    }

}
