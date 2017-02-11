package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.RankingEnum;

import java.util.HashMap;
import java.util.Map;

public class ComparingFacade {

    private final static Map<RankingEnum, IComparing> maps = new HashMap<RankingEnum, IComparing>();

    static {
        maps.put(RankingEnum.ROYAL_FLUSH, new RoyalFlushComparingImpl());
        maps.put(RankingEnum.STRAIGHT_FLUSH, new StraightFlushComparingImpl());
    }

    public static IComparing getComparing(RankingEnum rankingEnum) {
        return maps.get(rankingEnum);
    }

}
