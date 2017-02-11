package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Player;

import java.util.Map;

/**
 * Class {@code OnePairComparingImpl}
 * 一对的大小比较(先比对子, 再比三个单张)
 */
public class OnePairComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        Map<Integer, Integer> p1CardMap = o1.getCardsRankCountMap();
        Map<Integer, Integer> p2CardMap = o2.getCardsRankCountMap();

        return this.pairComparing(p1CardMap, p2CardMap, 2, 2);
    }

}
