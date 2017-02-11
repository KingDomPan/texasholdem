package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Player;

import java.util.Map;

/**
 * Class {@code TwoPairsComparingImpl}
 * 两对的大小比较(先比较第一对, 再比较第二对, 再比较单牌)
 */
public class TwoPairsComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        Map<Integer, Integer> p1CardMap = o1.getCardsRankCountMap();
        Map<Integer, Integer> p2CardMap = o2.getCardsRankCountMap();

        return this.pairComparing(p1CardMap, p2CardMap, 2, 3);
    }

}
